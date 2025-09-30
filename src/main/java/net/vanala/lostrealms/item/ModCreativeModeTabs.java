package net.vanala.lostrealms.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.vanala.lostrealms.LostRealms;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vanala.lostrealms.block.custom.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LostRealms.MOD_ID);

    public static final Supplier<CreativeModeTab> PREHISTORIC_ITEMS_TAB = CREATIVE_MODE_TAB.register("prehistoric_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.FOSSIL_SHARD.get()))
            .title(Component.translatable("creativetab.lostrealms.prehistoric_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.FOSSIL_SHARD);
                output.accept(ModItems.FOSSIL_DUST);
                output.accept(ModItems.FOSSIL_FUEL);
                output.accept(ModItems.ANCIENT_TOTEM);
            }).build());

    public static final Supplier<CreativeModeTab> PREHISTORIC_MOBS_TAB = CREATIVE_MODE_TAB.register("prehistoric_mobs_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, "prehistoric_items_tab"))
                    .icon(() -> new ItemStack(ModItems.LEOPARD_SPAWN_EGG.get()))
                    .title(Component.translatable("creativetab.lostrealms.prehistoric_mobs"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LEOPARD_SPAWN_EGG);
                    }).build());

    public static final Supplier<CreativeModeTab> PREHISTORIC_BLOCKS_TAB = CREATIVE_MODE_TAB.register("prehistoric_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, "prehistoric_mobs_tab"))
                    .icon(() -> new ItemStack(ModBlocks.FOSSIL_BLOCK.get()))
            .title(Component.translatable("creativetab.lostrealms.prehistoric_blocks"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModBlocks.FOSSIL_BLOCK);
            }).build());

    public static final Supplier<CreativeModeTab> POST_HISTORIC_ITEMS_TAB = CREATIVE_MODE_TAB.register("post_historic_items_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, "prehistoric_blocks_tab"))
                    .icon(() -> new ItemStack(ModItems.STEEL_INGOT.get()))
            .title(Component.translatable("creativetab.lostrealms.post_historic_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.STEEL_INGOT);
            }).build());

    public static final Supplier<CreativeModeTab> POST_HISTORIC_BLOCKS_TAB = CREATIVE_MODE_TAB.register("post_historic_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, "post_historic_items_tab"))
                    .icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK.get()))
            .title(Component.translatable("creativetab.lostrealms.post_historic_blocks"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModBlocks.STEEL_BLOCK);
            }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
