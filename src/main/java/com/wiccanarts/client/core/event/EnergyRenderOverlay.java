package com.wiccanarts.client.core.event;

import com.wiccanarts.client.ResourceLocations;
import com.wiccanarts.common.core.energy.EnergyHandler;
import com.wiccanarts.common.core.energy.IEnergy;
import com.wiccanarts.common.core.handler.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Optional;

/**
 * This class was created by Arekkuusu on 21/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SideOnly (Side.CLIENT)
public class EnergyRenderOverlay {

	private int renderTime;
	private float visible;
	private int oldEnergy;

	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			Minecraft mc = Minecraft.getMinecraft();
			Optional<IEnergy> optional = EnergyHandler.getEnergy(mc.player);

			if (optional.isPresent()) {
				IEnergy energy = optional.get();

				if (oldEnergy != energy.get()) {
					oldEnergy = energy.get();
					renderTime = 80;
					visible = 1F;
				}

				if (renderTime > 0) {
					ScaledResolution res = event.getResolution();
					GlStateManager.pushMatrix();

					if (ConfigHandler.HUD.hide && renderTime < 20) {
						visible -= 0.05F;
						visible = MathHelper.clamp(visible, 0F, 1F);

						GlStateManager.color(1F, 1F, 1F, visible);
					}

					float filled = (float) energy.get() / (float) energy.getMax();
					int heightEnd = ConfigHandler.HUD.heightEnd;
					int heightStart = ConfigHandler.HUD.heightStart;

					int width = 11;

					int heightUsed = heightEnd - heightStart;
					int heightFilled = (int) (heightUsed * filled);

					int posX = ConfigHandler.HUD.x;
					int posY = res.getScaledHeight() - ConfigHandler.HUD.y;

					int startPosX = posX - heightEnd;

					mc.getTextureManager().bindTexture(ResourceLocations.ENERGY_BACKGROUND);
					Gui.drawModalRectWithCustomSizedTexture(startPosX + 3, posY, 0F, heightUsed, width, heightFilled, width, heightUsed);

					mc.getTextureManager().bindTexture(ResourceLocations.ENERGY);
					Gui.drawModalRectWithCustomSizedTexture(startPosX + 3, posY, 0F, 0F, width, heightUsed, width, heightUsed);

					int textColor;
					int alpha = (int) (visible * 255);

					textColor = alpha << 24 | 0xFFFFFF;

					mc.fontRendererObj.drawStringWithShadow("E: " + energy.get(), startPosX, posY - 25, textColor);
					GlStateManager.popMatrix();

					--renderTime;
				}
			} else {
				renderTime = 0;
				visible = 1F;
			}
		}
	}
}
