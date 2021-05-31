package com.jellytumtum.mangetoutmod.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class PickaxeInstance extends PickaxeItem {

    public PickaxeInstance(ToolMaterial material) {
        super(material, 3, -2.6f, new Item.Settings().group(ItemGroup.TOOLS));

        // AttackDamage = 1.5 + 2nd param + 1 (as param=0 will stil +1)
        // AttackSpeed = 4 + 3rd Param (hence the - float value so its < 4.)
    }
    
}
