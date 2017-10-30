package com.witchworks.client.core;

import com.witchworks.client.ResourceLocations;
import com.witchworks.client.core.event.BrewHUD;
import com.witchworks.client.core.event.ClientEvents;
import com.witchworks.client.core.event.EnergyHUD;
import com.witchworks.client.fx.ParticleF;
import com.witchworks.client.handler.BlockCandleColorHandler;
import com.witchworks.client.handler.BrewItemColorHandler;
import com.witchworks.client.handler.ItemCandleColorHandler;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.client.render.entity.BrewRenderer;
import com.witchworks.client.render.entity.EmptyRenderer;
import com.witchworks.client.render.tile.TileRenderCauldron;
import com.witchworks.common.WitchWorks;
import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.core.net.GuiHandler;
import com.witchworks.common.core.proxy.ISidedProxy;
import com.witchworks.common.entity.EntityBrew;
import com.witchworks.common.entity.EntityBrewLinger;
import com.witchworks.common.item.ModItems;
import com.witchworks.common.tile.TileCauldron;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy implements ISidedProxy {

	@SubscribeEvent
	public static void registerItemModels(ModelRegistryEvent event) {
		ModelHandler.registerModels();
	}

	@SubscribeEvent
	public static void stitchEventPre(TextureStitchEvent.Pre event) {
		event.getMap().registerSprite(ResourceLocations.STEAM);
		event.getMap().registerSprite(ResourceLocations.BEE);
		event.getMap().registerSprite(ResourceLocations.GRAY_WATER);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		registerRenders();
		MinecraftForge.EVENT_BUS.register(new EnergyHUD());
		MinecraftForge.EVENT_BUS.register(new BrewHUD());
		MinecraftForge.EVENT_BUS.register(new ClientEvents());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BlockColors blocks = Minecraft.getMinecraft().getBlockColors();
		//Block Colors
		blocks.registerBlockColorHandler(new BlockCandleColorHandler(),
				ModBlocks.candle_large, ModBlocks.candle_medium, ModBlocks.candle_small);

		ItemColors items = Minecraft.getMinecraft().getItemColors();
		//Item Colors
		items.registerItemColorHandler(new ItemCandleColorHandler(),
				Item.getItemFromBlock(ModBlocks.candle_large),
				Item.getItemFromBlock(ModBlocks.candle_medium),
				Item.getItemFromBlock(ModBlocks.candle_small));
		items.registerItemColorHandler(new BrewItemColorHandler(),
				ModItems.brew_phial_drink, ModItems.brew_phial_splash, ModItems.brew_phial_linger);

		NetworkRegistry.INSTANCE.registerGuiHandler(WitchWorks.instance, new GuiHandler());
	}

	public void displayRecordText(ITextComponent text) {
		Minecraft.getMinecraft().ingameGUI.setRecordPlayingMessage(text.getFormattedText());
	}

	@Override
	public void spawnParticle(ParticleF particleF, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, int... args) {
		if (doParticle()) {
			Minecraft.getMinecraft().effectRenderer.addEffect(particleF.newInstance(x, y, z, xSpeed, ySpeed, zSpeed, args));
		}
	}

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

	private void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBrew.class, BrewRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityBrewLinger.class, EmptyRenderer::new);

		ClientRegistry.bindTileEntitySpecialRenderer(TileCauldron.class, new TileRenderCauldron());
	}
}
