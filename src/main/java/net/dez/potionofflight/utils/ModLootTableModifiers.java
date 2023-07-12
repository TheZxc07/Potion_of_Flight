package net.dez.potionofflight.utils;

import net.dez.potionofflight.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier PHANTOM_LOOT_TABLE_ID = new Identifier("minecraft", "entities/phantom");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && PHANTOM_LOOT_TABLE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.PHANTOM_ESSENCE))
                        .conditionally(RandomChanceLootCondition.builder(0.1f));

                tableBuilder.pool(poolBuilder);

            }
        });
    }
}
