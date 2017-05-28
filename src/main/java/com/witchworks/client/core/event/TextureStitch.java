package com.witchworks.client.core.event;

import com.witchworks.client.ResourceLocations;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly (Side.CLIENT)
public class TextureStitch {

	@SubscribeEvent
	public void stitchEventPre(TextureStitchEvent.Pre event) {
		event.getMap().registerSprite(ResourceLocations.CAULDRON_BUBBLE);
		event.getMap().registerSprite(ResourceLocations.CAULDRON_BUBBLE_POP);
		event.getMap().registerSprite(ResourceLocations.STEAM);
		event.getMap().registerSprite(ResourceLocations.BEE);
		event.getMap().registerSprite(ResourceLocations.GRAY_WATER);
	}
}
