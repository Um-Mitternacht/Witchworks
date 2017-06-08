package com.witchworks.common.item.magic.brew;

import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.IBrew;
import com.witchworks.api.helper.RomanNumber;
import com.witchworks.api.item.NBTHelper;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.potions.BrewUtils;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StringUtils;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * This class was created by Arekkuusu on 22/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemBrew extends ItemMod {

	public ItemBrew(String id) {
		super(id);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if (NBTHelper.hasTag(stack, BrewUtils.BREW_DESC)) {
			tooltip.add(TextFormatting.ITALIC + I18n.format(NBTHelper.getString(stack, BrewUtils.BREW_DESC)));
		}
		if (GuiScreen.isShiftKeyDown()) {
			tooltip.add(TextFormatting.DARK_GRAY + "" + TextFormatting.ITALIC + I18n.format("tooltip.brew.data"));
			List<BrewEffect> brewsFromStack = BrewUtils.getBrewsFromStack(stack);
			for (BrewEffect effect : brewsFromStack) {
				if (effect == null) break;
				IBrew brew = effect.getBrew();
				String info = " - " + TextFormatting.ITALIC + I18n.format(brew.getName()).replace(" Brew", "") + " ";
				info += RomanNumber.getRoman(effect.getAmplifier() + 1) + " ";
				info += "(" + StringUtils.ticksToElapsedTime(effect.getDuration()) + ")";
				tooltip.add(TextFormatting.DARK_AQUA + info);
			}
			if (brewsFromStack.isEmpty()) {
				tooltip.add("---");
			} else tooltip.add("");

			BrewUtils.addPotionTooltip(stack, tooltip, 1.0F);
		} else {
			tooltip.add(TextFormatting.DARK_GRAY + "" + TextFormatting.ITALIC + I18n.format("tooltip.shift_for_info"));
		}
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (NBTHelper.hasTag(stack, BrewUtils.BREW_NAME)) {
			return new TextComponentTranslation(NBTHelper.getString(stack, BrewUtils.BREW_NAME)).getFormattedText();
		}
		return super.getItemStackDisplayName(stack);
	}
}
