package com.celestia.world;

import java.util.Optional;

import com.celestia.block.ModBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

/**
 * Star Spire: places data/celestia/structure/star_spire.nbt (43 x 54 x 43) centred on the
 * chunk, on a Star Farm cave floor, with a random rotation. The template carves its own
 * dome-shaped hall, so it always has room. The centre sits 8 blocks into the chunk and the
 * structure reaches 21 blocks out, which stays inside the neighbouring chunks a feature may edit.
 */
public class StarSpireFeature extends Feature<DefaultFeatureConfig> {
    private static final Identifier ID = Identifier.of("celestia", "star_spire");
    private static final int HALF = 21, BELOW = 5;

    public StarSpireFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> ctx) {
        StructureWorldAccess world = ctx.getWorld();
        int cx = ((ctx.getOrigin().getX() >> 4) << 4) + 8;
        int cz = ((ctx.getOrigin().getZ() >> 4) << 4) + 8;
        BlockPos.Mutable p = new BlockPos.Mutable();
        int floorY = Integer.MIN_VALUE;
        for (int y = world.getBottomY() + 10; y < 0; y++) {          // deep caves only (room for 48 blocks above)
            p.set(cx, y, cz);
            if (world.getBlockState(p.down()).isOf(ModBlocks.STAR_MOSS) && world.getBlockState(p).isAir()
                    && StarFarmBiome.isStarFarm(world, p)) {
                floorY = y;
                break;
            }
        }
        if (floorY == Integer.MIN_VALUE) {
            return false;
        }
        Optional<StructureTemplate> template = world.toServerWorld().getStructureTemplateManager().getTemplate(ID);
        if (template.isEmpty()) {
            return false;
        }
        BlockRotation rotation = BlockRotation.random(ctx.getRandom());
        StructurePlacementData data = new StructurePlacementData()
                .setRotation(rotation)
                .setPosition(new BlockPos(HALF, 0, HALF))             // rotate around the tower axis
                .addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS)
                .setUpdateNeighbors(false);
        BlockPos corner = new BlockPos(cx - HALF, floorY - BELOW, cz - HALF);
        template.get().place(world, corner, corner, data, ctx.getRandom(), 2);
        return true;
    }
}
