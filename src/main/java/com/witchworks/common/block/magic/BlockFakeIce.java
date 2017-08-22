package com.witchworks.common.block.magic;

import com.witchworks.common.block.BlockMod;
import com.witchworks.common.lib.LibBlockName;
import net.minecraft.block.SoundType;
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
public class BlockFakeIce extends BlockMod {

	public BlockFakeIce() {
		super(LibBlockName.FAKE_ICE, Material.ICE);
		setSound(SoundType.SNOW);
		setResistance(2F);
		setHardness(2F);
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

	@SuppressWarnings("deprecation")
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
}
