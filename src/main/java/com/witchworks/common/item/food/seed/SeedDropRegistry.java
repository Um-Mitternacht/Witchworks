package com.witchworks.common.item.food.seed;

import com.witchworks.common.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

/**
 * This class was created by Joseph on 5/29/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class SeedDropRegistry {

	public static void init() {

		//Todo: Add unique ways of getting some of the seeds (silphium from dungeons and strongholds, white sage from dead bushes)
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_MANDRAKE), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_BELLADONNA), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_ACONITUM), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_THISTLE), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_MINT), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_GINGER), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_WORMWOOD), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_LAVENDER), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_ASPHODEL), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_TULSI), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_KENAF), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.SEED_GARLIC), 5);
	}
}
