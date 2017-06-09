package com.witchworks.common.potions;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.brew.IBrew;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class WarWaterBrew implements IBrew {

	public WarWaterBrew() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void apply(World world, BlockPos pos, @Nullable EntityLivingBase entity, int amplifier, int tick) {
		if (entity.isEntityAlive()) {
			entity.addPotionEffect(new PotionEffect(MobEffects.POISON, 1500, 0));
			entity.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 1500, 0));
			entity.addPotionEffect(new PotionEffect(MobEffects.UNLUCK, 1500, 0));
			entity.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 1500, 0));
		}
	}


	@Override
	public void onFinish(World world, BlockPos pos, @Nullable EntityLivingBase entity, int amplifier) {
		//NO-OP
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public int getColor() {
		return 0x7C0A02;
	}

	@Override
	public String getName() {
		return "brew.warwater_brew.name";
	}

	@Override
	public String getDescription() {
		return "brew.warwater_brew.desc";
	}

	@Override
	public BrewRegistry.Brew getType() {
		return BrewRegistry.Brew.SPLASH;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 4);
	}

}
