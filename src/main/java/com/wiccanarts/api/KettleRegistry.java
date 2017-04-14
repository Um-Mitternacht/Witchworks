package com.wiccanarts.api;

import com.wiccanarts.api.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 14/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
public final class KettleRegistry {

	private static final List<IKettleRecipe> kettleRecipes = new ArrayList<>();
	private static final Map<Item, KettleExchange> kettleExchanges = new HashMap<>();
	private static final Map<Item, PotionValidator<PotionHolder>> kettleEffects = new HashMap<>();
	private static final Map<Item, PotionValidator<IEffectModifier>> kettleModifiers = new HashMap<>();

	private KettleRegistry() {
	}

	public static IKettleRecipe registerKettleItemRecipe(ItemStack stack, Object... objects) {
		final IKettleRecipe recipe = new KettleRecipe(stack, objects);
		return registerKettleRecipe(recipe);
	}

	public static IKettleRecipe registerKettlePotionRecipe(ItemStack stack, Object... objects) {
		final IKettleRecipe recipe = new KettleRecipePotion(stack, objects);
		return registerKettleRecipe(recipe);
	}

	public static IKettleRecipe registerKettleRecipe(IKettleRecipe kettleRecipe) {
		kettleRecipes.add(kettleRecipe);
		return kettleRecipe;
	}

	public static void addKettleExchange(ItemStack in, ItemStack out, boolean strict) {
		kettleExchanges.put(in.getItem(), new KettleExchange(in, out, strict));
	}

	public static void addKettleEffectTo(ItemStack stack, PotionHolder effect) {
		final Item item = stack.getItem();
		if (kettleEffects.containsKey(item)) {
			kettleEffects.get(item).add(stack, effect);
		} else {
			kettleEffects.put(item, new PotionValidator<PotionHolder>().add(stack, effect));
		}
	}

	public static <T extends IEffectModifier> void addKettleModifierTo(ItemStack stack, T modifier) {
		final Item item = stack.getItem();
		if (kettleModifiers.containsKey(item)) {
			kettleModifiers.get(item).add(stack, modifier);
		} else {
			kettleModifiers.put(item, new PotionValidator<IEffectModifier>().add(stack, modifier));
		}
	}

	public static List<IKettleRecipe> getKettleRecipes() {
		return kettleRecipes;
	}

	public static Map<Item, KettleExchange> getKettleExchanges() {
		return kettleExchanges;
	}

	public static Map<Item, PotionValidator<PotionHolder>> getKettleEffects() {
		return kettleEffects;
	}

	public static Map<Item, PotionValidator<IEffectModifier>> getKettleModifiers() {
		return kettleModifiers;
	}
}
