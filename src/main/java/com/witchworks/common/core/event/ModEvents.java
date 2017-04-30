package com.witchworks.common.core.event;

import net.minecraftforge.common.MinecraftForge;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class ModEvents {

	private ModEvents() {
	}

	public static void preInit() {
		MinecraftForge.EVENT_BUS.register(new EnergyEvents());
		MinecraftForge.EVENT_BUS.register(new BrewEvents());
	}
}
