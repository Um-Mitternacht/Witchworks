package com.witchworks.common.core.handler;

import com.witchworks.api.WitchWorksAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class ModSounds {

	private ModSounds() {
	}

	public static void init() {
		registerSound(WitchWorksAPI.BOIL);
		registerSound(WitchWorksAPI.BUZZ);
	}

	private static void registerSound(ResourceLocation soundNameIn) {
		GameRegistry.register(new SoundEvent(soundNameIn), soundNameIn);
	}
}
