package com.wiccanarts.client;

import com.wiccanarts.common.lib.LibMod;
import net.minecraft.util.ResourceLocation;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ResourceLocations {

	//Misc
	public static final ResourceLocation STONE_SKIN = getLocation("textures/misc/cobblestone.png");
	public static final ResourceLocation WATER_STILL = getLocation("textures/misc/water_still.png");

	//GUI
	public static final ResourceLocation POTION_TEXTURES = getLocation("textures/gui/potions.png");
	public static final ResourceLocation APIARY_GUI = getLocation("textures/gui/apiary.png");

	//Particles
	public static final ResourceLocation CAULDRON_BUBBLE = getLocation("particle/cauldron_bubble");
	public static final ResourceLocation STEAM = getLocation("particle/steam");
	public static final ResourceLocation BEE = getLocation("particle/bee");

	private ResourceLocations() {
	}

	private static ResourceLocation getLocation(String name) {
		return new ResourceLocation(LibMod.MOD_ID, name);
	}
}
