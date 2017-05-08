package com.witchworks.common.core.net;

import com.witchworks.client.fx.ParticleF;
import com.witchworks.common.lib.LibMod;
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
import net.minecraftforge.fml.relauncher.Side;

/**
 * This class was created by Arekkuusu on 08/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class PacketHandler {

	private static final SimpleNetworkWrapper HANDLER = new SimpleNetworkWrapper(LibMod.MOD_ID);

	private PacketHandler() {
	}

	public static void init() {
		int id = 0;
		HANDLER.registerMessage(ParticleMessage.ParticleMessageHandler.class, ParticleMessage.class, id++, Side.CLIENT);
		HANDLER.registerMessage(EnergyMessage.EnergyMessageHandler.class, EnergyMessage.class, id++, Side.CLIENT);
		HANDLER.registerMessage(PotionMessage.PotionMessageHandler.class, PotionMessage.class, id, Side.CLIENT);
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
			final WorldServer ws = (WorldServer) world;

			for (EntityPlayer player : ws.playerEntities) {
				final EntityPlayerMP playerMP = (EntityPlayerMP) player;

				if (playerMP.getDistanceSq(pos) < 64 * 64
						&& ws.getPlayerChunkMap().isPlayerWatchingChunk(playerMP, pos.getX() >> 4, pos.getZ() >> 4)) {
					HANDLER.sendTo(message, playerMP);
				}
			}
		}
	}

	public static void spawnParticle(ParticleF particleF, World world, double x, double y, double z, int amount, double xSpeed, double ySpeed, double zSpeed, int... args) {
		sendToNear(world, new BlockPos(x, y, z), new ParticleMessage(particleF, x, y, z, amount, xSpeed, ySpeed, zSpeed, args));
	}

	public static void sendTileUpdateNearbyPlayers(TileEntity tile) {
		final IBlockState state = tile.getWorld().getBlockState(tile.getPos());
		tile.getWorld().notifyBlockUpdate(tile.getPos(), state, state, 8);
	}

	public static void updateToNearbyPlayers(World worldObj, BlockPos pos) {
		final IBlockState state = worldObj.getBlockState(pos);
		worldObj.notifyBlockUpdate(pos, state, state, 8);
	}
}
