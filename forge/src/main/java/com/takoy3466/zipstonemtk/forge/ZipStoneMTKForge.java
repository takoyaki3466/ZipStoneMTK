package com.takoy3466.zipstonemtk.forge;

import com.takoy3466.zipstonemtk.ZipStoneMTK;
import com.takoy3466.zipstonemtk.forge.datagen.*;
import dev.architectury.platform.forge.EventBuses;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Collections;
import java.util.List;

@Mod(ZipStoneMTK.MOD_ID)
public final class ZipStoneMTKForge {

    @SuppressWarnings("removal")
    public ZipStoneMTKForge() {
        init(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public ZipStoneMTKForge(FMLJavaModLoadingContext context) {
        init(context.getModEventBus());
    }

    public void init(IEventBus bus) {
        EventBuses.registerModEventBus(ZipStoneMTK.MOD_ID, bus);
        ZipStoneMTK.init();
        bus.addListener(this::gatherData);
    }

    public void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();

        gen.addProvider(event.includeServer(), new MTKBlockStateProvider(output, ZipStoneMTK.MOD_ID, helper));
        gen.addProvider(event.includeServer(), new LangJPProvider(output, ZipStoneMTK.MOD_ID));
        gen.addProvider(event.includeServer(), new LangENProvider(output, ZipStoneMTK.MOD_ID));
        gen.addProvider(event.includeServer(), new MTKRecipeProvider(output));
        gen.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(MTKLootTableProvider::new, LootContextParamSets.BLOCK))));
    }
}
