package com.witchworks.common.item.food;

import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemGinger extends ItemCrop {

	public ItemGinger() {
		super(LibItemName.GINGER, 4, 0.8F, false);
		setCreativeTab(WitchWorksCreativeTabs.PLANTS_CREATIVE_TAB);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		player.setFire(10);
	}
}
