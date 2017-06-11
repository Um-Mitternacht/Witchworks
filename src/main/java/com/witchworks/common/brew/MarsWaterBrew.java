package com.witchworks.common.brew;

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

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class MarsWaterBrew implements IBrew {

	public MarsWaterBrew() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		entity.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 1500, 0));
		entity.addPotionEffect(new PotionEffect(MobEffects.UNLUCK, 1500, 0));
		entity.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 1500, 0));
		entity.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 1500, 0));
		entity.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 1500, 0));
	}

	@Override
	public void onFinish(World world, BlockPos pos, EntityLivingBase entity, int amplifier) {
		//NO-OP
	}

	@Override
	public boolean isInstant() {
		return true;
	}

	@Override
	public int getColor() {
		return 0x7C0A02;
	}

	@Override
	public String getName() {
		return "brew.mars_water_brew.name";
	}

	@Override
	public String getDescription() {
		return "brew.mars_water_brew.desc";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 4);
	}

}
