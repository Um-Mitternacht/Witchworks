package com.wiccanarts.common.item.food;

import com.wiccanarts.api.item.*;
import com.wiccanarts.client.handler.*;
import net.minecraft.client.resources.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.relauncher.*;

import java.util.*;

/**
 * This class was created by Arekkuusu on 01/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
public class ItemCrop extends ItemModFood implements IModelRegister {

	private static final String DRY = "dry";
	private List<Potion> potions;

	public ItemCrop (String id, int amount, float saturation, boolean isWolfFood) {
		super (id, amount, saturation, isWolfFood);
	}

	protected void addPotion (Potion... potions) {
		this.potions = new ArrayList<> ();
		Collections.addAll (this.potions, potions);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add (TextFormatting.ITALIC + I18n.format ("wiccan.tooltip." + getNameInefficiently (stack) + "_description.name"));
	}

	@Override
	protected void onFoodEaten (ItemStack stack, World worldIn, EntityPlayer player) {
		if (! worldIn.isRemote && potions != null) {
			int modifier = isDry (stack) ? 160 : 80;
			for (Potion effect : potions) {
				player.addPotionEffect (new PotionEffect (effect, modifier, modifier / 80));
			}
		}
	}

	public void setDry (ItemStack stack, boolean isDry) {
		NBTHelper.setBoolean (stack, DRY, isDry);
	}

	public boolean isDry (ItemStack stack) {
		return NBTHelper.getBoolean (stack, DRY);
	}

	public String getNameInefficiently (ItemStack stack) {
		return getUnlocalizedName ().substring (5);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels () {
		ModelHandler.registerItem (this);
	}
}
