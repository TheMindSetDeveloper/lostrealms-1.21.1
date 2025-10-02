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
import net.vanala.lostrealms.entity.custom.KomodoDragonEntity;

public class KomodoDragonModel<T extends KomodoDragonEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, "komodo_dragon"), "main");
    private final ModelPart Body;
    private final ModelPart Neck;
    private final ModelPart Head;

    public KomodoDragonModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.Neck = this.Body.getChild("Neck");
        this.Head = this.Neck.getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -4.0F, -11.0F, 9.0F, 7.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -1.0F));

        PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -3.0F, -6.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.0F, -10.0F));

        PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 49).addBox(-2.0F, 1.0F, -4.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 47).addBox(-2.0F, -3.0F, -10.0F, 5.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

        PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 61).addBox(-2.0F, 0.0F, -7.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -3.0F));

        PartDefinition bone = Jaw.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(20, 55).addBox(0.0F, 0.0F, -3.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(64, 25).addBox(-1.0F, 0.0F, -5.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.075F, -2.0F));

        PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(-0.5F, -1.5F, 11.0F));

        PartDefinition cube_r1 = Tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 30).addBox(-3.0F, -3.0F, -12.0F, 6.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 2.2F, 12.0F, -0.1309F, 0.0F, 0.0F));

        PartDefinition bone4 = Tail.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 13.0F));

        PartDefinition cube_r2 = bone4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 30).addBox(-1.0F, -3.0F, -12.0F, 3.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 11.0F, -0.0436F, 0.0F, 0.0F));

        PartDefinition FrontLegs = Body.addOrReplaceChild("FrontLegs", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 1.0F));

        PartDefinition FrontLeftLeg = FrontLegs.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(64, 12).addBox(0.5F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(22, 61).addBox(-0.5F, 8.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -8.0F, -8.0F));

        PartDefinition FrontRightLeg = FrontLegs.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(54, 67).addBox(-4.5F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(64, 6).addBox(-5.5F, 8.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -8.0F, -8.0F));

        PartDefinition BackLegs = Body.addOrReplaceChild("BackLegs", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 1.0F));

        PartDefinition BackLeftLeg = BackLegs.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(22, 67).addBox(0.5F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(46, 61).addBox(-0.5F, 8.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -8.0F, 6.0F));

        PartDefinition BackRightLeg = BackLegs.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(38, 67).addBox(-4.5F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(64, 0).addBox(-5.5F, 8.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -8.0F, 6.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(KomodoDragonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(KomodoDragonAnimations.KOMODO_DRAGON_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, KomodoDragonAnimations.KOMODO_DRAGON_IDLE, ageInTicks, 1f);
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
