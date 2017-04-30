package com.witchworks.common.crafting.kettle;

import com.google.common.collect.ImmutableList;
import com.witchworks.api.recipe.IKettleRecipe;
import com.witchworks.common.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.oredict.OreDictionary;

/**
 * This class was created by Arekkuusu on 15/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
class HoneyKettleCrafting implements IKettleRecipe {

	private final ImmutableList<Object> needed = ImmutableList.of(new ItemStack(ModItems.HONEYCOMB));

	@Override
	public boolean checkRecipe(IItemHandler usedItems, World world) {
		int count = 0;
		for (int i = 0, size = usedItems.getSlots(); i < size; i++) {
			final ItemStack stack = usedItems.extractItem(i, 1, true);
			if (stack != null) {
				if (OreDictionary.itemMatches((ItemStack) needed.get(0), stack, true)) {
					++count;
				} else {
					return false;
				}
			} else {
				break;
			}
		}

		return count > 0;
	}

	@Override
	public boolean canTake(World world, EntityPlayer player, ItemStack stack) {
		return stack.getItem() == ModItems.GLASS_JAR;
	}

	@Override
	public boolean isLiquid() {
		return true;
	}

	@Override
	public int getDrain() {
		return 6;
	}

	@Override
	public ImmutableList<Object> getNeededItems() {
		return needed;
	}

	@Override
	public ItemStack getResult() {
		return new ItemStack(ModItems.HONEY);
	}
}
