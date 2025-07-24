package com.modarr.godsblood.datagen;

import com.modarr.godsblood.GodsBlood;
import com.modarr.godsblood.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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

    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
