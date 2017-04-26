package com.witchworks.client.handler;

import com.witchworks.api.state.WitchWorksState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 11/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BlockCandleColorHandler implements IBlockColor {

	@Override
	public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) {
		int color = 0;
		switch (state.getValue(WitchWorksState.COLOR).getMetadata()) {
			case 0:
				color = 15987957;
				break;
			case 1:
				color = 16087062;
				break;
			case 2:
				color = 11745961;
				break;
			case 3:
				color = 3847130;
				break;
			case 4:
				color = 16435754;
				break;
			case 5:
				color = 8834086;
				break;
			case 6:
				color = 16030389;
				break;
			case 7:
				color = 4673362;
				break;
			case 8:
				color = 9737358;
				break;
			case 9:
				color = 1413268;
				break;
			case 10:
				color = 8400048;
				break;
			case 11:
				color = 2895503;
				break;
			case 12:
				color = 8606770;
				break;
			case 13:
				color = 6653465;
				break;
			case 14:
				color = 10955043;
				break;
			case 15:
				color = 1184535;
				break;
			default:
				break;
		}
		return color;
	}
}
