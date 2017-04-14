package com.wiccanarts.common.crafting;

import com.wiccanarts.api.KettleRegistry;
import com.wiccanarts.api.recipe.PotionHolder;
import com.wiccanarts.common.item.ModItems;
import com.wiccanarts.common.potions.BrewUtils;
import com.wiccanarts.common.potions.ModBrews;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
public final class KettleCrafting {

	//Items

	//Potions

	private KettleCrafting() {
	}

	public static void init() {
		//Exchanges
		KettleRegistry.addKettleExchange(getStack(ModItems.EMPTY_HONEYCOMB), getStack(ModItems.WAX), false);
		KettleRegistry.addKettleExchange(getStack(ModItems.HONEYCOMB), getStack(ModItems.HONEY), false);
		KettleRegistry.addKettleExchange(getStack(Items.BEEF), getStack(Items.COOKED_BEEF), false);
		KettleRegistry.addKettleExchange(getStack(Items.FISH), getStack(Items.COOKED_FISH), false);
		KettleRegistry.addKettleExchange(getStack(Items.CHICKEN), getStack(Items.COOKED_CHICKEN), false);
		KettleRegistry.addKettleExchange(getStack(Items.MUTTON), getStack(Items.COOKED_MUTTON), false);
		KettleRegistry.addKettleExchange(getStack(Items.PORKCHOP), getStack(Items.COOKED_PORKCHOP), false);
		KettleRegistry.addKettleExchange(getStack(Items.RABBIT), getStack(Items.COOKED_RABBIT), false);

		//Item Recipes
		KettleRegistry.registerKettleItemRecipe(getStack(ModItems.SILVER_INGOT)
				, Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT, Items.COAL);

		KettleRegistry.registerKettleItemRecipe(getStack(Items.GOLD_INGOT)
				, Items.GOLD_NUGGET, Items.GOLD_NUGGET, Items.GOLD_NUGGET, Items.GOLD_NUGGET);

		//Potion Recipes
		KettleRegistry.registerKettlePotionRecipe(BrewUtils.createPotion(Items.POTIONITEM, new PotionEffect(MobEffects.HASTE, 200))
				, Items.SPECKLED_MELON, Items.SPECKLED_MELON, ModItems.SALT);

		//Custom Effects
		KettleRegistry.addKettleEffectTo(getStack(Items.GOLDEN_APPLE), new PotionHolder(MobEffects.ABSORPTION, 200));

		KettleRegistry.addKettleEffectTo(getStack(Items.IRON_INGOT), new PotionHolder(MobEffects.RESISTANCE, 50, 1));

		KettleRegistry.addKettleEffectTo(getStack(ModItems.BELLADONNA), new PotionHolder(MobEffects.POISON, 200));

		KettleRegistry.addKettleEffectTo(getStack(Items.RABBIT_FOOT), new PotionHolder(MobEffects.LUCK, 200));

		KettleRegistry.addKettleEffectTo(getStack(Blocks.COBBLESTONE), new PotionHolder(ModBrews.STONEFORM_BREW, 240));

		KettleRegistry.addKettleEffectTo(getStack(ModItems.SILVER_INGOT), new PotionHolder(ModBrews.PARALYSIS_BREW, 200));

		//Custom Modifiers
		KettleRegistry.addKettleModifierTo(getStack(Items.REDSTONE), effect -> effect.alter(100, 0));

		KettleRegistry.addKettleModifierTo(getStack(ModItems.QUARTZ), effect -> effect.alter(400, 0));

		KettleRegistry.addKettleModifierTo(getStack(Items.GLOWSTONE_DUST), effect -> effect.alter(-50, 1));

		KettleRegistry.addKettleModifierTo(getStack(ModItems.NUUMMITE), effect -> effect.alter(-150, 3));
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param item
	 * 		The item to make an ItemStack out of
	 *
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item) {
		return new ItemStack(item);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param block
	 * 		The block to make an ItemStack out of
	 *
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Block block) {
		return new ItemStack(block);
	}
}
