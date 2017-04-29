package com.witchworks.api.recipe;

import net.minecraft.potion.PotionEffect;

import java.util.Collection;

/**
 * This class was created by Arekkuusu on 14/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public interface IEffectListModifier extends IEffectModifier {

	@Override
	default PotionHolder apply(PotionHolder effect) {
		return effect;
	}

	Collection<PotionEffect> modify(Collection<PotionEffect> list);
}
