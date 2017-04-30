package com.witchworks.common.item;

import com.witchworks.common.core.achievement.ICraftAchievement;
import com.witchworks.common.core.achievement.ModAchievements;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * This class was created by Joseph on 4/17/2017.
 * It's distributed as part of Witchworks under
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
