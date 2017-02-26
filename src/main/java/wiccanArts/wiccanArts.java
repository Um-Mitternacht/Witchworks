package wiccanArts;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import wiccanArts.lib.Strings;

@Mod(modid = wiccanArts.MODID, version = wiccanArts.VERSION)
public class wiccanArts
{
	public static final String MODID = "wiccanArts";
	public static final String VERSION = "0.1";
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
	System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
	}
}
