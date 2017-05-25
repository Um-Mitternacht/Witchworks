package com.witchworks.api.sound;

import com.witchworks.api.WitchWorksAPI;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class WitchSoundEvents {

	public static final SoundEvent boil = getRegisteredSound(WitchWorksAPI.boil);
	public static final SoundEvent buzz = getRegisteredSound(WitchWorksAPI.buzz);
	public static final SoundEvent chalk_scribble = getRegisteredSound(WitchWorksAPI.chalk_scribble);

	private WitchSoundEvents() {
	}

	private static SoundEvent getRegisteredSound(ResourceLocation name) {
		return SoundEvent.REGISTRY.getObject(name);
	}
}
