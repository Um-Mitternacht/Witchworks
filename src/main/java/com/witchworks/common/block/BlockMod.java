/**
 * This class was created by <ArekkuusuJerii>. It's distributed as
 * part of the Grimoire Of Alice Mod. Get the Source Code in github:
 * https://github.com/ArekkuusuJerii/Grimore-Of-Alice
 * <p>
 * Grimore Of Alice is Open Source and distributed under the
 * Grimore Of Alice license: https://github.com/ArekkuusuJerii/Grimore-Of-Alice/blob/master/LICENSE.md
 */
package com.witchworks.common.block;

import com.witchworks.api.item.IModelRegister;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class BlockMod extends Block implements IModelRegister {

	public BlockMod(String id, Material material) {
		super(material);
		setUnlocalizedName(id);
		setDefaultState(defaultState());
		setRegistryName(LibMod.MOD_ID, id);
		setCreativeTab(WitchWorksCreativeTabs.BLOCKS_CREATIVE_TAB);
	}

	public Block setSound(SoundType type) {
		return super.setSoundType(type);
	}

	protected IBlockState defaultState() {
		return blockState.getBaseState();
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels() {
		ModelHandler.registerBlock(this);
	}
}
