package com.wiccanarts.common.block.ore;

import com.wiccanarts.common.block.BlockMod;
import com.wiccanarts.common.lib.LibBlockName;
import net.minecraft.block.material.Material;

/**
 * Created by BerciTheBeast on 8.3.2017.
 */
public class oreMoldavite extends BlockMod {
	public oreMoldavite() {
		super(LibBlockName.MOLDAVITE_ORE, Material.ROCK);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(3.3F);
	}
}
