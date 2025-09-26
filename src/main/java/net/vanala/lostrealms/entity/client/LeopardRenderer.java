package net.vanala.lostrealms.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vanala.lostrealms.LostRealms;
import net.vanala.lostrealms.entity.custom.LeopardEntity;

public class LeopardRenderer extends MobRenderer<LeopardEntity, LeopardModel<LeopardEntity>> {
    public LeopardRenderer(EntityRendererProvider.Context context) {
        super(context, new LeopardModel<>(context.bakeLayer(LeopardModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(LeopardEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, "textures/entity/leopard/leopard.png");
    }

    @Override
    public void render(LeopardEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
