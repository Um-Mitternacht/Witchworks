package com.wiccanarts.common.block.tools;

import com.wiccanarts.client.fx.ParticleF;
import com.wiccanarts.common.WiccanArts;
import com.wiccanarts.common.block.BlockMod;
import com.wiccanarts.common.block.tile.TileApiary;
import com.wiccanarts.common.lib.LibBlockName;
import com.wiccanarts.common.lib.LibGui;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

import static net.minecraft.block.BlockHorizontal.FACING;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BlockApiary extends BlockMod implements ITileEntityProvider {

	private static final AxisAlignedBB BOX = new AxisAlignedBB(0.12F, 0, 0.12F, 0.88F, 1, 0.88F);

	public BlockApiary() {
		super(LibBlockName.APIARY, Material.WOOD);
		setDefaultState(defaultState().withProperty(FACING, EnumFacing.NORTH));
		setSound(SoundType.WOOD);
		setResistance(2F);
		setHardness(2F);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			final TileEntity tile = worldIn.getTileEntity(pos);
			if (tile == null || !(tile instanceof TileApiary)) return false;

			if (heldItem != null && heldItem.getItem() == Items.NAME_TAG) {
				((TileApiary) tile).setCustomInventoryName(heldItem.getDisplayName());
			} else {
				playerIn.openGui(WiccanArts.instance, LibGui.APIARY, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
		}
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		final TileEntity tile = worldIn.getTileEntity(pos);
		if (tile != null && tile instanceof TileApiary) {
			((TileApiary) tile).dropItems();
		}
		worldIn.removeTileEntity(pos);
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(5) == 0) {
			WiccanArts.proxy.spawnParticle(ParticleF.BEE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0, 0, 0);
		}
	}

	@SuppressWarnings ("deprecation")
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOX;
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
		final EnumFacing enumfacing = EnumFacing.fromAngle(placer.rotationYaw).getOpposite();
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}

	@SuppressWarnings ("deprecation")
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@SuppressWarnings ("deprecation")
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileApiary();
	}
}
