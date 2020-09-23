package com.vikingkaare.firstmod.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public class ItemList {
    //Tools
    public static Item first_sword = null;
    public static Item first_pickaxe = null;
    public static Item first_axe = null;
    public static Item first_shovel = null;
    public static Item first_hoe = null;

    //Blocks, items
    public static Item first_item, second_item, first_block, second_block, first_slab, second_slab, first_stairs, second_stairs, first_wall, second_wall, oil_bucket;

    // Custom ItemTier
    public enum ModItemTier implements IItemTier
    {
    CUSTOM(4, 1500, 15.0F, 7.0F, 250, () -> {
        return Ingredient.fromItems(ItemList.first_item);
    });
    // Fields
    private final int harvestLevel;
    private final float efficiency;
    private final int maxUses;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial)
    {
        // Assign field to parameter
    this.harvestLevel = harvestLevel;
    this.efficiency = efficiency;
    this.maxUses = maxUses;
    this.attackDamage = attackDamage;
    this.enchantability = enchantability;
    this.repairMaterial = new LazyValue<>(repairMaterial);
    }
     //Implemented methods from interface IItemTier
        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }
}
