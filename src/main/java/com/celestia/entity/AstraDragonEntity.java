package com.celestia.entity;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector3f;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Daemaryong (대마룡). Summoned at the Star Altar with Everys.
 * Flies (passes through blocks like the Ender Dragon) and circles its altar, then attacks:
 *  - BREATH: hovers, opens its jaw and spits purple dragon-breath fireballs
 *  - DIVE:   charges straight at a player, hitting everything it touches
 *  - STAR RAIN (below 50% health): marks spots around players, stars crash down on them
 */
public class AstraDragonEntity extends HostileEntity {
    public static final int CIRCLE = 0, BREATH = 1, DIVE = 2, STAR_RAIN = 3, ROAR = 4;
    private static final TrackedData<Integer> STATE = DataTracker.registerData(AstraDragonEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final Vector3f PURPLE = new Vector3f(0.62f, 0.36f, 1.0f);
    private static final Vector3f GOLD = new Vector3f(1.0f, 0.85f, 0.4f);

    private final ServerBossBar bossBar = (ServerBossBar) new ServerBossBar(this.getDisplayName(),
            BossBar.Color.PURPLE, BossBar.Style.NOTCHED_10).setDarkenSky(true).setThickenFog(true);
    private BlockPos home = BlockPos.ORIGIN;
    private int stateTicks;
    private int cooldown = 80;
    private float circleAngle;
    private boolean phaseTwo;
    private Vec3d diveTarget = Vec3d.ZERO;
    private final List<Vec3d> starMarks = new ArrayList<>();
    private float jaw, prevJaw;

    public AstraDragonEntity(EntityType<? extends HostileEntity> type, World world) {
        super(type, world);
        this.noClip = true;
        this.setNoGravity(true);
        this.experiencePoints = 500;
        this.setPersistent();
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 400.0)
                .add(EntityAttributes.GENERIC_ARMOR, 10.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 80.0)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(STATE, ROAR);
    }

    public void setHome(BlockPos pos) {
        this.home = pos;
    }

    private int state() {
        return this.dataTracker.get(STATE);
    }

    private void setState(int s) {
        this.dataTracker.set(STATE, s);
        this.stateTicks = 0;
    }

    public boolean isDiving() {
        return state() == DIVE;
    }

    public float getJawOpen() {
        return this.jaw;
    }

    // ------------------------------------------------------------------ boss bar
    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    // ------------------------------------------------------------------ main loop
    @Override
    public void tick() {
        super.tick();
        this.noClip = true;
        this.setNoGravity(true);
        if (this.getWorld().isClient) {
            this.prevJaw = this.jaw;
            float want = (state() == BREATH || state() == ROAR) ? 1.0f : 0.0f;
            this.jaw += (want - this.jaw) * 0.25f;
            if (this.random.nextInt(3) == 0) {          // stardust trailing from the wings
                double a = this.random.nextDouble() * Math.PI * 2;
                this.getWorld().addParticle(ParticleTypes.END_ROD, this.getX() + Math.cos(a) * 5, this.getY() + 1.5,
                        this.getZ() + Math.sin(a) * 5, 0, -0.03, 0);
            }
        }
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        ServerWorld world = (ServerWorld) this.getWorld();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        if (!this.phaseTwo && this.getHealth() < this.getMaxHealth() * 0.5f) {
            this.phaseTwo = true;
            this.bossBar.setColor(BossBar.Color.PINK);
            setState(ROAR);
        }
        if (this.age % 20 == 0) {
            PlayerEntity p = world.getClosestPlayer(home.getX(), home.getY(), home.getZ(), 80, true);
            this.setTarget(p != null && !p.isSpectator() && !p.isCreative() ? p : null);
        }
        LivingEntity target = this.getTarget();
        this.stateTicks++;
        switch (state()) {
            case ROAR -> tickRoar(world);
            case BREATH -> tickBreath(world, target);
            case DIVE -> tickDive(world, target);
            case STAR_RAIN -> tickStarRain(world);
            default -> tickCircle(world, target);
        }
        hitWhatITouch(world);
    }

