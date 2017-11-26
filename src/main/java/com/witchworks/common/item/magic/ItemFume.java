package com.witchworks.common.item.magic;

import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.lib.LibItemName;

/**
 * Created by Joseph on 11/26/2017.
 */
public class ItemFume extends ItemMod {

	public ItemFume() {
		super(LibItemName.FUME);
		setMaxDamage(0);
		setCreativeTab(WitchWorksCreativeTabs.ITEMS_CREATIVE_TAB);
	}

}
