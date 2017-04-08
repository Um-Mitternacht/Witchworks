package com.wiccanarts.api;

import net.minecraft.util.ResourceLocation;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ResourceLocationsAPI {

	//Sounds
	public static final ResourceLocation BOIL = getLocation ("boil");

	private ResourceLocationsAPI () {
	}

	private static ResourceLocation getLocation (String name) {
		return new ResourceLocation ("wiccanarts", name);
	}
}
