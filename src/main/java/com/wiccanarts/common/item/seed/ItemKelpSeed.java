package com.wiccanarts.common.item.seed;

import com.wiccanarts.api.item.crop.Crop;
import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 02/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemKelpSeed extends ItemSeed {

	public ItemKelpSeed () {
		super (LibItemName.SEED_KELP, ModBlocks.CROP_KELP, Crop.KELP.getSoil ());
	}

	@Override
	@SuppressWarnings ("ConstantConditions")
	public ActionResult<ItemStack> onItemRightClick (ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		final RayTraceResult raytraceresult = this.rayTrace (worldIn, playerIn, true);

		if (raytraceresult == null) {
			return new ActionResult<> (EnumActionResult.PASS, itemStackIn);
		} else {
			if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK) {
				final BlockPos blockpos = raytraceresult.getBlockPos ();

				if (! worldIn.isBlockModifiable (playerIn, blockpos) || ! playerIn.canPlayerEdit (blockpos.offset (raytraceresult.sideHit), raytraceresult.sideHit, itemStackIn)) {
					return new ActionResult<> (EnumActionResult.FAIL, itemStackIn);
				}

				final BlockPos blockpos1 = blockpos.up ();
				final IBlockState iblockstate = worldIn.getBlockState (blockpos);

				if (iblockstate.getMaterial () == Material.WATER && iblockstate.getValue (BlockLiquid.LEVEL) == 0 && worldIn.isAirBlock (blockpos1)) {
					// special case for handling block placement with water lilies
					final net.minecraftforge.common.util.BlockSnapshot blocksnapshot = net.minecraftforge.common.util.BlockSnapshot.getBlockSnapshot (worldIn, blockpos1);
					worldIn.setBlockState (blockpos1, this.crop.getDefaultState ());
					if (net.minecraftforge.event.ForgeEventFactory.onPlayerBlockPlace (playerIn, blocksnapshot, net.minecraft.util.EnumFacing.UP, hand).isCanceled ()) {
						blocksnapshot.restore (true, false);
						return new ActionResult<> (EnumActionResult.FAIL, itemStackIn);
					}

					worldIn.setBlockState (blockpos1, this.crop.getDefaultState (), 11);

					if (! playerIn.capabilities.isCreativeMode) {
						-- itemStackIn.stackSize;
					}

					worldIn.playSound (playerIn, blockpos, SoundEvents.BLOCK_WATERLILY_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					return new ActionResult<> (EnumActionResult.SUCCESS, itemStackIn);
				}
			}

			return new ActionResult<> (EnumActionResult.FAIL, itemStackIn);
		}
	}

	@Override
	public EnumActionResult onItemUse (ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return EnumActionResult.FAIL;
	}
}
