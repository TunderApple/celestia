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

/** Huya, the Violet Star Dragon. Half-scale geometry; the renderer scales it by 2. Texture image is 4x denser than the declared size. (512x256 texture) */
public class AstraDragonModel<T extends AstraDragonEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root, body, jaw, head;
    private final ModelPart[] neck = new ModelPart[6];
    private final ModelPart[] tail = new ModelPart[12];
    private final ModelPart lWing, lFore, lHand, rWing, rFore, rHand;
    private final ModelPart[] legs = new ModelPart[4];

    public AstraDragonModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        ModelPart n = body.getChild("neck_root");
        for (int i = 0; i < 6; i++) {
            n = n.getChild("neck" + i);
            neck[i] = n;
        }
        this.head = n.getChild("head");
        this.jaw = head.getChild("jaw");
        ModelPart t = body;
        for (int i = 0; i < 12; i++) {
            t = t.getChild("tail" + i);
            tail[i] = t;
        }
        this.lWing = body.getChild("left_wing");
        this.lFore = lWing.getChild("forearm");
        this.lHand = lFore.getChild("hand");
        this.rWing = body.getChild("right_wing");
        this.rFore = rWing.getChild("forearm");
        this.rHand = rFore.getChild("hand");
        legs[0] = body.getChild("left_front_leg");
        legs[1] = body.getChild("right_front_leg");
        legs[2] = body.getChild("left_hind_leg");
        legs[3] = body.getChild("right_hind_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        ModelPartData p0 = root.addChild("body", ModelPartBuilder.create()
                .uv(30, 67).cuboid(-5.5F, -4F, -6F, 11F, 6F, 12F, new Dilation(0.05F))
                .uv(374, 37).cuboid(-3.5F, -6F, -6F, 7F, 10F, 12F, new Dilation(0.06F))
                .uv(344, 67).cuboid(-5F, 4.5F, -6F, 10F, 2F, 12F, new Dilation(0.1F)),
                ModelTransform.of(0F, 4F, 0F, -0.14F, 0F, 0F));
        ModelPartData p1 = p0.addChild("chest", ModelPartBuilder.create()
                .uv(156, 67).cuboid(-6.5F, -4F, -9F, 13F, 7F, 10F, new Dilation(0F))
                .uv(240, 37).cuboid(-3.5F, -7F, -9F, 7F, 13F, 10F, new Dilation(0.01F))
                .uv(220, 100).cuboid(-5.5F, 4.5F, -9F, 11F, 2F, 9F, new Dilation(0.1F))
                .uv(68, 86).cuboid(-5F, -4F, -11F, 10F, 10F, 3F, new Dilation(-0.3F))
                .uv(350, 112).cuboid(-7.5F, -8F, -7F, 5F, 3F, 6F, new Dilation(-0.1F))
                .uv(372, 112).cuboid(2.5F, -8F, -7F, 5F, 3F, 6F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, -6F, -0.1F, 0F, 0F));
        ModelPartData p2 = p0.addChild("hips", ModelPartBuilder.create()
                .uv(94, 86).cuboid(-6.5F, -3.5F, 0F, 13F, 5F, 8F, new Dilation(0F))
                .uv(0, 67).cuboid(-3.5F, -6.5F, 0F, 7F, 11F, 8F, new Dilation(0.01F))
                .uv(394, 112).cuboid(-4.5F, 3.5F, 0F, 9F, 2F, 7F, new Dilation(0.1F))
                .uv(136, 86).cuboid(-8F, -5F, 1F, 4F, 7F, 6F, new Dilation(-0.1F))
                .uv(156, 86).cuboid(4F, -5F, 1F, 4F, 7F, 6F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, 6F, 0.08F, 0F, 0F));
        ModelPartData p3 = p0.addChild("plate0", ModelPartBuilder.create()
                .uv(236, 123).cuboid(-0.5F, -6F, -1.2F, 1F, 6F, 2F, new Dilation(0F))
                .uv(162, 146).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -12F, -0.5F, 0F, 0F));
        ModelPartData p4 = p0.addChild("plate1", ModelPartBuilder.create()
                .uv(242, 123).cuboid(-0.5F, -5.5F, -1.2F, 1F, 6F, 2F, new Dilation(0F))
                .uv(172, 146).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -9.2F, -0.5F, 0F, 0F));
        ModelPartData p5 = p0.addChild("plate2", ModelPartBuilder.create()
                .uv(92, 132).cuboid(-0.5F, -5F, -1.2F, 1F, 5F, 2F, new Dilation(0F))
                .uv(182, 146).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -6.4F, -0.5F, 0F, 0F));
        ModelPartData p6 = p0.addChild("plate3", ModelPartBuilder.create()
                .uv(274, 132).cuboid(-0.5F, -4.5F, -1.2F, 1F, 4F, 2F, new Dilation(0F))
                .uv(192, 146).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -3.6F, -0.5F, 0F, 0F));
        ModelPartData p7 = p0.addChild("plate4", ModelPartBuilder.create()
                .uv(280, 132).cuboid(-0.5F, -4F, -1.2F, 1F, 4F, 2F, new Dilation(0F))
                .uv(202, 146).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -0.8F, -0.5F, 0F, 0F));
        ModelPartData p8 = p0.addChild("plate5", ModelPartBuilder.create()
                .uv(286, 132).cuboid(-0.5F, -3.5F, -1.2F, 1F, 4F, 2F, new Dilation(0F))
                .uv(212, 146).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 2F, -0.5F, 0F, 0F));
        ModelPartData p9 = p0.addChild("plate6", ModelPartBuilder.create()
                .uv(480, 140).cuboid(-0.5F, -3F, -1.2F, 1F, 3F, 2F, new Dilation(0F))
                .uv(222, 146).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 4.8F, -0.5F, 0F, 0F));
        ModelPartData p10 = p0.addChild("plate7", ModelPartBuilder.create()
                .uv(232, 146).cuboid(-0.5F, -2.5F, -1.2F, 1F, 2F, 2F, new Dilation(0F))
                .uv(238, 146).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 7.6F, -0.5F, 0F, 0F));
        ModelPartData p11 = p0.addChild("plate8", ModelPartBuilder.create()
                .uv(248, 146).cuboid(-0.5F, -2F, -1.2F, 1F, 2F, 2F, new Dilation(0F))
                .uv(254, 146).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 10.4F, -0.5F, 0F, 0F));
        ModelPartData p12 = p0.addChild("neck_root", ModelPartBuilder.create(),
                ModelTransform.of(0F, -3F, -12F, 0F, 0F, 0F));
        ModelPartData p13 = p12.addChild("neck0", ModelPartBuilder.create()
                .uv(362, 86).cuboid(-4.5F, -3.5F, -5F, 9F, 7F, 5F, new Dilation(0F))
                .uv(388, 67).cuboid(-3.5F, -4.5F, -5F, 7F, 9F, 5F, new Dilation(0.01F))
                .uv(292, 132).cuboid(-3.3F, 3.5F, -5F, 6F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -1F, -0.62F, 0F, 0F));
        ModelPartData p14 = p13.addChild("fin", ModelPartBuilder.create()
                .uv(486, 140).cuboid(-0.5F, -3F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4.5F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p15 = p13.addChild("neck1", ModelPartBuilder.create()
                .uv(260, 100).cuboid(-4.25F, -3.25F, -5F, 8F, 6F, 5F, new Dilation(0.05F))
                .uv(176, 86).cuboid(-3.25F, -4.25F, -5F, 6F, 8F, 5F, new Dilation(0.06F))
                .uv(314, 132).cuboid(-3.05F, 3.25F, -5F, 6F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, -0.38F, 0F, 0F));
        ModelPartData p16 = p15.addChild("fin", ModelPartBuilder.create()
                .uv(492, 140).cuboid(-0.5F, -2.8F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4.25F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p17 = p15.addChild("neck2", ModelPartBuilder.create()
                .uv(102, 112).cuboid(-3.75F, -2.75F, -5F, 7F, 5F, 5F, new Dilation(0F))
                .uv(390, 86).cuboid(-2.75F, -3.75F, -5F, 5F, 7F, 5F, new Dilation(0.01F))
                .uv(336, 132).cuboid(-2.55F, 2.75F, -5F, 5F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, -0.18F, 0F, 0F));
        ModelPartData p18 = p17.addChild("fin", ModelPartBuilder.create()
                .uv(498, 140).cuboid(-0.5F, -2.6F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.75F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p19 = p17.addChild("neck3", ModelPartBuilder.create()
                .uv(126, 112).cuboid(-3.5F, -2.5F, -5F, 7F, 5F, 5F, new Dilation(0.05F))
                .uv(410, 86).cuboid(-2.5F, -3.5F, -5F, 5F, 7F, 5F, new Dilation(0.06F))
                .uv(356, 132).cuboid(-2.3F, 2.5F, -5F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, 0.05F, 0F, 0F));
        ModelPartData p20 = p19.addChild("fin", ModelPartBuilder.create()
                .uv(504, 140).cuboid(-0.5F, -2.4F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.5F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p21 = p19.addChild("neck4", ModelPartBuilder.create()
                .uv(426, 112).cuboid(-3.25F, -2.25F, -5F, 6F, 4F, 5F, new Dilation(0F))
                .uv(286, 100).cuboid(-2.25F, -3.25F, -5F, 4F, 6F, 5F, new Dilation(0.01F))
                .uv(374, 132).cuboid(-2.05F, 2.25F, -5F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, 0.25F, 0F, 0F));
        ModelPartData p22 = p21.addChild("fin", ModelPartBuilder.create()
                .uv(0, 146).cuboid(-0.5F, -2.2F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.25F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p23 = p21.addChild("neck5", ModelPartBuilder.create()
                .uv(448, 112).cuboid(-3F, -2F, -5F, 6F, 4F, 5F, new Dilation(0.05F))
                .uv(304, 100).cuboid(-2F, -3F, -5F, 4F, 6F, 5F, new Dilation(0.06F))
                .uv(392, 132).cuboid(-1.8F, 2F, -5F, 3F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, 0.35F, 0F, 0F));
        ModelPartData p24 = p23.addChild("fin", ModelPartBuilder.create()
                .uv(6, 146).cuboid(-0.5F, -2F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p25 = p23.addChild("head", ModelPartBuilder.create()
                .uv(198, 86).cuboid(-4.5F, -3F, -7F, 9F, 5F, 8F, new Dilation(0F))
                .uv(274, 67).cuboid(-3.5F, -4F, -7F, 7F, 7F, 8F, new Dilation(0.01F))
                .uv(98, 132).cuboid(-5F, -4.6F, -6.2F, 10F, 2F, 5F, new Dilation(-0.1F))
                .uv(470, 112).cuboid(-3.5F, -1.8F, -12F, 7F, 3F, 6F, new Dilation(0F))
                .uv(322, 100).cuboid(-2.5F, -2.8F, -12F, 5F, 5F, 6F, new Dilation(0.01F))
                .uv(408, 132).cuboid(-2.8F, -1.4F, -15.5F, 6F, 2F, 4F, new Dilation(0F))
                .uv(248, 123).cuboid(-1.8F, -2.4F, -15.5F, 4F, 4F, 4F, new Dilation(0.01F))
                .uv(430, 86).cuboid(-2.6F, 1.6F, -17.6F, 1F, 1F, 11F, new Dilation(-0.15F))
                .uv(454, 86).cuboid(1.6F, 1.6F, -17.6F, 1F, 1F, 11F, new Dilation(-0.15F))
                .uv(264, 123).cuboid(-1.5F, -3.2F, -12F, 3F, 1F, 7F, new Dilation(0F))
                .uv(496, 112).cuboid(-5.4F, -2.2F, -6.5F, 2F, 3F, 6F, new Dilation(-0.1F))
                .uv(0, 123).cuboid(3.4F, -2.2F, -6.5F, 2F, 3F, 6F, new Dilation(-0.1F))
                .uv(428, 132).cuboid(-2.2F, -2F, -18.2F, 4F, 3F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, -6.5F, 0.45F, 0F, 0F));
        ModelPartData p26 = p25.addChild("jaw", ModelPartBuilder.create()
                .uv(412, 67).cuboid(-3F, 0F, -12F, 6F, 2F, 12F, new Dilation(0F))
                .uv(448, 67).cuboid(-3F, 0F, -12F, 6F, 2F, 12F, new Dilation(0.01F))
                .uv(150, 112).cuboid(-2.5F, 1.6F, -9.5F, 5F, 1F, 9F, new Dilation(0F))
                .uv(344, 100).cuboid(-2.6F, -0.8F, -11.6F, 1F, 1F, 10F, new Dilation(-0.15F))
                .uv(366, 100).cuboid(1.6F, -0.8F, -11.6F, 1F, 1F, 10F, new Dilation(-0.15F))
                .uv(354, 151).cuboid(-1.8F, -0.8F, -12.2F, 4F, 1F, 1F, new Dilation(-0.15F))
                .uv(442, 132).cuboid(-3.5F, 0.5F, -3F, 1F, 2F, 4F, new Dilation(0F))
                .uv(452, 132).cuboid(2.5F, 0.5F, -3F, 1F, 2F, 4F, new Dilation(0F)),
                ModelTransform.of(0F, 2.2F, -6F, 0.12F, 0F, 0F));
        ModelPartData p27 = p25.addChild("lhorn0", ModelPartBuilder.create()
                .uv(16, 123).cuboid(-1F, -1F, 0F, 2F, 2F, 7F, new Dilation(0.15F)),
                ModelTransform.of(2.6F, -3.4F, 0.5F, 0.4F, 0.25F, 0.1F));
        ModelPartData p28 = p27.addChild("lhorn1", ModelPartBuilder.create()
                .uv(284, 123).cuboid(-0.75F, -0.75F, 0F, 2F, 2F, 6F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 6.6F, -0.12F, 0.05F, 0F));
        ModelPartData p29 = p28.addChild("lhorn2", ModelPartBuilder.create()
                .uv(462, 132).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 5F, new Dilation(-0.01F)),
                ModelTransform.of(0F, 0F, 5.6F, -0.12F, 0.05F, 0F));
        ModelPartData p30 = p29.addChild("lhorn3", ModelPartBuilder.create()
                .uv(12, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.09F)),
                ModelTransform.of(0F, 0F, 4.6F, -0.12F, 0.05F, 0F));
        ModelPartData p31 = p25.addChild("rhorn0", ModelPartBuilder.create()
                .uv(34, 123).cuboid(-1F, -1F, 0F, 2F, 2F, 7F, new Dilation(0.15F)),
                ModelTransform.of(-2.6F, -3.4F, 0.5F, 0.4F, -0.25F, -0.1F));
        ModelPartData p32 = p31.addChild("rhorn1", ModelPartBuilder.create()
                .uv(300, 123).cuboid(-0.75F, -0.75F, 0F, 2F, 2F, 6F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 6.6F, -0.12F, -0.05F, 0F));
        ModelPartData p33 = p32.addChild("rhorn2", ModelPartBuilder.create()
                .uv(474, 132).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 5F, new Dilation(-0.01F)),
                ModelTransform.of(0F, 0F, 5.6F, -0.12F, -0.05F, 0F));
        ModelPartData p34 = p33.addChild("rhorn3", ModelPartBuilder.create()
                .uv(22, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.09F)),
                ModelTransform.of(0F, 0F, 4.6F, -0.12F, -0.05F, 0F));
        ModelPartData p35 = p25.addChild("lhorn_s0", ModelPartBuilder.create()
                .uv(264, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0.15F)),
                ModelTransform.of(3.6F, -1.2F, -1F, 0.2F, 0.75F, 0.05F));
        ModelPartData p36 = p35.addChild("lhorn_s1", ModelPartBuilder.create()
                .uv(210, 151).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 2.6F, -0.12F, 0.05F, 0F));
        ModelPartData p37 = p25.addChild("rhorn_s0", ModelPartBuilder.create()
                .uv(272, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0.15F)),
                ModelTransform.of(-3.6F, -1.2F, -1F, 0.2F, -0.75F, -0.05F));
        ModelPartData p38 = p37.addChild("rhorn_s1", ModelPartBuilder.create()
                .uv(216, 151).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 2.6F, -0.12F, -0.05F, 0F));
        ModelPartData p39 = p25.addChild("nose_horn", ModelPartBuilder.create()
                .uv(280, 146).cuboid(-0.5F, -2.5F, -0.5F, 1F, 3F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, -2.8F, -14.5F, 0.7F, 0F, 0F));
        ModelPartData p40 = p25.addChild("frill0l", ModelPartBuilder.create()
                .uv(32, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.05F)),
                ModelTransform.of(4.2F, -2.5F, -1F, 0.25F, 0.35F, 0.5F));
        ModelPartData p41 = p25.addChild("frill0r", ModelPartBuilder.create()
                .uv(42, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.05F)),
                ModelTransform.of(-4.2F, -2.5F, -1F, 0.25F, -0.35F, -0.5F));
        ModelPartData p42 = p25.addChild("frill1l", ModelPartBuilder.create()
                .uv(284, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(4.2F, -1F, 0F, 0.25F, 0.35F, 0.8F));
        ModelPartData p43 = p25.addChild("frill1r", ModelPartBuilder.create()
                .uv(292, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(-4.2F, -1F, 0F, 0.25F, -0.35F, -0.8F));
        ModelPartData p44 = p25.addChild("frill2l", ModelPartBuilder.create()
                .uv(300, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(4.2F, 0.5F, -1F, 0.25F, 0.35F, 1.1F));
        ModelPartData p45 = p25.addChild("frill2r", ModelPartBuilder.create()
                .uv(308, 146).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(-4.2F, 0.5F, -1F, 0.25F, -0.35F, -1.1F));
        ModelPartData p46 = p25.addChild("crest0", ModelPartBuilder.create()
                .uv(316, 146).cuboid(-0.5F, -2.8F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, -3F, 0.55F, 0F, 0F));
        ModelPartData p47 = p25.addChild("crest1", ModelPartBuilder.create()
                .uv(320, 146).cuboid(-0.5F, -2.5F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, -1.2F, 0.55F, 0F, 0F));
        ModelPartData p48 = p25.addChild("crest2", ModelPartBuilder.create()
                .uv(324, 146).cuboid(-0.5F, -2.2F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, 0.6F, 0.55F, 0F, 0F));
        ModelPartData p49 = p25.addChild("crest3", ModelPartBuilder.create()
                .uv(328, 146).cuboid(-0.5F, -1.9F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, 2.4F, 0.55F, 0F, 0F));
        ModelPartData p50 = p0.addChild("tail0", ModelPartBuilder.create()
                .uv(388, 100).cuboid(-4F, -3F, 0F, 8F, 6F, 5F, new Dilation(0F))
                .uv(232, 86).cuboid(-3F, -4F, 0F, 6F, 8F, 5F, new Dilation(0.01F))
                .uv(486, 132).cuboid(-3F, 3.1F, 0F, 6F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, -1F, 11F, -0.12F, 0F, 0F));
        ModelPartData p51 = p50.addChild("fin", ModelPartBuilder.create()
                .uv(0, 140).cuboid(-0.5F, -4F, -1F, 1F, 4F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p52 = p50.addChild("tail1", ModelPartBuilder.create()
                .uv(178, 112).cuboid(-3.5F, -2.5F, 0F, 7F, 5F, 5F, new Dilation(0.05F))
                .uv(478, 86).cuboid(-2.5F, -3.5F, 0F, 5F, 7F, 5F, new Dilation(0.06F))
                .uv(6, 140).cuboid(-2.5F, 2.6F, 0F, 5F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p53 = p52.addChild("fin", ModelPartBuilder.create()
                .uv(26, 140).cuboid(-0.5F, -3.7F, -1F, 1F, 4F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.5F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p54 = p52.addChild("tail2", ModelPartBuilder.create()
                .uv(52, 123).cuboid(-3F, -2F, 0F, 6F, 4F, 5F, new Dilation(0F))
                .uv(414, 100).cuboid(-2F, -3F, 0F, 4F, 6F, 5F, new Dilation(0.01F))
                .uv(32, 140).cuboid(-2F, 2.1F, 0F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p55 = p54.addChild("fin", ModelPartBuilder.create()
                .uv(52, 146).cuboid(-0.5F, -3.4F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p56 = p54.addChild("tail3", ModelPartBuilder.create()
                .uv(74, 123).cuboid(-3F, -2F, 0F, 6F, 4F, 5F, new Dilation(0.05F))
                .uv(432, 100).cuboid(-2F, -3F, 0F, 4F, 6F, 5F, new Dilation(0.06F))
                .uv(50, 140).cuboid(-2F, 2.1F, 0F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p57 = p56.addChild("fin", ModelPartBuilder.create()
                .uv(58, 146).cuboid(-0.5F, -3.1F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p58 = p56.addChild("tail4", ModelPartBuilder.create()
                .uv(96, 123).cuboid(-3F, -2F, 0F, 6F, 4F, 5F, new Dilation(0F))
                .uv(450, 100).cuboid(-2F, -3F, 0F, 4F, 6F, 5F, new Dilation(0.01F))
                .uv(68, 140).cuboid(-2F, 2.1F, 0F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p59 = p58.addChild("fin", ModelPartBuilder.create()
                .uv(64, 146).cuboid(-0.5F, -2.8F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p60 = p58.addChild("tail5", ModelPartBuilder.create()
                .uv(316, 123).cuboid(-2.5F, -1.5F, 0F, 5F, 3F, 5F, new Dilation(0.05F))
                .uv(202, 112).cuboid(-1.5F, -2.5F, 0F, 3F, 5F, 5F, new Dilation(0.06F))
                .uv(86, 140).cuboid(-1.5F, 1.6F, 0F, 3F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p61 = p60.addChild("fin", ModelPartBuilder.create()
                .uv(332, 146).cuboid(-0.5F, -2.5F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2.5F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p62 = p60.addChild("tail6", ModelPartBuilder.create()
                .uv(128, 132).cuboid(-2F, -1F, 0F, 4F, 2F, 5F, new Dilation(0F))
                .uv(118, 123).cuboid(-1F, -2F, 0F, 2F, 4F, 5F, new Dilation(0.01F))
                .uv(102, 140).cuboid(-1F, 1.1F, 0F, 2F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p63 = p62.addChild("fin", ModelPartBuilder.create()
                .uv(338, 146).cuboid(-0.5F, -2.2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p64 = p62.addChild("tail7", ModelPartBuilder.create()
                .uv(146, 132).cuboid(-2F, -1F, 0F, 4F, 2F, 5F, new Dilation(0.05F))
                .uv(132, 123).cuboid(-1F, -2F, 0F, 2F, 4F, 5F, new Dilation(0.06F))
                .uv(116, 140).cuboid(-1F, 1.1F, 0F, 2F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p65 = p64.addChild("fin", ModelPartBuilder.create()
                .uv(344, 146).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p66 = p64.addChild("tail8", ModelPartBuilder.create()
                .uv(164, 132).cuboid(-2F, -1F, 0F, 4F, 2F, 5F, new Dilation(0F))
                .uv(146, 123).cuboid(-1F, -2F, 0F, 2F, 4F, 5F, new Dilation(0.01F))
                .uv(130, 140).cuboid(-1F, 1.1F, 0F, 2F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p67 = p66.addChild("fin", ModelPartBuilder.create()
                .uv(350, 146).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p68 = p66.addChild("tail9", ModelPartBuilder.create()
                .uv(336, 123).cuboid(-1.5F, -1.5F, 0F, 3F, 3F, 5F, new Dilation(0.05F))
                .uv(352, 123).cuboid(-1.5F, -1.5F, 0F, 3F, 3F, 5F, new Dilation(0.06F))
                .uv(144, 140).cuboid(-0.5F, 0.6F, 0F, 1F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p69 = p68.addChild("fin", ModelPartBuilder.create()
                .uv(356, 146).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -1.5F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p70 = p68.addChild("side_finl", ModelPartBuilder.create()
                .uv(70, 146).cuboid(0F, -0.5F, 0F, 5F, 1F, 4F, new Dilation(-0.1F)),
                ModelTransform.of(1F, 0F, 2F, 0F, 0.4F, 0F));
        ModelPartData p71 = p68.addChild("side_finr", ModelPartBuilder.create()
                .uv(88, 146).cuboid(-5F, -0.5F, 0F, 5F, 1F, 4F, new Dilation(-0.1F)),
                ModelTransform.of(-1F, 0F, 2F, 0F, -0.4F, 0F));
        ModelPartData p72 = p68.addChild("tail10", ModelPartBuilder.create()
                .uv(182, 132).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0F))
                .uv(196, 132).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0.01F))
                .uv(156, 140).cuboid(0F, 0.1F, 0F, 1F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p73 = p72.addChild("fin", ModelPartBuilder.create()
                .uv(362, 146).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -1F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p74 = p72.addChild("tail11", ModelPartBuilder.create()
                .uv(210, 132).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0.05F))
                .uv(224, 132).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0.06F))
                .uv(168, 140).cuboid(0F, 0.1F, 0F, 1F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p75 = p74.addChild("fin", ModelPartBuilder.create()
                .uv(368, 146).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -1F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p76 = p74.addChild("blade", ModelPartBuilder.create()
                .uv(484, 67).cuboid(-0.5F, -4.5F, 0F, 1F, 9F, 5F, new Dilation(0F))
                .uv(368, 123).cuboid(-0.5F, -2.5F, 4.5F, 1F, 5F, 3F, new Dilation(-0.1F))
                .uv(374, 146).cuboid(-0.5F, -1F, 7F, 1F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 5.2F, 0F, 0F, 0F));
        ModelPartData p77 = p76.addChild("shard_l", ModelPartBuilder.create()
                .uv(222, 151).cuboid(0F, -1F, 0F, 4F, 2F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 1F, 0F, 0.6F, 0.3F));
        ModelPartData p78 = p76.addChild("shard_r", ModelPartBuilder.create()
                .uv(232, 151).cuboid(-4F, -1F, 0F, 4F, 2F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 1F, 0F, -0.6F, -0.3F));
        ModelPartData p79 = p0.addChild("left_wing", ModelPartBuilder.create()
                .uv(180, 140).cuboid(0F, -1.8F, -1.8F, 20F, 3F, 3F, new Dilation(0.2F))
                .uv(0, 100).cuboid(0F, -3F, -3F, 5F, 6F, 6F, new Dilation(0F))
                .uv(296, 0).cuboid(0F, -0.25F, 1F, 20F, 1F, 30F, new Dilation(-0.3F)),
                ModelTransform.of(5.5F, -6.5F, -8F, 0.35F, -0.45F, -0.75F));
        ModelPartData p80 = p79.addChild("forearm", ModelPartBuilder.create()
                .uv(380, 146).cuboid(0F, -1.3F, -1.3F, 26F, 2F, 2F, new Dilation(0.25F))
                .uv(0, 0).cuboid(0F, -0.25F, 0.6F, 3F, 1F, 36F, new Dilation(-0.3F))
                .uv(156, 0).cuboid(2.8889F, -0.25F, 0.6F, 3F, 1F, 32F, new Dilation(-0.3F))
                .uv(0, 37).cuboid(5.7778F, -0.25F, 0.6F, 3F, 1F, 29F, new Dilation(-0.3F))
                .uv(128, 37).cuboid(8.6667F, -0.25F, 0.6F, 3F, 1F, 25F, new Dilation(-0.3F))
                .uv(274, 37).cuboid(11.5556F, -0.25F, 0.6F, 3F, 1F, 22F, new Dilation(-0.3F))
                .uv(412, 37).cuboid(14.4444F, -0.25F, 0.6F, 3F, 1F, 20F, new Dilation(-0.3F))
                .uv(76, 67).cuboid(17.3333F, -0.25F, 0.6F, 3F, 1F, 17F, new Dilation(-0.3F))
                .uv(202, 67).cuboid(20.2222F, -0.25F, 0.6F, 3F, 1F, 15F, new Dilation(-0.3F))
                .uv(22, 100).cuboid(23.1111F, -0.25F, 0.6F, 3F, 1F, 11F, new Dilation(-0.3F)),
                ModelTransform.of(20F, 0F, 0F, 0F, 0.55F, 0.35F));
        ModelPartData p81 = p80.addChild("hand", ModelPartBuilder.create()
                .uv(226, 140).cuboid(-1F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0.2F))
                .uv(238, 140).cuboid(0F, -1F, -4.5F, 1F, 2F, 4F, new Dilation(0F)),
                ModelTransform.of(26F, 0F, 0F, 0F, 0.05F, 0F));
        ModelPartData p82 = p81.addChild("finger0", ModelPartBuilder.create()
                .uv(364, 151).cuboid(0F, -0.7F, -0.7F, 34F, 1F, 1F, new Dilation(0.2F))
                .uv(436, 146).cuboid(33F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.1F))
                .uv(434, 151).cuboid(0F, -0.25F, 0.2F, 4F, 1F, 1F, new Dilation(-0.3F))
                .uv(444, 146).cuboid(3.7778F, -0.25F, 0.2F, 4F, 1F, 3F, new Dilation(-0.3F))
                .uv(248, 140).cuboid(7.5556F, -0.25F, 0.2F, 4F, 1F, 5F, new Dilation(-0.3F))
                .uv(376, 123).cuboid(11.3333F, -0.25F, 0.2F, 4F, 1F, 7F, new Dilation(-0.3F))
                .uv(218, 112).cuboid(15.1111F, -0.25F, 0.2F, 4F, 1F, 9F, new Dilation(-0.3F))
                .uv(50, 100).cuboid(18.8889F, -0.25F, 0.2F, 4F, 1F, 11F, new Dilation(-0.3F))
                .uv(0, 86).cuboid(22.6667F, -0.25F, 0.2F, 4F, 1F, 13F, new Dilation(-0.3F))
                .uv(80, 100).cuboid(26.4444F, -0.25F, 0.2F, 4F, 1F, 11F, new Dilation(-0.3F))
                .uv(444, 151).cuboid(30.2222F, -0.25F, 0.2F, 4F, 1F, 1F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0F, 0F));
        ModelPartData p83 = p81.addChild("finger1", ModelPartBuilder.create()
                .uv(0, 155).cuboid(0F, -0.7F, -0.7F, 31F, 1F, 1F, new Dilation(0.15F))
                .uv(458, 146).cuboid(30F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.1F))
                .uv(64, 155).cuboid(0F, -0.25F, 0.2F, 3F, 1F, 1F, new Dilation(-0.3F))
                .uv(242, 151).cuboid(3.4444F, -0.25F, 0.2F, 3F, 1F, 2F, new Dilation(-0.3F))
                .uv(106, 146).cuboid(6.8889F, -0.25F, 0.2F, 3F, 1F, 4F, new Dilation(-0.3F))
                .uv(238, 132).cuboid(10.3333F, -0.25F, 0.2F, 3F, 1F, 6F, new Dilation(-0.3F))
                .uv(160, 123).cuboid(13.7778F, -0.25F, 0.2F, 3F, 1F, 8F, new Dilation(-0.3F))
                .uv(468, 100).cuboid(17.2222F, -0.25F, 0.2F, 3F, 1F, 10F, new Dilation(-0.3F))
                .uv(254, 86).cuboid(20.6667F, -0.25F, 0.2F, 3F, 1F, 12F, new Dilation(-0.3F))
                .uv(398, 123).cuboid(24.1111F, -0.25F, 0.2F, 3F, 1F, 7F, new Dilation(-0.3F))
                .uv(72, 155).cuboid(27.5556F, -0.25F, 0.2F, 3F, 1F, 1F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.5F, 0F));
        ModelPartData p84 = p81.addChild("finger2", ModelPartBuilder.create()
                .uv(80, 155).cuboid(0F, -0.7F, -0.7F, 27F, 1F, 1F, new Dilation(0.1F))
                .uv(466, 146).cuboid(26F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.1F))
                .uv(136, 155).cuboid(0F, -0.25F, 0.2F, 3F, 1F, 1F, new Dilation(-0.3F))
                .uv(252, 151).cuboid(3F, -0.25F, 0.2F, 3F, 1F, 2F, new Dilation(-0.3F))
                .uv(120, 146).cuboid(6F, -0.25F, 0.2F, 3F, 1F, 4F, new Dilation(-0.3F))
                .uv(266, 140).cuboid(9F, -0.25F, 0.2F, 3F, 1F, 5F, new Dilation(-0.3F))
                .uv(418, 123).cuboid(12F, -0.25F, 0.2F, 3F, 1F, 7F, new Dilation(-0.3F))
                .uv(244, 112).cuboid(15F, -0.25F, 0.2F, 3F, 1F, 9F, new Dilation(-0.3F))
                .uv(0, 112).cuboid(18F, -0.25F, 0.2F, 3F, 1F, 10F, new Dilation(-0.3F))
                .uv(474, 146).cuboid(21F, -0.25F, 0.2F, 3F, 1F, 3F, new Dilation(-0.3F))
                .uv(144, 155).cuboid(24F, -0.25F, 0.2F, 3F, 1F, 1F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -1F, 0F));
        ModelPartData p85 = p81.addChild("finger3", ModelPartBuilder.create()
                .uv(152, 155).cuboid(0F, -0.7F, -0.7F, 22F, 1F, 1F, new Dilation(0.05F))
                .uv(486, 146).cuboid(21F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.1F))
                .uv(198, 155).cuboid(0F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(204, 155).cuboid(2.4444F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(210, 155).cuboid(4.8889F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(216, 155).cuboid(7.3333F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(222, 155).cuboid(9.7778F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(228, 155).cuboid(12.2222F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(234, 155).cuboid(14.6667F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(240, 155).cuboid(17.1111F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(246, 155).cuboid(19.5556F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -1.5F, 0F));
        ModelPartData p86 = p0.addChild("right_wing", ModelPartBuilder.create()
                .uv(282, 140).cuboid(-20F, -1.8F, -1.8F, 20F, 3F, 3F, new Dilation(0.2F))
                .uv(110, 100).cuboid(-5F, -3F, -3F, 5F, 6F, 6F, new Dilation(0F))
                .uv(396, 0).cuboid(-20F, -0.25F, 1F, 20F, 1F, 30F, new Dilation(-0.3F)),
                ModelTransform.of(-5.5F, -6.5F, -8F, 0.35F, 0.45F, 0.75F));
        ModelPartData p87 = p86.addChild("forearm", ModelPartBuilder.create()
                .uv(0, 151).cuboid(-26F, -1.3F, -1.3F, 26F, 2F, 2F, new Dilation(0.25F))
                .uv(78, 0).cuboid(-3F, -0.25F, 0.6F, 3F, 1F, 36F, new Dilation(-0.3F))
                .uv(226, 0).cuboid(-5.8889F, -0.25F, 0.6F, 3F, 1F, 32F, new Dilation(-0.3F))
                .uv(64, 37).cuboid(-8.7778F, -0.25F, 0.6F, 3F, 1F, 29F, new Dilation(-0.3F))
                .uv(184, 37).cuboid(-11.6667F, -0.25F, 0.6F, 3F, 1F, 25F, new Dilation(-0.3F))
                .uv(324, 37).cuboid(-14.5556F, -0.25F, 0.6F, 3F, 1F, 22F, new Dilation(-0.3F))
                .uv(458, 37).cuboid(-17.4444F, -0.25F, 0.6F, 3F, 1F, 20F, new Dilation(-0.3F))
                .uv(116, 67).cuboid(-20.3333F, -0.25F, 0.6F, 3F, 1F, 17F, new Dilation(-0.3F))
                .uv(238, 67).cuboid(-23.2222F, -0.25F, 0.6F, 3F, 1F, 15F, new Dilation(-0.3F))
                .uv(132, 100).cuboid(-26.1111F, -0.25F, 0.6F, 3F, 1F, 11F, new Dilation(-0.3F)),
                ModelTransform.of(-20F, 0F, 0F, 0F, -0.55F, -0.35F));
        ModelPartData p88 = p87.addChild("hand", ModelPartBuilder.create()
                .uv(328, 140).cuboid(-2F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0.2F))
                .uv(340, 140).cuboid(-1F, -1F, -4.5F, 1F, 2F, 4F, new Dilation(0F)),
                ModelTransform.of(-26F, 0F, 0F, 0F, -0.05F, 0F));
        ModelPartData p89 = p88.addChild("finger0", ModelPartBuilder.create()
                .uv(252, 155).cuboid(-34F, -0.7F, -0.7F, 34F, 1F, 1F, new Dilation(0.2F))
                .uv(56, 151).cuboid(-35F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.1F))
                .uv(322, 155).cuboid(-4F, -0.25F, 0.2F, 4F, 1F, 1F, new Dilation(-0.3F))
                .uv(64, 151).cuboid(-7.7778F, -0.25F, 0.2F, 4F, 1F, 3F, new Dilation(-0.3F))
                .uv(350, 140).cuboid(-11.5556F, -0.25F, 0.2F, 4F, 1F, 5F, new Dilation(-0.3F))
                .uv(438, 123).cuboid(-15.3333F, -0.25F, 0.2F, 4F, 1F, 7F, new Dilation(-0.3F))
                .uv(268, 112).cuboid(-19.1111F, -0.25F, 0.2F, 4F, 1F, 9F, new Dilation(-0.3F))
                .uv(160, 100).cuboid(-22.8889F, -0.25F, 0.2F, 4F, 1F, 11F, new Dilation(-0.3F))
                .uv(34, 86).cuboid(-26.6667F, -0.25F, 0.2F, 4F, 1F, 13F, new Dilation(-0.3F))
                .uv(190, 100).cuboid(-30.4444F, -0.25F, 0.2F, 4F, 1F, 11F, new Dilation(-0.3F))
                .uv(332, 155).cuboid(-34.2222F, -0.25F, 0.2F, 4F, 1F, 1F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0F, 0F));
        ModelPartData p90 = p88.addChild("finger1", ModelPartBuilder.create()
                .uv(342, 155).cuboid(-31F, -0.7F, -0.7F, 31F, 1F, 1F, new Dilation(0.15F))
                .uv(78, 151).cuboid(-32F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.1F))
                .uv(406, 155).cuboid(-3F, -0.25F, 0.2F, 3F, 1F, 1F, new Dilation(-0.3F))
                .uv(262, 151).cuboid(-6.4444F, -0.25F, 0.2F, 3F, 1F, 2F, new Dilation(-0.3F))
                .uv(134, 146).cuboid(-9.8889F, -0.25F, 0.2F, 3F, 1F, 4F, new Dilation(-0.3F))
                .uv(256, 132).cuboid(-13.3333F, -0.25F, 0.2F, 3F, 1F, 6F, new Dilation(-0.3F))
                .uv(182, 123).cuboid(-16.7778F, -0.25F, 0.2F, 3F, 1F, 8F, new Dilation(-0.3F))
                .uv(26, 112).cuboid(-20.2222F, -0.25F, 0.2F, 3F, 1F, 10F, new Dilation(-0.3F))
                .uv(284, 86).cuboid(-23.6667F, -0.25F, 0.2F, 3F, 1F, 12F, new Dilation(-0.3F))
                .uv(460, 123).cuboid(-27.1111F, -0.25F, 0.2F, 3F, 1F, 7F, new Dilation(-0.3F))
                .uv(414, 155).cuboid(-30.5556F, -0.25F, 0.2F, 3F, 1F, 1F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.5F, 0F));
        ModelPartData p91 = p88.addChild("finger2", ModelPartBuilder.create()
                .uv(422, 155).cuboid(-27F, -0.7F, -0.7F, 27F, 1F, 1F, new Dilation(0.1F))
                .uv(86, 151).cuboid(-28F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.1F))
                .uv(478, 155).cuboid(-3F, -0.25F, 0.2F, 3F, 1F, 1F, new Dilation(-0.3F))
                .uv(272, 151).cuboid(-6F, -0.25F, 0.2F, 3F, 1F, 2F, new Dilation(-0.3F))
                .uv(148, 146).cuboid(-9F, -0.25F, 0.2F, 3F, 1F, 4F, new Dilation(-0.3F))
                .uv(368, 140).cuboid(-12F, -0.25F, 0.2F, 3F, 1F, 5F, new Dilation(-0.3F))
                .uv(480, 123).cuboid(-15F, -0.25F, 0.2F, 3F, 1F, 7F, new Dilation(-0.3F))
                .uv(294, 112).cuboid(-18F, -0.25F, 0.2F, 3F, 1F, 9F, new Dilation(-0.3F))
                .uv(52, 112).cuboid(-21F, -0.25F, 0.2F, 3F, 1F, 10F, new Dilation(-0.3F))
                .uv(94, 151).cuboid(-24F, -0.25F, 0.2F, 3F, 1F, 3F, new Dilation(-0.3F))
                .uv(486, 155).cuboid(-27F, -0.25F, 0.2F, 3F, 1F, 1F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 1F, 0F));
        ModelPartData p92 = p88.addChild("finger3", ModelPartBuilder.create()
                .uv(0, 157).cuboid(-22F, -0.7F, -0.7F, 22F, 1F, 1F, new Dilation(0.05F))
                .uv(106, 151).cuboid(-23F, -1F, -1F, 2F, 2F, 2F, new Dilation(-0.1F))
                .uv(46, 157).cuboid(-2F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(52, 157).cuboid(-4.4444F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(58, 157).cuboid(-6.8889F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(64, 157).cuboid(-9.3333F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(70, 157).cuboid(-11.7778F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(76, 157).cuboid(-14.2222F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(82, 157).cuboid(-16.6667F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(88, 157).cuboid(-19.1111F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F))
                .uv(94, 157).cuboid(-21.5556F, -0.25F, 0.2F, 2F, 1F, 1F, new Dilation(-0.3F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 1.5F, 0F));
        ModelPartData p93 = p0.addChild("left_front_leg", ModelPartBuilder.create()
                .uv(204, 123).cuboid(-2.2F, -1F, -2.2F, 4F, 5F, 4F, new Dilation(0.1F))
                .uv(78, 112).cuboid(-1.2F, -2F, -2.2F, 2F, 7F, 4F, new Dilation(0.11F)),
                ModelTransform.of(7.2F, 1F, -8.5F, 0.35F, 0F, -0.32F));
        ModelPartData p94 = p93.addChild("shin", ModelPartBuilder.create()
                .uv(500, 123).cuboid(-1.6F, 1F, -1.6F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(318, 112).cuboid(-0.6F, 0F, -1.6F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 5.5F, 0F, -0.55F, 0F, 0.3F));
        ModelPartData p95 = p94.addChild("foot", ModelPartBuilder.create()
                .uv(384, 140).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.25F, 0F, 0F));
        ModelPartData p96 = p95.addChild("toe0", ModelPartBuilder.create()
                .uv(114, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p97 = p96.addChild("claw", ModelPartBuilder.create()
                .uv(282, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p98 = p95.addChild("toe1", ModelPartBuilder.create()
                .uv(122, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p99 = p98.addChild("claw", ModelPartBuilder.create()
                .uv(288, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p100 = p95.addChild("toe2", ModelPartBuilder.create()
                .uv(130, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p101 = p100.addChild("claw", ModelPartBuilder.create()
                .uv(294, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p102 = p0.addChild("right_front_leg", ModelPartBuilder.create()
                .uv(220, 123).cuboid(-2.2F, -1F, -2.2F, 4F, 5F, 4F, new Dilation(0.1F))
                .uv(90, 112).cuboid(-1.2F, -2F, -2.2F, 2F, 7F, 4F, new Dilation(0.11F)),
                ModelTransform.of(-7.2F, 1F, -8.5F, 0.35F, 0F, 0.32F));
        ModelPartData p103 = p102.addChild("shin", ModelPartBuilder.create()
                .uv(0, 132).cuboid(-1.6F, 1F, -1.6F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(326, 112).cuboid(-0.6F, 0F, -1.6F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 5.5F, 0F, -0.55F, 0F, -0.3F));
        ModelPartData p104 = p103.addChild("foot", ModelPartBuilder.create()
                .uv(402, 140).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.25F, 0F, 0F));
        ModelPartData p105 = p104.addChild("toe0", ModelPartBuilder.create()
                .uv(138, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p106 = p105.addChild("claw", ModelPartBuilder.create()
                .uv(300, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p107 = p104.addChild("toe1", ModelPartBuilder.create()
                .uv(146, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p108 = p107.addChild("claw", ModelPartBuilder.create()
                .uv(306, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p109 = p104.addChild("toe2", ModelPartBuilder.create()
                .uv(154, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p110 = p109.addChild("claw", ModelPartBuilder.create()
                .uv(312, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p111 = p0.addChild("left_hind_leg", ModelPartBuilder.create()
                .uv(314, 86).cuboid(-3F, -2F, -3.2F, 6F, 7F, 6F, new Dilation(0.05F))
                .uv(304, 67).cuboid(-2F, -3F, -3.2F, 4F, 9F, 6F, new Dilation(0.06F))
                .uv(12, 132).cuboid(-2.5F, -3.5F, -1F, 5F, 3F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(7F, -0.5F, 7F, -0.45F, 0F, -0.28F));
        ModelPartData p112 = p111.addChild("shin", ModelPartBuilder.create()
                .uv(32, 132).cuboid(-1.8F, 1F, -1.8F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(334, 112).cuboid(-0.8F, 0F, -1.8F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 6.5F, -0.5F, 0.95F, 0F, 0.26F));
        ModelPartData p113 = p112.addChild("ankle", ModelPartBuilder.create()
                .uv(420, 140).cuboid(-1.5F, 1F, -1.5F, 3F, 3F, 3F, new Dilation(0.15F))
                .uv(44, 132).cuboid(-0.5F, 0F, -1.5F, 1F, 5F, 3F, new Dilation(0.16F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.6F, 0F, 0F));
        ModelPartData p114 = p113.addChild("foot", ModelPartBuilder.create()
                .uv(432, 140).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6F, 0F, 0.4F, 0F, 0F));
        ModelPartData p115 = p114.addChild("toe0", ModelPartBuilder.create()
                .uv(162, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p116 = p115.addChild("claw", ModelPartBuilder.create()
                .uv(318, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p117 = p114.addChild("toe1", ModelPartBuilder.create()
                .uv(170, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p118 = p117.addChild("claw", ModelPartBuilder.create()
                .uv(324, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p119 = p114.addChild("toe2", ModelPartBuilder.create()
                .uv(178, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p120 = p119.addChild("claw", ModelPartBuilder.create()
                .uv(330, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p121 = p0.addChild("right_hind_leg", ModelPartBuilder.create()
                .uv(338, 86).cuboid(-3F, -2F, -3.2F, 6F, 7F, 6F, new Dilation(0.05F))
                .uv(324, 67).cuboid(-2F, -3F, -3.2F, 4F, 9F, 6F, new Dilation(0.06F))
                .uv(52, 132).cuboid(-2.5F, -3.5F, -1F, 5F, 3F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(-7F, -0.5F, 7F, -0.45F, 0F, 0.28F));
        ModelPartData p122 = p121.addChild("shin", ModelPartBuilder.create()
                .uv(72, 132).cuboid(-1.8F, 1F, -1.8F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(342, 112).cuboid(-0.8F, 0F, -1.8F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 6.5F, -0.5F, 0.95F, 0F, -0.26F));
        ModelPartData p123 = p122.addChild("ankle", ModelPartBuilder.create()
                .uv(450, 140).cuboid(-1.5F, 1F, -1.5F, 3F, 3F, 3F, new Dilation(0.15F))
                .uv(84, 132).cuboid(-0.5F, 0F, -1.5F, 1F, 5F, 3F, new Dilation(0.16F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.6F, 0F, 0F));
        ModelPartData p124 = p123.addChild("foot", ModelPartBuilder.create()
                .uv(462, 140).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6F, 0F, 0.4F, 0F, 0F));
        ModelPartData p125 = p124.addChild("toe0", ModelPartBuilder.create()
                .uv(186, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p126 = p125.addChild("claw", ModelPartBuilder.create()
                .uv(336, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p127 = p124.addChild("toe1", ModelPartBuilder.create()
                .uv(194, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p128 = p127.addChild("claw", ModelPartBuilder.create()
                .uv(342, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p129 = p124.addChild("toe2", ModelPartBuilder.create()
                .uv(202, 151).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p130 = p129.addChild("claw", ModelPartBuilder.create()
                .uv(348, 151).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        return TexturedModelData.of(modelData, 512, 256);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }

    @Override
    public void setAngles(T e, float limbAngle, float limbDistance, float age, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        float beat = age * (e.isDiving() ? 0.32F : 0.2F);
        float s = MathHelper.sin(beat);
        // wings: three joints, each lagging behind the previous one
        lWing.roll += s * 0.4F;
        rWing.roll -= s * 0.4F;
        lFore.roll += MathHelper.sin(beat - 0.7F) * 0.4F;
        rFore.roll -= MathHelper.sin(beat - 0.7F) * 0.4F;
        lHand.roll += MathHelper.sin(beat - 1.4F) * 0.3F;
        rHand.roll -= MathHelper.sin(beat - 1.4F) * 0.3F;
        body.pivotY += -s * 1.2F;
        // tail: travelling wave
        for (int i = 0; i < tail.length; i++) {
            tail[i].yaw += MathHelper.sin(age * 0.09F - i * 0.55F) * 0.09F;
            tail[i].pitch += MathHelper.cos(age * 0.07F - i * 0.4F) * 0.03F;
        }
        // neck follows the look direction, spread over the four segments
        float yaw = headYaw * ((float) Math.PI / 180F) / 7.0F;
        float pitch = headPitch * ((float) Math.PI / 180F) / 7.0F;
        for (ModelPart p : neck) {
            p.yaw += yaw;
            p.pitch += pitch + MathHelper.sin(age * 0.05F) * 0.02F;
        }
        head.yaw += yaw;
        // jaw opens while breathing or roaring
        jaw.pitch += e.getJawOpen() * 0.75F + MathHelper.sin(age * 0.1F) * 0.03F;
        // legs tucked in flight
        for (int i = 0; i < 4; i++) {
            legs[i].pitch += (i < 2 ? 0.7F : 0.9F);
        }
    }
}
