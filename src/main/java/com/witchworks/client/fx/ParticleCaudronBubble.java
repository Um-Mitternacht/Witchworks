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

import java.awt.*;

@SideOnly (Side.CLIENT)
class ParticleCaudronBubble extends Particle {

	private int pop_timer;
	private TextureAtlasSprite pop;

	private ParticleCaudronBubble(World world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int rgb) {
		super(world, x, y, z, xSpeed, ySpeed, zSpeed);
		this.motionX = 0;
		this.motionY = 0;
		this.motionZ = 0;
		this.setSize(0.02F, 0.02F);
		this.particleScale *= 0.2F;
		this.motionY = ySpeed * 0.20000000298023224D + (Math.random() * 2.0D - 1.0D) * 0.019999999552965164D;
		this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
		float r = (rgb >>> 16 & 0xFF) / 256.0F;
		float g = (rgb >>> 8 & 0xFF) / 256.0F;
		float b = (rgb & 0xFF) / 256.0F;
		setRBGColorF(r, g, b);

		final TextureAtlasSprite atlasSprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ResourceLocations.CAULDRON_BUBBLE.toString());
		pop = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ResourceLocations.CAULDRON_BUBBLE_POP.toString());
		setParticleTexture(atlasSprite);
	}

	@Override
	public void renderParticle(VertexBuffer buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		GlStateManager.color(getRedColorF(), getGreenColorF(), getBlueColorF(), 1F);
		super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY += 0.001D;
		this.move(0, this.motionY, 0);
		this.motionY *= 0.4500000238418579D;

		if (pop_timer == 0 && --particleMaxAge <= 0) {
			setParticleTexture(pop);
			pop_timer = 4;
		} else if (this.particleMaxAge <= 0 && --pop_timer <= 0) {
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
		public Particle createParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... args) {
			Color color = new Color(args[0]).darker();
			return new ParticleCaudronBubble(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn, color.getRGB());
		}
	}
}