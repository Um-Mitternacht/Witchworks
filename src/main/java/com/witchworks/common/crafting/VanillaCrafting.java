package com.witchworks.common.crafting;

import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.item.ModItems;
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
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class VanillaCrafting {

	private VanillaCrafting() {
	}

	public static void items() {

		shaped().grid("NNN", "NNN", "NNN")
				.map('N', ModItems.SILVER_NUGGET)
				.outputs(ModItems.SILVER_INGOT)
				.build();

		shaped().grid("N N", "NNN", "NNN")
				.map('N', ModItems.SILVER_INGOT)
				.outputs(ModItems.SILVER_CHESTPLATE)
				.build();

		shaped().grid("NNN", "N N", "   ")
				.map('N', ModItems.SILVER_INGOT)
				.outputs(ModItems.SILVER_HELMET)
				.build();

		shaped().grid("NNN", "N N", "N N")
				.map('N', ModItems.SILVER_INGOT)
				.outputs(ModItems.SILVER_LEGGINGS)
				.build();

		shaped().grid("   ", "N N", "N N")
				.map('N', ModItems.SILVER_INGOT)
				.outputs(ModItems.SILVER_BOOTS)
				.build();

		shaped().grid(" N ", " N ", " S ")
				.map('N', ModItems.SILVER_INGOT)
				.map('S', Items.STICK)
				.outputs(ModItems.SILVER_SWORD)
				.build();

		shaped().grid(" N ", " S ", " S ")
				.map('N', ModItems.SILVER_INGOT)
				.map('S', Items.STICK)
				.outputs(ModItems.SILVER_SPADE)
				.build();

		shaped().grid("NN ", "NS ", " S ")
				.map('N', ModItems.SILVER_INGOT)
				.map('S', Items.STICK)
				.outputs(ModItems.SILVER_AXE)
				.build();

		shaped().grid("NN ", " S ", " S ")
				.map('N', ModItems.SILVER_INGOT)
				.map('S', Items.STICK)
				.outputs(ModItems.SILVER_HOE)
				.build();

		shaped().grid("NNN", " S ", " S ")
				.map('N', ModItems.SILVER_INGOT)
				.map('S', Items.STICK)
				.outputs(ModItems.SILVER_PICKAXE)
				.build();

		shapeless()
				.add(Items.NETHERBRICK)
				.add(Items.NETHERBRICK)
				.add(Items.QUARTZ)
				.add(Items.IRON_INGOT)
				.outputs(new ItemStack(ModBlocks.NETHERSTEEL, 4))
				.build();

		shapeless()
				.add(ModItems.MORTAR_AND_PESTLE)
				.add(ModBlocks.SILVER_ORE)
				.outputs(new ItemStack(ModItems.SILVER_POWDER, 1))
				.build();

		shapeless()
				.add(ModItems.SILVER_INGOT)
				.outputs(new ItemStack(ModItems.SILVER_NUGGET, 9))
				.build();

		shapeless().add(ModBlocks.SILVER_BLOCK)
				.outputs(new ItemStack(ModItems.SILVER_INGOT, 9))
				.build();

		shaped().grid(" N ", "NGN", " S ")
				.map('N', ModItems.SILVER_INGOT)
				.map('G', ModItems.ALEXANDRITE)
				.map('S', Items.STICK)
				.outputs(ModItems.ATHAME)
				.build();

		shaped().grid("NN ", "  N", " B ")
				.map('N', ModItems.SILVER_INGOT)
				.map('B', ModItems.BLOODSTONE)
				.outputs(ModItems.BOLINE)
				.build();

		shapeless().add(ModItems.TAGLOCK)
				.outputs(ModItems.TAGLOCK)
				.build();
	}

	public static void blocks() {
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

		for (int i = 0; i < 16; i++) {
			shapeless()
					.add(ModItems.WAX)
					.add(ModItems.WAX)
					.add(ModBlocks.CANDLE_MEDIUM)
					.add(new ItemStack(Items.DYE, 1, 15 - i))
					.outputs(new ItemStack(ModBlocks.CANDLE_LARGE, 1, i))
					.build();
		}

		shaped().grid("III", "III", "III")
				.map('I', ModItems.SILVER_INGOT)
				.outputs(ModBlocks.SILVER_BLOCK)
				.build();

		shaped().grid("BBB", "BBB", "BBB")
				.map('B', ModItems.BLOODSTONE)
				.outputs(ModBlocks.BLOODSTONE_BLOCK)
				.build();

		shaped().grid("TTT", "TTT", "TTT")
				.map('T', ModItems.TOURMALINE)
				.outputs(ModBlocks.TOURMALINE_BLOCK)
				.build();

		shaped().grid("MMM", "MMM", "MMM")
				.map('M', ModItems.MOLDAVITE)
				.outputs(ModBlocks.MOLDAVITE_BLOCK)
				.build();

		shaped().grid("N N", "ISI", "III")
				.map('I', Items.IRON_INGOT)
				.map('N', Items.field_191525_da)
				.map('S', ModItems.SILVER_INGOT)
				.outputs(ModBlocks.CAULDRON)
				.build();

		shaped().grid("WWW", "WHW", "WWW")
				.map('W', "plankWood")
				.map('H', Items.ITEM_FRAME)
				.outputs(ModBlocks.APIARY)
				.build();

		shaped().grid("LML", "SSS", "WWW")
				.map('W', "plankWood")
				.map('S', Blocks.STONE)
				.map('L', Blocks.CARPET)
				.map('M', ModItems.MOLDAVITE)
				.outputs(ModBlocks.ALTAR)
				.build();

		shapeless()
				.add(ModBlocks.MOLDAVITE_BLOCK)
				.outputs(new ItemStack(ModItems.MOLDAVITE, 9))
				.build();

		shapeless()
				.add(ModBlocks.TOURMALINE_BLOCK)
				.outputs(new ItemStack(ModItems.TOURMALINE, 9))
				.build();

		shapeless()
				.add(ModBlocks.BLOODSTONE_BLOCK)
				.outputs(new ItemStack(ModItems.BLOODSTONE, 9))
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
	}
}
