package com.witchworks.api.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Optional;

/**
 * This class was created by Arekkuusu on 12/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class PotionValidator <T> {

	private final ArrayList<Tuple<ItemStack, T>> list = new ArrayList<>();

	public PotionValidator<T> add(ItemStack stack, T modifier) {
		list.add(new Tuple<>(stack, modifier));
		return this;
	}

	public Optional<Tuple<ItemStack, T>> get(ItemStack stack) {
		return list.stream().filter(tuple -> OreDictionary.itemMatches(tuple.getFirst(), stack, true)).findAny();
	}
}
