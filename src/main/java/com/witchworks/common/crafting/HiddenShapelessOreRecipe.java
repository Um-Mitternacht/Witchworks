package com.witchworks.common.crafting;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class was created by BerciTheBeast on 12.4.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
public class HiddenShapelessOreRecipe implements IRecipe {

	private ItemStack output;
	private ArrayList<Object> input = new ArrayList<>();

	public HiddenShapelessOreRecipe(ItemStack result, Object... recipe) {
		output = result.copy();
		for (Object in : recipe) {
			if (in instanceof ItemStack) {
				input.add(((ItemStack) in).copy());
			} else if (in instanceof Item) {
				input.add(new ItemStack((Item) in));
			} else if (in instanceof Block) {
				input.add(new ItemStack((Block) in));
			} else if (in instanceof String) {
				input.add(OreDictionary.getOres((String) in));
			} else {
				String ret = "Invalid shapeless ore recipe: ";
				for (Object tmp : recipe) {
					ret += tmp + ", ";
				}
				ret += output;
				throw new RuntimeException(ret);
			}
		}
	}

	@Override
	public int getRecipeSize() {
		return input.size();
	}

	@Override
	public ItemStack getRecipeOutput() {
		return output;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		return output.copy();
	}

	@SuppressWarnings ("unchecked")
	@Override
	public boolean matches(InventoryCrafting var1, World world) {
		final ArrayList<Object> required = new ArrayList<>(input);

		for (int x = 0; x < var1.getSizeInventory(); x++) {
			final ItemStack slot = var1.getStackInSlot(x);

			if (slot != null) {
				boolean inRecipe = false;

				for (Object aRequired : required) {
					boolean match = false;

					if (aRequired instanceof ItemStack) {
						match = OreDictionary.itemMatches((ItemStack) aRequired, slot, false);
					} else if (aRequired instanceof List) {
						final Iterator<ItemStack> itr = ((List<ItemStack>) aRequired).iterator();
						while (itr.hasNext() && !match) {
							match = OreDictionary.itemMatches(itr.next(), slot, false);
						}
					}

					if (match) {
						inRecipe = true;
						required.remove(aRequired);
						break;
					}
				}

				if (!inRecipe) {
					return false;
				}
			}
		}

		return required.isEmpty();
	}

	/**
	 * Returns the input for this recipe, any mod accessing this value should never
	 * manipulate the values in this array as it will effect the recipe itself.
	 * @return The recipes input vales.
	 */
	public ArrayList<Object> getInput() {
		return this.input;
	}

	@Override
	public ItemStack[] getRemainingItems(InventoryCrafting inv) {
		return ForgeHooks.defaultRecipeGetRemainingItems(inv);
	}
}
