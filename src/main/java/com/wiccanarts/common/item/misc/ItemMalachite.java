package com.wiccanarts.common.item.misc;

import com.wiccanarts.common.achievement.ICraftAchievement;
import com.wiccanarts.common.achievement.ModAchievements;
import com.wiccanarts.common.item.ItemMod;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * This class was created by Joseph on 4/17/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemMalachite extends ItemMod implements ICraftAchievement {

	public ItemMalachite() {
		super(LibItemName.MALACHITE);
	}

	@Override
	public Achievement getAchievementOnCraft(ItemStack stack, EntityPlayer player, IInventory matrix) {
		return ModAchievements.craftMalachite;
	}
}
