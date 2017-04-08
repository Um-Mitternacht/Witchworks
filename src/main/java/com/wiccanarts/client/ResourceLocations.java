package com.wiccanarts.client;

import com.wiccanarts.common.lib.LibMod;
import net.minecraft.util.ResourceLocation;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ResourceLocations {

	//Entity
	public static final ResourceLocation STONE_SKIN = getLocation ("textures/misc/cobblestone.png");

	//GUI
	public static final ResourceLocation POTION_TEXTURES = getLocation ("textures/gui/potions.png");

	//Particles
	public static final ResourceLocation CAULDRON_BUBBLE = getLocation ("particle/cauldron_bubble");
	public static final ResourceLocation STEAM = getLocation ("particle/steam");

	private ResourceLocations () {
	}

	private static ResourceLocation getLocation (String name) {
		return new ResourceLocation (LibMod.MOD_ID, name);
	}
}
