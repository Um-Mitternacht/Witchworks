package com.witchworks.client.core.event;

import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.IBrewRenderLiving;
import com.witchworks.common.core.capability.brew.BrewStorageHandler;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collection;

/**
 * This class was created by Arekkuusu on 13/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SideOnly(Side.CLIENT)
public class ClientEvents {

	@SubscribeEvent
	public void onRender(RenderLivingEvent.Pre event) {
		Collection<BrewEffect> effects = BrewStorageHandler.getBrewEffects(event.getEntity());
		effects.stream().filter(effect -> effect.getBrew() instanceof IBrewRenderLiving).forEach(effect -> {
			if (event.isCanceled()) return;
			((IBrewRenderLiving) effect.getBrew()).onRenderLiving(event, event.getRenderer(), effect.getAmplifier());
		});
	}
}
