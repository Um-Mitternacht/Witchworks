package com.wiccanarts.common.block.crop;

import com.wiccanarts.common.lib.LibBlockName;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BlockKelp extends BlockCrop {

	public BlockKelp() {
		super(LibBlockName.CROP_KELP);
	}

	@Override
	protected boolean canSustainBush(IBlockState state) {
		return state.getBlock() == Blocks.WATER;
	}
}
