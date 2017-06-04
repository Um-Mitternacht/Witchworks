package com.witchworks.common.potions;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.item.IBrew;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ExtinguishBrew implements IBrew {

	public ExtinguishBrew() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void apply(World world, BlockPos pos, @Nullable EntityLivingBase entity, int amplifier, int tick) {
		if (entity.isBurning())
			entity.extinguish();
	}


	@Override
	public void onFinish(World world, BlockPos pos, @Nullable EntityLivingBase entity, int amplifier) {
		//NO-OP
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public int getColor() {
		return 0x3EB489;
	}

	@Override
	public String getName() {
		return "brew.extinguish_brew.name";
	}

	@Override
	public String getDescription() {
		return "brew.extinguish_brew.desc";
	}

	@Override
	public BrewRegistry.Brew getType() {
		return BrewRegistry.Brew.DRINK;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 3);
	}

}
