package com.witchworks.api.ritual;

import java.util.ArrayList;
import java.util.List;

/**
 * This class was created by Arekkuusu on 06/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class RitualRegistry {

	private static final List<IRitual> RITUALS = new ArrayList<>();

	public static void register(IRitual ritual) {
		RITUALS.add(ritual);
	}

	public static boolean isRegistered(IRitual ritual) {
		return RITUALS.contains(ritual);
	}

	public static List<IRitual> getRituals() {
		return RITUALS;
	}
}
