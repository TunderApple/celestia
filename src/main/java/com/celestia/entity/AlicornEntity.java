package com.celestia.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

/**
 * Alicorn: Unicorn x Pegasus hybrid. Never spawns naturally (no biome spawn is registered).
 * Has both the horn (G = rainbow dash, also in mid-air) and the wings (mid-air jump flight).
 * Cannot breed.
 */
public class AlicornEntity extends CelestialHorseEntity {
    public AlicornEntity(EntityType<? extends AbstractHorseEntity> type, World world) {
        super(type, world);
    }

    @Override public boolean hasHorn() { return true; }
    @Override public boolean hasWings() { return true; }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity mate) {
        return null;    // alicorns are sterile
    }
}
