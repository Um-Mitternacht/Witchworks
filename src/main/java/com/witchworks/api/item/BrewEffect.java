package com.witchworks.api.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BrewEffect {

	private IBrew brew;
	private boolean instant;
	private int duration;

	public BrewEffect(IBrew brew, int duration, boolean instant) {
		this.brew = brew;
		this.duration = duration;
		this.instant = instant;
	}

	public void update(World world, BlockPos pos, @Nullable EntityLivingBase entity) {
		brew.apply(world, pos, entity, duration--);
	}

	public void end(World world, BlockPos pos, @Nullable EntityLivingBase entity) {
		brew.onFinish(world, pos, entity);
	}

	public IBrew getBrew() {
		return brew;
	}

	public int getDuration() {
		return duration;
	}

	public boolean isInstant() {
		return instant;
	}

	public BrewEffect copy() {
		return new BrewEffect(brew, duration, instant);
	}
}
