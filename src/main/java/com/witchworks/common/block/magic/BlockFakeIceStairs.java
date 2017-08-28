package com.witchworks.common.block.magic;

import com.witchworks.common.lib.LibBlockName;
import com.witchworks.common.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class BlockFakeIceStairs extends BlockStairs {

	@SuppressWarnings("deprecation")
	public BlockFakeIceStairs(String unlocalizedName, IBlockState state) {
		super(state);
		setUnlocalizedName(LibBlockName.FAKE_ICE_STAIRS);
		setRegistryName(new ResourceLocation(LibMod.MOD_ID, unlocalizedName));
		useNeighborBrightness = true;
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

	@SuppressWarnings("deprecation")
	@Override
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		IBlockState sideState = world.getBlockState(pos.offset(side));
		Block block = sideState.getBlock();
		return block == this ? false : super.shouldSideBeRendered(state, world, pos, side);
	}
}
