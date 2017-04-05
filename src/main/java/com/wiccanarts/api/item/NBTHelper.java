package com.wiccanarts.api.item;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.UUID;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class NBTHelper {

	private NBTHelper () {
	}

	public static void setByte (ItemStack stack, String tag, byte i) {
		fixNBT (stack).setByte (tag, i);
	}

	public static void setInteger (ItemStack stack, String tag, int i) {
		fixNBT (stack).setInteger (tag, i);
	}

	public static void setFloat (ItemStack stack, String tag, float i) {
		fixNBT (stack).setFloat (tag, i);
	}

	public static void setBoolean (ItemStack stack, String tag, boolean i) {
		fixNBT (stack).setBoolean (tag, i);
	}

	public static void setUniqueID (ItemStack stack, String tag, UUID i) {
		fixNBT (stack).setUniqueId (tag, i);
	}

	public static byte getByte (ItemStack stack, String tag) {
		return fixNBT (stack).getByte (tag);
	}

	public static int getInteger (ItemStack stack, String tag) {
		return fixNBT (stack).getInteger (tag);
	}

	public static float getFloat (ItemStack stack, String tag) {
		return fixNBT (stack).getFloat (tag);
	}

	public static boolean getBoolean (ItemStack stack, String tag) {
		return fixNBT (stack).getBoolean (tag);
	}

	public static UUID getUniqueID (ItemStack stack, String tag) {
		return fixNBT (stack).getUniqueId (tag);
	}

	private static NBTTagCompound fixNBT (ItemStack stack) {
		NBTTagCompound tagCompound = stack.getTagCompound ();
		if (tagCompound == null) {
			tagCompound = new NBTTagCompound ();
			stack.setTagCompound (tagCompound);
		}
		return tagCompound;
	}
}
