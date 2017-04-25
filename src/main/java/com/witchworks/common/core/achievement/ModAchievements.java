package com.witchworks.common.core.achievement;

import com.witchworks.common.item.ModItems;
import com.witchworks.common.lib.LibAchievementName;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;
import java.util.List;

import static com.witchworks.common.lib.LibMod.MOD_NAME;

/**
 * Original code by Vazkii from Botania.
 */

@SuppressWarnings ("WeakerAccess")
public final class ModAchievements {

	public static final List<Achievement> achievements = new ArrayList<>();
	public static Achievement craftMalachite;

	private ModAchievements() {
	}

	public static void init() {
		craftMalachite = new AchievementMod(LibAchievementName.MALACHITE_CRAFT, 0, 0, ModItems.MALACHITE, null);

		final AchievementPage page = new AchievementPage(MOD_NAME, achievements.toArray(new Achievement[achievements.size()]));
		AchievementPage.registerAchievementPage(page);

		MinecraftForge.EVENT_BUS.register(AchievementTriggers.class);
	}
}
