package com.wiccanarts.api;

import com.wiccanarts.api.item.crop.Crop;
import com.wiccanarts.api.recipe.IKettleRecipe;
import com.wiccanarts.api.recipe.KettleFluidRecipe;
import com.wiccanarts.api.recipe.KettleRecipe;
import com.wiccanarts.common.block.crop.BlockCrop;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 01/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
public final class WiccanArtsAPI {

	private static final List<IKettleRecipe> kettleRecipes = new ArrayList<> ();

	private WiccanArtsAPI () {
	}

	public static IKettleRecipe registerKettleRecipe (ItemStack stack, Object... objects) {
		final IKettleRecipe recipe = new KettleRecipe (stack, objects);
		return registerKettleRecipe (recipe);
	}

	public static IKettleRecipe registerKettleFluidRecipe (Item item, ItemStack stack, Object... objects) {
		final IKettleRecipe recipe = new KettleFluidRecipe (item, stack, objects);
		return registerKettleRecipe (recipe);
	}

	public static IKettleRecipe registerKettleRecipe (IKettleRecipe kettleRecipe) {
		kettleRecipes.add (kettleRecipe);
		return kettleRecipe;
	}

	public static List<IKettleRecipe> getKettleRecipes () {
		return kettleRecipes;
	}

	public static class CropRegistry {

		private static final Map<Crop, Item> seeds = new HashMap<> ();
		private static final Map<Crop, BlockCrop> crops = new HashMap<> ();
		private static final Map<Crop, Item> foods = new HashMap<> ();

		public static Map<Crop, Item> getSeeds () {
			return seeds;
		}

		public static Map<Crop, BlockCrop> getCrops () {
			return crops;
		}

		public static Map<Crop, Item> getFoods () {
			return foods;
		}
	}
}
