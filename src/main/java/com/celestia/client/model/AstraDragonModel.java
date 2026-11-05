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

/** Huya, the star-dragon girl (boss). Rendered at 1.5x; texture image is 4x denser than the declared 512x64. */
public class AstraDragonModel<T extends AstraDragonEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root, torso, head, halo, cape, lArm, rArm, lFore, rFore, lWing, rWing, lHand, rHand, lLeg, rLeg;
    private final ModelPart[] braid = new ModelPart[7];
    private final ModelPart[] tail = new ModelPart[9];

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
        for (int i = 0; i < 7; i++) {
            b = b.getChild("braid" + i);
            braid[i] = b;
        }
        ModelPart t = torso;
        for (int i = 0; i < 9; i++) {
            t = t.getChild("tail" + i);
            tail[i] = t;
        }
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData root = modelData.getRoot();
        ModelPartData p0 = root.addChild("torso", ModelPartBuilder.create()
                .uv(112, 0).cuboid(-3.5F, -11F, -2F, 7F, 5F, 4F, new Dilation(0F))
                .uv(408, 0).cuboid(-3F, -6F, -1.75F, 6F, 4F, 3F, new Dilation(0.1F))
                .uv(426, 0).cuboid(-3.6F, -2.2F, -2.1F, 7F, 3F, 4F, new Dilation(0.05F))
                .uv(308, 17).cuboid(-3.4F, -3.2F, -2.2F, 7F, 1F, 4F, new Dilation(0F))
                .uv(226, 24).cuboid(-0.75F, -3.4F, -2.6F, 2F, 2F, 1F, new Dilation(-0.25F))
                .uv(232, 24).cuboid(-3.2F, -11.6F, -2.3F, 6F, 2F, 1F, new Dilation(0F))
                .uv(246, 24).cuboid(-0.75F, -10.4F, -2.6F, 2F, 2F, 1F, new Dilation(-0.3F))
                .uv(46, 24).cuboid(-1.6F, -12.4F, -1.5F, 3F, 1F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 12F, 0F, 0F, 0F, 0F));
        ModelPartData p1 = p0.addChild("head", ModelPartBuilder.create()
                .uv(18, 0).cuboid(-4F, -8F, -4F, 8F, 8F, 8F, new Dilation(0F))
                .uv(80, 0).cuboid(-4.3F, -8.6F, -4.3F, 8F, 2F, 8F, new Dilation(0.3F))
                .uv(50, 0).cuboid(-4.4F, -7.2F, -3.3F, 8F, 5F, 7F, new Dilation(0.4F))
                .uv(134, 0).cuboid(-4.2F, -6F, 1.5F, 8F, 6F, 3F, new Dilation(0.3F)),
                ModelTransform.of(0F, -11.6F, 0F, 0F, 0F, 0F));
        ModelPartData p2 = p1.addChild("left_horn0", ModelPartBuilder.create()
                .uv(58, 24).cuboid(-0.75F, -0.75F, 0F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(2.4F, -7.8F, -0.6F, 1.15F, 0.42F, 0.2F));
        ModelPartData p3 = p2.addChild("left_horn1", ModelPartBuilder.create()
                .uv(66, 24).cuboid(-0.6F, -0.6F, 0F, 1F, 1F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 2.7F, 0.32F, 0.05F, 0F));
        ModelPartData p4 = p3.addChild("left_horn2", ModelPartBuilder.create()
                .uv(252, 24).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 2.7F, 0.32F, 0.05F, 0F));
        ModelPartData p5 = p4.addChild("left_horn3", ModelPartBuilder.create()
                .uv(258, 24).cuboid(-0.4F, -0.4F, 0F, 1F, 1F, 2F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, 1.7F, 0.32F, 0.05F, 0F));
        ModelPartData p6 = p1.addChild("right_horn0", ModelPartBuilder.create()
                .uv(74, 24).cuboid(-0.75F, -0.75F, 0F, 1F, 1F, 3F, new Dilation(0.25F)),
                ModelTransform.of(-2.4F, -7.8F, -0.6F, 1.15F, -0.42F, -0.2F));
        ModelPartData p7 = p6.addChild("right_horn1", ModelPartBuilder.create()
                .uv(82, 24).cuboid(-0.6F, -0.6F, 0F, 1F, 1F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 2.7F, 0.32F, -0.05F, 0F));
        ModelPartData p8 = p7.addChild("right_horn2", ModelPartBuilder.create()
                .uv(264, 24).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 2.7F, 0.32F, -0.05F, 0F));
        ModelPartData p9 = p8.addChild("right_horn3", ModelPartBuilder.create()
                .uv(270, 24).cuboid(-0.4F, -0.4F, 0F, 1F, 1F, 2F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, 1.7F, 0.32F, -0.05F, 0F));
        ModelPartData p10 = p1.addChild("halo", ModelPartBuilder.create()
                .uv(304, 24).cuboid(4.5F, -0.5F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(308, 24).cuboid(4.3746F, 0.6126F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(312, 24).cuboid(4.0048F, 1.6694F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(316, 24).cuboid(3.4092F, 2.6174F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(320, 24).cuboid(2.6174F, 3.4092F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(324, 24).cuboid(1.6694F, 4.0048F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(328, 24).cuboid(0.6126F, 4.3746F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(332, 24).cuboid(-0.5F, 4.5F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(336, 24).cuboid(-1.6126F, 4.3746F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(340, 24).cuboid(-2.6694F, 4.0048F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(344, 24).cuboid(-3.6174F, 3.4092F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(348, 24).cuboid(-4.4092F, 2.6174F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(352, 24).cuboid(-5.0048F, 1.6694F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(356, 24).cuboid(-5.3746F, 0.6126F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(360, 24).cuboid(-5.5F, -0.5F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(364, 24).cuboid(-5.3746F, -1.6126F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(368, 24).cuboid(-5.0048F, -2.6694F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(372, 24).cuboid(-4.4092F, -3.6174F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(376, 24).cuboid(-3.6174F, -4.4092F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(380, 24).cuboid(-2.6694F, -5.0048F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(384, 24).cuboid(-1.6126F, -5.3746F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(388, 24).cuboid(-0.5F, -5.5F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(392, 24).cuboid(0.6126F, -5.3746F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(396, 24).cuboid(1.6694F, -5.0048F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(400, 24).cuboid(2.6174F, -4.4092F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(404, 24).cuboid(3.4092F, -3.6174F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(408, 24).cuboid(4.0048F, -2.6694F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(412, 24).cuboid(4.3746F, -1.6126F, -0.5F, 1F, 1F, 1F, new Dilation(-0.28F))
                .uv(416, 24).cuboid(3.0355F, 3.0355F, -0.5F, 1F, 1F, 1F, new Dilation(0.15F))
                .uv(420, 24).cuboid(-4.0355F, 3.0355F, -0.5F, 1F, 1F, 1F, new Dilation(0.15F))
                .uv(424, 24).cuboid(-4.0355F, -4.0355F, -0.5F, 1F, 1F, 1F, new Dilation(0.15F))
                .uv(428, 24).cuboid(3.0355F, -4.0355F, -0.5F, 1F, 1F, 1F, new Dilation(0.15F)),
                ModelTransform.of(0F, -4.5F, 6.2F, 0.1F, 0F, 0F));
        ModelPartData p11 = p1.addChild("braid0", ModelPartBuilder.create()
                .uv(330, 17).cuboid(-1.2F, 0F, -1.2F, 2F, 3F, 2F, new Dilation(0.2F)),
                ModelTransform.of(0F, -2F, 4.2F, 0.42F, 0F, -0.03F));
        ModelPartData p12 = p11.addChild("braid1", ModelPartBuilder.create()
                .uv(338, 17).cuboid(-1.2F, 0F, -1.2F, 2F, 3F, 2F, new Dilation(0.28F)),
                ModelTransform.of(0F, 2.7F, 0F, -0.06F, 0F, 0.03F));
        ModelPartData p13 = p12.addChild("braid2", ModelPartBuilder.create()
                .uv(346, 17).cuboid(-1.2F, 0F, -1.2F, 2F, 3F, 2F, new Dilation(0.2F)),
                ModelTransform.of(0F, 2.7F, 0F, -0.06F, 0F, -0.03F));
        ModelPartData p14 = p13.addChild("braid3", ModelPartBuilder.create()
                .uv(354, 17).cuboid(-1.2F, 0F, -1.2F, 2F, 3F, 2F, new Dilation(0.28F)),
                ModelTransform.of(0F, 2.7F, 0F, -0.06F, 0F, 0.03F));
        ModelPartData p15 = p14.addChild("braid4", ModelPartBuilder.create()
                .uv(362, 17).cuboid(-1.2F, 0F, -1.2F, 2F, 3F, 2F, new Dilation(0.2F)),
                ModelTransform.of(0F, 2.7F, 0F, -0.06F, 0F, -0.03F));
        ModelPartData p16 = p15.addChild("braid5", ModelPartBuilder.create()
                .uv(370, 17).cuboid(-0.9F, 0F, -0.9F, 2F, 3F, 2F, new Dilation(-0.02F)),
                ModelTransform.of(0F, 2.7F, 0F, -0.06F, 0F, 0.03F));
        ModelPartData p17 = p16.addChild("braid6", ModelPartBuilder.create()
                .uv(378, 17).cuboid(-0.9F, 0F, -0.9F, 2F, 3F, 2F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 2.7F, 0F, -0.06F, 0F, -0.03F));
        ModelPartData p18 = p17.addChild("ribbon", ModelPartBuilder.create()
                .uv(276, 24).cuboid(-1F, 0F, -1F, 2F, 1F, 2F, new Dilation(0.05F))
                .uv(284, 24).cuboid(-2.2F, 0.2F, -0.3F, 4F, 2F, 1F, new Dilation(-0.2F)),
                ModelTransform.of(0F, 2.6F, 0F, 0F, 0F, 0F));
        ModelPartData p19 = p18.addChild("tuft", ModelPartBuilder.create()
                .uv(386, 17).cuboid(-1F, 0F, -1F, 2F, 3F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 1.2F, 0F, 0F, 0F, 0F));
        ModelPartData p20 = p1.addChild("ahoge", ModelPartBuilder.create()
                .uv(90, 24).cuboid(-0.5F, -2.6F, -0.3F, 1F, 3F, 1F, new Dilation(-0.2F)),
                ModelTransform.of(0.5F, -8.4F, -1.5F, -0.7F, 0.2F, 0.25F));
        ModelPartData p21 = p20.addChild("ahoge2", ModelPartBuilder.create()
                .uv(294, 24).cuboid(-0.5F, -2F, -0.3F, 1F, 2F, 1F, new Dilation(-0.25F)),
                ModelTransform.of(0F, -2.4F, 0F, -0.9F, 0F, 0F));
        ModelPartData p22 = p1.addChild("bang0", ModelPartBuilder.create()
                .uv(94, 24).cuboid(-0.75F, 0F, -0.5F, 2F, 3F, 1F, new Dilation(-0.25F)),
                ModelTransform.of(-3.2F, -8.2F, -4.15F, 0.12F, 0F, 0.12F));
        ModelPartData p23 = p1.addChild("bang1", ModelPartBuilder.create()
                .uv(394, 17).cuboid(-0.75F, 0F, -0.5F, 2F, 4F, 1F, new Dilation(-0.25F)),
                ModelTransform.of(-1.8F, -8.2F, -4.15F, 0.12F, 0F, 0.05F));
        ModelPartData p24 = p1.addChild("bang2", ModelPartBuilder.create()
                .uv(100, 24).cuboid(-0.75F, 0F, -0.5F, 2F, 3F, 1F, new Dilation(-0.25F)),
                ModelTransform.of(-0.4F, -8.2F, -4.15F, 0.12F, 0F, 0F));
        ModelPartData p25 = p1.addChild("bang3", ModelPartBuilder.create()
                .uv(400, 17).cuboid(-0.75F, 0F, -0.5F, 2F, 4F, 1F, new Dilation(-0.25F)),
                ModelTransform.of(1F, -8.2F, -4.15F, 0.12F, 0F, -0.04F));
        ModelPartData p26 = p1.addChild("bang4", ModelPartBuilder.create()
                .uv(106, 24).cuboid(-0.75F, 0F, -0.5F, 2F, 3F, 1F, new Dilation(-0.25F)),
                ModelTransform.of(2.4F, -8.2F, -4.15F, 0.12F, 0F, -0.1F));
        ModelPartData p27 = p1.addChild("bang5", ModelPartBuilder.create()
                .uv(298, 24).cuboid(-0.75F, 0F, -0.5F, 2F, 2F, 1F, new Dilation(-0.25F)),
                ModelTransform.of(3.4F, -8.2F, -4.15F, 0.12F, 0F, -0.16F));
        ModelPartData p28 = p1.addChild("sidel0", ModelPartBuilder.create()
                .uv(448, 0).cuboid(-1F, 0F, -1F, 2F, 5F, 2F, new Dilation(0F)),
                ModelTransform.of(3.9F, -6.5F, -2.6F, 0.06F, 0F, 0.1F));
        ModelPartData p29 = p28.addChild("sidel1", ModelPartBuilder.create()
                .uv(88, 17).cuboid(-1F, 0F, -1F, 2F, 4F, 2F, new Dilation(0.02F)),
                ModelTransform.of(0F, 4.7F, 0F, 0.08F, 0F, 0F));
        ModelPartData p30 = p29.addChild("sidel2", ModelPartBuilder.create()
                .uv(112, 24).cuboid(-0.8F, 0F, -0.8F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 3.7F, 0F, 0.1F, 0F, 0F));
        ModelPartData p31 = p1.addChild("sider0", ModelPartBuilder.create()
                .uv(456, 0).cuboid(-1F, 0F, -1F, 2F, 5F, 2F, new Dilation(0F)),
                ModelTransform.of(-3.9F, -6.5F, -2.6F, 0.06F, 0F, -0.1F));
        ModelPartData p32 = p31.addChild("sider1", ModelPartBuilder.create()
                .uv(96, 17).cuboid(-1F, 0F, -1F, 2F, 4F, 2F, new Dilation(0.02F)),
                ModelTransform.of(0F, 4.7F, 0F, 0.08F, 0F, 0F));
        ModelPartData p33 = p32.addChild("sider2", ModelPartBuilder.create()
                .uv(116, 24).cuboid(-0.8F, 0F, -0.8F, 1F, 3F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 3.7F, 0F, 0.1F, 0F, 0F));
        ModelPartData p34 = p1.addChild("back00", ModelPartBuilder.create()
                .uv(236, 0).cuboid(-1.1F, 0F, -1F, 2F, 6F, 2F, new Dilation(0F)),
                ModelTransform.of(-3.2F, -6.5F, 3.2F, 0.16F, 0F, 0.096F));
        ModelPartData p35 = p34.addChild("back01", ModelPartBuilder.create()
                .uv(104, 17).cuboid(-1F, 0F, -0.9F, 2F, 5F, 1F, new Dilation(0.02F)),
                ModelTransform.of(0F, 5.7F, 0F, 0.06F, 0F, 0F));
        ModelPartData p36 = p35.addChild("back02", ModelPartBuilder.create()
                .uv(406, 17).cuboid(-0.8F, 0F, -0.7F, 1F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 4.7F, 0F, 0.08F, 0F, 0F));
        ModelPartData p37 = p1.addChild("back10", ModelPartBuilder.create()
                .uv(156, 0).cuboid(-1.1F, 0F, -1F, 2F, 7F, 2F, new Dilation(0F)),
                ModelTransform.of(-1.6F, -6.5F, 3.2F, 0.16F, 0F, 0.048F));
        ModelPartData p38 = p37.addChild("back11", ModelPartBuilder.create()
                .uv(110, 17).cuboid(-1F, 0F, -0.9F, 2F, 5F, 1F, new Dilation(0.02F)),
                ModelTransform.of(0F, 6.7F, 0F, 0.06F, 0F, 0F));
        ModelPartData p39 = p38.addChild("back12", ModelPartBuilder.create()
                .uv(410, 17).cuboid(-0.8F, 0F, -0.7F, 1F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 4.7F, 0F, 0.08F, 0F, 0F));
        ModelPartData p40 = p1.addChild("back20", ModelPartBuilder.create()
                .uv(164, 0).cuboid(-1.1F, 0F, -1F, 2F, 7F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, -6.5F, 3.2F, 0.16F, 0F, 0F));
        ModelPartData p41 = p40.addChild("back21", ModelPartBuilder.create()
                .uv(116, 17).cuboid(-1F, 0F, -0.9F, 2F, 5F, 1F, new Dilation(0.02F)),
                ModelTransform.of(0F, 6.7F, 0F, 0.06F, 0F, 0F));
        ModelPartData p42 = p41.addChild("back22", ModelPartBuilder.create()
                .uv(414, 17).cuboid(-0.8F, 0F, -0.7F, 1F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 4.7F, 0F, 0.08F, 0F, 0F));
        ModelPartData p43 = p1.addChild("back30", ModelPartBuilder.create()
                .uv(172, 0).cuboid(-1.1F, 0F, -1F, 2F, 7F, 2F, new Dilation(0F)),
                ModelTransform.of(1.6F, -6.5F, 3.2F, 0.16F, 0F, -0.048F));
        ModelPartData p44 = p43.addChild("back31", ModelPartBuilder.create()
                .uv(122, 17).cuboid(-1F, 0F, -0.9F, 2F, 5F, 1F, new Dilation(0.02F)),
                ModelTransform.of(0F, 6.7F, 0F, 0.06F, 0F, 0F));
        ModelPartData p45 = p44.addChild("back32", ModelPartBuilder.create()
                .uv(418, 17).cuboid(-0.8F, 0F, -0.7F, 1F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 4.7F, 0F, 0.08F, 0F, 0F));
        ModelPartData p46 = p1.addChild("back40", ModelPartBuilder.create()
                .uv(244, 0).cuboid(-1.1F, 0F, -1F, 2F, 6F, 2F, new Dilation(0F)),
                ModelTransform.of(3.2F, -6.5F, 3.2F, 0.16F, 0F, -0.096F));
        ModelPartData p47 = p46.addChild("back41", ModelPartBuilder.create()
                .uv(128, 17).cuboid(-1F, 0F, -0.9F, 2F, 5F, 1F, new Dilation(0.02F)),
                ModelTransform.of(0F, 5.7F, 0F, 0.06F, 0F, 0F));
        ModelPartData p48 = p47.addChild("back42", ModelPartBuilder.create()
                .uv(422, 17).cuboid(-0.8F, 0F, -0.7F, 1F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 4.7F, 0F, 0.08F, 0F, 0F));
        ModelPartData p49 = p0.addChild("left_arm", ModelPartBuilder.create()
                .uv(426, 17).cuboid(-1F, -1.2F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(464, 0).cuboid(-1F, 0F, -1F, 2F, 5F, 2F, new Dilation(0F)),
                ModelTransform.of(4.6F, -9.6F, 0F, -0.1F, 0F, -0.18F));
        ModelPartData p50 = p49.addChild("forearm", ModelPartBuilder.create()
                .uv(134, 17).cuboid(-1F, 0F, -1F, 2F, 4F, 2F, new Dilation(-0.02F))
                .uv(142, 17).cuboid(-1.6F, 2F, -1.6F, 3F, 3F, 3F, new Dilation(0.05F))
                .uv(120, 24).cuboid(-0.9F, 4.6F, -0.9F, 2F, 2F, 2F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 4.8F, 0F, -0.3F, 0F, 0F));
        ModelPartData p51 = p0.addChild("right_arm", ModelPartBuilder.create()
                .uv(438, 17).cuboid(-2F, -1.2F, -1.5F, 3F, 2F, 3F, new Dilation(0.2F))
                .uv(472, 0).cuboid(-1F, 0F, -1F, 2F, 5F, 2F, new Dilation(0F)),
                ModelTransform.of(-4.6F, -9.6F, 0F, -0.1F, 0F, 0.18F));
        ModelPartData p52 = p51.addChild("forearm", ModelPartBuilder.create()
                .uv(154, 17).cuboid(-1F, 0F, -1F, 2F, 4F, 2F, new Dilation(-0.02F))
                .uv(162, 17).cuboid(-1.6F, 2F, -1.6F, 3F, 3F, 3F, new Dilation(0.05F))
                .uv(128, 24).cuboid(-0.9F, 4.6F, -0.9F, 2F, 2F, 2F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 4.8F, 0F, -0.3F, 0F, 0F));
        ModelPartData p53 = p0.addChild("left_wing", ModelPartBuilder.create()
                .uv(432, 24).cuboid(0F, -0.75F, -0.75F, 9F, 1F, 1F, new Dilation(0.15F))
                .uv(252, 0).cuboid(0F, -0.25F, 0.4F, 9F, 1F, 7F, new Dilation(-0.35F)),
                ModelTransform.of(1.8F, -9F, 2.2F, 0.3F, -0.7F, -0.42F));
        ModelPartData p54 = p53.addChild("hand", ModelPartBuilder.create()
                .uv(452, 24).cuboid(0F, -0.75F, -0.75F, 1F, 1F, 1F, new Dilation(0.3F)),
                ModelTransform.of(9F, 0F, 0F, 0F, 0.15F, 0F));
        ModelPartData p55 = p54.addChild("finger0", ModelPartBuilder.create()
                .uv(456, 24).cuboid(0F, -0.5F, -0.5F, 13F, 1F, 1F, new Dilation(-0.1F))
                .uv(484, 24).cuboid(12F, -0.5F, -0.5F, 1F, 1F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.1F, 0F));
        ModelPartData p56 = p55.addChild("web", ModelPartBuilder.create()
                .uv(284, 0).cuboid(0F, -0.25F, 0F, 12F, 1F, 7F, new Dilation(-0.35F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p57 = p54.addChild("finger1", ModelPartBuilder.create()
                .uv(488, 24).cuboid(0F, -0.5F, -0.5F, 11F, 1F, 1F, new Dilation(-0.1F))
                .uv(0, 29).cuboid(10F, -0.5F, -0.5F, 1F, 1F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.55F, 0F));
        ModelPartData p58 = p57.addChild("web", ModelPartBuilder.create()
                .uv(480, 0).cuboid(0F, -0.25F, 0F, 10F, 1F, 6F, new Dilation(-0.35F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p59 = p54.addChild("finger2", ModelPartBuilder.create()
                .uv(4, 29).cuboid(0F, -0.5F, -0.5F, 8F, 1F, 1F, new Dilation(-0.1F))
                .uv(22, 29).cuboid(7F, -0.5F, -0.5F, 1F, 1F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -1F, 0F));
        ModelPartData p60 = p59.addChild("web", ModelPartBuilder.create()
                .uv(174, 17).cuboid(0F, -0.25F, 0F, 7F, 1F, 5F, new Dilation(-0.35F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p61 = p0.addChild("right_wing", ModelPartBuilder.create()
                .uv(26, 29).cuboid(-9F, -0.75F, -0.75F, 9F, 1F, 1F, new Dilation(0.15F))
                .uv(322, 0).cuboid(-9F, -0.25F, 0.4F, 9F, 1F, 7F, new Dilation(-0.35F)),
                ModelTransform.of(-1.8F, -9F, 2.2F, 0.3F, 0.7F, 0.42F));
        ModelPartData p62 = p61.addChild("hand", ModelPartBuilder.create()
                .uv(46, 29).cuboid(-1F, -0.75F, -0.75F, 1F, 1F, 1F, new Dilation(0.3F)),
                ModelTransform.of(-9F, 0F, 0F, 0F, -0.15F, 0F));
        ModelPartData p63 = p62.addChild("finger0", ModelPartBuilder.create()
                .uv(50, 29).cuboid(-13F, -0.5F, -0.5F, 13F, 1F, 1F, new Dilation(-0.1F))
                .uv(78, 29).cuboid(-13F, -0.5F, -0.5F, 1F, 1F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.1F, 0F));
        ModelPartData p64 = p63.addChild("web", ModelPartBuilder.create()
                .uv(354, 0).cuboid(-12F, -0.25F, 0F, 12F, 1F, 7F, new Dilation(-0.35F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p65 = p62.addChild("finger1", ModelPartBuilder.create()
                .uv(82, 29).cuboid(-11F, -0.5F, -0.5F, 11F, 1F, 1F, new Dilation(-0.1F))
                .uv(106, 29).cuboid(-11F, -0.5F, -0.5F, 1F, 1F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.55F, 0F));
        ModelPartData p66 = p65.addChild("web", ModelPartBuilder.create()
                .uv(0, 17).cuboid(-10F, -0.25F, 0F, 10F, 1F, 6F, new Dilation(-0.35F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p67 = p62.addChild("finger2", ModelPartBuilder.create()
                .uv(110, 29).cuboid(-8F, -0.5F, -0.5F, 8F, 1F, 1F, new Dilation(-0.1F))
                .uv(128, 29).cuboid(-8F, -0.5F, -0.5F, 1F, 1F, 1F, new Dilation(0.1F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 1F, 0F));
        ModelPartData p68 = p67.addChild("web", ModelPartBuilder.create()
                .uv(198, 17).cuboid(-7F, -0.25F, 0F, 7F, 1F, 5F, new Dilation(-0.35F)),
                ModelTransform.of(0F, 0F, 0.3F, 0F, 0F, 0F));
        ModelPartData p69 = p0.addChild("tail0", ModelPartBuilder.create()
                .uv(450, 17).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, -1F, 2F, 1.2F, 0F, 0F));
        ModelPartData p70 = p69.addChild("tail1", ModelPartBuilder.create()
                .uv(460, 17).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(0.01F)),
                ModelTransform.of(0F, 0F, 2.9F, -0.13F, 0F, 0F));
        ModelPartData p71 = p70.addChild("tail2", ModelPartBuilder.create()
                .uv(470, 17).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(-0.08F)),
                ModelTransform.of(0F, 0F, 2.9F, -0.13F, 0F, 0F));
        ModelPartData p72 = p71.addChild("tail3", ModelPartBuilder.create()
                .uv(480, 17).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(-0.17F)),
                ModelTransform.of(0F, 0F, 2.9F, -0.13F, 0.12F, 0F));
        ModelPartData p73 = p72.addChild("tail4", ModelPartBuilder.create()
                .uv(490, 17).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(-0.26F)),
                ModelTransform.of(0F, 0F, 2.9F, -0.13F, 0.12F, 0F));
        ModelPartData p74 = p73.addChild("tail5", ModelPartBuilder.create()
                .uv(500, 17).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(-0.35F)),
                ModelTransform.of(0F, 0F, 2.9F, -0.13F, 0.12F, 0F));
        ModelPartData p75 = p74.addChild("tail6", ModelPartBuilder.create()
                .uv(0, 24).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(-0.44F)),
                ModelTransform.of(0F, 0F, 2.9F, -0.22F, 0.12F, 0F));
        ModelPartData p76 = p75.addChild("tail7", ModelPartBuilder.create()
                .uv(10, 24).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(-0.53F)),
                ModelTransform.of(0F, 0F, 2.9F, -0.22F, 0.12F, 0F));
        ModelPartData p77 = p76.addChild("tail8", ModelPartBuilder.create()
                .uv(20, 24).cuboid(-1F, -1F, 0F, 2F, 2F, 3F, new Dilation(-0.62F)),
                ModelTransform.of(0F, 0F, 2.9F, -0.22F, 0.12F, 0F));
        ModelPartData p78 = p77.addChild("tip", ModelPartBuilder.create()
                .uv(222, 17).cuboid(-0.5F, -2F, 0F, 1F, 4F, 2F, new Dilation(0F))
                .uv(136, 24).cuboid(-0.5F, -1F, 1.6F, 1F, 2F, 2F, new Dilation(-0.15F)),
                ModelTransform.of(0F, 0F, 2.8F, 0F, 0F, 0F));
        ModelPartData p79 = p0.addChild("frill0", ModelPartBuilder.create()
                .uv(228, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0.2F, -2F, -0.55F, 0F, 0F));
        ModelPartData p80 = p0.addChild("frill1", ModelPartBuilder.create()
                .uv(236, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(1.7634F, 0.2F, -1.618F, -0.445F, -0.6283F, 0F));
        ModelPartData p81 = p0.addChild("frill2", ModelPartBuilder.create()
                .uv(244, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(2.8532F, 0.2F, -0.618F, -0.17F, -1.2566F, 0F));
        ModelPartData p82 = p0.addChild("frill3", ModelPartBuilder.create()
                .uv(252, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(2.8532F, 0.2F, 0.618F, 0.17F, -1.885F, 0F));
        ModelPartData p83 = p0.addChild("frill4", ModelPartBuilder.create()
                .uv(260, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(1.7634F, 0.2F, 1.618F, 0.445F, -2.5133F, 0F));
        ModelPartData p84 = p0.addChild("frill5", ModelPartBuilder.create()
                .uv(268, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0.2F, 2F, 0.55F, -3.1416F, 0F));
        ModelPartData p85 = p0.addChild("frill6", ModelPartBuilder.create()
                .uv(276, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(-1.7634F, 0.2F, 1.618F, 0.445F, -3.7699F, 0F));
        ModelPartData p86 = p0.addChild("frill7", ModelPartBuilder.create()
                .uv(284, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(-2.8532F, 0.2F, 0.618F, 0.17F, -4.3982F, 0F));
        ModelPartData p87 = p0.addChild("frill8", ModelPartBuilder.create()
                .uv(292, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(-2.8532F, 0.2F, -0.618F, -0.17F, -5.0265F, 0F));
        ModelPartData p88 = p0.addChild("frill9", ModelPartBuilder.create()
                .uv(300, 17).cuboid(-1.2F, 0F, -0.4F, 3F, 5F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(-1.7634F, 0.2F, -1.618F, -0.445F, -5.6549F, 0F));
        ModelPartData p89 = p0.addChild("skirt0", ModelPartBuilder.create()
                .uv(30, 24).cuboid(-1.3F, 0F, -0.5F, 3F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(0.9271F, -0.4F, -1.9021F, -0.3994F, -0.3142F, 0F));
        ModelPartData p90 = p0.addChild("skirt1", ModelPartBuilder.create()
                .uv(32, 17).cuboid(-1.3F, 0F, -0.5F, 3F, 6F, 1F, new Dilation(0F)),
                ModelTransform.of(2.4271F, -0.4F, -1.1756F, -0.2469F, -0.9425F, 0F));
        ModelPartData p91 = p0.addChild("skirt2", ModelPartBuilder.create()
                .uv(40, 17).cuboid(-1.3F, 0F, -0.5F, 3F, 6F, 1F, new Dilation(0F)),
                ModelTransform.of(3F, -0.4F, 0F, 0F, -1.5708F, 0F));
        ModelPartData p92 = p0.addChild("skirt3", ModelPartBuilder.create()
                .uv(180, 0).cuboid(-1.3F, 0F, -0.5F, 3F, 8F, 1F, new Dilation(0F)),
                ModelTransform.of(2.4271F, -0.4F, 1.1756F, 0.2469F, -2.1991F, 0F));
        ModelPartData p93 = p0.addChild("skirt4", ModelPartBuilder.create()
                .uv(188, 0).cuboid(-1.3F, 0F, -0.5F, 3F, 8F, 1F, new Dilation(0F)),
                ModelTransform.of(0.9271F, -0.4F, 1.9021F, 0.3994F, -2.8274F, 0F));
        ModelPartData p94 = p0.addChild("skirt5", ModelPartBuilder.create()
                .uv(196, 0).cuboid(-1.3F, 0F, -0.5F, 3F, 8F, 1F, new Dilation(0F)),
                ModelTransform.of(-0.9271F, -0.4F, 1.9021F, 0.3994F, -3.4558F, 0F));
        ModelPartData p95 = p0.addChild("skirt6", ModelPartBuilder.create()
                .uv(204, 0).cuboid(-1.3F, 0F, -0.5F, 3F, 8F, 1F, new Dilation(0F)),
                ModelTransform.of(-2.4271F, -0.4F, 1.1756F, 0.2469F, -4.0841F, 0F));
        ModelPartData p96 = p0.addChild("skirt7", ModelPartBuilder.create()
                .uv(48, 17).cuboid(-1.3F, 0F, -0.5F, 3F, 6F, 1F, new Dilation(0F)),
                ModelTransform.of(-3F, -0.4F, 0F, 0F, -4.7124F, 0F));
        ModelPartData p97 = p0.addChild("skirt8", ModelPartBuilder.create()
                .uv(56, 17).cuboid(-1.3F, 0F, -0.5F, 3F, 6F, 1F, new Dilation(0F)),
                ModelTransform.of(-2.4271F, -0.4F, -1.1756F, -0.2469F, -5.3407F, 0F));
        ModelPartData p98 = p0.addChild("skirt9", ModelPartBuilder.create()
                .uv(38, 24).cuboid(-1.3F, 0F, -0.5F, 3F, 4F, 1F, new Dilation(0F)),
                ModelTransform.of(-0.9271F, -0.4F, -1.9021F, -0.3994F, -5.969F, 0F));
        ModelPartData p99 = p0.addChild("cape", ModelPartBuilder.create()
                .uv(0, 0).cuboid(-4F, 0F, 0F, 8F, 16F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, -10.8F, 2.2F, 0.12F, 0F, 0F));
        ModelPartData p100 = p99.addChild("cape_tip", ModelPartBuilder.create()
                .uv(142, 24).cuboid(-3.5F, 0F, 0F, 7F, 3F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 16F, 0F, 0.12F, 0F, 0F));
        ModelPartData p1101 = root.addChild("left_leg", ModelPartBuilder.create()
                .uv(212, 0).cuboid(-1.25F, 0F, -1.25F, 3F, 6F, 3F, new Dilation(-0.25F))
                .uv(158, 24).cuboid(-1.3F, 4.5F, -1.3F, 3F, 1F, 3F, new Dilation(-0.15F)),
                ModelTransform.of(1.9F, 12.2F, 0F, 0F, 0F, 0.11F));
        ModelPartData p1102 = p1101.addChild("shin", ModelPartBuilder.create()
                .uv(392, 0).cuboid(-1.1F, 0F, -1.1F, 2F, 6F, 2F, new Dilation(0.1F))
                .uv(64, 17).cuboid(-1.4F, 2.5F, -1.6F, 3F, 4F, 3F, new Dilation(-0.1F))
                .uv(170, 24).cuboid(-1.5F, 2.3F, -1.7F, 3F, 1F, 3F, new Dilation(0F))
                .uv(182, 24).cuboid(-1.2F, 5.2F, -2.3F, 2F, 1F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 5.8F, 0F, 0.06F, 0F, 0F));
        ModelPartData p2103 = root.addChild("right_leg", ModelPartBuilder.create()
                .uv(224, 0).cuboid(-1.25F, 0F, -1.25F, 3F, 6F, 3F, new Dilation(-0.25F))
                .uv(192, 24).cuboid(-1.3F, 4.5F, -1.3F, 3F, 1F, 3F, new Dilation(-0.15F)),
                ModelTransform.of(-1.9F, 12.2F, 0F, 0F, 0F, -0.11F));
        ModelPartData p2104 = p2103.addChild("shin", ModelPartBuilder.create()
                .uv(400, 0).cuboid(-1.1F, 0F, -1.1F, 2F, 6F, 2F, new Dilation(0.1F))
                .uv(76, 17).cuboid(-1.4F, 2.5F, -1.6F, 3F, 4F, 3F, new Dilation(-0.1F))
                .uv(204, 24).cuboid(-1.5F, 2.3F, -1.7F, 3F, 1F, 3F, new Dilation(0F))
                .uv(216, 24).cuboid(-1.2F, 5.2F, -2.3F, 2F, 1F, 3F, new Dilation(0.1F)),
                ModelTransform.of(0F, 5.8F, 0F, 0.06F, 0F, 0F));
        return TexturedModelData.of(modelData, 512, 64);
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
