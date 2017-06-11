package com.witchworks.api;

import com.google.common.collect.Maps;
import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.IBrew;
import com.witchworks.common.item.ModItems;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 22/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class BrewRegistry {

	private static final List<IBrew> BREWS = new ArrayList<>();
	private static final Map<Brew, Map<IBrew, BrewEffect>> DEFAULTS = Maps.newLinkedHashMap();

	static {
		DEFAULTS.put(Brew.DRINK, Maps.newLinkedHashMap());
		DEFAULTS.put(Brew.SPLASH, Maps.newLinkedHashMap());
		DEFAULTS.put(Brew.LINGER, Maps.newLinkedHashMap());
	}

	private BrewRegistry() {
	}

	public static IBrew registerBrew(IBrew brew) {
		BREWS.add(brew);
		return brew;
	}

	public static void addDefault(Brew brew, BrewEffect effect) {
		DEFAULTS.get(brew).put(effect.getBrew(), effect);
	}

	public static boolean hasDefault(IBrew brew) {
		for (Brew enu : Brew.values()) {
			if (DEFAULTS.get(enu).containsKey(brew)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasDefault(Brew enu, IBrew brew) {
		return DEFAULTS.get(enu).containsKey(brew);
	}

	public static BrewEffect getDefault(IBrew brew) {
		for (Brew enu : Brew.values()) {
			if (DEFAULTS.get(enu).containsKey(brew)) {
				return DEFAULTS.get(enu).get(brew);
			}
		}
		return new BrewEffect(brew, 0, 0);
	}

	public static BrewEffect getDefault(Brew enu, IBrew brew) {
		return DEFAULTS.get(enu).get(brew);
	}

	public static int getBrewId(IBrew brew) {
		return BREWS.indexOf(brew);
	}

	public static IBrew getBrewById(int id) {
		return BREWS.get(id);
	}

	public static List<IBrew> getBrews() {
		return BREWS;
	}

	public static Map<Brew, Map<IBrew, BrewEffect>> getDefaults() {
		return DEFAULTS;
	}

	public enum Brew {
		DRINK (ModItems.BREW_PHIAL_DRINK),
		SPLASH (ModItems.BREW_PHIAL_SPLASH),
		LINGER (ModItems.BREW_PHIAL_LINGER);

		private final Item item;

		Brew(Item item) {
			this.item = item;
		}

		public Item getItem() {
			return item;
		}

		public static Brew byOrdinal(int ordinal) {
			return values()[ordinal];
		}
	}
}
