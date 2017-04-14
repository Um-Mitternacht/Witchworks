package com.wiccanarts.common.core.handler;

import com.wiccanarts.api.WiccanArtsAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ModSounds {

	private ModSounds() {
	}

	public static void preInit() {
		registerSound(WiccanArtsAPI.BOIL);
	}

	private static void registerSound(ResourceLocation soundNameIn) {
		GameRegistry.register(new SoundEvent(soundNameIn), soundNameIn);
	}
}
