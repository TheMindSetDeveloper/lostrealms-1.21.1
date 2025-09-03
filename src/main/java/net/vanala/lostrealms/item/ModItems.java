package net.vanala.lostrealms.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vanala.lostrealms.LostRealms;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(LostRealms.MOD_ID);

    public static final DeferredItem<Item> FOSSIL_SHARD = ITEMS.register("fossil_shard",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ANCIENT_TOTEM = ITEMS.register("ancient_totem",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
