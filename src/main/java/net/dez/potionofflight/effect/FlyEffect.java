package net.dez.potionofflight.effect;

import net.dez.potionofflight.utils.FlightData;
import net.dez.potionofflight.utils.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class FlyEffect extends StatusEffect {

    private int length;
    public FlyEffect(StatusEffectCategory statusEffectCategory, int colour){
        super(statusEffectCategory, colour);
    }
    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity.isPlayer()) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.getAbilities().creativeMode || !player.getStatusEffects().contains(this)) {
                player.getAbilities().allowFlying = false;
                player.getAbilities().flying = false;
            }
            if (!player.getStatusEffects().contains(this)) {
                player.getAbilities().setFlySpeed(0.05f);
            }
            FlightData.saveFlightEffectData((IEntityDataSaver) player, 0, 0);
            player.sendAbilitiesUpdate();
        }
    }
    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity.isPlayer()){
            PlayerEntity player = (PlayerEntity) entity;
            player.getAbilities().allowFlying = true;
            player.getAbilities().flying = true;
            //ClientPlayNetworking.send(Networking.FLIGHT_ID, PacketByteBufs.create());
            if (amplifier == 0) {
                player.getAbilities().setFlySpeed(0.025f);
            }
            else{
                player.getAbilities().setFlySpeed(0.05f);
            }
            FlightData.saveFlightEffectData((IEntityDataSaver) player, 1, 1);
            player.sendAbilitiesUpdate();
        }
    }

}
