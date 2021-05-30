package com.jellytumtum.test.registry;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.jellytumtum.test.Test;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;

public class ModBlocks {
    

    // Hardness: Stone (1.5f), Obsidian (50.0f), etc...
    // Mining Levels: Wood (0), Stone (1), Iron (2), Diamond (3), Netherite (4)
    public static final Block CONDENSED_MANGETOUT = new Block(FabricBlockSettings
    .of(Material.ORGANIC_PRODUCT, MaterialColor.GRASS)
    .breakByTool(FabricToolTags.HOES, 1)
    .breakByHand(true)
    .strength(1.5f, 2f)
    .sounds(BlockSoundGroup.WART_BLOCK));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Test.MOD_ID, "condensed_mangetout"), CONDENSED_MANGETOUT);
    }
}
