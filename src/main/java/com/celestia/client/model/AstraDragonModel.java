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

/** Huya, the Violet Star Dragon. Half-scale geometry; the renderer scales it by 2. Texture image is 4x denser than the declared size. (512x128 texture) */
public class AstraDragonModel<T extends AstraDragonEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root, body, jaw, head;
    private final ModelPart[] neck = new ModelPart[6];
    private final ModelPart[] tail = new ModelPart[10];
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
        for (int i = 0; i < 10; i++) {
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
                .uv(78, 0).cuboid(-6.5F, -4.5F, -6F, 13F, 8F, 12F, new Dilation(0.05F))
                .uv(0, 0).cuboid(-4.5F, -6.5F, -6F, 9F, 12F, 12F, new Dilation(0.06F))
                .uv(446, 0).cuboid(-5F, 4.5F, -6F, 10F, 2F, 12F, new Dilation(0.1F)),
                ModelTransform.of(0F, 5F, 0F, 0F, 0F, 0F));
        ModelPartData p1 = p0.addChild("chest", ModelPartBuilder.create()
                .uv(160, 0).cuboid(-6.5F, -4.5F, -8F, 13F, 8F, 9F, new Dilation(0F))
                .uv(42, 0).cuboid(-4.5F, -6.5F, -8F, 9F, 12F, 9F, new Dilation(0.01F))
                .uv(436, 24).cuboid(-5F, 4F, -8F, 10F, 2F, 9F, new Dilation(0.1F))
                .uv(148, 24).cuboid(-4.5F, -4F, -10F, 9F, 9F, 3F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, -6F, -0.08F, 0F, 0F));
        ModelPartData p2 = p0.addChild("hips", ModelPartBuilder.create()
                .uv(336, 0).cuboid(-6F, -4F, 0F, 12F, 7F, 8F, new Dilation(0F))
                .uv(128, 0).cuboid(-4F, -6F, 0F, 8F, 11F, 8F, new Dilation(0.01F))
                .uv(156, 48).cuboid(-4.5F, 3.5F, 0F, 9F, 2F, 7F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 6F, 0.06F, 0F, 0F));
        ModelPartData p3 = p0.addChild("plate0", ModelPartBuilder.create()
                .uv(498, 48).cuboid(-0.5F, -6F, -1.2F, 1F, 6F, 2F, new Dilation(0F))
                .uv(152, 72).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -12F, -0.5F, 0F, 0F));
        ModelPartData p4 = p0.addChild("plate1", ModelPartBuilder.create()
                .uv(504, 48).cuboid(-0.5F, -5.5F, -1.2F, 1F, 6F, 2F, new Dilation(0F))
                .uv(162, 72).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -9.2F, -0.5F, 0F, 0F));
        ModelPartData p5 = p0.addChild("plate2", ModelPartBuilder.create()
                .uv(252, 58).cuboid(-0.5F, -5F, -1.2F, 1F, 5F, 2F, new Dilation(0F))
                .uv(172, 72).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -6.4F, -0.5F, 0F, 0F));
        ModelPartData p6 = p0.addChild("plate3", ModelPartBuilder.create()
                .uv(456, 58).cuboid(-0.5F, -4.5F, -1.2F, 1F, 4F, 2F, new Dilation(0F))
                .uv(182, 72).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -3.6F, -0.5F, 0F, 0F));
        ModelPartData p7 = p0.addChild("plate4", ModelPartBuilder.create()
                .uv(462, 58).cuboid(-0.5F, -4F, -1.2F, 1F, 4F, 2F, new Dilation(0F))
                .uv(192, 72).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -0.8F, -0.5F, 0F, 0F));
        ModelPartData p8 = p0.addChild("plate5", ModelPartBuilder.create()
                .uv(468, 58).cuboid(-0.5F, -3.5F, -1.2F, 1F, 4F, 2F, new Dilation(0F))
                .uv(202, 72).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 2F, -0.5F, 0F, 0F));
        ModelPartData p9 = p0.addChild("plate6", ModelPartBuilder.create()
                .uv(0, 72).cuboid(-0.5F, -3F, -1.2F, 1F, 3F, 2F, new Dilation(0F))
                .uv(212, 72).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 4.8F, -0.5F, 0F, 0F));
        ModelPartData p10 = p0.addChild("plate7", ModelPartBuilder.create()
                .uv(222, 72).cuboid(-0.5F, -2.5F, -1.2F, 1F, 2F, 2F, new Dilation(0F))
                .uv(228, 72).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 7.6F, -0.5F, 0F, 0F));
        ModelPartData p11 = p0.addChild("plate8", ModelPartBuilder.create()
                .uv(238, 72).cuboid(-0.5F, -2F, -1.2F, 1F, 2F, 2F, new Dilation(0F))
                .uv(244, 72).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 10.4F, -0.5F, 0F, 0F));
        ModelPartData p12 = p0.addChild("neck_root", ModelPartBuilder.create(),
                ModelTransform.of(0F, -3F, -12F, 0F, 0F, 0F));
        ModelPartData p13 = p12.addChild("neck0", ModelPartBuilder.create()
                .uv(474, 24).cuboid(-4F, -3F, -5F, 8F, 6F, 5F, new Dilation(0F))
                .uv(0, 24).cuboid(-3F, -4F, -5F, 6F, 8F, 5F, new Dilation(0.01F))
                .uv(474, 58).cuboid(-2.8F, 3F, -5F, 5F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -1F, -0.55F, 0F, 0F));
        ModelPartData p14 = p13.addChild("fin", ModelPartBuilder.create()
                .uv(6, 72).cuboid(-0.5F, -3F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p15 = p13.addChild("neck1", ModelPartBuilder.create()
                .uv(418, 37).cuboid(-3.75F, -2.75F, -5F, 7F, 5F, 5F, new Dilation(0.05F))
                .uv(172, 24).cuboid(-2.75F, -3.75F, -5F, 5F, 7F, 5F, new Dilation(0.06F))
                .uv(0, 66).cuboid(-2.55F, 2.75F, -5F, 5F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, -0.3F, 0F, 0F));
        ModelPartData p16 = p15.addChild("fin", ModelPartBuilder.create()
                .uv(12, 72).cuboid(-0.5F, -2.8F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.75F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p17 = p15.addChild("neck2", ModelPartBuilder.create()
                .uv(442, 37).cuboid(-3.5F, -2.5F, -5F, 7F, 5F, 5F, new Dilation(0F))
                .uv(192, 24).cuboid(-2.5F, -3.5F, -5F, 5F, 7F, 5F, new Dilation(0.01F))
                .uv(20, 66).cuboid(-2.3F, 2.5F, -5F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, -0.12F, 0F, 0F));
        ModelPartData p18 = p17.addChild("fin", ModelPartBuilder.create()
                .uv(18, 72).cuboid(-0.5F, -2.6F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.5F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p19 = p17.addChild("neck3", ModelPartBuilder.create()
                .uv(188, 48).cuboid(-3.25F, -2.25F, -5F, 6F, 4F, 5F, new Dilation(0.05F))
                .uv(0, 37).cuboid(-2.25F, -3.25F, -5F, 4F, 6F, 5F, new Dilation(0.06F))
                .uv(38, 66).cuboid(-2.05F, 2.25F, -5F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, 0.05F, 0F, 0F));
        ModelPartData p20 = p19.addChild("fin", ModelPartBuilder.create()
                .uv(24, 72).cuboid(-0.5F, -2.4F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.25F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p21 = p19.addChild("neck4", ModelPartBuilder.create()
                .uv(210, 48).cuboid(-3F, -2F, -5F, 6F, 4F, 5F, new Dilation(0F))
                .uv(18, 37).cuboid(-2F, -3F, -5F, 4F, 6F, 5F, new Dilation(0.01F))
                .uv(56, 66).cuboid(-1.8F, 2F, -5F, 3F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, 0.2F, 0F, 0F));
        ModelPartData p22 = p21.addChild("fin", ModelPartBuilder.create()
                .uv(30, 72).cuboid(-0.5F, -2.2F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p23 = p21.addChild("neck5", ModelPartBuilder.create()
                .uv(0, 58).cuboid(-2.75F, -1.75F, -5F, 5F, 3F, 5F, new Dilation(0.05F))
                .uv(466, 37).cuboid(-1.75F, -2.75F, -5F, 3F, 5F, 5F, new Dilation(0.06F))
                .uv(72, 66).cuboid(-1.55F, 1.75F, -5F, 3F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, 0.3F, 0F, 0F));
        ModelPartData p24 = p23.addChild("fin", ModelPartBuilder.create()
                .uv(36, 72).cuboid(-0.5F, -2F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2.75F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p25 = p23.addChild("head", ModelPartBuilder.create()
                .uv(22, 24).cuboid(-4.5F, -3F, -7F, 9F, 5F, 8F, new Dilation(0F))
                .uv(376, 0).cuboid(-3.5F, -4F, -7F, 7F, 7F, 8F, new Dilation(0.01F))
                .uv(258, 58).cuboid(-5F, -4.6F, -6.2F, 10F, 2F, 5F, new Dilation(-0.1F))
                .uv(232, 48).cuboid(-3.5F, -1.8F, -12F, 7F, 3F, 6F, new Dilation(0F))
                .uv(36, 37).cuboid(-2.5F, -2.8F, -12F, 5F, 5F, 6F, new Dilation(0.01F))
                .uv(88, 66).cuboid(-2.8F, -1.4F, -15.5F, 6F, 2F, 4F, new Dilation(0F))
                .uv(20, 58).cuboid(-1.8F, -2.4F, -15.5F, 4F, 4F, 4F, new Dilation(0.01F))
                .uv(482, 37).cuboid(-2.6F, 1.6F, -15.2F, 1F, 1F, 9F, new Dilation(-0.15F))
                .uv(0, 48).cuboid(1.6F, 1.6F, -15.2F, 1F, 1F, 9F, new Dilation(-0.15F))
                .uv(36, 58).cuboid(-1.5F, -3.2F, -12F, 3F, 1F, 7F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, -6.5F, 0.45F, 0F, 0F));
        ModelPartData p26 = p25.addChild("jaw", ModelPartBuilder.create()
                .uv(212, 24).cuboid(-3F, 0F, -10F, 6F, 2F, 10F, new Dilation(0F))
                .uv(244, 24).cuboid(-3F, 0F, -10F, 6F, 2F, 10F, new Dilation(0.01F))
                .uv(20, 48).cuboid(-2.5F, 1.6F, -9.5F, 5F, 1F, 9F, new Dilation(0F))
                .uv(258, 48).cuboid(-2.6F, -0.8F, -9.6F, 1F, 1F, 8F, new Dilation(-0.15F))
                .uv(276, 48).cuboid(1.6F, -0.8F, -9.6F, 1F, 1F, 8F, new Dilation(-0.15F))
                .uv(224, 77).cuboid(-1.8F, -0.8F, -10.2F, 4F, 1F, 1F, new Dilation(-0.15F))
                .uv(108, 66).cuboid(-3.5F, 0.5F, -3F, 1F, 2F, 4F, new Dilation(0F))
                .uv(118, 66).cuboid(2.5F, 0.5F, -3F, 1F, 2F, 4F, new Dilation(0F)),
                ModelTransform.of(0F, 2.2F, -6F, 0.12F, 0F, 0F));
        ModelPartData p27 = p25.addChild("lhorn0", ModelPartBuilder.create()
                .uv(56, 58).cuboid(-1F, -1F, 0F, 2F, 2F, 6F, new Dilation(0.15F)),
                ModelTransform.of(2.6F, -3.2F, 0F, 0.45F, 0.32F, 0.12F));
        ModelPartData p28 = p27.addChild("lhorn1", ModelPartBuilder.create()
                .uv(288, 58).cuboid(-0.75F, -0.75F, 0F, 2F, 2F, 5F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 5.6F, 0.28F, 0.06F, 0F));
        ModelPartData p29 = p28.addChild("lhorn2", ModelPartBuilder.create()
                .uv(42, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.01F)),
                ModelTransform.of(0F, 0F, 4.6F, 0.28F, 0.06F, 0F));
        ModelPartData p30 = p29.addChild("lhorn3", ModelPartBuilder.create()
                .uv(254, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.09F)),
                ModelTransform.of(0F, 0F, 3.6F, 0.28F, 0.06F, 0F));
        ModelPartData p31 = p25.addChild("rhorn0", ModelPartBuilder.create()
                .uv(72, 58).cuboid(-1F, -1F, 0F, 2F, 2F, 6F, new Dilation(0.15F)),
                ModelTransform.of(-2.6F, -3.2F, 0F, 0.45F, -0.32F, -0.12F));
        ModelPartData p32 = p31.addChild("rhorn1", ModelPartBuilder.create()
                .uv(302, 58).cuboid(-0.75F, -0.75F, 0F, 2F, 2F, 5F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 5.6F, 0.28F, -0.06F, 0F));
        ModelPartData p33 = p32.addChild("rhorn2", ModelPartBuilder.create()
                .uv(52, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.01F)),
                ModelTransform.of(0F, 0F, 4.6F, 0.28F, -0.06F, 0F));
        ModelPartData p34 = p33.addChild("rhorn3", ModelPartBuilder.create()
                .uv(262, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.09F)),
                ModelTransform.of(0F, 0F, 3.6F, 0.28F, -0.06F, 0F));
        ModelPartData p35 = p25.addChild("lhorn_s0", ModelPartBuilder.create()
                .uv(270, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0.15F)),
                ModelTransform.of(3.6F, -1.2F, -1F, 0.2F, 0.75F, 0.05F));
        ModelPartData p36 = p35.addChild("lhorn_s1", ModelPartBuilder.create()
                .uv(120, 77).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 2.6F, 0.28F, 0.06F, 0F));
        ModelPartData p37 = p25.addChild("rhorn_s0", ModelPartBuilder.create()
                .uv(278, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0.15F)),
                ModelTransform.of(-3.6F, -1.2F, -1F, 0.2F, -0.75F, -0.05F));
        ModelPartData p38 = p37.addChild("rhorn_s1", ModelPartBuilder.create()
                .uv(126, 77).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 2.6F, 0.28F, -0.06F, 0F));
        ModelPartData p39 = p25.addChild("nose_horn", ModelPartBuilder.create()
                .uv(286, 72).cuboid(-0.5F, -2.5F, -0.5F, 1F, 3F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, -2.8F, -13.5F, 0.55F, 0F, 0F));
        ModelPartData p40 = p25.addChild("frill0l", ModelPartBuilder.create()
                .uv(62, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.05F)),
                ModelTransform.of(4.2F, -2.5F, -1F, 0.25F, 0.35F, 0.5F));
        ModelPartData p41 = p25.addChild("frill0r", ModelPartBuilder.create()
                .uv(72, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.05F)),
                ModelTransform.of(-4.2F, -2.5F, -1F, 0.25F, -0.35F, -0.5F));
        ModelPartData p42 = p25.addChild("frill1l", ModelPartBuilder.create()
                .uv(290, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(4.2F, -1F, 0F, 0.25F, 0.35F, 0.8F));
        ModelPartData p43 = p25.addChild("frill1r", ModelPartBuilder.create()
                .uv(298, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(-4.2F, -1F, 0F, 0.25F, -0.35F, -0.8F));
        ModelPartData p44 = p25.addChild("frill2l", ModelPartBuilder.create()
                .uv(306, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(4.2F, 0.5F, -1F, 0.25F, 0.35F, 1.1F));
        ModelPartData p45 = p25.addChild("frill2r", ModelPartBuilder.create()
                .uv(314, 72).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(-4.2F, 0.5F, -1F, 0.25F, -0.35F, -1.1F));
        ModelPartData p46 = p25.addChild("crest0", ModelPartBuilder.create()
                .uv(322, 72).cuboid(-0.5F, -2.8F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, -3F, 0.55F, 0F, 0F));
        ModelPartData p47 = p25.addChild("crest1", ModelPartBuilder.create()
                .uv(326, 72).cuboid(-0.5F, -2.5F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, -1.2F, 0.55F, 0F, 0F));
        ModelPartData p48 = p25.addChild("crest2", ModelPartBuilder.create()
                .uv(330, 72).cuboid(-0.5F, -2.2F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, 0.6F, 0.55F, 0F, 0F));
        ModelPartData p49 = p25.addChild("crest3", ModelPartBuilder.create()
                .uv(334, 72).cuboid(-0.5F, -1.9F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, 2.4F, 0.55F, 0F, 0F));
        ModelPartData p50 = p0.addChild("tail0", ModelPartBuilder.create()
                .uv(58, 37).cuboid(-4F, -3F, 0F, 8F, 6F, 5F, new Dilation(0F))
                .uv(56, 24).cuboid(-3F, -4F, 0F, 6F, 8F, 5F, new Dilation(0.01F))
                .uv(128, 66).cuboid(-3F, 3.1F, 0F, 6F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, -1F, 11F, -0.12F, 0F, 0F));
        ModelPartData p51 = p50.addChild("fin", ModelPartBuilder.create()
                .uv(150, 66).cuboid(-0.5F, -4F, -1F, 1F, 4F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p52 = p50.addChild("tail1", ModelPartBuilder.create()
                .uv(84, 37).cuboid(-4F, -3F, 0F, 8F, 6F, 5F, new Dilation(0.05F))
                .uv(78, 24).cuboid(-3F, -4F, 0F, 6F, 8F, 5F, new Dilation(0.06F))
                .uv(156, 66).cuboid(-3F, 3.1F, 0F, 6F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p53 = p52.addChild("fin", ModelPartBuilder.create()
                .uv(178, 66).cuboid(-0.5F, -3.7F, -1F, 1F, 4F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p54 = p52.addChild("tail2", ModelPartBuilder.create()
                .uv(48, 48).cuboid(-3.5F, -2.5F, 0F, 7F, 5F, 5F, new Dilation(0F))
                .uv(276, 24).cuboid(-2.5F, -3.5F, 0F, 5F, 7F, 5F, new Dilation(0.01F))
                .uv(184, 66).cuboid(-2.5F, 2.6F, 0F, 5F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p55 = p54.addChild("fin", ModelPartBuilder.create()
                .uv(82, 72).cuboid(-0.5F, -3.4F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.5F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p56 = p54.addChild("tail3", ModelPartBuilder.create()
                .uv(294, 48).cuboid(-3F, -2F, 0F, 6F, 4F, 5F, new Dilation(0.05F))
                .uv(110, 37).cuboid(-2F, -3F, 0F, 4F, 6F, 5F, new Dilation(0.06F))
                .uv(204, 66).cuboid(-2F, 2.1F, 0F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p57 = p56.addChild("fin", ModelPartBuilder.create()
                .uv(88, 72).cuboid(-0.5F, -3.1F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p58 = p56.addChild("tail4", ModelPartBuilder.create()
                .uv(316, 48).cuboid(-3F, -2F, 0F, 6F, 4F, 5F, new Dilation(0F))
                .uv(128, 37).cuboid(-2F, -3F, 0F, 4F, 6F, 5F, new Dilation(0.01F))
                .uv(222, 66).cuboid(-2F, 2.1F, 0F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p59 = p58.addChild("fin", ModelPartBuilder.create()
                .uv(94, 72).cuboid(-0.5F, -2.8F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p60 = p58.addChild("tail5", ModelPartBuilder.create()
                .uv(88, 58).cuboid(-2.5F, -1.5F, 0F, 5F, 3F, 5F, new Dilation(0.05F))
                .uv(72, 48).cuboid(-1.5F, -2.5F, 0F, 3F, 5F, 5F, new Dilation(0.06F))
                .uv(240, 66).cuboid(-1.5F, 1.6F, 0F, 3F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p61 = p60.addChild("fin", ModelPartBuilder.create()
                .uv(338, 72).cuboid(-0.5F, -2.5F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2.5F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p62 = p60.addChild("tail6", ModelPartBuilder.create()
                .uv(316, 58).cuboid(-2F, -1F, 0F, 4F, 2F, 5F, new Dilation(0F))
                .uv(338, 48).cuboid(-1F, -2F, 0F, 2F, 4F, 5F, new Dilation(0.01F))
                .uv(256, 66).cuboid(-1F, 1.1F, 0F, 2F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p63 = p62.addChild("fin", ModelPartBuilder.create()
                .uv(344, 72).cuboid(-0.5F, -2.2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p64 = p62.addChild("tail7", ModelPartBuilder.create()
                .uv(334, 58).cuboid(-2F, -1F, 0F, 4F, 2F, 5F, new Dilation(0.05F))
                .uv(352, 48).cuboid(-1F, -2F, 0F, 2F, 4F, 5F, new Dilation(0.06F))
                .uv(270, 66).cuboid(-1F, 1.1F, 0F, 2F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p65 = p64.addChild("fin", ModelPartBuilder.create()
                .uv(350, 72).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p66 = p64.addChild("side_finl", ModelPartBuilder.create()
                .uv(100, 72).cuboid(0F, -0.5F, 0F, 5F, 1F, 4F, new Dilation(-0.1F)),
                ModelTransform.of(1F, 0F, 2F, 0F, 0.4F, 0F));
        ModelPartData p67 = p64.addChild("side_finr", ModelPartBuilder.create()
                .uv(118, 72).cuboid(-5F, -0.5F, 0F, 5F, 1F, 4F, new Dilation(-0.1F)),
                ModelTransform.of(-1F, 0F, 2F, 0F, -0.4F, 0F));
        ModelPartData p68 = p64.addChild("tail8", ModelPartBuilder.create()
                .uv(108, 58).cuboid(-1.5F, -1.5F, 0F, 3F, 3F, 5F, new Dilation(0F))
                .uv(124, 58).cuboid(-1.5F, -1.5F, 0F, 3F, 3F, 5F, new Dilation(0.01F))
                .uv(284, 66).cuboid(-0.5F, 0.6F, 0F, 1F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p69 = p68.addChild("fin", ModelPartBuilder.create()
                .uv(356, 72).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -1.5F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p70 = p68.addChild("tail9", ModelPartBuilder.create()
                .uv(352, 58).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0.05F))
                .uv(366, 58).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0.06F))
                .uv(296, 66).cuboid(0F, 0.1F, 0F, 1F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p71 = p70.addChild("fin", ModelPartBuilder.create()
                .uv(362, 72).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -1F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p72 = p70.addChild("blade", ModelPartBuilder.create()
                .uv(490, 0).cuboid(-0.5F, -4.5F, 0F, 1F, 9F, 5F, new Dilation(0F))
                .uv(140, 58).cuboid(-0.5F, -2.5F, 4.5F, 1F, 5F, 3F, new Dilation(-0.1F))
                .uv(368, 72).cuboid(-0.5F, -1F, 7F, 1F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 5.2F, 0F, 0F, 0F));
        ModelPartData p73 = p72.addChild("shard_l", ModelPartBuilder.create()
                .uv(132, 77).cuboid(0F, -1F, 0F, 4F, 2F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 1F, 0F, 0.6F, 0.3F));
        ModelPartData p74 = p72.addChild("shard_r", ModelPartBuilder.create()
                .uv(142, 77).cuboid(-4F, -1F, 0F, 4F, 2F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 1F, 0F, -0.6F, -0.3F));
        ModelPartData p75 = p0.addChild("left_wing", ModelPartBuilder.create()
                .uv(308, 66).cuboid(0F, -1.6F, -1.6F, 17F, 3F, 3F, new Dilation(0.1F))
                .uv(88, 48).cuboid(0F, -2.5F, -2.5F, 4F, 5F, 5F, new Dilation(0F))
                .uv(204, 0).cuboid(0F, -0.3F, 1.4F, 17F, 1F, 16F, new Dilation(-0.25F)),
                ModelTransform.of(5.5F, -6F, -8F, 0.12F, -0.28F, -0.5F));
        ModelPartData p76 = p75.addChild("forearm", ModelPartBuilder.create()
                .uv(374, 72).cuboid(0F, -1.3F, -1.3F, 21F, 2F, 2F, new Dilation(0.2F))
                .uv(146, 37).cuboid(0F, -0.3F, 0.8F, 21F, 1F, 10F, new Dilation(-0.25F)),
                ModelTransform.of(17F, 0F, 0F, 0F, 0.4F, -0.18F));
        ModelPartData p77 = p76.addChild("hand", ModelPartBuilder.create()
                .uv(348, 66).cuboid(0F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0.1F))
                .uv(136, 72).cuboid(0F, -1F, -4F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(21F, 0F, 0F, 0F, 0.1F, 0F));
        ModelPartData p78 = p77.addChild("finger0", ModelPartBuilder.create()
                .uv(234, 77).cuboid(0F, -0.7F, -0.7F, 26F, 1F, 1F, new Dilation(0.15F))
                .uv(420, 72).cuboid(25F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.05F, 0F));
        ModelPartData p79 = p78.addChild("web", ModelPartBuilder.create()
                .uv(296, 24).cuboid(0F, -0.3F, 0F, 24F, 1F, 11F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p80 = p77.addChild("finger1", ModelPartBuilder.create()
                .uv(288, 77).cuboid(0F, -0.7F, -0.7F, 23F, 1F, 1F, new Dilation(0.15F))
                .uv(428, 72).cuboid(22F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.42F, -0.04F));
        ModelPartData p81 = p80.addChild("web", ModelPartBuilder.create()
                .uv(208, 37).cuboid(0F, -0.3F, 0F, 21F, 1F, 10F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p82 = p77.addChild("finger2", ModelPartBuilder.create()
                .uv(336, 77).cuboid(0F, -0.7F, -0.7F, 19F, 1F, 1F, new Dilation(0.15F))
                .uv(436, 72).cuboid(18F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.8F, -0.08F));
        ModelPartData p83 = p82.addChild("web", ModelPartBuilder.create()
                .uv(366, 48).cuboid(0F, -0.3F, 0F, 17F, 1F, 8F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p84 = p77.addChild("finger3", ModelPartBuilder.create()
                .uv(376, 77).cuboid(0F, -0.7F, -0.7F, 14F, 1F, 1F, new Dilation(0.15F))
                .uv(444, 72).cuboid(13F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -1.18F, -0.12F));
        ModelPartData p85 = p84.addChild("web", ModelPartBuilder.create()
                .uv(380, 58).cuboid(0F, -0.3F, 0F, 13F, 1F, 6F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p86 = p0.addChild("right_wing", ModelPartBuilder.create()
                .uv(360, 66).cuboid(-17F, -1.6F, -1.6F, 17F, 3F, 3F, new Dilation(0.1F))
                .uv(106, 48).cuboid(-4F, -2.5F, -2.5F, 4F, 5F, 5F, new Dilation(0F))
                .uv(270, 0).cuboid(-17F, -0.3F, 1.4F, 17F, 1F, 16F, new Dilation(-0.25F)),
                ModelTransform.of(-5.5F, -6F, -8F, 0.12F, 0.28F, 0.5F));
        ModelPartData p87 = p86.addChild("forearm", ModelPartBuilder.create()
                .uv(452, 72).cuboid(-21F, -1.3F, -1.3F, 21F, 2F, 2F, new Dilation(0.2F))
                .uv(270, 37).cuboid(-21F, -0.3F, 0.8F, 21F, 1F, 10F, new Dilation(-0.25F)),
                ModelTransform.of(-17F, 0F, 0F, 0F, -0.4F, 0.18F));
        ModelPartData p88 = p87.addChild("hand", ModelPartBuilder.create()
                .uv(400, 66).cuboid(-3F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0.1F))
                .uv(144, 72).cuboid(-1F, -1F, -4F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(-21F, 0F, 0F, 0F, -0.1F, 0F));
        ModelPartData p89 = p88.addChild("finger0", ModelPartBuilder.create()
                .uv(406, 77).cuboid(-26F, -0.7F, -0.7F, 26F, 1F, 1F, new Dilation(0.15F))
                .uv(498, 72).cuboid(-27F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.05F, 0F));
        ModelPartData p90 = p89.addChild("web", ModelPartBuilder.create()
                .uv(366, 24).cuboid(-24F, -0.3F, 0F, 24F, 1F, 11F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p91 = p88.addChild("finger1", ModelPartBuilder.create()
                .uv(460, 77).cuboid(-23F, -0.7F, -0.7F, 23F, 1F, 1F, new Dilation(0.15F))
                .uv(0, 77).cuboid(-24F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.42F, 0.04F));
        ModelPartData p92 = p91.addChild("web", ModelPartBuilder.create()
                .uv(332, 37).cuboid(-21F, -0.3F, 0F, 21F, 1F, 10F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p93 = p88.addChild("finger2", ModelPartBuilder.create()
                .uv(0, 81).cuboid(-19F, -0.7F, -0.7F, 19F, 1F, 1F, new Dilation(0.15F))
                .uv(8, 77).cuboid(-20F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.8F, 0.08F));
        ModelPartData p94 = p93.addChild("web", ModelPartBuilder.create()
                .uv(416, 48).cuboid(-17F, -0.3F, 0F, 17F, 1F, 8F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p95 = p88.addChild("finger3", ModelPartBuilder.create()
                .uv(40, 81).cuboid(-14F, -0.7F, -0.7F, 14F, 1F, 1F, new Dilation(0.15F))
                .uv(16, 77).cuboid(-15F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 1.18F, 0.12F));
        ModelPartData p96 = p95.addChild("web", ModelPartBuilder.create()
                .uv(418, 58).cuboid(-13F, -0.3F, 0F, 13F, 1F, 6F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p97 = p0.addChild("left_front_leg", ModelPartBuilder.create()
                .uv(466, 48).cuboid(-2.2F, -1F, -2.2F, 4F, 5F, 4F, new Dilation(0.1F))
                .uv(394, 37).cuboid(-1.2F, -2F, -2.2F, 2F, 7F, 4F, new Dilation(0.11F)),
                ModelTransform.of(5.2F, 1.5F, -8.5F, 0.6F, 0F, -0.08F));
        ModelPartData p98 = p97.addChild("shin", ModelPartBuilder.create()
                .uv(148, 58).cuboid(-1.6F, 1F, -1.6F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(124, 48).cuboid(-0.6F, 0F, -1.6F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 5.5F, 0F, -0.8F, 0F, 0F));
        ModelPartData p99 = p98.addChild("foot", ModelPartBuilder.create()
                .uv(412, 66).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.25F, 0F, 0F));
        ModelPartData p100 = p99.addChild("toe0", ModelPartBuilder.create()
                .uv(24, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p101 = p100.addChild("claw", ModelPartBuilder.create()
                .uv(152, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p102 = p99.addChild("toe1", ModelPartBuilder.create()
                .uv(32, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p103 = p102.addChild("claw", ModelPartBuilder.create()
                .uv(158, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p104 = p99.addChild("toe2", ModelPartBuilder.create()
                .uv(40, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p105 = p104.addChild("claw", ModelPartBuilder.create()
                .uv(164, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p106 = p0.addChild("right_front_leg", ModelPartBuilder.create()
                .uv(482, 48).cuboid(-2.2F, -1F, -2.2F, 4F, 5F, 4F, new Dilation(0.1F))
                .uv(406, 37).cuboid(-1.2F, -2F, -2.2F, 2F, 7F, 4F, new Dilation(0.11F)),
                ModelTransform.of(-5.2F, 1.5F, -8.5F, 0.6F, 0F, 0.08F));
        ModelPartData p107 = p106.addChild("shin", ModelPartBuilder.create()
                .uv(160, 58).cuboid(-1.6F, 1F, -1.6F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(132, 48).cuboid(-0.6F, 0F, -1.6F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 5.5F, 0F, -0.8F, 0F, 0F));
        ModelPartData p108 = p107.addChild("foot", ModelPartBuilder.create()
                .uv(430, 66).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.25F, 0F, 0F));
        ModelPartData p109 = p108.addChild("toe0", ModelPartBuilder.create()
                .uv(48, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p110 = p109.addChild("claw", ModelPartBuilder.create()
                .uv(170, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p111 = p108.addChild("toe1", ModelPartBuilder.create()
                .uv(56, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p112 = p111.addChild("claw", ModelPartBuilder.create()
                .uv(176, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p113 = p108.addChild("toe2", ModelPartBuilder.create()
                .uv(64, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p114 = p113.addChild("claw", ModelPartBuilder.create()
                .uv(182, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p115 = p0.addChild("left_hind_leg", ModelPartBuilder.create()
                .uv(100, 24).cuboid(-3F, -2F, -3.2F, 6F, 7F, 6F, new Dilation(0.05F))
                .uv(406, 0).cuboid(-2F, -3F, -3.2F, 4F, 9F, 6F, new Dilation(0.06F))
                .uv(172, 58).cuboid(-2.5F, -3.5F, -1F, 5F, 3F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(5.6F, 0F, 7F, -0.55F, 0F, -0.06F));
        ModelPartData p116 = p115.addChild("shin", ModelPartBuilder.create()
                .uv(192, 58).cuboid(-1.8F, 1F, -1.8F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(140, 48).cuboid(-0.8F, 0F, -1.8F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 6.5F, -0.5F, 1F, 0F, 0F));
        ModelPartData p117 = p116.addChild("ankle", ModelPartBuilder.create()
                .uv(448, 66).cuboid(-1.5F, 1F, -1.5F, 3F, 3F, 3F, new Dilation(0.15F))
                .uv(204, 58).cuboid(-0.5F, 0F, -1.5F, 1F, 5F, 3F, new Dilation(0.16F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.6F, 0F, 0F));
        ModelPartData p118 = p117.addChild("foot", ModelPartBuilder.create()
                .uv(460, 66).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6F, 0F, 0.4F, 0F, 0F));
        ModelPartData p119 = p118.addChild("toe0", ModelPartBuilder.create()
                .uv(72, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p120 = p119.addChild("claw", ModelPartBuilder.create()
                .uv(188, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p121 = p118.addChild("toe1", ModelPartBuilder.create()
                .uv(80, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p122 = p121.addChild("claw", ModelPartBuilder.create()
                .uv(194, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p123 = p118.addChild("toe2", ModelPartBuilder.create()
                .uv(88, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p124 = p123.addChild("claw", ModelPartBuilder.create()
                .uv(200, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p125 = p0.addChild("right_hind_leg", ModelPartBuilder.create()
                .uv(124, 24).cuboid(-3F, -2F, -3.2F, 6F, 7F, 6F, new Dilation(0.05F))
                .uv(426, 0).cuboid(-2F, -3F, -3.2F, 4F, 9F, 6F, new Dilation(0.06F))
                .uv(212, 58).cuboid(-2.5F, -3.5F, -1F, 5F, 3F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(-5.6F, 0F, 7F, -0.55F, 0F, 0.06F));
        ModelPartData p126 = p125.addChild("shin", ModelPartBuilder.create()
                .uv(232, 58).cuboid(-1.8F, 1F, -1.8F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(148, 48).cuboid(-0.8F, 0F, -1.8F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 6.5F, -0.5F, 1F, 0F, 0F));
        ModelPartData p127 = p126.addChild("ankle", ModelPartBuilder.create()
                .uv(478, 66).cuboid(-1.5F, 1F, -1.5F, 3F, 3F, 3F, new Dilation(0.15F))
                .uv(244, 58).cuboid(-0.5F, 0F, -1.5F, 1F, 5F, 3F, new Dilation(0.16F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.6F, 0F, 0F));
        ModelPartData p128 = p127.addChild("foot", ModelPartBuilder.create()
                .uv(490, 66).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6F, 0F, 0.4F, 0F, 0F));
        ModelPartData p129 = p128.addChild("toe0", ModelPartBuilder.create()
                .uv(96, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p130 = p129.addChild("claw", ModelPartBuilder.create()
                .uv(206, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p131 = p128.addChild("toe1", ModelPartBuilder.create()
                .uv(104, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p132 = p131.addChild("claw", ModelPartBuilder.create()
                .uv(212, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p133 = p128.addChild("toe2", ModelPartBuilder.create()
                .uv(112, 77).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p134 = p133.addChild("claw", ModelPartBuilder.create()
                .uv(218, 77).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        return TexturedModelData.of(modelData, 512, 128);
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
        lWing.roll += s * 0.55F;
        rWing.roll -= s * 0.55F;
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
