package com.wiccanarts.common.crafting;

import com.wiccanarts.api.KettleRegistry;
import com.wiccanarts.api.recipe.IEffectModifier;
import com.wiccanarts.api.recipe.PotionHolder;
import com.wiccanarts.common.item.ModItems;
import com.wiccanarts.common.potions.BrewUtils;
import com.wiccanarts.common.potions.ModBrews;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import java.util.HashMap;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
public final class KettleCrafting {

	private KettleCrafting() {
	}

	public static void init() {
		//Others
		KettleRegistry.registerKettleRecipe(new HoneyKettleCrafting());

		//Exchanges
		KettleRegistry.addKettleExchange(getStack(ModItems.EMPTY_HONEYCOMB), getStack(ModItems.WAX), false);
		KettleRegistry.addKettleExchange(getStack(Items.BEEF), getStack(Items.COOKED_BEEF), false);
		KettleRegistry.addKettleExchange(getStack(Items.FISH, 3), getStack(Items.COOKED_FISH), true);
		KettleRegistry.addKettleExchange(getStack(Items.CHICKEN), getStack(Items.COOKED_CHICKEN), false);
		KettleRegistry.addKettleExchange(getStack(Items.MUTTON), getStack(Items.COOKED_MUTTON), false);
		KettleRegistry.addKettleExchange(getStack(Items.PORKCHOP), getStack(Items.COOKED_PORKCHOP), false);
		KettleRegistry.addKettleExchange(getStack(Items.RABBIT), getStack(Items.COOKED_RABBIT), false);
		KettleRegistry.addKettleExchange(getStack(Items.POTATO), getStack(Items.BAKED_POTATO), false);

		//Item Recipes


		//Potion Recipes
		KettleRegistry.registerKettlePotionRecipe(BrewUtils.createPotion(Items.POTIONITEM, new PotionEffect(ModBrews.STONEFORM_BREW))
				, Blocks.COBBLESTONE, Blocks.COBBLESTONE, Blocks.COBBLESTONE, Blocks.COBBLESTONE, Items.IRON_INGOT, Items.BEETROOT);

		KettleRegistry.registerKettlePotionRecipe(BrewUtils.createPotion(Items.POTIONITEM, new PotionEffect(ModBrews.PARALYSIS_BREW))
				, Items.FERMENTED_SPIDER_EYE, Items.FERMENTED_SPIDER_EYE, Items.ROTTEN_FLESH, Items.POISONOUS_POTATO, ModItems.BELLADONNA);

		//Custom Brewing
		//Custom Effects
		KettleRegistry.addKettleEffectTo(getStack(Items.GOLDEN_CARROT), new PotionHolder(MobEffects.NIGHT_VISION, 500));

		KettleRegistry.addKettleEffectTo(getStack(Items.MAGMA_CREAM), new PotionHolder(MobEffects.FIRE_RESISTANCE, 500));

		KettleRegistry.addKettleEffectTo(getStack(Items.RABBIT_FOOT), new PotionHolder(MobEffects.JUMP_BOOST, 500));

		KettleRegistry.addKettleEffectTo(getStack(Items.SUGAR), new PotionHolder(MobEffects.SPEED, 500));

		KettleRegistry.addKettleEffectTo(getStack(Items.FISH, 3), new PotionHolder(MobEffects.WATER_BREATHING, 500));

		KettleRegistry.addKettleEffectTo(getStack(Items.SPECKLED_MELON), new PotionHolder(MobEffects.INSTANT_HEALTH, 0));

		KettleRegistry.addKettleEffectTo(getStack(Items.SPIDER_EYE), new PotionHolder(MobEffects.POISON, 500));

		KettleRegistry.addKettleEffectTo(getStack(Items.GHAST_TEAR), new PotionHolder(MobEffects.REGENERATION, 500));

		KettleRegistry.addKettleEffectTo(getStack(Items.BLAZE_POWDER), new PotionHolder(MobEffects.STRENGTH, 500));

		KettleRegistry.addKettleEffectTo(getStack(Items.GOLDEN_APPLE), new PotionHolder(MobEffects.HEALTH_BOOST, 500));

		KettleRegistry.addKettleEffectTo(getStack(Blocks.MELON_BLOCK), new PotionHolder(MobEffects.SATURATION, 500));

		//TODO: Belladonna gives hallucinations not paralysis
		//KettleRegistry.addKettleEffectTo(getStack(ModItems.BELLADONNA), new PotionHolder(ModBrews.PARALYSIS_BREW, 240));

		KettleRegistry.addKettleEffectTo(getStack(Items.BREAD), new PotionHolder(MobEffects.SATURATION, 600));

		KettleRegistry.addKettleEffectTo(getStack(ModItems.BLOODSTONE), new PotionHolder(MobEffects.ABSORPTION, 600));

		KettleRegistry.addKettleEffectTo(getStack(Blocks.RED_FLOWER), new PotionHolder(MobEffects.LUCK, 600));

		KettleRegistry.addKettleEffectTo(getStack(ModItems.ASPHODEL), new PotionHolder(MobEffects.UNLUCK, 600));

		KettleRegistry.addKettleEffectTo(getStack(ModItems.JASPER), new PotionHolder(MobEffects.RESISTANCE, 600));

		KettleRegistry.addKettleEffectTo(getStack(Items.CHORUS_FRUIT), new PotionHolder(MobEffects.LEVITATION, 600));

		KettleRegistry.addKettleEffectTo(getStack(Items.PRISMARINE_CRYSTALS), new PotionHolder(MobEffects.GLOWING, 600));

		KettleRegistry.addKettleEffectTo(getStack(Items.NETHER_STAR), new PotionHolder(MobEffects.WITHER, 1000));

		//Custom Modifiers
		KettleRegistry.addKettleModifierTo(getStack(Items.REDSTONE), effect -> effect.alter(10, 0));

		KettleRegistry.addKettleModifierTo(getStack(Blocks.REDSTONE_BLOCK), effect -> effect.alter(90, 0));

		KettleRegistry.addKettleModifierTo(getStack(Items.GLOWSTONE_DUST), effect -> effect.alter(-90, 1));

		KettleRegistry.addKettleModifierTo(getStack(Blocks.GLOWSTONE), effect -> effect.alter(-10, 2));

		KettleRegistry.addKettleModifierTo(getStack(Items.FERMENTED_SPIDER_EYE), new FermentedEyeModifier());

		KettleRegistry.addKettleModifierTo(getStack(ModItems.QUARTZ), effect -> effect.alter(400, 0));

		KettleRegistry.addKettleModifierTo(getStack(ModItems.NUUMMITE), effect -> effect.alter(-150, 3));
	}

