package com.wiccanarts.common.item.food;

import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.init.MobEffects;

/**
 * This class was created by Arekkuusu on 03/07/2017, and modified by Sunconure11 on 03/17/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemThistle extends ItemCrop {

	public ItemThistle() {
		super(LibItemName.THISTLE, 1, 2F, false);
		addPotion(MobEffects.REGENERATION);
	}
}
