package com.witchworks.common;

import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.brew.ModBrews;
import com.witchworks.common.core.capability.brew.CapabilityBrewStorage;
import com.witchworks.common.core.capability.energy.CapabilityEnergy;
import com.witchworks.common.core.command.CommandIncantation;
import com.witchworks.common.core.command.ModCommands;
import com.witchworks.common.core.event.ModEvents;
import com.witchworks.common.core.gen.ModGen;
import com.witchworks.common.core.net.PacketHandler;
import com.witchworks.common.core.proxy.ISidedProxy;
import com.witchworks.common.crafting.cauldron.CauldronCrafting;
import com.witchworks.common.entity.ModEntities;
import com.witchworks.common.item.ModItems;
import com.witchworks.common.item.food.seed.SeedDropRegistry;
import com.witchworks.common.lib.LibMod;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.witchworks.common.lib.LibMod.MOD_NAME;
import static net.minecraftforge.fml.common.Mod.EventHandler;
import static net.minecraftforge.fml.common.Mod.Instance;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
@Mod(modid = LibMod.MOD_ID, name = MOD_NAME, version = LibMod.MOD_VER, dependencies = LibMod.DEPENDENCIES, acceptedMinecraftVersions = "[1.12,1.13]", certificateFingerprint = "@FINGERPRINT@")
public class WitchWorks {

	public static final Logger logger = LogManager.getLogger(MOD_NAME);
	@SidedProxy(serverSide = LibMod.PROXY_COMMON, clientSide = LibMod.PROXY_CLIENT)
	public static ISidedProxy proxy;
	@Instance(LibMod.MOD_ID)
	public static WitchWorks instance;

	static {
		FluidRegistry.enableUniversalBucket();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CapabilityEnergy.init();
		CapabilityBrewStorage.init();
		PacketHandler.init();
		ModEvents.init();
		ModEntities.init();
		ModBrews.init();
		proxy.preInit(event);

		logger.info("Remember when I told you how my");
		logger.info("Kin is different in some ways?");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);

		ModItems.init();
		ModBlocks.init();
		CauldronCrafting.init();

		SeedDropRegistry.init();
		ModGen.init();

		logger.info("It's a fact, she is exactly that!");
		logger.info("A harbinger of death from the world of witchcraft,");
		logger.info("And she's feeding them cakes and her ale to this innocent boy,");
		logger.info("And her magic brings dismay!");

		logger.info("I hear her in the wind, the bane of our town");
		logger.info("Come with me, father, I'm to expose a heathen");
	}

	@EventHandler
	public void start(FMLServerStartingEvent event) {
		ModCommands.init();
		event.registerServerCommand(new CommandIncantation());
	}
}
