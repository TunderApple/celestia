package com.celestia.world;

import com.celestia.block.ModBlocks;
import com.celestia.fluid.ModFluids;
import com.mojang.serialization.Codec;

import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

/**
 * Runs once per chunk and decorates every Star Farm cave floor/ceiling in it:
 * giant tilted crystal spires, giant star blooms, vine curtains with star fruit,
 * starlight pools and falls, scattered sprouts/crystals, and rare little star fields.
 * Everything stays within +-8 blocks of the chunk so it never reaches unloaded chunks.
 */
public class StarFarmDecorFeature extends Feature<DefaultFeatureConfig> {
    public StarFarmDecorFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> ctx) {
        StructureWorldAccess world = ctx.getWorld();
        Random random = ctx.getRandom();
        BlockPos origin = ctx.getOrigin();
        int x0 = (origin.getX() >> 4) << 4, z0 = (origin.getZ() >> 4) << 4;
        int minY = world.getBottomY() + 8, maxY = 60;
        boolean placed = false;
        BlockPos.Mutable p = new BlockPos.Mutable();

        for (int dx = 0; dx < 16; dx++) {
            for (int dz = 0; dz < 16; dz++) {
                int x = x0 + dx, z = z0 + dz;
                for (int y = minY; y < maxY; y++) {
                    p.set(x, y, z);
                    BlockState here = world.getBlockState(p);
                    if (!here.isAir()) {
                        continue;
                    }
                    boolean floor = world.getBlockState(p.down()).isOf(ModBlocks.STAR_MOSS);
                    boolean ceiling = world.getBlockState(p.up()).isOf(ModBlocks.TWILIGHT_STONE);
                    if (!floor && !ceiling) {
                        continue;
                    }
                    if (!StarFarmBiome.isStarFarm(world, p)) {
                        continue;                                       // this spot is not in the biome
                    }
                    boolean inner = dx >= 4 && dx < 12 && dz >= 4 && dz < 12;
                    if (floor) {
                        placed |= decorateFloor(world, random, p.toImmutable(), inner);
                    }
                    if (ceiling) {
                        placed |= decorateCeiling(world, random, p.toImmutable(), inner);
                    }
                }
            }
        }
        return placed;
    }

    // ------------------------------------------------------------------ floor
    private boolean decorateFloor(StructureWorldAccess world, Random r, BlockPos pos, boolean inner) {
        float roll = r.nextFloat();
        if (inner && roll < 0.006f) {
            return crystalSpire(world, r, pos.down(), Direction.UP);
        }
        if (inner && roll < 0.016f) {
            return starBloom(world, r, pos);
        }
        if (inner && roll < 0.019f) {
            return starlightPool(world, r, pos.down());
        }
        if (inner && roll < 0.0205f) {
            return starField(world, r, pos.down());
        }
        if (roll < 0.09f) {
            world.setBlockState(pos, ModBlocks.STAR_SPROUT.getDefaultState(), 2);
            return true;
        }
        if (roll < 0.12f) {
            world.setBlockState(pos, ModBlocks.STAR_CRYSTAL.getDefaultState().with(AmethystClusterBlock.FACING, Direction.UP), 2);
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------------ ceiling
    private boolean decorateCeiling(StructureWorldAccess world, Random r, BlockPos pos, boolean inner) {
        float roll = r.nextFloat();
        if (inner && roll < 0.004f) {
            return crystalSpire(world, r, pos.up(), Direction.DOWN);
        }
        if (inner && roll < 0.0055f) {                                // starlight fall from the ceiling
            world.setBlockState(pos.up(), ModFluids.STILL_STARLIGHT.getDefaultState().getBlockState(), 2);
            world.scheduleFluidTick(pos.up(), ModFluids.STILL_STARLIGHT, 0);
            return true;
        }
        if (roll < 0.06f) {                                           // vine curtain ending in a star fruit
            int len = 2 + r.nextInt(10);
            BlockPos.Mutable m = pos.mutableCopy();
            int i = 0;
            for (; i < len; i++) {
                if (!world.getBlockState(m).isAir() || !world.getBlockState(m.down()).isAir()) {
                    break;
                }
                world.setBlockState(m, ModBlocks.STAR_VINE.getDefaultState(), 2);
                m.move(Direction.DOWN);
            }
            if (i > 0 && world.getBlockState(m).isAir()) {
                world.setBlockState(m, ModBlocks.STAR_FRUIT_BLOCK.getDefaultState(), 2);
            }
            return i > 0;
        }
        return false;
    }

    // ------------------------------------------------------------------ pieces
    /** Tilted tapering cone of crystal blocks, from floor (UP) or ceiling (DOWN). */
    private boolean crystalSpire(StructureWorldAccess world, Random r, BlockPos base, Direction dir) {
        int length = 7 + r.nextInt(dir == Direction.UP ? 12 : 8);
        float radius = 1.5f + r.nextFloat() * 1.6f;
        double ang = r.nextDouble() * Math.PI * 2, tilt = r.nextDouble() * 0.45;
        double tx = Math.cos(ang) * Math.sin(tilt), tz = Math.sin(ang) * Math.sin(tilt), ty = Math.cos(tilt) * dir.getOffsetY();
        boolean any = false;
        for (int i = 0; i <= length; i++) {
            double t = (double) i / length;
            double cx = base.getX() + 0.5 + tx * i, cy = base.getY() + 0.5 + ty * i, cz = base.getZ() + 0.5 + tz * i;
            double rad = radius * (1 - t) + 0.35;
            int ri = MathHelper.ceil(rad);
            for (int ox = -ri; ox <= ri; ox++) {
                for (int oz = -ri; oz <= ri; oz++) {
                    if (ox * ox + oz * oz > rad * rad) {
                        continue;
                    }
                    BlockPos q = BlockPos.ofFloored(cx + ox, cy, cz + oz);
                    if (Math.abs(q.getX() - base.getX()) > 8 || Math.abs(q.getZ() - base.getZ()) > 8) {
                        continue;
                    }
                    BlockState s = world.getBlockState(q);
                    if (s.isAir() || s.isOf(ModBlocks.STAR_SPROUT) || s.isOf(ModBlocks.STAR_VINE)) {
                        world.setBlockState(q, ModBlocks.STAR_CRYSTAL_BLOCK.getDefaultState(), 2);
                        any = true;
                    }
                }
            }
        }
        return any;
    }

    /** Giant star bloom: a stem 4-9 tall with a glowing petal crown. */
    private boolean starBloom(StructureWorldAccess world, Random r, BlockPos pos) {
        int h = 4 + r.nextInt(6);
        for (int y = 0; y <= h + 2; y++) {
            for (int ox = -2; ox <= 2; ox++) {
                for (int oz = -2; oz <= 2; oz++) {
                    if (!world.getBlockState(pos.add(ox, y, oz)).isAir() && !(ox == 0 && oz == 0 && y == 0)) {
                        if (y > 0) {
                            return false;                              // no room
                        }
                    }
                }
            }
        }
        for (int y = 0; y < h; y++) {
            world.setBlockState(pos.up(y), ModBlocks.BLOOM_STEM.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y), 2);
        }
        BlockPos top = pos.up(h);
        BlockState petal = ModBlocks.BLOOM_HEAD.getDefaultState();
        world.setBlockState(top, petal, 2);
        world.setBlockState(top.up(), petal, 2);
        for (Direction d : Direction.Type.HORIZONTAL) {
            world.setBlockState(top.offset(d), petal, 2);
            world.setBlockState(top.offset(d, 2).down(), petal, 2);
        }
        return true;
    }

    /** Small sunken pool of starlight (only where it is enclosed). */
    private boolean starlightPool(StructureWorldAccess world, Random r, BlockPos center) {
        int rad = 2 + r.nextInt(3);
        for (int ox = -rad - 1; ox <= rad + 1; ox++) {
            for (int oz = -rad - 1; oz <= rad + 1; oz++) {
                BlockPos q = center.add(ox, 0, oz);
                boolean edge = ox * ox + oz * oz > rad * rad;
                if (edge && !world.getBlockState(q).isOpaqueFullCube(world, q)) {
                    return false;                                      // would leak
                }
                if (!edge && !world.getBlockState(q.down()).isOpaqueFullCube(world, q.down())) {
                    return false;
                }
            }
        }
        BlockState liquid = ModFluids.STILL_STARLIGHT.getDefaultState().getBlockState();
        for (int ox = -rad; ox <= rad; ox++) {
            for (int oz = -rad; oz <= rad; oz++) {
                if (ox * ox + oz * oz <= rad * rad) {
                    BlockPos q = center.add(ox, 0, oz);
                    world.setBlockState(q, liquid, 2);
                    world.setBlockState(q.up(), Blocks.AIR.getDefaultState(), 2);
                }
            }
        }
        return true;
    }

    /** Rare natural star field: farmland rows with sprouts and starlight channels. */
    private boolean starField(StructureWorldAccess world, Random r, BlockPos center) {
        BlockState liquid = ModFluids.STILL_STARLIGHT.getDefaultState().getBlockState();
        for (int ox = -3; ox <= 3; ox++) {
            for (int oz = -3; oz <= 3; oz++) {
                BlockPos q = center.add(ox, 0, oz);
                if (!world.getBlockState(q).isOf(ModBlocks.STAR_MOSS) || !world.getBlockState(q.up()).isAir()) {
                    continue;
                }
                if (ox % 3 == 0 && Math.abs(oz) < 3) {
                    world.setBlockState(q, liquid, 2);
                } else {
                    world.setBlockState(q, ModBlocks.STAR_FARMLAND.getDefaultState(), 2);
                    if (r.nextFloat() < 0.8f) {
                        world.setBlockState(q.up(), ModBlocks.STAR_SPROUT.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
