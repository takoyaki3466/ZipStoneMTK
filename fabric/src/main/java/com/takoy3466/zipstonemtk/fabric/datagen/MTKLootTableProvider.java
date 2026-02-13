package com.takoy3466.zipstonemtk.fabric.datagen;

import com.takoy3466.zipstonemtk.fabric.api.MTKBlockLootProvider;
import com.takoy3466.zipstonemtk.init.BlocksInit;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Collections;
import java.util.List;

public class MTKLootTableProvider extends MTKBlockLootProvider {


    protected MTKLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        generateForList(BlocksInit.BLOCKS_AND_ITEMS.block());
    }

    private void generateForList(List<RegistrySupplier<Block>> blocks) {
        for (RegistrySupplier<Block> block : blocks) {
            dropSelfMTK(block.get(), true);
        }
    }
}
