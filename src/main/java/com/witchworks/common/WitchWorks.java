package com.witchworks.common;

import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.core.achievement.ModAchievements;
import com.witchworks.common.core.capability.energy.CapabilityEnergy;
import com.witchworks.common.core.capability.potion.CapabilityBrewStorage;
import com.witchworks.common.core.command.CommandIncantation;
import com.witchworks.common.core.command.ModCommands;
import com.witchworks.common.core.event.ModEvents;
import com.witchworks.common.core.handler.ModSounds;
import com.witchworks.common.core.net.PacketHandler;
import com.witchworks.common.core.proxy.ISidedProxy;
import com.witchworks.common.entity.ModEntities;
import com.witchworks.common.item.ModItems;
import com.witchworks.common.lib.LibMod;
import com.witchworks.common.potions.ModBrews;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import static net.minecraftforge.fml.common.Mod.EventHandler;
import static net.minecraftforge.fml.common.Mod.Instance;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
@Mod (modid = LibMod.MOD_ID, name = LibMod.MOD_NAME, version = LibMod.MOD_VER, dependencies = LibMod.DEPENDENCIES)
public class WitchWorks {

	@Instance (LibMod.MOD_ID)
	public static WitchWorks instance;
	@SidedProxy (serverSide = LibMod.PROXY_COMMON, clientSide = LibMod.PROXY_CLIENT)
	public static ISidedProxy proxy;

	static {
		FluidRegistry.enableUniversalBucket();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CapabilityEnergy.init();
		CapabilityBrewStorage.init();
		PacketHandler.init();
		ModEvents.preInit();
		ModSounds.preInit();
		ModEntities.preInit();
		ModBrews.init();
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);

		ModItems.initOreDictionary();
		ModItems.init();

		ModBlocks.initOreDictionary();
		ModBlocks.init();

		ModAchievements.init();

		//FIXME: Find out why they wont generate
		/*GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.SILVER_ORE, 4, 7), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.MOLDAVITE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.BLOODSTONE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.TOURMALINE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.MALACHITE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.TIGERS_EYE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.SERPENTINE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.NUUMMITE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.GARNET_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.PETOSKEY_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.JASPER_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.SALT_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.QUARTZ_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.AMETHYST_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.ALEXANDRITE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.COQUINA), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.CHALK), 0);*/
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	@EventHandler
	public void start(FMLServerStartingEvent event) {
		ModCommands.init();
		event.registerServerCommand(new CommandIncantation());
	}
}
