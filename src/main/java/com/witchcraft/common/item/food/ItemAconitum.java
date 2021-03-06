package com.witchcraft.common.item.food;

import com.witchcraft.common.core.WitchcraftCreativeTabs;
import com.witchcraft.common.lib.LibItemName;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Witchcraft under
 * the MIT license.
 */
public class ItemAconitum extends ItemCrop {

	public ItemAconitum() {
		super(LibItemName.ACONITUM, 2, 0.6F, false);
		addPotion(MobEffects.POISON, MobEffects.NAUSEA);
		setCreativeTab(WitchcraftCreativeTabs.PLANTS_CREATIVE_TAB);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}
}
