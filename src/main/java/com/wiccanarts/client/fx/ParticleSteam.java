package com.wiccanarts.client.fx;

import com.wiccanarts.client.ResourceLocations;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Arekkuusu on 04/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */

@SideOnly (Side.CLIENT)
class ParticleSteam extends Particle {

	private final float particleScaleOverTime;

	private ParticleSteam (World world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		super (world, x, y, z, xSpeed, ySpeed, zSpeed);
		this.motionY *= 0.20000000298023224D;

		if (xSpeed == 0.0D && zSpeed == 0.0D) {
			this.motionX *= 0.10000000149011612D;
			this.motionZ *= 0.10000000149011612D;
		}

		this.particleScale *= 0.75F;
		this.particleScaleOverTime = this.particleScale;
		this.particleMaxAge = (int) (8.0D / (Math.random () * 0.8D + 0.2D));

		final TextureAtlasSprite atlasSprite = Minecraft.getMinecraft ().getTextureMapBlocks ().getAtlasSprite (ResourceLocations.STEAM.toString ());
		setParticleTexture (atlasSprite);
	}

	@Override
	public void renderParticle (VertexBuffer buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		float f = ((float) this.particleAge + partialTicks) / (float) this.particleMaxAge * 32.0F;
		f = MathHelper.clamp (f, 0.0F, 1.0F);
		this.particleScale = this.particleScaleOverTime * f;
		super.renderParticle (buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

	public void onUpdate () {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY += 0.004D;
		this.move (this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9599999785423279D;
		this.motionY *= 0.9599999785423279D;
		this.motionZ *= 0.9599999785423279D;
		if (this.isCollided) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}

		if (this.particleMaxAge-- <= 0) {
			this.setExpired ();
		}
	}

	@Override
	public int getFXLayer () {
		return 1;
	}

	@Override
	public boolean isTransparent () {
		return true;
	}

	@SideOnly (Side.CLIENT)
	static class Factory implements IParticleF {
		public Particle createParticle (World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, float... args) {
			return new ParticleSteam (worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
		}
	}
}