    private void flyToward(Vec3d point, double speed) {
        Vec3d d = point.subtract(this.getPos());
        double len = d.length();
        Vec3d want = len < 0.5 ? Vec3d.ZERO : d.multiply(Math.min(speed, len) / len);
        this.setVelocity(this.getVelocity().lerp(want, 0.15));
        this.move(net.minecraft.entity.MovementType.SELF, this.getVelocity());
        Vec3d v = this.getVelocity();
        if (v.horizontalLengthSquared() > 0.001) {
            float yaw = (float) (MathHelper.atan2(v.z, v.x) * (180F / Math.PI)) - 90.0f;
            this.setYaw(MathHelper.stepUnwrappedAngleTowards(this.getYaw(), yaw, 6.0f));
            this.bodyYaw = this.getYaw();
        }
    }

    private void face(Vec3d p) {
        Vec3d d = p.subtract(this.getPos());
        float yaw = (float) (MathHelper.atan2(d.z, d.x) * (180F / Math.PI)) - 90.0f;
        this.setYaw(MathHelper.stepUnwrappedAngleTowards(this.getYaw(), yaw, 8.0f));
        this.bodyYaw = this.getYaw();
        this.headYaw = this.getYaw();
    }

    private void tickRoar(ServerWorld world) {
        flyToward(Vec3d.ofCenter(home).add(0, 10, 0), 0.3);
        if (this.stateTicks == 1) {
            world.playSound(null, this.getBlockPos(), SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.HOSTILE, 6.0f, 0.8f);
        }
        if (this.stateTicks % 4 == 0) {
            world.spawnParticles(new DustParticleEffect(PURPLE, 3.0f), this.getX(), this.getY() + 2, this.getZ(), 20, 3, 2, 3, 0);
        }
        if (this.stateTicks > 40) {
            setState(CIRCLE);
        }
    }

    private void tickCircle(ServerWorld world, LivingEntity target) {
        this.circleAngle += this.phaseTwo ? 0.035f : 0.025f;
        Vec3d c = Vec3d.ofCenter(home).add(Math.cos(circleAngle) * 16, 12 + Math.sin(this.age * 0.05) * 2, Math.sin(circleAngle) * 16);
        flyToward(c, this.phaseTwo ? 0.75 : 0.6);
        if (target != null && --this.cooldown <= 0) {
            int roll = this.random.nextInt(this.phaseTwo ? 3 : 2);
            if (roll == 0) {
                setState(BREATH);
            } else if (roll == 1) {
                this.diveTarget = target.getPos().add(0, 1, 0);
                setState(DIVE);
                world.playSound(null, this.getBlockPos(), SoundEvents.ENTITY_ENDER_DRAGON_FLAP, SoundCategory.HOSTILE, 5.0f, 0.7f);
            } else {
                setState(STAR_RAIN);
            }
            this.cooldown = (this.phaseTwo ? 50 : 80) + this.random.nextInt(40);
        }
    }

    private void tickBreath(ServerWorld world, LivingEntity target) {
        if (target == null) {
            setState(CIRCLE);
            return;
        }
        flyToward(this.getPos(), 0.1);                          // hover
        face(target.getPos());
        this.setVelocity(this.getVelocity().multiply(0.8));
        int shots = this.phaseTwo ? 3 : 1;
        if (this.stateTicks >= 20 && this.stateTicks < 20 + shots * 8 && (this.stateTicks - 20) % 8 == 0) {
            Vec3d mouth = this.getPos().add(Vec3d.fromPolar(0, this.getYaw()).multiply(6)).add(0, 2.5, 0);     // dragon mouth
            Vec3d dir = target.getEyePos().subtract(mouth).normalize();
            DragonFireballEntity ball = new DragonFireballEntity(world, this, dir);
            ball.refreshPositionAndAngles(mouth.x, mouth.y, mouth.z, 0, 0);
            world.spawnEntity(ball);
            world.playSound(null, this.getBlockPos(), SoundEvents.ENTITY_ENDER_DRAGON_SHOOT, SoundCategory.HOSTILE, 4.0f, 0.9f);
        }
        if (this.stateTicks > 20 + shots * 8 + 15) {
            setState(CIRCLE);
        }
    }

    private void tickDive(ServerWorld world, LivingEntity target) {
        flyToward(this.diveTarget, this.phaseTwo ? 1.6 : 1.3);
        world.spawnParticles(new DustParticleEffect(PURPLE, 2.0f), this.getX(), this.getY() + 1.5, this.getZ(), 6, 1.5, 1, 1.5, 0);
        if (this.getPos().distanceTo(this.diveTarget) < 2.5 || this.stateTicks > 50) {
            setState(CIRCLE);
        }
    }

