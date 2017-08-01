package com.witchworks.api.recipe;

import net.minecraft.item.ItemStack;

import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;

/**
 * This class was created by Joseph on 7/21/2017..
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class OvenRecipe {

	private final ItemStack[] outputs;
	private final ItemStack needed;

	public OvenRecipe(ItemStack needed, ItemStack... outputs) {
		this.needed = needed;
		this.outputs = outputs;
	}

	public ItemStack getNeeded() {
		return needed;
	}

	public ItemStack[] getOutputs() {
		ItemStack[] other = new ItemStack[outputs.length];

		for (int i = 0; i < outputs.length; i++) {
			other[i] = other[i].copy();
		}

		return other;
	}

	public boolean matches(ItemStack input) {
		return input != null && needed != null && needed.getItem() == input.getItem() && (needed.getItemDamage() == input.getItemDamage()
				|| input.getItemDamage() == WILDCARD_VALUE);
	}
}