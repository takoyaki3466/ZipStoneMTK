package com.takoy3466.zipstonemtk.init;

import com.takoy3466.zipstonemtk.ZipStoneMTK;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TabsInit {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(ZipStoneMTK.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> MAIN_TAB = TABS.register(
            "main_tab",
            () -> CreativeTabRegistry.create(
                    Component.translatable("zip_stone_main_tab"),
                    () -> new ItemStack(BlocksInit.BLOCKS_AND_ITEMS.item().get(0).get()))
    );

    public static void init() {
        TABS.register();
    }
}
