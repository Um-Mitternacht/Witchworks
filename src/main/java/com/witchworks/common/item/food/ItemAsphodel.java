package com.witchworks.common.item.food;

import com.witchworks.common.lib.LibItemName;
import net.minecraft.init.MobEffects;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemAsphodel extends ItemCrop {

	public ItemAsphodel() {
		super(LibItemName.ASPHODEL, 4, 0.2F, false);
		addPotion(MobEffects.STRENGTH, MobEffects.UNLUCK);
	}
}
