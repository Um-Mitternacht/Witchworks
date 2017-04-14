package com.wiccanarts.api;

import net.minecraft.util.ResourceLocation;

/**
 * This class was created by Arekkuusu on 01/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
public final class WiccanArtsAPI {

	//Sounds
	public static final ResourceLocation BOIL = getLocation("boil");

	private WiccanArtsAPI() {
	}

	private static ResourceLocation getLocation(String name) {
		return new ResourceLocation("wiccanarts", name);
	}
}
