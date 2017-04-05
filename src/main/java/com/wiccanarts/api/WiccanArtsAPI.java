package com.wiccanarts.api;

import com.wiccanarts.api.item.crop.*;
import com.wiccanarts.api.recipe.*;
import com.wiccanarts.common.block.crop.*;
import net.minecraft.item.*;

import java.util.*;

/**
 * This class was created by Arekkuusu on 01/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
public class WiccanArtsAPI {

	private static final List<IKettleRecipe> kettleRecipes = new ArrayList<>();

	public static IKettleRecipe registerKettleRecipe(ItemStack stack, Object... objects) {
		IKettleRecipe recipe = new KettleRecipe(stack, objects);
		return registerKettleRecipe(recipe);
	}

	public static IKettleRecipe registerKettleFluidRecipe(Item item, ItemStack stack, Object... objects) {
		IKettleRecipe recipe = new KettleFluidRecipe(item, stack, objects);
		return registerKettleRecipe(recipe);
	}

	public static IKettleRecipe registerKettleRecipe(IKettleRecipe kettleRecipe) {
		kettleRecipes.add(kettleRecipe);
		return kettleRecipe;
	}

	public static List<IKettleRecipe> getKettleRecipes() {
		return kettleRecipes;
	}

	public static class CropRegistry {

		private static final Map<Crop, Item> seeds = new HashMap<>();
		private static final Map<Crop, BlockCrop> crops = new HashMap<>();
		private static final Map<Crop, Item> foods = new HashMap<>();

		public static Map<Crop, Item> getSeeds() {
			return seeds;
		}

		public static Map<Crop, BlockCrop> getCrops() {
			return crops;
		}

		public static Map<Crop, Item> getFoods() {
			return foods;
		}
	}
}
