package com.wiccanarts.common.potions;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;

import java.util.Arrays;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
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
