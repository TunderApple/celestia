package com.celestia.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

/** Pegasus: wings (jump in mid-air to fly). */
public class PegasusEntity extends CelestialHorseEntity {
    public PegasusEntity(EntityType<? extends AbstractHorseEntity> type, World world) {
        super(type, world);
    }

    @Override public boolean hasHorn() { return false; }
    @Override public boolean hasWings() { return true; }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity mate) {
        return Breeding.child(world, this, mate);
    }
}
