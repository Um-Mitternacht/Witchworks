package com.witchworks.common.item.food.seed;

import com.witchworks.common.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by Joseph on 5/29/2017.
 */
public class SeedDropRegistry {

	public static void init() {

		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_MANDRAKE), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_BELLADONNA), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_ACONITUM), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_THISTLE), 5);
	}
}
