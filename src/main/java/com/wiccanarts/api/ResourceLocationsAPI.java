package com.wiccanarts.api;

import net.minecraft.util.ResourceLocation;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ResourceLocationsAPI {

	//Sounds
	public static final ResourceLocation TEST_SOUND = getLocation("test");

	private static ResourceLocation getLocation(String name){
		return new ResourceLocation("wiccanarts", name);
	}
}
