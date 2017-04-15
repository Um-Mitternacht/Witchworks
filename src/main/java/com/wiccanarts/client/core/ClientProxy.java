package com.wiccanarts.client.core;

import com.wiccanarts.client.core.event.TextureStitcher;
import com.wiccanarts.client.fx.ParticleF;
import com.wiccanarts.client.handler.BlockColorHandler;
import com.wiccanarts.client.handler.ItemColorHandler;
import com.wiccanarts.client.handler.ModelHandler;
import com.wiccanarts.client.render.tile.TileRenderKettle;
import com.wiccanarts.common.block.ModBlocks;
import com.wiccanarts.common.block.tile.TileKettle;
import com.wiccanarts.common.core.proxy.ISidedProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
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
@Mod.EventBusSubscriber (Side.CLIENT)
public class ClientProxy implements ISidedProxy {

	/**
	 * Here you can register your Item models that do not have a class.
	 * <p>
	 * According to the registry name of the item, the model loader will look
	 * into the models file and bind the item to its corresponding model.
	 * </p>
	 */
	@SideOnly (Side.CLIENT)
	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event) {
		ModelHandler.registerModels();
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		registerRenders();
		MinecraftForge.EVENT_BUS.register(new TextureStitcher());
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void init(FMLInitializationEvent event) {
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new BlockColorHandler(),
				ModBlocks.CANDLE_LARGE, ModBlocks.CANDLE_MEDIUM, ModBlocks.CANDLE_SMALL);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new ItemColorHandler(),
				Item.getItemFromBlock(ModBlocks.CANDLE_LARGE),
				Item.getItemFromBlock(ModBlocks.CANDLE_MEDIUM),
				Item.getItemFromBlock(ModBlocks.CANDLE_SMALL));
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void postInit(FMLPostInitializationEvent event) {

	}

	/**
	 * Register here all Renders. For example:
	 * {@code RenderingRegistry.registerEntityRenderingHandler(Entity.class, RenderEntity::new);}
	 * or
	 * {@code ClientRegistry.bindTileEntitySpecialRenderer(Tile.class, new RenderTile());}
	 * @see RenderingRegistry
	 */
	@SideOnly (Side.CLIENT)
	private void registerRenders() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileKettle.class, new TileRenderKettle());
	}

	/**
	 * Display a Record text with a format and localization.
	 * @param text An {@link ITextComponent}
	 */
	@SideOnly (Side.CLIENT)
	@Override
	public void displayRecordText(ITextComponent text) {
		Minecraft.getMinecraft().ingameGUI.setRecordPlayingMessage(text.getFormattedText());
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void spawnParticle(ParticleF particleF, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, float... args) {
		if (doParticle()) {
			Minecraft.getMinecraft().effectRenderer.addEffect(particleF.newInstance(x, y, z, xSpeed, ySpeed, zSpeed, args));
		}
	}

	@SideOnly (Side.CLIENT)
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
