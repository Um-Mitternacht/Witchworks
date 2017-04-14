package com.wiccanarts.common.block.tools;

import com.wiccanarts.api.item.IModelRegister;
import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.common.block.BlockMod;
import com.wiccanarts.common.lib.LibBlockName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraft.block.BlockHorizontal.FACING;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BlockAltar extends BlockMod implements IModelRegister {

	public BlockAltar() {
		super(LibBlockName.ALTAR, Material.ROCK);
		setSound(SoundType.STONE);
		setResistance(3F);
		setHardness(3F);
	}

	@SuppressWarnings ("deprecation")
	@Override
	public IBlockState getStateFromMeta(int meta) {
		final EnumFacing facing = EnumFacing.getHorizontal(meta);
		return getDefaultState().withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		final EnumFacing facing = state.getValue(FACING);
		return facing.getHorizontalIndex();
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, ItemStack stack) {
		final EnumFacing enumfacing = EnumFacing.fromAngle(placer.rotationYaw);
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}

	@SuppressWarnings ("deprecation")
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@SuppressWarnings ("deprecation")
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels() {
		ModelHandler.registerBlock(this);
	}
}
