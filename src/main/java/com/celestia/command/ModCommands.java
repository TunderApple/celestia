package com.celestia.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;

/**
 * /starfarm  -> finds the nearest Star Farm cave (same as /locate biome celestia:star_farm).
 * Works for everyone, also in survival worlds without cheats.
 */
public final class ModCommands {
    public static void init() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                dispatcher.register(CommandManager.literal("starfarm").executes(ctx -> {
                    var source = ctx.getSource();
                    source.getServer().getCommandManager().executeWithPrefix(
                            source.withLevel(2).withSilent(), "locate biome celestia:star_farm");
                    return 1;
                })));
    }

    private ModCommands() {
    }
}
