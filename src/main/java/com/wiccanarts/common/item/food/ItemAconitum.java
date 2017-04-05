package com.wiccanarts.common.item.food;

import com.wiccanarts.client.handler.*;
import com.wiccanarts.common.lib.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.relauncher.*;

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
