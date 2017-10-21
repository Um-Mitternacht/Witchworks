package com.witchworks.client.gui;

import com.witchworks.client.ResourceLocations;
import com.witchworks.client.gui.container.ContainerOven;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;

/**
 * Created by Joseph on 7/17/2017.
 */
public class GuiOven extends GuiContainer {

	private final InventoryPlayer playerInventory;
	private final IInventory tileOven;

	public GuiOven(InventoryPlayer playerInventory, IInventory tileOven) {
		super(new ContainerOven(playerInventory, tileOven));
		this.playerInventory = playerInventory;
		this.tileOven = tileOven;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		final String s = this.tileOven.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(ResourceLocations.OVEN_GUI);
		final int i = (this.width - this.xSize) / 2;
		final int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
}