package com.witchworks.common.item;

import com.witchworks.common.lib.LibItemName;
import com.witchworks.common.lib.LibMod;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

/**
 * This class was created by Arekkuusu on 04/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class ModMaterials {

	public static final Item.ToolMaterial TOOL_SILVER = EnumHelper.addToolMaterial(LibItemName.SILVER, 1, 275, 3.5F, 2.5F, 24);
	public static final ItemArmor.ArmorMaterial ARMOR_SILVER = EnumHelper.addArmorMaterial(LibItemName.SILVER, LibMod.MOD_ID + ":" + LibItemName.SILVER, 18, new int[] {2, 9, 4, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.5F);

	private ModMaterials() {
	}
}
