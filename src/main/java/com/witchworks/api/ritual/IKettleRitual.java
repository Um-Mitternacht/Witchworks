package com.witchworks.api.ritual;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 06/05/2017.
 * It's distributed as part of Witch Works under
 * the MIT license.
 */
public interface IKettleRitual <T extends TileEntity> {

	boolean check(World world, BlockPos pos);

	boolean tick(T tile, int tick);

	int getCost();
}
