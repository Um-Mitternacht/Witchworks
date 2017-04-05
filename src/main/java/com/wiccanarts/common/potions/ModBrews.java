package com.wiccanarts.common.potions;

import com.wiccanarts.common.lib.LibBrewName;
import com.wiccanarts.common.lib.LibMod;
import net.minecraft.potion.Potion;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@ObjectHolder (LibMod.MOD_ID)
public final class ModBrews {

	@ObjectHolder (LibBrewName.STONEFORM_BREW)
	public static final Potion STONEFORM_BREW = new BrewMod ();

	private ModBrews () {
	}
}
