package com.modarr.godsblood.item;

import com.modarr.godsblood.GodsBlood;
import com.modarr.godsblood.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GodsBlood.MODID);

    public static final Supplier<CreativeModeTab> GODS_BLOOD_TAB = CREATIVE_MODE_TAB.register("gods_blood_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ITEMGODSBLOOD.get()))
                    .title(Component.translatable("creativetab.godsblood.gods_blood"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModItems.ITEMGODSBLOOD);
                      output.accept(ModItems.CHISEL);
                      output.accept(ModItems.BLOOD_COAL);

                      output.accept(ModBlocks.BLOOD_BLOCK);
                      output.accept(ModBlocks.MAGIC_BLOCK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
