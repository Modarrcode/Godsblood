package com.modarr.godsblood.datagen;

import com.modarr.godsblood.GodsBlood;
import com.modarr.godsblood.block.ModBlocks;
import com.modarr.godsblood.block.custom.SaroniteLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GodsBlood.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SARONITE_ORE);
        blockWithItem(ModBlocks.BLOOD_BLOCK);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.BLOOD_COAL_BLOCK);
        blockWithItem(ModBlocks.SARONITE_BLOCK);
        stairsBlock(ModBlocks.SARONITE_STAIRS.get(), blockTexture(ModBlocks.SARONITE_BLOCK.get()));
        simpleBlockItem(ModBlocks.SARONITE_STAIRS.get(), new ModelFile.UncheckedModelFile("godsblood:block/" + ModBlocks.SARONITE_STAIRS.getId().getPath()));

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.SARONITE_LAMP_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(SaroniteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("saronite_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(GodsBlood.MODID, "block/" + "saronite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("saronite_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(GodsBlood.MODID, "block/" + "saronite_lamp_off")))};
            }
        });

        simpleBlockItem(ModBlocks.SARONITE_LAMP_BLOCK.get(), models().cubeAll("saronite_lamp_on",
                ResourceLocation.fromNamespaceAndPath(GodsBlood.MODID, "block/" + "saronite_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("godsblood:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("godsblood:block/" + deferredBlock.getId().getPath() + appendix));
    }

}
