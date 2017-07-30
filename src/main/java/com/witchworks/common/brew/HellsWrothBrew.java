package com.witchworks.common.brew;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 12/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class HellsWrothBrew extends BlockHitBrew {

	@Override
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		//NO-OP
	}

	@Override
	public void onFinish(World world, BlockPos pos, EntityLivingBase entity, int amplifier) {
		int box = 1 + amplifier;

		BlockPos posI = pos.add(box, box, box);
		BlockPos posF = pos.add(-box, -box, -box);
		BlockPos.getAllInBox(posI, posF).forEach(
				pos1 -> {
					if (world.getBlockState(pos1).getBlock() == Blocks.AIR)
						world.setBlockState(pos1, Blocks.MAGMA.getDefaultState());
				}
		);
	}

	@Override
	public boolean isBad() {
		return true;
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public int getColor() {
		return 0xE0115F;
	}

	@Override
	public String getName() {
		return "hells_wroth";
	}

	@Override
	void safeImpact(BlockPos pos, @Nullable EnumFacing side, World world, int amplifier) {
		int box = 1 + (int) ((float) amplifier / 2F);

		BlockPos posI = pos.add(box, box, box);
		BlockPos posF = pos.add(-box, -box, -box);

		Iterable<BlockPos> spots = BlockPos.getAllInBox(posI, posF);
		for (BlockPos spot : spots) {
			IBlockState state = world.getBlockState(spot);
			boolean place = amplifier > 2 || world.rand.nextInt(3) == 0;
			if (place) {
				if (state.getBlock() == Blocks.SNOW) {
					world.setBlockState(spot, Blocks.SOUL_SAND.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.PACKED_ICE) {
					world.setBlockState(spot, Blocks.NETHERRACK.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.FROSTED_ICE) {
					world.setBlockState(spot, Blocks.MAGMA.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.ICE) {
					world.setBlockState(spot, Blocks.MAGMA.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.SAND) {
					world.setBlockState(spot, Blocks.SOUL_SAND.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.STONE) {
					world.setBlockState(spot, Blocks.NETHERRACK.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.GRASS) {
					world.setBlockState(spot, Blocks.NETHERRACK.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.MYCELIUM) {
					world.setBlockState(spot, Blocks.NETHERRACK.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.MAGMA) {
					world.setBlockState(spot, Blocks.OBSIDIAN.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.WATER) {
					world.setBlockState(spot, Blocks.COBBLESTONE.getDefaultState(), 3);
				} else if (state.getBlock() == Blocks.FLOWING_WATER) {
					world.setBlockState(spot, Blocks.COBBLESTONE.getDefaultState(), 3);
				}
			}
		}
	}
}
