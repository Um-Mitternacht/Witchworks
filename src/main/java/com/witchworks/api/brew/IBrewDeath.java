package com.witchworks.api.brew;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * This class was created by Arekkuusu on 06/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public interface IBrewDeath {

	void onDeath(LivingDeathEvent event, DamageSource source, EntityLivingBase dying, int amplifier);
}
