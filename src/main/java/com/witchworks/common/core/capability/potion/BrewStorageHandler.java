package com.witchworks.common.core.capability.potion;

import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.IBrew;
import net.minecraft.entity.EntityLivingBase;

import java.util.Collection;
import java.util.Collections;
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
	 *
	 * @param entity The entity
	 * @return An {@link Optional <IBrewStorage>} for correctness
	 */
	@SuppressWarnings("ConstantConditions")
	public static Optional<IBrewStorage> getBrewStorage(EntityLivingBase entity) {
		if (entity.hasCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null)) {
			return Optional.of(entity.getCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null));
		}
		return Optional.empty();
	}

	@SuppressWarnings("ConstantConditions")
	public static Map<IBrew, BrewEffect> getBrewMap(EntityLivingBase entity) {
		if (entity.hasCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null)) {
			IBrewStorage storage = entity.getCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null);
			return storage.getBrews();
		}
		return Collections.emptyMap();
	}

	@SuppressWarnings("ConstantConditions")
	public static Collection<BrewEffect> getBrewEffects(EntityLivingBase entity) {
		if (entity.hasCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null)) {
			IBrewStorage storage = entity.getCapability(BrewStorageProvider.BREW_STORAGE_CAPABILITY, null);
			return storage.getBrews().values();
		}
		return Collections.emptyList();
	}

	/**
	 * Checks if a Brew is active.
	 *
	 * @param entity The entity
	 * @param brew   The brew
	 * @return If it is active
	 */
	public static boolean isBrewActive(EntityLivingBase entity, IBrew brew) {
		Optional<IBrewStorage> optional = BrewStorageHandler.getBrewStorage(entity);
		return optional.isPresent() && optional.get().getBrews().containsKey(brew);
	}

	/**
	 * Add a BrewEffect to the entity.
	 *
	 * @param entity The entity
	 * @param effect The effect
	 */
	public static void addEntityBrewEffect(EntityLivingBase entity, BrewEffect effect) {
		Optional<IBrewStorage> optional = BrewStorageHandler.getBrewStorage(entity);
		if (optional.isPresent()) {
			Map<IBrew, BrewEffect> effectMap = optional.get().getBrews();
			IBrew brew = effect.getBrew();
			BrewEffect out = effectMap.get(brew);
			if (out == null || effect.getDuration() > out.getDuration()) {
				effectMap.put(brew, effect);
				effect.start(entity);
			}
			optional.get().setBrews(effectMap);
		}
	}
}
