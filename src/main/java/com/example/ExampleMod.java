package com.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "modid";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Blocks & Custom Items
    public static final Item RUBY_GEM = new Item(new Item.Settings());
    public static final Block RUBY_ORE = new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE));
    public static final Block RUBY_BLOCK = new Block(AbstractBlock.Settings.copy(Blocks.EMERALD_BLOCK));

    // Custom Tool Tier Definition (Exactly between Iron and Diamond)
    public static final ToolMaterial RUBY_TOOL_MATERIAL = new ToolMaterial() {
        @Override public int getDurability() { return 750; } 
        @Override public float getMiningSpeedMultiplier() { return 7.0f; } 
        @Override public float getAttackDamage() { return 2.5f; } 
        @Override public int getMiningLevel() { return 2; } 
        @Override public int getEnchantability() { return 14; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(RUBY_GEM); }
    };

    // Custom Armor Tier Definition (Total 17 protection points)
    public static final ArmorMaterial RUBY_ARMOR_MATERIAL = new ArmorMaterial() {
        @Override public int getDurability(ArmorItem.Type type) { return 15 * 16; } 
        @Override public int getProtection(ArmorItem.Type type) {
            return switch (type) {
                case HELMET -> 2;
                case CHESTPLATE -> 6;
                case LEGGINGS -> 5;
                case BOOTS -> 4;
            };
        }
        @Override public int getEnchantability() { return 12; }
        @Override public SoundEvent getEquipSound() { return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.ofItems(RUBY_GEM); }
        @Override public String getName() { return "ruby"; }
        @Override public float getToughness() { return 1.0f; } 
        @Override public float getKnockbackResistance() { return 0.0f; }
    };

    // Instantiate Items
    public static final Item RUBY_SWORD = new SwordItem(RUBY_TOOL_MATERIAL, 4, -2.4f, new Item.Settings()); 
    public static final Item RUBY_PICKAXE = new PickaxeItem(RUBY_TOOL_MATERIAL, 1, -2.8f, new Item.Settings());
    public static final Item RUBY_AXE = new AxeItem(RUBY_TOOL_MATERIAL, 6, -3.0f, new Item.Settings());
    public static final Item RUBY_SHOVEL = new ShovelItem(RUBY_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Settings());
    public static final Item RUBY_HOE = new HoeItem(RUBY_TOOL_MATERIAL, -2, -1.0f, new Item.Settings());

    public static final Item RUBY_HELMET = new ArmorItem(RUBY_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item RUBY_CHESTPLATE = new ArmorItem(RUBY_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item RUBY_LEGGINGS = new ArmorItem(RUBY_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item RUBY_BOOTS = new ArmorItem(RUBY_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());

    @Override
    public void onInitialize() {
        // Safe Registration
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_gem"), RUBY_GEM);
        
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ruby_ore"), RUBY_ORE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_ore"), new BlockItem(RUBY_ORE, new Item.Settings()));
        
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_block"), new BlockItem(RUBY_BLOCK, new Item.Settings()));

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_sword"), RUBY_SWORD);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_pickaxe"), RUBY_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_axe"), RUBY_AXE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_hoe"), RUBY_HOE);

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "ruby_boots"), RUBY_BOOTS);

        LOGGER.info("Ruby Mod block and items applied perfectly!");
    }
}