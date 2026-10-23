package dev.glowberry.tart;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class GlowberryTart implements ModInitializer {
    public static final String MOD_ID = "glowberry_tart";

    public static final Item GLOWBERRY_TART = registerItem("glowberry_tart",
        new Item(new FabricItemSettings().maxCount(16).rarity(Rarity.UNCOMMON)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.7F)
                .alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20 * 25, 0), 1.0F)
                .build())));

    public static final Item GLOWBERRY_JAM = registerItem("glowberry_jam",
        new Item(new FabricItemSettings().maxCount(16)
            .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.8F)
                .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 20 * 12, 0), 1.0F)
                .build())));

    public static final Block GLOWBERRY_LANTERN = Registry.register(Registries.BLOCK,
        new Identifier(MOD_ID, "glowberry_lantern"),
        new Block(AbstractBlock.Settings.copy(Blocks.LANTERN).mapColor(MapColor.LIME).luminance(state -> 15)));
    public static final Item GLOWBERRY_LANTERN_ITEM = registerItem("glowberry_lantern",
        new BlockItem(GLOWBERRY_LANTERN, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
    }

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(GLOWBERRY_TART);
            entries.add(GLOWBERRY_JAM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(GLOWBERRY_LANTERN_ITEM));
    }
}