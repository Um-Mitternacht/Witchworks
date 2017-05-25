package com.witchworks.client.core.event;

import com.witchworks.client.ResourceLocations;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TextureStitch {

	@SubscribeEvent
	public void stitchEventPre(TextureStitchEvent.Pre event) {
		event.getMap().registerSprite(ResourceLocations.cauldron_bubble);
		event.getMap().registerSprite(ResourceLocations.cauldron_bubble_pop);
		event.getMap().registerSprite(ResourceLocations.steam);
		event.getMap().registerSprite(ResourceLocations.bee);
		event.getMap().registerSprite(ResourceLocations.gray_water);
	}
}
