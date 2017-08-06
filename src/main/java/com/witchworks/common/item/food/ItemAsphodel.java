package com.witchworks.common.item.food;

import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemAsphodel extends ItemCrop {

	public ItemAsphodel() {
		super(LibItemName.ASPHODEL, 2, 0.2F, false);
		setCreativeTab(WitchWorksCreativeTabs.PLANTS_CREATIVE_TAB);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.UNLUCK, 10, 0));
	}
}
