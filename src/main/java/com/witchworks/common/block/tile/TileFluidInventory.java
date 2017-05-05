package com.witchworks.common.block.tile;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 01/05/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public abstract class TileFluidInventory extends TileEntity {

	KettleFluid tank = createFluidHandler();

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		tank.readFromNBT(tag);
		readDataNBT(tag);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		tag = super.writeToNBT(tag);
		tank.writeToNBT(tag);
		writeDataNBT(tag);
		return tag;
	}

	private KettleFluid createFluidHandler() {
		return new KettleFluid(this, Fluid.BUCKET_VOLUME);
	}

	abstract void writeDataNBT(NBTTagCompound cmp);

	abstract void readDataNBT(NBTTagCompound cmp);

	abstract void onLiquidChange();

	public void play(SoundEvent events, float volume, float pitch) {
		world.playSound(null, getPos(), events, SoundCategory.BLOCKS, volume, pitch);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
	}

	@SuppressWarnings ("unchecked")
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY)
			return (T) tank;
		return super.getCapability(capability, facing);
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(getPos(), 0, getUpdateTag());
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
	}

	@SuppressWarnings ("WeakerAccess")
	public class KettleFluid extends FluidTank {

		final TileFluidInventory tile;

		public KettleFluid(TileFluidInventory tile, int capacity) {
			super(capacity);
			this.tile = tile;
		}

		public KettleFluid(TileFluidInventory tile, @Nullable FluidStack fluidStack, int capacity) {
			super(fluidStack, capacity);
			this.tile = tile;
		}

		public KettleFluid(TileFluidInventory tile, Fluid fluid, int amount, int capacity) {
			super(fluid, amount, capacity);
			this.tile = tile;
		}

		@Nullable
		public Fluid getInnerFluid() {
			return fluid != null ? fluid.getFluid() : null;
		}

		@Override
		protected void onContentsChanged() {
			tile.onLiquidChange();
		}

		public boolean containsFluid(Fluid other) {
			return fluid != null && fluid.getFluid() == other;
		}
	}
}
