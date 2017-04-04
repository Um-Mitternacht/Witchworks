package com.wiccanarts.common.potions;

import com.wiccanarts.common.lib.LibBrewName;
import net.minecraft.entity.EntityLivingBase;

/**
 * This class was created by Arekkuusu on 03/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BrewStoneform extends BrewMod {

	public BrewStoneform() {
		super(LibBrewName.STONEFORM_BREW, false, 0x000000, 0);
	}

	@Override
	public void performEffect(EntityLivingBase livingBase, int level) {
		if (livingBase.moveForward > 0) {
			livingBase.motionX *= 0.5D;
			livingBase.motionY *= 0.5D;
			livingBase.motionZ *= 0.5D;
		}
	}

	@Override
	public boolean isBadEffect() {
		return true;
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}
}
