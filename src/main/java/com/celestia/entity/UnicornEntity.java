package com.celestia.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

/** Unicorn: horn (G = rainbow dash). */
public class UnicornEntity extends CelestialHorseEntity {
    public UnicornEntity(EntityType<? extends AbstractHorseEntity> type, World world) {
        super(type, world);
    }

    @Override public boolean hasHorn() { return true; }
    @Override public boolean hasWings() { return false; }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity mate) {
        return Breeding.child(world, this, mate);
    }
}
