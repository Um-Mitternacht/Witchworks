package com.witchworks.api.brew;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Arekkuusu on 16/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public interface IBrewClientSide {

	@SideOnly(Side.CLIENT)
	void onUpdateClientSide(LivingEvent.LivingUpdateEvent event, EntityLivingBase entity, int amplifier);
}
