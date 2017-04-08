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
public class BlockApiary extends BlockMod implements IModelRegister {

	public BlockApiary () {
		super (LibBlockName.APIARY, Material.WOOD);
		setSound (SoundType.WOOD);
		setResistance (2F);
		setHardness (2F);
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
