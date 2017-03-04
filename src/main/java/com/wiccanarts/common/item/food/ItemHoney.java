package com.wiccanarts.common.item.food;

import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Joseph on 3/4/2017.
 */
public class ItemHoney extends ItemCrop {

	public ItemHoney() {
		super(LibItemName.HONEY, 4, 0.8F, false);
		addPotion(MobEffects.HASTE);
	}
}
