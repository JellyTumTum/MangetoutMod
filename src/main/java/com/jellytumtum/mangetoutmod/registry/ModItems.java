package com.jellytumtum.mangetoutmod.registry;

import com.jellytumtum.mangetoutmod.MangetoutMania;
// import com.jellytumtum.mangetoutmod.registry.CustomArmorMaterial;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
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
        .build()));  // DOES NOT NEED TO BE INDENTED JUST CLEAR THAT ITS PART OF FOOD COMPONENT BUILDER
    public static final Item CRISP_MANGETOUT = new Item(new Item.Settings().group(ItemGroup.FOOD).food(new FoodComponent.Builder()
        .hunger(3)
        .saturationModifier(1f)
        .snack()
        .build()));
        
    public static final Item MANGETOUTIUM_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item RAW_MANGETOUTIUM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item MANGETOUTIUM_SWORD = new SwordInstance(new ToolMaterialMangetoutium());
    public static final Item MANGETOUTIUM_PICKAXE = new PickaxeInstance(new ToolMaterialMangetoutium());
    public static final Item MANGETOUTIUM_SHOVEL = new ShovelInstance(new ToolMaterialMangetoutium());
    public static final Item MANGETOUTIUM_AXE = new AxeInstance(new ToolMaterialMangetoutium());
    public static final Item MANGETOUTIUM_HOE = new HoeInstance(new ToolMaterialMangetoutium());

    public static final ArmorMaterial MANGETOUT_ARMOUR_MATERIAL = new CustomArmorMaterial();
    // If you made a new material, this is where you would note it.
    public static final Item MANGETOUTIUM_HELMET = new ArmorItem(MANGETOUT_ARMOUR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item MANGETOUTIUM_CHESTPLATE = new ArmorItem(MANGETOUT_ARMOUR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item MANGETOUTIUM_LEGGINGS = new ArmorItem(MANGETOUT_ARMOUR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item MANGETOUTIUM_BOOTS = new ArmorItem(MANGETOUT_ARMOUR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));


    // Block Items
    public static final BlockItem CONDENSED_MANGETOUT = new BlockItem(ModBlocks.CONDENSED_MANGETOUT, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem MANGETOUTIUM_ORE = new BlockItem(ModBlocks.MANGETOUTIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem MANGETOUTIUM_BLOCK = new BlockItem(ModBlocks.MANGETOUTIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem MANGETOUT_STALK = new BlockItem(ModBlocks.MANGETOUT_STALK, new Item.Settings().group(ItemGroup.FOOD));



    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetout"), MANGETOUT);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "condensed_mangetout"), CONDENSED_MANGETOUT);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "crisp_mangetout"), CRISP_MANGETOUT);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "raw_mangetoutium"), RAW_MANGETOUTIUM);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_ingot"), MANGETOUTIUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_ore"), MANGETOUTIUM_ORE);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_block"), MANGETOUTIUM_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_sword"), MANGETOUTIUM_SWORD);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_pickaxe"), MANGETOUTIUM_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_shovel"), MANGETOUTIUM_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_axe"), MANGETOUTIUM_AXE);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_hoe"), MANGETOUTIUM_HOE);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetout_stalk"), MANGETOUT_STALK);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_helmet"), MANGETOUTIUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_chestplate"), MANGETOUTIUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_leggings"), MANGETOUTIUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_boots"), MANGETOUTIUM_BOOTS);
        


    }
}
