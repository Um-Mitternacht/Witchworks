package com.witchworks.common.item.magic.brew;

import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.BrewUtils;
import com.witchworks.api.brew.IBrew;
import com.witchworks.api.helper.RomanNumber;
import com.witchworks.api.item.NBTHelper;
import com.witchworks.common.item.ItemMod;
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
				IBrew brew = effect.getBrew();
				int amplifier = effect.getAmplifier();

				String string = TextFormatting.ITALIC + " - " + I18n.format(brew.getName() + ".tooltip") + " " +
						((amplifier <= 0) ? "" : (RomanNumber.getRoman(effect.getAmplifier()))) + " " +
						"(" + StringUtils.ticksToElapsedTime(effect.getDuration()) + ")";

				tooltip.add(TextFormatting.DARK_AQUA + string);
			}
			if (brewsFromStack.isEmpty()) {
				tooltip.add(TextFormatting.DARK_GRAY + "" + TextFormatting.ITALIC + "---");
			}

			tooltip.add(TextFormatting.DARK_GRAY + "" + TextFormatting.ITALIC + I18n.format("tooltip.potion.data"));
			BrewUtils.addPotionTooltip(stack, tooltip, 1.0F);
		} else {
			tooltip.add(TextFormatting.DARK_GRAY + "" + TextFormatting.ITALIC + I18n.format("tooltip.shift_for_info"));
		}
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (NBTHelper.hasTag(stack, BrewUtils.BREW_NAME)) {
			TextComponentTranslation text = new TextComponentTranslation(NBTHelper.getString(stack, BrewUtils.BREW_NAME));
			return text.getFormattedText();
		}
		return super.getItemStackDisplayName(stack);
	}
}
