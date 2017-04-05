package com.wiccanarts.common.item.seed;

import com.wiccanarts.api.item.crop.*;
import com.wiccanarts.common.block.*;
import com.wiccanarts.common.lib.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemKelpSeed extends ItemSeed {

	public ItemKelpSeed() {
		super(LibItemName.SEED_KELP, ModBlocks.CROP_KELP, Crop.KELP.getSoil());
	}

	@Override
	@SuppressWarnings("ConstantConditions")
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);

		if (raytraceresult == null) {
			return new ActionResult<>(EnumActionResult.PASS, itemStackIn);
		} else {
			if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
				BlockPos blockpos = raytraceresult.getBlockPos();

				if (!worldIn.isBlockModifiable(playerIn, blockpos) || !playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemStackIn)) {
					return new ActionResult<>(EnumActionResult.FAIL, itemStackIn);
				}

				BlockPos blockpos1 = blockpos.up();
				IBlockState iblockstate = worldIn.getBlockState(blockpos);

				if (iblockstate.getMaterial() == Material.WATER && iblockstate.getValue(BlockLiquid.LEVEL) == 0 && worldIn.isAirBlock(blockpos1)) {
					// special case for handling block placement with water lilies
					net.minecraftforge.common.util.BlockSnapshot blocksnapshot = net.minecraftforge.common.util.BlockSnapshot.getBlockSnapshot(worldIn, blockpos1);
					worldIn.setBlockState(blockpos1, this.crop.getDefaultState());
					if (net.minecraftforge.event.ForgeEventFactory.onPlayerBlockPlace(playerIn, blocksnapshot, net.minecraft.util.EnumFacing.UP, hand).isCanceled()) {
						blocksnapshot.restore(true, false);
						return new ActionResult<>(EnumActionResult.FAIL, itemStackIn);
					}

					worldIn.setBlockState(blockpos1, this.crop.getDefaultState(), 11);

					if (!playerIn.capabilities.isCreativeMode) {
						--itemStackIn.stackSize;
					}

					worldIn.playSound(playerIn, blockpos, SoundEvents.BLOCK_WATERLILY_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
				}
			}

			return new ActionResult<>(EnumActionResult.FAIL, itemStackIn);
		}
	}

	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return EnumActionResult.FAIL;
	}
}
