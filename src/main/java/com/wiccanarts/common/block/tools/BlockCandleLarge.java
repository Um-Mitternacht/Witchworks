package com.wiccanarts.common.block.tools;

import com.wiccanarts.api.item.*;
import com.wiccanarts.client.handler.*;
import com.wiccanarts.common.lib.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.relauncher.*;

import java.util.*;

/**
 * Created by Joseph on 3/4/2017.
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
