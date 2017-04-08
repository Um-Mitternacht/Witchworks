package com.wiccanarts.common.core.proxy;

import com.wiccanarts.client.fx.ParticleF;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ServerProxy implements ISidedProxy {

	@Override
	public void preInit (FMLPreInitializationEvent event) {
	}

	@Override
	public void init (FMLInitializationEvent event) {
	}

	@Override
	public void postInit (FMLPostInitializationEvent event) {
	}

	@Override
	public void displayRecordText (ITextComponent text) {
	}

	@Override
	public void spawnParticle (ParticleF particleF, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float... args) {
	}
}
