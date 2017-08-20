package com.witchworks.common.block.natural.tree;

import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.block.BlockMod;
import com.witchworks.common.lib.LibBlockName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

import static com.witchworks.common.core.WitchWorksCreativeTabs.BLOCKS_CREATIVE_TAB;
import static com.witchworks.common.core.WitchWorksCreativeTabs.PLANTS_CREATIVE_TAB;

/**
 * This class was created by <Arekkuusu> on 27/06/2017.
 * It's distributed as part of Solar Epiphany under
 * the MIT license.
 */
public class BlockWitchSapling extends BlockMod {

	public static final PropertyEnum<sapling> SAPLING = PropertyEnum.create("sapling", sapling.class);

	public BlockWitchSapling(Block block) {
		super(LibBlockName.WITCH_SAPLING, Material.PLANTS);
		setHardness(1.0F);
		setCreativeTab(PLANTS_CREATIVE_TAB);
	}

	@SuppressWarnings("deprecation")
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(SAPLING, BlockWitchSapling.sapling.values()[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(SAPLING).ordinal();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(SAPLING).ordinal();
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public void getSubBlocks(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> items) {
		{
			for (int i = 0; i < BlockWitchSapling.sapling.values().length; ++i) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, SAPLING);
	}

	@Override
	public void registerModel() {
		BlockWitchSapling.sapling[] values = BlockWitchSapling.sapling.values();
		for (int i = 0; i < values.length; i++) {
			BlockWitchSapling.sapling sapling = values[i];
			ModelHandler.registerForgeModel(this, i, "sapling=" + sapling.getName());
		}
	}

	public enum sapling implements IStringSerializable {
		YEW,
		OLIVE,
		CYPRESS,
		ROWAN,
		HAWTHORN,
		ALDER;

		@Override
		public String getName() {
			return name().toLowerCase();
		}
	}
}