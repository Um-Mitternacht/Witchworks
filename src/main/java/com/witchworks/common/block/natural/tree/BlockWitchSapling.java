package com.witchworks.common.block.natural.tree;

import com.witchworks.common.block.BlockMod;
import com.witchworks.common.lib.LibMod;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

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
			for (int i = 0; i < TreeTypes.SaplingTypes.values().length; ++i) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}

	public String getUnlocalizedName(ItemStack stack) {
		for (int i = 0; i < TreeTypes.SaplingTypes.values().length; ++i) {
			if (stack.getItemDamage() == i) {
				return this.getUnlocalizedName() + "." + TreeTypes.SaplingTypes.values()[i].getName();
			} else {
				continue;
			}
		}
		return this.getUnlocalizedName() + "." + TreeTypes.SaplingTypes.CYPRESS.getName();
	}
}