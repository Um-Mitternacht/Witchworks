package com.witchworks.common.item.magic.tools;

import com.witchworks.api.item.NBTHelper;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.item.ItemStack;

import java.util.UUID;

/**
 * Created by Joseph on 5/15/2017.
 */
public class ItemTaglock extends ItemMod {

	public ItemTaglock() {
		super(LibItemName.TAGLOCK);
	}

	public void getEntityTag(ItemStack stack, UUID uuid) {

		NBTHelper.setUniqueID(stack, "name", uuid);
	}


	public void addInformation() {

	}

	public void setTaggedEntity() {

	}
}
