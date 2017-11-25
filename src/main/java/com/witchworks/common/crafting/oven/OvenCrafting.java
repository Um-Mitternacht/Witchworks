package com.witchworks.common.crafting.oven;

import com.google.common.collect.Maps;
import com.witchworks.common.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Map;

/**
 * Created by Joseph on 11/6/2017.
 */

//Todo: Add RNG for fumes, and add an optional setting for glass jars.
public class OvenCrafting {

	private static final OvenCrafting OVEN_RECIPES = new OvenCrafting();
	private final Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
	private final Map<ItemStack, ItemStack> fumeList = Maps.<ItemStack, ItemStack>newHashMap();

	public OvenCrafting() {
		//test recipes
		addSmeltingRecipe(new ItemStack(Blocks.SAPLING), new ItemStack(ModItems.brew_phial_drink), new ItemStack(ModItems.wood_ash));
		addSmeltingRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.LEATHER), new ItemStack(ModItems.ectoplasm, 3));
		addSmeltingRecipe(new ItemStack(Blocks.IRON_ORE), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_NUGGET, 3));
	}

	public static OvenCrafting instance() {
		return OVEN_RECIPES;
	}

	/**
	 * @param input      the input stack
	 * @param output     what outpurs
	 * @param outputFume the output for the fume slot
	 */
	public void addSmeltingRecipe(ItemStack input, ItemStack output, ItemStack outputFume) {
		if (getSmeltResult(input) != ItemStack.EMPTY) {
			net.minecraftforge.fml.common.FMLLog.log.info("Ignored smelting recipe with conflicting input, please report to author: {} = {}", input, output);
			return;
		}
		this.smeltingList.put(input, output);
		this.fumeList.put(input, outputFume);
	}

	public ItemStack getSmeltResult(ItemStack stack) {
		for (Map.Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return entry.getValue();
			}
		}

		return ItemStack.EMPTY;
	}

	public ItemStack getFumesResult(ItemStack stack) {
		for (Map.Entry<ItemStack, ItemStack> entry : this.fumeList.entrySet()) {
			if (this.compareItemStacks(stack, entry.getKey())) {
				return entry.getValue();
			}
		}

		return ItemStack.EMPTY;
	}


	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}

	public Map<ItemStack, ItemStack> getSmeltingList() {
		return this.smeltingList;
	}
}
