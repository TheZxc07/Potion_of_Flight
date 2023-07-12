package net.dez.potionofflight;

import net.dez.potionofflight.effect.ModEffects;
import net.dez.potionofflight.event.PlayerDisconnectHandler;
import net.dez.potionofflight.event.PlayerJoinHandler;
import net.dez.potionofflight.item.ModItems;
import net.dez.potionofflight.networking.Networking;
import net.dez.potionofflight.potion.ModPotions;
import net.dez.potionofflight.utils.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PotionOfFlight implements ModInitializer {
	public static final String MOD_ID = "potionofflight";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();

		ModEffects.registerEffects();
		ModPotions.registerPotions();

		Networking.registerC2SPackets();

		ServerPlayConnectionEvents.JOIN.register(new PlayerJoinHandler());
		ServerPlayConnectionEvents.DISCONNECT.register(new PlayerDisconnectHandler());

	}
}
