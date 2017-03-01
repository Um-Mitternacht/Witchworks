package com.wiccanarts.common.core;

import com.wiccanarts.common.item.ItemMod;
import com.wiccanarts.common.lib.LibItemName;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@Mod.EventBusSubscriber
public class CommonRegistration {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				new ItemMod(LibItemName.GARNET),
				new ItemMod(LibItemName.MOLDAVITE),
				new ItemMod(LibItemName.NUUMITE),
				new ItemMod(LibItemName.PETOSKEY_STONE),
				new ItemMod(LibItemName.SERPENTINE),
				new ItemMod(LibItemName.TIGERS_EYE),
				new ItemMod(LibItemName.TOURMALINE)
		);
	}

	private static Item itemBlock(Block block) {
		return new ItemBlock(block).setRegistryName(block.getRegistryName());
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll();
	}

	@SubscribeEvent
	public static void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().registerAll();
	}
}
