package com.witchworks.common.brew;

import com.witchworks.api.brew.IBrew;
import com.witchworks.api.brew.IBrewClientSide;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class CursedLeapingBrew implements IBrew, IBrewClientSide {

	@Override //Note: Ascended glitch. This came as the result of trying to toy with operators for the brew of sinking.
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		if (entity.ticksExisted % 20 < 1 && entity.motionY >= 0.0D)
			entity.motionY += 1.0D;
	}

	@Override
	public boolean isBad() {
		return true;
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public int getColor() {
		return 0x4F7942;
	}

	@Override
	public String getName() {
		return "cursed_leaping";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc, int amplifier) {
		render(x, y, mc, 10);
	}

	@Override
	public void onUpdateClientSide(LivingEvent.LivingUpdateEvent event, EntityLivingBase entity, int amplifier) {
		if (entity.ticksExisted % 20 < 1 && entity.motionY >= 0.0D)
			entity.motionY += 1.0D;
	}
}
