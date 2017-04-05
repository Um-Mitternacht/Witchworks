package com.wiccanarts.common.item.food;

import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemAconitum extends ItemCrop {

	public ItemAconitum () {
		super (LibItemName.ACONITUM, 2, 0.6F, false);
		addPotion (MobEffects.POISON, MobEffects.NAUSEA);
	}

	@Override
	public EnumRarity getRarity (ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels () {
		ModelHandler.registerItem (this);
	}
}
