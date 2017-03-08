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
		shaped().grid("MAA") //Test recipe
				.map('M', Items.MELON)
				.map('A', Items.APPLE)
				.outputs(Items.SUGAR)
				.setMirror(true).build();

		for (ItemStack item : OreDictionary.getOres("nuggetSilver")) {
			System.out.println(item);
			shaped().grid("NNN", "NNN", "NNN")
					.map('N', item)
					.outputs(ModItems.SILVER_INGOT)
					.setMirror(true).build();
		}
		for (ItemStack item : OreDictionary.getOres("ingotSilver")) {
			shaped().grid("I")
					.map('I', item)
					.outputs(new ItemStack(ModItems.SILVER_NUGGET, 9))
					.setMirror(true).build();
		}

		for (ItemStack item : OreDictionary.getOres("gemMalachite")) {
			shaped().grid("LJ")
					.map('L', new ItemStack(Items.DYE, 1, 4))
					.map('J', ModItems.JASPER)
					.outputs(new ItemStack(ModItems.MALACHITE, 1))
					.setMirror(true).build();

		}
		shaped().grid("B")
				.map('B', ModBlocks.SILVER_BLOCK)
				.outputs(new ItemStack(ModItems.SILVER_INGOT, 9))
				.setMirror(true).build();

	}

	public static void blocks() {
		shaped().grid("III", "III", "III")
				.map('I', ModItems.SILVER_INGOT)
				.outputs(ModBlocks.SILVER_BLOCK)
				.setMirror(true).build();

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
				throw new IllegalArgumentException("You have to specify ingredients for the recipe");
			if (out == null) throw new IllegalArgumentException("Output not specified");

			ShapelessOreRecipe recipe = new ShapelessOreRecipe(out, ingredients.toArray());
			CraftingManager.getInstance().getRecipeList().add(recipe);
		}
	}
}
