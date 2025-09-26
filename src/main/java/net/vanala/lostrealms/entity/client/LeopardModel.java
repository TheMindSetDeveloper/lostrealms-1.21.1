package net.vanala.lostrealms.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.vanala.lostrealms.LostRealms;
import net.vanala.lostrealms.entity.custom.LeopardEntity;

public class LeopardModel<T extends LeopardEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, "leopard"), "main");
    private final ModelPart Body;
    private final ModelPart Head;

    public LeopardModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.Head = this.Body.getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -3.0F, -10.0F, 7.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(-3.5F, 5.0F, -10.0F, 7.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -1.0F));

        PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.5F, -1.5F, 9.2F));

        PartDefinition Tail_r1 = Tail.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -1.0F, -11.0F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 7.8F, -0.7854F, 0.0F, 0.0F));

        PartDefinition Tail1 = Tail.addOrReplaceChild("Tail1", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 7.0F));

        PartDefinition Tail1_r1 = Tail1.addOrReplaceChild("Tail1_r1", CubeListBuilder.create().texOffs(26, 49).addBox(-1.99F, -0.97F, -11.11F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.005F, 0.339F, 9.445F, -0.1745F, 0.0F, 0.0F));

        PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 8.0F));

        PartDefinition Tail2_r1 = Tail2.addOrReplaceChild("Tail2_r1", CubeListBuilder.create().texOffs(50, 49).addBox(-2.0304F, -1.0912F, -10.6656F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0152F, -5.5595F, 6.9758F, 0.48F, 0.0F, 0.0F));

        PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create(), PartPose.offset(0.5F, -1.0F, -9.0F));

        PartDefinition cube_r1 = Neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(54, 37).addBox(-0.5F, 2.0F, 4.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(54, 11).addBox(-3.0F, -4.0F, 4.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(54, 0).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(54, 44).addBox(-2.0F, 0.0F, -7.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -11.0F));

        PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(64, 37).addBox(-3.0F, 2.0F, 7.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, -7.0F, -10.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(40, 62).addBox(2.0F, 2.0F, 7.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, -7.0F, -10.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(14, 63).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -5.0F));

        PartDefinition LeftFrontLeg = Body.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(26, 62).addBox(-0.7F, -2.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 4.0F, -6.0F));

        PartDefinition RightFrontLeg = Body.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(0, 63).addBox(-2.3F, -2.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 4.0F, -6.0F));

        PartDefinition LeftBackLeg = Body.addOrReplaceChild("LeftBackLeg", CubeListBuilder.create().texOffs(54, 22).addBox(-0.5F, -1.0F, -2.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, 6.0F));

        PartDefinition RightBackLeg = Body.addOrReplaceChild("RightBackLeg", CubeListBuilder.create().texOffs(50, 61).addBox(-2.5F, -1.0F, -2.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, 6.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(LeopardEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(LeopardAnimations.LEOPARD_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, LeopardAnimations.LEOPARD_IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.Head.yRot = headYaw * ((float)Math.PI / 180f);
        this.Head.xRot = headPitch * ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return Body;
    }
}
