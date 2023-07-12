package net.dez.potionofflight.effect;

import net.dez.potionofflight.PotionOfFlight;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect FLIGHT;

    public static StatusEffect registerStatusEffect(String name){
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(PotionOfFlight.MOD_ID, name),
                new FlyEffect(StatusEffectCategory.BENEFICIAL, 	0xD8DEEC));
    }

    public static void registerEffects(){
        FLIGHT = registerStatusEffect("flight");
    }
}
