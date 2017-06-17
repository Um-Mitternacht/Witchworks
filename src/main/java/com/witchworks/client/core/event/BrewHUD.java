package com.witchworks.client.core.event;

import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.IBrew;
import com.witchworks.api.capability.IBrewStorage;
import com.witchworks.common.core.capability.brew.BrewStorageHandler;
import com.witchworks.common.core.handler.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collection;
import java.util.Optional;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SideOnly(Side.CLIENT)
public class BrewHUD {

	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent.Post event) {
		if (!ConfigHandler.BREW_HUD.hide && event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			Optional<IBrewStorage> optional = BrewStorageHandler.getBrewStorage(Minecraft.getMinecraft().player);
			if (optional.isPresent()) {
				ScaledResolution res = event.getResolution();

				int xOffset = res.getScaledWidth() - ConfigHandler.BREW_HUD.x;
				int yOffset = ConfigHandler.BREW_HUD.y;
				Minecraft mc = Minecraft.getMinecraft();
				Collection<BrewEffect> effects = optional.get().getBrewEffects();
				if (effects.isEmpty()) return;

				for (BrewEffect effect : effects) {
					IBrew brew = effect.getBrew();
					if (brew.shouldRender()) {
						GlStateManager.pushMatrix();

						brew.renderHUD(xOffset, yOffset, mc, effect.getAmplifier());
						if (ConfigHandler.BREW_HUD.orientation) {
							yOffset += 22;
						} else {
							xOffset += 22;
						}

						GlStateManager.popMatrix();
					}
				}
			}
		}
	}
}
