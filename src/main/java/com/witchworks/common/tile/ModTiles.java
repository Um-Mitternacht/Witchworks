package com.witchworks.common.tile;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class was created by Arekkuusu on 09/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class ModTiles {

	private static final String KETTLE = "cauldron";
	private static final String CANDLE = "candle";
	private static final String APIARY = "apiary";

	private ModTiles() {
	}

	public static void registerAll() {

		GameRegistry.registerTileEntity(TileCauldron.class, KETTLE);
		GameRegistry.registerTileEntity(TileCandle.class, CANDLE);
		GameRegistry.registerTileEntity(TileApiary.class, APIARY);
	}
}
