package com.wiccanarts.client.fx;

import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 02/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
interface IParticleF {

	Particle createParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, float... p_178902_15_);
}
