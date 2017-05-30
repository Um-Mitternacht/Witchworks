package com.witchworks.api;

import com.witchworks.api.recipe.ItemValidator;
import com.witchworks.api.recipe.KettleBrewRecipe;
import com.witchworks.api.recipe.KettleItemRecipe;
import com.witchworks.api.ritual.IRitual;
import com.witchworks.common.crafting.kettle.ItemRitual;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 14/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class KettleRegistry {

	private static final Map<Fluid, Map<Item, ItemValidator<ItemStack>>> KETTLE_PROCESSING = new HashMap<>();
	private static final Map<Item, FluidStack> FLUID_ITEMS = new HashMap<>();
	private static final List<KettleItemRecipe> KETTLE_ITEM_RITUALS = new ArrayList<>();
	private static final List<KettleBrewRecipe> KETTLE_BREW_RECIPES = new ArrayList<>();
	private static final List<IRitual> RITUALS = new ArrayList<>();

	private KettleRegistry() {
	}

	/**
	 * Register an Item to the Processing factory.
	 *
	 * @param fluid  The fluid this Item needs
	 * @param in     The Item you throw in
	 * @param out    The Item that comes out
	 * @param strict If the Item must be identical
	 */
	public static void addKettleProcessing(Fluid fluid, Item in, Item out, boolean strict) {
		addKettleProcessing(fluid, new ItemStack(in), new ItemStack(out), strict);
	}

	/**
	 * Register an Item to the Processing factory.
	 *
	 * @param fluid  The fluid this Item needs
	 * @param in     The Item you throw in
	 * @param out    The Item that comes out
	 * @param strict If the Item must be identical
	 */
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

	public static void addKettleFluid(Item item, FluidStack fluid) {
		FLUID_ITEMS.put(item, fluid);
	}

	public static KettleItemRecipe registerKettleItemRitual(ItemRitual ritual, Object... objects) {
		final KettleItemRecipe recipe = new KettleItemRecipe(ritual, objects);
		KETTLE_ITEM_RITUALS.add(recipe);
		if (!RITUALS.contains(ritual))
			RITUALS.add(ritual);
		return recipe;
	}

	public static KettleBrewRecipe registerKettleBrewRecipe(ItemStack stack, Object... objects) {
		final KettleBrewRecipe recipe = new KettleBrewRecipe(stack, objects);
		KETTLE_BREW_RECIPES.add(recipe);
		return recipe;
	}

	public static Map<Item, ItemValidator<ItemStack>> getKettleProcessing(Fluid fluid) {
		return KETTLE_PROCESSING.get(fluid);
	}

	public static Map<Item, FluidStack> getFluidItems() {
		return FLUID_ITEMS;
	}

	public static List<KettleItemRecipe> getKettleItemRituals() {
		return KETTLE_ITEM_RITUALS;
	}

	public static List<KettleBrewRecipe> getKettleBrewRecipes() {
		return KETTLE_BREW_RECIPES;
	}

	public static List<IRitual> getRituals() {
		return RITUALS;
	}
}
