package com.witchworks.common.potions;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.brew.IBrew;
import com.witchworks.api.brew.IBrewEntityImpact;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ExtinguishBrew implements IBrew, IBrewEntityImpact {

	public ExtinguishBrew() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		if (entity.isBurning())
			entity.extinguish();
	}

	@Override
	public void onFinish(World world, BlockPos pos, EntityLivingBase entity, int amplifier) {
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
		return BrewRegistry.Brew.SPLASH;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 3);
	}

	@Override
	public void impact(RayTraceResult trace, World world, int amplifier) {
		if (trace.typeOfHit == RayTraceResult.Type.BLOCK) {
			BlockPos pos = trace.getBlockPos().offset(trace.sideHit);
			int box = 1 + amplifier;
			BlockPos.getAllInBox(pos.add(box, box, box), pos.add(-box, -box, -box)).forEach(
					in -> {
						Material material = world.getBlockState(in).getMaterial();
						if (material == Material.FIRE) {
							world.setBlockToAir(in);
						}
					}
			);
		}
	}
}
