package com.witchworks.common.core.event;

import com.witchworks.api.item.BrewEffect;
import com.witchworks.api.item.IBrew;
import com.witchworks.common.core.capability.potion.BrewStorageHandler;
import com.witchworks.common.core.capability.potion.BrewStorageProvider;
import com.witchworks.common.core.capability.potion.IBrewStorage;
import com.witchworks.common.core.net.PacketHandler;
import com.witchworks.common.core.net.PotionMessage;
import com.witchworks.common.lib.LibMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BrewEvents {

	@SubscribeEvent
	public void attachPlayer(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityLivingBase) {
			event.addCapability(new ResourceLocation(LibMod.MOD_ID, "BrewData"), new BrewStorageProvider());
		}
	}

	@SuppressWarnings ("ConstantConditions")
	@SubscribeEvent
	public void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event) {
		final EntityPlayer oldPlayer = event.getOriginal();
		final EntityPlayer newPlayer = event.getEntityPlayer();

		if (event.isWasDeath() && oldPlayer.hasCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null) && newPlayer.hasCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null)) {
			final IBrewStorage oldCap = oldPlayer.getCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null);
			final IBrewStorage newCap = oldPlayer.getCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null);
			newCap.setBrews(oldCap.getBrews());
		}
	}

	@SubscribeEvent
	public void onUpdate(LivingEvent.LivingUpdateEvent event) {
		final EntityLivingBase entity = event.getEntityLiving();
		if (entity == null) return;
		Optional<IBrewStorage> optional = BrewStorageHandler.getBrewStorage(entity);
		if (optional.isPresent()) {
			IBrewStorage storage = optional.get();
			Map<IBrew, BrewEffect> brews = storage.getBrews();
			if (brews.isEmpty()) return;

			Map<IBrew, BrewEffect> updated = new HashMap<>();
			for (IBrew brew : brews.keySet()) {
				BrewEffect effect = brews.get(brew);
				if (effect.isInstant() || effect.getDuration() <= 0) {
					effect.end(entity.world, entity.getPosition(), entity);
				} else {
					effect.update(entity.world, entity.getPosition(), entity);
					updated.put(effect.getBrew(), effect);
				}
			}

			storage.setBrews(updated);
			if (entity instanceof EntityPlayer) {
				PacketHandler.sendTo((EntityPlayerMP) entity, new PotionMessage(updated.keySet(), entity.getUniqueID()));
			}
		}
	}
}
