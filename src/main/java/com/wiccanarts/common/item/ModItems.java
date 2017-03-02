package com.wiccanarts.common.item;

import com.wiccanarts.common.crafting.VanillaCrafting;
import com.wiccanarts.common.lib.LibItemName;
import com.wiccanarts.common.lib.LibMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@ObjectHolder(LibMod.MOD_ID)
public final class ModItems {

	@ObjectHolder(LibItemName.GARNET)
	public static final Item GARNET = new Item();
	@ObjectHolder(LibItemName.MOLDAVITE)
	public static final Item MOLDAVITE = new Item();
	@ObjectHolder(LibItemName.NUUMMITE)
	public static final Item NUUMMITE = new Item();
	@ObjectHolder(LibItemName.PETOSKEY_STONE)
	public static final Item PETOSKEY_STONE = new Item();
	@ObjectHolder(LibItemName.SERPENTINE)
	public static final Item SERPENTINE = new Item();
	@ObjectHolder(LibItemName.TIGERS_EYE)
	public static final Item TIGERS_EYE = new Item();
	@ObjectHolder(LibItemName.TOURMALINE)
	public static final Item TOURMALINE = new Item();
	@ObjectHolder(LibItemName.BLOODSTONE)
	public static final Item BLOODSTONE = new Item();

	public static void init() {
		VanillaCrafting.items();
	}

	public static void initOreDictionary() {
		OreDictionary.registerOre("gemBloodStone", new ItemStack(ModItems.BLOODSTONE));
		OreDictionary.registerOre("gemMoldavite", new ItemStack(ModItems.MOLDAVITE));
		OreDictionary.registerOre("gemNuummite", new ItemStack(ModItems.NUUMMITE));
		OreDictionary.registerOre("gemGarnet", new ItemStack(ModItems.GARNET));
		OreDictionary.registerOre("gemTourmaline", new ItemStack(ModItems.TOURMALINE));
		OreDictionary.registerOre("gemTigersEye", new ItemStack(ModItems.TIGERS_EYE));
		OreDictionary.registerOre("gemPetoskeyStone", new ItemStack(ModItems.PETOSKEY_STONE));
	}
}
