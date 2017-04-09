package com.wiccanarts.client.core.event;

import com.wiccanarts.client.ResourceLocations;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly (Side.CLIENT)
public class TextureStitcher {

	@SubscribeEvent
	public void stitcherEventPre(TextureStitchEvent.Pre event) {
		event.getMap().registerSprite(ResourceLocations.CAULDRON_BUBBLE);
		event.getMap().registerSprite(ResourceLocations.STEAM);
		event.getMap().registerSprite(ResourceLocations.BEE);
	}
}
