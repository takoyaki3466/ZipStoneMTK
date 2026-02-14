package com.takoy3466.zipstonemtk.forge.datagen;

import com.takoy3466.zipstonemtk.init.BlocksInit;
import com.takoy3466.zipstonemtk.helper.RecipeHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class MTKRecipeProvider extends RecipeProvider {
    public MTKRecipeProvider(PackOutput arg) {
        super(arg);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        RecipeHelper.compressAndReverseRecipe(consumer, BlocksInit.BLOCKS_AND_ITEMS.item(), Items.COBBLESTONE);
    }
}
