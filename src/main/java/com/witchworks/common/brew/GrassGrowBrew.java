package com.witchworks.common.brew;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 11/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class GrassGrowBrew extends BlockHitBrew {

	@Override
	public int getColor() {
		return 0x4CBB17;
	}

	@Override
	public String getName() {
		return "growth";
	}

	@Override
	public void safeImpact(BlockPos pos, @Nullable EnumFacing side, World world, int amplifier) {
		int box = 1 + (int) ((float) amplifier / 2F);

		BlockPos posI = pos.add(box, box, box);
		BlockPos posF = pos.add(-box, -box, -box);

		Iterable<BlockPos> spots = BlockPos.getAllInBox(posI, posF);
		for (BlockPos spot : spots) {
			IBlockState state = world.getBlockState(spot);
			boolean place = amplifier > 2 || world.rand.nextBoolean();
			if (place && state.getBlock() == Blocks.MYCELIUM && world.isAirBlock(spot.up())) {
				world.setBlockState(spot, Blocks.GRASS.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.DIRT) {
				world.setBlockState(spot, Blocks.GRASS.getDefaultState(), 3);
			}
		}
	}
}
