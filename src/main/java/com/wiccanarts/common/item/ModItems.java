package com.wiccanarts.common.item;

import com.wiccanarts.common.crafting.VanillaCrafting;
import com.wiccanarts.common.lib.LibMod;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@GameRegistry.ObjectHolder(LibMod.MOD_ID)
public final class ModItems {

	public static void init() {
		VanillaCrafting.items();
	}

	public static void initOreDictionary() {
	}
}
