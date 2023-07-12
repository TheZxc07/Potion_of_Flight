package net.dez.potionofflight.potion;

import net.dez.potionofflight.PotionOfFlight;
import net.dez.potionofflight.effect.ModEffects;
import net.dez.potionofflight.item.ModItems;
import net.dez.potionofflight.mixin.IBrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static Potion FLIGHT_POTION;
    public static Potion LONG_FLIGHT_POTION;
    public static Potion STRONG_FLIGHT_POTION;
    public static Potion registerPotion(String name, int length, int amplifier){
       return Registry.register(Registry.POTION, new Identifier(PotionOfFlight.MOD_ID, name), new Potion(new StatusEffectInstance(ModEffects.FLIGHT, length, amplifier)));
    }

    public static void registerPotions(){
        FLIGHT_POTION = registerPotion("flight_potion" ,900, 0);
        LONG_FLIGHT_POTION = registerPotion("long_flight_potion", 1800, 0);
        STRONG_FLIGHT_POTION = registerPotion("strong_flight_potion", 600, 1);

        registerPotionRecipes();
    }

    private static void registerPotionRecipes(){
        IBrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.SLOW_FALLING, ModItems.PHANTOM_ESSENCE, ModPotions.FLIGHT_POTION);
        IBrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.FLIGHT_POTION, Items.REDSTONE ,ModPotions.LONG_FLIGHT_POTION);
        IBrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.FLIGHT_POTION, Items.GLOWSTONE_DUST ,ModPotions.STRONG_FLIGHT_POTION);
    }
}
