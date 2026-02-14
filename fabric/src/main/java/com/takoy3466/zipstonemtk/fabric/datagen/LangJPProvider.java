package com.takoy3466.zipstonemtk.fabric.datagen;

import com.takoy3466.zipstonemtk.init.BlocksInit;
import com.takoy3466.zipstonemtk.init.TabsInit;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.world.level.block.Block;

import java.math.BigInteger;
import java.util.List;

public class LangJPProvider extends FabricLanguageProvider {

    protected LangJPProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "ja_jp");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        add(translationBuilder, BlocksInit.BLOCKS_AND_ITEMS.block(), "丸石");

        translationBuilder.add(TabsInit.MAIN_TAB.getKey(), "ZipStoneMTK");
    }

    private void add(TranslationBuilder builder, List<RegistrySupplier<Block>> blocks, String baseName) {
        for (int i = 0; i < blocks.size(); i++) {
            BigInteger zip = BigInteger.valueOf(9).pow(i + 1);
            builder.add(blocks.get(i).get(), zip + "倍圧縮" + baseName);
        }
    }
}
