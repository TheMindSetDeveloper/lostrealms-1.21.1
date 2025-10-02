package net.vanala.lostrealms.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.vanala.lostrealms.LostRealms;

import static net.vanala.lostrealms.util.ModTags.Blocks.createTag;
public class ModTags {

    public static final TagKey<Block> LEOPARD_SPAWNABLE_ON = createTag("leopard_spawnable_on");

    public static class Blocks {

        static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(LostRealms.MOD_ID, name));
        }
    }
}
