package com.wiccanarts.common.potions;

import com.wiccanarts.common.lib.LibBrewName;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

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
		if (livingBase instanceof EntityPlayer) {
			if (!((EntityPlayer) livingBase).capabilities.isCreativeMode) {
				apply(livingBase, level);
			}
		} else {
			apply(livingBase, level);
		}
	}

	private void apply(EntityLivingBase livingBase, int level) {
		livingBase.motionX *= 0.25D / (++level * 20);
		if (!livingBase.onGround) {
			livingBase.motionY -= 0.05 * ++level;
		}
		livingBase.motionZ *= 0.25D / (++level * 20);
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
