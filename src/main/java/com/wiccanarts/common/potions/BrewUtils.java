package com.wiccanarts.common.potions;

import net.minecraft.item.*;
import net.minecraft.potion.*;

import java.util.*;

/**
 * Created by BerciTheBeast on 27.3.2017.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
public class BrewUtils {

	public static ItemStack createPotion (Item in, PotionEffect... effects) {
		return createPotion (new ItemStack (in), effects);
	}

	public static ItemStack createPotion (ItemStack stack, PotionEffect... effects) {
		PotionUtils.appendEffects (stack, Arrays.asList (effects));
		return stack;
	}
}
