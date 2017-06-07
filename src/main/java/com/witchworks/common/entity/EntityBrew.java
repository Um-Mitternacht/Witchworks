package com.witchworks.common.entity;

import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.IBrewEntityImpact;
import com.witchworks.api.item.NBTHelper;
import com.witchworks.common.core.capability.potion.BrewStorageHandler;
import com.witchworks.common.potions.BrewUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.List;

/**
 * This class was created by Arekkuusu on 22/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class EntityBrew extends EntityThrowable {

	private BrewDispersion dispersion;
	private ItemStack stack;

	public EntityBrew(World worldIn) {
		super(worldIn);
	}

	public EntityBrew(World worldIn, ItemStack stack, BrewDispersion dispersion) {
		super(worldIn);
		this.dispersion = dispersion;
		this.stack = stack;
	}

	@Override
	protected void entityInit() {

	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if(world.isRemote) return;

		if(stack.hasTagCompound()) {
			impact(result);

			switch (dispersion) {
				case SPLASH:
					doSplash();
					break;
				case LINGER:

					break;
				default:
			}
		}

		setDead();
	}

	private void impact(RayTraceResult result) {
		List<BrewEffect> brewEffects = BrewUtils.getBrewsFromStack(stack);

		brewEffects.stream().filter(brewEffect -> brewEffect instanceof IBrewEntityImpact).forEach(brewEffect ->
			((IBrewEntityImpact) brewEffect).impact(result, world, brewEffect.getAmplifier())
		);
	}

	private void doSplash() {
		playSound(SoundEvents.ENTITY_SPLASH_POTION_BREAK, 1F, 1F);
		AxisAlignedBB axisalignedbb = this.getEntityBoundingBox().expand(4.0D, 2.0D, 4.0D);
		List<EntityLivingBase> list = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

		if (!list.isEmpty()) {
			Tuple<List<BrewEffect>, List<PotionEffect>> tuple = BrewUtils.deSerialize(NBTHelper.fixNBT(stack));

			for (EntityLivingBase entity : list) {
				double distance = this.getDistanceSqToEntity(entity);

				if (distance < 16.0D) {
					for (BrewEffect effect : tuple.getFirst()) {
						if (effect == null) continue;
						BrewStorageHandler.addEntityBrewEffect(entity, effect.copy());
					}

					for (PotionEffect potioneffect : tuple.getSecond()) {
						entity.addPotionEffect(new PotionEffect(potioneffect));
					}
				}
			}
		}
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		dispersion = BrewDispersion.valueOf(compound.getString("dispersion"));
		stack = new ItemStack(compound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		compound.setString("dispersion", dispersion.name());
		stack.writeToNBT(compound);
	}

	public ItemStack getBrew() {
		return stack;
	}

	public enum BrewDispersion {
		SPLASH,
		LINGER,
		GAS
	}
}
