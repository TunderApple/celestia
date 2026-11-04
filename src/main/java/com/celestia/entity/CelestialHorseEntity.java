package com.celestia.entity;

import org.joml.Vector3f;

import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Shared base for Unicorn / Pegasus / Alicorn.
 *
 * - Taming: ONLY golden carrots; each wild one secretly needs 5..64 of them.
 * - hasHorn():  G while riding = forward dash leaving a rainbow road (Unicorn, Alicorn).
 * - hasWings(): jump in mid-air to beat the wings and climb, glide otherwise,
 *               no fall damage (Pegasus, Alicorn).
 */
public abstract class CelestialHorseEntity extends AbstractHorseEntity {
    // ---- taming
    public static final int MIN_CARROTS = 5;
    public static final int MAX_CARROTS = 64;
    // ---- dash
    public static final int DASH_TICKS = 12;
    public static final int DASH_COOLDOWN = 60;
    public static final double DASH_SPEED = 0.95;
    // ---- flight
    public static final double FLAP_BASE = 0.32;
    public static final double FLAP_BONUS = 0.42;
    public static final double GLIDE_FALL_SPEED = -0.16;
    public static final double AIR_ACCEL = 0.045;
    public static final double AIR_MAX_SPEED = 0.85;

    private static final Vector3f[] RAINBOW = {
            rgb(0xff4d4d), rgb(0xff9a3c), rgb(0xffe14d), rgb(0x5ee36a),
            rgb(0x4db8ff), rgb(0x6a6aff), rgb(0xc06bff)
    };

    private int carrotsToTame;
    private int carrotsFed;
    private int dashTicks;
    private int dashCooldown;
    private float dashYaw;
    // client-side wing animation state
    private float wingSpread;
    private float flapIntensity;
    private float wingPhase;

    protected CelestialHorseEntity(EntityType<? extends AbstractHorseEntity> type, World world) {
        super(type, world);
        this.carrotsToTame = MIN_CARROTS + this.random.nextInt(MAX_CARROTS - MIN_CARROTS + 1);
    }

    public abstract boolean hasHorn();

    public abstract boolean hasWings();

    private static Vector3f rgb(int c) {
        return new Vector3f(((c >> 16) & 0xff) / 255f, ((c >> 8) & 0xff) / 255f, (c & 0xff) / 255f);
    }

