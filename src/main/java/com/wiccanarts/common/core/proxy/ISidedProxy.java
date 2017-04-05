package com.wiccanarts.common.core.proxy;

import com.wiccanarts.client.fx.*;
import net.minecraft.util.text.*;
import net.minecraftforge.fml.common.event.*;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public interface ISidedProxy {

	void preInit(FMLPreInitializationEvent event);

	void init(FMLInitializationEvent event);

	void postInit(FMLPostInitializationEvent event);

	void displayRecordText(ITextComponent text);

	void spawnParticle(ParticleF particleF, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float... args);
}
