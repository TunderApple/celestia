package com.celestia.client;

import org.lwjgl.glfw.GLFW;

import com.celestia.block.ModBlocks;
import com.celestia.client.model.AlicornModel;
import com.celestia.client.model.ArnyangModel;
import com.celestia.fluid.ModFluids;
import com.celestia.client.model.PegasusModel;
import com.celestia.client.model.UnicornModel;
import com.celestia.client.render.CelestialHorseRenderers;
import com.celestia.entity.ModEntities;
import com.celestia.entity.CelestialHorseEntity;
import com.celestia.network.DashPayload;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;

public class CelestiaClient implements ClientModInitializer {
    public static final EntityModelLayer UNICORN_LAYER = new EntityModelLayer(Identifier.of("celestia", "unicorn"), "main");
    public static final EntityModelLayer PEGASUS_LAYER = new EntityModelLayer(Identifier.of("celestia", "pegasus"), "main");

    public static final EntityModelLayer ALICORN_LAYER = new EntityModelLayer(Identifier.of("celestia", "alicorn"), "main");

    public static final EntityModelLayer ARNYANG_LAYER = new EntityModelLayer(Identifier.of("celestia", "arnyang"), "main");

    public static KeyBinding DASH_KEY;

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(UNICORN_LAYER, UnicornModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PEGASUS_LAYER, PegasusModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.UNICORN, CelestialHorseRenderers.Unicorn::new);
        EntityRendererRegistry.register(ModEntities.PEGASUS, CelestialHorseRenderers.Pegasus::new);
        EntityModelLayerRegistry.registerModelLayer(ALICORN_LAYER, AlicornModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ALICORN, CelestialHorseRenderers.Alicorn::new);

        EntityModelLayerRegistry.registerModelLayer(ARNYANG_LAYER, ArnyangModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ARNYANG, CelestialHorseRenderers.Arnyang::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.STAR_SPROUT, ModBlocks.STAR_VINE, ModBlocks.STAR_FRUIT_BLOCK, ModBlocks.STAR_CRYSTAL, ModBlocks.STAR_ALTAR);
        // Starlight: vanilla water textures tinted lavender
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_STARLIGHT, ModFluids.FLOWING_STARLIGHT,
                new SimpleFluidRenderHandler(Identifier.of("minecraft", "block/water_still"),
                        Identifier.of("minecraft", "block/water_flow"), 0xB8A6FF));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.STILL_STARLIGHT, ModFluids.FLOWING_STARLIGHT);

        DASH_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.celestia.unicorn_dash", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G, "category.celestia"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (DASH_KEY.wasPressed()) {
                if (client.player != null
                        && client.player.getVehicle() instanceof CelestialHorseEntity horse
                        && horse.hasHorn()
                        && horse.getControllingPassenger() == client.player
                        && horse.startDash(client.player.getYaw())) {     // move locally right away
                    ClientPlayNetworking.send(new DashPayload());           // server: cooldown + rainbow
                }
            }
        });
    }
}
