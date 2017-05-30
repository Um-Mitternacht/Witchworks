package com.witchworks.common.crafting.kettle;

import com.witchworks.api.KettleRegistry;
import com.witchworks.common.block.natural.fluid.Fluids;
import com.witchworks.common.item.ModItems;
import com.witchworks.common.potions.BrewUtils;
import com.witchworks.common.potions.ModBrews;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
public final class KettleCrafting {

	private KettleCrafting() {
	}

	public static void init() {
		//------------------------------------Processing------------------------------------//
		//Some recipes that return the non-dyed version of an Item
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, Items.LEATHER_HELMET, Items.LEATHER_HELMET, false);
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, Items.LEATHER_CHESTPLATE, Items.LEATHER_CHESTPLATE, false);
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, Items.LEATHER_LEGGINGS, Items.LEATHER_LEGGINGS, false);
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, Items.LEATHER_BOOTS, Items.LEATHER_BOOTS, false);
		//Cooking with Oil
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.PORKCHOP, Items.COOKED_PORKCHOP, true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.MUTTON, Items.COOKED_MUTTON, true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.RABBIT, Items.COOKED_RABBIT, true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.CHICKEN, Items.COOKED_CHICKEN, true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.BEEF, Items.COOKED_BEEF, true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.FISH, Items.COOKED_FISH, true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.POTATO, Items.BAKED_POTATO, true);
		//Coking with Water
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, ModItems.EMPTY_HONEYCOMB, ModItems.WAX, true);
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, ModItems.HONEYCOMB, ModItems.HONEY, true);

		//------------------------------------Fluid Creation------------------------------------//
		KettleRegistry.addKettleFluid(ModItems.HONEY, new FluidStack(Fluids.HONEY, 1000));

		//------------------------------------Item Rituals------------------------------------//
		KettleRegistry.registerKettleItemRitual(new ItemRitual(getStack(ModItems.SEED_MANDRAKE), 5)
				, getStack(Items.WHEAT_SEEDS, 5), Blocks.SOUL_SAND);

		//------------------------------------Potion Recipes------------------------------------//
		KettleRegistry.registerKettleBrewRecipe(BrewUtils.createBrew(ModItems.BREW_PHIAL_DRINK, ModBrews.SHELL_ARMOR)
				, Items.BONE, ModItems.NEEDLE_BONE, getStack(ModItems.HONEYCOMB, 3));

		KettleRegistry.registerKettleBrewRecipe(BrewUtils.createBrew(ModItems.BREW_PHIAL_DRINK, ModBrews.INNER_FIRE)
				, getStack(Items.BLAZE_ROD, 2), Items.GOLD_NUGGET);

		KettleRegistry.registerKettleBrewRecipe(BrewUtils.createBrew(ModItems.BREW_PHIAL_DRINK, ModBrews.SPIDER_NIGHTMARE)
				, getStack(Blocks.WEB, 10), getStack(Items.SPIDER_EYE, 5), Items.GHAST_TEAR);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param item The item to make an ItemStack out of
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item) {
		return getStack(item, 1, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param item The block to make an ItemStack out of
	 * @param size Size of ItemStack
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item, int size) {
		return new ItemStack(item, size, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param item The block to make an ItemStack out of
	 * @param size Size of ItemStack
	 * @param meta Meta of ItemStack
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item, int size, int meta) {
		return new ItemStack(item, size, meta);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param block The block to make an ItemStack out of
	 * @return An ItemStack
	 */
	@SuppressWarnings("ConstantConditions")
	private static ItemStack getStack(Block block) {
		return getStack(Item.getItemFromBlock(block), 1, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param block The block to make an ItemStack out of
	 * @param size  Size of ItemStack
	 * @return An ItemStack
	 */
	@SuppressWarnings("ConstantConditions")
	private static ItemStack getStack(Block block, int size) {
		return getStack(Item.getItemFromBlock(block), size, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param block The block to make an ItemStack out of
	 * @param size  Size of ItemStack
	 * @param meta  Meta of ItemStack
	 * @return An ItemStack
	 */
	@SuppressWarnings("ConstantConditions")
	private static ItemStack getStack(Block block, int size, int meta) {
		return getStack(Item.getItemFromBlock(block), size, meta);
	}
}
