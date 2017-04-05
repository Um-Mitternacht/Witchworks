package com.wiccanarts.common.potions;

import com.wiccanarts.common.lib.*;
import net.minecraft.potion.*;

import static net.minecraftforge.fml.common.registry.GameRegistry.*;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@ObjectHolder (LibMod.MOD_ID)
public final class ModBrews {

	@ObjectHolder (LibBrewName.STONEFORM_BREW)
	public static final Potion STONEFORM_BREW = new BrewMod ();
}
