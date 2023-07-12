package net.dez.potionofflight.networking.packet;

import net.dez.potionofflight.utils.FlightData;
import net.dez.potionofflight.utils.IEntityDataSaver;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class FlightEffectC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender packetSender) {
        int flightEffect = FlightData.getFlightEffectData((IEntityDataSaver) player);

    }
}
