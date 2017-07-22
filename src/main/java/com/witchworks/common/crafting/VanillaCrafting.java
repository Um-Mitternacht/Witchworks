package com.witchworks.common.crafting;

import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.item.ModItems;
import com.witchworks.common.item.ModMaterials;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
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
				.map('N', ModItems.silver_nugget)
				.outputs(ModItems.silver_ingot)
				.build();

		shaped().grid("N N", "NNN", "NNN")
				.map('N', ModItems.silver_ingot)
				.outputs(ModItems.silver_chestplate)
				.build();

		shaped().grid("NNN", "N N", "   ")
				.map('N', ModItems.silver_ingot)
				.outputs(ModItems.silver_helmet)
				.build();

		shaped().grid("NNN", "N N", "N N")
				.map('N', ModItems.silver_ingot)
				.outputs(ModItems.silver_leggings)
				.build();

		shaped().grid("   ", "N N", "N N")
				.map('N', ModItems.silver_ingot)
				.outputs(ModItems.silver_boots)
				.build();

		shaped().grid(" N ", " N ", " S ")
				.map('N', ModItems.silver_ingot)
				.map('S', Items.STICK)
				.outputs(ModItems.silver_sword)
				.build();

		shaped().grid(" N ", " S ", " S ")
				.map('N', ModItems.silver_ingot)
				.map('S', Items.STICK)
				.outputs(ModItems.silver_spade)
				.build();

		shaped().grid("NN ", "NS ", " S ")
				.map('N', ModItems.silver_ingot)
				.map('S', Items.STICK)
				.outputs(ModItems.silver_axe)
				.build();

		shaped().grid("NN ", " S ", " S ")
				.map('N', ModItems.silver_ingot)
				.map('S', Items.STICK)
				.outputs(ModItems.silver_hoe)
				.build();

		shaped().grid("NNN", " S ", " S ")
				.map('N', ModItems.silver_ingot)
				.map('S', Items.STICK)
				.outputs(ModItems.silver_pickaxe)
				.build();

		shapeless()
				.add(Items.NETHERBRICK)
				.add(Items.NETHERBRICK)
				.add(Items.QUARTZ)
				.add(Items.IRON_INGOT)
				.outputs(new ItemStack(ModBlocks.nethersteel, 4))
				.build();

		shapeless()
				.add(ModItems.glass_jar)
				.add(ModItems.needle_bone)
				.outputs(new ItemStack(ModItems.taglock, 1))
				.build();

		shapeless()
				.add(Items.FLINT)
				.add(Items.BONE)
				.outputs(new ItemStack(ModItems.needle_bone, 8))
				.build();

		shapeless()
				.add(ModItems.mortar_and_pestle)
				.add(ModBlocks.silver_ore)
				.outputs(new ItemStack(ModItems.silver_powder, 2))
				.build();

		shapeless()
				.add(ModItems.silver_ingot)
				.outputs(new ItemStack(ModItems.silver_nugget, 9))
				.build();

		shapeless().add(ModBlocks.silver_block)
				.outputs(new ItemStack(ModItems.silver_ingot, 9))
				.build();

		shaped().grid(" N ", "NGN", " S ")
				.map('N', ModItems.silver_ingot)
				.map('G', new ItemStack(ModItems.gem, 1, 9))
				.map('S', Items.STICK)
				.outputs(ModItems.athame)
				.build();

		shaped().grid("NN ", "  N", " B ")
				.map('N', ModItems.silver_ingot)
				.map('B', new ItemStack(ModItems.gem, 1, 5))
				.outputs(ModItems.boline)
				.build();

		shaped().grid(" S ", "G G", " G ")
				.map('G', Blocks.GLASS_PANE)
				.map('S', "slabWood")
				.outputs(new ItemStack(ModItems.glass_jar, 3))
				.build();

		shaped().grid(" T ", "S S", " S ")
				.map('T', Items.STICK)
				.map('S', Blocks.WOODEN_SLAB)
				.outputs(ModItems.mortar_and_pestle)
				.build();

		shapeless()
				.add(ModItems.taglock)
				.outputs(ModItems.taglock)
				.build();
	}

	private static ShapedRecipe shaped() {
		return new ShapedRecipe();
	}

	private static ShapelessRecipe shapeless() {
		return new ShapelessRecipe();
	}

	public static void blocks() {
		shapeless()
				.add(ModItems.wax)
				.add(ModItems.wax)
				.add(Items.STRING)
				.outputs(new ItemStack(ModBlocks.candle_small, 1))
				.build();

		for (int i = 0; i < 16; i++) {
			shapeless()
					.add(ModItems.wax)
					.add(ModItems.wax)
					.add(Items.STRING)
					.add(new ItemStack(Items.DYE, 1, 15 - i))
					.outputs(new ItemStack(ModBlocks.candle_small, 1, i))
					.build();
		}

		shapeless()
				.add(ModItems.wax)
				.add(ModItems.wax)
				.add(ModBlocks.candle_small)
				.outputs(new ItemStack(ModBlocks.candle_medium, 1))
				.build();

		for (int i = 0; i < 16; i++) {
			shapeless()
					.add(ModItems.wax)
					.add(ModItems.wax)
					.add(ModBlocks.candle_small)
					.add(new ItemStack(Items.DYE, 1, 15 - i))
					.outputs(new ItemStack(ModBlocks.candle_medium, 1, i))
					.build();
		}

		shapeless()
				.add(ModItems.wax)
				.add(ModItems.wax)
				.add(ModBlocks.candle_medium)
				.outputs(new ItemStack(ModBlocks.candle_large, 1))
				.build();

		for (int i = 0; i < 16; i++) {
			shapeless()
					.add(ModItems.wax)
					.add(ModItems.wax)
					.add(ModBlocks.candle_medium)
					.add(new ItemStack(Items.DYE, 1, 15 - i))
					.outputs(new ItemStack(ModBlocks.candle_large, 1, i))
					.build();
		}

		shaped().grid("III", "III", "III")
				.map('I', ModItems.silver_ingot)
				.outputs(ModBlocks.silver_block)
				.build();

		shaped().grid("BBB", "BBB", "BBB")
				.map('B', new ItemStack(ModItems.gem, 1, 5))
				.outputs(ModBlocks.bloodstone_block)
				.build();

		shaped().grid("TTT", "TTT", "TTT")
				.map('T', new ItemStack(ModItems.gem, 1, 4))
				.outputs(ModBlocks.tourmaline_block)
				.build();

		shaped().grid("MMM", "MMM", "MMM")
				.map('M', new ItemStack(ModItems.gem, 1, 1))
				.outputs(ModBlocks.moldavite_block)
				.build();

		shaped().grid("N N", "ISI", "III")
				.map('I', Items.IRON_INGOT)
				.map('N', Items.field_191525_da)
				.map('S', ModItems.silver_ingot)
				.outputs(ModBlocks.cauldron)
				.build();

		shaped().grid("WWW", "WHW", "WWW")
				.map('W', "plankWood")
				.map('H', ModItems.empty_honeycomb)
				.outputs(ModBlocks.apiary)
				.build();

		shaped().grid("LML", "SSS", "WWW")
				.map('W', "plankWood")
				.map('S', Blocks.STONE)
				.map('L', Blocks.CARPET)
				.map('M', new ItemStack(ModItems.gem, 1, 1))
				.outputs(ModBlocks.altar)
				.build();

		shaped().grid(" I ", "NNN", "NIN")
				.map('I', Blocks.IRON_BARS)
				.map('N', Items.IRON_INGOT)
				.outputs(ModBlocks.oven)
				.build();

		shapeless()
				.add(ModBlocks.moldavite_block)
				.outputs(new ItemStack(ModItems.gem, 9, 1))
				.build();

		shapeless()
				.add(ModBlocks.tourmaline_block)
				.outputs(new ItemStack(ModItems.gem, 9, 4))
				.build();

		shapeless()
				.add(ModBlocks.bloodstone_block)
				.outputs(new ItemStack(ModItems.gem, 9, 5))
				.build();

		GameRegistry.addSmelting(ModBlocks.silver_ore, new ItemStack(ModItems.silver_ingot, 1), 0.35F);
		GameRegistry.addSmelting(Blocks.SAPLING, new ItemStack(ModItems.wood_ash, 4), 0.15F);
		ModMaterials.TOOL_RITUAL.setRepairItem(new ItemStack(ModItems.silver_ingot));
		ModMaterials.ARMOR_SILVER.setRepairItem(new ItemStack(ModItems.silver_ingot));
		ModMaterials.TOOL_SILVER.setRepairItem(new ItemStack(ModItems.silver_ingot));
	}

	@SuppressWarnings({"unused", "WeakerAccess"})
	private static class ShapelessRecipe {

		private final List<Object> ingredients = new ArrayList<>();
		private ItemStack output;

		public ShapelessRecipe outputs(Block out) {
			return outputs(new ItemStack(out));
		}

		public ShapelessRecipe outputs(ItemStack out) {
			this.output = out;
			return this;
		}

		public ShapelessRecipe outputs(Item out) {
			return outputs(new ItemStack(out));
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
			if (output == null) throw new IllegalArgumentException("Output not specified!");

			final ShapelessOreRecipe recipe = new ShapelessOreRecipe(output, ingredients.toArray());
			CraftingManager.getInstance().getRecipeList().add(recipe);
		}
	}
}
