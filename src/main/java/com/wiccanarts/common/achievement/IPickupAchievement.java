package com.wiccanarts.common.achievement;

/**
 * Created by Joseph on 4/17/2017. Original code by Vazkii, from Botania.
 */
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public interface IPickupAchievement {

	public Achievement getAchievementOnPickup(ItemStack stack, EntityPlayer player, EntityItem item);

}