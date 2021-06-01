package com.jellytumtum.mangetoutmod;

import com.jellytumtum.mangetoutmod.registry.ModBlocks;
import com.jellytumtum.mangetoutmod.registry.ModItems;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
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
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

/* IMPORTANT DETAILS :

- TO ADD AN ITEM you need to add to ModItems and ModItems.registerItems + in lang folder add entry + add texture.
- TO ADD BLOCK you need to add to ModBlocks + ModItems + ModItems.registerItems + ModBlocks.registerBlocks + in lang folder add entry and texture.

TO DO LIST: 

- Villager functionality to make it obtainable. (available in villager trade and maybe some sort of random chest)
- Infused Mangetout Block -- Sea Lanterns / glowstone surrounded by mangetout -> luminous
- Change Condensed Mangetout block so it has top and side texture, see hay_block.json in the models section of minecrafts code to see how. (req the top texture to be made. )
- Mangetouter - drops mangetout  / rarely a mangetoutium bar. (creeper model)
- Look into generated structures. Mangetout Temple??  
- ADD ALL ITEMS TO MANGETOUT MANIA CREATIVE TAB

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
            stacks.add(new ItemStack(ModItems.MANGETOUT_STALK));
            stacks.add(new ItemStack(ModItems.CRISP_MANGETOUT));
            stacks.add(new ItemStack(ModItems.CONDENSED_MANGETOUT));
            stacks.add(new ItemStack(ModItems.MANGETOUTIUM_SWORD));
            stacks.add(new ItemStack(ModItems.MANGETOUTIUM_PICKAXE));
            stacks.add(new ItemStack(ModItems.MANGETOUTIUM_SHOVEL));
            stacks.add(new ItemStack(ModItems.MANGETOUTIUM_AXE));
            stacks.add(new ItemStack(ModItems.MANGETOUTIUM_HOE));
            stacks.add(new ItemStack(ModItems.MANGETOUTIUM_INGOT));
            stacks.add(new ItemStack(ModItems.MANGETOUTIUM_ORE));
            stacks.add(new ItemStack(ModItems.MANGETOUTIUM_BLOCK));
            stacks.add(new ItemStack(ModItems.RAW_MANGETOUTIUM));
            
        })
        .build();

    
        // injecting additional entries into loot tables. 
        private static final Identifier ZOMBIE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/zombie");

        private static ConfiguredFeature<?, ?> MANGETOUTIUM_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.MANGETOUTIUM_ORE.getDefaultState(), 4)) // last int value = max number in 1 vein.
        .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, 0, 25))).spreadHorizontally().repeat(2);
        // RangeDecoratorConfig(0, minYValue, maxYValue)
        // .repeat(veinsPerChunk)


    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        
        modifyLootTables();

        // ORE GENERATION
        RegistryKey<ConfiguredFeature<?,?>> mangetoutiumOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("mangetoutmod","mangetoutium_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, mangetoutiumOreOverworld.getValue(), MANGETOUTIUM_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, mangetoutiumOreOverworld); // line through cause its scary and people dont you messing innit.

        //FuelRegistry.INSTANCE.add(item, tickTime) --> for adding fuel sources. 

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
