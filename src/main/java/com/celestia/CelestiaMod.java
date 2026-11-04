package com.celestia;

import com.celestia.advancement.ModAdvancements;
import com.celestia.block.ModBlocks;
import com.celestia.command.ModCommands;
import com.celestia.item.ModItemGroup;
import com.celestia.fluid.ModFluids;
import com.celestia.entity.ModEntities;
import com.celestia.item.ModItems;
import com.celestia.network.ModNetworking;
import com.celestia.world.ModSpawns;
import com.celestia.world.ModWorldGen;

import net.fabricmc.api.ModInitializer;

public class CelestiaMod implements ModInitializer {
    public static final String MOD_ID = "celestia";

    @Override
    public void onInitialize() {
        ModFluids.init();
        ModBlocks.init();
        ModItems.init();
        ModEntities.init();
        ModItemGroup.init();
        ModCommands.init();
        ModSpawns.init();
        ModWorldGen.init();
        ModNetworking.init();
        ModAdvancements.init();
    }
}
