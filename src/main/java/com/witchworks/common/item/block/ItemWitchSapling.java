package com.witchworks.common.item.block;

import com.witchworks.api.helper.IModelRegister;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.block.natural.tree.BlockWitchSapling;
import com.witchworks.common.core.WitchWorksCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

/**
 * This class was created by <Arekkuusu> on 27/06/2017.
 * It's distributed as part of Solar Epiphany under
 * the MIT license.
 */
public class ItemWitchSapling extends ItemBlock implements IModelRegister {

	@Nonnull
	public ItemWitchSapling(Block block) {
		super(block);
		setRegistryName(block.getRegistryName());
		setHasSubtypes(true);
		setMaxDamage(0);
		this.setCreativeTab(WitchWorksCreativeTabs.PLANTS_CREATIVE_TAB);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + BlockWitchSapling.sapling.values()[stack.getMetadata()].getName();
	}

	@Override
	public void getSubItems(@Nonnull CreativeTabs tab, @Nonnull NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < BlockWitchSapling.sapling.values().length; ++i) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}


	@Override
	public void registerModel() {
		BlockWitchSapling.sapling[] values = BlockWitchSapling.sapling.values();
		for (int i = 0; i < values.length; i++) {
			BlockWitchSapling.sapling sapling = values[i];
			ModelHandler.registerForgeModel(this, i, "sapling=" + sapling.getName());
		}
	}
}
