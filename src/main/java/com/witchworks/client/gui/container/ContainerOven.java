package com.witchworks.client.gui.container;

import com.witchworks.common.tile.TileOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * Created by Joseph on 7/17/2017.
 */
public class ContainerOven extends Container {

	//Todo: Continue, life is getting in the way, as well as a damaged sleep cycle.
	private final IInventory oven;

	public ContainerOven(InventoryPlayer playerInventory, IInventory inventory) {
		this.oven = inventory;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		final Slot slot = inventorySlots.get(slotIndex);
		ItemStack copy = ItemStack.EMPTY;

		if (slot != null && slot.getHasStack()) {
			final ItemStack original = slot.getStack();
			copy = original.copy();

			if (slotIndex == 0) {
				if (!mergeItemStack(original, 5, 55, true)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			} else if (slotIndex > 5) {
				if (original.getCount() == 1 && !mergeItemStack(original, 0, 1, false)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			} else {
				if (!mergeItemStack(original, 5, 55, true)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			}

			if (original.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (original.getCount() == copy.getCount()) return ItemStack.EMPTY;

			slot.onTake(player, original);
		}

		return copy;
	}
}