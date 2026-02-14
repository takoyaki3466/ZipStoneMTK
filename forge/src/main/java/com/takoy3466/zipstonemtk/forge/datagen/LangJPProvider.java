package com.takoy3466.zipstonemtk.forge.datagen;

import com.takoy3466.zipstonemtk.init.BlocksInit;
import com.takoy3466.zipstonemtk.init.TabsInit;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import java.math.BigInteger;
import java.util.List;

public class LangJPProvider extends LanguageProvider {
    public LangJPProvider(PackOutput output, String modid) {
        super(output, modid, "ja_jp");
    }

    @Override
    protected void addTranslations() {
        add(BlocksInit.BLOCKS_AND_ITEMS.block(), "丸石");

        add("zip_stone_main_tab", "ZipStoneMTK");
    }

    private void add(List<RegistrySupplier<Block>> blocks, String baseName) {
        for (int i = 0; i < blocks.size(); i++) {
            BigInteger zip = BigInteger.valueOf(9).pow(i + 1);
            add(blocks.get(i).get(), zip + "倍圧縮" + baseName);
        }
    }
}
