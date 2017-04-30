package com.witchworks.client.handler;

import com.witchworks.api.item.NBTHelper;
import com.witchworks.common.potions.BrewUtils;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

/**
 * This class was created by Arekkuusu on 25/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class BrewItemColorHandler implements IItemColor {

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex) {
		if (tintIndex == 1 && NBTHelper.hasTag(stack, BrewUtils.COLOR_TAG)) {
			return NBTHelper.getInteger(stack, BrewUtils.COLOR_TAG);
		}
		return 0xFFFFFF;
	}
}
