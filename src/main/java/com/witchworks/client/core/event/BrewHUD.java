package com.witchworks.client.core.event;

import com.witchworks.api.item.IBrew;
import com.witchworks.common.core.capability.potion.BrewStorageHandler;
import com.witchworks.common.core.capability.potion.IBrewStorage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import static com.witchworks.common.core.handler.ConfigHandler.HUD.BREW_HUD;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SideOnly (Side.CLIENT)
public class BrewHUD {

	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent.Post event) {
		if (!BREW_HUD.hide && event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			Optional<IBrewStorage> optional = BrewStorageHandler.getBrewStorage(Minecraft.getMinecraft().player);
			if (optional.isPresent()) {
				ScaledResolution res = event.getResolution();

				int x = res.getScaledWidth() - BREW_HUD.x;
				int yOffset = BREW_HUD.y;
				Minecraft mc = Minecraft.getMinecraft();
				Set<IBrew> client = optional.get().getClient();
				if (client == null) return;
				Iterator<IBrew> renders = client.iterator();
				GlStateManager.pushMatrix();
				while (renders.hasNext()) {
					renders.next().renderHUD(x, yOffset, mc);
					yOffset += 22;
				}
				GlStateManager.popMatrix();
			}
		}
	}
}
