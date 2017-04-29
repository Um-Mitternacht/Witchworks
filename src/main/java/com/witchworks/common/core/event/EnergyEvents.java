package com.witchworks.common.core.event;

import com.witchworks.common.core.capability.energy.EnergyHandler;
import com.witchworks.common.core.capability.energy.EnergyProvider;
import com.witchworks.common.core.capability.energy.IEnergy;
import com.witchworks.common.core.net.EnergyMessage;
import com.witchworks.common.core.net.PacketHandler;
import com.witchworks.common.lib.LibMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Optional;

/**
 * This class was created by Arekkuusu on 20/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class EnergyEvents {

	@SubscribeEvent
	public void attachPlayer(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof EntityPlayer) {
			event.addCapability(new ResourceLocation(LibMod.MOD_ID, "EnergyData"), new EnergyProvider());
		}
	}

	@SuppressWarnings ("ConstantConditions")
	@SubscribeEvent
	public void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event) {
		final EntityPlayer oldPlayer = event.getOriginal();
		final EntityPlayer newPlayer = event.getEntityPlayer();

		if (event.isWasDeath() && oldPlayer.hasCapability(EnergyProvider.ENERGY_CAPABILITY, null) && newPlayer.hasCapability(EnergyProvider.ENERGY_CAPABILITY, null)) {
			final IEnergy oldCap = oldPlayer.getCapability(EnergyProvider.ENERGY_CAPABILITY, null);
			final IEnergy newCap = oldPlayer.getCapability(EnergyProvider.ENERGY_CAPABILITY, null);
			newCap.set(oldCap.get());
			newCap.setMax(oldCap.getMax());
			newCap.setRegen(oldCap.getRegen());
			newCap.setUses(oldCap.getUses());
			newCap.setOverchannel(oldCap.getOverchannel());
		}
	}

	@SubscribeEvent
	public void onWorldJoin(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof EntityPlayerMP) {
			EntityPlayerMP entity = (EntityPlayerMP) event.getEntity();
			Optional<IEnergy> optional = EnergyHandler.getEnergy(entity);
			if (optional.isPresent()) {
				PacketHandler.sendTo(entity, new EnergyMessage(optional.get(), entity.getUniqueID()));
			}
		}
	}

	@SubscribeEvent
	public void playerUpdate(LivingEvent.LivingUpdateEvent event) {
		if (!event.getEntity().world.isRemote && event.getEntity() instanceof EntityPlayer) {
			final EntityPlayer player = (EntityPlayer) event.getEntity();
			final Optional<IEnergy> optional = EnergyHandler.getEnergy(player);
			if (optional.isPresent()) {
				final IEnergy energy = optional.get();
				energyRegen(player, energy);
				overcast(player, energy);
			}
		}
	}

	private void energyRegen(EntityPlayer player, IEnergy energy) {
		if (energy.getRegen() == -1) return;
		if (energy.get() < energy.getMax() && energy.tick() % (energy.getRegen() + getTimeModifier(player)) == 0) {
			energy.set(energy.get() + 1 + getAmountModifier(player));
			energy.tickReset();
			if (player instanceof EntityPlayerMP)
				PacketHandler.sendTo((EntityPlayerMP) player, new EnergyMessage(energy, player.getUniqueID()));
		}
	}

	private int getTimeModifier(EntityPlayer player) {
		//TODO: Add boosts
		return 0;
	}

	private int getAmountModifier(EntityPlayer player) {
		//TODO: Add boosts
		return 0;
	}

	private void overcast(EntityPlayer player, IEnergy energy) {
		if (energy.getOverchannel() <= 0) return;

		energy.setOverchannel(0);
	}
}
