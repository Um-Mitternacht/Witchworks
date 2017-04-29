package com.witchworks.client.gui.container;

import com.witchworks.common.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 16/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ContainerApiary extends Container {

	private final IInventory apiary;

	public ContainerApiary(InventoryPlayer playerInventory, IInventory inventory) {
		this.apiary = inventory;
		this.addSlotToContainer(new SlotBee(inventory, 0, 26, 34));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				this.addSlotToContainer(new SlotItem(inventory, j + i * 6 + 1, 62 + j * 18, 16 + i * 18));
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
		listener.sendAllWindowProperties(this, this.apiary);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return !playerIn.isSpectator();
	}

	@SuppressWarnings ("ConstantConditions")
	@Nullable
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		final Slot slot = inventorySlots.get(slotIndex);
		ItemStack copy = null;

		if (slot != null && slot.getHasStack()) {
			final ItemStack original = slot.getStack();
			copy = original.copy();

			if (slotIndex == 0) {
				if (!mergeItemStack(original, 19, 55, true)) return null;
				slot.onSlotChange(original, copy);
			} else if (slotIndex > 19) {
				if (original.stackSize == 1 && !mergeItemStack(original, 0, 1, false)) return null;
				slot.onSlotChange(original, copy);
			} else {
				if (!mergeItemStack(original, 19, 55, true)) return null;
				slot.onSlotChange(original, copy);
			}

			if (original.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}

			if (original.stackSize == copy.stackSize) return null;

			slot.onPickupFromSlot(player, original);
		}

		return copy;
	}

	private class SlotBee extends Slot {

		SlotBee(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
			super(inventoryIn, slotIndex, xPosition, yPosition);
		}

		public boolean isItemValid(@Nullable ItemStack stack) {
			return stack != null && stack.getItem() == ModItems.BEE;
		}

		public int getItemStackLimit(ItemStack stack) {
			return 1;
		}
	}

	private class SlotItem extends Slot {

		SlotItem(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition) {
			super(inventoryIn, slotIndex, xPosition, yPosition);
		}

		public boolean isItemValid(@Nullable ItemStack stack) {
			return stack != null && (stack.getItem() == ModItems.HONEYCOMB
					|| stack.getItem() == ModItems.EMPTY_HONEYCOMB
					|| stack.getItem() == ModItems.BEE);
		}

		public int getItemStackLimit(ItemStack stack) {
			return 1;
		}
	}
}
