package net.vanala.lostrealms.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.vanala.lostrealms.LostRealms;
import net.vanala.lostrealms.block.custom.ModBlocks;
import net.vanala.lostrealms.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> FOSSIL_SMELTABLES = List.of(ModItems.FOSSIL_SHARD, ModBlocks.FOSSIL_BLOCK);
        List<ItemLike> FUEL_SMELTABLE = List.of(ModItems.FOSSIL_DUST);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FOSSIL_BLOCK.get())
                .pattern("SSS")
                .pattern("SFS")
                .pattern("SSS")
                .define('S', Items.STONE.asItem())
                .define('F', ModItems.FOSSIL_SHARD.get())
                .unlockedBy("has_fossil_shard", has(ModItems.FOSSIL_SHARD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.STEEL_INGOT.get())
                .unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK)
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, FOSSIL_SMELTABLES, RecipeCategory.MISC, ModItems.FOSSIL_DUST, 0.25f, 200, "fossil");
        oreSmelting(recipeOutput, FUEL_SMELTABLE, RecipeCategory.MISC, ModItems.FOSSIL_FUEL, 0.5f, 2000, "fossil");

        oreBlasting(recipeOutput, FOSSIL_SMELTABLES, RecipeCategory.MISC, ModItems.FOSSIL_DUST, 0.25f, 100, "fossil");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, LostRealms.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
