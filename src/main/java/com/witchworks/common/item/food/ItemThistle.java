package com.witchworks.common.item.food;

import com.witchworks.common.lib.LibItemName;
import net.minecraft.init.MobEffects;

/**
 * This class was created by Joseph on 02/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemThistle extends ItemCrop {

	public ItemThistle() {
		super(LibItemName.THISTLE, 4, 0.8F, false);
		addPotion(MobEffects.STRENGTH);
	}
}
