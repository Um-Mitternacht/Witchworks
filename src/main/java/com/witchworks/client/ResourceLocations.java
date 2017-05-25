package com.witchworks.client;

import com.witchworks.common.lib.LibMod;
import net.minecraft.util.ResourceLocation;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class ResourceLocations {

	//Misc
	public static final ResourceLocation gray_water = getLocation("blocks/fluid/gray_scale_fluid");

	//GUI
	public static final ResourceLocation potion_textures = getLocation("textures/gui/potions.png");
	public static final ResourceLocation brew_textures = getLocation("textures/gui/brews.png");
	public static final ResourceLocation apiary_gui = getLocation("textures/gui/apiary.png");
	public static final ResourceLocation energy = getLocation("textures/gui/energy.png");
	public static final ResourceLocation[] energy_background = new ResourceLocation[]{
			getLocation("textures/gui/energy_dark.png"),
			getLocation("textures/gui/energy_white.png"),
	};

	//Particles
	public static final ResourceLocation cauldron_bubble = getLocation("particle/cauldron_bubble");
	public static final ResourceLocation cauldron_bubble_pop = getLocation("particle/cauldron_bubble_pop");
	public static final ResourceLocation steam = getLocation("particle/steam");
	public static final ResourceLocation bee = getLocation("particle/bee");

	private ResourceLocations() {
	}

	private static ResourceLocation getLocation(String name) {
		return new ResourceLocation(LibMod.mod_id, name);
	}
}
