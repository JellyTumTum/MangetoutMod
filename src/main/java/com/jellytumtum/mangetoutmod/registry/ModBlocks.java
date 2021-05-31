package com.jellytumtum.mangetoutmod.registry;

import com.jellytumtum.mangetoutmod.MangetoutMania;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    

    // Hardness: Stone (1.5f), Obsidian (50.0f), etc...
    // Mining Levels: Wood (0), Stone (1), Iron (2), Diamond (3), Netherite (4)
    public static final Block CONDENSED_MANGETOUT = new Block(FabricBlockSettings
    .of(Material.ORGANIC_PRODUCT, MaterialColor.GRASS)
    .breakByTool(FabricToolTags.HOES, 1)
    .breakByHand(true)
    .strength(1.5f, 2f)
    .sounds(BlockSoundGroup.WART_BLOCK));

    public static final Block MANGETOUTIUM_ORE = new MangetoutiumOreBlock(FabricBlockSettings
    .of(Material.STONE, MaterialColor.STONE)
    .breakByTool(FabricToolTags.PICKAXES, 2)
    .breakByHand(false)
    .strength(5f, 15f)
    .sounds(BlockSoundGroup.STONE));

    public static final Block MANGETOUTIUM_BLOCK = new Block(FabricBlockSettings
    .of(Material.METAL, MaterialColor.GREEN)
    .breakByTool(FabricToolTags.PICKAXES, 2)
    .breakByHand(false)
    .strength(5f, 15f)
    .sounds(BlockSoundGroup.METAL));

    public static final Block MANGETOUT_STALK = new MangetoutStalk(FabricBlockSettings.copy(Blocks.SUGAR_CANE));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(MangetoutMania.MOD_ID, "condensed_mangetout"), CONDENSED_MANGETOUT);
        Registry.register(Registry.BLOCK, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_ore"), MANGETOUTIUM_ORE);
        Registry.register(Registry.BLOCK, new Identifier(MangetoutMania.MOD_ID, "mangetoutium_block"), MANGETOUTIUM_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MangetoutMania.MOD_ID, "mangetout_stalk"), MANGETOUT_STALK);
    
    }
}
