package com.wiccanarts.common.crafting;

import com.wiccanarts.api.WiccanArtsAPI;
import com.wiccanarts.api.item.crop.Crop;
import com.wiccanarts.api.recipe.IKettleRecipe;
import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.item.ModItems;
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
	public static IKettleRecipe POISON;
	public static IKettleRecipe WATERBREATHING;
	public static IKettleRecipe REGENERATION;

	private KettleCrafting() {
	}

	public static void init() {
		ItemStack potion = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.HEALING);
		HEALING = WiccanArtsAPI.registerKettleRecipe(potion, Crop.MANDRAKE_ROOT, ModItems.BLOODSTONE, Items.COAL);

		ItemStack potion0 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.LEAPING);
		LEAPING = WiccanArtsAPI.registerKettleRecipe(potion0, Crop.MANDRAKE_ROOT, Items.RABBIT_FOOT, Items.FEATHER);

		ItemStack potion1 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.POISON);
		POISON = WiccanArtsAPI.registerKettleRecipe(potion1, Crop.MANDRAKE_ROOT, ModItems.MALACHITE, Items.SPIDER_EYE);

		ItemStack potion2 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER_BREATHING);
		WATERBREATHING = WiccanArtsAPI.registerKettleRecipe(potion2, Crop.MANDRAKE_ROOT, Items.FISH, ModBlocks.COQUINA);

		ItemStack potion3 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.STRONG_REGENERATION);
		REGENERATION = WiccanArtsAPI.registerKettleRecipe(potion3, Crop.MANDRAKE_ROOT, Crop.LAVENDER, Items.WHEAT);
	}
}
