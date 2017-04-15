package com.wiccanarts.common.item.tool;


import com.wiccanarts.api.item.IModelRegister;
import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.common.core.WiccanArtsCreativeTabs;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemSilverPickaxe extends ItemPickaxe implements IModelRegister {

	public ItemSilverPickaxe(ToolMaterial material) {
		super(material);
		setRegistryName(LibItemName.SILVER_PICKAXE);
		setUnlocalizedName(LibItemName.SILVER_PICKAXE);
		setCreativeTab(WiccanArtsCreativeTabs.ITEMS_CREATIVE_TAB);
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void registerModels() {
		ModelHandler.registerItem(this);
	}
}
