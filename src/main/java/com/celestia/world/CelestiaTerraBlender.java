package com.celestia.world;

import java.util.function.Consumer;

import com.celestia.block.ModBlocks;
import com.mojang.datafixers.util.Pair;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

/**
 * Star Farm placement (TerraBlender): inside Celestia's overworld regions, the big
 * underground cave pockets that would be Dripstone Caves become Star Farm instead.
 * Surface rules turn its stone into twilight stone, floors into star moss over night soil.
 */
public class CelestiaTerraBlender implements TerraBlenderApi {
    /** Region weight: higher = Star Farm regions are more common (vanilla is 10). */
    public static final int REGION_WEIGHT = 3;

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new StarFarmRegion(Identifier.of("celestia", "overworld"), REGION_WEIGHT));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, "celestia",
                MaterialRules.condition(MaterialRules.biome(StarFarmBiome.KEY), MaterialRules.sequence(
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR,
                                MaterialRules.block(ModBlocks.STAR_MOSS.getDefaultState())),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH,
                                MaterialRules.block(ModBlocks.NIGHT_SOIL.getDefaultState())),
                        MaterialRules.block(ModBlocks.TWILIGHT_STONE.getDefaultState()))));
    }

    public static class StarFarmRegion extends Region {
        public StarFarmRegion(Identifier name, int weight) {
            super(name, RegionType.OVERWORLD, weight);
        }

        @Override
        public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
            this.addModifiedVanillaOverworldBiomes(mapper, builder ->
                    builder.replaceBiome(BiomeKeys.DRIPSTONE_CAVES, StarFarmBiome.KEY));
        }
    }
}
