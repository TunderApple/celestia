package com.celestia.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModEntities {
    public static final String MOD_ID = "celestia";

    public static final EntityType<UnicornEntity> UNICORN = register("unicorn",
            EntityType.Builder.create(UnicornEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.4f, 2.0f).eyeHeight(1.9f).passengerAttachments(1.72f).maxTrackingRange(10).build("unicorn"));

    public static final EntityType<PegasusEntity> PEGASUS = register("pegasus",
            EntityType.Builder.create(PegasusEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.4f, 2.0f).eyeHeight(1.9f).passengerAttachments(1.72f).maxTrackingRange(10).build("pegasus"));

    /** Star Farm cave cat. AMBIENT group so it spawns in dark caves like bats do. */
    public static final EntityType<ArnyangEntity> ARNYANG = register("arnyang",
            EntityType.Builder.create(ArnyangEntity::new, SpawnGroup.AMBIENT)
                    .dimensions(0.7f, 1.0f).eyeHeight(0.75f).maxTrackingRange(8).build("arnyang"));

    /** Breeding-only hybrid: no BiomeModifications spawn is ever added for it. */
    public static final EntityType<AlicornEntity> ALICORN = register("alicorn",
            EntityType.Builder.create(AlicornEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1.4f, 2.0f).eyeHeight(1.9f).passengerAttachments(1.72f).maxTrackingRange(10).build("alicorn"));

    private static <T extends net.minecraft.entity.Entity> EntityType<T> register(String name, EntityType<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, Identifier.of(MOD_ID, name), type);
    }

    public static void init() {
        FabricDefaultAttributeRegistry.register(ARNYANG, ArnyangEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(UNICORN, AbstractHorseEntity.createBaseHorseAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.HORSE_JUMP_STRENGTH, 0.9));
        FabricDefaultAttributeRegistry.register(PEGASUS, AbstractHorseEntity.createBaseHorseAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.28)
                .add(EntityAttributes.HORSE_JUMP_STRENGTH, 0.8));
        FabricDefaultAttributeRegistry.register(ALICORN, AbstractHorseEntity.createBaseHorseAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.32)
                .add(EntityAttributes.HORSE_JUMP_STRENGTH, 0.95));
    }

    private ModEntities() {
    }
}
