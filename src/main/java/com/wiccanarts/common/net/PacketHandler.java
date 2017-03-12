package com.wiccanarts.common.net;

import com.wiccanarts.common.lib.LibMod;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

/**
 * This class was created by Arekkuusu on 08/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class PacketHandler {

	private static final SimpleNetworkWrapper HANDLER = new SimpleNetworkWrapper(LibMod.MOD_ID);

	public static void init() {
		//int id = 0;
		//HANDLER.registerMessage(Message.Handler.class, MessageUpdate.class, id++, Side.CLIENT);
	}

	public static void sendToServer(IMessage message) {
		HANDLER.sendToServer(message);
	}

	public static void sendTo(EntityPlayerMP player, IMessage message) {
		HANDLER.sendTo(message, player);
	}

	public static void sendToNear(Entity entity, IMessage message) {
		sendToNear(entity.worldObj, new BlockPos(entity), message);
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

	public static void sendTileUpdateNearbyPlayers(TileEntity tile) {
		IBlockState state = tile.getWorld().getBlockState(tile.getPos());
		tile.getWorld().notifyBlockUpdate(tile.getPos(), state, state, 8);
	}

	public static void updateToNearbyPlayers(World worldObj, BlockPos pos) {
		IBlockState state = worldObj.getBlockState(pos);
		worldObj.notifyBlockUpdate(pos, state, state, 8);
	}
}
