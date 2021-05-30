package com.jellytumtum.test;

import com.jellytumtum.test.registry.ModBlocks;
import com.jellytumtum.test.registry.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Test implements ModInitializer {

    public static final String MOD_ID = "testing";

    // public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
    //     new Identifier(MOD_ID, "general"),
    //     () -> new ItemStack(ModItems.MANGETOUT));    // OLD LAME CREATIVE TAB

    // NEW FRESH CREATIVE TAB
    public static final ItemGroup COMPLEX_GROUP = FabricItemGroupBuilder.create(
        new Identifier(MOD_ID, "complexgroup"))
        .icon(() -> new ItemStack(ModItems.MANGETOUT))
        .appendItems(stacks -> {
            stacks.add(new ItemStack(ModItems.MANGETOUT));
            stacks.add(new ItemStack(ModItems.CONDENSED_MANGETOUT));
        })
        .build();

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        
    }
    
}
