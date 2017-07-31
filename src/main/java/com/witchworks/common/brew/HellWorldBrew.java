package com.witchworks.common.brew;

import com.witchworks.common.block.ModBlocks;
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
public class HellWorldBrew extends BlockHitBrew {

	@Override
	public int getColor() {
		return 0xED2939;
	}

	@Override
	public String getName() {
		return "hell_world";
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
			if (place && state.getBlock() == Blocks.GRASS_PATH && world.isAirBlock(spot.up())) {
				world.setBlockState(spot, Blocks.RED_NETHER_BRICK.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.GRAVEL) {
				world.setBlockState(spot, Blocks.SOUL_SAND.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.COBBLESTONE) {
				world.setBlockState(spot, Blocks.NETHERRACK.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.PLANKS) {
				world.setBlockState(spot, Blocks.NETHER_BRICK.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.OAK_STAIRS) {
				world.setBlockState(spot, Blocks.NETHER_BRICK_STAIRS.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.LOG) {
				world.setBlockState(spot, ModBlocks.nethersteel.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.STONE_STAIRS) {
				world.setBlockState(spot, Blocks.NETHER_BRICK_STAIRS.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.OAK_FENCE) {
				world.setBlockState(spot, Blocks.NETHER_BRICK_FENCE.getDefaultState(), 3);
			}
		}
	}
}
