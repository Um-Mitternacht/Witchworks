package com.wiccanarts.common.block.tools;

import com.wiccanarts.api.item.IModelRegister;
import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.common.block.BlockMod;
import com.wiccanarts.common.lib.LibBlockName;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Joseph on 3/4/2017.
 */
public class BlockKettle extends BlockMod implements IModelRegister {
	//public static final int FIRE_TICKS = 20 * 5;//for the "5 seconds above fire in order to heat up" thing. can be increased.

	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(1 * 0.0625, 0, 1 * 0.0625, 15 * 0.0625, 11 * 0.0625, 15 * 0.0625);

	public BlockKettle() {
		super(LibBlockName.KETTLE, Material.IRON);
		setHardness(5.0F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		ModelHandler.registerBlock(this);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return this.BOUNDING_BOX;
	}
}
