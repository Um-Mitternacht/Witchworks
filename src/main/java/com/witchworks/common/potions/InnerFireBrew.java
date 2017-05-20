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
public class InnerFireBrew implements IBrew {

	@Override
	public void apply(World world, BlockPos pos, @Nullable EntityLivingBase entity, int tick) {
		if (tick % 20 == 0) {
			pos = pos.add(world.rand.nextInt(5), world.rand.nextInt(5), world.rand.nextInt(5));

			if (world.getBlockState(pos).getBlock() == Blocks.AIR && world.getBlockState(pos.down()).getMaterial().getCanBurn()) {
				world.setBlockState(pos, Blocks.FIRE.getDefaultState());
			}
		}
	}

	@Override
	public void onFinish(World world, BlockPos pos, @Nullable EntityLivingBase entity) {
		//NO-OP
	}

	@Override
	public int getColor() {
		return 0x80CC0000;
	}

	@Override
	public String getName() {
		return "brew.fire_brew.name";
	}

	@Override
	public String getDescription() {
		return "brew.fire_brew.desc";
	}

	@Override
	public BrewRegistry.Brew getType() {
		return BrewRegistry.Brew.DRINK;
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 1);
	}
}
