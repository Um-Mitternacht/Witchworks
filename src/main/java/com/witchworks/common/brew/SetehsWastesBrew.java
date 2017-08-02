package com.witchworks.common.brew;

import net.minecraft.block.Block;
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
import java.util.HashMap;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class SetehsWastesBrew extends BlockHitBrew {

	private final Map<Block, IBlockState> stateMap = new HashMap<>();

	public SetehsWastesBrew() {
		stateMap.put(Blocks.SAND, Blocks.SAND.getStateFromMeta(1));
		stateMap.put(Blocks.SANDSTONE, Blocks.RED_SANDSTONE.getDefaultState());
		stateMap.put(Blocks.SANDSTONE_STAIRS, Blocks.RED_SANDSTONE_STAIRS.getDefaultState());
	}

	@Override
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		//NO-OP
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
		void safeImpact(BlockPos pos, @Nullable EnumFacing side, World world, int amplifier) {
			int box = 1 + (int) ((float) amplifier / 2F);

			BlockPos posI = pos.add(box, box, box);
			BlockPos posF = pos.add(-box, -box, -box);

			Iterable<BlockPos> spots = BlockPos.getAllInBox(posI, posF);
			for (BlockPos spot : spots) {
				Block block = world.getBlockState(spot).getBlock();
				boolean place = amplifier > 2 || world.rand.nextBoolean();
				if (place && stateMap.containsKey(block)) {
					world.setBlockState(spot, stateMap.get(block), 11);
				}
			}
		}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc, int amplifier) {
	}
}