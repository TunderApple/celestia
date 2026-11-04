package com.celestia.entity;

import com.celestia.item.ModItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

/**
 * Arnyang: a chubby horned cat of the Star Farm caves. Loves Star Fruit
 * (tempts, breeds) and stands up to cheer when you hold one near it.
 */
public class ArnyangEntity extends AnimalEntity {
    private float cheer;            // client-side 0..1

    public ArnyangEntity(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.1, stack -> stack.isOf(ModItems.STAR_FRUIT), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.STAR_FRUIT);
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity mate) {
        return ModEntities.ARNYANG.create(world);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            PlayerEntity p = this.getWorld().getClosestPlayer(this, 6.0);
            boolean fan = p != null && (p.getMainHandStack().isOf(ModItems.STAR_FRUIT) || p.getOffHandStack().isOf(ModItems.STAR_FRUIT));
            this.cheer += ((fan ? 1.0f : 0.0f) - this.cheer) * 0.2f;
        }
    }

    public float getCheerProgress() {
        return this.cheer;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CAT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CAT_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CAT_DEATH;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return !this.hasCustomName() && !this.isBaby() && distanceSquared > 128 * 128;
    }
}
