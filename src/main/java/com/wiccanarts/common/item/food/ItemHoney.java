package com.wiccanarts.common.item.food;

import com.wiccanarts.common.lib.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.world.*;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemHoney extends ItemModFood {

	public ItemHoney () {
		super (LibItemName.HONEY, 2, 4F, false);
	}

	@Override
	protected void onFoodEaten (ItemStack stack, World worldIn, EntityPlayer player) {
		player.addPotionEffect (new PotionEffect (MobEffects.HASTE, 50, 0));
		player.addPotionEffect (new PotionEffect (MobEffects.LUCK, 50, 0));
	}
}
