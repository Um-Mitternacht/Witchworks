package com.wiccanarts.common.block.tile;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 08/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public abstract class TileMod extends TileEntity {

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}

	@Override
	public final NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound par1nbtTagCompound) {
		final NBTTagCompound ret = super.writeToNBT(par1nbtTagCompound);
		writeDataNBT(ret);
		return ret;
	}

	@Override
	public final SPacketUpdateTileEntity getUpdatePacket() {
		final NBTTagCompound tag = getUpdateTag();
		writeDataNBT(tag);
		return new SPacketUpdateTileEntity(pos, 0, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		super.onDataPacket(net, packet);
		readDataNBT(packet.getNbtCompound());
	}

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound) {
		super.readFromNBT(par1nbtTagCompound);
		readDataNBT(par1nbtTagCompound);
	}

	abstract void writeDataNBT(NBTTagCompound cmp);

	abstract void readDataNBT(NBTTagCompound cmp);
}