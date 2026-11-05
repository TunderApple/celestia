package com.celestia.block;

import com.celestia.item.ModItems;
import com.celestia.ritual.StarRituals;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

/** Star Altar: right-click with Everys to summon Astra, the Violet Star Dragon. */
public class StarAltarBlock extends Block {
    private static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0, 0, 0, 16, 4, 16),
            Block.createCuboidShape(3, 4, 3, 13, 10, 13),
            Block.createCuboidShape(1, 10, 1, 15, 14, 15));

    public StarAltarBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
                                             PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!stack.isOf(ModItems.EVERYS)) {
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        if (world instanceof ServerWorld server) {
            if (StarRituals.isRunningAt(server, pos) || StarRituals.dragonNearby(server, pos)) {
                player.sendMessage(Text.translatable("ritual.celestia.busy").formatted(Formatting.GRAY), true);
                world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 1.0f, 0.5f);
                return ItemActionResult.CONSUME;
            }
            stack.decrementUnlessCreative(1, player);
            StarRituals.start(server, pos);
        }
        return ItemActionResult.success(world.isClient);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
