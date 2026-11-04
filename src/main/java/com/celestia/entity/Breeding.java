package com.celestia.entity;

import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;

/** Unicorn x Pegasus -> 20% Alicorn, otherwise a foal of either parent's kind. Same kind -> same kind. */
public final class Breeding {
    public static final float ALICORN_CHANCE = 0.20f;

    public static PassiveEntity child(ServerWorld world, CelestialHorseEntity self, PassiveEntity mate) {
        boolean mixed = (self instanceof UnicornEntity && mate instanceof PegasusEntity)
                || (self instanceof PegasusEntity && mate instanceof UnicornEntity);
        if (mixed) {
            if (world.random.nextFloat() < ALICORN_CHANCE) {
                return ModEntities.ALICORN.create(world);
            }
            return world.random.nextBoolean() ? ModEntities.UNICORN.create(world) : ModEntities.PEGASUS.create(world);
        }
        return self instanceof UnicornEntity ? ModEntities.UNICORN.create(world) : ModEntities.PEGASUS.create(world);
    }

    private Breeding() {
    }
}
