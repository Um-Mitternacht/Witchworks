package com.wiccanarts.common.item.tool;

import com.wiccanarts.common.core.WiccanArtsCreativeTabs;
import net.minecraft.item.ItemAxe;

/**
 * Created by BerciTheBeast on 27.3.2017.
 */
public class ItemSilverAxe extends ItemAxe {
	public ItemSilverAxe(String id, ToolMaterial material) {
		super(MaterialSilver.SILVER);
		setRegistryName(id);
		setUnlocalizedName(id);
		setCreativeTab(WiccanArtsCreativeTabs.ITEMS_CREATIVE_TAB);
	}
}
