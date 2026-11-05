package com.celestia.item;

import com.celestia.fluid.ModFluids;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public final class ModItems {
    public static final String MOD_ID = "celestia";

    public static final Item STAR_DUST = register("star_dust", new Item(new Item.Settings()));
    public static final Item STAR_SHARD = register("star_shard", new Item(new Item.Settings()));
    public static final Item UNICORN_HORN = register("unicorn_horn", new Item(new Item.Settings()));
    public static final Item PEGASUS_FEATHER = register("pegasus_feather", new Item(new Item.Settings()));

    /** Same rarity as Dragon's Breath (UNCOMMON, yellow name). */
    public static final Item EVERYS = register("everys",
            new EverysItem(new Item.Settings().rarity(Rarity.UNCOMMON)));

    /** Star Fruit: glowing fruit hanging in the Star Farm caves. Grants 30 s of night vision. */
    public static final Item STAR_FRUIT = register("star_fruit", new Item(new Item.Settings().food(
            new FoodComponent.Builder().nutrition(4).saturationModifier(0.6f).alwaysEdible()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 600), 1.0f).build())));

    public static final Item STARLIGHT_BUCKET = register("starlight_bucket",
            new BucketItem(ModFluids.STILL_STARLIGHT, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    /** Trophy dropped by Astra when slain by a player. */
    public static final Item ASTRA_SCALE = register("astra_scale", new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    // advancement icons (not obtainable in survival)
    public static final Item ICON_STELLIVE = register("icon_stellive", new Item(new Item.Settings()));
    public static final Item ICON_ARNYANG = register("icon_arnyang", new Item(new Item.Settings()));
    public static final Item ICON_END_HIGHLANDS = register("icon_end_highlands", new Item(new Item.Settings()));
    public static final Item ICON_ALICORN = register("icon_alicorn", new Item(new Item.Settings()));
    public static final Item ICON_PEGASUS = register("icon_pegasus", new Item(new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
    }

    /** Call from your ModInitializer#onInitialize to load this class. */
    public static void init() {
    }

    private ModItems() {
    }
}
