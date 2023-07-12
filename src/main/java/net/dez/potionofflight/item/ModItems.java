package net.dez.potionofflight.item;

import net.dez.potionofflight.PotionOfFlight;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item PHANTOM_ESSENCE = registerItem("phantom_essence", new Item(new FabricItemSettings().group(ItemGroup.BREWING)));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(PotionOfFlight.MOD_ID, name), item);
    }
    public static void registerModItems(){
        PotionOfFlight.LOGGER.debug("Registering Mod Items for " + PotionOfFlight.MOD_ID);
    }
}
