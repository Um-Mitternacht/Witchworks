package com.wiccanarts.client;

import com.wiccanarts.common.lib.LibMod;
import net.minecraft.util.ResourceLocation;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ResourceLocations {

	public static final ResourceLocation POTION_TEXTURES = getLocation("textures/gui/potions.png");

	private ResourceLocations() {
	}

	private static ResourceLocation getLocation(String name) {
		return new ResourceLocation(LibMod.MOD_ID, name);
	}
}
