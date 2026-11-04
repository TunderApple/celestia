package com.celestia.client.model;

import com.celestia.entity.UnicornEntity;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.MathHelper;

/** Generated from the Celestia model sheet (256x128 texture, box UV). */
public class UnicornModel<T extends UnicornEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    protected final ModelPart neck, tail;
    protected final ModelPart leftFrontLeg, rightFrontLeg, leftHindLeg, rightHindLeg;
    protected final ModelPart leftFrontKnee, rightFrontKnee;

    public UnicornModel(ModelPart root) {
        this.root = root;
        ModelPart body = root.getChild("body");
        this.neck = body.getChild("neck");
        this.tail = body.getChild("tail0");
        this.leftFrontLeg = body.getChild("left_front_leg");
        this.rightFrontLeg = body.getChild("right_front_leg");
        this.leftHindLeg = body.getChild("left_hind_leg");
        this.rightHindLeg = body.getChild("right_hind_leg");
        this.leftFrontKnee = leftFrontLeg.getChild("knee");
        this.rightFrontKnee = rightFrontLeg.getChild("knee");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        ModelPartData p0 = root.addChild("body", ModelPartBuilder.create()
                .uv(38, 0).cuboid(-5.5F, -5.5F, -5F, 11F, 10F, 10F, new Dilation(0F))
                .uv(0, 0).cuboid(-4.5F, -6.5F, -5F, 9F, 12F, 10F, new Dilation(0F))
                .uv(206, 22).cuboid(-4F, -3F, -14F, 8F, 8F, 3F, new Dilation(-0.1F))
                .uv(142, 38).cuboid(-2.5F, -7.4F, -12F, 5F, 2F, 7F, new Dilation(0.2F))
                .uv(0, 22).cuboid(-4F, 4.2F, -9F, 8F, 2F, 14F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 3F, 0F, 0F, 0F, 0F));
        ModelPartData p1 = p0.addChild("chest", ModelPartBuilder.create()
                .uv(214, 0).cuboid(-5F, -5.5F, -7F, 10F, 10F, 7F, new Dilation(0F))
                .uv(114, 0).cuboid(-4F, -6.5F, -7F, 8F, 12F, 7F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, -5F, 0F, 0F, 0F));
        ModelPartData p2 = p0.addChild("hips", ModelPartBuilder.create()
                .uv(176, 0).cuboid(-5.5F, -6F, 0F, 11F, 10F, 8F, new Dilation(0F))
                .uv(80, 0).cuboid(-4.5F, -7F, 0F, 9F, 12F, 8F, new Dilation(0F))
                .uv(42, 49).cuboid(-3.5F, -7.4F, 1F, 7F, 2F, 6F, new Dilation(0.2F))
                .uv(166, 38).cuboid(-4F, -4.5F, 7.5F, 8F, 8F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5F, 0F, 0F, 0F));
        ModelPartData p3 = p0.addChild("neck", ModelPartBuilder.create()
                .uv(144, 0).cuboid(-4F, -10F, -4.5F, 8F, 11F, 8F, new Dilation(0F))
                .uv(228, 22).cuboid(-2.5F, -8F, -6F, 5F, 9F, 2F, new Dilation(-0.1F))
                .uv(88, 22).cuboid(-1F, -10.5F, 2.5F, 2F, 11F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, -3.5F, -10F, 0.62F, 0F, 0F));
        ModelPartData p4 = p3.addChild("neck_top", ModelPartBuilder.create()
                .uv(98, 22).cuboid(-3F, -8F, -3.5F, 6F, 8F, 6F, new Dilation(0.1F))
                .uv(152, 22).cuboid(-1F, -9F, 1.6F, 2F, 10F, 3F, new Dilation(0.05F)),
                ModelTransform.of(0F, -9F, -0.5F, -0.12F, 0F, 0F));
        ModelPartData p5 = p4.addChild("head", ModelPartBuilder.create()
                .uv(122, 22).cuboid(-3.5F, -5F, -5.5F, 7F, 6F, 8F, new Dilation(0F))
                .uv(202, 49).cuboid(-3F, -5.6F, -6.5F, 6F, 2F, 5F, new Dilation(-0.05F))
                .uv(184, 38).cuboid(-4F, -2F, -4.5F, 8F, 4F, 5F, new Dilation(-0.3F)),
                ModelTransform.of(0F, -7.5F, -0.5F, 0.3F, 0F, 0F));
        ModelPartData p6 = p5.addChild("muzzle", ModelPartBuilder.create()
                .uv(0, 38).cuboid(-2.5F, -3.5F, -6F, 5F, 5F, 6F, new Dilation(0F))
                .uv(62, 58).cuboid(-3F, -3F, -7.5F, 6F, 4F, 2F, new Dilation(-0.15F))
                .uv(224, 49).cuboid(-2F, 1.2F, -6.5F, 4F, 1F, 6F, new Dilation(0.1F)),
                ModelTransform.of(0F, -1F, -5.5F, 0.08F, 0F, 0F));
        ModelPartData p7 = p5.addChild("left_ear", ModelPartBuilder.create()
                .uv(78, 58).cuboid(-1F, -4F, -1F, 2F, 4F, 2F, new Dilation(0F))
                .uv(152, 65).cuboid(-0.5F, -5F, -0.5F, 1F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(2.3F, -5F, 0.5F, -0.25F, 0F, 0.32F));
        ModelPartData p8 = p5.addChild("right_ear", ModelPartBuilder.create()
                .uv(86, 58).cuboid(-1F, -4F, -1F, 2F, 4F, 2F, new Dilation(0F))
                .uv(156, 65).cuboid(-0.5F, -5F, -0.5F, 1F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(-2.3F, -5F, 0.5F, -0.25F, 0F, -0.32F));
        ModelPartData p9 = p5.addChild("forelock", ModelPartBuilder.create()
                .uv(0, 58).cuboid(-1.5F, -0.5F, -5F, 3F, 1F, 6F, new Dilation(0F))
                .uv(94, 58).cuboid(0.5F, -0.2F, -4F, 2F, 1F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(0F, -6F, -2F, 0.12F, 0F, 0F));
        ModelPartData p10 = p5.addChild("horn", ModelPartBuilder.create()
                .uv(132, 65).cuboid(-1.5F, -1F, -1.5F, 3F, 1F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, -6.2F, -3.8F, -0.12F, 0F, 0F));
        ModelPartData p11 = p10.addChild("horn0", ModelPartBuilder.create()
                .uv(0, 65).cuboid(-1.5F, -2F, -1.5F, 3F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -1F, 0F, 0F, 0.55F, 0F));
        ModelPartData p12 = p11.addChild("horn1", ModelPartBuilder.create()
                .uv(108, 58).cuboid(-1.5F, -3F, -1.5F, 3F, 3F, 3F, new Dilation(-0.35F)),
                ModelTransform.of(0F, -2F, 0F, 0F, 0.55F, 0F));
        ModelPartData p13 = p12.addChild("horn2", ModelPartBuilder.create()
                .uv(12, 65).cuboid(-1F, -3F, -1F, 2F, 3F, 2F, new Dilation(0.1F)),
                ModelTransform.of(0F, -3F, 0F, 0F, 0.55F, 0F));
        ModelPartData p14 = p13.addChild("horn3", ModelPartBuilder.create()
                .uv(20, 65).cuboid(-1F, -3F, -1F, 2F, 3F, 2F, new Dilation(-0.15F)),
                ModelTransform.of(0F, -3F, 0F, 0F, 0.55F, 0F));
        ModelPartData p15 = p14.addChild("horn4", ModelPartBuilder.create()
                .uv(28, 65).cuboid(-1F, -3F, -1F, 2F, 3F, 2F, new Dilation(-0.4F)),
                ModelTransform.of(0F, -3F, 0F, 0F, 0.55F, 0F));
        ModelPartData p16 = p15.addChild("horn5", ModelPartBuilder.create()
                .uv(144, 65).cuboid(-0.5F, -2F, -0.5F, 1F, 2F, 1F, new Dilation(0.05F)),
                ModelTransform.of(0F, -3F, 0F, 0F, 0.55F, 0F));
        ModelPartData p17 = p16.addChild("horn6", ModelPartBuilder.create()
                .uv(148, 65).cuboid(-0.5F, -2F, -0.5F, 1F, 2F, 1F, new Dilation(-0.2F)),
                ModelTransform.of(0F, -2F, 0F, 0F, 0.55F, 0F));
        ModelPartData p18 = p4.addChild("lock0", ModelPartBuilder.create()
                .uv(68, 49).cuboid(-1.5F, 0F, -2F, 3F, 4F, 4F, new Dilation(0F)),
                ModelTransform.of(0.8F, -9F, 2.2F, 0F, 0F, -0.16F));
        ModelPartData p19 = p18.addChild("tip", ModelPartBuilder.create()
                .uv(82, 49).cuboid(-1.25F, 0F, -1.5F, 2F, 5F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 3.5F, 0F, 0.21F, 0F, -0.35F));
        ModelPartData p20 = p4.addChild("lock1", ModelPartBuilder.create()
                .uv(210, 38).cuboid(-1.5F, 0F, -2F, 3F, 5F, 4F, new Dilation(0.06F)),
                ModelTransform.of(0.8F, -6.5F, 2.2F, 0.05F, 0F, -0.16F));
        ModelPartData p21 = p20.addChild("tip", ModelPartBuilder.create()
                .uv(92, 49).cuboid(-1.25F, 0F, -1.5F, 2F, 5F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 4.5F, 0F, 0.21F, 0F, -0.35F));
        ModelPartData p22 = p4.addChild("lock2", ModelPartBuilder.create()
                .uv(224, 38).cuboid(-1.5F, 0F, -2F, 3F, 5F, 4F, new Dilation(0F)),
                ModelTransform.of(0.8F, -4F, 2.2F, 0F, 0F, -0.16F));
        ModelPartData p23 = p22.addChild("tip", ModelPartBuilder.create()
                .uv(102, 49).cuboid(-1.25F, 0F, -1.5F, 2F, 5F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 4.5F, 0F, 0.21F, 0F, -0.35F));
        ModelPartData p24 = p4.addChild("lock0_1", ModelPartBuilder.create()
                .uv(18, 58).cuboid(-1F, 0F, -2F, 2F, 3F, 4F, new Dilation(0F)),
                ModelTransform.of(-0.8F, -7F, 2.4F, 0F, 0F, 0.1F));
        ModelPartData p25 = p24.addChild("tip", ModelPartBuilder.create()
                .uv(120, 58).cuboid(-0.75F, 0F, -1.5F, 2F, 3F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 2.5F, 0F, 0.15F, 0F, 0.25F));
        ModelPartData p26 = p3.addChild("lock0", ModelPartBuilder.create()
                .uv(22, 38).cuboid(-1.5F, 0F, -2F, 3F, 6F, 4F, new Dilation(0F)),
                ModelTransform.of(0.8F, -10.5F, 3.2F, 0F, 0F, -0.16F));
        ModelPartData p27 = p26.addChild("tip", ModelPartBuilder.create()
                .uv(112, 49).cuboid(-1.25F, 0F, -1.5F, 2F, 5F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 5.5F, 0F, 0.21F, 0F, -0.35F));
        ModelPartData p28 = p3.addChild("lock1", ModelPartBuilder.create()
                .uv(36, 38).cuboid(-1.5F, 0F, -2F, 3F, 6F, 4F, new Dilation(0.06F)),
                ModelTransform.of(0.8F, -8F, 3.2F, 0.05F, 0F, -0.16F));
        ModelPartData p29 = p28.addChild("tip", ModelPartBuilder.create()
                .uv(238, 38).cuboid(-1.25F, 0F, -1.5F, 2F, 6F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 5.5F, 0F, 0.21F, 0F, -0.35F));
        ModelPartData p30 = p3.addChild("lock2", ModelPartBuilder.create()
                .uv(50, 38).cuboid(-1.5F, 0F, -2F, 3F, 6F, 4F, new Dilation(0F)),
                ModelTransform.of(0.8F, -5.5F, 3.2F, 0F, 0F, -0.16F));
        ModelPartData p31 = p30.addChild("tip", ModelPartBuilder.create()
                .uv(0, 49).cuboid(-1.25F, 0F, -1.5F, 2F, 6F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 5.5F, 0F, 0.21F, 0F, -0.35F));
        ModelPartData p32 = p3.addChild("lock3", ModelPartBuilder.create()
                .uv(64, 38).cuboid(-1.5F, 0F, -2F, 3F, 6F, 4F, new Dilation(0.06F)),
                ModelTransform.of(0.8F, -3F, 3.2F, 0.05F, 0F, -0.16F));
        ModelPartData p33 = p32.addChild("tip", ModelPartBuilder.create()
                .uv(122, 49).cuboid(-1.25F, 0F, -1.5F, 2F, 5F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 5.5F, 0F, 0.21F, 0F, -0.35F));
        ModelPartData p34 = p3.addChild("lock0_1", ModelPartBuilder.create()
                .uv(30, 58).cuboid(-1F, 0F, -2F, 2F, 3F, 4F, new Dilation(0F)),
                ModelTransform.of(-0.8F, -9.5F, 3.4F, 0F, 0F, 0.1F));
        ModelPartData p35 = p34.addChild("tip", ModelPartBuilder.create()
                .uv(42, 58).cuboid(-0.75F, 0F, -1.5F, 2F, 4F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 2.5F, 0F, 0.15F, 0F, 0.25F));
        ModelPartData p36 = p3.addChild("lock1_1", ModelPartBuilder.create()
                .uv(132, 49).cuboid(-1F, 0F, -2F, 2F, 4F, 4F, new Dilation(0.06F)),
                ModelTransform.of(-0.8F, -6F, 3.4F, 0.05F, 0F, 0.1F));
        ModelPartData p37 = p36.addChild("tip", ModelPartBuilder.create()
                .uv(52, 58).cuboid(-0.75F, 0F, -1.5F, 2F, 4F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 3.5F, 0F, 0.15F, 0F, 0.25F));
        ModelPartData p38 = p0.addChild("tail0", ModelPartBuilder.create()
                .uv(144, 49).cuboid(-1.5F, -1F, -1.5F, 3F, 5F, 3F, new Dilation(0.12F)),
                ModelTransform.of(0F, -5.5F, 12.5F, 0.9F, 0F, 0F));
        ModelPartData p39 = p38.addChild("tail1", ModelPartBuilder.create()
                .uv(78, 38).cuboid(-2F, 0F, -2F, 4F, 6F, 4F, new Dilation(0F)),
                ModelTransform.of(0F, 4F, 0F, -0.35F, 0F, 0F));
        ModelPartData p40 = p39.addChild("tail2", ModelPartBuilder.create()
                .uv(162, 22).cuboid(-3F, 0F, -2.5F, 6F, 7F, 5F, new Dilation(0.12F)),
                ModelTransform.of(0F, 5.5F, 0F, -0.3F, 0F, 0F));
        ModelPartData p41 = p40.addChild("tail3", ModelPartBuilder.create()
                .uv(184, 22).cuboid(-3F, 0F, -2.5F, 6F, 7F, 5F, new Dilation(0F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.22F, 0F, 0F));
        ModelPartData p42 = p41.addChild("tail4", ModelPartBuilder.create()
                .uv(156, 49).cuboid(-2F, 0F, -1.5F, 4F, 5F, 3F, new Dilation(0.12F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.1F, 0F, 0F));
        ModelPartData p43 = p0.addChild("left_front_leg", ModelPartBuilder.create()
                .uv(10, 49).cuboid(-2F, -2F, -2.25F, 4F, 5F, 4F, new Dilation(0.35F))
                .uv(94, 38).cuboid(-1.5F, 0F, -1.5F, 3F, 7F, 3F, new Dilation(0.35F)),
                ModelTransform.of(3.1F, 3F, -8F, -0.04F, 0F, 0F));
        ModelPartData p44 = p43.addChild("knee", ModelPartBuilder.create()
                .uv(36, 65).cuboid(-1.75F, -0.6F, -1.75F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(170, 49).cuboid(-1F, 1F, -1F, 2F, 6F, 2F, new Dilation(0.45F)),
                ModelTransform.of(0F, 7.5F, 0F, 0.04F, 0F, 0F));
        ModelPartData p45 = p44.addChild("hoof", ModelPartBuilder.create()
                .uv(48, 65).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(130, 58).cuboid(-2F, -0.2F, -2F, 4F, 2F, 4F, new Dilation(0.05F))
                .uv(146, 58).cuboid(-1.75F, 1.3F, -2.1F, 3F, 2F, 4F, new Dilation(0.25F)),
                ModelTransform.of(0F, 7F, 0F, 0F, 0F, 0F));
        ModelPartData p46 = p0.addChild("right_front_leg", ModelPartBuilder.create()
                .uv(26, 49).cuboid(-2F, -2F, -2.25F, 4F, 5F, 4F, new Dilation(0.35F))
                .uv(106, 38).cuboid(-1.5F, 0F, -1.5F, 3F, 7F, 3F, new Dilation(0.35F)),
                ModelTransform.of(-3.1F, 3F, -8F, -0.04F, 0F, 0F));
        ModelPartData p47 = p46.addChild("knee", ModelPartBuilder.create()
                .uv(60, 65).cuboid(-1.75F, -0.6F, -1.75F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(178, 49).cuboid(-1F, 1F, -1F, 2F, 6F, 2F, new Dilation(0.45F)),
                ModelTransform.of(0F, 7.5F, 0F, 0.04F, 0F, 0F));
        ModelPartData p48 = p47.addChild("hoof", ModelPartBuilder.create()
                .uv(72, 65).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(160, 58).cuboid(-2F, -0.2F, -2F, 4F, 2F, 4F, new Dilation(0.05F))
                .uv(176, 58).cuboid(-1.75F, 1.3F, -2.1F, 3F, 2F, 4F, new Dilation(0.25F)),
                ModelTransform.of(0F, 7F, 0F, 0F, 0F, 0F));
        ModelPartData p49 = p0.addChild("left_hind_leg", ModelPartBuilder.create()
                .uv(44, 22).cuboid(-2.5F, -3.5F, -3.5F, 5F, 9F, 6F, new Dilation(0.1F)),
                ModelTransform.of(3.3F, 1F, 8F, -0.25F, 0F, 0F));
        ModelPartData p50 = p49.addChild("gaskin", ModelPartBuilder.create()
                .uv(118, 38).cuboid(-1.5F, -0.5F, -1.75F, 3F, 7F, 3F, new Dilation(0.3F)),
                ModelTransform.of(0F, 5F, -0.5F, 0.6F, 0F, 0F));
        ModelPartData p51 = p50.addChild("hock", ModelPartBuilder.create()
                .uv(84, 65).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.1F))
                .uv(186, 49).cuboid(-1F, 1F, -1F, 2F, 6F, 2F, new Dilation(0.45F)),
                ModelTransform.of(0F, 6F, 0F, -0.35F, 0F, 0F));
        ModelPartData p52 = p51.addChild("hoof", ModelPartBuilder.create()
                .uv(96, 65).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(190, 58).cuboid(-2F, -0.2F, -2F, 4F, 2F, 4F, new Dilation(0.05F))
                .uv(206, 58).cuboid(-1.75F, 0.8F, -2.1F, 3F, 2F, 4F, new Dilation(0.25F)),
                ModelTransform.of(0F, 6.5F, 0F, 0F, 0F, 0F));
        ModelPartData p53 = p0.addChild("right_hind_leg", ModelPartBuilder.create()
                .uv(66, 22).cuboid(-2.5F, -3.5F, -3.5F, 5F, 9F, 6F, new Dilation(0.1F)),
                ModelTransform.of(-3.3F, 1F, 8F, -0.25F, 0F, 0F));
        ModelPartData p54 = p53.addChild("gaskin", ModelPartBuilder.create()
                .uv(130, 38).cuboid(-1.5F, -0.5F, -1.75F, 3F, 7F, 3F, new Dilation(0.3F)),
                ModelTransform.of(0F, 5F, -0.5F, 0.6F, 0F, 0F));
        ModelPartData p55 = p54.addChild("hock", ModelPartBuilder.create()
                .uv(108, 65).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.1F))
                .uv(194, 49).cuboid(-1F, 1F, -1F, 2F, 6F, 2F, new Dilation(0.45F)),
                ModelTransform.of(0F, 6F, 0F, -0.35F, 0F, 0F));
        ModelPartData p56 = p55.addChild("hoof", ModelPartBuilder.create()
                .uv(120, 65).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(220, 58).cuboid(-2F, -0.2F, -2F, 4F, 2F, 4F, new Dilation(0.05F))
                .uv(236, 58).cuboid(-1.75F, 0.8F, -2.1F, 3F, 2F, 4F, new Dilation(0.25F)),
                ModelTransform.of(0F, 6.5F, 0F, 0F, 0F, 0F));
        return TexturedModelData.of(modelData, 256, 128);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        animateBody(limbAngle, limbDistance, animationProgress, headYaw, headPitch);
    }

    protected void animateBody(float limbAngle, float limbDistance, float age, float headYaw, float headPitch) {
        float swing = limbAngle * 0.6662F;
        float d = Math.min(limbDistance, 1.0F);
        float fl = MathHelper.cos(swing) * 1.0F * d;
        float fr = MathHelper.cos(swing + (float) Math.PI) * 1.0F * d;
        leftFrontLeg.pitch += fl;
        rightFrontLeg.pitch += fr;
        leftHindLeg.pitch += fr * 0.8F;
        rightHindLeg.pitch += fl * 0.8F;
        leftFrontKnee.pitch += Math.max(0.0F, -fl) * 0.9F;
        rightFrontKnee.pitch += Math.max(0.0F, -fr) * 0.9F;
        neck.pitch += headPitch * ((float) Math.PI / 180F) * 0.5F;
        neck.yaw += headYaw * ((float) Math.PI / 180F) * 0.6F;
        neck.pitch += MathHelper.sin(age * 0.05F) * 0.02F;
        tail.yaw += MathHelper.sin(age * 0.067F) * 0.08F + fr * 0.15F;
        tail.pitch += d * 0.35F;
    }
}
