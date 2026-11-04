package com.celestia.client.model;

import com.celestia.entity.ArnyangEntity;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.MathHelper;

/** Arnyang (256x64 texture). Walks on four legs; stands up and cheers when a player holds a Star Fruit. */
public class ArnyangModel<T extends ArnyangEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    private final ModelPart[] posed;
    // per part: stand pivot xyz, stand rot xyz, cheer pivot xyz, cheer rot xyz
    private static final float[][] POSES = {
        {0F, 20.4011F, 3.5F, 0F, 0F, 0F, 0F, 17.4425F, 3.5F, -1.25F, 0F, 0F},
        {0F, -5.6F, -6.9F, 0F, 0F, 0F, 0F, -5.6F, -6.9F, 1.17F, 0F, 0F},
        {0F, -4.2F, 1F, 0.95F, 0F, 0F, 0F, -4.2F, 1F, 2.44F, 0F, 0.2F},
        {2F, -1F, -6.3F, 0F, 0F, 0F, 3.2F, -3F, -6.5F, 5.236F, -0.8F, -0.8F},
        {-2F, -1F, -6.3F, 0F, 0F, 0F, -3.2F, -3F, -6.5F, 5.236F, 0.8F, 0.8F},
        {2F, -1F, -0.8F, 0F, 0F, 0F, 2F, -1F, -0.8F, 1.25F, 0F, 0F},
        {-2F, -1F, -0.8F, 0F, 0F, 0F, -2F, -1F, -0.8F, 1.25F, 0F, 0F}
    };

    public ArnyangModel(ModelPart root) {
        this.root = root;
        ModelPart body = root.getChild("body");
        this.posed = new ModelPart[] {
            body, body.getChild("head"), body.getChild("tail"),
            body.getChild("left_front_leg"), body.getChild("right_front_leg"),
            body.getChild("left_hind_leg"), body.getChild("right_hind_leg")
        };
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        ModelPartData p0 = root.addChild("body", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-3.5F, -6F, -8F, 7F, 6F, 9F, new Dilation(0.1F))
                .uv(32, 0).cuboid(-3F, -6.6F, -7.5F, 6F, 7F, 8F, new Dilation(0.1F))
                .uv(120, 0).cuboid(-4F, -5.4F, -7.4F, 8F, 5F, 8F, new Dilation(-0.2F))
                .uv(182, 0).cuboid(-3F, -5.2F, -9.1F, 6F, 5F, 2F, new Dilation(0.1F))
                .uv(48, 22).cuboid(-2F, -1.3F, -9.6F, 4F, 2F, 1F, new Dilation(0F))
                .uv(198, 0).cuboid(-2.5F, -1.2F, -7F, 5F, 1F, 6F, new Dilation(0.15F)),
                ModelTransform.of(0F, 20.4011F, 3.5F, 0F, 0F, 0F));
        ModelPartData p1 = p0.addChild("head", ModelPartBuilder.create()
                .uv(60, 0).cuboid(-4.5F, -7F, -6F, 9F, 7F, 7F, new Dilation(0F))
                .uv(92, 0).cuboid(-4F, -7.5F, -5.5F, 8F, 8F, 6F, new Dilation(-0.05F))
                .uv(78, 15).cuboid(-3.5F, -7.9F, -5F, 7F, 1F, 5F, new Dilation(0.05F))
                .uv(152, 0).cuboid(-5F, -3.2F, -5F, 10F, 3F, 5F, new Dilation(-0.2F))
                .uv(220, 0).cuboid(-4F, -0.9F, -5.4F, 8F, 1F, 6F, new Dilation(-0.05F))
                .uv(0, 15).cuboid(-4F, -6.5F, 0.6F, 8F, 6F, 1F, new Dilation(-0.1F))
                .uv(102, 15).cuboid(-3.6F, -0.2F, -4.4F, 7F, 1F, 5F, new Dilation(0.25F)),
                ModelTransform.of(0F, -5.6F, -6.9F, 0F, 0F, 0F));
        ModelPartData p2 = p1.addChild("left_ear", ModelPartBuilder.create()
                .uv(202, 15).cuboid(-2F, -2F, -1F, 4F, 2F, 2F, new Dilation(0F))
                .uv(58, 22).cuboid(-1.5F, -3F, -1F, 3F, 1F, 2F, new Dilation(-0.02F))
                .uv(100, 22).cuboid(-1F, -4F, -0.5F, 2F, 1F, 1F, new Dilation(0.05F))
                .uv(106, 22).cuboid(-0.5F, -5F, -0.5F, 1F, 1F, 1F, new Dilation(-0.05F))
                .uv(68, 22).cuboid(-1F, -3.2F, -1.25F, 2F, 2F, 1F, new Dilation(-0.15F)),
                ModelTransform.of(3.1F, -7.2F, -2.6F, -0.12F, 0F, 0.26F));
        ModelPartData p3 = p1.addChild("right_ear", ModelPartBuilder.create()
                .uv(214, 15).cuboid(-2F, -2F, -1F, 4F, 2F, 2F, new Dilation(0F))
                .uv(74, 22).cuboid(-1.5F, -3F, -1F, 3F, 1F, 2F, new Dilation(-0.02F))
                .uv(110, 22).cuboid(-1F, -4F, -0.5F, 2F, 1F, 1F, new Dilation(0.05F))
                .uv(116, 22).cuboid(-0.5F, -5F, -0.5F, 1F, 1F, 1F, new Dilation(-0.05F))
                .uv(84, 22).cuboid(-1F, -3.2F, -1.25F, 2F, 2F, 1F, new Dilation(-0.15F)),
                ModelTransform.of(-3.1F, -7.2F, -2.6F, -0.12F, 0F, -0.26F));
        ModelPartData p4 = p1.addChild("horn", ModelPartBuilder.create()
                .uv(226, 15).cuboid(-1.5F, -0.8F, -1.5F, 3F, 1F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, -7.6F, -3F, -0.06F, 0F, 0F));
        ModelPartData p5 = p4.addChild("horn0", ModelPartBuilder.create()
                .uv(150, 15).cuboid(-1.5F, -2F, -1.5F, 3F, 2F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(0F, -0.6F, 0F, 0F, 0.62F, 0F));
        ModelPartData p6 = p5.addChild("horn1", ModelPartBuilder.create()
                .uv(238, 15).cuboid(-1F, -2F, -1F, 2F, 2F, 2F, new Dilation(0.15F)),
                ModelTransform.of(0F, -2F, 0F, 0F, 0.62F, 0F));
        ModelPartData p7 = p6.addChild("horn2", ModelPartBuilder.create()
                .uv(246, 15).cuboid(-1F, -2F, -1F, 2F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, -2F, 0F, 0F, 0.62F, 0F));
        ModelPartData p8 = p7.addChild("horn3", ModelPartBuilder.create()
                .uv(90, 22).cuboid(-0.5F, -2F, -0.5F, 1F, 2F, 1F, new Dilation(0.05F)),
                ModelTransform.of(0F, -2F, 0F, 0F, 0.62F, 0F));
        ModelPartData p9 = p8.addChild("horn4", ModelPartBuilder.create()
                .uv(120, 22).cuboid(-0.5F, -1F, -0.5F, 1F, 1F, 1F, new Dilation(-0.3F)),
                ModelTransform.of(0F, -2F, 0F, 0F, 0.62F, 0F));
        ModelPartData p10 = p1.addChild("tuft", ModelPartBuilder.create()
                .uv(162, 15).cuboid(-1F, -1F, -1.5F, 2F, 2F, 3F, new Dilation(-0.2F)),
                ModelTransform.of(4.9F, -2.4F, -3F, 0F, 0F, 0.55F));
        ModelPartData p11 = p1.addChild("tuft_1", ModelPartBuilder.create()
                .uv(172, 15).cuboid(-1F, -1F, -1.5F, 2F, 2F, 3F, new Dilation(-0.2F)),
                ModelTransform.of(-4.9F, -2.4F, -3F, 0F, 0F, -0.55F));
        ModelPartData p12 = p1.addChild("tuft_2", ModelPartBuilder.create()
                .uv(182, 15).cuboid(-1F, -1F, -1.5F, 2F, 2F, 3F, new Dilation(-0.2F)),
                ModelTransform.of(4.9F, -1.2F, -1.2F, 0F, 0F, 0.95F));
        ModelPartData p13 = p1.addChild("tuft_3", ModelPartBuilder.create()
                .uv(192, 15).cuboid(-1F, -1F, -1.5F, 2F, 2F, 3F, new Dilation(-0.2F)),
                ModelTransform.of(-4.9F, -1.2F, -1.2F, 0F, 0F, -0.95F));
        ModelPartData p14 = p1.addChild("charm", ModelPartBuilder.create()
                .uv(124, 22).cuboid(-0.5F, -0.4F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(94, 22).cuboid(-1F, 0.4F, -0.5F, 2F, 2F, 1F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.6F, -4.9F, 0.15F, 0F, 0F));
        ModelPartData p15 = p0.addChild("tail", ModelPartBuilder.create()
                .uv(18, 15).cuboid(-1.5F, -0.5F, -1.5F, 3F, 4F, 3F, new Dilation(-0.25F)),
                ModelTransform.of(0F, -4.2F, 1F, 0.95F, 0F, 0F));
        ModelPartData p16 = p15.addChild("tail2", ModelPartBuilder.create()
                .uv(126, 15).cuboid(-1.5F, 0F, -1.5F, 3F, 3F, 3F, new Dilation(-0.15F)),
                ModelTransform.of(0F, 3.2F, 0F, -0.75F, 0F, 0F));
        ModelPartData p17 = p16.addChild("tail3", ModelPartBuilder.create()
                .uv(138, 15).cuboid(-1.5F, 0F, -1.5F, 3F, 3F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 2.5F, 0F, -0.65F, 0F, 0F));
        ModelPartData p18 = p0.addChild("left_front_leg", ModelPartBuilder.create()
                .uv(30, 15).cuboid(-1.5F, -0.5F, -1.5F, 3F, 4F, 3F, new Dilation(-0.1F)),
                ModelTransform.of(2F, -1F, -6.3F, 0F, 0F, 0F));
        ModelPartData p19 = p18.addChild("paw", ModelPartBuilder.create()
                .uv(0, 22).cuboid(-1.5F, 0F, -1.9F, 3F, 1F, 3F, new Dilation(0.05F)),
                ModelTransform.of(0F, 3.2F, 0F, 0F, 0F, 0F));
        ModelPartData p20 = p0.addChild("right_front_leg", ModelPartBuilder.create()
                .uv(42, 15).cuboid(-1.5F, -0.5F, -1.5F, 3F, 4F, 3F, new Dilation(-0.1F)),
                ModelTransform.of(-2F, -1F, -6.3F, 0F, 0F, 0F));
        ModelPartData p21 = p20.addChild("paw", ModelPartBuilder.create()
                .uv(12, 22).cuboid(-1.5F, 0F, -1.9F, 3F, 1F, 3F, new Dilation(0.05F)),
                ModelTransform.of(0F, 3.2F, 0F, 0F, 0F, 0F));
        ModelPartData p22 = p0.addChild("left_hind_leg", ModelPartBuilder.create()
                .uv(54, 15).cuboid(-1.5F, -0.5F, -1.5F, 3F, 4F, 3F, new Dilation(-0.1F)),
                ModelTransform.of(2F, -1F, -0.8F, 0F, 0F, 0F));
        ModelPartData p23 = p22.addChild("paw", ModelPartBuilder.create()
                .uv(24, 22).cuboid(-1.5F, 0F, -1.9F, 3F, 1F, 3F, new Dilation(0.05F)),
                ModelTransform.of(0F, 3.2F, 0F, 0F, 0F, 0F));
        ModelPartData p24 = p0.addChild("right_hind_leg", ModelPartBuilder.create()
                .uv(66, 15).cuboid(-1.5F, -0.5F, -1.5F, 3F, 4F, 3F, new Dilation(-0.1F)),
                ModelTransform.of(-2F, -1F, -0.8F, 0F, 0F, 0F));
        ModelPartData p25 = p24.addChild("paw", ModelPartBuilder.create()
                .uv(36, 22).cuboid(-1.5F, 0F, -1.9F, 3F, 1F, 3F, new Dilation(0.05F)),
                ModelTransform.of(0F, 3.2F, 0F, 0F, 0F, 0F));
        return TexturedModelData.of(modelData, 256, 64);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float age, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        float c = entity.getCheerProgress();
        for (int i = 0; i < posed.length; i++) {
            float[] p = POSES[i];
            ModelPart part = posed[i];
            part.pivotX = MathHelper.lerp(c, p[0], p[6]);
            part.pivotY = MathHelper.lerp(c, p[1], p[7]);
            part.pivotZ = MathHelper.lerp(c, p[2], p[8]);
            part.pitch = MathHelper.lerp(c, p[3], p[9]);
            part.yaw = MathHelper.lerp(c, p[4], p[10]);
            part.roll = MathHelper.lerp(c, p[5], p[11]);
        }
        ModelPart head = posed[1], tail = posed[2];
        head.yaw += headYaw * ((float) Math.PI / 180F) * 0.7F;
        head.pitch += headPitch * ((float) Math.PI / 180F) * 0.5F;
        float swing = limbAngle * 0.6662F, d = Math.min(limbDistance, 1.0F) * (1.0F - c);
        posed[3].pitch += MathHelper.cos(swing) * 1.1F * d;
        posed[4].pitch += MathHelper.cos(swing + (float) Math.PI) * 1.1F * d;
        posed[5].pitch += MathHelper.cos(swing + (float) Math.PI) * 1.1F * d;
        posed[6].pitch += MathHelper.cos(swing) * 1.1F * d;
        // cheering: paws wave, body bounces a little
        posed[3].roll += MathHelper.sin(age * 0.6F) * 0.35F * c;
        posed[4].roll -= MathHelper.sin(age * 0.6F) * 0.35F * c;
        posed[0].pivotY -= Math.abs(MathHelper.sin(age * 0.3F)) * 0.8F * c;
        tail.yaw += MathHelper.sin(age * 0.12F) * 0.25F;
    }
}
