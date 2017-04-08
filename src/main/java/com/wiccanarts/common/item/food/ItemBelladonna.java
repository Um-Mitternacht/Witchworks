package com.wiccanarts.common.item.food;

import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.init.MobEffects;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemBelladonna extends ItemCrop {

	public ItemBelladonna () {
		super (LibItemName.BELLADONNA, 6, 1.5F, false);
		addPotion (MobEffects.WITHER, MobEffects.NAUSEA);
	}
}
