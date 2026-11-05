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

/** Astra, the Violet Star Dragon. Half-scale geometry; the renderer scales it by 2. (256x128 texture) */
public class AstraDragonModel<T extends AstraDragonEntity> extends SinglePartEntityModel<T> {
    private final ModelPart root, body, jaw, head;
    private final ModelPart[] neck = new ModelPart[4];
    private final ModelPart[] tail = new ModelPart[8];
    private final ModelPart lWing, lFore, lHand, rWing, rFore, rHand;
    private final ModelPart[] legs = new ModelPart[4];

    public AstraDragonModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild("body");
        ModelPart n = body.getChild("neck_root");
        for (int i = 0; i < 4; i++) {
            n = n.getChild("neck" + i);
            neck[i] = n;
        }
        this.head = n.getChild("head");
        this.jaw = head.getChild("jaw");
        ModelPart t = body;
        for (int i = 0; i < 8; i++) {
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
                .uv(0, 0).cuboid(-6.5F, -6F, -11F, 13F, 11F, 21F, new Dilation(0F))
                .uv(68, 0).cuboid(-5.5F, -7F, -10F, 11F, 13F, 19F, new Dilation(0F))
                .uv(0, 55).cuboid(-5F, 4.5F, -10F, 10F, 2F, 18F, new Dilation(0.05F))
                .uv(194, 75).cuboid(-5F, -6F, -13F, 10F, 9F, 3F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 6F, 0F, 0F, 0F, 0F));
        ModelPartData p1 = p0.addChild("spike0", ModelPartBuilder.create()
                .uv(86, 101).cuboid(-0.5F, -5F, -1F, 1F, 5F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, -6F, -9F, -0.35F, 0F, 0F));
        ModelPartData p2 = p0.addChild("spike1", ModelPartBuilder.create()
                .uv(92, 101).cuboid(-0.5F, -5F, -1F, 1F, 5F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, -6F, -6F, -0.35F, 0F, 0F));
        ModelPartData p3 = p0.addChild("spike2", ModelPartBuilder.create()
                .uv(60, 110).cuboid(-0.5F, -4F, -1F, 1F, 4F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, -6F, -3F, -0.35F, 0F, 0F));
        ModelPartData p4 = p0.addChild("spike3", ModelPartBuilder.create()
                .uv(66, 110).cuboid(-0.5F, -4F, -1F, 1F, 4F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, -6F, 0F, -0.35F, 0F, 0F));
        ModelPartData p5 = p0.addChild("spike4", ModelPartBuilder.create()
                .uv(228, 110).cuboid(-0.5F, -3F, -1F, 1F, 3F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, -6F, 3F, -0.35F, 0F, 0F));
        ModelPartData p6 = p0.addChild("spike5", ModelPartBuilder.create()
                .uv(234, 110).cuboid(-0.5F, -3F, -1F, 1F, 3F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, -6F, 6F, -0.35F, 0F, 0F));
        ModelPartData p7 = p0.addChild("spike6", ModelPartBuilder.create()
                .uv(240, 110).cuboid(-0.5F, -3F, -1F, 1F, 3F, 2F, new Dilation(0.05F)),
                ModelTransform.of(0F, -6F, 9F, -0.35F, 0F, 0F));
        ModelPartData p8 = p0.addChild("neck_root", ModelPartBuilder.create(),
                ModelTransform.of(0F, -2F, -9F, 0F, 0F, 0F));
        ModelPartData p9 = p8.addChild("neck0", ModelPartBuilder.create()
                .uv(226, 55).cuboid(-4F, -4F, -7F, 8F, 8F, 7F, new Dilation(0F))
                .uv(98, 101).cuboid(-3F, 2.8F, -6F, 6F, 1F, 6F, new Dilation(0.05F))
                .uv(72, 110).cuboid(-0.5F, -6.5F, -4F, 1F, 3F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, -1F, -0.6F, 0F, 0F));
        ModelPartData p10 = p9.addChild("neck1", ModelPartBuilder.create()
                .uv(0, 75).cuboid(-3.5F, -3.5F, -7F, 7F, 7F, 7F, new Dilation(0.1F))
                .uv(122, 101).cuboid(-2.5F, 2.3F, -6F, 5F, 1F, 6F, new Dilation(0.05F))
                .uv(80, 110).cuboid(-0.5F, -6F, -4F, 1F, 3F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, -6F, -0.25F, 0F, 0F));
        ModelPartData p11 = p10.addChild("neck2", ModelPartBuilder.create()
                .uv(102, 75).cuboid(-3F, -3F, -7F, 6F, 6F, 7F, new Dilation(0F))
                .uv(144, 101).cuboid(-2F, 1.8F, -6F, 4F, 1F, 6F, new Dilation(0.05F))
                .uv(88, 110).cuboid(-0.5F, -5.5F, -4F, 1F, 3F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, -6F, 0.1F, 0F, 0F));
        ModelPartData p12 = p11.addChild("neck3", ModelPartBuilder.create()
                .uv(220, 75).cuboid(-2.5F, -2.5F, -7F, 5F, 5F, 7F, new Dilation(0.1F))
                .uv(164, 101).cuboid(-1.5F, 1.3F, -6F, 3F, 1F, 6F, new Dilation(0.05F))
                .uv(96, 110).cuboid(-0.5F, -5F, -4F, 1F, 3F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, -6F, 0.3F, 0F, 0F));
        ModelPartData p13 = p12.addChild("head", ModelPartBuilder.create()
                .uv(188, 55).cuboid(-5F, -4F, -8F, 10F, 7F, 9F, new Dilation(0F))
                .uv(210, 89).cuboid(-4F, -5.3F, -7F, 8F, 2F, 7F, new Dilation(0.05F))
                .uv(28, 75).cuboid(-3.5F, -2.5F, -17F, 7F, 5F, 9F, new Dilation(0F))
                .uv(18, 101).cuboid(-2.5F, -3.4F, -16.5F, 5F, 1F, 7F, new Dilation(0F))
                .uv(110, 89).cuboid(-6F, -1F, -6F, 2F, 4F, 6F, new Dilation(-0.1F))
                .uv(126, 89).cuboid(4F, -1F, -6F, 2F, 4F, 6F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, -5.5F, 0.5F, 0F, 0F));
        ModelPartData p14 = p13.addChild("jaw", ModelPartBuilder.create()
                .uv(0, 89).cuboid(-3.2F, 0F, -9.5F, 6F, 2F, 10F, new Dilation(0.05F))
                .uv(234, 117).cuboid(-2.8F, -0.6F, -9.3F, 5F, 1F, 1F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 2.5F, -7F, 0.18F, 0F, 0F));
        ModelPartData p15 = p13.addChild("left_horn", ModelPartBuilder.create()
                .uv(182, 101).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0.1F)),
                ModelTransform.of(3.2F, -4F, -1F, 0.55F, 0.25F, 0.18F));
        ModelPartData p16 = p15.addChild("h2", ModelPartBuilder.create()
                .uv(104, 110).cuboid(-0.75F, -0.75F, 0F, 1F, 1F, 5F, new Dilation(0.25F)),
                ModelTransform.of(0F, 0F, 4.5F, 0.35F, 0.05F, 0F));
        ModelPartData p17 = p16.addChild("h3", ModelPartBuilder.create()
                .uv(246, 110).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.05F)),
                ModelTransform.of(0F, 0F, 4.5F, 0.35F, 0F, 0F));
        ModelPartData p18 = p13.addChild("right_horn", ModelPartBuilder.create()
                .uv(196, 101).cuboid(-1F, -1F, 0F, 2F, 2F, 5F, new Dilation(0.1F)),
                ModelTransform.of(-3.2F, -4F, -1F, 0.55F, -0.25F, -0.18F));
        ModelPartData p19 = p18.addChild("h2", ModelPartBuilder.create()
                .uv(116, 110).cuboid(-0.75F, -0.75F, 0F, 1F, 1F, 5F, new Dilation(0.25F)),
                ModelTransform.of(0F, 0F, 4.5F, 0.35F, -0.05F, 0F));
        ModelPartData p20 = p19.addChild("h3", ModelPartBuilder.create()
                .uv(0, 117).cuboid(-0.5F, -0.5F, 0F, 1F, 1F, 4F, new Dilation(-0.05F)),
                ModelTransform.of(0F, 0F, 4.5F, 0.35F, 0F, 0F));
        ModelPartData p21 = p13.addChild("crest", ModelPartBuilder.create()
                .uv(42, 101).cuboid(-0.5F, -3F, -1F, 1F, 3F, 5F, new Dilation(0F)),
                ModelTransform.of(0F, -5.5F, -2F, 0.25F, 0F, 0F));
        ModelPartData p22 = p0.addChild("tail0", ModelPartBuilder.create()
                .uv(60, 75).cuboid(-4F, -4F, 0F, 8F, 8F, 6F, new Dilation(0F))
                .uv(10, 117).cuboid(-0.5F, -6F, 1F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, -1F, 9F, -0.1F, 0F, 0F));
        ModelPartData p23 = p22.addChild("tail1", ModelPartBuilder.create()
                .uv(128, 75).cuboid(-3.5F, -3.5F, 0F, 7F, 7F, 6F, new Dilation(0.1F))
                .uv(18, 117).cuboid(-0.5F, -5.5F, 1F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 6F, 0.07F, 0F, 0F));
        ModelPartData p24 = p23.addChild("tail2", ModelPartBuilder.create()
                .uv(32, 89).cuboid(-3F, -3F, 0F, 6F, 6F, 6F, new Dilation(0F))
                .uv(26, 117).cuboid(-0.5F, -5F, 1F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 6F, 0.07F, 0F, 0F));
        ModelPartData p25 = p24.addChild("tail3", ModelPartBuilder.create()
                .uv(56, 89).cuboid(-2.5F, -2.5F, 0F, 5F, 5F, 6F, new Dilation(0.1F))
                .uv(34, 117).cuboid(-0.5F, -4.5F, 1F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 6F, 0.07F, 0F, 0F));
        ModelPartData p26 = p25.addChild("tail4", ModelPartBuilder.create()
                .uv(142, 89).cuboid(-2F, -2F, 0F, 4F, 4F, 6F, new Dilation(0F))
                .uv(42, 117).cuboid(-0.5F, -4F, 1F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 6F, 0.07F, 0.1F, 0F));
        ModelPartData p27 = p26.addChild("tail5", ModelPartBuilder.create()
                .uv(0, 101).cuboid(-1.5F, -1.5F, 0F, 3F, 3F, 6F, new Dilation(0.1F))
                .uv(50, 117).cuboid(-0.5F, -3.5F, 1F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 6F, 0.07F, 0.1F, 0F));
        ModelPartData p28 = p27.addChild("tail6", ModelPartBuilder.create()
                .uv(54, 101).cuboid(-1F, -1F, 0F, 2F, 2F, 6F, new Dilation(0F))
                .uv(58, 117).cuboid(-0.5F, -3F, 1F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 6F, 0.07F, 0.1F, 0F));
        ModelPartData p29 = p28.addChild("tail7", ModelPartBuilder.create()
                .uv(70, 101).cuboid(-1F, -1F, 0F, 2F, 2F, 6F, new Dilation(0.1F))
                .uv(66, 117).cuboid(-0.5F, -3F, 1F, 1F, 2F, 3F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 6F, 0.07F, 0.1F, 0F));
        ModelPartData p30 = p29.addChild("blade", ModelPartBuilder.create()
                .uv(88, 75).cuboid(-0.5F, -4F, 0F, 1F, 8F, 6F, new Dilation(0F))
                .uv(210, 101).cuboid(-0.5F, -2F, 5F, 1F, 4F, 3F, new Dilation(-0.1F)),
                ModelTransform.of(0F, 0F, 5.5F, 0F, 0F, 0F));
        ModelPartData p31 = p0.addChild("left_wing", ModelPartBuilder.create()
                .uv(128, 110).cuboid(0F, -1.5F, -1.5F, 16F, 3F, 3F, new Dilation(0F))
                .uv(56, 55).cuboid(0F, -0.4F, 1.2F, 16F, 1F, 17F, new Dilation(-0.2F)),
                ModelTransform.of(5.5F, -5F, -6F, 0.1F, -0.25F, -0.55F));
        ModelPartData p32 = p31.addChild("forearm", ModelPartBuilder.create()
                .uv(74, 117).cuboid(0F, -1.2F, -1.2F, 20F, 2F, 2F, new Dilation(0.1F))
                .uv(88, 32).cuboid(0F, -0.4F, 0.8F, 20F, 1F, 20F, new Dilation(-0.2F)),
                ModelTransform.of(16F, 0F, 0F, 0F, 0.45F, -0.2F));
        ModelPartData p33 = p32.addChild("hand", ModelPartBuilder.create()
                .uv(128, 0).cuboid(0F, -0.4F, 0.4F, 22F, 1F, 22F, new Dilation(-0.2F))
                .uv(166, 110).cuboid(-1F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0F)),
                ModelTransform.of(20F, 0F, 0F, 0F, -0.35F, 0F));
        ModelPartData p34 = p33.addChild("finger0", ModelPartBuilder.create()
                .uv(0, 122).cuboid(0F, -0.6F, -0.6F, 24F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.12F, 0F));
        ModelPartData p35 = p33.addChild("finger1", ModelPartBuilder.create()
                .uv(50, 122).cuboid(0F, -0.6F, -0.6F, 20F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -0.55F, 0F));
        ModelPartData p36 = p33.addChild("finger2", ModelPartBuilder.create()
                .uv(92, 122).cuboid(0F, -0.6F, -0.6F, 15F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, -1F, 0F));
        ModelPartData p37 = p0.addChild("right_wing", ModelPartBuilder.create()
                .uv(178, 110).cuboid(-16F, -1.5F, -1.5F, 16F, 3F, 3F, new Dilation(0F))
                .uv(122, 55).cuboid(-16F, -0.4F, 1.2F, 16F, 1F, 17F, new Dilation(-0.2F)),
                ModelTransform.of(-5.5F, -5F, -6F, 0.1F, 0.25F, 0.55F));
        ModelPartData p38 = p37.addChild("forearm", ModelPartBuilder.create()
                .uv(118, 117).cuboid(-20F, -1.2F, -1.2F, 20F, 2F, 2F, new Dilation(0.1F))
                .uv(168, 32).cuboid(-20F, -0.4F, 0.8F, 20F, 1F, 20F, new Dilation(-0.2F)),
                ModelTransform.of(-16F, 0F, 0F, 0F, -0.45F, 0.2F));
        ModelPartData p39 = p38.addChild("hand", ModelPartBuilder.create()
                .uv(0, 32).cuboid(-22F, -0.4F, 0.4F, 22F, 1F, 22F, new Dilation(-0.2F))
                .uv(216, 110).cuboid(-2F, -1.5F, -1.5F, 3F, 3F, 3F, new Dilation(0F)),
                ModelTransform.of(-20F, 0F, 0F, 0F, 0.35F, 0F));
        ModelPartData p40 = p39.addChild("finger0", ModelPartBuilder.create()
                .uv(124, 122).cuboid(-24F, -0.6F, -0.6F, 24F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.12F, 0F));
        ModelPartData p41 = p39.addChild("finger1", ModelPartBuilder.create()
                .uv(174, 122).cuboid(-20F, -0.6F, -0.6F, 20F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 0.55F, 0F));
        ModelPartData p42 = p39.addChild("finger2", ModelPartBuilder.create()
                .uv(216, 122).cuboid(-15F, -0.6F, -0.6F, 15F, 1F, 1F, new Dilation(0F)),
                ModelTransform.of(0F, 0F, 0F, 0F, 1F, 0F));
        ModelPartData p43 = p0.addChild("left_front_leg", ModelPartBuilder.create()
                .uv(78, 89).cuboid(-2F, -1.5F, -2F, 4F, 7F, 4F, new Dilation(0F)),
                ModelTransform.of(5F, 2F, -6F, 0.45F, 0F, 0F));
        ModelPartData p44 = p43.addChild("shin", ModelPartBuilder.create()
                .uv(162, 89).cuboid(-1.75F, 0F, -1.75F, 3F, 7F, 3F, new Dilation(0.15F)),
                ModelTransform.of(0F, 6F, 0F, -0.55F, 0F, 0F));
        ModelPartData p45 = p44.addChild("foot", ModelPartBuilder.create()
                .uv(218, 101).cuboid(-2.5F, 0F, -3F, 5F, 2F, 5F, new Dilation(0.05F)),
                ModelTransform.of(0F, 7F, 0F, -0.1F, 0F, 0F));
        ModelPartData p46 = p45.addChild("claw0", ModelPartBuilder.create()
                .uv(162, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(-1.6F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p47 = p45.addChild("claw1", ModelPartBuilder.create()
                .uv(168, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p48 = p45.addChild("claw2", ModelPartBuilder.create()
                .uv(174, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(1.6F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p49 = p0.addChild("right_front_leg", ModelPartBuilder.create()
                .uv(94, 89).cuboid(-2F, -1.5F, -2F, 4F, 7F, 4F, new Dilation(0F)),
                ModelTransform.of(-5F, 2F, -6F, 0.45F, 0F, 0F));
        ModelPartData p50 = p49.addChild("shin", ModelPartBuilder.create()
                .uv(174, 89).cuboid(-1.75F, 0F, -1.75F, 3F, 7F, 3F, new Dilation(0.15F)),
                ModelTransform.of(0F, 6F, 0F, -0.55F, 0F, 0F));
        ModelPartData p51 = p50.addChild("foot", ModelPartBuilder.create()
                .uv(0, 110).cuboid(-2.5F, 0F, -3F, 5F, 2F, 5F, new Dilation(0.05F)),
                ModelTransform.of(0F, 7F, 0F, -0.1F, 0F, 0F));
        ModelPartData p52 = p51.addChild("claw0", ModelPartBuilder.create()
                .uv(180, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(-1.6F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p53 = p51.addChild("claw1", ModelPartBuilder.create()
                .uv(186, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p54 = p51.addChild("claw2", ModelPartBuilder.create()
                .uv(192, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(1.6F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p55 = p0.addChild("left_hind_leg", ModelPartBuilder.create()
                .uv(154, 75).cuboid(-2.5F, -2F, -2.5F, 5F, 8F, 5F, new Dilation(0F)),
                ModelTransform.of(5F, 2F, 6F, -0.5F, 0F, 0F));
        ModelPartData p56 = p55.addChild("shin", ModelPartBuilder.create()
                .uv(186, 89).cuboid(-1.75F, 0F, -1.75F, 3F, 7F, 3F, new Dilation(0.15F)),
                ModelTransform.of(0F, 6F, 0F, 0.75F, 0F, 0F));
        ModelPartData p57 = p56.addChild("foot", ModelPartBuilder.create()
                .uv(20, 110).cuboid(-2.5F, 0F, -3F, 5F, 2F, 5F, new Dilation(0.05F)),
                ModelTransform.of(0F, 7F, 0F, 0.35F, 0F, 0F));
        ModelPartData p58 = p57.addChild("claw0", ModelPartBuilder.create()
                .uv(198, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(-1.6F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p59 = p57.addChild("claw1", ModelPartBuilder.create()
                .uv(204, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p60 = p57.addChild("claw2", ModelPartBuilder.create()
                .uv(210, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(1.6F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p61 = p0.addChild("right_hind_leg", ModelPartBuilder.create()
                .uv(174, 75).cuboid(-2.5F, -2F, -2.5F, 5F, 8F, 5F, new Dilation(0F)),
                ModelTransform.of(-5F, 2F, 6F, -0.5F, 0F, 0F));
        ModelPartData p62 = p61.addChild("shin", ModelPartBuilder.create()
                .uv(198, 89).cuboid(-1.75F, 0F, -1.75F, 3F, 7F, 3F, new Dilation(0.15F)),
                ModelTransform.of(0F, 6F, 0F, 0.75F, 0F, 0F));
        ModelPartData p63 = p62.addChild("foot", ModelPartBuilder.create()
                .uv(40, 110).cuboid(-2.5F, 0F, -3F, 5F, 2F, 5F, new Dilation(0.05F)),
                ModelTransform.of(0F, 7F, 0F, 0.35F, 0F, 0F));
        ModelPartData p64 = p63.addChild("claw0", ModelPartBuilder.create()
                .uv(216, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(-1.6F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p65 = p63.addChild("claw1", ModelPartBuilder.create()
                .uv(222, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(0F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        ModelPartData p66 = p63.addChild("claw2", ModelPartBuilder.create()
                .uv(228, 117).cuboid(-0.5F, -0.5F, -2F, 1F, 1F, 2F, new Dilation(0F)),
                ModelTransform.of(1.6F, 1.5F, -2.6F, 0.6F, 0F, 0F));
        return TexturedModelData.of(modelData, 256, 128);
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
        float yaw = headYaw * ((float) Math.PI / 180F) / 5.0F;
        float pitch = headPitch * ((float) Math.PI / 180F) / 5.0F;
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
