package com.witchworks.common.potions;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.item.IBrew;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class SpiderNightmareBrew implements IBrew {

	@Override
	public void apply(World world, BlockPos pos, @Nullable EntityLivingBase entity, int tick) {
		//NO-OP
	}

	@Override
	public void onFinish(World world, BlockPos pos, @Nullable EntityLivingBase entity) {
		BlockPos posI = pos.add(-2, -2, -2);
		BlockPos posF = pos.add(2, 2, 2);
		BlockPos.getAllInBox(posI, posF).forEach(
				pos1 -> {
					if (world.getBlockState(pos1).getBlock() == Blocks.AIR)
						world.setBlockState(pos1, Blocks.WEB.getDefaultState());
				}
		);
	}

	@Override
	public int getColor() {
		return 0x000000;
	}

	@Override
	public String getName() {
		return "brew.spider_nightmare_brew.name";
	}

	@Override
	public String getDescription() {
		return "brew.spider_nightmare_brew.desc";
	}

	@Override
	public BrewRegistry.Brew getType() {
		return BrewRegistry.Brew.DRINK;
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 2);
	}
}
