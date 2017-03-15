package com.wiccanarts.common.core;

import com.wiccanarts.api.WiccanArtsAPI;
import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.item.ModItems;
import com.wiccanarts.common.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class WiccanArtsCreativeTabs {

	public static final PlantsCreativeTab PLANTS_CREATIVE_TAB = new PlantsCreativeTab();
	public static final ItemsCreativeTab ITEMS_CREATIVE_TAB = new ItemsCreativeTab();

	private static abstract class CreativeTab extends CreativeTabs {

		List<ItemStack> list;

		CreativeTab(String name) {
			super(LibMod.MOD_ID + name);
			setNoTitle();
		}

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return getIconItemStack().getItem();
		}

		@SideOnly(Side.CLIENT)
		void addItem(Item item) {
			item.getSubItems(item, this, list);
		}

		@SideOnly(Side.CLIENT)
		void addBlock(Block block) {
			ItemStack stack = new ItemStack(block);
			block.getSubBlocks(stack.getItem(), this, list);
		}
	}

	private static class PlantsCreativeTab extends CreativeTab {

		PlantsCreativeTab() {
			super("_plants");
			setBackgroundImageName("item_search.png");
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() {
			return new ItemStack(Items.FLOWER_POT);
		}

		@Override
		public boolean hasSearchBar() {
			return true;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public void displayAllRelevantItems(List<ItemStack> list) {
			this.list = list;
			WiccanArtsAPI.CropRegistry.getFoods().forEach((crop, itemModFood) -> addItem(itemModFood));
			WiccanArtsAPI.CropRegistry.getSeeds().forEach((crop, item) -> addItem(item));
		}
	}

	private static class ItemsCreativeTab extends CreativeTab {

		ItemsCreativeTab() {
			super("_items");
			setBackgroundImageName("item_search.png");
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() {
			return new ItemStack(Items.BONE);
		}

		@Override
		public boolean hasSearchBar() {
			return true;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public void displayAllRelevantItems(List<ItemStack> list) {
			this.list = list;
			addItem(ModItems.GARNET);
			addItem(ModItems.NUUMMITE);
			addItem(ModItems.MOLDAVITE);
			addItem(ModItems.PETOSKEY_STONE);
			addItem(ModItems.SERPENTINE);
			addItem(ModItems.TOURMALINE);
			addItem(ModItems.TIGERS_EYE);
			addItem(ModItems.BLOODSTONE);
			addItem(ModItems.JASPER);
			addItem(ModItems.MALACHITE);
			addItem(ModItems.AMETHYST);
			addItem(ModItems.ALEXANDRITE);
			addItem(ModItems.QUARTZ);
			addItem(ModItems.SILVER_POWDER);
			addItem(ModItems.SILVER_INGOT);
			addItem(ModItems.SILVER_NUGGET);
			addItem(ModItems.HONEY);
			addItem(ModItems.WAX);
			addItem(ModItems.SALT);
			addItem(ModItems.HONEYCOMB);
			addItem(ModItems.BEE);
			addItem(ModItems.LAVENDER_SPRIG);
			addBlock(ModBlocks.SILVER_BLOCK);
			addBlock(ModBlocks.COQUINA);
			addBlock(ModBlocks.KETTLE);
			addBlock(ModBlocks.SILVER_ORE);
			addBlock(ModBlocks.MOLDAVITE_ORE);
			addBlock(ModBlocks.MOLDAVITE_BLOCK);
			addBlock(ModBlocks.BLOODSTONE_BLOCK);
			addBlock(ModBlocks.NETHERSTEEL);
			addBlock(ModBlocks.CANDLE_LARGE);
			addBlock(ModBlocks.CANDLE_MEDIUM);
			addBlock(ModBlocks.CANDLE_SMALL);
		}
	}
}
