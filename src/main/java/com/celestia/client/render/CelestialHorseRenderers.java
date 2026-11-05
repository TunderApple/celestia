package com.celestia.client.render;

import com.celestia.client.CelestiaClient;
import com.celestia.client.model.AlicornModel;
import com.celestia.client.model.AstraDragonModel;
import com.celestia.entity.AstraDragonEntity;
import net.minecraft.client.util.math.MatrixStack;
import com.celestia.client.model.ArnyangModel;
import com.celestia.client.model.PegasusModel;
import com.celestia.client.model.UnicornModel;
import com.celestia.entity.AlicornEntity;
import com.celestia.entity.ArnyangEntity;
import com.celestia.entity.PegasusEntity;
import com.celestia.entity.UnicornEntity;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;

public final class CelestialHorseRenderers {
    private static final Identifier UNICORN_TEX = Identifier.of("celestia", "textures/entity/unicorn.png");
    private static final Identifier UNICORN_GLOW = Identifier.of("celestia", "textures/entity/unicorn_glow.png");
    private static final Identifier ALICORN_TEX = Identifier.of("celestia", "textures/entity/alicorn.png");
    private static final Identifier ALICORN_GLOW = Identifier.of("celestia", "textures/entity/alicorn_glow.png");
    private static final Identifier PEGASUS_TEX = Identifier.of("celestia", "textures/entity/pegasus.png");

    public static class Unicorn extends MobEntityRenderer<UnicornEntity, UnicornModel<UnicornEntity>> {
        public Unicorn(EntityRendererFactory.Context ctx) {
            super(ctx, new UnicornModel<>(ctx.getPart(CelestiaClient.UNICORN_LAYER)), 0.85f);
            this.addFeature(new Glow<>(this, UNICORN_GLOW));      // glowing horn, visible in the dark
        }

        @Override
        public Identifier getTexture(UnicornEntity entity) {
            return UNICORN_TEX;
        }
    }

    public static class Pegasus extends MobEntityRenderer<PegasusEntity, PegasusModel<PegasusEntity>> {
        public Pegasus(EntityRendererFactory.Context ctx) {
            super(ctx, new PegasusModel<>(ctx.getPart(CelestiaClient.PEGASUS_LAYER)), 0.85f);
        }

        @Override
        public Identifier getTexture(PegasusEntity entity) {
            return PEGASUS_TEX;
        }
    }

    public static class Alicorn extends MobEntityRenderer<AlicornEntity, AlicornModel<AlicornEntity>> {
        public Alicorn(EntityRendererFactory.Context ctx) {
            super(ctx, new AlicornModel<>(ctx.getPart(CelestiaClient.ALICORN_LAYER)), 0.9f);
            this.addFeature(new Glow<>(this, ALICORN_GLOW));      // horn + starry mane glow
        }

        @Override
        public Identifier getTexture(AlicornEntity entity) {
            return ALICORN_TEX;
        }
    }

    public static class Arnyang extends MobEntityRenderer<ArnyangEntity, ArnyangModel<ArnyangEntity>> {
        private static final Identifier TEX = Identifier.of("celestia", "textures/entity/arnyang.png");

        public Arnyang(EntityRendererFactory.Context ctx) {
            super(ctx, new ArnyangModel<>(ctx.getPart(CelestiaClient.ARNYANG_LAYER)), 0.4f);
            this.addFeature(new Glow<>(this, Identifier.of("celestia", "textures/entity/arnyang_glow.png")));
        }

        @Override
        public Identifier getTexture(ArnyangEntity entity) {
            return TEX;
        }
    }

    public static class AstraDragon extends MobEntityRenderer<AstraDragonEntity, AstraDragonModel<AstraDragonEntity>> {
        private static final Identifier TEX = Identifier.of("celestia", "textures/entity/astra_dragon.png");

        public AstraDragon(EntityRendererFactory.Context ctx) {
            super(ctx, new AstraDragonModel<>(ctx.getPart(CelestiaClient.ASTRA_LAYER)), 1.0f);
            this.addFeature(new Glow<>(this, Identifier.of("celestia", "textures/entity/astra_dragon_glow.png")));
        }

        @Override
        protected void scale(AstraDragonEntity entity, MatrixStack matrices, float amount) {
            matrices.scale(1.5f, 1.5f, 1.5f);                        // a towering 3-block-tall boss
        }

        @Override
        public Identifier getTexture(AstraDragonEntity entity) {
            return TEX;
        }
    }

    /** Full-bright overlay layer (like spider/enderman eyes) for emissive texels. */
    public static class Glow<T extends net.minecraft.entity.LivingEntity, M extends net.minecraft.client.render.entity.model.EntityModel<T>>
            extends EyesFeatureRenderer<T, M> {
        private final RenderLayer layer;

        public Glow(FeatureRendererContext<T, M> ctx, Identifier texture) {
            super(ctx);
            this.layer = RenderLayer.getEyes(texture);
        }

        @Override
        public RenderLayer getEyesTexture() {
            return this.layer;
        }
    }

    private CelestialHorseRenderers() {
    }
}
