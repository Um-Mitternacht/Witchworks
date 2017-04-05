package com.wiccanarts.common.core.handler;

import com.wiccanarts.api.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.common.registry.*;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ModSounds {

	public static void preInit() {
		registerSound(ResourceLocationsAPI.BOIL);
	}

	private static void registerSound(ResourceLocation soundNameIn) {
		GameRegistry.register(new SoundEvent(soundNameIn), soundNameIn);
	}
}
