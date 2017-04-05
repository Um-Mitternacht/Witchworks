package com.wiccanarts.common.block.tile;

import com.wiccanarts.common.lib.LibBlockName;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class was created by Arekkuusu on 09/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ModTiles {

	private ModTiles () {
	}

	public static void registerAll () {

		GameRegistry.registerTileEntity (TileKettle.class, LibBlockName.KETTLE);
	}
}
