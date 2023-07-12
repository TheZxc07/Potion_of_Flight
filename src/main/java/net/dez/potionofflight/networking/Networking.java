package net.dez.potionofflight.networking;

import net.dez.potionofflight.PotionOfFlight;
import net.dez.potionofflight.networking.packet.FlightEffectC2SPacket;
import net.dez.potionofflight.networking.packet.FlightEffectS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class Networking {
    public static final Identifier FLIGHT_ID = new Identifier(PotionOfFlight.MOD_ID, "flight");
    public static void registerC2SPackets(){
        ServerPlayNetworking.registerGlobalReceiver(FLIGHT_ID, FlightEffectC2SPacket::receive);
    }

    public static void registerS2CPackets(){
        ClientPlayNetworking.registerGlobalReceiver(FLIGHT_ID, FlightEffectS2CPacket::send);
    }
}
