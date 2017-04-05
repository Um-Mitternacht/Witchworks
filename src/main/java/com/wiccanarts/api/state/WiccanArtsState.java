package com.wiccanarts.api.state;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;

/**
 * This class was created by Arekkuusu on 28/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class WiccanArtsState {

	public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create ("color", EnumDyeColor.class);
	public static final PropertyEnum<BlockStairs.EnumHalf> HALF = PropertyEnum.create ("half", BlockStairs.EnumHalf.class);
	public static final PropertyDirection HORIZONTAL = PropertyDirection.create ("facing", EnumFacing.Plane.HORIZONTAL);

	private WiccanArtsState () {
	}
}
