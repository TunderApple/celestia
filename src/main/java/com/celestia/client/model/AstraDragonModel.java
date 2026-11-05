package com.celestia.client.model;

import com.celestia.entity.AstraDragonEntity;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.MathHelper;

/** Huya, the star-dragon girl (boss). Rendered at 1.5x; texture image is 4x denser than the declared 256x64. */
public class AstraDragonModel<T extends AstraDragonEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root, torso, head, halo, cape, lArm, rArm, lFore, rFore, lWing, rWing, lHand, rHand, lLeg, rLeg;
    private final ModelPart[] braid = new ModelPart[6];
    private final ModelPart[] tail = new ModelPart[8];

    public AstraDragonModel(ModelPart root) {
        this.root = root;
        this.torso = root.getChild("torso");
        this.head = torso.getChild("head");
        this.halo = head.getChild("halo");
        this.cape = torso.getChild("cape");
        this.lArm = torso.getChild("left_arm");
        this.rArm = torso.getChild("right_arm");
        this.lFore = lArm.getChild("forearm");
        this.rFore = rArm.getChild("forearm");
        this.lWing = torso.getChild("left_wing");
        this.rWing = torso.getChild("right_wing");
        this.lHand = lWing.getChild("hand");
        this.rHand = rWing.getChild("hand");
        this.lLeg = root.getChild("left_leg");
        this.rLeg = root.getChild("right_leg");
        ModelPart b = head;
        for (int i = 0; i < 6; i++) {
            b = b.getChild("braid" + i);
            braid[i] = b;
        }
        ModelPart t = torso;
        for (int i = 0; i < 8; i++) {
            t = t.getChild("tail" + i);
            tail[i] = t;
        }
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        ModelPartData p0 = root.addChild("torso", ModelPartBuilder.create()
                .uv(54, 0).cuboid(-4F, -12F, -2.5F, 8F, 7F, 5F, new Dilation(0F))
                .uv(12, 22).cuboid(-3.5F, -5F, -2F, 7F, 5F, 4F, new Dilation(0F))
                .uv(96, 41).cuboid(-4.3F, -11.5F, -2.9F, 9F, 4F, 1F, new Dilation(0F))
                .uv(20, 53).cuboid(-1F, -9F, -3.1F, 2F, 2F, 1F, new Dilation(-0.2F))
                .uv(116, 33).cuboid(-4.2F, -1.5F, -2.6F, 8F, 2F, 5F, new Dilation(0.2F))
                .uv(116, 41).cuboid(-2.5F, -13F, -2F, 5F, 1F, 4F, new Dilation(0F)),
                ModelTransform.of(0F, 12F, 0F, 0F, 0F, 0F));
        ModelPartData p1 = p0.addChild("head", ModelPartBuilder.create()
                .uv(22, 0).cuboid(-4F, -8F, -4F, 8F, 8F, 8F, new Dilation(0F))
                .uv(80, 0).cuboid(-4.5F, -8.7F, -4.5F, 9F, 3F, 9F, new Dilation(0F))
                .uv(116, 0).cuboid(-4.5F, -7F, 1.2F, 9F, 9F, 3F, new Dilation(0.05F))
                .uv(140, 0).cuboid(-4.6F, -6.4F, -4.2F, 1F, 8F, 4F, new Dilation(0F))
                .uv(150, 0).cuboid(3.6F, -6.4F, -4.2F, 1F, 8F, 4F, new Dilation(0F))
                .uv(26, 53).cuboid(-4.4F, -8.3F, -4.65F, 9F, 2F, 1F, new Dilation(-0.1F))
                .uv(46, 53).cuboid(-3.6F, -6.5F, -4.65F, 2F, 2F, 1F, new Dilation(-0.15F))
                .uv(52, 53).cuboid(1.6F, -6.5F, -4.65F, 2F, 2F, 1F, new Dilation(-0.15F))
                .uv(110, 53).cuboid(-0.6F, -6.3F, -4.7F, 1F, 1F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(0F, -12.5F, 0F, 0F, 0F, 0F));
        ModelPartData p2 = p1.addChild("left_horn0", ModelPartBuilder.create()
                .uv(134, 41).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(0.1F)),
                ModelTransform.of(2.6F, -7.6F, -1F, 0.95F, 0.35F, 0.25F));
        ModelPartData p3 = p2.addChild("left_horn1", ModelPartBuilder.create()
                .uv(144, 41).cuboid(-0.75F, -0.75F, 0F, 2F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 2.6F, 0.22F, 0.08F, 0F));
        ModelPartData p4 = p3.addChild("left_horn2", ModelPartBuilder.create()
                .uv(32, 48).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, 2.6F, 0.22F, 0.08F, 0F));
        ModelPartData p5 = p4.addChild("left_horn3", ModelPartBuilder.create()
                .uv(58, 53).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 2.6F, 0.22F, 0.08F, 0F));
        ModelPartData p6 = p1.addChild("right_horn0", ModelPartBuilder.create()
                .uv(154, 41).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(0.1F)),
                ModelTransform.of(-2.6F, -7.6F, -1F, 0.95F, -0.35F, -0.25F));
        ModelPartData p7 = p6.addChild("right_horn1", ModelPartBuilder.create()
                .uv(164, 41).cuboid(-0.75F, -0.75F, 0F, 2F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 2.6F, 0.22F, -0.08F, 0F));
        ModelPartData p8 = p7.addChild("right_horn2", ModelPartBuilder.create()
                .uv(40, 48).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, 2.6F, 0.22F, -0.08F, 0F));
        ModelPartData p9 = p8.addChild("right_horn3", ModelPartBuilder.create()
                .uv(64, 53).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 2.6F, 0.22F, -0.08F, 0F));
        ModelPartData p10 = p1.addChild("halo", ModelPartBuilder.create()
                .uv(70, 53).cuboid(4.2F, -1F, -0.5F, 2F, 2F, 1F, new Dilation(0.1F))
                .uv(114, 53).cuboid(4.3042F, 1.49F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(118, 53).cuboid(3.177F, 3.177F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(122, 53).cuboid(1.49F, 4.3042F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(76, 53).cuboid(-1F, 4.2F, -0.5F, 2F, 2F, 1F, new Dilation(0.1F))
                .uv(126, 53).cuboid(-2.49F, 4.3042F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(130, 53).cuboid(-4.177F, 3.177F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(134, 53).cuboid(-5.3042F, 1.49F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(82, 53).cuboid(-6.2F, -1F, -0.5F, 2F, 2F, 1F, new Dilation(0.1F))
                .uv(138, 53).cuboid(-5.3042F, -2.49F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(142, 53).cuboid(-4.177F, -4.177F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(146, 53).cuboid(-2.49F, -5.3042F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(88, 53).cuboid(-1F, -6.2F, -0.5F, 2F, 2F, 1F, new Dilation(0.1F))
                .uv(150, 53).cuboid(1.49F, -5.3042F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(154, 53).cuboid(3.177F, -4.177F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F))
                .uv(158, 53).cuboid(4.3042F, -2.49F, -0.5F, 1F, 1F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(0F, -4.5F, 6F, 0.12F, 0F, 0F));
        ModelPartData p11 = p1.addChild("braid0", ModelPartBuilder.create()
                .uv(142, 33).cuboid(-1.5F, 0F, -1.5F, 3F, 4F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(0F, -1.5F, 4F, 0.35F, 0F, 0.04F));
        ModelPartData p12 = p11.addChild("braid1", ModelPartBuilder.create()
                .uv(154, 33).cuboid(-1.5F, 0F, -1.5F, 3F, 4F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 3.2F, 0F, -0.05F, 0F, 0.04F));
        ModelPartData p13 = p12.addChild("braid2", ModelPartBuilder.create()
                .uv(166, 33).cuboid(-1.5F, 0F, -1.5F, 3F, 4F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(0F, 3.2F, 0F, -0.05F, 0F, 0.04F));
        ModelPartData p14 = p13.addChild("braid3", ModelPartBuilder.create()
                .uv(178, 33).cuboid(-1.5F, 0F, -1.5F, 3F, 4F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 3.2F, 0F, -0.05F, 0F, 0.04F));
        ModelPartData p15 = p14.addChild("braid4", ModelPartBuilder.create()
                .uv(44, 41).cuboid(-1F, 0F, -1F, 2F, 4F, 2F, new Dilation(-0.05F)),
                ModelTransform.of(0F, 3.2F, 0F, -0.05F, 0F, 0.04F));
        ModelPartData p16 = p15.addChild("braid5", ModelPartBuilder.create()
                .uv(52, 41).cuboid(-1F, 0F, -1F, 2F, 4F, 2F, new Dilation(0.1F)),
                ModelTransform.of(0F, 3.2F, 0F, -0.05F, 0F, 0.04F));
        ModelPartData p17 = p16.addChild("clasp", ModelPartBuilder.create()
                .uv(48, 48).cuboid(-1F, 0F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 3.6F, 0F, 0F, 0.78F, 0F));
        ModelPartData p18 = p17.addChild("tuft", ModelPartBuilder.create()
                .uv(60, 41).cuboid(-1.5F, 0F, -1.5F, 3F, 3F, 3F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 1.6F, 0F, 0F, 0F, 0F));
        ModelPartData p19 = p1.addChild("ahoge", ModelPartBuilder.create()
                .uv(56, 48).cuboid(-0.5F, -3F, -0.5F, 1F, 3F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(0F, -8.6F, -1F, -0.6F, 0F, 0.2F));
        ModelPartData p20 = p0.addChild("left_arm", ModelPartBuilder.create()
                .uv(72, 41).cuboid(-1.5F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0.3F))
                .uv(34, 22).cuboid(-1.25F, 0F, -1.25F, 3F, 6F, 3F, new Dilation(0F)),
                ModelTransform.of(5.4F, -11F, 0F, -0.15F, 0F, -0.32F));
        ModelPartData p21 = p20.addChild("forearm", ModelPartBuilder.create()
                .uv(176, 22).cuboid(-1.25F, 0F, -1.25F, 3F, 5F, 3F, new Dilation(-0.05F))
                .uv(188, 22).cuboid(-2F, 1.5F, -2F, 4F, 4F, 4F, new Dilation(-0.2F))
                .uv(60, 48).cuboid(-1.5F, 4.5F, -1.5F, 3F, 1F, 3F, new Dilation(0F))
                .uv(174, 41).cuboid(-1F, 5F, -1F, 2F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 6F, 0F, -0.35F, 0F, 0F));
        ModelPartData p22 = p21.addChild("orb", ModelPartBuilder.create()
                .uv(72, 48).cuboid(-0.75F, -0.75F, -0.75F, 2F, 2F, 2F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 9.5F, -0.5F, 0.6F, 0.6F, 0F));
        ModelPartData p23 = p0.addChild("right_arm", ModelPartBuilder.create()
                .uv(84, 41).cuboid(-1.5F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0.3F))
                .uv(46, 22).cuboid(-1.25F, 0F, -1.25F, 3F, 6F, 3F, new Dilation(0F)),
                ModelTransform.of(-5.4F, -11F, 0F, -0.15F, 0F, 0.32F));
        ModelPartData p24 = p23.addChild("forearm", ModelPartBuilder.create()
                .uv(204, 22).cuboid(-1.25F, 0F, -1.25F, 3F, 5F, 3F, new Dilation(-0.05F))
                .uv(216, 22).cuboid(-2F, 1.5F, -2F, 4F, 4F, 4F, new Dilation(-0.2F))
                .uv(80, 48).cuboid(-1.5F, 4.5F, -1.5F, 3F, 1F, 3F, new Dilation(0F))
                .uv(182, 41).cuboid(-1F, 5F, -1F, 2F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 6F, 0F, -0.35F, 0F, 0F));
        ModelPartData p25 = p24.addChild("orb", ModelPartBuilder.create()
                .uv(92, 48).cuboid(-0.75F, -0.75F, -0.75F, 2F, 2F, 2F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 9.5F, -0.5F, 0.6F, 0.6F, 0F));
        ModelPartData p26 = p0.addChild("left_wing", ModelPartBuilder.create()
                .uv(100, 48).cuboid(0F, -1F, -1F, 11F, 2F, 2F, new Dilation(0F))
                .uv(160, 0).cuboid(0F, -0.25F, 0.6F, 11F, 1F, 10F, new Dilation(-0.3F)),
                ModelTransform.of(2.5F, -9.5F, 2.6F, 0.35F, -0.75F, -0.55F));
        ModelPartData p27 = p26.addChild("hand", ModelPartBuilder.create()
                .uv(126, 48).cuboid(0F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(11F, 0F, 0F, 0F, 0.1F, 0F));
        ModelPartData p28 = p27.addChild("finger0", ModelPartBuilder.create()
                .uv(162, 53).cuboid(0F, -0.5F, -0.5F, 16F, 1F, 1F, new Dilation(0F))
                .uv(134, 48).cuboid(15F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.05F, 0F));
        ModelPartData p29 = p28.addChild("web", ModelPartBuilder.create()
                .uv(58, 22).cuboid(0F, -0.25F, 0F, 15F, 1F, 8F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p30 = p27.addChild("finger1", ModelPartBuilder.create()
                .uv(196, 53).cuboid(0F, -0.5F, -0.5F, 13F, 1F, 1F, new Dilation(0F))
                .uv(142, 48).cuboid(12F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.5F, 0F));
        ModelPartData p31 = p30.addChild("web", ModelPartBuilder.create()
                .uv(0, 33).cuboid(0F, -0.25F, 0F, 12F, 1F, 7F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p32 = p27.addChild("finger2", ModelPartBuilder.create()
                .uv(224, 53).cuboid(0F, -0.5F, -0.5F, 10F, 1F, 1F, new Dilation(0F))
                .uv(150, 48).cuboid(9F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.95F, 0F));
        ModelPartData p33 = p32.addChild("web", ModelPartBuilder.create()
                .uv(190, 33).cuboid(0F, -0.25F, 0F, 9F, 1F, 6F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p34 = p0.addChild("right_wing", ModelPartBuilder.create()
                .uv(158, 48).cuboid(-11F, -1F, -1F, 11F, 2F, 2F, new Dilation(0F))
                .uv(202, 0).cuboid(-11F, -0.25F, 0.6F, 11F, 1F, 10F, new Dilation(-0.3F)),
                ModelTransform.of(-2.5F, -9.5F, 2.6F, 0.35F, 0.75F, 0.55F));
        ModelPartData p35 = p34.addChild("hand", ModelPartBuilder.create()
                .uv(184, 48).cuboid(-2F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(-11F, 0F, 0F, 0F, -0.1F, 0F));
        ModelPartData p36 = p35.addChild("finger0", ModelPartBuilder.create()
                .uv(0, 57).cuboid(-16F, -0.5F, -0.5F, 16F, 1F, 1F, new Dilation(0F))
                .uv(192, 48).cuboid(-17F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.05F, 0F));
        ModelPartData p37 = p36.addChild("web", ModelPartBuilder.create()
                .uv(104, 22).cuboid(-15F, -0.25F, 0F, 15F, 1F, 8F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p38 = p35.addChild("finger1", ModelPartBuilder.create()
                .uv(34, 57).cuboid(-13F, -0.5F, -0.5F, 13F, 1F, 1F, new Dilation(0F))
                .uv(200, 48).cuboid(-14F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.5F, 0F));
        ModelPartData p39 = p38.addChild("web", ModelPartBuilder.create()
                .uv(38, 33).cuboid(-12F, -0.25F, 0F, 12F, 1F, 7F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p40 = p35.addChild("finger2", ModelPartBuilder.create()
                .uv(62, 57).cuboid(-10F, -0.5F, -0.5F, 10F, 1F, 1F, new Dilation(0F))
                .uv(208, 48).cuboid(-11F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.95F, 0F));
        ModelPartData p41 = p40.addChild("web", ModelPartBuilder.create()
                .uv(220, 33).cuboid(-9F, -0.25F, 0F, 9F, 1F, 6F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p42 = p0.addChild("tail0", ModelPartBuilder.create()
                .uv(190, 41).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -1.5F, 2.4F, 1.15F, 0F, 0F));
        ModelPartData p43 = p42.addChild("fin", ModelPartBuilder.create()
                .uv(94, 53).cuboid(-0.5F, -1.5F, -0.5F, 1F, 2F, 1F, new Dilation(-0.2F)),
                ModelTransform.of(0F, -1F, 1.5F, -0.5F, 0F, 0F));
        ModelPartData p44 = p42.addChild("tail1", ModelPartBuilder.create()
                .uv(200, 41).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 3.4F, -0.14F, 0F, 0F));
        ModelPartData p45 = p44.addChild("tail2", ModelPartBuilder.create()
                .uv(210, 41).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 3.4F, -0.14F, 0F, 0F));
        ModelPartData p46 = p45.addChild("fin", ModelPartBuilder.create()
                .uv(98, 53).cuboid(-0.5F, -1.5F, -0.5F, 1F, 2F, 1F, new Dilation(-0.2F)),
                ModelTransform.of(0F, -1F, 1.5F, -0.5F, 0F, 0F));
        ModelPartData p47 = p45.addChild("tail3", ModelPartBuilder.create()
                .uv(220, 41).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 3.4F, -0.14F, 0.1F, 0F));
        ModelPartData p48 = p47.addChild("tail4", ModelPartBuilder.create()
                .uv(216, 48).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 3.4F, -0.14F, 0.1F, 0F));
        ModelPartData p49 = p48.addChild("fin", ModelPartBuilder.create()
                .uv(102, 53).cuboid(-0.5F, -1.5F, -0.5F, 1F, 2F, 1F, new Dilation(-0.2F)),
                ModelTransform.of(0F, -0.5F, 1.5F, -0.5F, 0F, 0F));
        ModelPartData p50 = p48.addChild("tail5", ModelPartBuilder.create()
                .uv(224, 48).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 3.4F, -0.22F, 0.1F, 0F));
        ModelPartData p51 = p50.addChild("tail6", ModelPartBuilder.create()
                .uv(232, 48).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 3.4F, -0.22F, 0.1F, 0F));
        ModelPartData p52 = p51.addChild("fin", ModelPartBuilder.create()
                .uv(106, 53).cuboid(-0.5F, -1.5F, -0.5F, 1F, 2F, 1F, new Dilation(-0.2F)),
                ModelTransform.of(0F, -0.5F, 1.5F, -0.5F, 0F, 0F));
        ModelPartData p53 = p51.addChild("tail7", ModelPartBuilder.create()
                .uv(240, 48).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 3.4F, -0.22F, 0.1F, 0F));
        ModelPartData p54 = p53.addChild("blade", ModelPartBuilder.create()
                .uv(76, 33).cuboid(-0.5F, -2.5F, 0F, 1F, 5F, 3F, new Dilation(0F))
                .uv(248, 48).cuboid(-0.5F, -1F, 2.5F, 1F, 2F, 2F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, 3.4F, 0F, 0F, 0F));
        ModelPartData p55 = p0.addChild("panel0", ModelPartBuilder.create()
                .uv(230, 41).cuboid(-2F, 0F, -0.5F, 4F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -0.5F, -2F, -0.38F, 0F, 0F));
        ModelPartData p56 = p0.addChild("panel1", ModelPartBuilder.create()
                .uv(240, 41).cuboid(-1.5F, 0F, -0.5F, 3F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(2.4042F, -0.5F, -1.4142F, -0.2687F, -0.7854F, 0F));
        ModelPartData p57 = p0.addChild("panel2", ModelPartBuilder.create()
                .uv(0, 41).cuboid(-2F, 0F, -0.5F, 4F, 6F, 1F, new Dilation(0F)),
                ModelTransform.of(3.4F, -0.5F, 0F, 0F, -1.5708F, 0F));
        ModelPartData p58 = p0.addChild("panel3", ModelPartBuilder.create()
                .uv(150, 22).cuboid(-1.5F, 0F, -0.5F, 3F, 8F, 1F, new Dilation(0F)),
                ModelTransform.of(2.4042F, -0.5F, 1.4142F, 0.2687F, -2.3562F, 0F));
        ModelPartData p59 = p0.addChild("panel4", ModelPartBuilder.create()
                .uv(158, 22).cuboid(-2F, 0F, -0.5F, 4F, 8F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -0.5F, 2F, 0.38F, -3.1416F, 0F));
        ModelPartData p60 = p0.addChild("panel5", ModelPartBuilder.create()
                .uv(168, 22).cuboid(-1.5F, 0F, -0.5F, 3F, 8F, 1F, new Dilation(0F)),
                ModelTransform.of(-2.4042F, -0.5F, 1.4142F, 0.2687F, -3.927F, 0F));
        ModelPartData p61 = p0.addChild("panel6", ModelPartBuilder.create()
                .uv(10, 41).cuboid(-2F, 0F, -0.5F, 4F, 6F, 1F, new Dilation(0F)),
                ModelTransform.of(-3.4F, -0.5F, 0F, 0F, -4.7124F, 0F));
        ModelPartData p62 = p0.addChild("panel7", ModelPartBuilder.create()
                .uv(248, 41).cuboid(-1.5F, 0F, -0.5F, 3F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(-2.4042F, -0.5F, -1.4142F, -0.2687F, -5.4978F, 0F));
        ModelPartData p63 = p0.addChild("cape", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-5F, 0F, 0F, 10F, 21F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -11.5F, 2.7F, 0.18F, 0F, 0F));
        ModelPartData p64 = p63.addChild("cape_tip", ModelPartBuilder.create()
                .uv(0, 53).cuboid(-4.5F, 0F, 0F, 9F, 3F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 21F, 0F, 0.15F, 0F, 0F));
        ModelPartData p1065 = root.addChild("left_leg", ModelPartBuilder.create()
                .uv(244, 0).cuboid(-1.5F, 0F, -1.5F, 3F, 8F, 3F, new Dilation(0F)),
                ModelTransform.of(2.2F, 12F, 0F, 0.04F, 0F, 0.16F));
        ModelPartData p1066 = p1065.addChild("shin", ModelPartBuilder.create()
                .uv(20, 41).cuboid(-1.5F, 0F, -1.5F, 3F, 4F, 3F, new Dilation(-0.02F))
                .uv(84, 33).cuboid(-1.8F, 0.5F, -1.8F, 4F, 4F, 4F, new Dilation(-0.25F))
                .uv(0, 48).cuboid(-1.75F, 3.6F, -2.4F, 4F, 1F, 4F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 7.6F, 0F, 0.12F, 0F, 0F));
        ModelPartData p2067 = root.addChild("right_leg", ModelPartBuilder.create()
                .uv(0, 22).cuboid(-1.5F, 0F, -1.5F, 3F, 8F, 3F, new Dilation(0F)),
                ModelTransform.of(-2.2F, 12F, 0F, 0.04F, 0F, -0.16F));
        ModelPartData p2068 = p2067.addChild("shin", ModelPartBuilder.create()
                .uv(32, 41).cuboid(-1.5F, 0F, -1.5F, 3F, 4F, 3F, new Dilation(-0.02F))
                .uv(100, 33).cuboid(-1.8F, 0.5F, -1.8F, 4F, 4F, 4F, new Dilation(-0.25F))
                .uv(16, 48).cuboid(-1.75F, 3.6F, -2.4F, 4F, 1F, 4F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 7.6F, 0F, 0.12F, 0F, 0F));
        return TexturedModelData.of(modelData, 256, 64);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(T e, float limbAngle, float limbDistance, float age, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        float beat = age * (e.isDiving() ? 0.4F : 0.22F);
        float s = MathHelper.sin(beat);
        float bob = MathHelper.sin(age * 0.08F);
        // floating: whole body bobs, legs dangle and sway
        torso.pivotY += bob * 0.8F;
        lLeg.pivotY += bob * 0.8F;
        rLeg.pivotY += bob * 0.8F;
        lLeg.pitch += 0.15F + MathHelper.sin(age * 0.08F) * 0.08F;
        rLeg.pitch += 0.05F + MathHelper.sin(age * 0.08F + 1.2F) * 0.08F;
        // wings
        lWing.roll += s * 0.45F;
        rWing.roll -= s * 0.45F;
        lHand.yaw += MathHelper.sin(beat - 0.8F) * 0.25F;
        rHand.yaw -= MathHelper.sin(beat - 0.8F) * 0.25F;
        // head looks at the target
        head.yaw += headYaw * ((float) Math.PI / 180F) * 0.8F;
        head.pitch += headPitch * ((float) Math.PI / 180F) * 0.6F;
        halo.roll += age * 0.03F;
        // hair braid, cape and tail follow with a lag
        for (int i = 0; i < braid.length; i++) {
            braid[i].roll += MathHelper.sin(age * 0.07F - i * 0.5F) * 0.05F;
            braid[i].pitch += MathHelper.sin(age * 0.06F - i * 0.4F) * 0.03F;
        }
        cape.pitch += 0.1F + MathHelper.sin(age * 0.09F) * 0.06F + (e.isDiving() ? 0.6F : 0.0F);
        for (int i = 0; i < tail.length; i++) {
            tail[i].yaw += MathHelper.sin(age * 0.1F - i * 0.6F) * 0.12F;
        }
        // casting: both arms rise toward the target while she breathes starfire
        float cast = e.getJawOpen();
        lArm.pitch -= cast * 1.6F;
        rArm.pitch -= cast * 1.6F;
        lArm.roll += cast * 0.25F;
        rArm.roll -= cast * 0.25F;
        lFore.pitch += cast * 0.3F;
        rFore.pitch += cast * 0.3F;
        lArm.pitch += MathHelper.sin(age * 0.1F) * 0.05F * (1 - cast);
        rArm.pitch -= MathHelper.sin(age * 0.1F) * 0.05F * (1 - cast);
    }
}