    // =====================================================================  taming
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (!this.isTame() && !this.isBaby()) {
            if (stack.isOf(Items.GOLDEN_CARROT)) {
                if (!this.getWorld().isClient) {
                    stack.decrementUnlessCreative(1, player);
                    this.carrotsFed++;
                    this.playSound(SoundEvents.ENTITY_HORSE_EAT, 1.0f, 1.0f);
                    if (this.carrotsFed >= this.carrotsToTame) {
                        this.bondWithPlayer(player);
                        this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
                    } else {
                        this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
                    }
                }
                return ActionResult.success(this.getWorld().isClient);
            }
            if (!player.shouldCancelInteraction()) {           // untamed: refuses riders
                if (!this.getWorld().isClient) {
                    this.playAngrySound();
                }
                return ActionResult.success(this.getWorld().isClient);
            }
        }
        return super.interactMob(player, hand);
    }

    // =====================================================================  breeding
    /** Unicorn/Pegasus breed with each other freely; Alicorns cannot breed at all. */
    @Override
    public boolean canBreedWith(AnimalEntity other) {
        if (other == this || !(other instanceof CelestialHorseEntity mate)) {
            return false;
        }
        if (this instanceof AlicornEntity || mate instanceof AlicornEntity) {
            return false;
        }
        return this.canBreed() && mate.canBreed();
    }

    // =====================================================================  dash
    /** Called on the rider's client (moves the horse) and on the server (cooldown + particles). */
    public boolean startDash(float yaw) {
        if (!this.hasHorn() || this.dashCooldown > 0 || !this.isTame() || !this.isSaddled()) {
            return false;
        }
        this.dashTicks = DASH_TICKS;
        this.dashCooldown = DASH_COOLDOWN;
        this.dashYaw = yaw;
        if (!this.getWorld().isClient) {
            this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.ENTITY_HORSE_GALLOP, SoundCategory.NEUTRAL, 1.2f, 1.4f);
            this.getWorld().playSound(null, this.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.NEUTRAL, 1.5f, 1.2f);
        }
        return true;
    }

    public boolean isDashing() {
        return this.dashTicks > 0;
    }

    private void spawnRainbowRoad(ServerWorld server) {
        Vec3d dir = Vec3d.fromPolar(0.0f, this.dashYaw);
        Vec3d side = new Vec3d(-dir.z, 0, dir.x);
        Vec3d base = this.getPos().subtract(dir.multiply(1.1)).add(0, 0.12, 0);
        for (int i = 0; i < RAINBOW.length; i++) {
            Vec3d p = base.add(side.multiply((i - 3) * 0.2));
            server.spawnParticles(new DustParticleEffect(RAINBOW[i], 1.8f), p.x, p.y, p.z,
                    4, dir.x * 0.4, 0.02, dir.z * 0.4, 0.0);
        }
        server.spawnParticles(ParticleTypes.END_ROD, base.x, base.y + 0.6, base.z, 2, 0.4, 0.3, 0.4, 0.01);
    }

    // =====================================================================  flight
    private boolean airborne() {
        return !this.isOnGround() && !this.isTouchingWater() && !this.isInLava();
    }

    @Override
    protected void tickControlled(PlayerEntity controllingPlayer, Vec3d movementInput) {
        super.tickControlled(controllingPlayer, movementInput);   // vanilla: jump from the ground
        if (!this.isLogicalSideForUpdatingMovement()) {
            return;
        }
        Vec3d v = this.getVelocity();
        if (this.hasWings() && airborne()) {
            if (this.jumpStrength > 0.0f) {                        // jump released in the air = wing beat
                v = new Vec3d(v.x, Math.max(v.y, 0.0) + FLAP_BASE + FLAP_BONUS * this.jumpStrength, v.z);
                this.jumpStrength = 0.0f;
                this.flapIntensity = 1.0f;
                this.playSound(SoundEvents.ENTITY_ENDER_DRAGON_FLAP, 0.6f, 1.6f);
            }
            if (v.y < GLIDE_FALL_SPEED) {
                v = new Vec3d(v.x, GLIDE_FALL_SPEED, v.z);
            }
            if (movementInput.z > 0) {
                Vec3d f = Vec3d.fromPolar(0.0f, this.getYaw()).multiply(AIR_ACCEL);
                v = v.add(f.x, 0, f.z);
                double h = Math.sqrt(v.x * v.x + v.z * v.z);
                if (h > AIR_MAX_SPEED && this.dashTicks <= 0) {
                    v = new Vec3d(v.x / h * AIR_MAX_SPEED, v.y, v.z / h * AIR_MAX_SPEED);
                }
            }
        }
        if (this.dashTicks > 0) {                                  // dash works on the ground and in the air
            Vec3d dir = Vec3d.fromPolar(0.0f, this.dashYaw);
            v = new Vec3d(dir.x * DASH_SPEED, v.y, dir.z * DASH_SPEED);
        }
        this.setVelocity(v);
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        if (this.hasWings()) {
            return false;                                          // no fall damage for horse or rider
        }
        return super.handleFallDamage(fallDistance, damageMultiplier, damageSource);
    }

    // =====================================================================  tick
    @Override
    public void tick() {
        super.tick();
        if (this.dashCooldown > 0) {
            this.dashCooldown--;
        }
        if (this.dashTicks > 0) {
            this.dashTicks--;
            if (this.getWorld() instanceof ServerWorld server) {
                spawnRainbowRoad(server);
            }
        }
        if (this.getWorld().isClient && this.hasWings()) {
            float target = airborne() ? 1.0f : 0.0f;
            this.wingSpread += (target - this.wingSpread) * 0.25f;
            if (this.getY() - this.prevY > 0.04) {
                this.flapIntensity = Math.min(1.0f, this.flapIntensity + 0.35f);
            } else {
                this.flapIntensity *= 0.9f;
            }
            if (this.wingSpread > 0.05f) {
                this.wingPhase += 0.18f + 0.55f * this.flapIntensity;
            }
        }
    }

    public float getWingSpread() {
        return this.wingSpread;
    }

    public float getFlapIntensity() {
        return MathHelper.clamp(this.flapIntensity, 0.0f, 1.0f);
    }

    public float getWingPhase() {
        return this.wingPhase;
    }

    // =====================================================================  save / load
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("CelestiaCarrotsToTame", this.carrotsToTame);
        nbt.putInt("CelestiaCarrotsFed", this.carrotsFed);
        nbt.putInt("DashCooldown", this.dashCooldown);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("CelestiaCarrotsToTame")) {
            this.carrotsToTame = nbt.getInt("CelestiaCarrotsToTame");
        }
        this.carrotsFed = nbt.getInt("CelestiaCarrotsFed");
        this.dashCooldown = nbt.getInt("DashCooldown");
    }

    // =====================================================================  sounds (placeholders)
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_HORSE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_HORSE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HORSE_DEATH;
    }

    @Override
    protected SoundEvent getAngrySound() {
        return SoundEvents.ENTITY_HORSE_ANGRY;
    }
}
