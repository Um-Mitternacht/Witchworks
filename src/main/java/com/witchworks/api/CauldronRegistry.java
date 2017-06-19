package com.witchworks.api;

import com.witchworks.api.recipe.BrewModifier;
import com.witchworks.api.recipe.ItemValidator;
import com.witchworks.api.recipe.KettleBrewRecipe;
import com.witchworks.api.recipe.KettleItemRecipe;
import com.witchworks.common.crafting.cauldron.ItemRitual;
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
public final class CauldronRegistry {

	private static final Map<Fluid, Map<Item, ItemValidator<ItemStack>>> ITEM_PROCESSING = new HashMap<>();
	private static final Map<Item, FluidStack> FLUID_INGREDIENTS = new HashMap<>();
	private static final List<KettleItemRecipe> ITEM_RITUALS = new ArrayList<>();
	private static final List<KettleBrewRecipe> BREW_RECIPES = new ArrayList<>();
	private static final Map<Item, ItemValidator<Object>> BREW_EFFECTS = new HashMap<>();
	private static final Map<Item, ItemValidator<BrewModifier>> BREW_MODIFIERS = new HashMap<>();

	private CauldronRegistry() {
	}

	/**
	 * Register an Item to the Processing factory.
	 *
	 * @param fluid  The fluid this Item needs
	 * @param in     The Item you throw in
	 * @param out    The Item that comes out
	 * @param strict If the Item must be identical
	 */
	public static void registerItemProcessing(Fluid fluid, ItemStack in, ItemStack out, boolean strict) {
		if (ITEM_PROCESSING.containsKey(fluid)) {
			Map<Item, ItemValidator<ItemStack>> map = ITEM_PROCESSING.get(fluid);
			Item item = in.getItem();
			if (map.containsKey(item)) {
				map.get(item).add(in, out, strict);
			} else {
				map.put(item, new ItemValidator<ItemStack>().add(in, out, strict));
			}
		} else {
			Map<Item, ItemValidator<ItemStack>> map = new HashMap<>();
			map.put(in.getItem(), new ItemValidator<ItemStack>().add(in, out, strict));
			ITEM_PROCESSING.put(fluid, map);
		}
	}

	public static void registerFluidIngredient(Item item, FluidStack fluid) {
		FLUID_INGREDIENTS.put(item, fluid);
	}

	public static void registerItemRitual(ItemRitual ritual, Object... objects) {
		final KettleItemRecipe recipe = new KettleItemRecipe(ritual, objects);
		ITEM_RITUALS.add(recipe);
	}

	public static void registerBrewRecipe(ItemStack stack, Object... objects) {
		final KettleBrewRecipe recipe = new KettleBrewRecipe(stack, objects);
		BREW_RECIPES.add(recipe);
	}

	public static <T> void registerItemEffect(ItemStack stack, T effect, boolean strict) {
		Item item = stack.getItem();
		if (BREW_EFFECTS.containsKey(item)) {
			BREW_EFFECTS.get(item).add(stack, effect, strict);
		} else {
			BREW_EFFECTS.put(item, new ItemValidator<>().add(stack, effect, strict));
		}
	}

	public static void registerItemModifier(ItemStack stack, BrewModifier modifier, boolean strict) {
		Item item = stack.getItem();
		if (BREW_MODIFIERS.containsKey(item)) {
			BREW_MODIFIERS.get(item).add(stack, modifier, strict);
		} else {
			BREW_MODIFIERS.put(item, new ItemValidator<BrewModifier>().add(stack, modifier, strict));
		}
	}

	public static Map<Item, ItemValidator<ItemStack>> getItemProcessing(Fluid fluid) {
		return ITEM_PROCESSING.get(fluid);
	}

	public static Map<Item, FluidStack> getFluidIngredients() {
		return FLUID_INGREDIENTS;
	}

	public static List<KettleItemRecipe> getItemRituals() {
		return ITEM_RITUALS;
	}

	public static List<KettleBrewRecipe> getBrewRecipes() {
		return BREW_RECIPES;
	}

	public static Map<Item, ItemValidator<Object>> getBrewEffects() {
		return BREW_EFFECTS;
	}

	public static Map<Item, ItemValidator<BrewModifier>> getBrewModifiers() {
		return BREW_MODIFIERS;
	}
}
