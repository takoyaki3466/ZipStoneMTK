package com.takoy3466.zipstonemtk.fabric.datagen;

import com.takoy3466.zipstonemtk.init.BlocksInit;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class MTKRecipeProvider extends FabricRecipeProvider {

    public MTKRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        compressedRecipe(consumer, BlocksInit.BLOCKS_AND_ITEMS.item(), Items.COBBLESTONE);
    }

    private void compressedRecipe(Consumer<FinishedRecipe> consumer, List<RegistrySupplier<? extends Item>> items, ItemLike firstItem) {
        for (int i = 0; i < items.size(); i++) {
            RegistrySupplier<? extends Item> item = items.get(i);
            if (i == 0) {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, item.get())
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', firstItem)
                        .unlockedBy("hasItem", InventoryChangeTrigger.TriggerInstance.hasItems(firstItem))
                        .save(consumer);
            }else {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, item.get())
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .define('#', items.get(i - 1).get())
                        .unlockedBy("hasItem", InventoryChangeTrigger.TriggerInstance.hasItems(firstItem))
                        .save(consumer);
            }
        }
    }
}
