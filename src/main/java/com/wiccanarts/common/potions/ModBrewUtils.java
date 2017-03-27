package com.wiccanarts.common.potions;

import com.google.common.base.Objects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;

import java.util.Collection;

/**
 * Created by BerciTheBeast on 27.3.2017.
 */
public class ModBrewUtils {
	public static ItemStack setEffects(ItemStack stack, Collection<PotionEffect> effects) {
		if (effects.isEmpty()) {
			return stack;
		} else {
			NBTTagCompound nbttagcompound = Objects.firstNonNull(stack.getTagCompound(), new NBTTagCompound());
			NBTTagList nbttaglist = new NBTTagList();

			for (PotionEffect potioneffect : effects) {
				nbttaglist.appendTag(potioneffect.writeCustomPotionEffectToNBT(new NBTTagCompound()));
			}

			nbttagcompound.setTag("CustomPotionEffects", nbttaglist);
			stack.setTagCompound(nbttagcompound);
			return stack;
		}
	}
}
