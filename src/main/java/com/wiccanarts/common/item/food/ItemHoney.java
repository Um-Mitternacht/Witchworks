package com.wiccanarts.common.item.food;

import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.init.MobEffects;

/**
 * Created by Joseph on 3/4/2017.
 */
public class ItemHoney extends ItemCrop {

	public ItemHoney() {
		super(LibItemName.HONEY, 2, 0.5F, false);
		addPotion(MobEffects.HASTE, MobEffects.LUCK);
	}
}
