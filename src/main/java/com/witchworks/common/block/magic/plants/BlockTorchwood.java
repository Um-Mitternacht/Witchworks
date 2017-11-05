package com.witchworks.common.block.magic.plants;

import com.witchworks.common.block.BlockMod;
import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.lib.LibBlockName;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Joseph on 11/4/2017.
 */
public class BlockTorchwood extends BlockMod implements IGrowable {

	public BlockTorchwood() {
		super(LibBlockName.TORCHWOOD, Material.WOOD);
		setResistance(3F);
		setHardness(3F);
		this.setLightLevel(0.7F);
		setCreativeTab(WitchWorksCreativeTabs.BLOCKS_CREATIVE_TAB);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return false;
	}

	public boolean canSustainBush(IBlockState state) {
		return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.STONE || state.getBlock() == Blocks.FARMLAND || state.getBlock() == this;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos.down());
		return canSustainBush(state);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		if (rand.nextInt(42) == 0) {
			worldIn.setBlockState(pos, getDefaultState());
		} else {
			trySpread(worldIn, pos, rand);
		}
	}

	private void trySpread(World world, BlockPos center, Random rand) {
		BlockPos I = center.add(-1, -1, -1);
		BlockPos F = center.add(1, 1, 1);
		BlockPos.getAllInBox(I, F).forEach(
				pos -> {
					if (rand.nextBoolean() && canSustainBush(world.getBlockState(pos.down()))
							&& (world.isAirBlock(pos) || world.getBlockState(pos).getBlock().isReplaceable(world, pos))) {
						world.setBlockState(pos, getDefaultState(), 2);
					}
				}
		);
	}

	@Override
	public Block.EnumOffsetType getOffsetType()
	{
		return Block.EnumOffsetType.XYZ;
	}


	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

	}
}
