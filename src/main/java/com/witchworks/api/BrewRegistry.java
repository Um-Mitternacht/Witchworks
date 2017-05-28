package com.witchworks.api;

import com.witchworks.api.item.BrewEffect;
import com.witchworks.api.item.IBrew;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 22/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
public final class BrewRegistry {

	private static final List<IBrew> brews = new ArrayList<>();
	private static final Map<IBrew, BrewEffect> defaults = new LinkedHashMap<>();

	private BrewRegistry() {
	}

	public static IBrew registerBrew(IBrew brew) {
		brews.add(brew);
		return brew;
	}

	public static void addDefault(BrewEffect effect) {
		defaults.put(effect.getBrew(), effect);
	}

	public static BrewEffect getDefault(IBrew brew) {
		return defaults.get(brew);
	}

	public static int getBrewId(IBrew brew) {
		return brews.indexOf(brew);
	}

	public static IBrew getBrewById(int id) {
		return brews.get(id);
	}

	public static List<IBrew> getBrews() {
		return brews;
	}

	public static Map<IBrew, BrewEffect> getDefaults() {
		return defaults;
	}

	public enum Brew {
		DRINK,
		SPLASH,
		LINGER;

		public static Brew byOrdinal(int ordinal) {
			return values()[ordinal];
		}
	}
}
