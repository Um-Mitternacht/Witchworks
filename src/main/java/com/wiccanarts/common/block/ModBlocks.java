package com.wiccanarts.common.block;

import com.wiccanarts.common.block.crop.BlockCrop;
import com.wiccanarts.common.crafting.VanillaCrafting;
import com.wiccanarts.common.lib.LibBlockName;
import com.wiccanarts.common.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@ObjectHolder(LibMod.MOD_ID)
public final class ModBlocks {

	@ObjectHolder(LibBlockName.CROP_ACONITUM)
	public static final BlockCrop CROP_ACONITUM = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_ASPHODEL)
	public static final BlockCrop CROP_ASPHODEL = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_BELLADONNA)
	public static final BlockCrop CROP_BELLADONNA = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_GINGER)
	public static final BlockCrop CROP_GINGER = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_KELP)
	public static final BlockCrop CROP_KELP = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_MINT)
	public static final BlockCrop CROP_MINT = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_WHITE_SAGE)
	public static final BlockCrop CROP_WHITE_SAGE = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_DANDELION_ROOT)
	public static final BlockCrop CROP_DANDELION_ROOT = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_ALLIUM)
	public static final BlockCrop CROP_ALLIUM = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_MANDRAKE_ROOT)
	public static final BlockCrop CROP_MANDRAKE_ROOT = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_LILAC)
	public static final BlockCrop CROP_LILAC = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_LAVENDER)
	public static final BlockCrop CROP_LAVENDER = new BlockCrop();

	@ObjectHolder(LibBlockName.SILVER_BLOCK)
	public static final Block SILVER_BLOCK = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.MOLDAVITE_BLOCK)
	public static final Block MOLDAVITE_BLOCK = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.COQUINA)
	public static final Block COQUINA = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.BLOODSTONE_BLOCK)
	public static final Block BLOODSTONE_BLOCK = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.TOURMALINE_BLOCK)
	public static final Block TOURMALINE_BLOCK = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.KETTLE)
	public static final Block KETTLE = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.SILVER_ORE)
	public static final Block SILVER_ORE = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.MOLDAVITE_ORE)
	public static final Block MOLDAVITE_ORE = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.BLOODSTONE_ORE)
	public static final Block BLOODSTONE_ORE = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.TOURMALINE_ORE)
	public static final Block TOURMALINE_ORE = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.MALACHITE_ORE)
	public static final Block MALACHITE_ORE = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.NETHERSTEEL)
	public static final Block NETHERSTEEL = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.CANDLE_LARGE)
	public static final Block CANDLE_LARGE = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.CANDLE_MEDIUM)
	public static final Block CANDLE_MEDIUM = new Block(Material.ROCK);
	@ObjectHolder(LibBlockName.CANDLE_SMALL)
	public static final Block CANDLE_SMALL = new Block(Material.ROCK);

	public static void init() {
		VanillaCrafting.blocks();
	}

	public static void initOreDictionary() {
		OreDictionary.registerOre("coquina", new ItemStack(ModBlocks.COQUINA));
		OreDictionary.registerOre("blockSilver", new ItemStack(ModBlocks.SILVER_BLOCK));
		OreDictionary.registerOre("blockMoldavite", new ItemStack(ModBlocks.MOLDAVITE_BLOCK));
		OreDictionary.registerOre("blockBloodstone", new ItemStack(ModBlocks.BLOODSTONE_BLOCK));
		OreDictionary.registerOre("oreSilver", new ItemStack(ModBlocks.SILVER_ORE));
		OreDictionary.registerOre("oreMoldavite", new ItemStack(ModBlocks.MOLDAVITE_ORE));
		OreDictionary.registerOre("oreBloodstone", new ItemStack(ModBlocks.BLOODSTONE_ORE));
		OreDictionary.registerOre("oreTourmaline", new ItemStack(ModBlocks.TOURMALINE_ORE));
		OreDictionary.registerOre("oreMalachite", new ItemStack(ModBlocks.MALACHITE_ORE));
		OreDictionary.registerOre("blockTourmaline", new ItemStack(ModBlocks.TOURMALINE_BLOCK));
		OreDictionary.registerOre("blockNethersteel", new ItemStack(ModBlocks.NETHERSTEEL));
	}
}
