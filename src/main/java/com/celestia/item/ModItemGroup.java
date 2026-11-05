package com.celestia.item;

import com.celestia.block.ModBlocks;
import com.celestia.entity.ModEntities;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/** Creative inventory tab "Celestia" with every item, block and spawn egg of the mod. */
public final class ModItemGroup {
    public static final Item UNICORN_SPAWN_EGG = egg("unicorn_spawn_egg", new SpawnEggItem(ModEntities.UNICORN, 0xF8F4FB, 0xFF9FD0, new Item.Settings()));
    public static final Item PEGASUS_SPAWN_EGG = egg("pegasus_spawn_egg", new SpawnEggItem(ModEntities.PEGASUS, 0xF4F7FB, 0x6FA8EC, new Item.Settings()));
    public static final Item ALICORN_SPAWN_EGG = egg("alicorn_spawn_egg", new SpawnEggItem(ModEntities.ALICORN, 0xD9C8FF, 0xF0C66A, new Item.Settings()));
    public static final Item ARNYANG_SPAWN_EGG = egg("arnyang_spawn_egg", new SpawnEggItem(ModEntities.ARNYANG, 0xFFFFFF, 0x6FC0F5, new Item.Settings()));

    public static final ItemGroup CELESTIA = Registry.register(Registries.ITEM_GROUP, Identifier.of("celestia", "main"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.EVERYS))
                    .displayName(Text.translatable("itemGroup.celestia"))
                    .entries((context, e) -> {
                        // spawn eggs
                        e.add(UNICORN_SPAWN_EGG);
                        e.add(PEGASUS_SPAWN_EGG);
                        e.add(ALICORN_SPAWN_EGG);
                        e.add(ARNYANG_SPAWN_EGG);
                        // items
                        e.add(ModItems.STAR_DUST);
                        e.add(ModItems.STAR_SHARD);
                        e.add(ModItems.UNICORN_HORN);
                        e.add(ModItems.PEGASUS_FEATHER);
                        e.add(ModItems.EVERYS);
                        e.add(ModItems.STAR_FRUIT);
                        e.add(ModItems.STARLIGHT_BUCKET);
                        // blocks
                        e.add(ModBlocks.STAR_SHARD_ORE);
                        e.add(ModBlocks.STAR_SHARD_BLOCK);
                        e.add(ModBlocks.TWILIGHT_STONE);
                        e.add(ModBlocks.TWILIGHT_BRICKS);
                        e.add(ModBlocks.STAR_ALTAR);
                        e.add(ModBlocks.NIGHT_SOIL);
                        e.add(ModBlocks.STAR_MOSS);
                        e.add(ModBlocks.STAR_FARMLAND);
                        e.add(ModBlocks.STAR_CRYSTAL_BLOCK);
                        e.add(ModBlocks.STAR_CRYSTAL);
                        e.add(ModBlocks.BLOOM_STEM);
                        e.add(ModBlocks.BLOOM_HEAD);
                        e.add(ModBlocks.STAR_SPROUT);
                        e.add(ModBlocks.STAR_VINE);
                    })
                    .build());

    private static Item egg(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of("celestia", name), item);
    }

    public static void init() {
    }

    private ModItemGroup() {
    }
}
