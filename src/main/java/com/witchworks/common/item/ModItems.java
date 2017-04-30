package com.witchworks.common.item;

import com.witchworks.common.crafting.VanillaCrafting;
import com.witchworks.common.crafting.kettle.KettleCrafting;
import com.witchworks.common.lib.LibItemName;
import com.witchworks.common.lib.LibMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@ObjectHolder (LibMod.MOD_ID)
public final class ModItems {

	//Gemstones
	@ObjectHolder (LibItemName.GARNET)
	public static final Item GARNET = new Item();
	@ObjectHolder (LibItemName.MOLDAVITE)
	public static final Item MOLDAVITE = new Item();
	@ObjectHolder (LibItemName.NUUMMITE)
	public static final Item NUUMMITE = new Item();
	@ObjectHolder (LibItemName.PETOSKEY_STONE)
	public static final Item PETOSKEY_STONE = new Item();
	@ObjectHolder (LibItemName.SERPENTINE)
	public static final Item SERPENTINE = new Item();
	@ObjectHolder (LibItemName.TIGERS_EYE)
	public static final Item TIGERS_EYE = new Item();
	@ObjectHolder (LibItemName.TOURMALINE)
	public static final Item TOURMALINE = new Item();
	@ObjectHolder (LibItemName.BLOODSTONE)
	public static final Item BLOODSTONE = new Item();
	@ObjectHolder (LibItemName.JASPER)
	public static final Item JASPER = new Item();
	@ObjectHolder (LibItemName.MALACHITE)
	public static final Item MALACHITE = new Item();
	@ObjectHolder (LibItemName.AMETHYST)
	public static final Item AMETHYST = new Item();
	@ObjectHolder (LibItemName.ALEXANDRITE)
	public static final Item ALEXANDRITE = new Item();
	@ObjectHolder (LibItemName.QUARTZ)
	public static final Item QUARTZ = new Item();

	//Metals
	@ObjectHolder (LibItemName.SILVER_INGOT)
	public static final Item SILVER_INGOT = new Item();
	@ObjectHolder (LibItemName.SILVER_POWDER)
	public static final Item SILVER_POWDER = new Item();
	@ObjectHolder (LibItemName.SILVER_NUGGET)
	public static final Item SILVER_NUGGET = new Item();

	//Food Items
	@ObjectHolder (LibItemName.HONEY)
	public static final Item HONEY = new Item();
	@ObjectHolder (LibItemName.MANDRAKE_ROOT)
	public static final Item MANDRAKE_ROOT = new Item();
	@ObjectHolder (LibItemName.LAVENDER)
	public static final Item LAVENDER = new Item();
	@ObjectHolder (LibItemName.BELLADONNA)
	public static final Item BELLADONNA = new Item();
	@ObjectHolder (LibItemName.ASPHODEL)
	public static final Item ASPHODEL = new Item();
	@ObjectHolder (LibItemName.KELP)
	public static final Item KELP = new Item();
	@ObjectHolder (LibItemName.GINGER)
	public static final Item GINGER = new Item();
	@ObjectHolder (LibItemName.MINT)
	public static final Item MINT = new Item();
	@ObjectHolder (LibItemName.THISTLE)
	public static final Item THISTLE = new Item();
	@ObjectHolder (LibItemName.GARLIC)
	public static final Item GARLIC = new Item();
	@ObjectHolder (LibItemName.ACONITUM)
	public static final Item ACONITUM = new Item();
	@ObjectHolder (LibItemName.WHITE_SAGE)
	public static final Item WHITE_SAGE = new Item();

	//Materials
	@ObjectHolder (LibItemName.WAX)
	public static final Item WAX = new Item();
	@ObjectHolder (LibItemName.SALT)
	public static final Item SALT = new Item();
	@ObjectHolder (LibItemName.HONEYCOMB)
	public static final Item HONEYCOMB = new Item();
	@ObjectHolder (LibItemName.EMPTY_HONEYCOMB)
	public static final Item EMPTY_HONEYCOMB = new Item();
	@ObjectHolder (LibItemName.LAVENDER_OIL)
	public static final Item LAVENDER_OIL = new Item();

