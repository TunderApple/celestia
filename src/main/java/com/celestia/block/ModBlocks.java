package com.celestia.block;

import com.celestia.fluid.ModFluids;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public final class ModBlocks {
    // ---------------------------------------------------------------- End ore
    /** Netherite pickaxe only (see tags); as tough as ancient debris; faintly glowing. */
    public static final Block STAR_SHARD_ORE = register("star_shard_ore", new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.PALE_YELLOW).requiresTool().strength(30.0f, 1200.0f)
            .sounds(BlockSoundGroup.ANCIENT_DEBRIS).luminance(s -> 5)));
    public static final Block STAR_SHARD_BLOCK = register("star_shard_block", new Block(AbstractBlock.Settings.create()
            .mapColor(MapColor.PURPLE).requiresTool().strength(5.0f, 6.0f)
            .sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(s -> 10)));

    // ---------------------------------------------------------------- Star Farm terrain
    public static final Block TWILIGHT_STONE = register("twilight_stone", new Block(AbstractBlock.Settings.copy(Blocks.STONE)
            .mapColor(MapColor.BLUE)));
    public static final Block NIGHT_SOIL = register("night_soil", new Block(AbstractBlock.Settings.copy(Blocks.DIRT)
            .mapColor(MapColor.PURPLE)));
    public static final Block STAR_MOSS = register("star_moss", new Block(AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK)
            .mapColor(MapColor.CYAN).luminance(s -> 3)));
    public static final Block STAR_FARMLAND = register("star_farmland", new Block(AbstractBlock.Settings.copy(Blocks.DIRT)
            .mapColor(MapColor.PURPLE).luminance(s -> 2)));
    public static final Block STAR_CRYSTAL_BLOCK = register("star_crystal_block", new Block(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)
            .mapColor(MapColor.PURPLE).luminance(s -> 12)));
    public static final Block STAR_CRYSTAL = register("star_crystal", new AmethystClusterBlock(7.0f, 3.0f,
            AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER).luminance(s -> 10)));

    public static final Block TWILIGHT_BRICKS = register("twilight_bricks", new Block(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)
            .mapColor(MapColor.BLUE)));
    public static final Block CRACKED_TWILIGHT_BRICKS = register("cracked_twilight_bricks", new Block(AbstractBlock.Settings.copy(TWILIGHT_BRICKS)));
    public static final Block CHISELED_TWILIGHT_BRICKS = register("chiseled_twilight_bricks", new Block(AbstractBlock.Settings.copy(TWILIGHT_BRICKS)));
    public static final Block GILDED_TWILIGHT_BRICKS = register("gilded_twilight_bricks", new Block(AbstractBlock.Settings.copy(TWILIGHT_BRICKS)
            .mapColor(MapColor.GOLD)));
    public static final Block TWILIGHT_PILLAR = register("twilight_pillar", new PillarBlock(AbstractBlock.Settings.copy(TWILIGHT_BRICKS)));
    public static final Block TWILIGHT_BRICK_STAIRS = register("twilight_brick_stairs",
            new StairsBlock(TWILIGHT_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(TWILIGHT_BRICKS)));
    public static final Block TWILIGHT_BRICK_SLAB = register("twilight_brick_slab", new SlabBlock(AbstractBlock.Settings.copy(TWILIGHT_BRICKS)));

    /** Star Altar: heart of the Star Tower. Glows; very hard to break. */
    public static final Block STAR_ALTAR = register("star_altar", new StarAltarBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS)
            .mapColor(MapColor.PURPLE).strength(50.0f, 1200.0f).luminance(s -> 12).nonOpaque()));

    // ---------------------------------------------------------------- Star Farm plants
    public static final Block BLOOM_STEM = register("bloom_stem", new PillarBlock(AbstractBlock.Settings.copy(Blocks.MUSHROOM_STEM)
            .mapColor(MapColor.CYAN)));
    public static final Block BLOOM_HEAD = register("bloom_head", new Block(AbstractBlock.Settings.copy(Blocks.SHROOMLIGHT)
            .mapColor(MapColor.YELLOW).luminance(s -> 15)));
    public static final Block STAR_SPROUT = register("star_sprout", new StarSproutBlock(AbstractBlock.Settings.copy(Blocks.SHORT_GRASS)
            .mapColor(MapColor.YELLOW).luminance(s -> 8).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block STAR_VINE = register("star_vine", new HangingPlantBlock(AbstractBlock.Settings.copy(Blocks.CAVE_VINES_PLANT)
            .mapColor(MapColor.CYAN).luminance(s -> 0)));
    public static final Block STAR_FRUIT_BLOCK = registerNoItem("star_fruit", new HangingPlantBlock(AbstractBlock.Settings.copy(Blocks.CAVE_VINES_PLANT)
            .mapColor(MapColor.YELLOW).luminance(s -> 15)));

    // ---------------------------------------------------------------- Starlight liquid
    public static final Block STARLIGHT = registerNoItem("starlight", new FluidBlock(ModFluids.STILL_STARLIGHT,
            AbstractBlock.Settings.copy(Blocks.WATER).mapColor(MapColor.LIGHT_BLUE).luminance(s -> 13)) {
    });

    private static Block register(String name, Block block) {
        Identifier id = Identifier.of("celestia", name);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, id, block);
    }

    private static Block registerNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of("celestia", name), block);
    }

    public static void init() {
    }

    private ModBlocks() {
    }
}
