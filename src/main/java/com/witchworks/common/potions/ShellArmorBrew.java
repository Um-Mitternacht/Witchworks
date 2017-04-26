package com.witchworks.common.potions;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.item.IBrew;
import com.witchworks.common.core.capability.potion.BrewStorageHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ShellArmorBrew implements IBrew {

	public ShellArmorBrew() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void apply(World world, BlockPos pos, @Nullable EntityLivingBase entity, int tick) {
		//NO - OP
	}

	@Override
	public void onFinish(World world, BlockPos pos, @Nullable EntityLivingBase entity) {
		//NO-OP
	}

	@Override
	public int getColor() {
		return 0xCCFF00;
	}

	@Override
	public String getName() {
		return "brew.shell_armor.name";
	}

	@Override
	public String getDescription() {
		return "brew.shell_armor.desc";
	}

	@Override
	public BrewRegistry.Brew getType() {
		return BrewRegistry.Brew.DRINK;
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 0);
	}

	@SubscribeEvent
	public void onHurt(LivingHurtEvent event) {
		if (BrewStorageHandler.isBrewActive(event.getEntityLiving(), ModBrews.SHELL_ARMOR)) {
			Entity attacker = event.getSource().getSourceOfDamage();
			if (attacker != null) {
				float damage = event.getAmount();
				attacker.attackEntityFrom(DamageSource.magic, damage);
			}
		}
	}
}
