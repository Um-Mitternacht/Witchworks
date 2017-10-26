package com.witchworks.common.core.proxy;

import com.witchworks.client.fx.ParticleF;
import com.witchworks.common.lib.LibMod;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SideOnly(Side.SERVER)
@Mod.EventBusSubscriber(modid = LibMod.MOD_ID)
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
