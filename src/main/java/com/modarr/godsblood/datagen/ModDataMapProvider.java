package com.modarr.godsblood.datagen;

import com.modarr.godsblood.block.ModBlocks;
import com.modarr.godsblood.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.BLOOD_COAL.getId(), new FurnaceFuel(1200), false)
                .add(ModBlocks.BLOOD_COAL_BLOCK.getId(), new FurnaceFuel(10800), false);
    }
}
