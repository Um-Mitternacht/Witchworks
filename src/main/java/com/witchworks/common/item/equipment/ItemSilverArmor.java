package com.witchworks.common.item.equipment;

import com.witchworks.api.item.IModelRegister;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.core.WitchWorksCreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by BerciTheBeast on 11.4.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemSilverArmor extends ItemArmor implements IModelRegister {

	public ItemSilverArmor(String id, ArmorMaterial materialIn, int renderIndex, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndex, equipmentSlotIn);
		setRegistryName(id);
		setUnlocalizedName(id);
		setCreativeTab(WitchWorksCreativeTabs.ITEMS_CREATIVE_TAB);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public void registerModels() {
		ModelHandler.registerItem(this);
	}

}
