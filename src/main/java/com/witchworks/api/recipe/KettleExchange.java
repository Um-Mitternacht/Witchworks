package com.witchworks.api.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 11/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class KettleExchange {

	private final ItemStack input;
	private final ItemStack output;
	private final boolean strict;

	public KettleExchange(ItemStack input, ItemStack output, boolean strict) {
		this.input = input;
		this.output = output;
		this.strict = strict;
	}

	@Nullable
	public ItemStack getExchange(ItemStack in) {
		return OreDictionary.itemMatches(input, in, strict) ? output.copy() : null;
	}
}
