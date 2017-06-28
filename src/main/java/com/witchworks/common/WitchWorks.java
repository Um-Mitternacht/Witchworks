package com.witchworks.common;

import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.brew.ModBrews;
import com.witchworks.common.core.achievement.ModAchievements;
import com.witchworks.common.core.capability.brew.CapabilityBrewStorage;
import com.witchworks.common.core.capability.energy.CapabilityEnergy;
import com.witchworks.common.core.command.CommandIncantation;
import com.witchworks.common.core.command.ModCommands;
import com.witchworks.common.core.event.ModEvents;
import com.witchworks.common.core.gen.ModGen;
import com.witchworks.common.core.handler.ModSounds;
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

import static net.minecraftforge.fml.common.Mod.EventHandler;
import static net.minecraftforge.fml.common.Mod.Instance;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
@Mod(modid = LibMod.MOD_ID, name = LibMod.MOD_NAME, version = LibMod.MOD_VER, dependencies = LibMod.DEPENDENCIES, acceptedMinecraftVersions = "[1.11]")
public class WitchWorks {

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
		ModSounds.init();
		ModEntities.init();
		ModBrews.init();
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);

		ModItems.init();
		ModBlocks.init();
		CauldronCrafting.init();

		SeedDropRegistry.init();
		ModAchievements.init();
		ModGen.init();
	}

	@EventHandler
	public void start(FMLServerStartingEvent event) {
		ModCommands.init();
		event.registerServerCommand(new CommandIncantation());
	}
}
