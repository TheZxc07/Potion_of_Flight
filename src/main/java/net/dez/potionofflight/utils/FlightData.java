package net.dez.potionofflight.utils;

import net.minecraft.nbt.NbtCompound;

public class FlightData {
    public static void saveFlightEffectData(IEntityDataSaver player, int flight, int flightState) {
        NbtCompound playerData = player.getPersistentData();
        playerData.putInt("flight", flight);
        playerData.putInt("flightstate", flightState);
    }

    public static int getFlightEffectData(IEntityDataSaver player){
        NbtCompound playerData = player.getPersistentData();
        if (playerData.contains("flight")){
            return playerData.getInt("flight");
        }
        return 0;
    }

    public static int getFlightState(IEntityDataSaver player){
        NbtCompound playerData = player.getPersistentData();
        if (playerData.contains("flightstate")){
            return playerData.getInt("flightstate");
        }
        return 0;
    }
}
