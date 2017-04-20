package com.wiccanarts.common.core.command;

import java.util.HashMap;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 19/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ModCommands {

	static final Map<String, IIncantation> commands = new HashMap<>();

	private ModCommands() {
	}

	public static void init() {
		addIncantation("heal", new IncantationHeal());
		addIncantation("burn", new IncantationBurn());
	}

	private static void addIncantation(String name, IIncantation incantation) {
		commands.put(name, incantation);
	}
}
