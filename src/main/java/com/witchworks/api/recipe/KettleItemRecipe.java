package com.witchworks.api.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 04/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class KettleItemRecipe extends KettleRecipe {

	public KettleItemRecipe(ItemStack result, Object... inputs) {
		super(result, inputs);
	}

	public boolean performRitual(World world, BlockPos pos) {
		return true;
	}
}
