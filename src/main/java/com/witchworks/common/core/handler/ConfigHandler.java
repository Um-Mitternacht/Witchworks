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
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@Config(modid = LibMod.MOD_ID)
public final class ConfigHandler {

	@Comment("Change vein sizes, generation height and generation chance")
	public static WorldGen WORLD_GEN = new WorldGen();
	@Comment("Customize the HUDs positions in the screen")
	public static HUD HUD = new HUD();

	private ConfigHandler() {
	}

	public static class WorldGen {
		@Comment("Silver Ore gen")
		public int silver_min_vein = 1;
		public int silver_max_vein = 8;
		public int silver_min_height = 10;
		public int silver_max_height = 128;
		public int silver_gen_chance = 8;

		@Comment("Moldavite Ore gen")
		public int moldavite_min_vein = 1;
		public int moldavite_max_vein = 4;
		public int moldavite_min_height = 10;
		public int moldavite_max_height = 80;
		public int moldavite_gen_chance = 1;

		@Comment("Bloodstone Ore gen")
		public int bloodStone_min_vein = 1;
		public int bloodStone_max_vein = 2;
		public int bloodStone_min_height = 10;
		public int bloodStone_max_height = 100;
		public int bloodStone_gen_chance = 1;

		@Comment("Tourmaline Ore gen")
		public int tourmaline_min_vein = 1;
		public int tourmaline_max_vein = 2;
		public int tourmaline_min_height = 10;
		public int tourmaline_max_height = 80;
		public int tourmaline_gen_chance = 2;

		@Comment("Malachite Ore gen")
		public int malachite_min_vein = 1;
		public int malachite_max_vein = 2;
		public int malachite_min_height = 10;
		public int malachite_max_height = 80;
		public int malachite_gen_chance = 2;

		@Comment("Tigers Eye Ore gen")
		public int tigersEye_min_vein = 1;
		public int tigersEye_max_vein = 2;
		public int tigersEye_min_height = 10;
		public int tigersEye_max_height = 60;
		public int tigersEye_gen_chance = 1;

		@Comment("Nummite Ore gen")
		public int nuumite_min_vein = 1;
		public int nuumite_max_vein = 2;
		public int nuumite_min_height = 10;
		public int nuumite_max_height = 80;
		public int nuumite_gen_chance = 2;

		@Comment("Garnet Ore gen")
		public int garnet_min_vein = 1;
		public int garnet_max_vein = 2;
		public int garnet_min_height = 10;
		public int garnet_max_height = 65;
		public int garnet_gen_chance = 1;

		@Comment("Jasper Ore gen")
		public int jasper_min_vein = 1;
		public int jasper_max_vein = 2;
		public int jasper_min_height = 10;
		public int jasper_max_height = 80;
		public int jasper_gen_chance = 2;

		@Comment("Salt Ore gen")
		public int salt_min_vein = 1;
		public int salt_max_vein = 4;
		public int salt_min_height = 10;
		public int salt_max_height = 128;
		public int salt_gen_chance = 2;

		@Comment("Amethyst Ore gen")
		public int amethyst_min_vein = 1;
		public int amethyst_max_vein = 4;
		public int amethyst_min_height = 10;
		public int amethyst_max_height = 40;
		public int amethyst_gen_chance = 2;

		@Comment("Alexandrite Ore gen")
		public int alexandrite_min_vein = 1;
		public int alexandrite_max_vein = 2;
		public int alexandrite_min_height = 10;
		public int alexandrite_max_height = 40;
		public int alexandrite_gen_chance = 1;

		@Comment("Coquina gen")
		public int coquina_min_vein = 1;
		public int coquina_max_vein = 4;
		public int coquina_min_height = 55;
		public int coquina_max_height = 65;
		public int coquina_gen_chance = 2;

		@Comment("Chalk gen")
		public int chalk_min_vein = 1;
		public int chalk_max_vein = 25;
		public int chalk_min_height = 10;
		public int chalk_max_height = 255;
		public int chalk_gen_chance = 8;
	}

	public static class HUD {

		@Comment("Energy HUD")
		public static EnergyHUD ENERGY_HUD = new EnergyHUD();
		@Comment("Brews HUD")
		public static BrewHUD BREW_HUD = new BrewHUD();

		public static class EnergyHUD {
			@Comment("Should the energy HUD be hidden?")
			public boolean hide = true;
			@Comment({"Pixels before HUD starts", "Size is calculated with heightEnd - heightStart"})
			public int heightStart = 32;
			@Comment({"Pixels after HUD ends", "Size is calculated with heightEnd - heightStart"})
			public int heightEnd = 134;
			@Comment("Width of the HUD")
			public int width = 25;

			@Comment({"Position of the HUD in the screen", "\"x\" value is from left to right", "\"y\" value is from bottom to top"})
			public int x = 150;
			public int y = 129;
		}

		public static class BrewHUD {
			@Comment("Should the brew HUD be hidden?")
			public boolean hide;
			@Comment({"Position of the HUD in the screen", "\"x\" value is from right to left", "\"y\" value is from top to bottom"})
			public int x = 21;
			public int y = 100;
		}
	}
}
