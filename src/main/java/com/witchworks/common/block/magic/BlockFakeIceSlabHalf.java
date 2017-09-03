package com.witchworks.common.block.magic;

/**
 * Created by Joseph on 9/3/2017.
 */
public class BlockFakeIceSlabHalf extends BlockFakeIceSlab {

	public BlockFakeIceSlabHalf(String unlocalizedName) {
		super(unlocalizedName);
	}

	@Override
	public boolean isDouble() {
		return false;
	}
}
