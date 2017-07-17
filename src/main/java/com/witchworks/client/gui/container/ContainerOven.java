package com.witchworks.client.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by Joseph on 7/17/2017.
 */
public class ContainerOven extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return false;
	}
}
