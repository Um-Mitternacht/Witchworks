package com.wiccanarts.common.crafting;

import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.List;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class VanillaCrafting {

	public static void items() {

		for (ItemStack item : OreDictionary.getOres("nuggetSilver")) {
			System.out.println(item);
			shaped().grid("NNN", "NNN", "NNN")
					.map('N', item)
					.outputs(ModItems.SILVER_INGOT)
					.setMirror(true).build();
		}

		for (ItemStack item : OreDictionary.getOres("gemBloodstone")) {
			System.out.println(item);
			shaped().grid("BBB", "BBB", "BBB")
					.map('B', item)
					.outputs(ModBlocks.BLOODSTONE_BLOCK)
					.setMirror(true).build();
		}

		for (ItemStack item : OreDictionary.getOres("gemMoldavite")) {
			System.out.println(item);
			shaped().grid("MMM", "MMM", "MMM")
					.map('M', item)
					.outputs(ModBlocks.MOLDAVITE_BLOCK)
					.setMirror(true).build();
		}

		for (ItemStack item : OreDictionary.getOres("blockMoldavite")) {
			shapeless()
					.add(item)
					.outputs(new ItemStack(ModItems.MOLDAVITE, 9))
					.build();
		}

		for (ItemStack item : OreDictionary.getOres("blockBloodstone")) {
			shapeless()
					.add(item)
					.outputs(new ItemStack(ModItems.BLOODSTONE, 9))
					.build();
		}

		shapeless()
				.add(new ItemStack(Items.DYE, 1, 4))
				.add(ModItems.JASPER)
				.outputs(new ItemStack(ModItems.MALACHITE, 1))
				.build();


		shapeless()
				.add(ModItems.WAX)
				.add(ModItems.WAX)
				.add(Items.STRING)
				.outputs(new ItemStack(ModBlocks.CANDLE_SMALL, 1))
				.build();

		for (int i = 0; i < 16; i++) {
			shapeless()
					.add(ModItems.WAX)
					.add(ModItems.WAX)
					.add(Items.STRING)
					.add(new ItemStack(Items.DYE, 1, i))
					.outputs(new ItemStack(ModBlocks.CANDLE_SMALL, 1, i))
					.build();
		}

		shapeless()
				.add(ModItems.WAX)
				.add(ModBlocks.CANDLE_SMALL)
				.add(ModBlocks.CANDLE_SMALL)
				.outputs(new ItemStack(ModBlocks.CANDLE_MEDIUM, 1))
				.build();

		for (int i = 0; i < 16; i++) {
			shapeless()
					.add(ModItems.WAX)
					.add(ModBlocks.CANDLE_SMALL)
					.add(ModBlocks.CANDLE_SMALL)
					.add(new ItemStack(Items.DYE, 1, i))
					.outputs(new ItemStack(ModBlocks.CANDLE_MEDIUM, 1, i))
					.build();
		}

		shapeless()
				.add(ModItems.WAX)
				.add(ModBlocks.CANDLE_MEDIUM)
				.add(ModBlocks.CANDLE_MEDIUM)
				.outputs(new ItemStack(ModBlocks.CANDLE_LARGE, 1))
				.build();

		for (int i = 0; i < 16; i++) {
			shapeless()
					.add(ModItems.WAX)
					.add(ModBlocks.CANDLE_MEDIUM)
					.add(ModBlocks.CANDLE_MEDIUM)
					.add(new ItemStack(Items.DYE, 1, i))
					.outputs(new ItemStack(ModBlocks.CANDLE_LARGE, 1, i))
					.build();
		}

		for (ItemStack item : OreDictionary.getOres("ingotSilver")) {
			shapeless()
					.add(item)
					.outputs(new ItemStack(ModItems.SILVER_NUGGET, 9))
					.build();
		}

		shapeless().add(ModBlocks.SILVER_BLOCK)
				.outputs(new ItemStack(ModItems.SILVER_INGOT, 9))
				.build();
	}

	public static void blocks() {

		shaped().grid("III", "III", "III")
				.map('I', ModItems.SILVER_INGOT)
				.outputs(ModBlocks.SILVER_BLOCK)
				.build();
	}

	private static ShapedRecipe shaped() {
		return new ShapedRecipe();
	}

	private static ShapelessRecipe shapeless() {
		return new ShapelessRecipe();
	}

	@SuppressWarnings({"unused", "WeakerAccess"})
	private static class ShapelessRecipe {

		private final List<Object> ingredients = new ArrayList<>();
		private ItemStack out = null;

		public ShapelessRecipe outputs(Block out) {
			return outputs(new ItemStack(out));
		}

		public ShapelessRecipe outputs(Item out) {
			return outputs(new ItemStack(out));
		}

		public ShapelessRecipe outputs(ItemStack out) {
			this.out = out;
			return this;
		}

		public ShapelessRecipe add(Block block) {
			ingredients.add(block);
			return this;
		}

		public ShapelessRecipe add(Item item) {
			ingredients.add(item);
			return this;
		}

		public ShapelessRecipe add(ItemStack stack) {
			ingredients.add(stack);
			return this;
		}

		public ShapelessRecipe add(String string) {
			ingredients.add(string);
			return this;
		}

		public void build() {

			if (ingredients.isEmpty())
				throw new IllegalArgumentException("You have to specify ingredients for the recipe!");
			if (out == null) throw new IllegalArgumentException("Output not specified!");

			ShapelessOreRecipe recipe = new ShapelessOreRecipe(out, ingredients.toArray());
			CraftingManager.getInstance().getRecipeList().add(recipe);
		}
	}
}
