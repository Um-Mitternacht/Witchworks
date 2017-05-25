package com.witchworks.common.item.block;

import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemSalt extends ItemMod {

	public ItemSalt() {
		super(LibItemName.SALT);
	}

	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		{
			boolean flag = worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos);
			BlockPos blockpos = flag ? pos : pos.offset(facing);
			ItemStack itemstack = player.getHeldItem(hand);

			if (player.canPlayerEdit(blockpos, facing, itemstack) && worldIn.mayPlace(worldIn.getBlockState(blockpos).getBlock(), blockpos, false, facing, (Entity) null) && ModBlocks.SALT_BARRIER.canPlaceBlockAt(worldIn, blockpos)) {
				itemstack.shrink(1);
				worldIn.setBlockState(blockpos, ModBlocks.SALT_BARRIER.getDefaultState());
				return EnumActionResult.SUCCESS;
			}
			else
			{
				return EnumActionResult.FAIL;
			}
		}
	}
}
