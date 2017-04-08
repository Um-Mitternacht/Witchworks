package com.wiccanarts.common.block.tools;

import com.wiccanarts.api.item.IModelRegister;
import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.common.lib.LibBlockName;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BlockCandleLarge extends BlockCandle implements IModelRegister {

	private static final AxisAlignedBB LARGE_BOX = new AxisAlignedBB (0.25, 0, 0.25, 0.75, 1, 0.75);

	public BlockCandleLarge () {
		super (LibBlockName.CANDLE_LARGE);
	}

	@SuppressWarnings ("deprecation")
	@Override
	public AxisAlignedBB getBoundingBox (IBlockState state, IBlockAccess source, BlockPos pos) {
		return LARGE_BOX;
	}

	@Override
	public void getSubBlocks (Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for (int i = 0; i < 16; i++) {
			list.add (new ItemStack (itemIn, 1, i));
		}
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels () {
		for (int i = 0; i < 16; i++) {
			ModelHandler.registerBlock (this, i);
		}
	}
}
