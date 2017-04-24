package com.wiccanarts.api.item;

import com.wiccanarts.api.BrewRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public interface IBrew {

	/**
	 * Apply the effects
	 */
	void apply(World world, BlockPos pos, @Nullable EntityLivingBase entity, int tick);

	void onFinish(World world, BlockPos pos, @Nullable EntityLivingBase entity);

	int getColor();

	String getName();

	String getDescription();

	BrewRegistry.Brew getType();
}
