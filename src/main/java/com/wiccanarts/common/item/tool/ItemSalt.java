package com.wiccanarts.common.item.tool;

import com.wiccanarts.common.block.*;
import com.wiccanarts.common.item.*;
import com.wiccanarts.common.lib.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemSalt extends ItemMod {

	public ItemSalt () {
		super (LibItemName.SALT);
	}

	@Override
	public EnumActionResult onItemUse (ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		boolean flag = worldIn.getBlockState (pos).getBlock ().isReplaceable (worldIn, pos);
		BlockPos blockpos = flag ? pos : pos.offset (facing);

		if (playerIn.canPlayerEdit (blockpos, facing, stack) && worldIn.canBlockBePlaced (worldIn.getBlockState (blockpos).getBlock (), blockpos, false, facing, (Entity) null, stack) && ModBlocks.SALT_BARRIER.canPlaceBlockAt (worldIn, blockpos)) {
			-- stack.stackSize;
			worldIn.setBlockState (blockpos, ModBlocks.SALT_BARRIER.getDefaultState ());
			return EnumActionResult.SUCCESS;
		} else {
			return EnumActionResult.FAIL;
		}
	}
}
