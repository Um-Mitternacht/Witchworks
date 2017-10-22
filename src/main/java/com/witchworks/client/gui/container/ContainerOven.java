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
				this.addSlotToContainer(new ContainerOven.SlotOvenInput(inventory, j + i * 6 + 1, 62 + j * 18, 16 + i * 18));
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
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

			if (index < containerSlots) {
				if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
				return ItemStack.EMPTY;
			}

			if (itemstack1.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
				oven.markDirty();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(player, itemstack1);
		}

		return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return !playerIn.isSpectator();
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

	private class SlotOvenInput extends Slot {

		SlotOvenInput(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public boolean isItemValid(@Nullable ItemStack stack) {
			return stack != null;
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenJar extends Slot {

		SlotOvenJar(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public boolean isItemValid(@Nullable ItemStack stack) {
			return stack != null && (stack.getItem() == ModItems.glass_jar
					|| stack.getItem() == ModItems.glass_jar);
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenByproduct extends Slot {

		SlotOvenByproduct(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public boolean isItemValid(@Nullable ItemStack stack) {
			return stack != null;
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenFume extends Slot {

		SlotOvenFume(IInventory inventoryIn, int slotIndex, int x, int y) {
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