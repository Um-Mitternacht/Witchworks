package com.wiccanarts.api.recipe;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 04/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class KettleFluidRecipe extends KettleRecipe {

	private final Item item;

	public KettleFluidRecipe (Item item, ItemStack result, Object... inputs) {
		super (result, inputs);
		this.item = item;
	}

	@Override
	public boolean canTake (World world, EntityPlayer player, ItemStack stack) {
		return stack.getItem () == item;
	}
}
