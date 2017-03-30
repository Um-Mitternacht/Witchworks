package com.wiccanarts.common.block.magic;


import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.wiccanarts.common.block.BlockMod;
import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.item.ModItems;
import com.wiccanarts.common.lib.LibBlockName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by BerciTheBeast on 27.3.2017.
 */
public class BlockSaltBarrier extends BlockMod {
	public static final PropertyEnum<BlockSaltBarrier.EnumAttachPosition> NORTH = PropertyEnum.<BlockSaltBarrier.EnumAttachPosition>create("north", BlockSaltBarrier.EnumAttachPosition.class);
	public static final PropertyEnum<BlockSaltBarrier.EnumAttachPosition> EAST = PropertyEnum.<BlockSaltBarrier.EnumAttachPosition>create("east", BlockSaltBarrier.EnumAttachPosition.class);
	public static final PropertyEnum<BlockSaltBarrier.EnumAttachPosition> SOUTH = PropertyEnum.<BlockSaltBarrier.EnumAttachPosition>create("south", BlockSaltBarrier.EnumAttachPosition.class);
	public static final PropertyEnum<BlockSaltBarrier.EnumAttachPosition> WEST = PropertyEnum.<BlockSaltBarrier.EnumAttachPosition>create("west", BlockSaltBarrier.EnumAttachPosition.class);
	public static final PropertyInteger POWER = PropertyInteger.create("power", 0, 15);
	protected static final AxisAlignedBB[] SALT_BARRIER_AABB = new AxisAlignedBB[]{new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 0.8125D), new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 0.8125D), new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 1.0D), new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 0.0625D, 0.8125D), new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 0.0625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.8125D, 0.0625D, 0.8125D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.8125D, 0.0625D, 1.0D), new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 1.0D, 0.0625D, 0.8125D), new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 1.0D, 0.0625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 1.0D, 0.0625D, 0.8125D), new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 1.0D, 0.0625D, 1.0D), new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 1.0D, 0.0625D, 0.8125D), new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 0.8125D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D)};
	private final Set<BlockPos> blocksNeedingUpdate = Sets.<BlockPos>newHashSet();
	private boolean canProvidePower = true;

	public BlockSaltBarrier() {
		super(LibBlockName.SALT_BARRIER, Material.CIRCUITS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, BlockSaltBarrier.EnumAttachPosition.NONE).withProperty(EAST, BlockSaltBarrier.EnumAttachPosition.NONE).withProperty(SOUTH, BlockSaltBarrier.EnumAttachPosition.NONE).withProperty(WEST, BlockSaltBarrier.EnumAttachPosition.NONE));
	}

	private static int getAABBIndex(IBlockState state) {
		int i = 0;
		boolean flag = state.getValue(NORTH) != BlockSaltBarrier.EnumAttachPosition.NONE;
		boolean flag1 = state.getValue(EAST) != BlockSaltBarrier.EnumAttachPosition.NONE;
		boolean flag2 = state.getValue(SOUTH) != BlockSaltBarrier.EnumAttachPosition.NONE;
		boolean flag3 = state.getValue(WEST) != BlockSaltBarrier.EnumAttachPosition.NONE;

		if (flag || flag2 && !flag && !flag1 && !flag3) {
			i |= 1 << EnumFacing.NORTH.getHorizontalIndex();
		}

		if (flag1 || flag3 && !flag && !flag1 && !flag2) {
			i |= 1 << EnumFacing.EAST.getHorizontalIndex();
		}

		if (flag2 || flag && !flag1 && !flag2 && !flag3) {
			i |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
		}

		if (flag3 || flag1 && !flag && !flag2 && !flag3) {
			i |= 1 << EnumFacing.WEST.getHorizontalIndex();
		}

		return i;
	}

	protected static boolean canConnectUpwardsTo(IBlockAccess worldIn, BlockPos pos) {
		return canConnectTo(worldIn.getBlockState(pos), null, worldIn, pos);
	}

	protected static boolean canConnectTo(IBlockState blockState, @Nullable EnumFacing side, IBlockAccess world, BlockPos pos) {
		Block block = blockState.getBlock();

		if (block == ModBlocks.SALT_BARRIER) {
			return true;
		} else {
			return false;
		}
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SALT_BARRIER_AABB[getAABBIndex(state.getActualState(source, pos))];
	}

	/**
	 * Get the actual Block state of this Block at the given position. This applies properties not visible in the
	 * metadata, such as fence connections.
	 */
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		state = state.withProperty(WEST, this.getAttachPosition(worldIn, pos, EnumFacing.WEST));
		state = state.withProperty(EAST, this.getAttachPosition(worldIn, pos, EnumFacing.EAST));
		state = state.withProperty(NORTH, this.getAttachPosition(worldIn, pos, EnumFacing.NORTH));
		state = state.withProperty(SOUTH, this.getAttachPosition(worldIn, pos, EnumFacing.SOUTH));
		return state;
	}

	private BlockSaltBarrier.EnumAttachPosition getAttachPosition(IBlockAccess worldIn, BlockPos pos, EnumFacing direction) {
		BlockPos blockpos = pos.offset(direction);
		IBlockState iblockstate = worldIn.getBlockState(pos.offset(direction));

		if (!canConnectTo(worldIn.getBlockState(blockpos), direction, worldIn, blockpos) && (iblockstate.isNormalCube() || !canConnectUpwardsTo(worldIn, blockpos.down()))) {
			IBlockState iblockstate1 = worldIn.getBlockState(pos.up());

			if (!iblockstate1.isNormalCube()) {
				boolean flag = worldIn.getBlockState(blockpos).isSideSolid(worldIn, blockpos, EnumFacing.UP) || worldIn.getBlockState(blockpos).getBlock() == Blocks.GLOWSTONE;

				if (flag && canConnectUpwardsTo(worldIn, blockpos.up())) {
					if (iblockstate.isBlockNormalCube()) {
						return BlockSaltBarrier.EnumAttachPosition.UP;
					}

					return BlockSaltBarrier.EnumAttachPosition.SIDE;
				}
			}

			return BlockSaltBarrier.EnumAttachPosition.NONE;
		} else {
			return BlockSaltBarrier.EnumAttachPosition.SIDE;
		}
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).isFullyOpaque() || worldIn.getBlockState(pos.down()).getBlock() == Blocks.GLOWSTONE;
	}

	private IBlockState updateSurroundingSalt(World worldIn, BlockPos pos, IBlockState state) {
		List<BlockPos> list = Lists.newArrayList(this.blocksNeedingUpdate);
		this.blocksNeedingUpdate.clear();

		for (BlockPos blockpos : list) {
			worldIn.notifyNeighborsOfStateChange(blockpos, this);
		}

		return state;
	}

	/**
	 * Calls World.notifyNeighborsOfStateChange() for all neighboring blocks, but only if the given block is a redstone
	 * wire.
	 */
	private void notifyBarrierNeighborsOfStateChange(World worldIn, BlockPos pos) {
		if (worldIn.getBlockState(pos).getBlock() == this) {
			worldIn.notifyNeighborsOfStateChange(pos, this);

			for (EnumFacing enumfacing : EnumFacing.values()) {
				worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this);
			}
		}
	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile Entity is set
	 */
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			this.updateSurroundingSalt(worldIn, pos, state);

			for (EnumFacing enumfacing : EnumFacing.Plane.VERTICAL) {
				worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this);
			}

			for (EnumFacing enumfacing1 : EnumFacing.Plane.HORIZONTAL) {
				this.notifyBarrierNeighborsOfStateChange(worldIn, pos.offset(enumfacing1));
			}

			for (EnumFacing enumfacing2 : EnumFacing.Plane.HORIZONTAL) {
				BlockPos blockpos = pos.offset(enumfacing2);

				if (worldIn.getBlockState(blockpos).isNormalCube()) {
					this.notifyBarrierNeighborsOfStateChange(worldIn, blockpos.up());
				} else {
					this.notifyBarrierNeighborsOfStateChange(worldIn, blockpos.down());
				}
			}
		}
	}

	/**
	 * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
	 */
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);

		if (!worldIn.isRemote) {
			for (EnumFacing enumfacing : EnumFacing.values()) {
				worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this);
			}

			this.updateSurroundingSalt(worldIn, pos, state);

			for (EnumFacing enumfacing1 : EnumFacing.Plane.HORIZONTAL) {
				this.notifyBarrierNeighborsOfStateChange(worldIn, pos.offset(enumfacing1));
			}

			for (EnumFacing enumfacing2 : EnumFacing.Plane.HORIZONTAL) {
				BlockPos blockpos = pos.offset(enumfacing2);

				if (worldIn.getBlockState(blockpos).isNormalCube()) {
					this.notifyBarrierNeighborsOfStateChange(worldIn, blockpos.up());
				} else {
					this.notifyBarrierNeighborsOfStateChange(worldIn, blockpos.down());
				}
			}
		}
	}

	/**
	 * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
	 * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
	 * block, etc.
	 */
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
		if (!worldIn.isRemote) {
			if (this.canPlaceBlockAt(worldIn, pos)) {
				this.updateSurroundingSalt(worldIn, pos, state);
			} else {
				this.dropBlockAsItem(worldIn, pos, state, 0);
				worldIn.setBlockToAir(pos);
			}
		}
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.SALT;
	}

	/**
	 * Can this block provide power. Only wire currently seems to have this change based on its state.
	 */


	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		double d0 = (double) pos.getX() + 0.5D + ((double) rand.nextFloat() - 0.5D) * 0.2D;
		double d1 = (double) ((float) pos.getY() + 0.0625F);
		double d2 = (double) pos.getZ() + 0.5D + ((double) rand.nextFloat() - 0.5D) * 0.2D;
		float f = (float) 3 / 15.0F;
		float f1 = f * 0.6F + 0.4F;
		float f2 = Math.max(0.0F, f * f * 0.7F - 0.5F);
		float f3 = Math.max(0.0F, f * f * 0.6F - 0.7F);
		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, d0, d1, d2, (double) f1, (double) f2, (double) f3, new int[0]);

	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ModItems.SALT);
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState();
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
			case CLOCKWISE_180:
				return state.withProperty(NORTH, state.getValue(SOUTH)).withProperty(EAST, state.getValue(WEST)).withProperty(SOUTH, state.getValue(NORTH)).withProperty(WEST, state.getValue(EAST));
			case COUNTERCLOCKWISE_90:
				return state.withProperty(NORTH, state.getValue(EAST)).withProperty(EAST, state.getValue(SOUTH)).withProperty(SOUTH, state.getValue(WEST)).withProperty(WEST, state.getValue(NORTH));
			case CLOCKWISE_90:
				return state.withProperty(NORTH, state.getValue(WEST)).withProperty(EAST, state.getValue(NORTH)).withProperty(SOUTH, state.getValue(EAST)).withProperty(WEST, state.getValue(SOUTH));
			default:
				return state;
		}
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
	 * blockstate.
	 */
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		switch (mirrorIn) {
			case LEFT_RIGHT:
				return state.withProperty(NORTH, state.getValue(SOUTH)).withProperty(SOUTH, state.getValue(NORTH));
			case FRONT_BACK:
				return state.withProperty(EAST, state.getValue(WEST)).withProperty(WEST, state.getValue(EAST));
			default:
				return super.withMirror(state, mirrorIn);
		}
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{NORTH, EAST, SOUTH, WEST});
	}

	static enum EnumAttachPosition implements IStringSerializable {
		UP("up"),
		SIDE("side"),
		NONE("none");

		private final String name;

		private EnumAttachPosition(String name) {
			this.name = name;
		}

		public String toString() {
			return this.getName();
		}

		public String getName() {
			return this.name;
		}
	}
}
