package com.witchworks.common.item.magic;

import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.block.natural.BlockGemOre;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for (int i = 0; i < BlockGemOre.Gem.values().length; i++) {
			subItems.add(new ItemStack(itemIn, 1, i));
		}
	}

	@Override
	public void registerModel() {
		ModelHandler.registerModel(this, BlockGemOre.Gem.class);
	}
}
