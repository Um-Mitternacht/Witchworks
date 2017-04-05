package com.wiccanarts.common;

import com.wiccanarts.common.block.*;
import com.wiccanarts.common.core.event.*;
import com.wiccanarts.common.core.gen.*;
import com.wiccanarts.common.core.handler.*;
import com.wiccanarts.common.core.proxy.*;
import com.wiccanarts.common.entity.*;
import com.wiccanarts.common.item.*;
import com.wiccanarts.common.lib.*;
import com.wiccanarts.common.net.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.registry.*;

import static net.minecraftforge.fml.common.Mod.*;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
@Mod(modid = LibMod.MOD_ID, name = LibMod.MOD_NAME, version = LibMod.MOD_VER, dependencies = LibMod.DEPENDENCIES)
public class WiccanArts {

	@Instance(LibMod.MOD_ID)
	public static WiccanArts instance;

	@SidedProxy(serverSide = LibMod.PROXY_COMMON, clientSide = LibMod.PROXY_CLIENT)
	public static ISidedProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		PacketHandler.init();
		ModEvents.preInit();
		ModEntities.preInit();
		ModSounds.preInit();
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);

		ModItems.initOreDictionary();
		ModItems.init();

		ModBlocks.initOreDictionary();
		ModBlocks.init();

		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.SILVER_ORE, 4, 7), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.MOLDAVITE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.BLOODSTONE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.TOURMALINE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.MALACHITE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.TIGERS_EYE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.SERPENTINE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.NUUMMITE_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.GARNET_ORE), 0);
		GameRegistry.registerWorldGenerator(new WorldGenOre(ModBlocks.PETOSKEY_ORE), 0);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
