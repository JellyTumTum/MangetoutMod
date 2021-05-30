package com.jellytumtum.test.registry;

import com.jellytumtum.test.Test;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Items
    public static final Item MANGETOUT = new Item(new Item.Settings().group(ItemGroup.FOOD));

    // Block Items
    public static final BlockItem CONDENSED_MANGETOUT = new BlockItem(ModBlocks.CONDENSED_MANGETOUT, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "mangetout"), MANGETOUT);
        Registry.register(Registry.ITEM, new Identifier(Test.MOD_ID, "condensed_mangetout"), CONDENSED_MANGETOUT);
    }
}
