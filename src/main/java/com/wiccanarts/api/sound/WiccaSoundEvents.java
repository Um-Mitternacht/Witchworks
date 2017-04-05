package com.wiccanarts.api.sound;

import com.wiccanarts.api.*;
import net.minecraft.util.*;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class WiccaSoundEvents {

	public static final SoundEvent BOIL = getRegisteredSound(ResourceLocationsAPI.BOIL);

	private WiccaSoundEvents() {
	}

	private static SoundEvent getRegisteredSound(ResourceLocation name) {
		return SoundEvent.REGISTRY.getObject(name);
	}
}
