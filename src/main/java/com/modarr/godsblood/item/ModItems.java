package com.modarr.godsblood.item;

import com.modarr.godsblood.GodsBlood;
import com.modarr.godsblood.item.custom.ChiselItem;
import com.modarr.godsblood.item.custom.FuelItem;
import com.modarr.godsblood.item.custom.ModFoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GodsBlood.MODID);

    public static final DeferredItem<Item> ITEMGODSBLOOD = ITEMS.register("godsblood",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA)));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties()));

    public static final DeferredItem<Item> BLOOD_COAL = ITEMS.register("blood_coal",
            () -> new FuelItem(new Item.Properties(), 800));

    public static void register(IEventBus eventBus)  {
        ITEMS.register(eventBus);

    }
}
