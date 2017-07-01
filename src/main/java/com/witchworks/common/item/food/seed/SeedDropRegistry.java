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
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_mandrake), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_belladonna), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_aconitum), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_thistle), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_mint), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_ginger), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_wormwood), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_lavender), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_asphodel), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_tulsi), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_kenaf), 5);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.seed_garlic), 5);
	}
}
