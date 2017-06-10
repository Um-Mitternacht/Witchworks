package com.witchworks.common.potions;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.brew.IBrew;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class HolyWaterBrew implements IBrew {

	@Override
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		//Todo: Some better effects to attack undead
		if (entity.isEntityUndead()) {
			entity.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 1));
			entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
		}
	}

	@Override
	public void onFinish(World world, BlockPos pos, EntityLivingBase entity, int amplifier) {
		if (entity.isEntityUndead()) {
			entity.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 1));
			entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
		}
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public int getColor() {
		return 0x8DA399;
	}

	@Override
	public String getName() {
		return "brew.holy_water_brew.name";
	}

	@Override
	public String getDescription() {
		return "brew.holy_water_brew.desc";
	}

	@Override
	public BrewRegistry.Brew getType() {
		return BrewRegistry.Brew.SPLASH;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 6);
	}
}
