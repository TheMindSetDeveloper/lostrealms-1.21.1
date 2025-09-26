package net.vanala.lostrealms.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.vanala.lostrealms.LostRealms;
import net.vanala.lostrealms.entity.ModEntities;
import net.vanala.lostrealms.entity.client.LeopardModel;
import net.vanala.lostrealms.entity.custom.LeopardEntity;

@EventBusSubscriber(modid = LostRealms.MOD_ID, bus = EventBusSubscriber.Bus.MOD)

public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LeopardModel.LAYER_LOCATION, LeopardModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.LEOPARD.get(), LeopardEntity.createAttributes().build());
    }
}
