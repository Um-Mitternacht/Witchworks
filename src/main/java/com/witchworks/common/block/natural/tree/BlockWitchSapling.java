package com.witchworks.common.block.natural.tree;

import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.block.BlockMod;
import com.witchworks.common.block.natural.BlockGemOre;
import com.witchworks.common.lib.LibMod;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class BlockWitchSapling extends BlockMod {

	public BlockWitchSapling(String id) {
		super(id, Material.PLANTS);
		setSound(SoundType.PLANT);
		this.setRegistryName(new ResourceLocation(LibMod.MOD_ID));
	}

	@Override
	public void getSubBlocks(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> items) {
		{
			for (int i = 0; i < BlockGemOre.Gem.values().length; ++i) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
}