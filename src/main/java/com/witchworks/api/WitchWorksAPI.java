package com.witchworks.api;

import net.minecraft.util.ResourceLocation;

/**
 * This class was created by Arekkuusu on 01/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
public final class WitchWorksAPI {

	//Sounds
	public static final ResourceLocation BOIL = getLocation("boil");
	public static final ResourceLocation BUZZ = getLocation("buzz");
	public static final ResourceLocation CHALK_SCRIBBLE = getLocation("chalk_scribble");
	//Constants
	public static final String TAGLOCK_ENTITY = "tag_entity";
	public static final String TAGLOCK_ENTITY_NAME = "tag_entity_name";

	private WitchWorksAPI() {
	}

	private static ResourceLocation getLocation(String name) {
		return new ResourceLocation("witchworks", name);
	}
}
