package com.witchworks.client.gui.container;

import com.witchworks.common.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Created by Joseph on 7/17/2017.
 */
public class ContainerOven extends Container {

	//Todo: Continue, life is getting in the way, as well as a damaged sleep cycle.
	private final IInventory oven;

	public ContainerOven(InventoryPlayer playerInventory, IInventory inventory) {
		this.oven = inventory;

		this.addSlotToContainer(new ContainerOven.SlotOvenInput(inventory, 0, 19, 17));
		this.addSlotToContainer(new ContainerOven.SlotOvenFuel(inventory, 0, 19, 53));
		this.addSlotToContainer(new ContainerOven.SlotOvenJar(inventory, 0, 69, 53));
		this.addSlotToContainer(new ContainerOven.SlotOvenFume(inventory, 0, 128, 53));
		this.addSlotToContainer(new ContainerOven.SlotOvenOutput(inventory, 0, 124, 21, playerInventory.player));

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
				if (!mergeItemStack(original, 1, 64, true)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			} else if (slotIndex > 64) {
				if (original.getCount() == 1 && !mergeItemStack(original, 0, 64, false)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			} else {
				if (!mergeItemStack(original, 1, 64, true)) return ItemStack.EMPTY;
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

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return !playerIn.isSpectator();
	}

	private class SlotOvenFuel extends SlotFurnaceFuel {

		SlotOvenFuel(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public boolean isItemValid(ItemStack stack) {
			return TileEntityFurnace.isItemFuel(stack) || isBucket(stack);
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenJar extends Slot {

		SlotOvenJar(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public boolean isItemValid(ItemStack stack) {
			return stack != null && stack.getItem() == ModItems.glass_jar;
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenInput extends Slot {

		SlotOvenInput(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public boolean isItemValid(ItemStack stack) {
			return true;
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenFume extends Slot {

		SlotOvenFume(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public boolean isItemValid(ItemStack stack) {
			return true;
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenOutput extends SlotFurnaceOutput {

		private final EntityPlayer player;

		SlotOvenOutput(IInventory inventoryIn, int slotIndex, int x, int y, EntityPlayer player) {
			super(player, inventoryIn, slotIndex, x, y);
			this.player = player;
		}

		public boolean isItemValid(ItemStack stack) {
			return false;
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}
}