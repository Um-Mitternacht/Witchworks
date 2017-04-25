package com.witchworks.common.core.achievement;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * Original code by Vazkii, from Botania.
 */

public interface IPickupAchievement {

	Achievement getAchievementOnPickup(ItemStack stack, EntityPlayer player, EntityItem item);
}