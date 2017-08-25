package com.witchworks.common.block.magic;

import com.witchworks.common.block.BlockMod;
import com.witchworks.common.lib.LibBlockName;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class BlockFakeIceFence extends BlockMod {

	@SuppressWarnings("deprecation")
	public BlockFakeIceFence() {
		super(LibBlockName.FAKE_ICE_FENCE, Material.ICE);
		setResistance(2F);
		setHardness(2F);
		slipperiness = 0.98F;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
}
