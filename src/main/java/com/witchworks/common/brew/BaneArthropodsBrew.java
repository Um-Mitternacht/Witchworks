package com.witchworks.common.brew;

import com.witchworks.api.brew.IBrew;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class BaneArthropodsBrew implements IBrew {

	@Override
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		if (amplifier >= 3) {
			if (entity.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD) {
				entity.attackEntityFrom(DamageSource.MAGIC, 20);
			}
		}

		if (amplifier == 2) {
			if (entity.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD) {
				entity.attackEntityFrom(DamageSource.MAGIC, 16);
			}
		}

		if (entity.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD) {
			entity.attackEntityFrom(DamageSource.MAGIC, 10);
		}
	}

	@Override
	public boolean isBad() {
		return true;
	}

	@Override
	public boolean isInstant() {
		return true;
	}

	@Override
	public int getColor() {
		return 0x50C878;
	}

	@Override
	public String getName() {
		return "bane_arthropods";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc, int amplifier) {
		//NO-OP
	}
}
