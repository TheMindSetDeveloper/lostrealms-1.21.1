package net.vanala.lostrealms.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootTable;
import net.vanala.lostrealms.entity.ModEntities;

public class ModEntitiesLootTables extends EntityLootSubProvider {

    public ModEntitiesLootTables(HolderLookup.Provider provider) {
        this(FeatureFlags.REGISTRY.allFlags(), provider);
    }

    protected ModEntitiesLootTables(FeatureFlagSet flagSet, HolderLookup.Provider provider) {
        super(flagSet, provider);
    }

    @Override
    public void generate() {
        this.add(ModEntities.LEOPARD.get(), LootTable.lootTable());
        this.add(ModEntities.KOMODO_DRAGON.get(), LootTable.lootTable());
    }
}
