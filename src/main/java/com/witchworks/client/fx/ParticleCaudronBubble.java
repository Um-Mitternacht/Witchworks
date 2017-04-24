package com.witchworks.client.fx;

import com.witchworks.client.ResourceLocations;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly (Side.CLIENT)
class ParticleCaudronBubble extends Particle {

	private ParticleCaudronBubble(World world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float[] colors) {
		super(world, x, y, z, xSpeed, ySpeed, zSpeed);
		this.setSize(0.02F, 0.02F);
		this.particleScale *= 0.2F;
		this.motionY = ySpeed * 0.20000000298023224D + (Math.random() * 2.0D - 1.0D) * 0.019999999552965164D;
		this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
		setRBGColorF(colors[0], colors[1], colors[2]);

		final TextureAtlasSprite atlasSprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ResourceLocations.CAULDRON_BUBBLE.toString());
		setParticleTexture(atlasSprite);
	}

	@Override
	public void renderParticle(VertexBuffer buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
		GlStateManager.color(getRedColorF(), getGreenColorF(), getBlueColorF(), 1.0F);
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY += 0.002D;
		this.move(0, this.motionY, 0);
		this.motionY *= 0.4500000238418579D;

		if (this.particleMaxAge-- <= 0) {
			this.setExpired();
		}
	}

	@Override
	public int getFXLayer() {
		return 1;
	}

	@Override
	public boolean isTransparent() {
		return true;
	}

	@SideOnly (Side.CLIENT)
	static class Factory implements IParticleF {
		public Particle createParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, float... args) {
			return new ParticleCaudronBubble(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn, args);
		}
	}
}