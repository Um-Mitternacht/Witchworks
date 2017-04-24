package com.witchworks.common.item.magic.brew;

import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemBrewLinger extends ItemBrew {

	public ItemBrewLinger() {
		super(LibItemName.BREW_PHIAL_LINGER);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {

		return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
	}
}
