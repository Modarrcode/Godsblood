package com.modarr.godsblood.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Map;

public class ChiselItem extends Item {

    private static final Map<Block, Block> CHISEL_MAP = Map.of(
            Blocks.STONE, Blocks.IRON_BLOCK
    );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide) return InteractionResult.SUCCESS; // Skip logic on client

        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Block clickedBlock = state.getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            Block newBlock = CHISEL_MAP.get(clickedBlock);
            level.setBlock(pos, newBlock.defaultBlockState(), 3); // 3 = notify neighbors & update client
            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }
}
