package com.wiccanarts.common.item.food;

import com.wiccanarts.common.item.ItemMod;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Joseph on 3/4/2017.
 */
public class ItemHoney extends ItemFood {

	public ItemHoney(EntityPlayer player, ItemStack stack) {
		super(LibItemName.HONEY, 2, 4F, false);
		player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 50, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 50, 0));
	}
}
