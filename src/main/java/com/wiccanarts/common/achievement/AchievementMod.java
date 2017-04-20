package com.wiccanarts.common.achievement;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * Original code by Vazkii, from Botania.
 */

class AchievementMod extends Achievement {

	private AchievementMod(String name, int x, int y, ItemStack icon, Achievement parent) {
		super("achievement.wiccanarts:" + name, "wiccanarts:" + name, x, y, icon, parent);
		ModAchievements.achievements.add(this);
		registerStat();
	}

	AchievementMod(String name, int x, int y, Item icon, Achievement parent) {
		this(name, x, y, new ItemStack(icon), parent);
	}

	AchievementMod(String name, int x, int y, Block icon, Achievement parent) {
		this(name, x, y, new ItemStack(icon), parent);
	}
}
