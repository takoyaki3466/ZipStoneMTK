package com.takoy3466.zipstonemtk.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MTKDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(LangJPProvider::new);
        pack.addProvider(LangENProvider::new);
        pack.addProvider(MTKBlockStateProvider::new);
        pack.addProvider(MTKLootTableProvider::new);
        pack.addProvider(MTKRecipeProvider::new);
    }

}
