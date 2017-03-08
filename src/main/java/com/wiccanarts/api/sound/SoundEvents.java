package com.wiccanarts.api.sound;

import com.wiccanarts.api.ResourceLocationsAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class SoundEvents {

	public static final SoundEvent TEST_SOUND = getRegisteredSound(ResourceLocationsAPI.TEST_SOUND);

	private SoundEvents() {
	}

	private static SoundEvent getRegisteredSound(ResourceLocation name) {
		return SoundEvent.REGISTRY.getObject(name);
	}
}
