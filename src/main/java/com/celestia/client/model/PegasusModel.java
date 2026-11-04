package com.celestia.client.model;

import com.celestia.entity.PegasusEntity;

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
public class PegasusModel<T extends PegasusEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root;
    protected final ModelPart neck, tail;
    protected final ModelPart leftFrontLeg, rightFrontLeg, leftHindLeg, rightHindLeg;
    protected final ModelPart leftFrontKnee, rightFrontKnee;
    protected final ModelPart leftWing, leftForearm, leftHand, rightWing, rightForearm, rightHand;

    public PegasusModel(ModelPart root) {
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
        ModelPart b = root.getChild("body");
        this.leftWing = b.getChild("left_wing");
        this.leftForearm = leftWing.getChild("forearm");
        this.leftHand = leftForearm.getChild("hand");
        this.rightWing = b.getChild("right_wing");
        this.rightForearm = rightWing.getChild("forearm");
        this.rightHand = rightForearm.getChild("hand");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        ModelPartData p0 = root.addChild("body", ModelPartBuilder.create()
                .uv(38, 0).cuboid(-5.5F, -5.5F, -5F, 11F, 10F, 10F, new Dilation(0F))
                .uv(0, 0).cuboid(-4.5F, -6.5F, -5F, 9F, 12F, 10F, new Dilation(0F))
                .uv(0, 86).cuboid(-4F, -3F, -14F, 8F, 8F, 3F, new Dilation(-0.1F))
                .uv(136, 86).cuboid(-2.5F, -7.4F, -12F, 5F, 2F, 7F, new Dilation(0.2F))
                .uv(110, 41).cuboid(-4F, 4.2F, -9F, 8F, 2F, 14F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 3F, 0F, 0F, 0F, 0F));
        ModelPartData p1 = p0.addChild("chest", ModelPartBuilder.create()
                .uv(0, 41).cuboid(-5F, -5.5F, -7F, 10F, 10F, 7F, new Dilation(0F))
                .uv(114, 0).cuboid(-4F, -6.5F, -7F, 8F, 12F, 7F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, -5F, 0F, 0F, 0F));
        ModelPartData p2 = p0.addChild("hips", ModelPartBuilder.create()
                .uv(42, 22).cuboid(-5.5F, -6F, 0F, 11F, 10F, 8F, new Dilation(0F))
                .uv(80, 0).cuboid(-4.5F, -7F, 0F, 9F, 12F, 8F, new Dilation(0F))
                .uv(0, 97).cuboid(-3.5F, -7.4F, 1F, 7F, 2F, 6F, new Dilation(0.2F))
                .uv(160, 86).cuboid(-4F, -4.5F, 7.5F, 8F, 8F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5F, 0F, 0F, 0F));
        ModelPartData p3 = p0.addChild("neck", ModelPartBuilder.create()
                .uv(144, 0).cuboid(-4F, -10F, -4.5F, 8F, 11F, 8F, new Dilation(0F))
                .uv(22, 86).cuboid(-2.5F, -8F, -6F, 5F, 9F, 2F, new Dilation(-0.1F))
                .uv(90, 58).cuboid(-1F, -10.5F, 2.5F, 2F, 11F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, -3.5F, -10F, 0.62F, 0F, 0F));
        ModelPartData p4 = p3.addChild("neck_top", ModelPartBuilder.create()
                .uv(100, 58).cuboid(-3F, -8F, -3.5F, 6F, 8F, 6F, new Dilation(0.1F))
                .uv(218, 58).cuboid(-1F, -9F, 1.6F, 2F, 10F, 3F, new Dilation(0.05F)),
                ModelTransform.of(0F, -9F, -0.5F, -0.12F, 0F, 0F));
        ModelPartData p5 = p4.addChild("head", ModelPartBuilder.create()
                .uv(124, 58).cuboid(-3.5F, -5F, -5.5F, 7F, 6F, 8F, new Dilation(0F))
                .uv(84, 97).cuboid(-3F, -5.6F, -6.5F, 6F, 2F, 5F, new Dilation(-0.05F))
                .uv(178, 86).cuboid(-4F, -2F, -4.5F, 8F, 4F, 5F, new Dilation(-0.3F)),
                ModelTransform.of(0F, -7.5F, -0.5F, 0.3F, 0F, 0F));
        ModelPartData p6 = p5.addChild("muzzle", ModelPartBuilder.create()
                .uv(36, 86).cuboid(-2.5F, -3.5F, -6F, 5F, 5F, 6F, new Dilation(0F))
                .uv(0, 105).cuboid(-3F, -3F, -7.5F, 6F, 4F, 2F, new Dilation(-0.15F))
                .uv(106, 97).cuboid(-2F, 1.2F, -6.5F, 4F, 1F, 6F, new Dilation(0.1F)),
                ModelTransform.of(0F, -1F, -5.5F, 0.08F, 0F, 0F));
        ModelPartData p7 = p5.addChild("left_ear", ModelPartBuilder.create()
                .uv(16, 105).cuboid(-1F, -4F, -1F, 2F, 4F, 2F, new Dilation(0F))
                .uv(108, 117).cuboid(-0.5F, -5F, -0.5F, 1F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(2.3F, -5F, 0.5F, -0.25F, 0F, 0.32F));
        ModelPartData p8 = p5.addChild("right_ear", ModelPartBuilder.create()
                .uv(24, 105).cuboid(-1F, -4F, -1F, 2F, 4F, 2F, new Dilation(0F))
                .uv(112, 117).cuboid(-0.5F, -5F, -0.5F, 1F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(-2.3F, -5F, 0.5F, -0.25F, 0F, -0.32F));
        ModelPartData p9 = p5.addChild("forelock", ModelPartBuilder.create()
                .uv(126, 97).cuboid(-1.5F, -0.5F, -5F, 3F, 1F, 6F, new Dilation(0F))
                .uv(32, 105).cuboid(0.5F, -0.2F, -4F, 2F, 1F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(0F, -6F, -2F, 0.12F, 0F, 0F));
        ModelPartData p10 = p4.addChild("lock0", ModelPartBuilder.create()
                .uv(144, 97).cuboid(-1.5F, 0F, -2F, 3F, 3F, 4F, new Dilation(0F)),
                ModelTransform.of(0.8F, -8F, 2F, 0F, 0F, -0.1F));
        ModelPartData p11 = p10.addChild("tip", ModelPartBuilder.create()
                .uv(46, 105).cuboid(-1.25F, 0F, -1.5F, 2F, 3F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 2.5F, 0F, 0.3F, 0F, -0.5F));
        ModelPartData p12 = p4.addChild("lock1", ModelPartBuilder.create()
                .uv(158, 97).cuboid(-1.5F, 0F, -2F, 3F, 3F, 4F, new Dilation(0.06F)),
                ModelTransform.of(0.8F, -5F, 2F, 0.05F, 0F, -0.1F));
        ModelPartData p13 = p12.addChild("tip", ModelPartBuilder.create()
                .uv(172, 97).cuboid(-1.25F, 0F, -1.5F, 2F, 4F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 2.5F, 0F, 0.3F, 0F, -0.5F));
        ModelPartData p14 = p3.addChild("lock0", ModelPartBuilder.create()
                .uv(182, 97).cuboid(-1.5F, 0F, -2F, 3F, 3F, 4F, new Dilation(0F)),
                ModelTransform.of(0.8F, -10F, 3F, 0F, 0F, -0.1F));
        ModelPartData p15 = p14.addChild("tip", ModelPartBuilder.create()
                .uv(196, 97).cuboid(-1.25F, 0F, -1.5F, 2F, 4F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 2.5F, 0F, 0.3F, 0F, -0.5F));
        ModelPartData p16 = p3.addChild("lock1", ModelPartBuilder.create()
                .uv(26, 97).cuboid(-1.5F, 0F, -2F, 3F, 4F, 4F, new Dilation(0.06F)),
                ModelTransform.of(0.8F, -7F, 3F, 0.05F, 0F, -0.1F));
        ModelPartData p17 = p16.addChild("tip", ModelPartBuilder.create()
                .uv(206, 97).cuboid(-1.25F, 0F, -1.5F, 2F, 4F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 3.5F, 0F, 0.3F, 0F, -0.5F));
        ModelPartData p18 = p3.addChild("lock2", ModelPartBuilder.create()
                .uv(216, 97).cuboid(-1.5F, 0F, -2F, 3F, 3F, 4F, new Dilation(0F)),
                ModelTransform.of(0.8F, -4F, 3F, 0F, 0F, -0.1F));
        ModelPartData p19 = p18.addChild("tip", ModelPartBuilder.create()
                .uv(230, 97).cuboid(-1.25F, 0F, -1.5F, 2F, 4F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 2.5F, 0F, 0.3F, 0F, -0.5F));
        ModelPartData p20 = p0.addChild("tail0", ModelPartBuilder.create()
                .uv(40, 97).cuboid(-1.5F, -1F, -1.5F, 3F, 5F, 3F, new Dilation(0.12F)),
                ModelTransform.of(0F, -5.5F, 12.5F, 0.9F, 0F, 0F));
        ModelPartData p21 = p20.addChild("tail1", ModelPartBuilder.create()
                .uv(58, 86).cuboid(-2F, 0F, -2F, 4F, 6F, 4F, new Dilation(0F)),
                ModelTransform.of(0F, 4F, 0F, -0.35F, 0F, 0F));
        ModelPartData p22 = p21.addChild("tail2", ModelPartBuilder.create()
                .uv(120, 73).cuboid(-2.5F, 0F, -2.5F, 5F, 7F, 5F, new Dilation(0.12F)),
                ModelTransform.of(0F, 5.5F, 0F, -0.3F, 0F, 0F));
        ModelPartData p23 = p22.addChild("tail3", ModelPartBuilder.create()
                .uv(74, 86).cuboid(-2F, 0F, -1.5F, 4F, 7F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.22F, 0F, 0F));
        ModelPartData p24 = p23.addChild("tail4", ModelPartBuilder.create()
                .uv(240, 97).cuboid(-1.5F, 0F, -1.5F, 3F, 4F, 3F, new Dilation(0.12F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.1F, 0F, 0F));
        ModelPartData p25 = p0.addChild("left_front_leg", ModelPartBuilder.create()
                .uv(204, 86).cuboid(-2F, -2F, -2.25F, 4F, 5F, 4F, new Dilation(0.35F))
                .uv(88, 86).cuboid(-1.5F, 0F, -1.5F, 3F, 7F, 3F, new Dilation(0.35F)),
                ModelTransform.of(3.1F, 3F, -8F, -0.04F, 0F, 0F));
        ModelPartData p26 = p25.addChild("knee", ModelPartBuilder.create()
                .uv(118, 111).cuboid(-1.75F, -0.6F, -1.75F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(52, 97).cuboid(-1F, 1F, -1F, 2F, 6F, 2F, new Dilation(0.45F)),
                ModelTransform.of(0F, 7.5F, 0F, 0.04F, 0F, 0F));
        ModelPartData p27 = p26.addChild("hoof", ModelPartBuilder.create()
                .uv(130, 111).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(56, 105).cuboid(-2F, -0.2F, -2F, 4F, 2F, 4F, new Dilation(0.05F))
                .uv(72, 105).cuboid(-1.75F, 1.3F, -2.1F, 3F, 2F, 4F, new Dilation(0.25F)),
                ModelTransform.of(0F, 7F, 0F, 0F, 0F, 0F));
        ModelPartData p28 = p0.addChild("right_front_leg", ModelPartBuilder.create()
                .uv(220, 86).cuboid(-2F, -2F, -2.25F, 4F, 5F, 4F, new Dilation(0.35F))
                .uv(100, 86).cuboid(-1.5F, 0F, -1.5F, 3F, 7F, 3F, new Dilation(0.35F)),
                ModelTransform.of(-3.1F, 3F, -8F, -0.04F, 0F, 0F));
        ModelPartData p29 = p28.addChild("knee", ModelPartBuilder.create()
                .uv(142, 111).cuboid(-1.75F, -0.6F, -1.75F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(60, 97).cuboid(-1F, 1F, -1F, 2F, 6F, 2F, new Dilation(0.45F)),
                ModelTransform.of(0F, 7.5F, 0F, 0.04F, 0F, 0F));
        ModelPartData p30 = p29.addChild("hoof", ModelPartBuilder.create()
                .uv(154, 111).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(86, 105).cuboid(-2F, -0.2F, -2F, 4F, 2F, 4F, new Dilation(0.05F))
                .uv(102, 105).cuboid(-1.75F, 1.3F, -2.1F, 3F, 2F, 4F, new Dilation(0.25F)),
                ModelTransform.of(0F, 7F, 0F, 0F, 0F, 0F));
        ModelPartData p31 = p0.addChild("left_hind_leg", ModelPartBuilder.create()
                .uv(226, 41).cuboid(-2.5F, -3.5F, -3.5F, 5F, 9F, 6F, new Dilation(0.1F)),
                ModelTransform.of(3.3F, 1F, 8F, -0.25F, 0F, 0F));
        ModelPartData p32 = p31.addChild("gaskin", ModelPartBuilder.create()
                .uv(112, 86).cuboid(-1.5F, -0.5F, -1.75F, 3F, 7F, 3F, new Dilation(0.3F)),
                ModelTransform.of(0F, 5F, -0.5F, 0.6F, 0F, 0F));
        ModelPartData p33 = p32.addChild("hock", ModelPartBuilder.create()
                .uv(166, 111).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.1F))
                .uv(68, 97).cuboid(-1F, 1F, -1F, 2F, 6F, 2F, new Dilation(0.45F)),
                ModelTransform.of(0F, 6F, 0F, -0.35F, 0F, 0F));
        ModelPartData p34 = p33.addChild("hoof", ModelPartBuilder.create()
                .uv(178, 111).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(116, 105).cuboid(-2F, -0.2F, -2F, 4F, 2F, 4F, new Dilation(0.05F))
                .uv(132, 105).cuboid(-1.75F, 0.8F, -2.1F, 3F, 2F, 4F, new Dilation(0.25F)),
                ModelTransform.of(0F, 6.5F, 0F, 0F, 0F, 0F));
        ModelPartData p35 = p0.addChild("right_hind_leg", ModelPartBuilder.create()
                .uv(0, 58).cuboid(-2.5F, -3.5F, -3.5F, 5F, 9F, 6F, new Dilation(0.1F)),
                ModelTransform.of(-3.3F, 1F, 8F, -0.25F, 0F, 0F));
        ModelPartData p36 = p35.addChild("gaskin", ModelPartBuilder.create()
                .uv(124, 86).cuboid(-1.5F, -0.5F, -1.75F, 3F, 7F, 3F, new Dilation(0.3F)),
                ModelTransform.of(0F, 5F, -0.5F, 0.6F, 0F, 0F));
        ModelPartData p37 = p36.addChild("hock", ModelPartBuilder.create()
                .uv(190, 111).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.1F))
                .uv(76, 97).cuboid(-1F, 1F, -1F, 2F, 6F, 2F, new Dilation(0.45F)),
                ModelTransform.of(0F, 6F, 0F, -0.35F, 0F, 0F));
        ModelPartData p38 = p37.addChild("hoof", ModelPartBuilder.create()
                .uv(202, 111).cuboid(-1.5F, -0.6F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(146, 105).cuboid(-2F, -0.2F, -2F, 4F, 2F, 4F, new Dilation(0.05F))
                .uv(162, 105).cuboid(-1.75F, 0.8F, -2.1F, 3F, 2F, 4F, new Dilation(0.25F)),
                ModelTransform.of(0F, 6.5F, 0F, 0F, 0F, 0F));
        ModelPartData p39 = p0.addChild("left_wing", ModelPartBuilder.create()
                .uv(176, 105).cuboid(0F, -1.5F, -1.5F, 7F, 3F, 3F, new Dilation(0F))
                .uv(196, 105).cuboid(0F, -0.6F, 1F, 7F, 1F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(4.5F, -6.5F, -6.5F, 0.1F, -0.3F, -0.68F));
        ModelPartData p40 = p39.addChild("forearm", ModelPartBuilder.create()
                .uv(28, 117).cuboid(0F, -1F, -1F, 10F, 2F, 2F, new Dilation(-0.1F))
                .uv(220, 105).cuboid(0F, -0.8F, 0.4F, 10F, 1F, 5F, new Dilation(-0.15F))
                .uv(214, 111).cuboid(0F, -0.3F, 3F, 10F, 1F, 4F, new Dilation(-0.2F)),
                ModelTransform.of(7F, 0F, 0F, 0F, 0.5F, -0.2F));
        ModelPartData p41 = p40.addChild("sec0", ModelPartBuilder.create()
                .uv(140, 73).cuboid(-1F, -0.5F, 0F, 3F, 1F, 11F, new Dilation(-0.3F)),
                ModelTransform.of(1F, 0.3F, 0.6F, 0F, 0F, 0F));
        ModelPartData p42 = p40.addChild("sec1", ModelPartBuilder.create()
                .uv(0, 73).cuboid(-1F, -0.5F, 0F, 3F, 1F, 12F, new Dilation(-0.3F)),
                ModelTransform.of(3F, 0.42F, 0.6F, 0F, -0.05F, 0F));
        ModelPartData p43 = p40.addChild("sec2", ModelPartBuilder.create()
                .uv(154, 58).cuboid(-1F, -0.5F, 0F, 3F, 1F, 13F, new Dilation(-0.3F)),
                ModelTransform.of(5F, 0.54F, 0.6F, 0F, -0.1F, 0F));
        ModelPartData p44 = p40.addChild("sec3", ModelPartBuilder.create()
                .uv(168, 73).cuboid(-1F, -0.5F, 0F, 3F, 1F, 11F, new Dilation(-0.3F)),
                ModelTransform.of(7F, 0.66F, 0.6F, 0F, -0.15F, 0F));
        ModelPartData p45 = p40.addChild("sec4", ModelPartBuilder.create()
                .uv(30, 73).cuboid(-1F, -0.5F, 0F, 3F, 1F, 12F, new Dilation(-0.3F)),
                ModelTransform.of(9F, 0.78F, 0.6F, 0F, -0.2F, 0F));
        ModelPartData p46 = p40.addChild("hand", ModelPartBuilder.create()
                .uv(52, 117).cuboid(0F, -0.75F, -0.75F, 6F, 2F, 2F, new Dilation(-0.2F))
                .uv(0, 111).cuboid(0F, -0.9F, 0.3F, 6F, 1F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(10F, 0F, 0F, 0F, -0.75F, 0.12F));
        ModelPartData p47 = p46.addChild("prim0", ModelPartBuilder.create()
                .uv(22, 58).cuboid(-1F, -0.5F, 0F, 3F, 1F, 14F, new Dilation(-0.3F)),
                ModelTransform.of(0.6F, 0.25F, 0.4F, 0F, 0.12F, 0F));
        ModelPartData p48 = p46.addChild("prim1", ModelPartBuilder.create()
                .uv(34, 41).cuboid(-1F, -0.5F, 0F, 3F, 1F, 16F, new Dilation(-0.3F)),
                ModelTransform.of(1.65F, 0.37F, 0.4F, 0F, 0.36F, 0F));
        ModelPartData p49 = p46.addChild("prim2", ModelPartBuilder.create()
                .uv(80, 22).cuboid(-1F, -0.5F, 0F, 3F, 1F, 17F, new Dilation(-0.3F)),
                ModelTransform.of(2.7F, 0.49F, 0.4F, 0F, 0.6F, 0F));
        ModelPartData p50 = p46.addChild("prim3", ModelPartBuilder.create()
                .uv(176, 0).cuboid(-1F, -0.5F, 0F, 3F, 1F, 18F, new Dilation(-0.3F)),
                ModelTransform.of(3.75F, 0.61F, 0.4F, 0F, 0.84F, 0F));
        ModelPartData p51 = p46.addChild("prim4", ModelPartBuilder.create()
                .uv(120, 22).cuboid(-1F, -0.5F, 0F, 3F, 1F, 17F, new Dilation(-0.3F)),
                ModelTransform.of(4.8F, 0.73F, 0.4F, 0F, 1.08F, 0F));
        ModelPartData p52 = p46.addChild("prim5", ModelPartBuilder.create()
                .uv(154, 41).cuboid(-1F, -0.5F, 0F, 3F, 1F, 15F, new Dilation(-0.3F)),
                ModelTransform.of(5.85F, 0.85F, 0.4F, 0F, 1.32F, 0F));
        ModelPartData p53 = p0.addChild("right_wing", ModelPartBuilder.create()
                .uv(22, 111).cuboid(-7F, -1.5F, -1.5F, 7F, 3F, 3F, new Dilation(0F))
                .uv(42, 111).cuboid(-7F, -0.6F, 1F, 7F, 1F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(-4.5F, -6.5F, -6.5F, 0.1F, 0.3F, 0.68F));
        ModelPartData p54 = p53.addChild("forearm", ModelPartBuilder.create()
                .uv(68, 117).cuboid(-10F, -1F, -1F, 10F, 2F, 2F, new Dilation(-0.1F))
                .uv(66, 111).cuboid(-10F, -0.8F, 0.4F, 10F, 1F, 5F, new Dilation(-0.15F))
                .uv(0, 117).cuboid(-10F, -0.3F, 3F, 10F, 1F, 4F, new Dilation(-0.2F)),
                ModelTransform.of(-7F, 0F, 0F, 0F, -0.5F, 0.2F));
        ModelPartData p55 = p54.addChild("sec0", ModelPartBuilder.create()
                .uv(196, 73).cuboid(-1F, -0.5F, 0F, 3F, 1F, 11F, new Dilation(-0.3F)),
                ModelTransform.of(-1F, 0.3F, 0.6F, 0F, 0F, 0F));
        ModelPartData p56 = p54.addChild("sec1", ModelPartBuilder.create()
                .uv(60, 73).cuboid(-1F, -0.5F, 0F, 3F, 1F, 12F, new Dilation(-0.3F)),
                ModelTransform.of(-3F, 0.42F, 0.6F, 0F, 0.05F, 0F));
        ModelPartData p57 = p54.addChild("sec2", ModelPartBuilder.create()
                .uv(186, 58).cuboid(-1F, -0.5F, 0F, 3F, 1F, 13F, new Dilation(-0.3F)),
                ModelTransform.of(-5F, 0.54F, 0.6F, 0F, 0.1F, 0F));
        ModelPartData p58 = p54.addChild("sec3", ModelPartBuilder.create()
                .uv(224, 73).cuboid(-1F, -0.5F, 0F, 3F, 1F, 11F, new Dilation(-0.3F)),
                ModelTransform.of(-7F, 0.66F, 0.6F, 0F, 0.15F, 0F));
        ModelPartData p59 = p54.addChild("sec4", ModelPartBuilder.create()
                .uv(90, 73).cuboid(-1F, -0.5F, 0F, 3F, 1F, 12F, new Dilation(-0.3F)),
                ModelTransform.of(-9F, 0.78F, 0.6F, 0F, 0.2F, 0F));
        ModelPartData p60 = p54.addChild("hand", ModelPartBuilder.create()
                .uv(92, 117).cuboid(-6F, -0.75F, -0.75F, 6F, 2F, 2F, new Dilation(-0.2F))
                .uv(96, 111).cuboid(-6F, -0.9F, 0.3F, 6F, 1F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(-10F, 0F, 0F, 0F, 0.75F, -0.12F));
        ModelPartData p61 = p60.addChild("prim0", ModelPartBuilder.create()
                .uv(56, 58).cuboid(-1F, -0.5F, 0F, 3F, 1F, 14F, new Dilation(-0.3F)),
                ModelTransform.of(-0.6F, 0.25F, 0.4F, 0F, -0.12F, 0F));
        ModelPartData p62 = p60.addChild("prim1", ModelPartBuilder.create()
                .uv(72, 41).cuboid(-1F, -0.5F, 0F, 3F, 1F, 16F, new Dilation(-0.3F)),
                ModelTransform.of(-1.65F, 0.37F, 0.4F, 0F, -0.36F, 0F));
        ModelPartData p63 = p60.addChild("prim2", ModelPartBuilder.create()
                .uv(160, 22).cuboid(-1F, -0.5F, 0F, 3F, 1F, 17F, new Dilation(-0.3F)),
                ModelTransform.of(-2.7F, 0.49F, 0.4F, 0F, -0.6F, 0F));
        ModelPartData p64 = p60.addChild("prim3", ModelPartBuilder.create()
                .uv(0, 22).cuboid(-1F, -0.5F, 0F, 3F, 1F, 18F, new Dilation(-0.3F)),
                ModelTransform.of(-3.75F, 0.61F, 0.4F, 0F, -0.84F, 0F));
        ModelPartData p65 = p60.addChild("prim4", ModelPartBuilder.create()
                .uv(200, 22).cuboid(-1F, -0.5F, 0F, 3F, 1F, 17F, new Dilation(-0.3F)),
                ModelTransform.of(-4.8F, 0.73F, 0.4F, 0F, -1.08F, 0F));
        ModelPartData p66 = p60.addChild("prim5", ModelPartBuilder.create()
                .uv(190, 41).cuboid(-1F, -0.5F, 0F, 3F, 1F, 15F, new Dilation(-0.3F)),
                ModelTransform.of(-5.85F, 0.85F, 0.4F, 0F, -1.32F, 0F));
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
        animateWings(entity.getWingSpread(), entity.getFlapIntensity(), entity.getWingPhase());
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
    private static final float[][] FOLDED = { {0.05F, -1.5F, 0.95F}, {0F, 2.8F, 0F}, {0F, -2.75F, 0.05F} };
    private static final float[][] SPREAD = { {0.1F, -0.3F, -0.68F}, {0F, 0.5F, -0.2F}, {0F, -0.75F, 0.12F} };
    private static final float[][] FLAP_UP = { {0.15F, -0.15F, -1.25F}, {0F, 0.35F, -0.25F}, {0F, -0.6F, -0.05F} };
    private static final float[][] FLAP_DOWN = { {0F, -0.35F, 0.28F}, {0F, 0.55F, 0.35F}, {0F, -0.85F, 0.35F} };

    /** spread: 0 folded .. 1 open; flap: 0 glide .. 1 full flapping; phase in radians. */
    protected void animateWings(float spread, float flap, float phase) {
        float beat = (MathHelper.sin(phase) + 1.0F) * 0.5F;      // 0 = down-stroke end, 1 = up-stroke end
        ModelPart[] left = {leftWing, leftForearm, leftHand};
        ModelPart[] right = {rightWing, rightForearm, rightHand};
        for (int i = 0; i < 3; i++) {
            float[] air = new float[3];
            for (int k = 0; k < 3; k++) {
                float stroke = MathHelper.lerp(beat, FLAP_DOWN[i][k], FLAP_UP[i][k]);
                air[k] = MathHelper.lerp(flap, SPREAD[i][k], stroke);
            }
            float px = MathHelper.lerp(spread, FOLDED[i][0], air[0]);
            float py = MathHelper.lerp(spread, FOLDED[i][1], air[1]);
            float pz = MathHelper.lerp(spread, FOLDED[i][2], air[2]);
            left[i].pitch = px;  left[i].yaw = py;  left[i].roll = pz;
            right[i].pitch = px; right[i].yaw = -py; right[i].roll = -pz;
        }
    }
}
