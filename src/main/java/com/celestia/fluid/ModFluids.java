package com.celestia.fluid;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModFluids {
    public static final StarlightFluid STILL_STARLIGHT = Registry.register(Registries.FLUID,
            Identifier.of("celestia", "starlight"), new StarlightFluid.Still());
    public static final StarlightFluid FLOWING_STARLIGHT = Registry.register(Registries.FLUID,
            Identifier.of("celestia", "flowing_starlight"), new StarlightFluid.Flowing());

    public static void init() {
    }

    private ModFluids() {
    }
}
