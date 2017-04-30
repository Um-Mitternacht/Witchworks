package com.witchworks.common.potions;

import com.witchworks.client.ResourceLocations;
import com.witchworks.common.lib.LibMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Arekkuusu on 27/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class BrewMod extends Potion {

	private final int iconIndex;

	BrewMod() {
		super(false, 0);
		iconIndex = 0;
	}

	public BrewMod(String name, boolean badEffect, int color, int iconIndex) {
		super(badEffect, color);
		setPotionName("effect." + LibMod.MOD_ID + "." + name);
		setRegistryName(name);
		this.iconIndex = iconIndex;
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		render(x + 6, y + 7, 1);
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		render(x + 3, y + 3, alpha);
	}

	@SideOnly (Side.CLIENT)
	private void render(int x, int y, float alpha) {
		Minecraft.getMinecraft().renderEngine.bindTexture(ResourceLocations.POTION_TEXTURES);
		final Tessellator tessellator = Tessellator.getInstance();
		final VertexBuffer buf = tessellator.getBuffer();
		buf.begin(7, DefaultVertexFormats.POSITION_TEX);
		GlStateManager.color(1, 1, 1, alpha);

		final int textureX = iconIndex % 8 * 18;
		final int textureY = 198 + iconIndex / 8 * 18;
		final float f = 0.00390625F;

		buf.pos(x, y + 18, 0).tex(textureX * f, (textureY + 18) * f).endVertex();
		buf.pos(x + 18, y + 18, 0).tex((textureX + 18) * f, (textureY + 18) * f).endVertex();
		buf.pos(x + 18, y, 0).tex((textureX + 18) * f, textureY * f).endVertex();
		buf.pos(x, y, 0).tex(textureX * f, textureY * f).endVertex();

		tessellator.draw();
	}
}
