package com.wiccanarts.common.achievement;

import com.wiccanarts.common.item.ModItems;
import com.wiccanarts.common.lib.LibAchievementName;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

import static com.wiccanarts.common.lib.LibMod.MOD_NAME;

/**
 * Created by Joseph on 4/17/2017. Original code by Vazkii from Botania.
 */
public final class ModAchievements {

	public static Achievement malachiteCraft;

	public static AchievementPage wiccanArtsPage;
	public static int pageIndex;

	public static void init() {

		malachiteCraft = new AchievementMod(LibAchievementName.MALACHITE_CRAFT, 0, 11, ModItems.MALACHITE, malachiteCraft);

		pageIndex = AchievementPage.getAchievementPages().size();
		wiccanArtsPage = new AchievementPage(MOD_NAME, AchievementMod.achievements.toArray(new Achievement[AchievementMod.achievements.size()]));
		AchievementPage.registerAchievementPage(wiccanArtsPage);

		MinecraftForge.EVENT_BUS.register(AchievementTriggerer.class);
	}

}
