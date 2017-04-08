package com.wiccanarts.common.item;

import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

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
		final EntityPlayer player = entity instanceof EntityPlayer ? (EntityPlayer) entity : null;

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
