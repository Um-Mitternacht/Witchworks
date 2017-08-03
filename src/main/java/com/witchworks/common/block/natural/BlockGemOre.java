package com.witchworks.common.block.natural;

import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.block.BlockMod;
import com.witchworks.common.lib.LibBlockName;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

/**
 * This class was created by <Arekkuusu> on 27/06/2017.
 * It's distributed as part of Solar Epiphany under
 * the MIT license.
 */
public class BlockGemOre extends BlockMod {

	public static final PropertyEnum<Gem> GEM = PropertyEnum.create("gem", Gem.class);

	public BlockGemOre() {
		super(LibBlockName.GEM_ORE, Material.ROCK);
		setHardness(2.0F);
	}

	@SuppressWarnings("deprecation")
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(GEM, Gem.values()[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(GEM).ordinal();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(GEM).ordinal();
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		items.add(new ItemStack(this));
		items.add(new ItemStack(this, 1, 1));
		items.add(new ItemStack(this, 1, 2));
		items.add(new ItemStack(this, 1, 3));
		items.add(new ItemStack(this, 1, 4));
		items.add(new ItemStack(this, 1, 5));
		items.add(new ItemStack(this, 1, 6));
		items.add(new ItemStack(this, 1, 7));
		items.add(new ItemStack(this, 1, 8));
		items.add(new ItemStack(this, 1, 9));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, GEM);
	}

	@Override
	public void registerModel() {
		Gem[] values = Gem.values();
		for (int i = 0; i < values.length; i++) {
			Gem gem = values[i];
			ModelHandler.registerForgeModel(this, i, "gem=" + gem.getName());
		}
	}

	public enum Gem implements IStringSerializable {
		GARNET,
		MOLDAVITE,
		NUUMMITE,
		TIGERS_EYE,
		TOURMALINE,
		BLOODSTONE,
		JASPER,
		MALACHITE,
		AMETHYST,
		ALEXANDRITE;

		@Override
		public String getName() {
			return name().toLowerCase();
		}
	}
}
