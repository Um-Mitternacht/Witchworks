package com.wiccanarts.common.item;

import com.wiccanarts.common.lib.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemBrewPhial extends ItemMod { //TODO: Make Item texture change color

	public ItemBrewPhial () {
		super (LibItemName.BREW_PHIAL);
	}

	@Override
	public ItemStack onItemUseFinish (ItemStack stack, World world, EntityLivingBase entity) {
		EntityPlayer player = entity instanceof EntityPlayer ? (EntityPlayer) entity : null;

		-- stack.stackSize;

		if (! world.isRemote) {
			for (PotionEffect effect : PotionUtils.getEffectsFromStack (stack)) {
				System.out.println (effect);
				entity.addPotionEffect (effect);
			}
		}

		if (player != null && ! player.capabilities.isCreativeMode) {
			if (stack.stackSize <= 0) {
				return new ItemStack (Items.GLASS_BOTTLE);
			}

			player.inventory.addItemStackToInventory (new ItemStack (Items.GLASS_BOTTLE));
		}
		return stack;
	}

	@Override
	public int getMaxItemUseDuration (ItemStack stack) {
		return 32;
	}

	@Override
	public EnumAction getItemUseAction (ItemStack stack) {
		return EnumAction.DRINK;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick (ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.setActiveHand (hand);
		return new ActionResult<> (EnumActionResult.SUCCESS, itemStackIn);
	}
}
