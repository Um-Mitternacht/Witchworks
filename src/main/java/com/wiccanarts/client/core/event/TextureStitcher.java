package com.wiccanarts.client.core.event;

import com.wiccanarts.client.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.relauncher.*;

@SideOnly (Side.CLIENT)
public class TextureStitcher {

	@SubscribeEvent
	public void stitcherEventPre (TextureStitchEvent.Pre event) {
		event.getMap ().registerSprite (ResourceLocations.CAULDRON_BUBBLE);
		event.getMap ().registerSprite (ResourceLocations.STEAM);
	}
}
