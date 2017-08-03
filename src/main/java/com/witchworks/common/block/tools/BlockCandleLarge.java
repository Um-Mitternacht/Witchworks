package com.witchworks.common.block.tools;

import com.witchworks.common.lib.LibBlockName;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class BlockCandleLarge extends BlockCandle {

	private static final AxisAlignedBB LARGE_BOX = new AxisAlignedBB(0.25, 0, 0.25, 0.75, 1, 0.75);

	public BlockCandleLarge() {
		super(LibBlockName.CANDLE_LARGE);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return LARGE_BOX;
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		items.add(new ItemStack(this));
		items.add(new ItemStack(this, 1, 1));
		items.add(new ItemStack(this, 1, 2));
		items.add(new ItemStack(this, 1, 3));
		items.add(new ItemStack(this, 1, 4));
		items.add(new ItemStack(this, 1, 5));
		items.add(new ItemStack(this, 1, 6));
		items.add(new ItemStack(this, 1, 7));
		items.add(new ItemStack(this, 1, 8));
		items.add(new ItemStack(this, 1, 9));
		items.add(new ItemStack(this, 1, 10));
		items.add(new ItemStack(this, 1, 11));
		items.add(new ItemStack(this, 1, 12));
		items.add(new ItemStack(this, 1, 13));
		items.add(new ItemStack(this, 1, 14));
		items.add(new ItemStack(this, 1, 15));
	}

	@Override
	public int getType() {
		return 2;
	}
}
