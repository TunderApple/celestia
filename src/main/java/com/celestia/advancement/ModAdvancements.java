package com.celestia.advancement;

import java.util.List;

import com.celestia.entity.ModEntities;
import com.celestia.world.StarFarmBiome;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;

/**
 * Once a second: entering the Star Farm biome, and being within 12 blocks of a
 * unicorn / pegasus / arnyang, grant the matching advancements.
 */
public final class ModAdvancements {
    private static final double MEET_RANGE = 12.0;

    private record Meet(EntityType<?> type, Identifier advancement) {
    }

    public static void init() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (server.getTicks() % 20 != 0) {
                return;
            }
            List<Meet> meets = List.of(
                    new Meet(ModEntities.UNICORN, Identifier.of("celestia", "meet_unicorn")),
                    new Meet(ModEntities.PEGASUS, Identifier.of("celestia", "meet_pegasus")),
                    new Meet(ModEntities.ARNYANG, Identifier.of("celestia", "meet_arnyang")));
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (StarFarmBiome.isStarFarm(player.getWorld(), player.getBlockPos())) {
                    grant(server, player, Identifier.of("celestia", "star_farm"), "enter");
                }
                Box box = player.getBoundingBox().expand(MEET_RANGE);
                for (Meet m : meets) {
                    if (!player.getWorld().getEntitiesByType(m.type(), box, Entity::isAlive).isEmpty()) {
                        grant(server, player, m.advancement(), "meet");
                    }
                }
            }
        });
    }

    public static void grant(MinecraftServer server, ServerPlayerEntity player, Identifier id, String criterion) {
        AdvancementEntry entry = server.getAdvancementLoader().get(id);
        if (entry != null && !player.getAdvancementTracker().getProgress(entry).isDone()) {
            player.getAdvancementTracker().grantCriterion(entry, criterion);
        }
    }

    private ModAdvancements() {
    }
}
