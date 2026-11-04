package com.celestia.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

/** Small glowing star flower; grows on star moss, night soil and star farmland. */
public class StarSproutBlock extends PlantBlock {
    public static final MapCodec<StarSproutBlock> CODEC = createCodec(StarSproutBlock::new);
    private static final VoxelShape SHAPE = PlantBlock.createCuboidShape(3, 0, 3, 13, 13, 13);

    public StarSproutBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.STAR_MOSS) || floor.isOf(ModBlocks.NIGHT_SOIL) || floor.isOf(ModBlocks.STAR_FARMLAND)
                || super.canPlantOnTop(floor, world, pos);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
