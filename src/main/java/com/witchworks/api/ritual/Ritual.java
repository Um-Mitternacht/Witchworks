package com.witchworks.api.ritual;

import com.witchworks.api.KettleRegistry;
import com.witchworks.common.core.capability.energy.EnergyHandler;
import com.witchworks.common.core.capability.energy.EnergyProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class was created by Arekkuusu on 06/05/2017.
 * It's distributed as part of Witch Works under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
public class Ritual <T extends TileEntity> {

	public static final IKettleRitual DEFAULT_NO_ENERGY = new DefaultRitual();

	private IKettleRitual<T> ritual;
	private ItemStack stack;
	private int cost;

	private boolean fail;
	private int drained;
	private int tick;

	private Ritual() {
		ritual = null;
		stack = null;
	}

	public Ritual(IKettleRitual<T> ritual) {
		this.ritual = ritual;
		this.cost = ritual.getCost();
		drained = cost;
	}

	public Ritual(IKettleRitual<T> ritual, ItemStack stack) {
		this.ritual = ritual;
		this.stack = stack;
		this.cost = ritual.getCost();
		drained = cost;
	}

	public static <T extends TileEntity> Ritual<T> newInstance() {
		return new Ritual<>();
	}

	public boolean canPerform(World world, BlockPos pos) {
		return ritual != null && ritual.check(world, pos);
	}

	public boolean update(T tile) {
		tile.markDirty();
		if (cost > 0 && drained > 0 && tick % 20 == 0) {
			drainEnergy(tile.getWorld(), tile.getPos());
		}
		return ritual != null && ritual.tick(tile, tick++);
	}

	@SuppressWarnings ("ConstantConditions")
	private void drainEnergy(World world, BlockPos pos) {
		List<EntityPlayer> list = world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos).expandXyz(5)).stream()
				.filter(player -> player.hasCapability(EnergyProvider.ENERGY_CAPABILITY, null)).collect(Collectors.toList());
		if (!list.isEmpty()) {
			list.forEach(player -> {
				if (drained <= 0) return;
				if (EnergyHandler.addEnergy(player, -1)) {
					--drained;
				} else {
					fail();
				}
			});
		} else {
			fail();
		}
	}

	public boolean isFail() {
		return fail;
	}

	public void fail() {
		this.fail = true;
	}

	public int getCost() {
		return cost;
	}

	public int getTick() {
		return tick;
	}

	public boolean hasEnded() {
		return tick >= 100 + (cost * 20);
	}

	public ItemStack getStack() {
		return stack;
	}

	@SuppressWarnings ("unchecked")
	public void readNBT(NBTTagCompound cmp) {
		NBTTagCompound tag = cmp.getCompoundTag("ritual_data");
		ritual = KettleRegistry.getKettleRituals().get(tag.getInteger("ritual"));
		drained = tag.getInteger("drained");
		tick = tag.getInteger("tick");
		stack = ItemStack.loadItemStackFromNBT(tag);
	}

	public void writeNBT(NBTTagCompound cmp) {
		NBTTagCompound tag = new NBTTagCompound();
		if (stack != null)
			tag = stack.writeToNBT(tag);
		tag.setInteger("ritual", KettleRegistry.getKettleRituals().indexOf(ritual));
		tag.setInteger("drained", drained);
		tag.setInteger("tick", tick);
		cmp.setTag("ritual_data", tag);
	}

	public static class DefaultRitual implements IKettleRitual {

		@Override
		public boolean check(World world, BlockPos pos) {
			return true;
		}

		@Override
		public boolean tick(TileEntity tile, int tick) {
			return true;
		}

		@Override
		public int getCost() {
			return 0;
		}
	}

	public static class EnergyRitual implements IKettleRitual {

		private final int cost;

		public EnergyRitual(int cost) {
			this.cost = cost;
		}

		@Override
		public boolean check(World world, BlockPos pos) {
			return !world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos).expandXyz(5)).isEmpty();
		}

		@Override
		public boolean tick(TileEntity tile, int tick) {
			return true;
		}

		@Override
		public int getCost() {
			return cost;
		}
	}
}
