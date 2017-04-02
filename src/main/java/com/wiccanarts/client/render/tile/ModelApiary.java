package com.wiccanarts.client.render.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * apiary.tcn - TechneToTabulaImporter
 * Created using Tabula 5.1.0
 */
public class ModelApiary extends ModelBase {
	public ModelRenderer bottom;
	public ModelRenderer top;

	public ModelApiary() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.bottom = new ModelRenderer(this, 0, 16);
		this.bottom.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.bottom.addBox(-4.0F, 6.0F, -4.0F, 8, 6, 8, 0.0F);
		this.top = new ModelRenderer(this, 0, 16);
		this.top.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.top.addBox(-4.0F, 0.0F, -4.0F, 8, 6, 8, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.bottom.render(f5);
		this.top.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
