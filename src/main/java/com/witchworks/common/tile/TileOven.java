package com.witchworks.common.tile;

import com.witchworks.api.helper.ItemNullHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

/**
 * Created by Joseph on 7/17/2017.
 */
public class TileOven extends TileEntityLockable implements ITickable, ISidedInventory {
	private NonNullList<ItemStack> ovenItemStacks = NonNullList.<ItemStack>withSize(5, ItemStack.EMPTY);
	private String ovenCustomName;

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return new int[0];
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		{
			if (direction == EnumFacing.DOWN && index == 1) {
				Item item = stack.getItem();

				if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
					return false;
				}
			}

			return true;
		}
	}

	@Override
	public int getSizeInventory() {
		return this.ovenItemStacks.size();
	}

	@Override
	public boolean isEmpty()
		{
			for (ItemStack itemstack : this.ovenItemStacks) {
				if (!itemstack.isEmpty()) {
					return false;
				}
			}

			return true;
		}

	@Override
	public ItemStack getStackInSlot(int index) {
		return (ItemStack)this.ovenItemStacks.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.ovenItemStacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.ovenItemStacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {

	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return false;
	}

	@Override
	public void openInventory(EntityPlayer player) {

	}

	@Override
	public void closeInventory(EntityPlayer player) {

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {

	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {

	}

	@Override
	public void update() {

	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return null;
	}

	@Override
	public String getGuiID() {
			return "witchworks:oven";
		}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.ovenCustomName : "container.oven";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}
}
