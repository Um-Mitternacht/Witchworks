package com.wiccanarts.client.gui;

/**
 * Created by Joseph on 4/17/2017. Original code from Vazkii in Botania.
 */

import com.wiccanarts.common.achievement.ModAchievements;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.stats.StatisticsManager;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

;

public class GuiAchievementsHacky extends GuiAchievements {

	public GuiAchievementsHacky(GuiScreen screen, StatisticsManager stats) {
		super(screen, stats);
		ReflectionHelper.setPrivateValue(GuiAchievements.class, this, ModAchievements.pageIndex, "currentPage");
	}

	@Override
	public void initGui() {
		super.initGui();
		buttonList.get(1).displayString = ModAchievements.wiccanArtsPage.getName();
	}
}
