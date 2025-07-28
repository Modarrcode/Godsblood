package com.modarr.godsblood.datagen;

import com.modarr.godsblood.GodsBlood;
import com.modarr.godsblood.block.ModBlocks;
import com.modarr.godsblood.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.minecraft.resources.ResourceLocation;


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
                .unlockedBy("has_godsblood", has(ModItems.ITEMGODSBLOOD.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UNREFINED_SARONITE_INGOT.get())
                .pattern(" B ")
                .pattern("BIB")
                .pattern(" B ")
                .define('B', ModItems.ITEMGODSBLOOD.get())
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_godsblood", has(ModItems.ITEMGODSBLOOD.get()))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOOD_COAL_BLOCK.get())
                .pattern("OOO")
                .pattern("OOO")
                .pattern("OOO")
                .define('O', ModItems.BLOOD_COAL.get())
                .unlockedBy("has_godsblood", has(ModItems.ITEMGODSBLOOD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SARONITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SARONITE_INGOT.get())
                .unlockedBy("has_saronite_ingot", has(ModItems.SARONITE_INGOT)).save(recipeOutput);

        stairBuilder(ModBlocks.SARONITE_STAIRS.get(), Ingredient.of(ModItems.SARONITE_INGOT)).group("saronite")
                        .unlockedBy("has_saronite_ingot", has(ModItems.SARONITE_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLOOD_COAL.get())
                .pattern(" B ")
                .pattern("BCB")
                .pattern(" B ")
                .define('C', Items.COAL)
                .define('B', ModItems.ITEMGODSBLOOD.get())
                        .unlockedBy("has_godsblood", has(ModItems.ITEMGODSBLOOD)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ITEMGODSBLOOD.get(), 9)
                .requires(ModBlocks.BLOOD_BLOCK)
                .unlockedBy("has_blood_block", has(ModBlocks.BLOOD_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SARONITE_INGOT.get(), 9)
                .requires(ModBlocks.SARONITE_BLOCK)
                .unlockedBy("has_saronite_block", has(ModBlocks.SARONITE_BLOCK))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(GodsBlood.MODID, "saronite_ingot_from_block"));

        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(ModItems.UNREFINED_SARONITE_INGOT.get()),
                RecipeCategory.MISC,
                ModItems.SARONITE_INGOT.get(),
                0.35f,
                200
        ).unlockedBy("has_godsblood", has(ModItems.ITEMGODSBLOOD.get())).save(recipeOutput, ResourceLocation.fromNamespaceAndPath(GodsBlood.MODID, "saronite_refining"));

    }
}
