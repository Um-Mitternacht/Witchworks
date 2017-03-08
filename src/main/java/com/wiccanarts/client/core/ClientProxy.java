package com.wiccanarts.client.core;

import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.core.proxy.ISidedProxy;
import com.wiccanarts.common.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy implements ISidedProxy {

	/**
	 * Here you can register your Item models that do not have a class.
	 * <p>
	 * According to the registry name of the item, the model loader will look
	 * into the models file and bind the item to its corresponding model.
	 * </p>
	 */
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event) {
		ModelHandler.registerModels(); //These do have a class, but need to be registered in the event

		ModelHandler.registerItem(ModItems.GARNET);
		ModelHandler.registerItem(ModItems.MOLDAVITE);
		ModelHandler.registerItem(ModItems.NUUMMITE);
		ModelHandler.registerItem(ModItems.PETOSKEY_STONE);
		ModelHandler.registerItem(ModItems.SERPENTINE);
		ModelHandler.registerItem(ModItems.TIGERS_EYE);
		ModelHandler.registerItem(ModItems.TOURMALINE);
		ModelHandler.registerItem(ModItems.BLOODSTONE);
		ModelHandler.registerItem(ModItems.JASPER);
		ModelHandler.registerItem(ModItems.MALACHITE);
		ModelHandler.registerItem(ModItems.AMETHYST);
		ModelHandler.registerItem(ModItems.ALEXANDRITE);
		ModelHandler.registerItem(ModItems.QUARTZ);
		ModelHandler.registerItem(ModItems.SILVER_POWDER);
		ModelHandler.registerItem(ModItems.SILVER_NUGGET);
		ModelHandler.registerItem(ModItems.SILVER_INGOT);

		ModelHandler.registerBlock(ModBlocks.SILVER_BLOCK);
		ModelHandler.registerBlock(ModBlocks.COQUINA);
		ModelHandler.registerBlock(ModBlocks.MOLDAVITE_BLOCK);
		ModelHandler.registerBlock(ModBlocks.BLOODSTONE_BLOCK);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		registerRenders();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void init(FMLInitializationEvent event) {

	}

	@SideOnly(Side.CLIENT)
	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

	/**
	 * Register here all Renders. For example:
	 * {@code RenderingRegistry.registerEntityRenderingHandler(Entity.class, RenderEntity::new);}
	 * or
	 * {@code ClientRegistry.bindTileEntitySpecialRenderer(Tile.class, new RenderTile());}
	 *
	 * @see RenderingRegistry
	 */
	@SideOnly(Side.CLIENT)
	private void registerRenders() {

	}

	/**
	 * Display a Record text with a format and localization.
	 *
	 * @param text An {@link ITextComponent}
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public void displayRecordText(ITextComponent text) {
		Minecraft.getMinecraft().ingameGUI.setRecordPlayingMessage(text.getFormattedText());
	}

	@SideOnly(Side.CLIENT)
	private boolean doParticle() {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
			return false;

		float chance = 1F;
		if (Minecraft.getMinecraft().gameSettings.particleSetting == 1)
			chance = 0.6F;
		else if (Minecraft.getMinecraft().gameSettings.particleSetting == 2)
			chance = 0.2F;

		return chance == 1F || Math.random() < chance;
	}
}
