package com.modarr.godsblood.datagen;

import com.modarr.godsblood.block.ModBlocks;
import com.modarr.godsblood.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOOD_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.ITEMGODSBLOOD.get())
                .unlockedBy("has_godsblood", has(ModItems.ITEMGODSBLOOD)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ITEMGODSBLOOD.get(), 9)
                .requires(ModBlocks.BLOOD_BLOCK)
                .unlockedBy("has_blood_block", has(ModBlocks.BLOOD_BLOCK)).save(recipeOutput);

    }
}
