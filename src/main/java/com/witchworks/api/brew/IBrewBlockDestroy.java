package com.witchworks.api.brew;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;

/**
 * This class was created by Arekkuusu on 06/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public interface IBrewBlockDestroy {

	void onBlockDestroy(LivingDestroyBlockEvent event, EntityLivingBase breaker);
}
