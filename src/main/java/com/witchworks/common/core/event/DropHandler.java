package com.witchworks.common.core.event;

import com.witchworks.common.item.ModItems;
import net.minecraft.block.BlockDeadBush;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Joseph on 7/17/2017.
 */
public class DropHandler {
	@SubscribeEvent
	public void SeedDropSage(BlockEvent.HarvestDropsEvent event) {
		if (event.getState().getBlock() instanceof BlockDeadBush) {
			event.getDrops().add(new ItemStack(ModItems.seed_white_sage));
		}
	}
}
