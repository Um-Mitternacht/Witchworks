package com.wiccanarts.common.item.misc;

import com.wiccanarts.common.achievement.*;
import com.wiccanarts.common.item.ItemMod;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * Created by Joseph on 4/17/2017.
 */
public class ItemMalachite extends ItemMod {

	public ItemMalachite() {
		super(LibItemName.MALACHITE);
	}

	public Achievement getAchievementOnCraft(ItemStack stack, EntityPlayer player, IInventory matrix) {
		return ModAchievements.malachiteCraft;
	}
}
