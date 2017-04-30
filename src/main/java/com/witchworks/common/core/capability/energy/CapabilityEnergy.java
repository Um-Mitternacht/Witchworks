package com.witchworks.common.core.capability.energy;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;

/**
 * This class was created by Arekkuusu on 20/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class CapabilityEnergy {

	private static final String AMOUNT = "energy_amount";
	private static final String MAX = "energy_max";
	private static final String REGEN = "energy_regen";
	private static final String USES = "energy_uses";
	private static final String OVERCHANNEL = "energy_overchannel";

	private CapabilityEnergy() {
	}

	public static void init() {
		CapabilityManager.INSTANCE.register(IEnergy.class, new IStorage<IEnergy>() {

			@Override
			public NBTBase writeNBT(Capability<IEnergy> capability, IEnergy instance, EnumFacing side) {
				final NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger(AMOUNT, instance.get());
				tag.setInteger(MAX, instance.getMax());
				tag.setInteger(REGEN, instance.getRegen());
				tag.setInteger(USES, instance.getUses());
				tag.setInteger(OVERCHANNEL, instance.getOverchannel());
				return tag;
			}

			@Override
			public void readNBT(Capability<IEnergy> capability, IEnergy instance, EnumFacing side, NBTBase nbt) {
				final NBTTagCompound tag = (NBTTagCompound) nbt;
				instance.set(tag.getInteger(AMOUNT));
				instance.setMax(tag.getInteger(MAX));
				instance.setRegen(tag.getInteger(REGEN));
				instance.setUses(tag.getInteger(USES));
				instance.setOverchannel(tag.getInteger(OVERCHANNEL));
			}
		}, DefaultEnergy::new);
	}

	public static class DefaultEnergy implements IEnergy {

		private int amount;
		private int max = 8;
		private int regen = 20;
		private int uses;
		private int overchannel;
		private int tick;

		@Override
		public boolean set(int i) {
			this.amount = i;
			if (this.amount > getMax())
				this.amount = getMax();
			if (this.amount < 0) {
				setOverchannel(this.amount * -1);
				this.amount = 0;
			}

			return i >= 0 && i <= getMax();
		}

		@Override
		public int get() {
			return amount;
		}

		@Override
		public int getMax() {
			return max;
		}

		@Override
		public void setMax(int max) {
			this.max = max;
		}

		@Override
		public int getRegen() {
			return regen;
		}

		@Override
		public void setRegen(int rate) {
			this.regen = rate > 0 ? rate : -1;
		}

		@Override
		public int getUses() {
			return uses;
		}

		@Override
		public void setUses(int uses) {
			this.uses = uses >= 0 ? uses : 0;
		}

		@Override
		public int getOverchannel() {
			return overchannel;
		}

		@Override
		public void setOverchannel(int overchannel) {
			this.overchannel = overchannel;
		}

		@Override
		public int tick() {
			return ++tick;
		}

		@Override
		public void tickReset() {
			this.tick = 0;
		}
	}
}
