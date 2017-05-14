package com.witchworks.common.crafting.kettle;

import com.witchworks.api.KettleRegistry;
import com.witchworks.api.ritual.Ritual;
import com.witchworks.common.block.natural.fluid.Fluids;
import com.witchworks.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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

		//------------------------------------Item Rituals------------------------------------//
		//Test recipe ignore
		KettleRegistry.registerKettleItemRecipe(Ritual.DEFAULT_NO_ENERGY
				, getStack(Items.GOLDEN_APPLE)
				, getStack(Items.GOLD_INGOT, 4), Items.BONE, Items.BONE, Items.BONE, Items.BONE);
		//Test recipe ignore
		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(5)
				, getStack(Items.SADDLE)
				, getStack(Items.LEATHER), Items.LEATHER, Items.IRON_INGOT, ModItems.BELLADONNA);

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(40)
				, getStack(Items.GOLDEN_APPLE, 1, 1)
				, getStack(Blocks.GOLD_BLOCK, 9), Items.APPLE);

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(10)
				, getStack(ModItems.GEMSTONE_AMALGAM)
				, getStack(Items.DYE, 1, 4), ModItems.ALEXANDRITE, ModItems.AMETHYST, ModItems.BLOODSTONE, ModItems.GARNET, ModItems.JASPER, ModItems.MALACHITE, ModItems.MOLDAVITE, ModItems.NUUMMITE, ModItems.PETOSKEY_STONE, ModItems.QUARTZ, ModItems.SERPENTINE, ModItems.TIGERS_EYE, ModItems.TIGERS_EYE, ModItems.TOURMALINE, ModItems.SALT, Items.EMERALD, Items.DIAMOND, Items.QUARTZ);

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.WHEAT_SEEDS)
				, getStack(Blocks.DIRT));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.BEETROOT_SEEDS)
				, getStack(Items.WHEAT_SEEDS));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.PUMPKIN_SEEDS)
				, getStack(Items.BEETROOT_SEEDS));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.MELON_SEEDS)
				, getStack(Items.PUMPKIN_SEEDS));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.CARROT)
				, getStack(Items.MELON_SEEDS));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.POTATO)
				, getStack(Items.CARROT));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.NETHER_WART)
				, getStack(Items.POTATO));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.CHORUS_FRUIT)
				, getStack(Items.NETHER_WART));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Blocks.CACTUS)
				, getStack(Items.CHORUS_FRUIT));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.REEDS)
				, getStack(Blocks.CACTUS));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_ACONITUM)
				, getStack(Items.REEDS));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_ASPHODEL)
				, getStack(ModItems.SEED_ACONITUM));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_BELLADONNA)
				, getStack(ModItems.SEED_ASPHODEL));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_GARLIC)
				, getStack(ModItems.SEED_BELLADONNA));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_GINGER)
				, getStack(ModItems.SEED_GARLIC));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_KELP)
				, getStack(ModItems.SEED_GINGER));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_KENAF)
				, getStack(ModItems.SEED_KELP));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_LAVENDER)
				, getStack(ModItems.SEED_KENAF));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_MANDRAKE)
				, getStack(ModItems.SEED_LAVENDER));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_MINT)
				, getStack(ModItems.SEED_MANDRAKE));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_SILPHIUM)
				, getStack(ModItems.SEED_MINT));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_THISTLE)
				, getStack(ModItems.SEED_SILPHIUM));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_TULSI)
				, getStack(ModItems.SEED_THISTLE));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_WHITE_SAGE)
				, getStack(ModItems.SEED_TULSI));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(ModItems.SEED_WORMWOOD)
				, getStack(ModItems.SEED_WHITE_SAGE));

		KettleRegistry.registerKettleItemRecipe(new Ritual.EnergyRitual(2)
				, getStack(Items.WHEAT_SEEDS)
				, getStack(ModItems.SEED_WORMWOOD));

	}

	/**
	 * Who needs to write the whole thing?
	 * @param item The item to make an ItemStack out of
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item) {
		return getStack(item, 1, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param item The block to make an ItemStack out of
	 * @param size Size of ItemStack
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item, int size) {
		return new ItemStack(item, size, 0);
	}

	/**
	 * Who needs to write the whole thing?
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
	 * @param block The block to make an ItemStack out of
	 * @return An ItemStack
	 */
	@SuppressWarnings ("ConstantConditions")
	private static ItemStack getStack(Block block) {
		return getStack(Item.getItemFromBlock(block), 1, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param block The block to make an ItemStack out of
	 * @param size Size of ItemStack
	 * @return An ItemStack
	 */
	@SuppressWarnings ("ConstantConditions")
	private static ItemStack getStack(Block block, int size) {
		return getStack(Item.getItemFromBlock(block), size, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param block The block to make an ItemStack out of
	 * @param size Size of ItemStack
	 * @param meta Meta of ItemStack
	 * @return An ItemStack
	 */
	@SuppressWarnings ("ConstantConditions")
	private static ItemStack getStack(Block block, int size, int meta) {
		return getStack(Item.getItemFromBlock(block), size, meta);
	}
}
