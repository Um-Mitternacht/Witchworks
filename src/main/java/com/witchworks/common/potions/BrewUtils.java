package com.witchworks.common.potions;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.item.BrewEffect;
import com.witchworks.api.item.IBrew;
import com.witchworks.api.item.NBTHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
public class BrewUtils {

	public static final String BREW_TAG = "brew";
	public static final String COLOR_TAG = "color";
	public static final String NAME_TAG = "name";
	public static final String DESC_TAG = "desc";

	public static final String INSTANT_TAG = "instant";
	public static final String DURATION_TAG = "duration";

	public static ItemStack createPotion(Item item, Collection<PotionEffect> effects) {
		return createPotion(new ItemStack(item), effects);
	}

	public static ItemStack createPotion(ItemStack stack, Collection<PotionEffect> effects) {
		PotionUtils.appendEffects(stack, effects);
		return stack;
	}

	public static ItemStack createPotion(Item in, PotionEffect... effects) {
		return createPotion(new ItemStack(in), effects);
	}

	public static ItemStack createPotion(ItemStack stack, PotionEffect... effects) {
		PotionUtils.appendEffects(stack, Arrays.asList(effects));
		return stack;
	}

	public static ItemStack createBrew(Item item, BrewEffect effect) {
		return createBrew(new ItemStack(item), effect.getBrew(), effect.getDuration(), effect.isInstant());
	}

	public static ItemStack createBrew(Item item, IBrew brew, int duration, boolean instant) {
		return createBrew(new ItemStack(item), brew, duration, instant);
	}

	public static ItemStack createBrew(ItemStack stack, IBrew brew, int duration, boolean instant) {
		NBTHelper.setInteger(stack, BREW_TAG, BrewRegistry.getBrewId(brew));
		NBTHelper.setInteger(stack, COLOR_TAG, brew.getColor());
		NBTHelper.setString(stack, NAME_TAG, brew.getName());
		NBTHelper.setString(stack, DESC_TAG, brew.getDescription());
		NBTHelper.setInteger(stack, DURATION_TAG, duration);
		NBTHelper.setBoolean(stack, INSTANT_TAG, instant);
		return stack;
	}

	public static Optional<BrewEffect> getBrewFromStack(ItemStack stack) {
		if (isBrew(stack)) {
			IBrew brew = BrewRegistry.getBrewById(NBTHelper.getInteger(stack, BREW_TAG));
			int duration = NBTHelper.getInteger(stack, DURATION_TAG);
			boolean instant = NBTHelper.getBoolean(stack, INSTANT_TAG);
			return Optional.of(new BrewEffect(brew, duration, instant));
		}
		return Optional.empty();
	}

	public static boolean isBrew(ItemStack stack) {
		return NBTHelper.hasTag(stack, BREW_TAG);
	}

	@SideOnly (Side.CLIENT)
	public static void addBrewDescription(List<String> tooltip, ItemStack stack) {
		if (NBTHelper.hasTag(stack, DESC_TAG)) {
			String desc = NBTHelper.getString(stack, DESC_TAG);
			if (!desc.isEmpty())
				tooltip.add(I18n.format(desc));
		}
	}
}
