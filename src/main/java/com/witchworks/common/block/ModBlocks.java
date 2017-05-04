package com.witchworks.common.block;

import com.witchworks.common.block.natural.crop.BlockCrop;
import com.witchworks.common.crafting.VanillaCrafting;
import com.witchworks.common.lib.LibBlockName;
import com.witchworks.common.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@ObjectHolder (LibMod.MOD_ID)
public final class ModBlocks {

	@ObjectHolder (LibBlockName.CROP_ACONITUM)
	public static final BlockCrop CROP_ACONITUM = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_ASPHODEL)
	public static final BlockCrop CROP_ASPHODEL = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_BELLADONNA)
	public static final BlockCrop CROP_BELLADONNA = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_GINGER)
	public static final BlockCrop CROP_GINGER = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_KELP)
	public static final BlockCrop CROP_KELP = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_MINT)
	public static final BlockCrop CROP_MINT = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_WHITE_SAGE)
	public static final BlockCrop CROP_WHITE_SAGE = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_MANDRAKE_ROOT)
	public static final BlockCrop CROP_MANDRAKE_ROOT = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_LAVENDER)
	public static final BlockCrop CROP_LAVENDER = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_THISTLE)
	public static final BlockCrop CROP_THISTLE = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_TULSI)
	public static final BlockCrop CROP_TULSI = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_KENAF)
	public static final BlockCrop CROP_KENAF = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_SILPHIUM)
	public static final BlockCrop CROP_SILPHIUM = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_GARLIC)
	public static final BlockCrop CROP_GARLIC = new BlockCrop();
	@ObjectHolder (LibBlockName.CROP_WORMWOOD)
	public static final BlockCrop CROP_WORMWOOD = new BlockCrop();

	@ObjectHolder (LibBlockName.SILVER_BLOCK)
	public static final Block SILVER_BLOCK = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.MOLDAVITE_BLOCK)
	public static final Block MOLDAVITE_BLOCK = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.COQUINA)
	public static final Block COQUINA = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.BLOODSTONE_BLOCK)
	public static final Block BLOODSTONE_BLOCK = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.TOURMALINE_BLOCK)
	public static final Block TOURMALINE_BLOCK = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.KETTLE)
	public static final Block KETTLE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.SILVER_ORE)
	public static final Block SILVER_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.MOLDAVITE_ORE)
	public static final Block MOLDAVITE_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.BLOODSTONE_ORE)
	public static final Block BLOODSTONE_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.TOURMALINE_ORE)
	public static final Block TOURMALINE_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.MALACHITE_ORE)
	public static final Block MALACHITE_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.TIGERS_EYE_ORE)
	public static final Block TIGERS_EYE_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.GARNET_ORE)
	public static final Block GARNET_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.PETOSKEY_ORE)
	public static final Block PETOSKEY_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.SERPENTINE_ORE)
	public static final Block SERPENTINE_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.NUUMMITE_ORE)
	public static final Block NUUMMITE_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.NETHERSTEEL)
	public static final Block NETHERSTEEL = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.CANDLE_LARGE)
	public static final Block CANDLE_LARGE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.CANDLE_MEDIUM)
	public static final Block CANDLE_MEDIUM = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.CANDLE_SMALL)
	public static final Block CANDLE_SMALL = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.SALT_BARRIER)
	public static final Block SALT_BARRIER = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.BEEHIVE)
	public static final Block BEEHIVE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.ALTAR)
	public static final Block ALTAR = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.APIARY)
	public static final Block APIARY = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.SALT_ORE)
	public static final Block SALT_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.JASPER_ORE)
	public static final Block JASPER_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.QUARTZ_ORE)
	public static final Block QUARTZ_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.AMETHYST_ORE)
	public static final Block AMETHYST_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.ALEXANDRITE_ORE)
	public static final Block ALEXANDRITE_ORE = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.CHALK)
	public static final Block CHALK = new Block(Material.ROCK);
	@ObjectHolder (LibBlockName.OILPRESS)
	public static final Block OILPRESS = new Block(Material.ROCK);

	private ModBlocks() {
	}

	public static void init() {
		VanillaCrafting.blocks();
	}

	public static void initOreDictionary() {
		OreDictionary.registerOre("coquina", new ItemStack(ModBlocks.COQUINA));
		OreDictionary.registerOre("limestone", new ItemStack(ModBlocks.COQUINA));
		OreDictionary.registerOre("blockSilver", new ItemStack(ModBlocks.SILVER_BLOCK));
		OreDictionary.registerOre("blockMoldavite", new ItemStack(ModBlocks.MOLDAVITE_BLOCK));
		OreDictionary.registerOre("blockBloodstone", new ItemStack(ModBlocks.BLOODSTONE_BLOCK));
		OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.SILVER_ORE));
		OreDictionary.registerOre("oreMoldavite", new ItemStack(ModBlocks.MOLDAVITE_ORE));
		OreDictionary.registerOre("oreBloodstone", new ItemStack(ModBlocks.BLOODSTONE_ORE));
		OreDictionary.registerOre("oreTourmaline", new ItemStack(ModBlocks.TOURMALINE_ORE));
		OreDictionary.registerOre("oreMalachite", new ItemStack(ModBlocks.MALACHITE_ORE));
		OreDictionary.registerOre("oreTigersEye", new ItemStack(ModBlocks.TIGERS_EYE_ORE));
		OreDictionary.registerOre("oreJasper", new ItemStack(ModBlocks.JASPER_ORE));
		OreDictionary.registerOre("oreSerpentine", new ItemStack(ModBlocks.SERPENTINE_ORE));
		OreDictionary.registerOre("blockTourmaline", new ItemStack(ModBlocks.TOURMALINE_BLOCK));
		OreDictionary.registerOre("blockNethersteel", new ItemStack(ModBlocks.NETHERSTEEL));
		OreDictionary.registerOre("oreSalt", new ItemStack(ModBlocks.SALT_ORE));
		OreDictionary.registerOre("oreQuartz", new ItemStack(ModBlocks.QUARTZ_ORE));
		OreDictionary.registerOre("oreAmethyst", new ItemStack(ModBlocks.AMETHYST_ORE));
		OreDictionary.registerOre("oreAlexandrite", new ItemStack(ModBlocks.ALEXANDRITE_ORE));
		OreDictionary.registerOre("chalk", new ItemStack(ModBlocks.CHALK));
	}
}
