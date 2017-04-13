package com.wiccanarts.common.potions;

import com.wiccanarts.common.lib.LibBrewName;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by BerciTheBeast on 13.4.2017.
 */
public class BrewParalysis extends BrewMod {

	public BrewParalysis() {
		super(LibBrewName.PARALYSIS_BREW, true, 0x001234, 1);
	}

	@Override
	public void performEffect(EntityLivingBase livingBase, int level) {
		if (livingBase instanceof EntityPlayer) {
			if (! ((EntityPlayer) livingBase).capabilities.isCreativeMode) {
				livingBase.motionX = 0;
				if (! livingBase.onGround) {
					livingBase.motionY -= (0.05 * ((level + 1) + 1));
				}
				livingBase.motionZ = 0;
				((EntityPlayer) livingBase).rotationYaw = ((EntityPlayer) livingBase).prevRotationYaw;
				((EntityPlayer) livingBase).rotationPitch = ((EntityPlayer) livingBase).prevRotationPitch;
			}
		} else {
			livingBase.motionX = 0;
			if (! livingBase.onGround) {
				livingBase.motionY -= (0.05 * (level + 1));
			}
			livingBase.motionZ = 0;
			((EntityPlayer) livingBase).rotationYaw = ((EntityPlayer) livingBase).prevRotationYaw;
			((EntityPlayer) livingBase).rotationPitch = ((EntityPlayer) livingBase).prevRotationPitch;
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
