package com.witchcraft.common.core.proxy;

import com.witchcraft.client.fx.ParticleF;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchcraft under
 * the MIT license.
 */
public class ServerProxy implements ISidedProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		//NO-OP
	}

	@Override
	public void init(FMLInitializationEvent event) {
		//NO-OP
	}

	@Override
	public void displayRecordText(ITextComponent text) {
		//NO-OP
	}

	@Override
	public void spawnParticle(ParticleF particleF, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int... args) {
		//NO-OP
	}
}
