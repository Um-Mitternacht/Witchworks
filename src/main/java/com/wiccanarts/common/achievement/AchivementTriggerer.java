package com.wiccanarts.common.achievement;

/**
 * Created by Joseph on 4/17/2017. Original code by Vazkii.
 */

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public final class AchivementTriggerer {

	private AchivementTriggerer() {
	}

	@SubscribeEvent
	public static void onItemPickedUp(EntityItemPickupEvent event) {
		ItemStack stack = event.getItem().getEntityItem();
		if (stack.getItem() instanceof IPickupAchievement) {
			Achievement achievement = ((IPickupAchievement) stack.getItem()).getAchievementOnPickup(stack, event.getEntityPlayer(), event.getItem());
			if (achievement != null)
				event.getEntityPlayer().addStat(achievement, 1);
		}
	}

	@SubscribeEvent
	public static void onItemCrafted(ItemCraftedEvent event) {
		if (event.crafting != null && event.crafting.getItem() instanceof ICraftAchievement) {
			Achievement achievement = ((ICraftAchievement) event.crafting.getItem()).getAchievementOnCraft(event.crafting, event.player, event.craftMatrix);
			if (achievement != null)
				event.player.addStat(achievement, 1);
		}
	}

}
