package com.witchworks.client.gui.container;

import com.witchworks.common.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Created by Joseph on 7/17/2017.
 */
public class ContainerOven extends Container {

	//Todo: Continue, life is getting in the way, as well as a damaged sleep cycle.
	private final IInventory oven;

	public ContainerOven(InventoryPlayer playerInventory, IInventory inventory) {
		this.oven = inventory;
		this.addSlotToContainer(new ContainerOven.SlotOvenFuel(inventory, 0, 26, 34));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				this.addSlotToContainer(new ContainerOven.SlotOvenItem(inventory, j + i * 6 + 1, 62 + j * 18, 16 + i * 18));
			}
		}

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}
	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.oven);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		final Slot slot = inventorySlots.get(slotIndex);
		ItemStack copy = ItemStack.EMPTY;

		if (slot != null && slot.getHasStack()) {
			final ItemStack original = slot.getStack();
			copy = original.copy();

			if (slotIndex == 0) {
				if (!mergeItemStack(original, 4, 55, true)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			} else if (slotIndex > 4) {
				if (original.getCount() == 1 && !mergeItemStack(original, 0, 1, false)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			} else {
				if (!mergeItemStack(original, 4, 55, true)) return ItemStack.EMPTY;
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

	private class SlotOvenFuel extends Slot {

		SlotOvenFuel(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public boolean isItemValid(@Nullable ItemStack stack) {
			return stack != null;
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return !playerIn.isSpectator();
	}

	private class SlotOvenItem extends Slot {

		SlotOvenItem(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public boolean isItemValid(@Nullable ItemStack stack) {
			return stack != null;
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}
}