	//Misc
	@ObjectHolder (LibItemName.BEE)
	public static final Item BEE = new Item();
	@ObjectHolder (LibItemName.GLASS_JAR)
	public static final Item GLASS_JAR = new Item();
	@ObjectHolder (LibItemName.BREW_PHIAL_DRINK)
	public static final Item BREW_PHIAL_DRINK = new Item();
	@ObjectHolder (LibItemName.BREW_PHIAL_SPLASH)
	public static final Item BREW_PHIAL_SPLASH = new Item();
	@ObjectHolder (LibItemName.BREW_PHIAL_LINGER)
	public static final Item BREW_PHIAL_LINGER = new Item();

	//Tools
	@ObjectHolder (LibItemName.SILVER_PICKAXE)
	public static final Item SILVER_PICKAXE = new Item();
	@ObjectHolder (LibItemName.SILVER_AXE)
	public static final Item SILVER_AXE = new Item();
	@ObjectHolder (LibItemName.SILVER_SPADE)
	public static final Item SILVER_SPADE = new Item();
	@ObjectHolder (LibItemName.SILVER_HOE)
	public static final Item SILVER_HOE = new Item();
	@ObjectHolder (LibItemName.SILVER_SWORD)
	public static final Item SILVER_SWORD = new Item();
	@ObjectHolder (LibItemName.MORTAR_AND_PESTLE)
	public static final Item MORTAR_AND_PESTLE = new Item();
	@ObjectHolder (LibItemName.SILVER_HELMET)
	public static final Item SILVER_HELMET = new Item();
	@ObjectHolder (LibItemName.SILVER_CHESTPLATE)
	public static final Item SILVER_CHESTPLATE = new Item();
	@ObjectHolder (LibItemName.SILVER_LEGGINGS)
	public static final Item SILVER_LEGGINGS = new Item();
	@ObjectHolder (LibItemName.SILVER_BOOTS)
	public static final Item SILVER_BOOTS = new Item();
	@ObjectHolder (LibItemName.RING)
	public static final Item RING = new Item();
	@ObjectHolder (LibItemName.BELT)
	public static final Item BELT = new Item();
	@ObjectHolder (LibItemName.CHALK_ITEM)
	public static final Item CHALK_ITEM = new Item();
	@ObjectHolder (LibItemName.CROWN)
	public static final Item CROWN = new Item();
	@ObjectHolder (LibItemName.SHIRT)
	public static final Item SHIRT = new Item();
	@ObjectHolder (LibItemName.AMULET)
	public static final Item AMULET = new Item();
	@ObjectHolder (LibItemName.TRINKET)
	public static final Item TRINKET = new Item();
	@ObjectHolder (LibItemName.CHARM)
	public static final Item CHARM = new Item();
	@ObjectHolder (LibItemName.WAND)
	public static final Item WAND = new Item();


	//Books
	@ObjectHolder (LibItemName.SHADOW_BOOK)
	public static final Item SHADOW_BOOK = new Item();
	@ObjectHolder (LibItemName.DUSTY_GRIMOIRE)
	public static final Item DUSTY_GRIMOIRE = new Item();

	private ModItems() {
	}

	public static void init() {
		VanillaCrafting.items();
		KettleCrafting.init();
	}

