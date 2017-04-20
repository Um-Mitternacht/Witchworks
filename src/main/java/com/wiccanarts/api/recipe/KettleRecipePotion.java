package com.wiccanarts.api.recipe;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 04/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class KettleRecipePotion extends KettleRecipe {

	public KettleRecipePotion(ItemStack result, Object... inputs) {
		super(result, inputs);
	}

	@Override
	public boolean canTake(World world, EntityPlayer player, ItemStack stack) {
		return stack.getItem() == Items.GLASS_BOTTLE;
	}

	@Override
	public boolean isLiquid() {
		return true;
	}
}
