package com.witchworks.common.potions;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.brew.IBrew;
import com.witchworks.api.brew.IBrewHurt;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ShellArmorBrew implements IBrew, IBrewHurt {

	@Override
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		//NO - OP
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

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 0);
	}

	@Override
	public void onHurt(LivingHurtEvent event, DamageSource source, EntityLivingBase affected) {
		Entity attacker = source.getSourceOfDamage();
		if (attacker != null) {
			float damage = event.getAmount();
			attacker.attackEntityFrom(DamageSource.MAGIC, damage);
		}
	}
}
