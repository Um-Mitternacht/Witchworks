package com.wiccanarts.common.item;

import com.wiccanarts.common.crafting.VanillaCrafting;
import com.wiccanarts.common.lib.LibMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@GameRegistry.ObjectHolder(LibMod.MOD_ID)
public final class ModItems {

	public static final Item garnet = new Item();
	public static final Item moldavite = new Item();
	public static final Item nuummite = new Item();
	public static final Item petoskey_stone = new Item();
	public static final Item serpentine = new Item();
	public static final Item tigers_eye = new Item();
	public static final Item tourmaline = new Item();
	public static final Item bloodstone = new Item();

	public static void init() {
		VanillaCrafting.items();
	}

	public static void initOreDictionary() {
		OreDictionary.registerOre("gemBloodstone", new ItemStack(ModItems.bloodstone));
		OreDictionary.registerOre("gemMoldavite", new ItemStack(ModItems.moldavite));
		OreDictionary.registerOre("gemNuummite", new ItemStack(ModItems.nuummite));
		OreDictionary.registerOre("gemGarnet", new ItemStack(ModItems.garnet));
		OreDictionary.registerOre("gemTourmaline", new ItemStack(ModItems.tourmaline));
		OreDictionary.registerOre("gemTigersEye", new ItemStack(ModItems.tigers_eye));
		OreDictionary.registerOre("gemPetoskeyStone", new ItemStack(ModItems.petoskey_stone));
	}
}
