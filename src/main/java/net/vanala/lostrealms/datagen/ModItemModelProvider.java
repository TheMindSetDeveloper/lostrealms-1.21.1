package net.vanala.lostrealms.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.vanala.lostrealms.LostRealms;
import net.vanala.lostrealms.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LostRealms.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.FOSSIL_SHARD.get());
        basicItem(ModItems.FOSSIL_DUST.get());
        basicItem(ModItems.FOSSIL_FUEL.get());
        basicItem(ModItems.ANCIENT_TOTEM.get());

        basicItem(ModItems.STEEL_INGOT.get());

        withExistingParent(ModItems.LEOPARD_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
