package com.witchworks.common.block.magic;

import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.block.BlockMod;
import com.witchworks.common.block.BlockModSlab;
import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.lib.LibBlockName;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class BlockFakeIceSlab extends BlockModSlab {

	@SuppressWarnings("deprecation")
	public BlockFakeIceSlab() {
		super(false, Material.ICE, LibBlockName.FAKE_ICE_SLAB);
		setResistance(2F);
		setHardness(2F);
		slipperiness = 0.98F;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public BlockSlab getFullBlock() {
		return (BlockSlab) ModBlocks.fake_ice_slab_full;
	}

	@Override
	public BlockSlab getSingleBlock() {
		return (BlockSlab) ModBlocks.fake_ice_slab;
	}

	@Override
	public void registerModel() {
		ModelHandler.registerModel(this, 0);
	}
}
