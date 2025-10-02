package net.vanala.lostrealms.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vanala.lostrealms.LostRealms;
import net.vanala.lostrealms.entity.ModEntities;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(LostRealms.MOD_ID);

    public static final DeferredItem<Item> FOSSIL_SHARD = ITEMS.register("fossil_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FOSSIL_DUST = ITEMS.register("fossil_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FOSSIL_FUEL = ITEMS.register("fossil_fuel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ANCIENT_TOTEM = ITEMS.register("ancient_totem",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LEOPARD_SPAWN_EGG = ITEMS.register("leopard_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.LEOPARD, 0x5f5f5f, 0x5a5a5a,
                    new Item.Properties()));
    public static final DeferredItem<Item> KOMODO_DRAGON_SPAWN_EGG = ITEMS.register("komodo_dragon_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.KOMODO_DRAGON, 0x3a453a, 0x324a32,
                    new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
