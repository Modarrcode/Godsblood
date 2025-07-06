package com.modarr.godsblood.item;

import com.modarr.godsblood.GodsBlood;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GodsBlood.MODID);

    public static final DeferredItem<Item> ITEMGODSBLOOD = ITEMS.register("godsblood",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)  {
        ITEMS.register(eventBus);

    }
}
