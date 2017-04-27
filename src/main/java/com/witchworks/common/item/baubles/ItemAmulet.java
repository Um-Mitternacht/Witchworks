package com.witchworks.common.item.baubles;

import baubles.api.BaubleType;
import net.minecraft.item.ItemStack;

/**
 * This class was created by BerciTheBeast on 21.4.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemAmulet extends ItemBauble {

	public ItemAmulet(String id) {
		super(id);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.AMULET;
	}
}
