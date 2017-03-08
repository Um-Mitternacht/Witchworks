package com.wiccanarts.common.core;

import com.wiccanarts.api.item.crop.Crop;
import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.block.crop.*;
import com.wiccanarts.common.block.tools.BlockKettle;
import com.wiccanarts.common.item.ItemMod;
import com.wiccanarts.common.item.food.*;
import com.wiccanarts.common.item.seed.ItemKelpSeed;
import com.wiccanarts.common.item.seed.ItemSeed;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.wiccanarts.api.WiccanArtsAPI.CropRegistry;
import static com.wiccanarts.api.item.crop.Crop.*;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@Mod.EventBusSubscriber
public class CommonRegistration {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		//Crops
		registerCrop(ACONITUM, ModBlocks.CROP_ACONITUM, new ItemAconitum(), LibItemName.SEED_ACONITUM);
		registerCrop(ASPHODEL, ModBlocks.CROP_ASPHODEL, new ItemAsphodel(), LibItemName.SEED_ASPHODEL);
		registerCrop(BELLADONNA, ModBlocks.CROP_BELLADONNA, new ItemBelladonna(), LibItemName.SEED_BELLADONNA);
		registerCrop(GINGER, ModBlocks.CROP_GINGER, new ItemGinger(), LibItemName.SEED_GINGER);
		registerCrop(KELP, ModBlocks.CROP_KELP, new ItemKelp(), new ItemKelpSeed());

		CropRegistry.getFoods().forEach((crop, item) -> event.getRegistry().register(item));
		CropRegistry.getSeeds().forEach((crop, item) -> event.getRegistry().register(item));

		//Normal Items
		event.getRegistry().registerAll(
				new ItemMod(LibItemName.GARNET),
				new ItemMod(LibItemName.MOLDAVITE),
				new ItemMod(LibItemName.NUUMMITE),
				new ItemMod(LibItemName.PETOSKEY_STONE),
				new ItemMod(LibItemName.SERPENTINE),
				new ItemMod(LibItemName.TIGERS_EYE),
				new ItemMod(LibItemName.TOURMALINE),
				new ItemMod(LibItemName.BLOODSTONE),
				new ItemMod(LibItemName.JASPER),
				new ItemMod(LibItemName.MALACHITE),
				new ItemMod(LibItemName.AMETHYST),
				new ItemMod(LibItemName.ALEXANDRITE),
				new ItemMod(LibItemName.QUARTZ),
				new ItemMod(LibItemName.SILVER_POWDER),
				new ItemMod(LibItemName.SILVER_INGOT),
				new ItemMod(LibItemName.SILVER_NUGGET),
				new ItemMod(LibItemName.HONEY)

		);

		//Item Blocks
		event.getRegistry().registerAll(
				itemBlock(ModBlocks.CROP_ACONITUM),
				itemBlock(ModBlocks.CROP_ASPHODEL),
				itemBlock(ModBlocks.CROP_BELLADONNA),
				itemBlock(ModBlocks.CROP_GINGER),
				itemBlock(ModBlocks.CROP_KELP),
				itemBlock(ModBlocks.SILVER_BLOCK),
				itemBlock(ModBlocks.COQUINA),
				itemBlock(ModBlocks.KETTLE)
		);
	}

	private static Item itemBlock(Block block) {
		return new ItemBlock(block).setRegistryName(block.getRegistryName());
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				new BlockAconitum(),
				new BlockAsphodel(),
				new BlockBelladonna(),
				new BlockGinger(),
				new BlockKelp(),
				ModBlocks.SILVER_BLOCK,
				new BlockKettle()
		);
	}

	@SubscribeEvent
	public static void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().registerAll();
	}

	/**
	 * Register a Crop to the {@link CropRegistry}, this method creates a new {@link ItemSeed} for you.
	 *
	 * @param crop      The Crop enum
	 * @param blockCrop The block this Crop can have
	 * @param cropItem  The item this Crop will drop when harvested
	 * @param seedName  The name id the new ItemSeed
	 */
	private static void registerCrop(Crop crop, BlockCrop blockCrop, ItemCrop cropItem, String seedName) {
		registerCrop(crop, blockCrop, cropItem, new ItemSeed(seedName, blockCrop, crop.getSoil()));
	}

	/**
	 * Register a Crop to the {@link CropRegistry}, this method accepts a custom {@link ItemSeed}.
	 * <p>
	 * The Item Seed needs to be different, for ex the Kelp seed,
	 * that needs to be placed on water so it uses a different placement logic.
	 * </p>
	 *
	 * @param crop      The Crop enum
	 * @param blockCrop The block this Crop can have
	 * @param cropItem  The item this Crop will drop when harvested
	 * @param seedItem  The seed that will place the Crop
	 */
	private static void registerCrop(Crop crop, BlockCrop blockCrop, ItemCrop cropItem, Item seedItem) {
		blockCrop.setCrop(cropItem);
		blockCrop.setSeed(seedItem);

		CropRegistry.getSeeds().put(crop, seedItem);
		CropRegistry.getCrops().put(crop, blockCrop);
		CropRegistry.getFoods().put(crop, cropItem);
	}
}
