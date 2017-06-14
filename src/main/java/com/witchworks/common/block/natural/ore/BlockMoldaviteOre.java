package com.witchworks.common.block.natural.ore;

import com.witchworks.common.block.BlockMod;
import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.item.ModItems;
import com.witchworks.common.lib.LibBlockName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */

public class BlockMoldaviteOre extends BlockMod {

	public BlockMoldaviteOre() {
		super(LibBlockName.MOLDAVITE_ORE, Material.ROCK);
		setSound(SoundType.STONE);
		setResistance(3F);
		setHardness(3F);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.MOLDAVITE;
	}

	public int quantityDroppedWithBonus(int fortune, Random random) {
		return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}

	public int quantityDropped(Random random) {
		return 2 + random.nextInt(2);
	}

	@Override
	public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
		if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this)) {
			return 1 + RANDOM.nextInt(5);
		}
		return 0;
	}

	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
		super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
	}

	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(ModBlocks.MOLDAVITE_ORE);
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(ModBlocks.MOLDAVITE_ORE), 1, this.damageDropped(state));
	}
}
