package com.wiccanarts.common.achievement;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * Created by Joseph on 4/17/2017. Original code by Vazkii, from Botania.
 */

public interface ICraftAchievement {

	public Achievement getAchievementOnCraft(ItemStack stack, EntityPlayer player, IInventory matrix);
}
