package com.wiccanarts.common.core.handler;

import com.wiccanarts.common.potions.ModBrews;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by BerciTheBeast on 26.3.2017.
 */
public class PotionEventHandler {
	public PotionEventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingEvent.LivingUpdateEvent event) {

		if (event.getEntityLiving().isPotionActive(ModBrews.test)) {
			BlockPos position = event.getEntityLiving().getPosition();
			World world = event.getEntityLiving().getEntityWorld();
			float d1 = position.getX();
			float d2 = position.getY();
			float d3 = position.getZ();
			world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, d1, d2, d3, 0.0D, 0.1D, 0.0D);

		}

	}


}
