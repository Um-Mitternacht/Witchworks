package com.witchworks.client.gui.container.slots;

import com.witchworks.common.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;

/**
 * Created by Joseph on 10/29/2017.
 */
public class SlotOvenJar extends SlotItemHandler {
	public SlotOvenJar(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}

	public boolean isItemValid(@Nullable ItemStack stack) {
		return stack != null && (stack.getItem() == Items.GLASS_BOTTLE
				|| stack.getItem() == ModItems.glass_jar);
	}
}