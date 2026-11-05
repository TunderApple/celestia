package com.celestia.world;

import java.util.ArrayList;
import java.util.List;

import com.celestia.block.ModBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

/**
 * Star Tower: a twilight-brick tower (22 tall) standing in a Star Farm cave, with glowing
 * crystal windows, a spiral staircase along the inner wall, a crowned roof, eight crystal
 * pillars around its platform, and the Star Altar in the middle of the ground floor.
 * Rare: see placed_feature/star_tower.json (rarity filter).
 */
public class StarTowerFeature extends Feature<DefaultFeatureConfig> {
    private static final int HEIGHT = 22;
    private static final double WALL_IN = 3.6, WALL_OUT = 4.6;

    public StarTowerFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> ctx) {
        StructureWorldAccess world = ctx.getWorld();
        int cx = ((ctx.getOrigin().getX() >> 4) << 4) + 8;
        int cz = ((ctx.getOrigin().getZ() >> 4) << 4) + 8;
        // find a Star Farm cave floor with some headroom in this column
        BlockPos.Mutable p = new BlockPos.Mutable();
        for (int y = world.getBottomY() + 10; y < 50; y++) {
            p.set(cx, y, cz);
            if (world.getBlockState(p.down()).isOf(ModBlocks.STAR_MOSS) && world.getBlockState(p).isAir()
                    && headroom(world, p) >= 8 && StarFarmBiome.isStarFarm(world, p)) {
                build(world, cx, y, cz);
                return true;
            }
        }
        return false;
    }

    private static int headroom(StructureWorldAccess world, BlockPos pos) {
        int h = 0;
        while (h < 12 && world.getBlockState(pos.up(h)).isAir()) {
            h++;
        }
        return h;
    }

    private static void put(StructureWorldAccess w, int x, int y, int z, BlockState s) {
        BlockPos pos = new BlockPos(x, y, z);
        if (y < w.getBottomY() || y >= w.getTopY() || w.getBlockState(pos).getHardness(w, pos) < 0) {
            return;                                     // never replace bedrock-like blocks
        }
        w.setBlockState(pos, s, 2);
    }

    private static void build(StructureWorldAccess w, int cx, int fy, int cz) {
        BlockState brick = ModBlocks.TWILIGHT_BRICKS.getDefaultState();
        BlockState crystal = ModBlocks.STAR_CRYSTAL_BLOCK.getDefaultState();
        BlockState light = ModBlocks.BLOOM_HEAD.getDefaultState();
        BlockState air = Blocks.AIR.getDefaultState();

        // platform (filled down to the ground) + crystal pillars
        for (int dx = -8; dx <= 8; dx++) {
            for (int dz = -8; dz <= 8; dz++) {
                double d = Math.hypot(dx, dz);
                if (d <= 7.5) {
                    put(w, cx + dx, fy - 1, cz + dz, brick);
                    for (int k = 2; k <= 5; k++) {
                        BlockPos below = new BlockPos(cx + dx, fy - k, cz + dz);
                        if (!w.getBlockState(below).isAir() && w.getFluidState(below).isEmpty()) {
                            break;
                        }
                        put(w, cx + dx, fy - k, cz + dz, brick);
                    }
                }
                if (d >= 6.5 && d <= 7.5 && (dx == 0 || dz == 0 || Math.abs(dx) == Math.abs(dz)) && !(dx == 0 && dz < 0)) {
                    for (int y = 0; y < 3; y++) {
                        put(w, cx + dx, fy + y, cz + dz, crystal);
                    }
                    put(w, cx + dx, fy + 3, cz + dz, light);
                }
            }
        }
        // walls, door, windows, hollow interior
        for (int y = 0; y < HEIGHT; y++) {
            for (int dx = -5; dx <= 5; dx++) {
                for (int dz = -5; dz <= 5; dz++) {
                    double d = Math.hypot(dx, dz);
                    int X = cx + dx, Y = fy + y, Z = cz + dz;
                    if (d < WALL_IN) {
                        put(w, X, Y, Z, air);
                    } else if (d <= WALL_OUT) {
                        boolean door = dz < 0 && Math.abs(dx) <= 1 && y <= 2;
                        boolean window = (y % 6 == 4 || y % 6 == 5) && (dx == 0 || dz == 0) && y > 3;
                        if (door) {
                            put(w, X, Y, Z, air);
                        } else if (window || y == HEIGHT - 1) {
                            put(w, X, Y, Z, crystal);
                        } else {
                            put(w, X, Y, Z, brick);
                        }
                    }
                }
            }
        }
        // wall lights inside
        for (int y = 3; y < HEIGHT - 1; y += 6) {
            put(w, cx + 3, fy + y, cz, light);
            put(w, cx - 3, fy + y, cz, light);
            put(w, cx, fy + y, cz + 3, light);
        }
        // spiral staircase of full blocks (climb by jumping)
        List<int[]> steps = new ArrayList<>();
        for (int y = 1; y < HEIGHT - 1; y++) {
            double a = Math.PI * 0.5 + y * 0.62;
            int sx = (int) Math.round(3 * Math.cos(a)), sz = (int) Math.round(3 * Math.sin(a));
            if (sz < 0 && Math.abs(sx) <= 1 && y <= 3) {
                continue;
            }
            put(w, cx + sx, fy + y - 1, cz + sz, brick);
            steps.add(new int[] {sx, sz});
        }
        int[] last = steps.isEmpty() ? new int[] {3, 0} : steps.get(steps.size() - 1);
        // top floor with a hole above the last step
        for (int dx = -4; dx <= 4; dx++) {
            for (int dz = -4; dz <= 4; dz++) {
                if (Math.hypot(dx, dz) < WALL_IN && Math.hypot(dx - last[0], dz - last[1]) > 1.2) {
                    put(w, cx + dx, fy + HEIGHT - 1, cz + dz, brick);
                }
            }
        }
        // crenellations + crown spire
        for (int dx = -5; dx <= 5; dx++) {
            for (int dz = -5; dz <= 5; dz++) {
                double d = Math.hypot(dx, dz);
                if (d >= WALL_IN && d <= WALL_OUT && Math.floorMod(dx + dz, 2) == 0) {
                    put(w, cx + dx, fy + HEIGHT, cz + dz, brick);
                }
            }
        }
        for (int y = 0; y < 3; y++) {
            put(w, cx, fy + HEIGHT + y, cz, crystal);
        }
        put(w, cx, fy + HEIGHT + 3, cz, light);

        // ---- the Star Altar in the middle of the ground floor
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                put(w, cx + dx, fy, cz + dz, brick);
            }
        }
        put(w, cx, fy + 1, cz, ModBlocks.STAR_ALTAR.getDefaultState());
        put(w, cx - 1, fy + 1, cz - 1, light);
        put(w, cx + 1, fy + 1, cz - 1, light);
        put(w, cx - 1, fy + 1, cz + 1, light);
        put(w, cx + 1, fy + 1, cz + 1, light);
        BlockState cluster = ModBlocks.STAR_CRYSTAL.getDefaultState().with(AmethystClusterBlock.FACING, Direction.UP);
        for (int k = 0; k < 8; k++) {
            double a = k * Math.PI / 4;
            int x = (int) Math.round(2.6 * Math.cos(a)), z = (int) Math.round(2.6 * Math.sin(a));
            if (!(z < 0 && Math.abs(x) <= 1)) {
                put(w, cx + x, fy, cz + z, cluster);
            }
        }
    }
}
