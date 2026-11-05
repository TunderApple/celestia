package com.celestia.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;

public final class ModWorldGen {
    public static final Feature<DefaultFeatureConfig> STAR_FARM_DECOR = Registry.register(Registries.FEATURE,
            Identifier.of("celestia", "star_farm_decor"), new StarFarmDecorFeature(DefaultFeatureConfig.CODEC));

    public static final Feature<DefaultFeatureConfig> STAR_SPIRE = Registry.register(Registries.FEATURE,
            Identifier.of("celestia", "star_spire"), new StarSpireFeature(DefaultFeatureConfig.CODEC));

    public static final RegistryKey<PlacedFeature> STAR_SHARD_ORE_END =
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("celestia", "star_shard_ore_end"));

    public static void init() {
        // Star Shard Ore: outer End islands only (not the dragon's main island)
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS,
                        BiomeKeys.END_BARRENS, BiomeKeys.SMALL_END_ISLANDS),
                GenerationStep.Feature.UNDERGROUND_ORES, STAR_SHARD_ORE_END);
    }

    private ModWorldGen() {
    }
}
