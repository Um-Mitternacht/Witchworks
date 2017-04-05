package com.wiccanarts.common.core.event;

import com.wiccanarts.common.potions.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.fml.common.eventhandler.*;

/**
 * This class was created by BerciTheBeast on 26.3.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
class PotionEvents {

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event) {
		if (event.getEntityLiving().isPotionActive(ModBrews.STONEFORM_BREW)) {
			event.setAmount(event.getAmount() * 0.5F);
		}
	}
}
