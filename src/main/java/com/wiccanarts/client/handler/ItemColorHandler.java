package com.wiccanarts.client.handler;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

/**
 * This class was created by Arekkuusu on 11/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemColorHandler implements IItemColor {

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex) {
		int color = 0;
		switch (stack.getMetadata()) {
			case 0:
				color = 15658734;
				break;
			case 1:
				color = 16758062;
				break;
			case 2:
				color = 16594685;
				break;
			case 3:
				color = 11393254;
				break;
			case 4:
				color = 16777042;
				break;
			case 5:
				color = 5634389;
				break;
			case 6:
				color = 16766429;
				break;
			case 7:
				color = 12237498;
				break;
			case 8:
				color = 14671839;
				break;
			case 9:
				color = 6291455;
				break;
			case 10:
				color = 11665586;
				break;
			case 11:
				color = 7105791;
				break;
			case 12:
				color = 8606770;
				break;
			case 13:
				color = 48896;
				break;
			case 14:
				color = 16730184;
				break;
			case 15:
				color = 3223857;
				break;
		}
		return color;
	}
}
