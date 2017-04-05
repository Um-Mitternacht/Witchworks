package com.wiccanarts.common.item.food;

import com.wiccanarts.common.core.*;
import net.minecraft.item.*;

/**
 * This class was created by Arekkuusu on 28/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemModFood extends ItemFood {

	public ItemModFood (String id, int amount, float saturation, boolean isWolfFood) {
		super (amount, saturation, isWolfFood);
		setRegistryName (id);
		setUnlocalizedName (id);
		setCreativeTab (WiccanArtsCreativeTabs.ITEMS_CREATIVE_TAB);
	}
}
