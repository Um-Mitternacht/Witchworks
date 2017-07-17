package com.witchworks.common.core.command;

import java.util.HashMap;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 19/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class ModCommands {

	static final Map<String, IIncantation> commands = new HashMap<>();

	private ModCommands() {
	}

	public static void init() {
		addIncantation("medico", new IncantationHeal());
		addIncantation("lux", new IncantationCandlelight());
	}

	private static void addIncantation(String name, IIncantation incantation) {
		commands.put(name, incantation);
	}
}
