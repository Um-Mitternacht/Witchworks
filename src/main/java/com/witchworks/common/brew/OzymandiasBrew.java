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
public class OzymandiasBrew extends BlockHitBrew {

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
		return 0x16161D;
	}

	@Override
	public String getName() {
		return "ozymandias";
	}

	@SuppressWarnings("deprecation")
	@Override
	public void safeImpact(BlockPos pos, @Nullable EnumFacing side, World world, int amplifier) {
		int box = 1 + (int) ((float) amplifier / 2F);

		BlockPos posI = pos.add(box, box, box);
		BlockPos posF = pos.add(-box, -box, -box);

		Iterable<BlockPos> spots = BlockPos.getAllInBox(posI, posF);
		for (BlockPos spot : spots) {
			IBlockState state = world.getBlockState(spot);
			boolean place = amplifier > 2 || world.rand.nextBoolean();
			if (place && state.getBlock() == Blocks.COBBLESTONE_WALL && world.isAirBlock(spot.up())) {
				world.setBlockState(spot, Blocks.COBBLESTONE_WALL.getStateFromMeta(1), 3);
			} else if (state.getBlock() == Blocks.COBBLESTONE) {
				world.setBlockState(spot, Blocks.MOSSY_COBBLESTONE.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.TALLGRASS) {
				world.setBlockState(spot, Blocks.DEADBUSH.getDefaultState(), 3);
			} else if (state.getBlock() == Blocks.STONEBRICK) {
				world.setBlockState(spot, Blocks.STONEBRICK.getStateFromMeta(1), 3);
			} else if (state.getBlock() == Blocks.GRASS) {
				world.setBlockState(spot, Blocks.SAND.getDefaultState(), 3);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc, int amplifier) {
		render(x, y, mc, 3);
	}
}