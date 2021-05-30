package com.jellytumtum.mangetoutmod.registry;

import com.jellytumtum.mangetoutmod.MangetoutMania;

import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Items
    public static final Item MANGETOUT = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder()
        .hunger(4)
        .saturationModifier(2f)
        .snack()
        .build()));  // DOES NOT NEED TO BE INDENTED JUST CLEAR THAT ITS PART OF FOOD COMPONENT BUILDER
    public static final Item CRISP_MANGETOUT = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder()
        .hunger(2)
        .snack()
        .build())); 


    // Block Items
    public static final BlockItem CONDENSED_MANGETOUT = new BlockItem(ModBlocks.CONDENSED_MANGETOUT, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetout"), MANGETOUT);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "condensed_mangetout"), CONDENSED_MANGETOUT);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "crisp_mangetout"), CRISP_MANGETOUT);
    }
}
