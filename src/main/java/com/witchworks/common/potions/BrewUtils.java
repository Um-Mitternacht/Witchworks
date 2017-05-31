package com.witchworks.common.potions;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.item.BrewEffect;
import com.witchworks.api.item.IBrew;
import com.witchworks.api.item.NBTHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BrewUtils {

	public static final String BREW_COLOR = "brew_color";
	public static final String BREW_NAME = "brew_name";
	public static final String BREW_DESC = "brew_desc";

	public static final String BREW_DATA = "brew_data";
	public static final String BREW_ID = "brew_id";
	public static final String BREW_AMPLIFIER = "brew_amplifier";
	public static final String BREW_DURATION = "brew_duration";

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

	public static void appendPotions(NBTTagCompound tag, Collection<PotionEffect> effects) {
		NBTTagList tagList = tag.getTagList("CustomPotionEffects", 9);
		for (PotionEffect potioneffect : effects) {
			tagList.appendTag(potioneffect.writeCustomPotionEffectToNBT(new NBTTagCompound()));
		}
		tag.setTag("CustomPotionEffects", tagList);
	}

	public static ItemStack createBrew(Item item, IBrew brew) {
		ItemStack stack = new ItemStack(item);
		addBrewEffect(stack, BrewRegistry.getDefault(brew));
		NBTHelper.setString(stack, BREW_NAME, brew.getName());
		NBTHelper.setString(stack, BREW_DESC, brew.getDescription());
		NBTHelper.setInteger(stack, BREW_COLOR, brew.getColor());
		return stack;
	}

	public static ItemStack createBrew(Item item, BrewEffect... effects) {
		ItemStack stack = new ItemStack(item);
		NBTTagList list = addBrewData(stack);
		for (BrewEffect effect : effects) {
			NBTTagCompound tag = new NBTTagCompound();
			IBrew brew = effect.getBrew();
			tag.setInteger(BREW_ID, BrewRegistry.getBrewId(brew));
			tag.setInteger(BREW_AMPLIFIER, effect.getAmplifier());
			tag.setInteger(BREW_DURATION, effect.getDuration());
			list.appendTag(tag);
		}
		return stack;
	}

	public static void appendBrews(NBTTagCompound tag, Collection<BrewEffect> effects) {
		NBTTagList list = new NBTTagList();
		tag.setTag(BREW_DATA, list);
		for (BrewEffect effect : effects) {
			NBTTagCompound compound = new NBTTagCompound();
			IBrew brew = effect.getBrew();
			compound.setInteger(BREW_ID, BrewRegistry.getBrewId(brew));
			compound.setInteger(BREW_AMPLIFIER, effect.getAmplifier());
			compound.setInteger(BREW_DURATION, effect.getDuration());
			list.appendTag(compound);
		}
	}

	public static ItemStack addBrewEffect(ItemStack stack, BrewEffect effect) {
		NBTTagList list = addBrewData(stack);
		NBTTagCompound tag = new NBTTagCompound();
		IBrew brew = effect.getBrew();
		tag.setInteger(BREW_ID, BrewRegistry.getBrewId(brew));
		tag.setInteger(BREW_AMPLIFIER, effect.getAmplifier());
		tag.setInteger(BREW_DURATION, effect.getDuration());
		list.appendTag(tag);
		return stack;
	}

	public static NBTTagList addBrewData(ItemStack stack) {
		if (!NBTHelper.hasTag(stack, BREW_DATA)) {
			NBTTagList list = new NBTTagList();
			NBTHelper.setNBT(stack, BREW_DATA, list);
			return list;
		}
		return NBTHelper.getNBT(stack, BREW_DATA);
	}

	public static ItemStack addBrewInfo(ItemStack stack, IBrew brew) {
		NBTHelper.setString(stack, BREW_NAME, brew.getName());
		NBTHelper.setString(stack, BREW_DESC, brew.getDescription());
		NBTHelper.setInteger(stack, BREW_COLOR, brew.getColor());

		return stack;
	}

	public static List<BrewEffect> getBrewsFromStack(ItemStack stack) {
		List<BrewEffect> effects = new ArrayList<>();

		NBTTagList list = NBTHelper.getNBT(stack, BREW_DATA);
		for (int i = 0, size = list.tagCount(); i < size; i++) {
			NBTTagCompound tag = list.getCompoundTagAt(i);
			IBrew brew = BrewRegistry.getBrewById(tag.getInteger(BREW_ID));
			int duration = tag.getInteger(BREW_DURATION);
			int amplifier = tag.getInteger(BREW_AMPLIFIER);
			effects.add(new BrewEffect(brew, duration, amplifier));
		}

		return effects;
	}

	public static NBTTagCompound serialize(Collection<Object> collection) {
		List<BrewEffect> brewEffects = new ArrayList<>();
		List<PotionEffect> potionEffects = new ArrayList<>();
		for (Object brew : collection) {
			if(brew instanceof BrewEffect) {
				brewEffects.add((BrewEffect) brew);
			} else if(brew instanceof PotionEffect){
				potionEffects.add((PotionEffect) brew);
			}
		}
		NBTTagCompound compound = new NBTTagCompound();

		appendPotions(compound, potionEffects);
		appendBrews(compound, brewEffects);

		return compound;
	}

	public static boolean hasBrewData(ItemStack stack) {
		return NBTHelper.hasTag(stack, BREW_DATA);
	}

	@SideOnly(Side.CLIENT)
	public static void addBrewDescription(List<String> tooltip, ItemStack stack) {
		if (NBTHelper.hasTag(stack, BREW_DESC)) {
			String desc = NBTHelper.getString(stack, BREW_DESC);
			if (!desc.isEmpty())
				tooltip.add(I18n.format(desc));
		}
	}
}
