package com.wiccanarts.common.item.tool;

import com.wiccanarts.api.item.*;
import com.wiccanarts.client.handler.*;
import com.wiccanarts.common.core.*;
import com.wiccanarts.common.lib.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.relauncher.*;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemSilverAxe extends ItemAxe implements IModelRegister {

	public ItemSilverAxe(ToolMaterial material) {
		super(material, material.getDamageVsEntity(), material.getEfficiencyOnProperMaterial());
		setRegistryName(LibItemName.SILVER_AXE);
		setUnlocalizedName(LibItemName.SILVER_AXE);
		setCreativeTab(WiccanArtsCreativeTabs.ITEMS_CREATIVE_TAB);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		ModelHandler.registerItem(this);
	}
}
