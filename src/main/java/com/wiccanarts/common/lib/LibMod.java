package com.wiccanarts.common.lib;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class LibMod {

	//ID for MOD
	public static final String MOD_ID = "wiccanarts";

	//Name of MOD
	public static final String MOD_NAME = "WiccanArts";

	//Version of MOD
	public static final String MOD_VER = "@VERSION@";

	//Dependency
	public static final String DEPENDENCIES = "required-after:Forge@[12.18.3.2234,];required-after:JEI@[3.14.7.415,];required-after:Waila@[1.8.10-B24_1.10.2,];required-after:llibrary@[1.7.4,];required-after:Baubles@[1.3.9,]";

	//Client proxy location
	public static final String PROXY_CLIENT = "com.wiccanarts.client.core.ClientProxy";

	//Server proxy location
	public static final String PROXY_COMMON = "com.wiccanarts.common.core.proxy.ServerProxy";

	private LibMod() {
	}
}