	/**
	 * Who needs to write the whole thing?
	 * @param item The item to make an ItemStack out of
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item) {
		return getStack(item, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param item The block to make an ItemStack out of
	 * @param meta Meta of ItemStack
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item, int meta) {
		return new ItemStack(item, 1, meta);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param block The block to make an ItemStack out of
	 * @return An ItemStack
	 */
	@SuppressWarnings ("ConstantConditions")
	private static ItemStack getStack(Block block) {
		return getStack(Item.getItemFromBlock(block), 0);
	}

	/**
	 * Who needs to write the whole thing?
	 * @param block The block to make an ItemStack out of
	 * @return An ItemStack
	 */
	@SuppressWarnings ("ConstantConditions")
	private static ItemStack getStack(Block block, int meta) {
		return getStack(Item.getItemFromBlock(block), meta);
	}

	private static class FermentedEyeModifier implements IEffectModifier {

		private Map<Potion, Potion> potionMap = new HashMap<>();

		FermentedEyeModifier() {
			potionMap.put(MobEffects.NIGHT_VISION, MobEffects.INVISIBILITY);
			potionMap.put(MobEffects.JUMP_BOOST, MobEffects.SLOWNESS);
			potionMap.put(MobEffects.SPEED, MobEffects.SLOWNESS);
			potionMap.put(MobEffects.INSTANT_HEALTH, MobEffects.INSTANT_DAMAGE);
			potionMap.put(MobEffects.REGENERATION, MobEffects.POISON);
			potionMap.put(MobEffects.POISON, MobEffects.INSTANT_DAMAGE);
			potionMap.put(MobEffects.STRENGTH, MobEffects.WEAKNESS);
		}

		@Override
		public PotionHolder apply(PotionHolder effect) {
			if (potionMap.containsKey(effect.getPotion())) {
				effect.setPotion(potionMap.get(effect.getPotion()));
			}
			return effect;
		}
	}
}
