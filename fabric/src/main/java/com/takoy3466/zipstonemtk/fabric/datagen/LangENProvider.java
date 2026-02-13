package com.takoy3466.zipstonemtk.fabric.datagen;

import com.takoy3466.zipstonemtk.init.BlocksInit;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.world.level.block.Block;

import java.math.BigInteger;
import java.util.List;

public class LangENProvider extends FabricLanguageProvider {


    protected LangENProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    private void add(TranslationBuilder translationBuilder, List<RegistrySupplier<Block>> blocks, String baseName) {
        for (int i = 0; i < blocks.size(); i++) {
            BigInteger zip = BigInteger.valueOf(9).pow(i + 1);
            translationBuilder.add(blocks.get(i).get(), zip + "x compressed " + baseName);
        }
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        add(translationBuilder, BlocksInit.BLOCKS_AND_ITEMS.block(), "cobblestone");
    }
}
