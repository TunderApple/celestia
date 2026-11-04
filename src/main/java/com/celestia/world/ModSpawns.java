package com.celestia.world;

import com.celestia.block.ModBlocks;
import com.celestia.entity.ModEntities;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.biome.BiomeKeys;

/**
 * Unicorn & Pegasus appear only in vanilla End Highlands.
 * Every natural spawn attempt there succeeds with a 10% chance (each mob separately),
 * and only on end stone.
 */
public final class ModSpawns {
    public static final float SPAWN_CHANCE = 0.10f;

    public static void init() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                SpawnGroup.CREATURE, ModEntities.UNICORN, 10, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.END_HIGHLANDS),
                SpawnGroup.CREATURE, ModEntities.PEGASUS, 10, 1, 3);

        SpawnRestriction.register(ModEntities.UNICORN, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModSpawns::canSpawn);
        SpawnRestriction.register(ModEntities.PEGASUS, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModSpawns::canSpawn);
        // Arnyang: listed in the Star Farm biome's spawners (data/celestia/worldgen/biome/star_farm.json)
        SpawnRestriction.register(ModEntities.ARNYANG, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ModSpawns::canArnyangSpawn);
    }

    private static <T extends MobEntity> boolean canArnyangSpawn(EntityType<T> type, ServerWorldAccess world,
                                                                SpawnReason reason, BlockPos pos, Random random) {
        var below = world.getBlockState(pos.down());
        return reason != SpawnReason.NATURAL || below.isOf(ModBlocks.STAR_MOSS) || below.isOf(ModBlocks.NIGHT_SOIL)
                || below.isOf(ModBlocks.TWILIGHT_STONE);
    }

    private static <T extends MobEntity> boolean canSpawn(EntityType<T> type, ServerWorldAccess world,
                                                          SpawnReason reason, BlockPos pos, Random random) {
        if (reason == SpawnReason.SPAWN_EGG || reason == SpawnReason.COMMAND || reason == SpawnReason.BREEDING) {
            return true;
        }
        return world.getBlockState(pos.down()).isOf(Blocks.END_STONE) && random.nextFloat() < SPAWN_CHANCE;
    }

    private ModSpawns() {
    }
}
