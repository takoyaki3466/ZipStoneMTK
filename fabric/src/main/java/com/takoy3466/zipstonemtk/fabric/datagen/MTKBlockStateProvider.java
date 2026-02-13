package com.takoy3466.zipstonemtk.fabric.datagen;

import com.takoy3466.zipstonemtk.init.BlocksInit;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.UnknownNullability;

import java.util.List;

public class MTKBlockStateProvider extends FabricModelProvider {

    public MTKBlockStateProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        registerListBlockModel(blockStateModelGenerator, BlocksInit.BLOCKS_AND_ITEMS.block());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }

    private void registerListBlockModel(BlockModelGenerators modelGenerators, List<RegistrySupplier<Block>> blocks) {
        for (RegistrySupplier<Block> block : blocks) {
            modelGenerators.createTrivialCube(block.get());
        }
    }
}
