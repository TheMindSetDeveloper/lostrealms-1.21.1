package net.vanala.lostrealms.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vanala.lostrealms.LostRealms;
import net.vanala.lostrealms.entity.custom.LeopardEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, LostRealms.MOD_ID);

    public static final Supplier<EntityType<LeopardEntity>> LEOPARD =
            ENTITY_TYPES.register("leopard", () -> EntityType.Builder.of(LeopardEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1f).build("leopard"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
