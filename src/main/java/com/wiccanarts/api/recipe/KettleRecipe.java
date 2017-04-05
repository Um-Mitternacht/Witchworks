package com.wiccanarts.api.recipe;

import com.google.common.collect.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraftforge.items.*;
import net.minecraftforge.oredict.*;

import java.util.*;
import java.util.stream.*;

import static net.minecraftforge.oredict.OreDictionary.*;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class KettleRecipe implements IKettleRecipe {

	private final ItemStack result;
	private final ImmutableList<Object> neededItems;

	public KettleRecipe (ItemStack result, Object... inputs) {
		this.result = result;

		final List<Object> stackedList = Arrays.stream (inputs).map (obj -> {
			if (obj instanceof Item) return new ItemStack ((Item) obj);
			else if (obj instanceof Block) return new ItemStack ((Block) obj);
			else return obj;
		}).collect (Collectors.toList ());

		neededItems = ImmutableList.copyOf (stackedList);
	}

	@Override
	public boolean checkRecipe (IItemHandler usedItems, World world) {
		final List<ItemStack> list = getUsedItems (usedItems);
		if (list.size () == neededItems.size ()) {
			boolean matches = true;
			for (int i = 0; i < list.size (); i++) {
				final Object needed = neededItems.get (i);
				final ItemStack used = list.get (i);
				if (needed instanceof ItemStack && ! ItemStack.areItemStacksEqual (used, (ItemStack) needed)) {
					matches = false;
					break;
				} else if (needed instanceof String && ! containsMatch (OreDictionary.getOres ((String) needed), used)) {
					matches = false;
					break;
				}
			}
			return matches;
		}
		return false;
	}

	@Override
	public boolean canTake (World world, EntityPlayer player, ItemStack stack) {
		return false;
	}

	private List<ItemStack> getUsedItems (IItemHandler handler) {
		final List<ItemStack> used = new ArrayList<> ();
		for (int i = 0; i < handler.getSlots (); i++) {
			final ItemStack stack = handler.extractItem (i, 1, true);
			if (stack != null) {
				used.add (stack);
			} else {
				break;
			}
		}
		return used;
	}

	private boolean containsMatch (List<ItemStack> inputs, ItemStack target) {
		for (ItemStack input : inputs) {
			if (itemMatches (target, input)) {
				return true;
			}
		}
		return false;
	}

	private boolean itemMatches (ItemStack target, ItemStack input) {
		return input != null && target != null && target.getItem () == input.getItem () && (target.getItemDamage () == input.getItemDamage ()
				|| input.getItemDamage () == WILDCARD_VALUE);
	}

	@Override
	public ImmutableList<Object> getNeededItems () {
		return neededItems;
	}

	@Override
	public ItemStack getResult () {
		return result.copy ();
	}
}
