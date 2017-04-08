package com.wiccanarts.common.block.tools;

import com.wiccanarts.api.item.IModelRegister;
import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.common.block.BlockMod;
import com.wiccanarts.common.lib.LibBlockName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BlockAltar extends BlockMod implements IModelRegister {

	public BlockAltar () {
		super (LibBlockName.ALTAR, Material.ROCK);
		setSound (SoundType.STONE);
		setResistance (3F);
		setHardness (3F);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels () {
		ModelHandler.registerBlock (this);
	}

	@SuppressWarnings ("deprecation")
	@Override
	public boolean isFullCube (IBlockState state) {
		return false;
	}

	@SuppressWarnings ("deprecation")
	@Override
	public boolean isOpaqueCube (IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer () {
		return BlockRenderLayer.SOLID;
	}
}

