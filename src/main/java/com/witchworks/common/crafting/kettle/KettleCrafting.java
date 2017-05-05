package com.witchworks.common.crafting.kettle;

import com.witchworks.api.KettleRegistry;
import com.witchworks.common.block.natural.fluid.Fluids;
import com.witchworks.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
public final class KettleCrafting {

	private KettleCrafting() {
	}

	public static void init() {
		//------------------------------------Processing------------------------------------//
		//Some recipes that return the non-dyed version of an Item
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, Items.LEATHER_HELMET, getStack(Items.LEATHER_HELMET), false);
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, Items.LEATHER_CHESTPLATE, getStack(Items.LEATHER_CHESTPLATE), false);
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, Items.LEATHER_LEGGINGS, getStack(Items.LEATHER_LEGGINGS), false);
		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, Items.LEATHER_BOOTS, getStack(Items.LEATHER_BOOTS), false);
		//Cooking with Oil
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.PORKCHOP, getStack(Items.COOKED_PORKCHOP), true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.MUTTON, getStack(Items.COOKED_MUTTON), true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.RABBIT, getStack(Items.COOKED_RABBIT), true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.CHICKEN, getStack(Items.COOKED_CHICKEN), true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.BEEF, getStack(Items.COOKED_BEEF), true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.FISH, getStack(Items.COOKED_FISH), true);
		KettleRegistry.addKettleProcessing(Fluids.MUNDANE_OIL, Items.POTATO, getStack(Items.BAKED_POTATO), true);

		KettleRegistry.addKettleProcessing(FluidRegistry.WATER, ModItems.EMPTY_HONEYCOMB, getStack(ModItems.WAX), true);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param item The item to make an ItemStack out of
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item) {
		return getStack(item, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param item The block to make an ItemStack out of
	 * @param meta Meta of ItemStack
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item, int meta) {
		return new ItemStack(item, 1, meta);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param block The block to make an ItemStack out of
	 * @return An ItemStack
	 */
	@SuppressWarnings ("ConstantConditions")
	private static ItemStack getStack(Block block) {
		return getStack(Item.getItemFromBlock(block), 0);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param block The block to make an ItemStack out of
	 * @return An ItemStack
	 */
	@SuppressWarnings ("ConstantConditions")
	private static ItemStack getStack(Block block, int meta) {
		return getStack(Item.getItemFromBlock(block), meta);
	}
}
