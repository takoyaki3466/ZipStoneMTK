package com.takoy3466.zipstonemtk.init;

import com.takoy3466.zipstonemtk.ZipStoneMTK;
import com.takoy3466.zipstonemtk.block.BlockZipStone;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlocksInit {
    public static int NUM = 64;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ZipStoneMTK.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ZipStoneMTK.MOD_ID, Registries.ITEM);

    public static final BlockAndItemList BLOCKS_AND_ITEMS = listRegister("zip_stone",
            BlockZipStone::new, new Item.Properties().arch$tab(TabsInit.MAIN_TAB), NUM);


    public static BlockAndItemList listRegister(String baseName, Supplier<? extends Block> supplier, Item.Properties properties, int num) {
        List<RegistrySupplier<Block>> blockList = new ArrayList<>();
        List<RegistrySupplier<? extends Item>> itemList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            RegistrySupplier<Block> block = BLOCKS.register(baseName + i, supplier);
            RegistrySupplier<BlockItem> item = ITEMS.register(baseName + i, () -> new BlockItem(block.get(), properties));
            blockList.add(block);
            itemList.add(item);
        }
        return new BlockAndItemList(blockList, itemList);
    }

    public record BlockAndItemList(List<RegistrySupplier<Block>> block, List<RegistrySupplier<? extends Item>> item) {

    }

    public static void init() {
        BLOCKS.register();
        ITEMS.register();
    }
}
