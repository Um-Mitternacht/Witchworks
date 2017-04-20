package com.wiccanarts.common.core.command;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

/**
 * This class was created by Arekkuusu on 19/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
class IncantationBurn implements IIncantation {

	@SuppressWarnings ("ConstantConditions")
	@Override
	public void cast(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		final EntityLivingBase entity = (EntityLivingBase) sender.getCommandSenderEntity();

		final Vec3d vec3d = new Vec3d(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ);
		final Vec3d vec3d1 = entity.getLookVec();
		final Vec3d vec3d2 = vec3d.addVector(vec3d1.xCoord * 10, vec3d1.yCoord * 10, vec3d1.zCoord * 10);

		final RayTraceResult traceBlocks = entity.world.rayTraceBlocks(vec3d, vec3d2, false, false, true);
		final BlockPos block = traceBlocks.getBlockPos();
		if (block != null && entity.world.getBlockState(block.offset(traceBlocks.sideHit)) == Blocks.AIR.getDefaultState()) {
			entity.world.playSound(null, block, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, 2F);
			entity.world.setBlockState(block.offset(traceBlocks.sideHit), Blocks.FIRE.getDefaultState());
		}
	}
}
