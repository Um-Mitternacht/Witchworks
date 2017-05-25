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
@SuppressWarnings({"WeakerAccess", "unused"})
public class BrewUtils {

	public static final String brew_tag = "brew";
	public static final String color_tag = "color";
	public static final String name_tag = "name";
	public static final String desc_tag = "desc";

	public static final String instant_tag = "instant";
	public static final String duration_tag = "duration";

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
		NBTHelper.setInteger(stack, brew_tag, BrewRegistry.getBrewId(brew));
		NBTHelper.setInteger(stack, color_tag, brew.getColor());
		NBTHelper.setString(stack, name_tag, brew.getName());
		NBTHelper.setString(stack, desc_tag, brew.getDescription());
		NBTHelper.setInteger(stack, duration_tag, duration);
		NBTHelper.setBoolean(stack, instant_tag, instant);
		return stack;
	}

	public static Optional<BrewEffect> getBrewFromStack(ItemStack stack) {
		if (isBrew(stack)) {
			IBrew brew = BrewRegistry.getBrewById(NBTHelper.getInteger(stack, brew_tag));
			int duration = NBTHelper.getInteger(stack, duration_tag);
			boolean instant = NBTHelper.getBoolean(stack, instant_tag);
			return Optional.of(new BrewEffect(brew, duration, instant));
		}
		return Optional.empty();
	}

	public static boolean isBrew(ItemStack stack) {
		return NBTHelper.hasTag(stack, brew_tag);
	}

	@SideOnly(Side.CLIENT)
	public static void addBrewDescription(List<String> tooltip, ItemStack stack) {
		if (NBTHelper.hasTag(stack, desc_tag)) {
			String desc = NBTHelper.getString(stack, desc_tag);
			if (!desc.isEmpty())
				tooltip.add(I18n.format(desc));
		}
	}
}
