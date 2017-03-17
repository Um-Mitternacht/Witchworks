package com.wiccanarts.api.item.crop;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

/**
 * This class was created by Arekkuusu on 28/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings("unused")
public enum Crop {
	ACONITUM(Blocks.FARMLAND),
	ASPHODEL(Blocks.FARMLAND),
	BELLADONNA(Blocks.FARMLAND),
	GINGER(Blocks.FARMLAND),
	KELP(Blocks.WATER),
	MINT(Blocks.FARMLAND),
	WHITE_SAGE(Blocks.FARMLAND),
	DANDELION_ROOT(Blocks.FARMLAND),
	ALLIUM(Blocks.FARMLAND),
	MANDRAKE_ROOT(Blocks.FARMLAND),
	LILAC(Blocks.FARMLAND),
	LAVENDER(Blocks.FARMLAND);

	private final Block soil;

	Crop(Block soil) {
		this.soil = soil;
	}

	public Block getSoil() {
		return soil;
	}
}
