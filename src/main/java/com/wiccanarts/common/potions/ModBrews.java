package com.wiccanarts.common.potions;

import com.wiccanarts.common.lib.LibBrewName;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.wiccanarts.common.core.handler.PotionEventHandler;

public final class ModBrews {

	public static Potion test;

	public static void init() {
		new PotionEventHandler();

		test = registerPotion("Test Potion", new ResourceLocation(LibBrewName.TEST), false, 0x000000, 0, 0);
	}

	protected static Potion registerPotion(String name, ResourceLocation location, boolean badEffect, int potionColour, int idxX, int idxY) {
		Potion potion = new BrewMod(name, location, badEffect, potionColour, idxX, idxY);
		GameRegistry.register(potion.setRegistryName(location.getResourcePath()));
		return potion;
	}
}
