package com.wiccanarts.common.potions;

import com.wiccanarts.common.lib.LibBrewName;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 * This class was created by BerciTheBeast on 13.4.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BrewParalysis extends BrewMod {

	public BrewParalysis() {
		super(LibBrewName.PARALYSIS_BREW, true, 0x000000, 1);
	}

	@Override
	public void performEffect(EntityLivingBase livingBase, int level) {
		if (livingBase instanceof EntityPlayer) {
			final EntityPlayer player = (EntityPlayer) livingBase;
			if (!player.capabilities.isCreativeMode) {
				apply(livingBase, level);
				if (player instanceof EntityPlayerMP) {
					final EntityPlayerMP mp = (EntityPlayerMP) player;
					mp.setPositionAndUpdate(mp.prevPosX, mp.prevPosY, mp.prevPosZ);
				}
			}
		} else {
			apply(livingBase, level);
		}
	}

	private void apply(EntityLivingBase livingBase, int level) {
		livingBase.motionX = 0;
		if (!livingBase.onGround) {
			livingBase.motionY -= 0.01 * level;
		}
		livingBase.motionZ = 0;
		livingBase.rotationYaw = livingBase.prevRotationYaw;
		livingBase.rotationPitch = livingBase.prevRotationPitch;
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
