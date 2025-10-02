package net.vanala.lostrealms.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.vanala.lostrealms.LostRealms;
import net.vanala.lostrealms.entity.custom.KomodoDragonEntity;

public class KomodoDragonRenderer extends MobRenderer<KomodoDragonEntity, KomodoDragonModel<KomodoDragonEntity>> {
    public KomodoDragonRenderer(EntityRendererProvider.Context context) {
        super(context, new KomodoDragonModel<>(context.bakeLayer(KomodoDragonModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(KomodoDragonEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, "textures/entity/komodo_dragon/komodo_dragon.png");
    }

    @Override
    public void render(KomodoDragonEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isBaby()) {
            poseStack.scale(0.45f,0.45f,0.45f);
        } else {
            poseStack.scale(1f,1f,1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
