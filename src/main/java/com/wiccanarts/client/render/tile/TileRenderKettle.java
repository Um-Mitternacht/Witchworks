package com.wiccanarts.client.render.tile;

import com.wiccanarts.common.block.tile.TileKettle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.lwjgl.opengl.GL11;

/**
 * This class was created by Arekkuusu on 09/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class TileRenderKettle extends TileEntitySpecialRenderer<TileKettle> {

	@Override
	public void renderTileEntityAt(TileKettle te, double x, double y, double z, float partialTicks, int destroyStage) {
		if (te.hasWater()) {
			GlStateManager.pushMatrix();
			GlStateManager.disableLighting();
			final double level = y + 0.155D + (te.getWaterLevel() * 0.075D);
			GlStateManager.translate(x, level, z);

			Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			final Fluid fluid = FluidRegistry.WATER;

			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GlStateManager.disableAlpha();

			final float[] color = te.getWaterColor();
			GlStateManager.color(color[0], color[1], color[2]);

			final float w = 0.125F;
			GlStateManager.translate(w, 0, w);
			GlStateManager.rotate(90F, 1F, 0F, 0F);
			final float s = 0.0460425F;
			GlStateManager.scale(s, s, s);

			renderWater(fluid.getStill());

			GlStateManager.enableAlpha();
			GlStateManager.disableBlend();

			GlStateManager.enableLighting();
			GlStateManager.popMatrix();
		}
	}

	private void renderWater(ResourceLocation loc) {
		final TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(loc.toString());
		final Tessellator tessellator = Tessellator.getInstance();
		tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);

		tessellator.getBuffer().pos(0, 16, 0).tex(sprite.getMinU(), sprite.getMaxV()).endVertex();
		tessellator.getBuffer().pos(16, 16, 0).tex(sprite.getMaxU(), sprite.getMaxV()).endVertex();
		tessellator.getBuffer().pos(16, 0, 0).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();
		tessellator.getBuffer().pos(0, 0, 0).tex(sprite.getMinU(), sprite.getMinV()).endVertex();
		tessellator.draw();
	}
}
