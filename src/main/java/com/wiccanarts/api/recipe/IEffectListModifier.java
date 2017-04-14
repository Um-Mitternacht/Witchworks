package com.wiccanarts.api.recipe;

import com.wiccanarts.common.block.tile.TileKettle;
import net.minecraft.potion.PotionEffect;

import java.util.Collection;

/**
 * This class was created by Arekkuusu on 14/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public interface IEffectListModifier extends IEffectModifier {

	@Override
	default PotionHolder apply(PotionHolder effect) {
		return effect;
	}

	Collection<PotionEffect> modify(TileKettle kettle, Collection<PotionEffect> list);
}
