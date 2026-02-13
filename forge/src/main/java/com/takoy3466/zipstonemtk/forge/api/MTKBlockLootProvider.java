package com.takoy3466.zipstonemtk.forge.api;

//import com.takoy3466.manaitamtk.api.registry.BlockRegistryObject;
//import com.takoy3466.manaitamtk.api.registry.MTKRegistryObject;
//import com.takoy3466.manaitamtk.api.registry.tiered.TieredBlockRegistryObject;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class MTKBlockLootProvider extends BlockLootSubProvider {

    protected MTKBlockLootProvider(Set<Item> items, FeatureFlagSet featureFlagSet) {
        this(items, featureFlagSet, new HashMap<>());
    }

    protected MTKBlockLootProvider(Set<Item> items, FeatureFlagSet featureFlagSet, Map<ResourceLocation, LootTable.Builder> builderMap) {
        super(items, featureFlagSet, builderMap);
    }

    protected void dropSelfMTK(Block block, boolean condition) {
        add(block, createSingleTable(condition, block));
    }

    protected <T extends ConditionUserBuilder<T>> T explosionCondition(boolean condition, ConditionUserBuilder<T> builder) {
        return condition ? builder.when(ExplosionCondition.survivesExplosion()) : builder.unwrap();
    }

    public LootTable.Builder createSingleTable(boolean condition, ItemLike itemLike) {
        return LootTable.lootTable().withPool(this.explosionCondition(condition, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))));
    }
}
