package com.wiccanarts.common.crafting;

import com.wiccanarts.api.WiccanArtsAPI;
import com.wiccanarts.api.recipe.IKettleRecipe;
import com.wiccanarts.common.item.ModItems;
import com.wiccanarts.common.potions.BrewUtils;
import com.wiccanarts.common.potions.ModBrews;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.potion.PotionEffect;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
public final class KettleCrafting {

	public static IKettleRecipe STONEFORM_BREW;

	private KettleCrafting() {
	}

	public static void init() {
		WiccanArtsAPI.addValidPotionItem(ModItems.BREW_PHIAL);
		WiccanArtsAPI.addValidPotionItem(Items.POTIONITEM);

		STONEFORM_BREW = WiccanArtsAPI.registerKettleRecipe(BrewUtils.createPotion(Items.POTIONITEM, new PotionEffect(ModBrews.STONEFORM_BREW, 1800))
				, Blocks.COBBLESTONE, Blocks.COBBLESTONE, Blocks.COBBLESTONE, Blocks.COBBLESTONE, ModItems.MANDRAKE_ROOT, ModItems.WAX);
	}
}
