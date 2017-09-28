package com.witchworks.common.core.handler;

import com.witchworks.api.WitchWorksAPI;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */

//Todo: Redo this class, I need to figure out how to redo sounds.

@Mod.EventBusSubscriber
public final class ModSounds {

	private ModSounds() {
	}

	public static void init() {
		registerSound(WitchWorksAPI.BOIL);
		registerSound(WitchWorksAPI.BUZZ);
	}

	@SubscribeEvent
	private static void registerSound(ResourceLocation soundNameIn) {
		GameRegistry.register(new SoundEvent(soundNameIn), soundNameIn);
	}
}
