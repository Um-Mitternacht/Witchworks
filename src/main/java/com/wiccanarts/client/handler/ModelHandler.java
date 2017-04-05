package com.wiccanarts.client.handler;

import com.wiccanarts.api.item.*;
import com.wiccanarts.common.lib.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraftforge.client.model.*;
import net.minecraftforge.fml.relauncher.*;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
@SideOnly(Side.CLIENT)
public final class ModelHandler {

	private ModelHandler() {
	}

	/**
	 * Register all Item and Block models from the registry.
	 */
	public static void registerModels() {
		for (Block block : Block.REGISTRY) {
			if (block instanceof IModelRegister)
				((IModelRegister) block).registerModels();
		}

		for (Item item : Item.REGISTRY) {
			if (item instanceof IModelRegister)
				((IModelRegister) item).registerModels();
		}
	}

	//Items
	public static void registerItem(Item item) {
		registerItem(item, 0);
	}

	public static void registerItem(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	public static void registerItemAllType(Item item, IStringSerializable[] values) {
		registerEnums(item, values, item.getRegistryName().getResourcePath());
	}

	public static void registerItemAllMeta(Item item, int metas) {
		registerMetas(item, metas, item.getRegistryName().getResourcePath());
	}

	//Blocks
	public static void registerBlock(Block block) {
		registerBlock(block, 0);
	}

	public static void registerBlock(Block block, int meta) {
		Item iBlock = Item.getItemFromBlock(block);
		if (iBlock == null) throw new IllegalArgumentException("Tried to register a block that doesn't have an item");
		ModelLoader.setCustomModelResourceLocation(iBlock, meta, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

	public static void registerBlockAllType(Block block, IStringSerializable[] values) {
		Item iBlock = Item.getItemFromBlock(block);
		if (iBlock == null) throw new IllegalArgumentException("Tried to register a block that doesn't have an item");
		registerEnums(iBlock, values, iBlock.getRegistryName().getResourcePath());
	}

	public static void registerBlockAllMeta(Block block, int metas) {
		Item iBlock = Item.getItemFromBlock(block);
		if (iBlock == null) throw new IllegalArgumentException("Tried to register a block that doesn't have an item");
		registerMetas(iBlock, metas, block.getRegistryName().getResourcePath());
	}

	/**
	 * Set a new model resource location to an Item for as many meta the item has.
	 *
	 * @param item     The Item
	 * @param maxMeta  The max meta
	 * @param itemName The name of the Item
	 */
	public static void registerMetas(Item item, int maxMeta, String itemName) {
		for (int i = 0; i < maxMeta; i++) {
			ModelLoader.setCustomModelResourceLocation(item, i,
					new ModelResourceLocation(LibMod.MOD_ID + ":" + itemName + "_" + i, "inventory")
			);
		}
	}

	/**
	 * Set a new model resource location to an Item for as many enums there are.
	 *
	 * @param item     The Item
	 * @param values   The enum which holds the different Item Types
	 * @param itemName The name of the Item
	 */
	public static void registerEnums(Item item, IStringSerializable[] values, String itemName) {
		for (int i = 0; i < values.length; i++) {
			IStringSerializable e = values[i];
			ModelLoader.setCustomModelResourceLocation(item, i,
					new ModelResourceLocation(LibMod.MOD_ID + ":" + itemName + "_" + e.getName(), "inventory")
			);
		}
	}
}
