package com.wiccanarts.common.item.seed;

import com.wiccanarts.api.item.*;
import com.wiccanarts.client.handler.*;
import com.wiccanarts.common.core.*;
import net.minecraft.block.*;
import net.minecraft.client.resources.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.relauncher.*;

import java.util.*;

/**
 * This class was created by Arekkuusu on 27/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
public class ItemSeed extends ItemSeeds implements IPlantable, IModelRegister {

	protected final Block crop;
	protected final Block soil;

	public ItemSeed(String id, Block crop, Block soil) {
		super(crop, soil);
		setRegistryName(id);
		setUnlocalizedName(id);
		setCreativeTab(WiccanArtsCreativeTabs.PLANTS_CREATIVE_TAB);
		this.crop = crop;
		this.soil = soil;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.ITALIC + I18n.format("wiccan.tooltip." + getNameInefficiently(stack) + "_description.name"));
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return soil == Blocks.FARMLAND ? EnumPlantType.Crop : EnumPlantType.Water;
	}

	public String getNameInefficiently(ItemStack stack) {
		return getUnlocalizedName().substring(5);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		ModelHandler.registerItem(this);
	}
}
