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

/** Daemaryong (대마룡). Half-scale geometry; the renderer scales it by 2. Texture image is 4x denser than the declared size. (512x128 texture) */
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
                .uv(76, 0).cuboid(-6F, -4.2F, -6F, 12F, 7F, 12F, new Dilation(0.05F))
                .uv(0, 0).cuboid(-4F, -6.2F, -6F, 8F, 11F, 12F, new Dilation(0.06F))
                .uv(430, 0).cuboid(-5F, 4.5F, -6F, 10F, 2F, 12F, new Dilation(0.1F)),
                ModelTransform.of(0F, 5F, 0F, 0F, 0F, 0F));
        ModelPartData p1 = p0.addChild("chest", ModelPartBuilder.create()
                .uv(154, 0).cuboid(-7F, -4F, -9F, 14F, 7F, 10F, new Dilation(0F))
                .uv(40, 0).cuboid(-4F, -7F, -9F, 8F, 13F, 10F, new Dilation(0.01F))
                .uv(140, 37).cuboid(-5.5F, 4.5F, -9F, 11F, 2F, 9F, new Dilation(0.1F))
                .uv(84, 23).cuboid(-5F, -4F, -11F, 10F, 10F, 3F, new Dilation(-0.3F))
                .uv(370, 49).cuboid(-7.5F, -8F, -7F, 5F, 3F, 6F, new Dilation(-0.1F))
                .uv(392, 49).cuboid(2.5F, -8F, -7F, 5F, 3F, 6F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, -6F, -0.1F, 0F, 0F));
        ModelPartData p2 = p0.addChild("hips", ModelPartBuilder.create()
                .uv(110, 23).cuboid(-6.5F, -3.5F, 0F, 13F, 5F, 8F, new Dilation(0F))
                .uv(124, 0).cuboid(-3.5F, -6.5F, 0F, 7F, 11F, 8F, new Dilation(0.01F))
                .uv(414, 49).cuboid(-4.5F, 3.5F, 0F, 9F, 2F, 7F, new Dilation(0.1F))
                .uv(152, 23).cuboid(-8F, -5F, 1F, 4F, 7F, 6F, new Dilation(-0.1F))
                .uv(172, 23).cuboid(4F, -5F, 1F, 4F, 7F, 6F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, 6F, 0.08F, 0F, 0F));
        ModelPartData p3 = p0.addChild("plate0", ModelPartBuilder.create()
                .uv(298, 60).cuboid(-0.5F, -6F, -1.2F, 1F, 6F, 2F, new Dilation(0F))
                .uv(456, 77).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -12F, -0.5F, 0F, 0F));
        ModelPartData p4 = p0.addChild("plate1", ModelPartBuilder.create()
                .uv(304, 60).cuboid(-0.5F, -5.5F, -1.2F, 1F, 6F, 2F, new Dilation(0F))
                .uv(466, 77).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -9.2F, -0.5F, 0F, 0F));
        ModelPartData p5 = p0.addChild("plate2", ModelPartBuilder.create()
                .uv(40, 69).cuboid(-0.5F, -5F, -1.2F, 1F, 5F, 2F, new Dilation(0F))
                .uv(476, 77).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -6.4F, -0.5F, 0F, 0F));
        ModelPartData p6 = p0.addChild("plate3", ModelPartBuilder.create()
                .uv(216, 69).cuboid(-0.5F, -4.5F, -1.2F, 1F, 4F, 2F, new Dilation(0F))
                .uv(486, 77).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -3.6F, -0.5F, 0F, 0F));
        ModelPartData p7 = p0.addChild("plate4", ModelPartBuilder.create()
                .uv(222, 69).cuboid(-0.5F, -4F, -1.2F, 1F, 4F, 2F, new Dilation(0F))
                .uv(496, 77).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, -0.8F, -0.5F, 0F, 0F));
        ModelPartData p8 = p0.addChild("plate5", ModelPartBuilder.create()
                .uv(228, 69).cuboid(-0.5F, -3.5F, -1.2F, 1F, 4F, 2F, new Dilation(0F))
                .uv(0, 83).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 2F, -0.5F, 0F, 0F));
        ModelPartData p9 = p0.addChild("plate6", ModelPartBuilder.create()
                .uv(304, 77).cuboid(-0.5F, -3F, -1.2F, 1F, 3F, 2F, new Dilation(0F))
                .uv(10, 83).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 4.8F, -0.5F, 0F, 0F));
        ModelPartData p10 = p0.addChild("plate7", ModelPartBuilder.create()
                .uv(20, 83).cuboid(-0.5F, -2.5F, -1.2F, 1F, 2F, 2F, new Dilation(0F))
                .uv(26, 83).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 7.6F, -0.5F, 0F, 0F));
        ModelPartData p11 = p0.addChild("plate8", ModelPartBuilder.create()
                .uv(36, 83).cuboid(-0.5F, -2F, -1.2F, 1F, 2F, 2F, new Dilation(0F))
                .uv(42, 83).cuboid(-1F, -1F, -1.5F, 2F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 10.4F, -0.5F, 0F, 0F));
        ModelPartData p12 = p0.addChild("neck_root", ModelPartBuilder.create(),
                ModelTransform.of(0F, -3F, -12F, 0F, 0F, 0F));
        ModelPartData p13 = p12.addChild("neck0", ModelPartBuilder.create()
                .uv(192, 23).cuboid(-5F, -4F, -5F, 10F, 8F, 5F, new Dilation(0F))
                .uv(334, 0).cuboid(-4F, -5F, -5F, 8F, 10F, 5F, new Dilation(0.01F))
                .uv(234, 69).cuboid(-3.8F, 4F, -5F, 7F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -1F, -0.5F, 0F, 0F));
        ModelPartData p14 = p13.addChild("fin", ModelPartBuilder.create()
                .uv(310, 77).cuboid(-0.5F, -3F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -5F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p15 = p13.addChild("neck1", ModelPartBuilder.create()
                .uv(370, 23).cuboid(-4.5F, -3.5F, -5F, 9F, 7F, 5F, new Dilation(0.05F))
                .uv(474, 0).cuboid(-3.5F, -4.5F, -5F, 7F, 9F, 5F, new Dilation(0.06F))
                .uv(258, 69).cuboid(-3.3F, 3.5F, -5F, 6F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, -0.32F, 0F, 0F));
        ModelPartData p16 = p15.addChild("fin", ModelPartBuilder.create()
                .uv(316, 77).cuboid(-0.5F, -2.8F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4.5F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p17 = p15.addChild("neck2", ModelPartBuilder.create()
                .uv(180, 37).cuboid(-4F, -3F, -5F, 8F, 6F, 5F, new Dilation(0F))
                .uv(222, 23).cuboid(-3F, -4F, -5F, 6F, 8F, 5F, new Dilation(0.01F))
                .uv(280, 69).cuboid(-2.8F, 3F, -5F, 5F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, -0.15F, 0F, 0F));
        ModelPartData p18 = p17.addChild("fin", ModelPartBuilder.create()
                .uv(322, 77).cuboid(-0.5F, -2.6F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p19 = p17.addChild("neck3", ModelPartBuilder.create()
                .uv(210, 49).cuboid(-3.5F, -2.5F, -5F, 7F, 5F, 5F, new Dilation(0.05F))
                .uv(398, 23).cuboid(-2.5F, -3.5F, -5F, 5F, 7F, 5F, new Dilation(0.06F))
                .uv(300, 69).cuboid(-2.3F, 2.5F, -5F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, 0.02F, 0F, 0F));
        ModelPartData p20 = p19.addChild("fin", ModelPartBuilder.create()
                .uv(328, 77).cuboid(-0.5F, -2.4F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.5F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p21 = p19.addChild("neck4", ModelPartBuilder.create()
                .uv(446, 49).cuboid(-3.25F, -2.25F, -5F, 6F, 4F, 5F, new Dilation(0F))
                .uv(206, 37).cuboid(-2.25F, -3.25F, -5F, 4F, 6F, 5F, new Dilation(0.01F))
                .uv(318, 69).cuboid(-2.05F, 2.25F, -5F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, 0.18F, 0F, 0F));
        ModelPartData p22 = p21.addChild("fin", ModelPartBuilder.create()
                .uv(334, 77).cuboid(-0.5F, -2.2F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.25F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p23 = p21.addChild("neck5", ModelPartBuilder.create()
                .uv(468, 49).cuboid(-3F, -2F, -5F, 6F, 4F, 5F, new Dilation(0.05F))
                .uv(224, 37).cuboid(-2F, -3F, -5F, 4F, 6F, 5F, new Dilation(0.06F))
                .uv(336, 69).cuboid(-1.8F, 2F, -5F, 3F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, -4.6F, 0.28F, 0F, 0F));
        ModelPartData p24 = p23.addChild("fin", ModelPartBuilder.create()
                .uv(340, 77).cuboid(-0.5F, -2F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, -2.5F, -0.5F, 0F, 0F));
        ModelPartData p25 = p23.addChild("head", ModelPartBuilder.create()
                .uv(244, 23).cuboid(-4.5F, -3F, -7F, 9F, 5F, 8F, new Dilation(0F))
                .uv(360, 0).cuboid(-3.5F, -4F, -7F, 7F, 7F, 8F, new Dilation(0.01F))
                .uv(46, 69).cuboid(-5F, -4.6F, -6.2F, 10F, 2F, 5F, new Dilation(-0.1F))
                .uv(0, 60).cuboid(-3.5F, -1.8F, -12F, 7F, 3F, 6F, new Dilation(0F))
                .uv(242, 37).cuboid(-2.5F, -2.8F, -12F, 5F, 5F, 6F, new Dilation(0.01F))
                .uv(352, 69).cuboid(-2.8F, -1.4F, -15.5F, 6F, 2F, 4F, new Dilation(0F))
                .uv(310, 60).cuboid(-1.8F, -2.4F, -15.5F, 4F, 4F, 4F, new Dilation(0.01F))
                .uv(418, 23).cuboid(-2.6F, 1.6F, -17.6F, 1F, 1F, 11F, new Dilation(-0.15F))
                .uv(442, 23).cuboid(1.6F, 1.6F, -17.6F, 1F, 1F, 11F, new Dilation(-0.15F))
                .uv(326, 60).cuboid(-1.5F, -3.2F, -12F, 3F, 1F, 7F, new Dilation(0F))
                .uv(26, 60).cuboid(-5.4F, -2.2F, -6.5F, 2F, 3F, 6F, new Dilation(-0.1F))
                .uv(42, 60).cuboid(3.4F, -2.2F, -6.5F, 2F, 3F, 6F, new Dilation(-0.1F))
                .uv(372, 69).cuboid(-2.2F, -2F, -18.2F, 4F, 3F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, -6.5F, 0.45F, 0F, 0F));
        ModelPartData p26 = p25.addChild("jaw", ModelPartBuilder.create()
                .uv(0, 23).cuboid(-3F, 0F, -12F, 6F, 2F, 12F, new Dilation(0F))
                .uv(36, 23).cuboid(-3F, 0F, -12F, 6F, 2F, 12F, new Dilation(0.01F))
                .uv(234, 49).cuboid(-2.5F, 1.6F, -9.5F, 5F, 1F, 9F, new Dilation(0F))
                .uv(264, 37).cuboid(-2.6F, -0.8F, -11.6F, 1F, 1F, 10F, new Dilation(-0.15F))
                .uv(286, 37).cuboid(1.6F, -0.8F, -11.6F, 1F, 1F, 10F, new Dilation(-0.15F))
                .uv(0, 87).cuboid(-1.8F, -0.8F, -12.2F, 4F, 1F, 1F, new Dilation(-0.15F))
                .uv(386, 69).cuboid(-3.5F, 0.5F, -3F, 1F, 2F, 4F, new Dilation(0F))
                .uv(396, 69).cuboid(2.5F, 0.5F, -3F, 1F, 2F, 4F, new Dilation(0F)),
                ModelTransform.of(0F, 2.2F, -6F, 0.12F, 0F, 0F));
        ModelPartData p27 = p25.addChild("lhorn0", ModelPartBuilder.create()
                .uv(58, 60).cuboid(-1F, -1F, 0F, 2F, 2F, 7F, new Dilation(0.15F)),
                ModelTransform.of(2.6F, -3.4F, 0.5F, 0.4F, 0.25F, 0.1F));
        ModelPartData p28 = p27.addChild("lhorn1", ModelPartBuilder.create()
                .uv(346, 60).cuboid(-0.75F, -0.75F, 0F, 2F, 2F, 6F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 6.6F, -0.12F, 0.05F, 0F));
        ModelPartData p29 = p28.addChild("lhorn2", ModelPartBuilder.create()
                .uv(406, 69).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 5F, new Dilation(-0.01F)),
                ModelTransform.of(0F, 0F, 5.6F, -0.12F, 0.05F, 0F));
        ModelPartData p30 = p29.addChild("lhorn3", ModelPartBuilder.create()
                .uv(346, 77).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.09F)),
                ModelTransform.of(0F, 0F, 4.6F, -0.12F, 0.05F, 0F));
        ModelPartData p31 = p25.addChild("rhorn0", ModelPartBuilder.create()
                .uv(76, 60).cuboid(-1F, -1F, 0F, 2F, 2F, 7F, new Dilation(0.15F)),
                ModelTransform.of(-2.6F, -3.4F, 0.5F, 0.4F, -0.25F, -0.1F));
        ModelPartData p32 = p31.addChild("rhorn1", ModelPartBuilder.create()
                .uv(362, 60).cuboid(-0.75F, -0.75F, 0F, 2F, 2F, 6F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 6.6F, -0.12F, -0.05F, 0F));
        ModelPartData p33 = p32.addChild("rhorn2", ModelPartBuilder.create()
                .uv(418, 69).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 5F, new Dilation(-0.01F)),
                ModelTransform.of(0F, 0F, 5.6F, -0.12F, -0.05F, 0F));
        ModelPartData p34 = p33.addChild("rhorn3", ModelPartBuilder.create()
                .uv(356, 77).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.09F)),
                ModelTransform.of(0F, 0F, 4.6F, -0.12F, -0.05F, 0F));
        ModelPartData p35 = p25.addChild("lhorn_s0", ModelPartBuilder.create()
                .uv(52, 83).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0.15F)),
                ModelTransform.of(3.6F, -1.2F, -1F, 0.2F, 0.75F, 0.05F));
        ModelPartData p36 = p35.addChild("lhorn_s1", ModelPartBuilder.create()
                .uv(408, 83).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 2.6F, -0.12F, 0.05F, 0F));
        ModelPartData p37 = p25.addChild("rhorn_s0", ModelPartBuilder.create()
                .uv(60, 83).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(0.15F)),
                ModelTransform.of(-3.6F, -1.2F, -1F, 0.2F, -0.75F, -0.05F));
        ModelPartData p38 = p37.addChild("rhorn_s1", ModelPartBuilder.create()
                .uv(414, 83).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(0.07F)),
                ModelTransform.of(0F, 0F, 2.6F, -0.12F, -0.05F, 0F));
        ModelPartData p39 = p25.addChild("nose_horn", ModelPartBuilder.create()
                .uv(68, 83).cuboid(-0.5F, -2.5F, -0.5F, 1F, 3F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, -2.8F, -14.5F, 0.7F, 0F, 0F));
        ModelPartData p40 = p25.addChild("frill0l", ModelPartBuilder.create()
                .uv(366, 77).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.05F)),
                ModelTransform.of(4.2F, -2.5F, -1F, 0.25F, 0.35F, 0.5F));
        ModelPartData p41 = p25.addChild("frill0r", ModelPartBuilder.create()
                .uv(376, 77).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.05F)),
                ModelTransform.of(-4.2F, -2.5F, -1F, 0.25F, -0.35F, -0.5F));
        ModelPartData p42 = p25.addChild("frill1l", ModelPartBuilder.create()
                .uv(72, 83).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(4.2F, -1F, 0F, 0.25F, 0.35F, 0.8F));
        ModelPartData p43 = p25.addChild("frill1r", ModelPartBuilder.create()
                .uv(80, 83).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(-4.2F, -1F, 0F, 0.25F, -0.35F, -0.8F));
        ModelPartData p44 = p25.addChild("frill2l", ModelPartBuilder.create()
                .uv(88, 83).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(4.2F, 0.5F, -1F, 0.25F, 0.35F, 1.1F));
        ModelPartData p45 = p25.addChild("frill2r", ModelPartBuilder.create()
                .uv(96, 83).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 3F, new Dilation(-0.05F)),
                ModelTransform.of(-4.2F, 0.5F, -1F, 0.25F, -0.35F, -1.1F));
        ModelPartData p46 = p25.addChild("crest0", ModelPartBuilder.create()
                .uv(104, 83).cuboid(-0.5F, -2.8F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, -3F, 0.55F, 0F, 0F));
        ModelPartData p47 = p25.addChild("crest1", ModelPartBuilder.create()
                .uv(108, 83).cuboid(-0.5F, -2.5F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, -1.2F, 0.55F, 0F, 0F));
        ModelPartData p48 = p25.addChild("crest2", ModelPartBuilder.create()
                .uv(112, 83).cuboid(-0.5F, -2.2F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, 0.6F, 0.55F, 0F, 0F));
        ModelPartData p49 = p25.addChild("crest3", ModelPartBuilder.create()
                .uv(116, 83).cuboid(-0.5F, -1.9F, -0.5F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -4.6F, 2.4F, 0.55F, 0F, 0F));
        ModelPartData p50 = p0.addChild("tail0", ModelPartBuilder.create()
                .uv(308, 37).cuboid(-4F, -3F, 0F, 8F, 6F, 5F, new Dilation(0F))
                .uv(278, 23).cuboid(-3F, -4F, 0F, 6F, 8F, 5F, new Dilation(0.01F))
                .uv(430, 69).cuboid(-3F, 3.1F, 0F, 6F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, -1F, 11F, -0.12F, 0F, 0F));
        ModelPartData p51 = p50.addChild("fin", ModelPartBuilder.create()
                .uv(452, 69).cuboid(-0.5F, -4F, -1F, 1F, 4F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p52 = p50.addChild("tail1", ModelPartBuilder.create()
                .uv(334, 37).cuboid(-4F, -3F, 0F, 8F, 6F, 5F, new Dilation(0.05F))
                .uv(300, 23).cuboid(-3F, -4F, 0F, 6F, 8F, 5F, new Dilation(0.06F))
                .uv(458, 69).cuboid(-3F, 3.1F, 0F, 6F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p53 = p52.addChild("fin", ModelPartBuilder.create()
                .uv(480, 69).cuboid(-0.5F, -3.7F, -1F, 1F, 4F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -4F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p54 = p52.addChild("tail2", ModelPartBuilder.create()
                .uv(262, 49).cuboid(-3.5F, -2.5F, 0F, 7F, 5F, 5F, new Dilation(0F))
                .uv(466, 23).cuboid(-2.5F, -3.5F, 0F, 5F, 7F, 5F, new Dilation(0.01F))
                .uv(486, 69).cuboid(-2.5F, 2.6F, 0F, 5F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p55 = p54.addChild("fin", ModelPartBuilder.create()
                .uv(386, 77).cuboid(-0.5F, -3.4F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3.5F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p56 = p54.addChild("tail3", ModelPartBuilder.create()
                .uv(94, 60).cuboid(-3F, -2F, 0F, 6F, 4F, 5F, new Dilation(0.05F))
                .uv(360, 37).cuboid(-2F, -3F, 0F, 4F, 6F, 5F, new Dilation(0.06F))
                .uv(0, 77).cuboid(-2F, 2.1F, 0F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p57 = p56.addChild("fin", ModelPartBuilder.create()
                .uv(392, 77).cuboid(-0.5F, -3.1F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p58 = p56.addChild("tail4", ModelPartBuilder.create()
                .uv(116, 60).cuboid(-3F, -2F, 0F, 6F, 4F, 5F, new Dilation(0F))
                .uv(378, 37).cuboid(-2F, -3F, 0F, 4F, 6F, 5F, new Dilation(0.01F))
                .uv(18, 77).cuboid(-2F, 2.1F, 0F, 4F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0F, 0F));
        ModelPartData p59 = p58.addChild("fin", ModelPartBuilder.create()
                .uv(398, 77).cuboid(-0.5F, -2.8F, -1F, 1F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -3F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p60 = p58.addChild("tail5", ModelPartBuilder.create()
                .uv(378, 60).cuboid(-2.5F, -1.5F, 0F, 5F, 3F, 5F, new Dilation(0.05F))
                .uv(286, 49).cuboid(-1.5F, -2.5F, 0F, 3F, 5F, 5F, new Dilation(0.06F))
                .uv(36, 77).cuboid(-1.5F, 1.6F, 0F, 3F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p61 = p60.addChild("fin", ModelPartBuilder.create()
                .uv(120, 83).cuboid(-0.5F, -2.5F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2.5F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p62 = p60.addChild("tail6", ModelPartBuilder.create()
                .uv(76, 69).cuboid(-2F, -1F, 0F, 4F, 2F, 5F, new Dilation(0F))
                .uv(138, 60).cuboid(-1F, -2F, 0F, 2F, 4F, 5F, new Dilation(0.01F))
                .uv(52, 77).cuboid(-1F, 1.1F, 0F, 2F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p63 = p62.addChild("fin", ModelPartBuilder.create()
                .uv(126, 83).cuboid(-0.5F, -2.2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p64 = p62.addChild("tail7", ModelPartBuilder.create()
                .uv(94, 69).cuboid(-2F, -1F, 0F, 4F, 2F, 5F, new Dilation(0.05F))
                .uv(152, 60).cuboid(-1F, -2F, 0F, 2F, 4F, 5F, new Dilation(0.06F))
                .uv(66, 77).cuboid(-1F, 1.1F, 0F, 2F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p65 = p64.addChild("fin", ModelPartBuilder.create()
                .uv(132, 83).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -2F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p66 = p64.addChild("side_finl", ModelPartBuilder.create()
                .uv(404, 77).cuboid(0F, -0.5F, 0F, 5F, 1F, 4F, new Dilation(-0.1F)),
                ModelTransform.of(1F, 0F, 2F, 0F, 0.4F, 0F));
        ModelPartData p67 = p64.addChild("side_finr", ModelPartBuilder.create()
                .uv(422, 77).cuboid(-5F, -0.5F, 0F, 5F, 1F, 4F, new Dilation(-0.1F)),
                ModelTransform.of(-1F, 0F, 2F, 0F, -0.4F, 0F));
        ModelPartData p68 = p64.addChild("tail8", ModelPartBuilder.create()
                .uv(398, 60).cuboid(-1.5F, -1.5F, 0F, 3F, 3F, 5F, new Dilation(0F))
                .uv(414, 60).cuboid(-1.5F, -1.5F, 0F, 3F, 3F, 5F, new Dilation(0.01F))
                .uv(80, 77).cuboid(-0.5F, 0.6F, 0F, 1F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p69 = p68.addChild("fin", ModelPartBuilder.create()
                .uv(138, 83).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -1.5F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p70 = p68.addChild("tail9", ModelPartBuilder.create()
                .uv(112, 69).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0.05F))
                .uv(126, 69).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0.06F))
                .uv(92, 77).cuboid(0F, 0.1F, 0F, 1F, 1F, 5F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 5.4F, 0.05F, 0.08F, 0F));
        ModelPartData p71 = p70.addChild("fin", ModelPartBuilder.create()
                .uv(144, 83).cuboid(-0.5F, -2F, -1F, 1F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -1F, 2.5F, -0.55F, 0F, 0F));
        ModelPartData p72 = p70.addChild("blade", ModelPartBuilder.create()
                .uv(72, 23).cuboid(-0.5F, -4.5F, 0F, 1F, 9F, 5F, new Dilation(0F))
                .uv(430, 60).cuboid(-0.5F, -2.5F, 4.5F, 1F, 5F, 3F, new Dilation(-0.1F))
                .uv(150, 83).cuboid(-0.5F, -1F, 7F, 1F, 2F, 2F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 0F, 5.2F, 0F, 0F, 0F));
        ModelPartData p73 = p72.addChild("shard_l", ModelPartBuilder.create()
                .uv(420, 83).cuboid(0F, -1F, 0F, 4F, 2F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 1F, 0F, 0.6F, 0.3F));
        ModelPartData p74 = p72.addChild("shard_r", ModelPartBuilder.create()
                .uv(430, 83).cuboid(-4F, -1F, 0F, 4F, 2F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 1F, 0F, -0.6F, -0.3F));
        ModelPartData p75 = p0.addChild("left_wing", ModelPartBuilder.create()
                .uv(104, 77).cuboid(0F, -1.6F, -1.6F, 17F, 3F, 3F, new Dilation(0.1F))
                .uv(302, 49).cuboid(0F, -2.5F, -2.5F, 4F, 5F, 5F, new Dilation(0F))
                .uv(202, 0).cuboid(0F, -0.3F, 1.4F, 17F, 1F, 16F, new Dilation(-0.25F)),
                ModelTransform.of(5.5F, -6F, -8F, 0.22F, -0.32F, -0.22F));
        ModelPartData p76 = p75.addChild("forearm", ModelPartBuilder.create()
                .uv(156, 83).cuboid(0F, -1.3F, -1.3F, 21F, 2F, 2F, new Dilation(0.2F))
                .uv(396, 37).cuboid(0F, -0.3F, 0.8F, 21F, 1F, 10F, new Dilation(-0.25F)),
                ModelTransform.of(17F, 0F, 0F, 0F, 0.4F, -0.18F));
        ModelPartData p77 = p76.addChild("hand", ModelPartBuilder.create()
                .uv(144, 77).cuboid(0F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0.1F))
                .uv(440, 77).cuboid(0F, -1F, -4F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(21F, 0F, 0F, 0F, 0.1F, 0F));
        ModelPartData p78 = p77.addChild("finger0", ModelPartBuilder.create()
                .uv(10, 87).cuboid(0F, -0.7F, -0.7F, 26F, 1F, 1F, new Dilation(0.15F))
                .uv(202, 83).cuboid(25F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.05F, 0F));
        ModelPartData p79 = p78.addChild("web", ModelPartBuilder.create()
                .uv(0, 37).cuboid(0F, -0.3F, 0F, 24F, 1F, 11F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p80 = p77.addChild("finger1", ModelPartBuilder.create()
                .uv(64, 87).cuboid(0F, -0.7F, -0.7F, 23F, 1F, 1F, new Dilation(0.15F))
                .uv(210, 83).cuboid(22F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.42F, -0.04F));
        ModelPartData p81 = p80.addChild("web", ModelPartBuilder.create()
                .uv(0, 49).cuboid(0F, -0.3F, 0F, 21F, 1F, 10F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p82 = p77.addChild("finger2", ModelPartBuilder.create()
                .uv(112, 87).cuboid(0F, -0.7F, -0.7F, 19F, 1F, 1F, new Dilation(0.15F))
                .uv(218, 83).cuboid(18F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.8F, -0.08F));
        ModelPartData p83 = p82.addChild("web", ModelPartBuilder.create()
                .uv(166, 60).cuboid(0F, -0.3F, 0F, 17F, 1F, 8F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p84 = p77.addChild("finger3", ModelPartBuilder.create()
                .uv(152, 87).cuboid(0F, -0.7F, -0.7F, 14F, 1F, 1F, new Dilation(0.15F))
                .uv(226, 83).cuboid(13F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -1.18F, -0.12F));
        ModelPartData p85 = p84.addChild("web", ModelPartBuilder.create()
                .uv(140, 69).cuboid(0F, -0.3F, 0F, 13F, 1F, 6F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p86 = p0.addChild("right_wing", ModelPartBuilder.create()
                .uv(156, 77).cuboid(-17F, -1.6F, -1.6F, 17F, 3F, 3F, new Dilation(0.1F))
                .uv(320, 49).cuboid(-4F, -2.5F, -2.5F, 4F, 5F, 5F, new Dilation(0F))
                .uv(268, 0).cuboid(-17F, -0.3F, 1.4F, 17F, 1F, 16F, new Dilation(-0.25F)),
                ModelTransform.of(-5.5F, -6F, -8F, 0.22F, 0.32F, 0.22F));
        ModelPartData p87 = p86.addChild("forearm", ModelPartBuilder.create()
                .uv(234, 83).cuboid(-21F, -1.3F, -1.3F, 21F, 2F, 2F, new Dilation(0.2F))
                .uv(62, 49).cuboid(-21F, -0.3F, 0.8F, 21F, 1F, 10F, new Dilation(-0.25F)),
                ModelTransform.of(-17F, 0F, 0F, 0F, -0.4F, 0.18F));
        ModelPartData p88 = p87.addChild("hand", ModelPartBuilder.create()
                .uv(196, 77).cuboid(-3F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0.1F))
                .uv(448, 77).cuboid(-1F, -1F, -4F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(-21F, 0F, 0F, 0F, -0.1F, 0F));
        ModelPartData p89 = p88.addChild("finger0", ModelPartBuilder.create()
                .uv(182, 87).cuboid(-26F, -0.7F, -0.7F, 26F, 1F, 1F, new Dilation(0.15F))
                .uv(280, 83).cuboid(-27F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.05F, 0F));
        ModelPartData p90 = p89.addChild("web", ModelPartBuilder.create()
                .uv(70, 37).cuboid(-24F, -0.3F, 0F, 24F, 1F, 11F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p91 = p88.addChild("finger1", ModelPartBuilder.create()
                .uv(236, 87).cuboid(-23F, -0.7F, -0.7F, 23F, 1F, 1F, new Dilation(0.15F))
                .uv(288, 83).cuboid(-24F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.42F, 0.04F));
        ModelPartData p92 = p91.addChild("web", ModelPartBuilder.create()
                .uv(124, 49).cuboid(-21F, -0.3F, 0F, 21F, 1F, 10F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p93 = p88.addChild("finger2", ModelPartBuilder.create()
                .uv(284, 87).cuboid(-19F, -0.7F, -0.7F, 19F, 1F, 1F, new Dilation(0.15F))
                .uv(296, 83).cuboid(-20F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.8F, 0.08F));
        ModelPartData p94 = p93.addChild("web", ModelPartBuilder.create()
                .uv(216, 60).cuboid(-17F, -0.3F, 0F, 17F, 1F, 8F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p95 = p88.addChild("finger3", ModelPartBuilder.create()
                .uv(324, 87).cuboid(-14F, -0.7F, -0.7F, 14F, 1F, 1F, new Dilation(0.15F))
                .uv(304, 83).cuboid(-15F, -1F, -1F, 2F, 2F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 1.18F, 0.12F));
        ModelPartData p96 = p95.addChild("web", ModelPartBuilder.create()
                .uv(178, 69).cuboid(-13F, -0.3F, 0F, 13F, 1F, 6F, new Dilation(-0.25F)),
                ModelTransform.of(0F, 0F, 0.4F, 0F, 0F, 0F));
        ModelPartData p97 = p0.addChild("left_front_leg", ModelPartBuilder.create()
                .uv(266, 60).cuboid(-2.2F, -1F, -2.2F, 4F, 5F, 4F, new Dilation(0.1F))
                .uv(186, 49).cuboid(-1.2F, -2F, -2.2F, 2F, 7F, 4F, new Dilation(0.11F)),
                ModelTransform.of(7.2F, 1F, -8.5F, 0.35F, 0F, -0.32F));
        ModelPartData p98 = p97.addChild("shin", ModelPartBuilder.create()
                .uv(438, 60).cuboid(-1.6F, 1F, -1.6F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(338, 49).cuboid(-0.6F, 0F, -1.6F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 5.5F, 0F, -0.55F, 0F, 0.3F));
        ModelPartData p99 = p98.addChild("foot", ModelPartBuilder.create()
                .uv(208, 77).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.25F, 0F, 0F));
        ModelPartData p100 = p99.addChild("toe0", ModelPartBuilder.create()
                .uv(312, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p101 = p100.addChild("claw", ModelPartBuilder.create()
                .uv(440, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p102 = p99.addChild("toe1", ModelPartBuilder.create()
                .uv(320, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p103 = p102.addChild("claw", ModelPartBuilder.create()
                .uv(446, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p104 = p99.addChild("toe2", ModelPartBuilder.create()
                .uv(328, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p105 = p104.addChild("claw", ModelPartBuilder.create()
                .uv(452, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p106 = p0.addChild("right_front_leg", ModelPartBuilder.create()
                .uv(282, 60).cuboid(-2.2F, -1F, -2.2F, 4F, 5F, 4F, new Dilation(0.1F))
                .uv(198, 49).cuboid(-1.2F, -2F, -2.2F, 2F, 7F, 4F, new Dilation(0.11F)),
                ModelTransform.of(-7.2F, 1F, -8.5F, 0.35F, 0F, 0.32F));
        ModelPartData p107 = p106.addChild("shin", ModelPartBuilder.create()
                .uv(450, 60).cuboid(-1.6F, 1F, -1.6F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(346, 49).cuboid(-0.6F, 0F, -1.6F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 5.5F, 0F, -0.55F, 0F, -0.3F));
        ModelPartData p108 = p107.addChild("foot", ModelPartBuilder.create()
                .uv(226, 77).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.25F, 0F, 0F));
        ModelPartData p109 = p108.addChild("toe0", ModelPartBuilder.create()
                .uv(336, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p110 = p109.addChild("claw", ModelPartBuilder.create()
                .uv(458, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p111 = p108.addChild("toe1", ModelPartBuilder.create()
                .uv(344, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p112 = p111.addChild("claw", ModelPartBuilder.create()
                .uv(464, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p113 = p108.addChild("toe2", ModelPartBuilder.create()
                .uv(352, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p114 = p113.addChild("claw", ModelPartBuilder.create()
                .uv(470, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p115 = p0.addChild("left_hind_leg", ModelPartBuilder.create()
                .uv(322, 23).cuboid(-3F, -2F, -3.2F, 6F, 7F, 6F, new Dilation(0.05F))
                .uv(390, 0).cuboid(-2F, -3F, -3.2F, 4F, 9F, 6F, new Dilation(0.06F))
                .uv(462, 60).cuboid(-2.5F, -3.5F, -1F, 5F, 3F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(7F, -0.5F, 7F, -0.45F, 0F, -0.28F));
        ModelPartData p116 = p115.addChild("shin", ModelPartBuilder.create()
                .uv(482, 60).cuboid(-1.8F, 1F, -1.8F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(354, 49).cuboid(-0.8F, 0F, -1.8F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 6.5F, -0.5F, 0.95F, 0F, 0.26F));
        ModelPartData p117 = p116.addChild("ankle", ModelPartBuilder.create()
                .uv(244, 77).cuboid(-1.5F, 1F, -1.5F, 3F, 3F, 3F, new Dilation(0.15F))
                .uv(494, 60).cuboid(-0.5F, 0F, -1.5F, 1F, 5F, 3F, new Dilation(0.16F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.6F, 0F, 0F));
        ModelPartData p118 = p117.addChild("foot", ModelPartBuilder.create()
                .uv(256, 77).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6F, 0F, 0.4F, 0F, 0F));
        ModelPartData p119 = p118.addChild("toe0", ModelPartBuilder.create()
                .uv(360, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p120 = p119.addChild("claw", ModelPartBuilder.create()
                .uv(476, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p121 = p118.addChild("toe1", ModelPartBuilder.create()
                .uv(368, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p122 = p121.addChild("claw", ModelPartBuilder.create()
                .uv(482, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p123 = p118.addChild("toe2", ModelPartBuilder.create()
                .uv(376, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p124 = p123.addChild("claw", ModelPartBuilder.create()
                .uv(488, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p125 = p0.addChild("right_hind_leg", ModelPartBuilder.create()
                .uv(346, 23).cuboid(-3F, -2F, -3.2F, 6F, 7F, 6F, new Dilation(0.05F))
                .uv(410, 0).cuboid(-2F, -3F, -3.2F, 4F, 9F, 6F, new Dilation(0.06F))
                .uv(0, 69).cuboid(-2.5F, -3.5F, -1F, 5F, 3F, 5F, new Dilation(-0.1F)),
                ModelTransform.of(-7F, -0.5F, 7F, -0.45F, 0F, 0.28F));
        ModelPartData p126 = p125.addChild("shin", ModelPartBuilder.create()
                .uv(20, 69).cuboid(-1.8F, 1F, -1.8F, 3F, 5F, 3F, new Dilation(0.2F))
                .uv(362, 49).cuboid(-0.8F, 0F, -1.8F, 1F, 7F, 3F, new Dilation(0.21F)),
                ModelTransform.of(0F, 6.5F, -0.5F, 0.95F, 0F, -0.26F));
        ModelPartData p127 = p126.addChild("ankle", ModelPartBuilder.create()
                .uv(274, 77).cuboid(-1.5F, 1F, -1.5F, 3F, 3F, 3F, new Dilation(0.15F))
                .uv(32, 69).cuboid(-0.5F, 0F, -1.5F, 1F, 5F, 3F, new Dilation(0.16F)),
                ModelTransform.of(0F, 6.5F, 0F, -0.6F, 0F, 0F));
        ModelPartData p128 = p127.addChild("foot", ModelPartBuilder.create()
                .uv(286, 77).cuboid(-2.5F, 0F, -2.6F, 5F, 2F, 4F, new Dilation(0.1F)),
                ModelTransform.of(0F, 6F, 0F, 0.4F, 0F, 0F));
        ModelPartData p129 = p128.addChild("toe0", ModelPartBuilder.create()
                .uv(384, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-1.8F, 1.4F, -2.2F, 0.15F, 0.25F, 0F));
        ModelPartData p130 = p129.addChild("claw", ModelPartBuilder.create()
                .uv(494, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p131 = p128.addChild("toe1", ModelPartBuilder.create()
                .uv(392, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(0F, 1.4F, -2.2F, 0.15F, 0F, 0F));
        ModelPartData p132 = p131.addChild("claw", ModelPartBuilder.create()
                .uv(500, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, 0.2F, -2.6F, 0.7F, 0F, 0F));
        ModelPartData p133 = p128.addChild("toe2", ModelPartBuilder.create()
                .uv(400, 83).cuboid(-0.75F, -0.75F, -2.5F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(1.8F, 1.4F, -2.2F, 0.15F, -0.25F, 0F));
        ModelPartData p134 = p133.addChild("claw", ModelPartBuilder.create()
                .uv(506, 83).cuboid(-0.5F, -0.5F, -2.2F, 1F, 1F, 2F, new Dilation(0.05F)),
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
