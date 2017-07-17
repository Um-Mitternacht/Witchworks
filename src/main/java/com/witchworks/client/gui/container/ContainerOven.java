package com.witchworks.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;

/**
 * Created by Joseph on 7/17/2017.
 */
public class ContainerOven extends Container {

	private final IInventory oven;

	public ContainerOven(InventoryPlayer playerInventory, IInventory inventory) {
		this.oven = inventory;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return false;
	}
}
