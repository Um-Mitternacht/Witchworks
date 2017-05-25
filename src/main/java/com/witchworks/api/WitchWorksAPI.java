package com.witchworks.api;

import net.minecraft.util.ResourceLocation;

/**
 * This class was created by Arekkuusu on 01/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class WitchWorksAPI {

	//Sounds
	public static final ResourceLocation boil = getLocation("boil");
	public static final ResourceLocation buzz = getLocation("buzz");
	public static final ResourceLocation chalk_scribble = getLocation("chalk_scribble");
	//Constants
	public static final String taglock_entity = "tag_entity";
	public static final String taglock_entity_name = "tag_entity_name";

	private WitchWorksAPI() {
	}

	private static ResourceLocation getLocation(String name) {
		return new ResourceLocation("witchworks", name);
	}
}
