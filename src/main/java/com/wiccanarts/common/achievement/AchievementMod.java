package com.wiccanarts.common.achievement;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

/**
 * Created by Joseph on 4/17/2017. Original code by Vazkii, from Botania.
 */
public class AchievementMod extends Achievement {

	public static final List<Achievement> achievements = new ArrayList<>();

	public AchievementMod(String name, int x, int y, ItemStack icon, Achievement parent) {
		super("achievement.wiccanarts:" + name, "wiccanarts:" + name, x, y, icon, parent);
		achievements.add(this);
		registerStat();

	}

	public AchievementMod(String name, int x, int y, Item icon, Achievement parent) {
		this(name, x, y, new ItemStack(icon), parent);
	}

	public AchievementMod(String name, int x, int y, Block icon, Achievement parent) {
		this(name, x, y, new ItemStack(icon), parent);
	}
}
