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
public class BlockCandleSmall extends BlockCandle {

	private static final AxisAlignedBB SMALL_BOX = new AxisAlignedBB(0.38, 0, 0.38, 0.62, 0.5, 0.62);

	public BlockCandleSmall() {
		super(LibBlockName.CANDLE_SMALL);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SMALL_BOX;
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
}
