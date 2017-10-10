package com.witchworks.common.core.event;

import com.witchworks.common.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Joseph on 10/10/2017.
 */
public class HarvestEvent {

	@SubscribeEvent
	@Mod.EventHandler
	public void onHarvestBush(BlockEvent.HarvestDropsEvent harvest) {
		if ((harvest.getState().getBlock() == Blocks.DEADBUSH && harvest.getWorld().rand.nextInt(100) < 25)) {
			harvest.getDrops().clear();
			harvest.getDrops().add(new ItemStack(ModItems.seed_white_sage, 1));
		}
	}

	@SubscribeEvent
	@Mod.EventHandler
	public void onHarvestLeaves(BlockEvent.HarvestDropsEvent event) {
		if ((event.getState().getBlock() == Blocks.LEAVES && event.getWorld().rand.nextInt(100) < 25)) {
			event.getDrops().clear();
			event.getDrops().add(new ItemStack(ModItems.oak_apple_gall, 1));
		}
	}
}