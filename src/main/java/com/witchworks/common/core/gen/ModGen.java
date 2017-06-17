package com.witchworks.common.core.gen;

import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.core.handler.ConfigHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class was created by Arekkuusu on 21/05/2017.
 * It's distributed as part of Witch Works under
 * the MIT license.
 */
public final class ModGen {

	private ModGen() {
	}

	public static void init() {
		//World generation
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.SILVER_ORE, ConfigHandler.WORLD_GEN.SILVER.silver_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.SILVER.silver_min_vein, ConfigHandler.WORLD_GEN.SILVER.silver_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.SILVER.silver_min_height, ConfigHandler.WORLD_GEN.SILVER.silver_max_height)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.MOLDAVITE_ORE, ConfigHandler.WORLD_GEN.MOLDAVITE.moldavite_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.MOLDAVITE.moldavite_min_vein, ConfigHandler.WORLD_GEN.MOLDAVITE.moldavite_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.MOLDAVITE.moldavite_min_height, ConfigHandler.WORLD_GEN.MOLDAVITE.moldavite_max_height)
				.setBiomes(BiomeDictionary.Type.FOREST)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.BLOODSTONE_ORE, ConfigHandler.WORLD_GEN.BLOOD_STONE.bloodStone_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.BLOOD_STONE.bloodStone_min_vein, ConfigHandler.WORLD_GEN.BLOOD_STONE.bloodStone_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.BLOOD_STONE.bloodStone_min_height, ConfigHandler.WORLD_GEN.BLOOD_STONE.bloodStone_max_height)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.TOURMALINE_ORE, ConfigHandler.WORLD_GEN.TOURMALINE.tourmaline_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.TOURMALINE.tourmaline_min_vein, ConfigHandler.WORLD_GEN.TOURMALINE.tourmaline_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.TOURMALINE.tourmaline_min_height, ConfigHandler.WORLD_GEN.TOURMALINE.tourmaline_max_height)
				.setBiomes(BiomeDictionary.Type.JUNGLE)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.MALACHITE_ORE, ConfigHandler.WORLD_GEN.MALACHITE.malachite_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.MALACHITE.malachite_min_vein, ConfigHandler.WORLD_GEN.MALACHITE.malachite_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.MALACHITE.malachite_min_height, ConfigHandler.WORLD_GEN.MALACHITE.malachite_max_height)
				.setBiomes(BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.TIGERS_EYE_ORE, ConfigHandler.WORLD_GEN.TIGERS_EYE.tigersEye_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.TIGERS_EYE.tigersEye_min_vein, ConfigHandler.WORLD_GEN.TIGERS_EYE.tigersEye_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.TIGERS_EYE.tigersEye_min_height, ConfigHandler.WORLD_GEN.TIGERS_EYE.tigersEye_max_height)
				.setBiomes(BiomeDictionary.Type.MESA)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.NUUMMITE_ORE, ConfigHandler.WORLD_GEN.NUUMMITE.nuummite_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.NUUMMITE.nuummite_min_vein, ConfigHandler.WORLD_GEN.NUUMMITE.nuummite_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.NUUMMITE.nuummite_min_height, ConfigHandler.WORLD_GEN.NUUMMITE.nuummite_max_height)
				.setBiomes(BiomeDictionary.Type.COLD)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.GARNET_ORE, ConfigHandler.WORLD_GEN.GARNET.garnet_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.GARNET.garnet_min_vein, ConfigHandler.WORLD_GEN.GARNET.garnet_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.GARNET.garnet_min_height, ConfigHandler.WORLD_GEN.GARNET.garnet_max_height)
				.setBiomes(BiomeDictionary.Type.MESA, BiomeDictionary.Type.DRY)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.JASPER_ORE, ConfigHandler.WORLD_GEN.JASPER.jasper_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.JASPER.jasper_min_vein, ConfigHandler.WORLD_GEN.JASPER.jasper_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.JASPER.jasper_min_height, ConfigHandler.WORLD_GEN.JASPER.jasper_max_height)
				.setBiomes(BiomeDictionary.Type.JUNGLE)
				.build(), 0);
		//SALT
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.SALT_ORE, ConfigHandler.WORLD_GEN.SALT.salt_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.SALT.salt_min_vein, ConfigHandler.WORLD_GEN.SALT.salt_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.SALT.salt_min_height, ConfigHandler.WORLD_GEN.SALT.salt_max_height)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.SALT_ORE, ConfigHandler.WORLD_GEN.SALT.salt_gen_chance * 2)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.SALT.salt_min_vein, ConfigHandler.WORLD_GEN.SALT.salt_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.SALT.salt_min_height, ConfigHandler.WORLD_GEN.SALT.salt_max_height)
				.setBiomes(BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS)
				.build(), 0);
		//SALT
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.AMETHYST_ORE, ConfigHandler.WORLD_GEN.AMETHYST.amethyst_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.AMETHYST.amethyst_min_vein, ConfigHandler.WORLD_GEN.AMETHYST.amethyst_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.AMETHYST.amethyst_min_height, ConfigHandler.WORLD_GEN.AMETHYST.amethyst_max_height)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.ALEXANDRITE_ORE, ConfigHandler.WORLD_GEN.ALEXANDRITE.alexandrite_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.ALEXANDRITE.alexandrite_min_vein, ConfigHandler.WORLD_GEN.ALEXANDRITE.alexandrite_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.ALEXANDRITE.alexandrite_min_height, ConfigHandler.WORLD_GEN.ALEXANDRITE.alexandrite_max_height)
				.setBiomes(BiomeDictionary.Type.JUNGLE)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.COQUINA, ConfigHandler.WORLD_GEN.COQUINA.coquina_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.COQUINA.coquina_min_vein, ConfigHandler.WORLD_GEN.COQUINA.coquina_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.COQUINA.coquina_min_height, ConfigHandler.WORLD_GEN.COQUINA.coquina_max_height)
				.setBiomes(BiomeDictionary.Type.BEACH)
				.build(), 0);
		GameRegistry.registerWorldGenerator(WorldGenOre.OreGenBuilder.forOre(ModBlocks.CHALK, ConfigHandler.WORLD_GEN.CHALK.chalk_gen_chance)
				.generateOn(Blocks.STONE)
				.setVeinSize(ConfigHandler.WORLD_GEN.CHALK.chalk_min_vein, ConfigHandler.WORLD_GEN.CHALK.chalk_max_vein)
				.setHeightRange(ConfigHandler.WORLD_GEN.CHALK.chalk_min_height, ConfigHandler.WORLD_GEN.CHALK.chalk_max_height)
				.setBiomes(BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS)
				.build(), 0);
	}
}
