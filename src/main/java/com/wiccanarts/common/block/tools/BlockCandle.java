package com.wiccanarts.common.block.tools;

import com.wiccanarts.common.block.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import static com.wiccanarts.api.state.WiccanArtsState.*;

/**
 * This class was created by Arekkuusu on 11/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BlockCandle extends BlockMod {

	public BlockCandle (String id) {
		super (id, Material.CLOTH);
		setSound (SoundType.CLOTH);
	}

	@Override
	protected IBlockState defaultState () {
		return super.defaultState ().withProperty (COLOR, EnumDyeColor.WHITE);
	}

	@Override
	public int damageDropped (IBlockState state) {
		return getMetaFromState (state);
	}

	@Override
	public BlockStateContainer createBlockState () {
		return new BlockStateContainer (this, COLOR);
	}

	@SuppressWarnings ("deprecation")
	public MapColor getMapColor (IBlockState state) {
		return state.getValue (COLOR).getMapColor ();
	}

	@Override
	public int getMetaFromState (IBlockState state) {
		return state.getValue (COLOR).getMetadata ();
	}

	@SuppressWarnings ("deprecation")
	@Override
	public IBlockState getStateFromMeta (int meta) {
		if (meta >= EnumDyeColor.values ().length) {
			meta = 0;
		}
		return getDefaultState ().withProperty (COLOR, EnumDyeColor.byMetadata (meta));
	}

	@Override
	public IBlockState getStateForPlacement (World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, ItemStack stack) {
		return getDefaultState ().withProperty (COLOR, EnumDyeColor.byMetadata (meta));
	}

	@Override
	public boolean canPlaceBlockAt (World worldIn, BlockPos pos) {
		return worldIn.getBlockState (
				pos.down ()).isSideSolid (
				worldIn,
				pos.down (),
				EnumFacing.UP
		);
	}

	@SuppressWarnings ("deprecation")
	@Override
	public boolean isFullCube (IBlockState state) {
		return false;
	}

	@SuppressWarnings ("deprecation")
	@Override
	public boolean isOpaqueCube (IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer () {
		return BlockRenderLayer.SOLID;
	}
}
