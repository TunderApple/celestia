package com.celestia.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

/** Client -> server: "my unicorn dashes now". */
public record DashPayload() implements CustomPayload {
    public static final CustomPayload.Id<DashPayload> ID =
            new CustomPayload.Id<>(Identifier.of("celestia", "unicorn_dash"));
    public static final PacketCodec<RegistryByteBuf, DashPayload> CODEC = PacketCodec.unit(new DashPayload());

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
