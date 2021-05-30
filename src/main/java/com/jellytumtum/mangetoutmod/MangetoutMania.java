package com.jellytumtum.mangetoutmod;

import com.jellytumtum.mangetoutmod.registry.ModBlocks;
import com.jellytumtum.mangetoutmod.registry.ModItems;

import jdk.nashorn.api.tree.IdentifierTree;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.UniformLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.util.Identifier;

/* IMPORTANT DETAILS :

- TO ADD AN ITEM you need to add to ModItems and ModItems.registerItems + in lang folder add entry + add texture.
- TO ADD BLOCK you need to add to ModBlocks + ModItems + ModItems.registerItems + ModBlocks.registerBlocks + in lang folder add entry and texture.

TO DO LIST: 

- Farmable Mangetout
- Food Functionality to Mangetout. 
- Mangetout weapons
- Mangetoutium Ore.
- Magic Mangetout
- Mangetouter - drops mangetout (creeper model)

*/

public class MangetoutMania implements ModInitializer {

    public static final String MOD_ID = "mangetoutmod";

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

    
        // injecting additional entries into loot tables. 
        private static final Identifier ZOMBIE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/zombie");

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        
        modifyLootTables();
        
    }

    private void modifyLootTables() {
        LootTableLoadingCallback.EVENT.register(((rescourceManager, lootManager, id, supplier, setter) -> {
            // checks for the specific loot table
            if (ZOMBIE_LOOT_TABLE_ID.equals(id)) {

                // Add individual drop
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .with(ItemEntry.builder(ModItems.MANGETOUT)) // Add individual drop
                        .withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(0f, 1.0f)).build());
                supplier.withPool(poolBuilder.build());

            // Extra Loot Tables go inside another if statement innit.
            }
        }));
    }
    
}
