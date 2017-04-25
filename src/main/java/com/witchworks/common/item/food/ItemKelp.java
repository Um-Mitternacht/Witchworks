package com.witchworks.common.item.food;

import com.witchworks.common.lib.LibItemName;
import net.minecraft.init.MobEffects;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemKelp extends ItemCrop {

	public ItemKelp() {
		super(LibItemName.KELP, 3, 0.8F, false);
		addPotion(MobEffects.WATER_BREATHING, MobEffects.LUCK);
	}
}
