package com.modarr.godsblood.datagen;

import com.modarr.godsblood.GodsBlood;
import com.modarr.godsblood.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GodsBlood.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    basicItem(ModItems.ITEMGODSBLOOD.get());
    basicItem(ModItems.BANANA.get());
    basicItem(ModItems.BLOOD_COAL.get());
    basicItem(ModItems.CHISEL.get());
    }
}
