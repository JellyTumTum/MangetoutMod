package com.jellytumtum.mangetoutmod.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class HoeInstance extends HoeItem {

    public HoeInstance(ToolMaterial material) {
        super(material, -1, 0f, new Item.Settings().group(ItemGroup.TOOLS));

        // AttackDamage = 1.5 + 2nd param + 1 (as param=0 will stil +1) if (-1) then no change from 1.5
        // AttackSpeed = 4 + 3rd Param (hence the - float value so its < 4.)

    }
    
}