    private void tickStarRain(ServerWorld world) {
        flyToward(Vec3d.ofCenter(home).add(0, 16, 0), 0.5);
        if (this.stateTicks == 1) {
            this.starMarks.clear();
            for (PlayerEntity p : world.getPlayers(p -> p.squaredDistanceTo(Vec3d.ofCenter(home)) < 64 * 64 && !p.isSpectator())) {
                for (int i = 0; i < 4; i++) {
                    this.starMarks.add(p.getPos().add(this.random.nextGaussian() * 4, 0, this.random.nextGaussian() * 4));
                }
                this.starMarks.add(p.getPos());
            }
            world.playSound(null, this.getBlockPos(), SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.HOSTILE, 4.0f, 1.6f);
        }
        if (this.stateTicks < 35) {                            // warning: glowing pillars of light
            for (Vec3d m : this.starMarks) {
                world.spawnParticles(ParticleTypes.END_ROD, m.x, m.y + 0.2 + (this.stateTicks % 10) * 0.6, m.z, 1, 0.3, 0, 0.3, 0);
                world.spawnParticles(new DustParticleEffect(GOLD, 1.5f), m.x, m.y + 0.1, m.z, 3, 0.9, 0, 0.9, 0);
            }
        } else if (this.stateTicks == 35) {                    // impact
            for (Vec3d m : this.starMarks) {
                world.spawnParticles(ParticleTypes.EXPLOSION, m.x, m.y + 0.5, m.z, 2, 0.5, 0.5, 0.5, 0);
                world.spawnParticles(ParticleTypes.FIREWORK, m.x, m.y + 0.5, m.z, 25, 0.3, 0.6, 0.3, 0.25);
                world.playSound(null, BlockPos.ofFloored(m), SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, SoundCategory.HOSTILE, 2.0f, 0.7f);
                for (LivingEntity e : world.getEntitiesByClass(LivingEntity.class, new Box(m, m).expand(2.2, 2.5, 2.2), e -> e != this)) {
                    e.damage(this.getDamageSources().indirectMagic(this, this), 10.0f);
                }
            }
        } else if (this.stateTicks > 50) {
            setState(CIRCLE);
        }
    }

    /** Contact damage: the dragon's body hurts anything it flies through. */
    private void hitWhatITouch(ServerWorld world) {
        if (this.age % 5 != 0) {
            return;
        }
        float dmg = isDiving() ? 14.0f : 6.0f;
        for (LivingEntity e : world.getEntitiesByClass(LivingEntity.class, this.getBoundingBox().expand(1.0), e -> e != this)) {
            if (e.damage(this.getDamageSources().mobAttack(this), dmg)) {
                Vec3d push = e.getPos().subtract(this.getPos()).normalize().multiply(isDiving() ? 2.0 : 1.0);
                e.addVelocity(push.x, 0.5, push.z);
            }
        }
    }

    // ------------------------------------------------------------------ misc
    @Override
    public boolean damage(DamageSource source, float amount) {
        if (state() == ROAR) {
            amount *= 0.25f;                                   // armoured while roaring
        }
        return super.damage(source, amount);
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (this.getWorld() instanceof ServerWorld world) {
            world.spawnParticles(ParticleTypes.FIREWORK, this.getX(), this.getY() + 2, this.getZ(), 200, 3, 3, 3, 0.4);
            world.spawnParticles(new DustParticleEffect(PURPLE, 4.0f), this.getX(), this.getY() + 2, this.getZ(), 120, 4, 3, 4, 0);
            world.playSound(null, this.getBlockPos(), SoundEvents.ENTITY_ENDER_DRAGON_DEATH, SoundCategory.HOSTILE, 5.0f, 1.2f);
        }
        this.bossBar.clearPlayers();
    }

    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }

    @Override
    public Box getVisibilityBoundingBox() {
        return this.getBoundingBox().expand(10.0, 4.0, 10.0);  // wings are much wider than the hitbox
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ENDER_DRAGON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_ENDER_DRAGON_HURT;
    }

    @Override
    protected float getSoundVolume() {
        return 4.0f;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.put("Home", NbtHelper.fromBlockPos(this.home));
        nbt.putBoolean("PhaseTwo", this.phaseTwo);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        NbtHelper.toBlockPos(nbt, "Home").ifPresent(p -> this.home = p);
        this.phaseTwo = nbt.getBoolean("PhaseTwo");
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }
    }
}
