package com.wiccanarts.common.achievement;

import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import com.wiccanarts.common.lib.LibAchievementName;

/**
 * Created by Joseph on 4/17/2017. Original code by Vazkii from Botania.
 */
public final class ModAchievements {

	public static Achievement malachiteCraft;

	public static void init() {

		malachiteCraft = new AchievementMod(LibAchievementName.MALACHITE_CRAFT, 0, 11, ModItems.MALACHITE, malachiteCraft);
	}
}
