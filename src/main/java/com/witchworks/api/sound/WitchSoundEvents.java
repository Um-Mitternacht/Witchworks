package com.witchworks.api.sound;

import com.witchworks.api.WitchworksAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class WitchSoundEvents {

	public static final SoundEvent BOIL = getRegisteredSound(WitchworksAPI.BOIL);
	public static final SoundEvent BUZZ = getRegisteredSound(WitchworksAPI.BUZZ);
	public static final SoundEvent CHALK_SCRIBBLE = getRegisteredSound(WitchworksAPI.CHALK_SCRIBBLE);
	public static final SoundEvent BUBBLE = getRegisteredSound(WitchworksAPI.BUBBLE);
	public static final SoundEvent OVEN_OPEN = getRegisteredSound(WitchworksAPI.OVEN_OPEN);

	private WitchSoundEvents() {
	}

	private static SoundEvent getRegisteredSound(ResourceLocation name) {
		return SoundEvent.REGISTRY.getObject(name);
	}
}
