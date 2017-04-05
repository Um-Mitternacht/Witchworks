package com.wiccanarts.client.core;

import com.wiccanarts.client.core.event.*;
import com.wiccanarts.client.fx.*;
import com.wiccanarts.client.handler.*;
import com.wiccanarts.client.render.tile.*;
import com.wiccanarts.common.block.*;
import com.wiccanarts.common.block.tile.*;
import com.wiccanarts.common.core.proxy.*;
import net.minecraft.client.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.client.registry.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.relauncher.*;

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
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		registerRenders();
		MinecraftForge.EVENT_BUS.register(new TextureStitcher());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void init(FMLInitializationEvent event) {
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new BlockColorHandler(),
				ModBlocks.CANDLE_LARGE, ModBlocks.CANDLE_MEDIUM, ModBlocks.CANDLE_SMALL);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemColorHandler(),
				Item.getItemFromBlock(ModBlocks.CANDLE_LARGE),
				Item.getItemFromBlock(ModBlocks.CANDLE_MEDIUM),
				Item.getItemFromBlock(ModBlocks.CANDLE_SMALL));
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
		ClientRegistry.bindTileEntitySpecialRenderer(TileKettle.class, new TileRenderKettle());
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
	@Override
	public void spawnParticle(ParticleF particleF, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float... args) {
		if (doParticle()) {
			Minecraft.getMinecraft().effectRenderer.addEffect(particleF.newInstance(x, y, z, xSpeed, ySpeed, zSpeed, args));
		}
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
