package com.witchworks.api;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * This class was created by Arekkuusu on 01/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public final class WitchWorksAPI {

	//States
	public static final PropertyEnum<EnumDyeColor> COLOR = PropertyEnum.create("color", EnumDyeColor.class);
	public static final PropertyEnum<BlockStairs.EnumHalf> HALF = PropertyEnum.create("half", BlockStairs.EnumHalf.class);

	//Constants
	public static final String TAGLOCK_ENTITY = "tag_entity";
	public static final String TAGLOCK_ENTITY_NAME = "tag_entity_name";

	//Sounds
	public static final ResourceLocation BOIL = getLocation("boil");
	public static final ResourceLocation BUZZ = getLocation("buzz");
	public static final ResourceLocation CHALK_SCRIBBLE = getLocation("chalk_scribble");

	//Brews
	public static final Item BREW_PHIAL_DRINK = Item.REGISTRY.getObject(getLocation("brew_phial_drink"));
	public static final Item BREW_PHIAL_SPLASH = Item.REGISTRY.getObject(getLocation("brew_phial_splash"));
	public static final Item BREW_PHIAL_LINGER = Item.REGISTRY.getObject(getLocation("brew_phial_linger"));

	public static ResourceLocation SHELL_ARMOR = getLocation("shell_armor");
	public static ResourceLocation SPIDER_NIGHTMARE = getLocation("spider_nightmare");
	public static ResourceLocation EXTINGUISH_FIRES = getLocation("extinguish_fires");
	public static ResourceLocation MARS_WATER = getLocation("mars_water");
	public static ResourceLocation FROSTBITE = getLocation("frostbite");
	public static ResourceLocation HOLY_WATER = getLocation("holy_water");
	public static ResourceLocation VOLATILE = getLocation("volatility");
	public static ResourceLocation HARVEST = getLocation("harvest");
	public static ResourceLocation FERTILIZE = getLocation("fertilize");
	public static ResourceLocation GROW_FLOWERS = getLocation("grow_flowers");
	public static ResourceLocation TILL_LAND = getLocation("till_land");
	public static ResourceLocation ENDER_INHIBITION = getLocation("ender_inhibition");
	public static ResourceLocation PATH_OF_THE_DEEP = getLocation("path_of_the_deep");
	public static ResourceLocation ROCK_PULVERIZE = getLocation("rock_pulverize");
	public static ResourceLocation PRUNE_LEAVES = getLocation("prune_leaves");
	public static ResourceLocation AUTO_PLANT = getLocation("auto_plant");
	public static ResourceLocation BANE_ARTHROPODS = getLocation("bane_arthropods");
	public static ResourceLocation SINKING = getLocation("sinking");
	public static ResourceLocation CURSED_LEAPING = getLocation("cursed_leaping");
	public static ResourceLocation SKIN_TINT = getLocation("skin_tint");
	public static ResourceLocation SNOW_TRAIL = getLocation("snow_trail");
	public static ResourceLocation WOLFSBANE = getLocation("wolfsbane");
	public static ResourceLocation OUTCASTS_SHAME = getLocation("outcasts_shame");
	public static ResourceLocation IGNITION = getLocation("ignition");

	private WitchWorksAPI() {
	}

	private static ResourceLocation getLocation(String name) {
		return new ResourceLocation("witchworks", name);
	}
}
