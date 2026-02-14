package com.takoy3466.zipstonemtk.fabric.datagen;

import com.takoy3466.zipstonemtk.init.BlocksInit;
import com.takoy3466.zipstonemtk.helper.RecipeHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class MTKRecipeProvider extends FabricRecipeProvider {

    public MTKRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        RecipeHelper.compressAndReverseRecipe(consumer, BlocksInit.BLOCKS_AND_ITEMS.item(), Items.COBBLESTONE);
    }
}
