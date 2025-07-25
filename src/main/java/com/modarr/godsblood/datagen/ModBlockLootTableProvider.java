package com.modarr.godsblood.datagen;

import com.modarr.godsblood.block.ModBlocks;
import com.modarr.godsblood.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLOOD_BLOCK.get());
        dropSelf(ModBlocks.BLOOD_COAL_BLOCK.get());
        dropSelf(ModBlocks.SARONITE_BLOCK.get());
        dropSelf(ModBlocks.SARONITE_STAIRS.get());
        add(ModBlocks.MAGIC_BLOCK.get(),
                block -> createOreDrop(ModBlocks.MAGIC_BLOCK.get(), ModItems.ITEMGODSBLOOD.get()));
        add(ModBlocks.SARONITE_ORE.get(),
                block -> createOreDrop(ModBlocks.SARONITE_ORE.get(), ModItems.ITEMGODSBLOOD.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
