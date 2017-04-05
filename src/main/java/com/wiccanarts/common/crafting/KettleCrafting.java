package com.wiccanarts.common.crafting;

import com.wiccanarts.api.*;
import com.wiccanarts.api.recipe.*;
import com.wiccanarts.common.item.*;
import com.wiccanarts.common.potions.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
public final class KettleCrafting {

	//Items

	//Fluids
	public static IKettleRecipe HONEY;
	public static IKettleRecipe LAVENDER;
	public static IKettleRecipe STONEFORM_BREW;

	private KettleCrafting() {
	}

	public static void init() {

		HONEY = WiccanArtsAPI.registerKettleFluidRecipe(ModItems.GLASS_JAR
				, new ItemStack(ModItems.HONEY)
				, ModItems.WAX, ModItems.WAX, ModItems.WAX, ModItems.WAX);

		LAVENDER = WiccanArtsAPI.registerKettleFluidRecipe(ModItems.GLASS_JAR
				, new ItemStack(ModItems.LAVENDER_OIL)
				, ModItems.LAVENDER, ModItems.LAVENDER, ModItems.LAVENDER, ModItems.LAVENDER);

		STONEFORM_BREW = WiccanArtsAPI.registerKettleFluidRecipe(Items.POTIONITEM
				, BrewUtils.createPotion(Items.POTIONITEM, new PotionEffect(ModBrews.STONEFORM_BREW, 1800))
				, Blocks.COBBLESTONE, Blocks.COBBLESTONE, Blocks.COBBLESTONE, Blocks.COBBLESTONE, ModItems.MANDRAKE_ROOT, ModItems.WAX);
	}
}
