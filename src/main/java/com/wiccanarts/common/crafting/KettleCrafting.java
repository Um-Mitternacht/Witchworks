package com.wiccanarts.common.crafting;

import com.wiccanarts.api.WiccanArtsAPI;
import com.wiccanarts.api.recipe.IKettleRecipe;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class KettleCrafting {

	public static IKettleRecipe HEALING;
	public static IKettleRecipe LEAPING;

	private KettleCrafting() {
	}

	public static void init() {
		ItemStack potion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.HEALING);
		HEALING = WiccanArtsAPI.registerKettleRecipe(potion, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS, Items.WHEAT_SEEDS);

		ItemStack potion0 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.LEAPING);
		LEAPING = WiccanArtsAPI.registerKettleRecipe(potion0, Items.WHEAT_SEEDS, Items.COAL, Items.WHEAT_SEEDS);
	}
}
