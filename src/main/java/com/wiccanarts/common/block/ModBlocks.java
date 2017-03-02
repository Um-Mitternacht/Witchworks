package com.wiccanarts.common.block;

import com.wiccanarts.common.block.crop.BlockCrop;
import com.wiccanarts.common.crafting.VanillaCrafting;
import com.wiccanarts.common.lib.LibBlockName;
import com.wiccanarts.common.lib.LibMod;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@ObjectHolder(LibMod.MOD_ID)
public final class ModBlocks {

	@ObjectHolder(LibBlockName.CROP_ACONITUM)
	public static final BlockCrop CROP_ACONITUM = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_ASPHODEL)
	public static final BlockCrop CROP_ASPHODEL = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_BELLADONNA)
	public static final BlockCrop CROP_BELLADONNA = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_GINGER)
	public static final BlockCrop CROP_GINGER = new BlockCrop();
	@ObjectHolder(LibBlockName.CROP_KELP)
	public static final BlockCrop CROP_KELP = new BlockCrop();

	public static void init() {
		VanillaCrafting.blocks();
	}

	public static void initOreDictionary() {
	}
}
