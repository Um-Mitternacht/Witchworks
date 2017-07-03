package com.witchworks.common.core.achievement;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

/**
 * Original code by Vazkii, from Botania.
 */

final class AchievementTriggers {

	private AchievementTriggers() {
	}

	@SubscribeEvent
	public static void onItemPickedUp(EntityItemPickupEvent event) {
		final ItemStack stack = event.getItem().getItem();
		if (stack.getItem() instanceof IPickupAchievement) {
			final Achievement achievement = ((IPickupAchievement) stack.getItem()).getAchievementOnPickup(stack, event.getEntityPlayer(), event.getItem());
			if (achievement != null)
				event.getEntityPlayer().addStat(achievement, 1);
		}
	}

	@SubscribeEvent
	public static void onItemCrafted(ItemCraftedEvent event) {
		if (!event.crafting.isEmpty() && event.crafting.getItem() instanceof ICraftAchievement) {
			final Achievement achievement = ((ICraftAchievement) event.crafting.getItem()).getAchievementOnCraft(event.crafting, event.player, event.craftMatrix);
			if (achievement != null)
				event.player.addStat(achievement, 1);
		}
	}
}
