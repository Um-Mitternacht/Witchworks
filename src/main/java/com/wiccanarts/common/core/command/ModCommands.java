package com.wiccanarts.common.core.command;

import java.util.HashMap;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 19/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ModCommands {

	static final Map<String, IIncarnation> commands = new HashMap<>();

	private ModCommands() {
	}

	public static void init() {
		addIncarnation("heal", new IncarnationHeal());
		addIncarnation("burn", new IncarnationBurn());
	}

	private static void addIncarnation(String name, IIncarnation incarnation) {
		commands.put(name, incarnation);
	}
}
