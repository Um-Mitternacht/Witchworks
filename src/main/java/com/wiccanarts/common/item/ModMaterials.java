package com.wiccanarts.common.item;

import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

/**
 * This class was created by Arekkuusu on 04/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ModMaterials {

	public static final Item.ToolMaterial SILVER = EnumHelper.addToolMaterial (LibItemName.SILVER, 2, 222, 3.5F, 2.5F, 18);

	private ModMaterials () {
	}
}
