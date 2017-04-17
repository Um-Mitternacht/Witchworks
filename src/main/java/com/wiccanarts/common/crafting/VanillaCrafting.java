package com.wiccanarts.common.crafting;

import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.List;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class VanillaCrafting {

	private VanillaCrafting() {
	}

	public static void items() {

		shaped().grid("NNN", "NNN", "NNN")
				.map('N', "nuggetSilver")
				.outputs(ModItems.SILVER_INGOT)
				.build();

		shaped().grid("BBB", "BBB", "BBB")
				.map('B', "gemBloodstone")
				.outputs(ModBlocks.BLOODSTONE_BLOCK)
				.build();

		shaped().grid("TTT", "TTT", "TTT")
				.map('T', "gemTourmaline")
				.outputs(ModBlocks.TOURMALINE_BLOCK)
				.build();

		shaped().grid("MMM", "MMM", "MMM")
				.map('M', "gemMoldavite")
				.outputs(ModBlocks.MOLDAVITE_BLOCK)
				.build();

		shaped().grid("WWW", "WHW", "WWW")
				.map('W', "plankWood")
				.map('H', ModItems.EMPTY_HONEYCOMB)
				.outputs(ModBlocks.APIARY)
				.build();

		shaped().grid("LSL", "SSS", "WWW")
				.map('W', "plankWood")
				.map('S', Blocks.STONE)
				.map('L', Blocks.CARPET)
				.outputs(ModBlocks.ALTAR)
				.build();

		shapeless()
				.add("blockMoldavite")
				.outputs(new ItemStack(ModItems.MOLDAVITE, 9))
				.build();

		shapeless()
				.add("blockTourmaline")
				.outputs(new ItemStack(ModItems.TOURMALINE, 9))
				.build();

		shapeless()
				.add("blockBloodstone")
				.outputs(new ItemStack(ModItems.BLOODSTONE, 9))
				.build();

		shapeless()
				.add(Items.NETHERBRICK)
				.add(Items.NETHERBRICK)
				.add(Items.QUARTZ)
				.add(Items.IRON_INGOT)
				.outputs(new ItemStack(ModBlocks.NETHERSTEEL, 4))
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
					.add(new ItemStack(Items.DYE, 1, 15 - i))
					.outputs(new ItemStack(ModBlocks.CANDLE_SMALL, 1, i))
					.build();
		}

		shapeless()
				.add(ModItems.WAX)
				.add(ModItems.WAX)
				.add(ModBlocks.CANDLE_SMALL)
				.outputs(new ItemStack(ModBlocks.CANDLE_MEDIUM, 1))
				.build();

		for (int i = 0; i < 16; i++) {
			shapeless()
					.add(ModItems.WAX)
					.add(ModItems.WAX)
					.add(ModBlocks.CANDLE_SMALL)
					.add(new ItemStack(Items.DYE, 1, 15 - i))
					.outputs(new ItemStack(ModBlocks.CANDLE_MEDIUM, 1, i))
					.build();
		}

		shapeless()
				.add(ModItems.WAX)
				.add(ModItems.WAX)
				.add(ModBlocks.CANDLE_MEDIUM)
				.outputs(new ItemStack(ModBlocks.CANDLE_LARGE, 1))
				.build();

		shapeless()
				.add(new ItemStack(Items.DYE, 1, 4))
				.add(ModItems.JASPER)
				.outputs(new ItemStack(ModItems.MALACHITE, 1))
				.buildHidden();

		for (int i = 0; i < 16; i++) {
			shapeless()
					.add(ModItems.WAX)
					.add(ModItems.WAX)
					.add(ModBlocks.CANDLE_MEDIUM)
					.add(new ItemStack(Items.DYE, 1, 15 - i))
					.outputs(new ItemStack(ModBlocks.CANDLE_LARGE, 1, i))
					.build();
		}

		shapeless()
				.add("ingotSilver")
				.outputs(new ItemStack(ModItems.SILVER_NUGGET, 9))
				.build();

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

	@SuppressWarnings ({"unused", "WeakerAccess"})
	private static class ShapelessRecipe {

		private final List<Object> ingredients = new ArrayList<>();
		private ItemStack output;

		public ShapelessRecipe outputs(Block out) {
			return outputs(new ItemStack(out));
		}

		public ShapelessRecipe outputs(Item out) {
			return outputs(new ItemStack(out));
		}

		public ShapelessRecipe outputs(ItemStack out) {
			this.output = out;
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
				throw new IllegalArgumentException("You have to specify ingredients for the recipe, please report this!");
			if (output == null) throw new IllegalArgumentException("Output not specified, please report this!");

			final ShapelessOreRecipe recipe = new ShapelessOreRecipe(output, ingredients.toArray());
			CraftingManager.getInstance().getRecipeList().add(recipe);
		}

		public void buildHidden() {
			if (ingredients.isEmpty())
				throw new IllegalArgumentException("You have to specify ingredients for the recipe, please report this!");
			if (output == null) throw new IllegalArgumentException("Output not specified, please report this!");

			final HiddenShapelessOreRecipe recipe = new HiddenShapelessOreRecipe(output, ingredients.toArray());
			CraftingManager.getInstance().getRecipeList().add(recipe);
		}
	}
}
