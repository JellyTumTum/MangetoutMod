package com.jellytumtum.mangetoutmod.registry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ToolMaterialMangetoutium implements ToolMaterial {

    @Override
    public int getDurability() {
        return 748;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10;
    }

    @Override
    public float getAttackDamage() {
        return 1.5f;
        // Diamond : Sword[7], Shovel[5.5], Pickaxe[5.5], Axe[9], Hoe[1] 
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.MANGETOUTIUM_INGOT);
    }
    
}
