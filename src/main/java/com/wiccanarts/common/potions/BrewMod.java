package com.wiccanarts.common.potions;

import com.wiccanarts.client.ResourceLocations;
import com.wiccanarts.common.lib.LibMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by BerciTheBeast on 26.3.2017.
 */
public class BrewMod extends Potion {
	public static ResourceLocation texture = new ResourceLocation(LibMod.MOD_ID, "textures/misc/potions.png");
	public BrewMod(String name, ResourceLocation location, boolean badEffect, int potionColor, int indexInPictureX, int indexInPictureY) {
		super(badEffect, potionColor);
		this.setIconIndex(indexInPictureX, indexInPictureY);
		this.setPotionName(name);
	}

	@Override
	public boolean shouldRenderInvText(PotionEffect effect) {
		return true;
	}

	public PotionEffect apply(EntityLivingBase entity, int duration) {
		return apply(entity, duration, 0);
	}

	public PotionEffect apply(EntityLivingBase entity, int duration, int level) {
		return apply(entity, duration, level, false, false);
	}

	public PotionEffect apply(EntityLivingBase entity, int duration, int level, boolean fromAmbient, boolean showParticles) {
		PotionEffect effect = new PotionEffect(this, duration, level, fromAmbient, showParticles);
		entity.addPotionEffect(effect);
		return effect;
	}

	public int getLevel(EntityLivingBase entity) {
		PotionEffect effect = entity.getActivePotionEffect(this);
		if(effect != null) {
			return effect.getAmplifier();
		}
		return 0;
	}

	@Override
	public boolean shouldRender(PotionEffect effect){
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getStatusIconIndex() {
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		return super.getStatusIconIndex();
	}

}
