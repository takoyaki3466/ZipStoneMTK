package com.takoy3466.zipstonemtk.forge.datagen;

import com.takoy3466.zipstonemtk.forge.api.MTKBlockLootProvider;
import com.takoy3466.zipstonemtk.init.BlocksInit;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MTKLootTableProvider extends MTKBlockLootProvider {

    public MTKLootTableProvider() {
        super(Collections.emptySet(), FeatureFlags.VANILLA_SET);
    }

    @Override
    protected void generate() {
        generateForList(BlocksInit.BLOCKS_AND_ITEMS.block());
    }

    private void generateForList(List<RegistrySupplier<Block>> blocks) {
        for (RegistrySupplier<Block> block : blocks) {
            dropSelfMTK(block.get(), true);
        }
    }

    @NotNull
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return new Iterable<>() {
            @Override
            public @NotNull Iterator<Block> iterator() {
                return BlocksInit.BLOCKS_AND_ITEMS.block().stream().map(RegistrySupplier::get).iterator();
            }
        };
    }
}
