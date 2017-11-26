package com.witchworks.common.item.magic.books;

import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.lib.LibItemName;

/**
 * This class was created by Joseph on 4/22/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemShadowBook extends ItemMod {

	public ItemShadowBook() {
		super(LibItemName.SHADOW_BOOK);
		setMaxDamage(0);
		setCreativeTab(WitchWorksCreativeTabs.ITEMS_CREATIVE_TAB);
	}

	//Todo: Functionality, allow it to store books from this mod.
}