	public static void initOreDictionary() {
		OreDictionary.registerOre("gemBloodstone", new ItemStack(ModItems.BLOODSTONE));
		OreDictionary.registerOre("gemMoldavite", new ItemStack(ModItems.MOLDAVITE));
		OreDictionary.registerOre("gemNuummite", new ItemStack(ModItems.NUUMMITE));
		OreDictionary.registerOre("gemGarnet", new ItemStack(ModItems.GARNET));
		OreDictionary.registerOre("gemTourmaline", new ItemStack(ModItems.TOURMALINE));
		OreDictionary.registerOre("gemTigersEye", new ItemStack(ModItems.TIGERS_EYE));
		OreDictionary.registerOre("gemPetoskeyStone", new ItemStack(ModItems.PETOSKEY_STONE));
		OreDictionary.registerOre("gemJasper", new ItemStack(ModItems.JASPER));
		OreDictionary.registerOre("gemMalachite", new ItemStack(ModItems.MALACHITE));
		OreDictionary.registerOre("gemAmethyst", new ItemStack(ModItems.AMETHYST));
		OreDictionary.registerOre("gemAlexandrite", new ItemStack(ModItems.ALEXANDRITE));
		OreDictionary.registerOre("gemQuartz", new ItemStack(ModItems.QUARTZ));
		OreDictionary.registerOre("nuggetSilver", new ItemStack(ModItems.SILVER_NUGGET));
		OreDictionary.registerOre("ingotSilver", new ItemStack(ModItems.SILVER_INGOT));
		OreDictionary.registerOre("powderSilver", new ItemStack(ModItems.SILVER_POWDER));
		OreDictionary.registerOre("honeyDrop", new ItemStack(ModItems.HONEY));
		OreDictionary.registerOre("dropHoney", new ItemStack(ModItems.HONEY));
		OreDictionary.registerOre("listAllsugar", new ItemStack(ModItems.HONEY));
		OreDictionary.registerOre("materialWax", new ItemStack(ModItems.WAX));
		OreDictionary.registerOre("materialBeeswax", new ItemStack(ModItems.WAX));
		OreDictionary.registerOre("materialPressedWax", new ItemStack(ModItems.WAX));
		OreDictionary.registerOre("itemBeeswax", new ItemStack(ModItems.WAX));
		OreDictionary.registerOre("foodSalt", new ItemStack(ModItems.SALT));
		OreDictionary.registerOre("dustSalt", new ItemStack(ModItems.SALT));
		OreDictionary.registerOre("materialSalt", new ItemStack(ModItems.SALT));
		OreDictionary.registerOre("lumpSalt", new ItemStack(ModItems.SALT));
		OreDictionary.registerOre("cropLavender", new ItemStack(ModItems.LAVENDER));
		OreDictionary.registerOre("listAllherb", new ItemStack(ModItems.LAVENDER));
		OreDictionary.registerOre("cropBelladonna", new ItemStack(ModItems.BELLADONNA));
		OreDictionary.registerOre("cropMandrake", new ItemStack(ModItems.MANDRAKE_ROOT));
		OreDictionary.registerOre("cropKelp", new ItemStack(ModItems.KELP));
		OreDictionary.registerOre("cropSeaweed", new ItemStack(ModItems.KELP));
		OreDictionary.registerOre("listAllveggie", new ItemStack(ModItems.KELP));
		OreDictionary.registerOre("listAllgreenveggie", new ItemStack(ModItems.KELP));
		OreDictionary.registerOre("cropAsphodel", new ItemStack(ModItems.ASPHODEL));
		OreDictionary.registerOre("listAllspice", new ItemStack(ModItems.GINGER));
		OreDictionary.registerOre("cropGinger", new ItemStack(ModItems.GINGER));
		OreDictionary.registerOre("cropMint", new ItemStack(ModItems.MINT));
		OreDictionary.registerOre("listAllspice", new ItemStack(ModItems.MINT));
		OreDictionary.registerOre("cropSpiceleaf", new ItemStack(ModItems.MINT));
		OreDictionary.registerOre("listAllgreenveggie", new ItemStack(ModItems.MINT));
		OreDictionary.registerOre("cropThistle", new ItemStack(ModItems.THISTLE));
		OreDictionary.registerOre("cropGarlic", new ItemStack(ModItems.GARLIC));
		OreDictionary.registerOre("listAllherb", new ItemStack(ModItems.GARLIC));
		OreDictionary.registerOre("cropAconitum", new ItemStack(ModItems.ACONITUM));
		OreDictionary.registerOre("cropWhiteSage", new ItemStack(ModItems.WHITE_SAGE));
	}
}
