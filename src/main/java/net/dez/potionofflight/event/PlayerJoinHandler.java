package net.dez.potionofflight.event;

import net.dez.potionofflight.utils.FlightData;
import net.dez.potionofflight.utils.IEntityDataSaver;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerJoinHandler implements ServerPlayConnectionEvents.Join {

    @Override
    public void onPlayReady(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server) {
        ServerPlayerEntity player = handler.player;
        if (FlightData.getFlightEffectData((IEntityDataSaver) player) == 1){
            player.getAbilities().allowFlying = true;
            if (FlightData.getFlightState((IEntityDataSaver) player) == 1){
                player.getAbilities().flying = true;
            }
            else {
                player.getAbilities().flying = false;
            }
        }
    }
}

//    int flightEffect = FlightData.getFlightEffectData((IEntityDataSaver) client.player);
//    String test;
//        if (flightEffect == 1){
//                test = "Deez";
//                }
//                else{
//                test = "Nuts";
//                }
//                client.player.sendMessage(Text.literal(test));