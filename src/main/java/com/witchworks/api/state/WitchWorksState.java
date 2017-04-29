package com.witchworks.api.state;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;

/**
 * This class was created by Arekkuusu on 28/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class WitchWorksState {

	public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create("color", EnumDyeColor.class);
	public static final PropertyEnum<BlockStairs.EnumHalf> HALF = PropertyEnum.create("half", BlockStairs.EnumHalf.class);

	private WitchWorksState() {
	}
}
