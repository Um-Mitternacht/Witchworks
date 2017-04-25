package com.witchworks.common.item.magic.brew;

import com.witchworks.api.item.NBTHelper;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.potions.BrewUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * This class was created by Arekkuusu on 22/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemBrew extends ItemMod {

	public ItemBrew(String id) {
		super(id);
		setMaxStackSize(1);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if (BrewUtils.isBrew(stack)) {
			BrewUtils.addBrewDescription(tooltip, stack);
		} else {
			PotionUtils.addPotionTooltip(stack, tooltip, 1.0F);
		}
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (BrewUtils.isBrew(stack)) {
			return new TextComponentTranslation(NBTHelper.getString(stack, BrewUtils.NAME_TAG)).getFormattedText();
		}
		return super.getItemStackDisplayName(stack);
	}
}
