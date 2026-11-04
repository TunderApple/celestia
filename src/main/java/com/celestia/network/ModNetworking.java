package com.celestia.network;

import com.celestia.entity.CelestialHorseEntity;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

public final class ModNetworking {
    public static void init() {
        PayloadTypeRegistry.playC2S().register(DashPayload.ID, DashPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(DashPayload.ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            context.server().execute(() -> {
                if (player.getVehicle() instanceof CelestialHorseEntity horse
                        && horse.hasHorn() && horse.getControllingPassenger() == player) {
                    horse.startDash(player.getYaw());
                }
            });
        });
    }

    private ModNetworking() {
    }
}
