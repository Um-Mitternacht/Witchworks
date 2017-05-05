package com.witchworks.api.recipe;

import com.google.common.collect.ImmutableList;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public interface IKettleRecipe {

	boolean checkRecipe(IItemHandler usedItems, World world);

	ImmutableList<Object> getNeededItems();

	ItemStack getResult();
}
