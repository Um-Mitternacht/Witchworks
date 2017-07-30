package com.witchworks.common.brew;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class SetehsWastesBrew extends BlockHitBrew {

	@Override
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		//NO-OP
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
		return 0xD2691E;
	}

	@Override
	public String getName() {
		return "setehs_wastes";
	}

	@SuppressWarnings("deprecation")
	@Override
	public void safeImpact(BlockPos pos, @Nullable EnumFacing side, World world, int amplifier) {
		int box = 1 + (int) ((float) amplifier / 2F);

		BlockPos posI = pos.add(box, box, box);
		BlockPos posF = pos.add(-box, -box, -box);

		//Fixme: Get it to respect meta fully, and apply the appropriate changes. Currently, it defaults to red sandstone, even for chiselled and what not.
		Iterable<BlockPos> spots = BlockPos.getAllInBox(posI, posF);
		for (BlockPos spot : spots) {
			IBlockState state = world.getBlockState(spot);
			boolean place = amplifier > 2 || world.rand.nextBoolean();
			if (place && state.getBlock() == Blocks.SAND && world.isAirBlock(spot.up())) {
				world.setBlockState(spot, Blocks.SAND.getStateFromMeta(1), 3);
			} else if (state.getBlock() == Blocks.SANDSTONE) {
				world.setBlockState(spot, Blocks.RED_SANDSTONE.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.SANDSTONE_STAIRS) {
				world.setBlockState(spot, Blocks.RED_SANDSTONE_STAIRS.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.STONE_SLAB.getStateFromMeta(1)) {
				world.setBlockState(spot, Blocks.STONE_SLAB2.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.STONE_SLAB.getStateFromMeta(9)) {
				world.setBlockState(spot, Blocks.STONE_SLAB2.getStateFromMeta(8), 3);
			} else if (state.getBlock() == Blocks.SANDSTONE.getStateFromMeta(1)) {
				world.setBlockState(spot, Blocks.RED_SANDSTONE.getStateFromMeta(1), 3);
			} else if (state.getBlock() == Blocks.SANDSTONE.getStateFromMeta(2)) {
				world.setBlockState(spot, Blocks.RED_SANDSTONE.getStateFromMeta(2), 3);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc, int amplifier) {
		render(x, y, mc, 3);
	}
}