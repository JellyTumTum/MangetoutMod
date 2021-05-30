package com.jellytumtum.test;

import com.jellytumtum.test.registry.ModBlocks;
import com.jellytumtum.test.registry.ModItems;
import net.fabricmc.api.ModInitializer;

public class Test implements ModInitializer {

    public static final String MOD_ID = "testing";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        
    }
    
}
