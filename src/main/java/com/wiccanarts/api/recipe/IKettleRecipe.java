package com.wiccanarts.api.recipe;

import com.google.common.collect.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.items.*;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public interface IKettleRecipe {

	boolean checkRecipe (IItemHandler usedItems, World world);

	boolean canTake (World world, EntityPlayer player, ItemStack stack);

	ImmutableList<Object> getNeededItems ();

	ItemStack getResult ();
}
