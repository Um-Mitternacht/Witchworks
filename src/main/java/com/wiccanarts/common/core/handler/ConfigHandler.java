/**
 * This class was created by <ArekkuusuJerii>. It's distributed as
 * part of the Grimoire Of Alice Mod. Get the Source Code in github:
 * https://github.com/ArekkuusuJerii/Grimore-Of-Alice
 * <p>
 * Grimoire Of Alice is Open Source and distributed under the
 * Grimoire Of Alice license: https://github.com/ArekkuusuJerii/Grimoire-Of-Alice/blob/master/LICENSE.md
 */
package com.wiccanarts.common.core.handler;

import com.wiccanarts.common.lib.LibMod;
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

	@Comment ("Don't change this if you don't know what you are doing")
	public static WiccanArts wiccanArts = new WiccanArts ();

	private ConfigHandler () {
	}

	public static class WiccanArts {

		@Comment ("")
		public Crafting crafting = new Crafting ();
		@Comment ("")
		public WorldGen worldGen = new WorldGen ();
		@Comment ("")
		public Spawning spawning = new Spawning ();

		public static class Crafting {

		}

		public static class WorldGen {

		}

		public static class Spawning {

		}
	}
}
