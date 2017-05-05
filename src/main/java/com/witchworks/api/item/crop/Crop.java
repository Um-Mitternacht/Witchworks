package com.witchworks.api.item.crop;

import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.block.natural.crop.BlockCrop;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

/**
 * This class was created by Arekkuusu on 28/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public enum Crop {
	ACONITUM(Blocks.FARMLAND, ModBlocks.CROP_ACONITUM),
	ASPHODEL(Blocks.FARMLAND, ModBlocks.CROP_ASPHODEL),
	BELLADONNA(Blocks.FARMLAND, ModBlocks.CROP_BELLADONNA),
	GINGER(Blocks.FARMLAND, ModBlocks.CROP_GINGER),
	KELP(Blocks.WATER, ModBlocks.CROP_KELP),
	MINT(Blocks.FARMLAND, ModBlocks.CROP_MINT),
	WHITE_SAGE(Blocks.FARMLAND, ModBlocks.CROP_WHITE_SAGE),
	MANDRAKE_ROOT(Blocks.FARMLAND, ModBlocks.CROP_MANDRAKE_ROOT),
	LAVENDER(Blocks.FARMLAND, ModBlocks.CROP_LAVENDER),
	THISTLE(Blocks.FARMLAND, ModBlocks.CROP_THISTLE),
	TULSI(Blocks.FARMLAND, ModBlocks.CROP_TULSI),
	KENAF(Blocks.FARMLAND, ModBlocks.CROP_KENAF),
	SILPHIUM(Blocks.FARMLAND, ModBlocks.CROP_SILPHIUM),
	GARLIC(Blocks.FARMLAND, ModBlocks.CROP_GARLIC),
	WORMWOOD(Blocks.FARMLAND, ModBlocks.CROP_WORMWOOD);

	private final Block soil;
	private final BlockCrop placed;

	Crop(Block soil, BlockCrop placed) {
		this.soil = soil;
		this.placed = placed;
	}

	public Block getSoil() {
		return soil;
	}

	public BlockCrop getPlaced() {
		return placed;
	}
}
