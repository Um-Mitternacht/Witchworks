package com.witchworks.client.gui.container;

import com.witchworks.client.gui.container.slots.SlotOvenJar;
import com.witchworks.common.tile.TileOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Created by Joseph on 7/17/2017.
 */
public class ContainerOven extends Container {

	//Todo: Continue, life is getting in the way, as well as a damaged sleep cycle.
	private final IInventory oven;
	private IItemHandler handler;
	private TileOven te;

	public ContainerOven(InventoryPlayer playerInventory, IInventory inventory) {
		this.oven = inventory;
		this.te = te;
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		this.addSlotToContainer(new SlotItemHandler(handler, 0, 19, 17));
		this.addSlotToContainer(new SlotItemHandler(handler, 0, 19, 53));
		this.addSlotToContainer(new SlotOvenJar(handler, 0, 69, 53));
		this.addSlotToContainer(new SlotItemHandler(handler, 0, 128, 53));
		this.addSlotToContainer(new SlotItemHandler(handler, 0, 124, 21));

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
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(fromSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			previous = current.copy();

			if (fromSlot < this.handler.getSlots()) {
				if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
					return ItemStack.EMPTY;
			} else {
				if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
					return ItemStack.EMPTY;
			}

			if (current.getCount() == 0)
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();

			if (current.getCount() == previous.getCount())
				return previous;
			slot.onTake(playerIn, current);
		}
		return previous;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return !playerIn.isSpectator();
	}

	private class SlotOvenFuel extends SlotFurnaceFuel {

		SlotOvenFuel(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenInput extends Slot {

		SlotOvenInput(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenFume extends Slot {

		SlotOvenFume(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}

	private class SlotOvenOutput extends Slot {

		SlotOvenOutput(IInventory inventoryIn, int slotIndex, int x, int y) {
			super(inventoryIn, slotIndex, x, y);
		}

		public int getItemStackLimit(ItemStack stack) {
			return 64;
		}
	}
}