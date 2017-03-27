package com.wiccanarts.common.crafting;

import com.wiccanarts.api.WiccanArtsAPI;
import com.wiccanarts.api.item.crop.Crop;
import com.wiccanarts.api.recipe.IKettleRecipe;
import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.item.ModItems;
import com.wiccanarts.common.potions.ModBrewUtils;
import com.wiccanarts.common.potions.ModBrews;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;

import java.util.ArrayList;

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
	public static IKettleRecipe TEST1;

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


		ArrayList<PotionEffect> list = new ArrayList<>();
		list.add(new PotionEffect(ModBrews.test, 20 * 15));

		ItemStack potion4 = ModBrewUtils.setEffects(new ItemStack(ModItems.BREW_PHIAL), list);
		TEST1 = WiccanArtsAPI.registerKettleRecipe(potion4, Crop.MANDRAKE_ROOT, Blocks.TNT); //gotta add a method somewhere to get effects from recipe, not potions


	}
}
