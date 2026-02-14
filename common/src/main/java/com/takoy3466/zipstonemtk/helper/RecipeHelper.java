package com.takoy3466.zipstonemtk.helper;

import com.takoy3466.zipstonemtk.ZipStoneMTK;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class RecipeHelper {

    public static void compressAndReverseRecipe(Consumer<FinishedRecipe> consumer, List<RegistrySupplier<? extends Item>> items, ItemLike baseItem) {
        compressedRecipe(consumer, items, baseItem);
        reverseRecipe(consumer, items, baseItem);
    }

    public static void compressedRecipe(Consumer<FinishedRecipe> consumer, List<RegistrySupplier<? extends Item>> items, ItemLike firstItem) {
        for (int i = 0; i < items.size(); i++) {
            RegistrySupplier<? extends Item> item = items.get(i);
            if (i == 0) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, item.get())
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', firstItem)
                        .unlockedBy("hasItem", InventoryChangeTrigger.TriggerInstance.hasItems(firstItem))
                        .save(consumer, new ResourceLocation(ZipStoneMTK.MOD_ID, item.get().toString() + "_compressed"));
            }else {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, item.get())
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', items.get(i - 1).get())
                        .unlockedBy("hasItem", InventoryChangeTrigger.TriggerInstance.hasItems(firstItem))
                        .save(consumer, new ResourceLocation(ZipStoneMTK.MOD_ID, item.get().toString() + "_compressed"));
            }
        }
    }

    public static void reverseRecipe(Consumer<FinishedRecipe> consumer, List<RegistrySupplier<? extends Item>> items, ItemLike lastItem) {
        for (int i = 0; i < items.size(); i++) {
            RegistrySupplier<? extends Item> item = items.get(i);
            if (i == 0) {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, lastItem, 9)
                        .requires(item.get())
                        .unlockedBy("hasItem", InventoryChangeTrigger.TriggerInstance.hasItems(lastItem))
                        .save(consumer, new ResourceLocation(ZipStoneMTK.MOD_ID, item.get().toString() + "_reverse"));
            }else {
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, items.get(i - 1).get(), 9)
                        .requires(item.get())
                        .unlockedBy("hasItem", InventoryChangeTrigger.TriggerInstance.hasItems(lastItem))
                        .save(consumer, new ResourceLocation(ZipStoneMTK.MOD_ID, item.get().toString() + "_reverse"));
            }
        }
    }
}
