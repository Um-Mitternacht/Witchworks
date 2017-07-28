package com.witchworks.common.item.food;

import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * This class was created by Joseph on 02/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemHeart extends ItemModFood {

	public ItemHeart() {
		super(LibItemName.HEART, 8, 1.2F, true);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 750, 2));
		player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 750, 2));
	}
}
