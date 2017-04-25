package com.witchworks.common.core.capability.energy;

import com.witchworks.common.core.net.EnergyMessage;
import com.witchworks.common.core.net.PacketHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.Optional;

/**
 * This class was created by Arekkuusu on 20/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class EnergyHandler {

	private EnergyHandler() {
	}

	/**
	 * Adds the given value to the energy of the player.
	 * <p>
	 * If the amount drained is greater than the available amount,
	 * it automatically gets stored as overchannel
	 * </p>
	 * @param player The player
	 * @param amount The amount
	 * @return If the amount was greater or equal than 0 and less or equal than the max amount
	 */
	public static boolean addEnergy(EntityPlayer player, int amount) {
		final Optional<IEnergy> optional = getEnergy(player);
		boolean mod = false;

		if (optional.isPresent()) {
			IEnergy energy = optional.get();
			mod = energy.set(energy.get() + amount);
			energy.setUses(energy.getUses() + 1);
			energy.tickReset();
			if (player instanceof EntityPlayerMP)
				PacketHandler.sendTo((EntityPlayerMP) player, new EnergyMessage(energy, player.getUniqueID()));
		}
		return mod;
	}

	/**
	 * Sets the max energy a player can hold.
	 * @param player The player
	 * @param maxAmount The new max amount
	 */
	public static void setMaxEnergy(EntityPlayer player, int maxAmount) {
		Optional<IEnergy> optional = getEnergy(player);
		if (optional.isPresent() && maxAmount >= 0) {
			optional.get().setMax(maxAmount);
		}
	}

	/**
	 * Sets the regen of the player.
	 * <p>
	 * Any number smaller than 0 will set the regen to -1,
	 * thus deactivating regeneration
	 * </p>
	 * @param player The player
	 * @param timeInTicks Ticks
	 */
	public static void setRegen(EntityPlayer player, int timeInTicks) {
		Optional<IEnergy> optional = getEnergy(player);
		if (optional.isPresent()) {
			optional.get().setRegen(timeInTicks);
		}
	}

	/**
	 * Returns the {@link IEnergy} interface of the player.
	 * @param player The player
	 * @return An {@link Optional<IEnergy>} for correctness
	 */
	@SuppressWarnings ("ConstantConditions")
	public static Optional<IEnergy> getEnergy(EntityPlayer player) {
		if (player.hasCapability(EnergyProvider.ENERGY_CAPABILITY, null)) {
			return Optional.of(player.getCapability(EnergyProvider.ENERGY_CAPABILITY, null));
		}
		return Optional.empty();
	}
}
