package com.witchworks.common.core.capability.potion;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.IBrew;
import com.witchworks.api.brew.BrewUtils;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class CapabilityBrewStorage {

	private CapabilityBrewStorage() {
	}

	public static void init() {
		CapabilityManager.INSTANCE.register(IBrewStorage.class, new Capability.IStorage<IBrewStorage>() {

			@Override
			public NBTBase writeNBT(Capability<IBrewStorage> capability, IBrewStorage instance, EnumFacing side) {
				NBTTagList tagList = new NBTTagList();
				for (Map.Entry<IBrew, BrewEffect> entry : instance.getBrews().entrySet()) {
					NBTTagCompound tag = new NBTTagCompound();
					tag.setInteger(BrewUtils.BREW_ID, BrewRegistry.getBrewId(entry.getKey()));
					tag.setInteger(BrewUtils.BREW_DURATION, entry.getValue().getDuration());
					tag.setInteger(BrewUtils.BREW_AMPLIFIER, entry.getValue().getAmplifier());
					tagList.appendTag(tag);
				}
				NBTTagCompound compound = new NBTTagCompound();
				compound.setTag(BrewUtils.BREW_DATA, tagList);
				return compound;
			}

			@Override
			public void readNBT(Capability<IBrewStorage> capability, IBrewStorage instance, EnumFacing side, NBTBase nbt) {
				Map<IBrew, BrewEffect> effects = new HashMap<>();
				NBTTagList tagList = (NBTTagList) ((NBTTagCompound) nbt).getTag(BrewUtils.BREW_DATA);
				for (int i = 0; i < tagList.tagCount(); i++) {
					NBTTagCompound tag = (NBTTagCompound) tagList.get(i);
					IBrew brew = BrewRegistry.getBrewById(tag.getInteger(BrewUtils.BREW_ID));
					int duration = tag.getInteger(BrewUtils.BREW_DURATION);
					int amplifier = tag.getInteger(BrewUtils.BREW_AMPLIFIER);
					effects.put(brew, new BrewEffect(brew, duration, amplifier));
				}
				instance.setBrews(effects);
			}

		}, DefaultBrewStorage::new);
	}

	public static class DefaultBrewStorage implements IBrewStorage {

		private Map<IBrew, BrewEffect> effects = new LinkedHashMap<>();
		private Set<IBrew> client;

		@Override
		public Map<IBrew, BrewEffect> getBrews() {
			return effects;
		}

		@Override
		public void setBrews(Map<IBrew, BrewEffect> effects) {
			this.effects = effects;
		}

		@SideOnly(Side.CLIENT)
		public Set<IBrew> getClient() {
			return client;
		}

		@SideOnly(Side.CLIENT)
		public void setClient(Set<IBrew> client) {
			this.client = client;
		}
	}
}
