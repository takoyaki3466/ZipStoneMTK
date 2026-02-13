package com.takoy3466.zipstonemtk.forge.datagen;

import com.takoy3466.zipstonemtk.init.BlocksInit;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class MTKBlockStateProvider extends BlockStateProvider {
    public MTKBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerListBlockModel(BlocksInit.BLOCKS_AND_ITEMS.block());
    }

    private void registerListBlockModel(List<RegistrySupplier<Block>> blocks) {
        for (RegistrySupplier<Block> block : blocks) {
            simpleBlockWithItem(block.get(), cubeAll(block.get()));
        }
    }
}
