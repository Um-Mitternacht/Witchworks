/**
 * This class was created by <ArekkuusuJerii>. It's distributed as
 * part of the Grimoire Of Alice Mod. Get the Source Code in github:
 * https://github.com/ArekkuusuJerii/Grimore-Of-Alice
 * <p>
 * Grimoire Of Alice is Open Source and distributed under the
 * Grimoire Of Alice license: https://github.com/ArekkuusuJerii/Grimoire-Of-Alice/blob/master/LICENSE.md
 */
package com.witchworks.common.core.handler;

import com.witchworks.common.lib.LibMod;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
@Config (modid = LibMod.MOD_ID)
public final class ConfigHandler {

	public static WorldGen WORLD_GEN = new WorldGen();
	@Comment ("Customise the HUDs positions in the screen")
	public static HUD HUD = new HUD();

	private ConfigHandler() {
	}

	public static class WorldGen {

	}

	public static class HUD {

		@Comment ("Energy HUD")
		public static EnergyHUD ENERGY_HUD = new EnergyHUD();
		@Comment ("Brews HUD")
		public static BrewHUD BREW_HUD = new BrewHUD();

		public static class EnergyHUD {
			@Comment ("If the HUD should hide")
			public boolean hide = true;
			@Comment ({"Pixels before HUD starts", "Size is calculated with heightEnd - heightStart"})
			public int heightStart = 32;
			@Comment ({"Pixels after HUD ends", "Size is calculated with heightEnd - heightStart"})
			public int heightEnd = 134;
			@Comment ("Width of the HUD")
			public int width = 25;

			@Comment ({"Position of the HUD in the screen", "\"x\" value is from left to right", "\"y\" value is from bottom to top"})
			public int x = 150;
			public int y = 129;
		}

		public static class BrewHUD {
			@Comment ("If the Brews should be hidden")
			public boolean hide;
			@Comment ({"Position of the HUD in the screen", "\"x\" value is from right to left", "\"y\" value is from top to bottom"})
			public int x = 21;
			public int y = 100;
		}
	}
}
