package com.wiccanarts.common.net;

import com.wiccanarts.client.fx.*;
import com.wiccanarts.common.lib.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;
import net.minecraftforge.fml.relauncher.*;

/**
 * This class was created by Arekkuusu on 08/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class PacketHandler {

	private static final SimpleNetworkWrapper HANDLER = new SimpleNetworkWrapper(LibMod.MOD_ID);

	public static void init() {
		int id = 0;
		HANDLER.registerMessage(ParticleMessage.ParticleMessageHandler.class, ParticleMessage.class, id++, Side.CLIENT);
	}

	public static void sendToServer(IMessage message) {
		HANDLER.sendToServer(message);
	}

	public static void sendTo(EntityPlayerMP player, IMessage message) {
		HANDLER.sendTo(message, player);
	}

	public static void sendToNear(Entity entity, IMessage message) {
		sendToNear(entity.getEntityWorld(), new BlockPos(entity), message);
	}

	public static void sendToNear(World world, BlockPos pos, IMessage message) {
		if (world instanceof WorldServer) {
			WorldServer ws = (WorldServer) world;

			for (EntityPlayer player : ws.playerEntities) {
				EntityPlayerMP playerMP = (EntityPlayerMP) player;

				if (playerMP.getDistanceSq(pos) < 64 * 64
						&& ws.getPlayerChunkMap().isPlayerWatchingChunk(playerMP, pos.getX() >> 4, pos.getZ() >> 4)) {
					HANDLER.sendTo(message, playerMP);
				}
			}
		}
	}

	public static void spawnParticle(ParticleF particleF, World world, double x, double y, double z, int amount, double xSpeed, double ySpeed, double zSpeed, float... args) {
		sendToNear(world, new BlockPos(x, y, z), new ParticleMessage(particleF, x, y, z, amount, xSpeed, ySpeed, zSpeed, args));
	}

	public static void sendTileUpdateNearbyPlayers(TileEntity tile) {
		IBlockState state = tile.getWorld().getBlockState(tile.getPos());
		tile.getWorld().notifyBlockUpdate(tile.getPos(), state, state, 8);
	}

	public static void updateToNearbyPlayers(World worldObj, BlockPos pos) {
		IBlockState state = worldObj.getBlockState(pos);
		worldObj.notifyBlockUpdate(pos, state, state, 8);
	}
}
