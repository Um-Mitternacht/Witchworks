package com.witchworks.common.brew;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.IBrew;
import com.witchworks.common.lib.LibMod;

import static com.witchworks.api.BrewRegistry.Brew.*;
import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@ObjectHolder(LibMod.MOD_ID)
public final class ModBrews {

	public static IBrew SHELL_ARMOR;
	public static IBrew SPIDER_NIGHTMARE;
	public static IBrew EXTINGUISH;
	public static IBrew MARS_WATER;
	public static IBrew FROSTBITE;
	public static IBrew HOLY_WATER;
	public static IBrew VOLATILE;

	private ModBrews() {
	}

	public static void init() {
		SHELL_ARMOR = BrewRegistry.registerBrew(new ShellArmorBrew());
		BrewRegistry.addDefault(DRINK, new BrewEffect(SHELL_ARMOR, 2500, 0));

		SPIDER_NIGHTMARE = BrewRegistry.registerBrew(new SpiderNightmareBrew());
		BrewRegistry.addDefault(SPLASH, new BrewEffect(SPIDER_NIGHTMARE, 500, 0));
		BrewRegistry.addDefault(LINGER, new BrewEffect(SPIDER_NIGHTMARE, 1000, 0));

		EXTINGUISH = BrewRegistry.registerBrew(new ExtinguishBrew());
		BrewRegistry.addDefault(SPLASH, new BrewEffect(EXTINGUISH, 0, 0));

		MARS_WATER = BrewRegistry.registerBrew(new MarsWaterBrew());

		FROSTBITE = BrewRegistry.registerBrew(new FrostbiteBrew());
		BrewRegistry.addDefault(SPLASH, new BrewEffect(FROSTBITE, 500, 0));

		HOLY_WATER = BrewRegistry.registerBrew(new HolyWaterBrew());
		BrewRegistry.addDefault(SPLASH, new BrewEffect(HOLY_WATER, 200, 0));
		BrewRegistry.addDefault(LINGER, new BrewEffect(HOLY_WATER, 50, 0));

		VOLATILE = BrewRegistry.registerBrew(new VolatileBrew());
		BrewRegistry.addDefault(SPLASH, new BrewEffect(VOLATILE, 500, 0));
		BrewRegistry.addDefault(LINGER, new BrewEffect(VOLATILE, 100, 0));
	}
}
