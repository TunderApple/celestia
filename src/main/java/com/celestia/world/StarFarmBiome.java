package com.celestia.world;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;

public final class StarFarmBiome {
    public static final RegistryKey<Biome> KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of("celestia", "star_farm"));

    public static boolean isStarFarm(WorldView world, BlockPos pos) {
        return world.getBiome(pos).matchesKey(KEY);
    }

    private StarFarmBiome() {
    }
}
