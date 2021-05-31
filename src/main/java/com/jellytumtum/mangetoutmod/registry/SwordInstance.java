package com.jellytumtum.mangetoutmod.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class SwordInstance extends SwordItem {

    public SwordInstance(ToolMaterial material) {
        super(material, 5, -2.2f, new Item.Settings().group(ItemGroup.TOOLS));
 

    }
    
}