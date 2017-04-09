package com.wiccanarts.common.item.tool;

import com.wiccanarts.api.item.IModelRegister;
import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.common.core.WiccanArtsCreativeTabs;
import com.wiccanarts.common.item.ItemMod;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemGlassJar extends ItemMod implements IModelRegister {

	public ItemGlassJar() {
		super(LibItemName.GLASS_JAR);
		setRegistryName(LibItemName.GLASS_JAR);
		setUnlocalizedName(LibItemName.GLASS_JAR);
		setCreativeTab(WiccanArtsCreativeTabs.ITEMS_CREATIVE_TAB);
		setContainerItem(this);
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void registerModels() {
		ModelHandler.registerItem(this);
	}
}
