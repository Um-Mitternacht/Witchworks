package com.witchworks.common.core.capability.potion;

import com.witchworks.api.item.BrewEffect;
import com.witchworks.api.item.IBrew;

import java.util.Map;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public interface IBrewStorage {

	Map<IBrew, BrewEffect> getBrews();

	void setBrews(Map<IBrew, BrewEffect> effect);
}
