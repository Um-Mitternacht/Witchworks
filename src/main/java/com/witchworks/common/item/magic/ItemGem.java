package com.witchworks.common.item.magic;

import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.block.natural.BlockGemOre;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * This class was created by <Arekkuusu> on 28/06/2017.
 * It's distributed as part of Solar Epiphany under
 * the MIT license.
 */
public class ItemGem extends ItemMod {

	public ItemGem() {
		super(LibItemName.GEM);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + BlockGemOre.Gem.values()[stack.getMetadata()].getName();
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
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
	public void registerModel() {
		ModelHandler.registerModel(this, BlockGemOre.Gem.class);
	}
}
