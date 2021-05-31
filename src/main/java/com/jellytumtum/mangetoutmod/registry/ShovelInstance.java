package com.jellytumtum.mangetoutmod.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ShovelInstance extends ShovelItem {

    public ShovelInstance(ToolMaterial material) {
        super(material, 4.5f, -3f, new Item.Settings().group(ItemGroup.TOOLS));

        // AttackDamage = 1.5 + 2nd param + 1 (as param=0 will stil +1)
        // AttackSpeed = 4 + 3rd Param (hence the - float value so its < 4.)

    }
    
}
