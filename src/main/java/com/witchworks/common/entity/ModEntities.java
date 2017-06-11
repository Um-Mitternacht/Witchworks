package com.witchworks.common.entity;

import com.witchworks.common.WitchWorks;
import com.witchworks.common.lib.LibMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class ModEntities {

	private ModEntities() {
	}

	public static void preInit() {
		int id = 0;

		EntityRegistry.registerModEntity(getResource("brew_throwable"), EntityBrew.class, "brew_throwable", id++, WitchWorks.instance, 64, 1, true);
		EntityRegistry.registerModEntity(getResource("brew_linger"), EntityBrewLinger.class, "brew_linger", id, WitchWorks.instance, 64, 1, false);
	}

	private static ResourceLocation getResource(String name) {
		return new ResourceLocation(LibMod.MOD_ID, name);
	}
}
