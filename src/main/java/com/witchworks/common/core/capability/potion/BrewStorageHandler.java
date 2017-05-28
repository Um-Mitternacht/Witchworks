package com.witchworks.common.core.capability.potion;

import com.witchworks.api.item.BrewEffect;
import com.witchworks.api.item.IBrew;
import net.minecraft.entity.EntityLivingBase;

import java.util.Map;
import java.util.Optional;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class BrewStorageHandler {

	private BrewStorageHandler() {
	}

	/**
	 * Returns the {@link IBrewStorage} interface of the brew storage.
	 * @param entity The entity
	 * @return An {@link Optional <IBrewStorage>} for correctness
	 */
	@SuppressWarnings ("ConstantConditions")
	public static Optional<IBrewStorage> getBrewStorage(EntityLivingBase entity) {
		if (entity.hasCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null)) {
			return Optional.of(entity.getCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null));
		}
		return Optional.empty();
	}

	/**
	 * Checks if a Brew is active.
	 * @param entity The entity
	 * @param brew The brew
	 * @return If it is active
	 */
	public static boolean isBrewActive(EntityLivingBase entity, IBrew brew) {
		Optional<IBrewStorage> optional = BrewStorageHandler.getBrewStorage(entity);
		return optional.isPresent() && optional.get().getBrews().containsKey(brew);
	}

	/**
	 * Add a BrewEffect to the entity.
	 * @param entity The entity
	 * @param effect The effect
	 */
	public static void addEntityBrewEffect(EntityLivingBase entity, BrewEffect effect) {
		Optional<IBrewStorage> optional = BrewStorageHandler.getBrewStorage(entity);
		if (optional.isPresent()) {
			Map<IBrew, BrewEffect> effectMap = optional.get().getBrews();
			BrewEffect out = effectMap.get(effect.getBrew());
			if (out == null || effect.getDuration() > out.getDuration()) {
				effectMap.put(effect.getBrew(), effect);
			}
			optional.get().setBrews(effectMap);
		}
	}
}
