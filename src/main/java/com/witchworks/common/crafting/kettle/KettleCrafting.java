package com.witchworks.common.crafting.kettle;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.KettleRegistry;
import com.witchworks.api.recipe.BrewSimpleModifier;
import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.block.natural.fluid.Fluids;
import com.witchworks.common.item.ModItems;
import com.witchworks.common.potions.BrewUtils;
import com.witchworks.common.potions.ModBrews;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
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
		KettleRegistry.addKettleFluid(Items.POTATO, new FluidStack(Fluids.MUNDANE_OIL, 1000));

		//------------------------------------Item Rituals------------------------------------//
		KettleRegistry.registerKettleItemRitual(new ItemRitual(getStack(ModItems.SEED_MANDRAKE), 5)
				, getStack(Items.WHEAT_SEEDS, 5), Blocks.SOUL_SAND);

		KettleRegistry.registerKettleItemRitual(new ItemRitual(getStack(Items.GOLDEN_APPLE, 1, 1), 8)
				, getStack(Blocks.GOLD_BLOCK, 8), Items.APPLE);
		//Todo: Sapling recipes once we add our own (to make it easier to get them without exploring, in the event a player cannot find them),
		//Todo: Also gemstone amalgam for usage as a crafting ingredient. Also, the easter egg recipe and its achievement.

		//------------------------------------Brew Recipes------------------------------------//
		KettleRegistry.registerKettleBrewRecipe(BrewUtils.createBrew(ModItems.BREW_PHIAL_DRINK, ModBrews.SHELL_ARMOR)
				, Items.BONE, ModItems.NEEDLE_BONE, getStack(ModBlocks.COQUINA, 3));

		KettleRegistry.registerKettleBrewRecipe(BrewUtils.createBrew(ModItems.BREW_PHIAL_DRINK, ModBrews.INNER_FIRE)
				, getStack(Items.BLAZE_ROD, 2), Items.GOLD_NUGGET, Items.BLAZE_POWDER);

		KettleRegistry.registerKettleBrewRecipe(BrewUtils.createBrew(ModItems.BREW_PHIAL_DRINK, ModBrews.SPIDER_NIGHTMARE)
				, getStack(Blocks.WEB, 10), getStack(Items.SPIDER_EYE, 5), Items.GHAST_TEAR, Items.FERMENTED_SPIDER_EYE);

		//Todo: More brews, obviously. Just need ideas, really.

		//------------------------------------Custom Brew Creation------------------------------------//
		//Todo: Continue once more effects are added, such as new brews, and what not. Also when I get around to making the ingredients and what not.
		KettleRegistry.addItemEffect(getStack(ModItems.SALT), new PotionEffect(MobEffects.BLINDNESS, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.ROTTEN_FLESH), new PotionEffect(MobEffects.HUNGER, 500), false);
		KettleRegistry.addItemEffect(getStack(Blocks.END_STONE), new PotionEffect(MobEffects.LEVITATION, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.SPIDER_EYE), new PotionEffect(MobEffects.POISON, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.GHAST_TEAR), new PotionEffect(MobEffects.REGENERATION, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.GOLDEN_CARROT), new PotionEffect(MobEffects.NIGHT_VISION, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.SUGAR), new PotionEffect(MobEffects.SPEED, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.MAGMA_CREAM), new PotionEffect(MobEffects.FIRE_RESISTANCE, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.BLAZE_POWDER), new PotionEffect(MobEffects.STRENGTH, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.RABBIT_FOOT), new PotionEffect(MobEffects.JUMP_BOOST, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.SPECKLED_MELON), new PotionEffect(MobEffects.INSTANT_HEALTH, 1), false);
		KettleRegistry.addItemEffect(getStack(Items.FISH, 1, 3), new PotionEffect(MobEffects.WATER_BREATHING, 500), false);
		KettleRegistry.addItemEffect(getStack(Blocks.RED_FLOWER, 1, 1), new PotionEffect(MobEffects.LUCK, 500), false);
		KettleRegistry.addItemEffect(getStack(ModItems.WAX), new PotionEffect(MobEffects.SLOWNESS, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.POISONOUS_POTATO), new PotionEffect(MobEffects.NAUSEA, 500), false);
		KettleRegistry.addItemEffect(getStack(ModItems.BELLADONNA), new PotionEffect(MobEffects.WITHER, 500), false);
		KettleRegistry.addItemEffect(getStack(ModItems.ASPHODEL), new PotionEffect(MobEffects.UNLUCK, 500), false);
		KettleRegistry.addItemEffect(getStack(ModItems.LAVENDER), new PotionEffect(MobEffects.HASTE, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.PRISMARINE_CRYSTALS), new PotionEffect(MobEffects.GLOWING, 500), false);
		KettleRegistry.addItemEffect(getStack(ModItems.KELP), new PotionEffect(MobEffects.WATER_BREATHING, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.PRISMARINE_SHARD), new PotionEffect(MobEffects.MINING_FATIGUE, 500), false);
		KettleRegistry.addItemEffect(getStack(Items.SHULKER_SHELL), new PotionEffect(MobEffects.SLOWNESS, 500), false);
		KettleRegistry.addItemEffect(getStack(ModBlocks.COQUINA), BrewRegistry.getDefault(ModBrews.SHELL_ARMOR), false);

		KettleRegistry.addItemModifier(getStack(Items.QUARTZ), new BrewSimpleModifier(2400, 0), true);
		KettleRegistry.addItemModifier(getStack(Items.REDSTONE), new BrewSimpleModifier(600, 0), true);
		KettleRegistry.addItemModifier(getStack(Blocks.REDSTONE_BLOCK), new BrewSimpleModifier(1200, 0), true);

		KettleRegistry.addItemModifier(getStack(ModItems.NUUMMITE), new BrewSimpleModifier(0, 3), true);
		KettleRegistry.addItemModifier(getStack(Items.GLOWSTONE_DUST), new BrewSimpleModifier(0, 1), true);
		KettleRegistry.addItemModifier(getStack(Blocks.GLOWSTONE), new BrewSimpleModifier(0, 2), true);
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
