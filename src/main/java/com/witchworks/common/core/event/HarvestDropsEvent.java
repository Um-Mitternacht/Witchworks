package com.witchworks.common.core.event;

import com.witchworks.common.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Joseph on 9/24/2017.
 */
public class HarvestDropsEvent {

	@SubscribeEvent
	@Mod.EventHandler
	public void onHarvestBlock(BlockEvent.HarvestDropsEvent event) {
		if ((event.getState().getBlock() == Blocks.LEAVES2 && event.getWorld().rand.nextInt(100) < 55)) {
			event.getDrops().clear();
			event.getDrops().add(new ItemStack(ModItems.oak_apple_gall, 1));
		}
	}
}