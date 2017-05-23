package com.witchworks.api;

import com.witchworks.api.recipe.ItemValidator;
import com.witchworks.api.recipe.KettleItemRecipe;
import com.witchworks.api.recipe.KettlePotionRecipe;
import com.witchworks.api.ritual.IRitual;
import com.witchworks.common.crafting.kettle.ItemRitual;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 14/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
public final class KettleRegistry {

	private static final List<IRitual> RITUALS = new ArrayList<>();
	private static final List<KettleItemRecipe> KETTLE_ITEM_RITUALS = new ArrayList<>();
	private static final List<KettlePotionRecipe> KETTLE_POTION_RECIPES = new ArrayList<>();
	private static final Map<Fluid, Map<Item, ItemValidator<ItemStack>>> KETTLE_PROCESSING = new HashMap<>();

	private KettleRegistry() {
	}

	public static KettleItemRecipe registerKettleItemRitual(ItemRitual ritual, Object... objects) {
		final KettleItemRecipe recipe = new KettleItemRecipe(ritual, objects);
		KETTLE_ITEM_RITUALS.add(recipe);
		if (!RITUALS.contains(ritual))
			RITUALS.add(ritual);
		return recipe;
	}

	public static KettlePotionRecipe registerKettlePotionRecipe(ItemStack stack, Object... objects) {
		final KettlePotionRecipe recipe = new KettlePotionRecipe(stack, objects);
		KETTLE_POTION_RECIPES.add(recipe);
		return recipe;
	}

	public static void addKettleProcessing(Fluid fluid, Item in, ItemStack out, boolean strict) {
		addKettleProcessing(fluid, new ItemStack(in), out, strict);
	}

	public static void addKettleProcessing(Fluid fluid, ItemStack in, ItemStack out, boolean strict) {
		if (KETTLE_PROCESSING.containsKey(fluid)) {
			Map<Item, ItemValidator<ItemStack>> map = KETTLE_PROCESSING.get(fluid);
			Item item = in.getItem();
			if (map.containsKey(item)) {
				map.get(item).add(in, out, strict);
			} else {
				map.put(item, new ItemValidator<ItemStack>().add(in, out, strict));
			}
		} else {
			Map<Item, ItemValidator<ItemStack>> map = new HashMap<>();
			map.put(in.getItem(), new ItemValidator<ItemStack>().add(in, out, strict));
			KETTLE_PROCESSING.put(fluid, map);
		}
	}

	public static List<IRitual> getRituals() {
		return RITUALS;
	}

	public static List<KettleItemRecipe> getKettleItemRituals() {
		return KETTLE_ITEM_RITUALS;
	}

	public static List<KettlePotionRecipe> getKettlePotionRecipes() {
		return KETTLE_POTION_RECIPES;
	}

	public static Map<Item, ItemValidator<ItemStack>> getKettleProcessing(Fluid fluid) {
		return KETTLE_PROCESSING.get(fluid);
	}
}
