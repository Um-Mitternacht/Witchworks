package com.witchworks.api.recipe;

import com.witchworks.api.ritual.IKettleRitual;
import net.minecraft.item.ItemStack;

/**
 * This class was created by Arekkuusu on 04/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class KettleItemRecipe extends FlawlessRecipe {

	private final IKettleRitual ritual;

	public KettleItemRecipe(IKettleRitual ritual, ItemStack result, Object... inputs) {
		super(result, inputs);
		this.ritual = ritual;
	}

	public IKettleRitual getRitual() {
		return ritual;
	}
}
