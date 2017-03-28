package com.wiccanarts.common.crafting;

import com.wiccanarts.api.WiccanArtsAPI;
import com.wiccanarts.api.item.crop.Crop;
import com.wiccanarts.api.recipe.IKettleRecipe;
import com.wiccanarts.common.potions.BrewUtils;
import com.wiccanarts.common.potions.ModBrews;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
public final class KettleCrafting {

	public static IKettleRecipe TEST;

	private KettleCrafting() {
	}

	public static void init() {
		ItemStack potion4 = BrewUtils.createPotion(new PotionEffect(ModBrews.TEST, 20 * 15));
		TEST = WiccanArtsAPI.registerKettleRecipe(potion4, Crop.MANDRAKE_ROOT, Blocks.TNT); //gotta add a method somewhere to get effects from recipe, not potions
	}
}
