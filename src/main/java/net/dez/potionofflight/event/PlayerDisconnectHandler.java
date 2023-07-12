package net.dez.potionofflight.event;

import net.dez.potionofflight.utils.FlightData;
import net.dez.potionofflight.utils.IEntityDataSaver;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerDisconnectHandler implements ServerPlayConnectionEvents.Disconnect {


    @Override
    public void onPlayDisconnect(ServerPlayNetworkHandler handler, MinecraftServer server) {
        ServerPlayerEntity player = handler.player;
        if (player.getAbilities().flying){
            FlightData.saveFlightEffectData((IEntityDataSaver) player, 1, 1);
        }
        else if (player.getAbilities().allowFlying){
            FlightData.saveFlightEffectData((IEntityDataSaver) player, 1, 0);
        }
        else{
            FlightData.saveFlightEffectData((IEntityDataSaver) player, 0, 0);
        }
    }
}
