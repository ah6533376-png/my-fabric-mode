package dev.glowberry.tart;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class GlowberryTart implements ModInitializer {
    public static final String MOD_ID = "glowberry_tart";

    public static final Item GLOWBERRY_TART = Registry.register(
        Registries.ITEM,
        new Identifier(MOD_ID, "glowberry_tart"),
        new Item(new FabricItemSettings()
            .maxCount(16)
            .rarity(Rarity.UNCOMMON)
            .food(new FoodComponent.Builder()
                .hunger(6)
                .saturationModifier(0.7F)
                .alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20 * 25, 0), 1.0F)
                .build()
            )
        )
    );

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
            .register(entries -> entries.add(GLOWBERRY_TART));
    }
}
