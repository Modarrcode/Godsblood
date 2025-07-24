package com.modarr.godsblood.block;

import com.modarr.godsblood.block.custom.MagicBlock;
import net.minecraft.world.level.block.Block;
import com.modarr.godsblood.GodsBlood;
import com.modarr.godsblood.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(GodsBlood.MODID);

    public static final DeferredBlock<Block> BLOOD_BLOCK = registerBlock("blood_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.8f,2f).sound(SoundType.FROGLIGHT)));

    public static final DeferredBlock<Block> BLOOD_COAL_BLOCK = registerBlock("blood_coal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.8f,2f).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(2f)));
    public static final DeferredBlock<Block> SARONITE_ORE = registerBlock("saronite_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.8f, 2f).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> SARONITE_BLOCK = registerBlock("saronite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.8f,2f).sound(SoundType.METAL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static  <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
