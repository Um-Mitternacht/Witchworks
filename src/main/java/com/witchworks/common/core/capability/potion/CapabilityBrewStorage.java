package com.witchworks.common.core.capability.potion;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.item.BrewEffect;
import com.witchworks.api.item.IBrew;
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
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class CapabilityBrewStorage {

	private static final String TAG_LIST = "tag_list";
	private static final String BREW_TAG = "brew";
	private static final String INSTANT_TAG = "instant";
	private static final String DURATION_TAG = "duration";

	private CapabilityBrewStorage() {
	}

	public static void init() {
		CapabilityManager.INSTANCE.register(IBrewStorage.class, new Capability.IStorage<IBrewStorage>() {

			@Override
			public NBTBase writeNBT(Capability<IBrewStorage> capability, IBrewStorage instance, EnumFacing side) {
				NBTTagList tagList = new NBTTagList();
				for (Map.Entry<IBrew, BrewEffect> entry : instance.getBrews().entrySet()) {
					NBTTagCompound tag = new NBTTagCompound();
					tag.setInteger(BREW_TAG, BrewRegistry.getBrewId(entry.getKey()));
					tag.setInteger(DURATION_TAG, entry.getValue().getDuration());
					tag.setBoolean(INSTANT_TAG, entry.getValue().isInstant());
					tagList.appendTag(tag);
				}
				NBTTagCompound compound = new NBTTagCompound();
				compound.setTag(TAG_LIST, tagList);
				return compound;
			}

			@Override
			public void readNBT(Capability<IBrewStorage> capability, IBrewStorage instance, EnumFacing side, NBTBase nbt) {
				Map<IBrew, BrewEffect> effects = new HashMap<>();
				NBTTagList tagList = ((NBTTagCompound) nbt).getTagList(TAG_LIST, 9);
				for (int i = 0; i < tagList.tagCount(); i++) {
					NBTTagCompound tag = (NBTTagCompound) tagList.get(i);
					IBrew brew = BrewRegistry.getBrewById(tag.getInteger(BREW_TAG));
					effects.put(brew, new BrewEffect(brew, tag.getInteger(DURATION_TAG), tag.getBoolean(INSTANT_TAG)));
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

		@SideOnly (Side.CLIENT)
		public Set<IBrew> getClient() {
			return client;
		}

		@SideOnly (Side.CLIENT)
		public void setClient(Set<IBrew> client) {
			this.client = client;
		}
	}
}
