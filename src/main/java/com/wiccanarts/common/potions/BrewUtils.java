package com.wiccanarts.common.potions;

import com.wiccanarts.common.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;

import java.util.Arrays;

/**
 * Created by BerciTheBeast on 27.3.2017.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BrewUtils {

	public static ItemStack createPotion(PotionEffect... effects) {
		return createPotion(new ItemStack(ModItems.BREW_PHIAL), effects);
	}

	public static ItemStack createPotion(ItemStack stack, PotionEffect... effects) {
		PotionUtils.appendEffects(stack, Arrays.asList(effects));
		return stack;
	}
}
