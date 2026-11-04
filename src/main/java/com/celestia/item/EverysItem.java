package com.celestia.item;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

/** Everys — "모든 차원을 넘어서 잊혀진 빛과 소리를 다시 하나로" */
public class EverysItem extends Item {
    public EverysItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("item.celestia.everys.desc").formatted(Formatting.GRAY, Formatting.ITALIC));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
