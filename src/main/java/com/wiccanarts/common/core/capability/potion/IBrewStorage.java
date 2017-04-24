package com.wiccanarts.common.core.capability.potion;

import com.wiccanarts.api.item.BrewEffect;
import com.wiccanarts.api.item.IBrew;

import java.util.Map;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public interface IBrewStorage {

	void setBrews(Map<IBrew, BrewEffect> effect);

	Map<IBrew, BrewEffect> getBrews();
}
