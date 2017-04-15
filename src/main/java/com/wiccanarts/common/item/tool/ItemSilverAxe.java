package com.wiccanarts.common.item.tool;

import com.wiccanarts.api.item.IModelRegister;
import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.common.core.WiccanArtsCreativeTabs;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

	@SideOnly (Side.CLIENT)
	@Override
	public void registerModels() {
		ModelHandler.registerItem(this);
	}
}
