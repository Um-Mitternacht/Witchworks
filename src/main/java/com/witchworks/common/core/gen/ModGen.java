package com.witchworks.common.core.gen;

import com.witchworks.common.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.witchworks.common.core.handler.ConfigHandler.WORLD_GEN;

/**
 * This class was created by Arekkuusu on 21/05/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public final class ModGen {

	private ModGen() {
	}

	public static void init() {
		//World generation
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.SILVER_ORE, WORLD_GEN.silver_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.silver_min_vein, WORLD_GEN.silver_max_vein)
				.setHeightRange(WORLD_GEN.silver_min_height, WORLD_GEN.silver_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.MOLDAVITE_ORE, WORLD_GEN.moldavite_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.moldavite_min_vein, WORLD_GEN.moldavite_max_vein)
				.setHeightRange(WORLD_GEN.moldavite_min_height, WORLD_GEN.moldavite_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.BLOODSTONE_ORE, WORLD_GEN.bloodStone_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.bloodStone_min_vein, WORLD_GEN.bloodStone_max_vein)
				.setHeightRange(WORLD_GEN.bloodStone_min_height, WORLD_GEN.bloodStone_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.TOURMALINE_ORE, WORLD_GEN.tourmaline_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.tourmaline_min_vein, WORLD_GEN.tourmaline_max_vein)
				.setHeightRange(WORLD_GEN.tourmaline_min_height, WORLD_GEN.tourmaline_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.MALACHITE_ORE, WORLD_GEN.malachite_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.malachite_min_vein, WORLD_GEN.malachite_max_vein)
				.setHeightRange(WORLD_GEN.malachite_min_height, WORLD_GEN.malachite_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.TIGERS_EYE_ORE, WORLD_GEN.tigersEye_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.tigersEye_min_vein, WORLD_GEN.tigersEye_max_vein)
				.setHeightRange(WORLD_GEN.tigersEye_min_height, WORLD_GEN.tigersEye_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.SERPENTINE_ORE, WORLD_GEN.serpentine_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.serpentine_min_vein, WORLD_GEN.serpentine_max_vein)
				.setHeightRange(WORLD_GEN.serpentine_min_height, WORLD_GEN.serpentine_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.NUUMMITE_ORE, WORLD_GEN.nuummite_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.nuummite_min_vein, WORLD_GEN.nuummite_max_vein)
				.setHeightRange(WORLD_GEN.nuummite_min_height, WORLD_GEN.nuummite_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.GARNET_ORE, WORLD_GEN.garnet_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.garnet_min_vein, WORLD_GEN.garnet_max_vein)
				.setHeightRange(WORLD_GEN.garnet_min_height, WORLD_GEN.garnet_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.PETOSKEY_ORE, WORLD_GEN.petoskey_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.petoskey_min_vein, WORLD_GEN.petoskey_max_vein)
				.setHeightRange(WORLD_GEN.petoskey_min_height, WORLD_GEN.petoskey_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.JASPER_ORE, WORLD_GEN.jasper_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.jasper_min_vein, WORLD_GEN.jasper_max_vein)
				.setHeightRange(WORLD_GEN.jasper_min_height, WORLD_GEN.jasper_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.SALT_ORE, WORLD_GEN.salt_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.salt_min_vein, WORLD_GEN.salt_max_vein)
				.setHeightRange(WORLD_GEN.salt_min_height, WORLD_GEN.salt_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.QUARTZ_ORE, WORLD_GEN.quartz_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.quartz_min_vein, WORLD_GEN.quartz_max_vein)
				.setHeightRange(WORLD_GEN.quartz_min_height, WORLD_GEN.quartz_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.AMETHYST_ORE, WORLD_GEN.amethyst_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.amethyst_min_vein, WORLD_GEN.amethyst_max_vein)
				.setHeightRange(WORLD_GEN.amethyst_min_height, WORLD_GEN.amethyst_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.ALEXANDRITE_ORE, WORLD_GEN.alexandrite_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.alexandrite_min_vein, WORLD_GEN.alexandrite_max_vein)
				.setHeightRange(WORLD_GEN.alexandrite_min_height, WORLD_GEN.alexandrite_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.COQUINA, WORLD_GEN.coquina_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.coquina_min_vein, WORLD_GEN.coquina_max_vein)
				.setHeightRange(WORLD_GEN.coquina_min_height, WORLD_GEN.coquina_max_height)
				.setDimension(0)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.CHALK, WORLD_GEN.chalk_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(WORLD_GEN.chalk_min_vein, WORLD_GEN.chalk_max_vein)
				.setHeightRange(WORLD_GEN.chalk_min_height, WORLD_GEN.chalk_max_height)
				.setDimension(0)
				.build(), 0);
	}
}
