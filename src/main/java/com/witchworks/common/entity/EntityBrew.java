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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
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

	private static final DataParameter<ItemStack> ITEM = EntityDataManager.createKey(EntityBrew.class, DataSerializers.OPTIONAL_ITEM_STACK);
	private BrewDispersion dispersion;

	public EntityBrew(World worldIn) {
		super(worldIn);
	}

	public EntityBrew(World worldIn, EntityLivingBase living, ItemStack stack, BrewDispersion dispersion) {
		super(worldIn, living);
		this.dispersion = dispersion;
		setBrew(stack);
	}

	@Override
	protected void entityInit() {
		getDataManager().register(ITEM, ItemStack.EMPTY);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (world.isRemote) return;

		if (getBrew().hasTagCompound()) {
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
		List<BrewEffect> brewEffects = BrewUtils.getBrewsFromStack(getBrew());

		brewEffects.stream().filter(brewEffect -> brewEffect.getBrew() instanceof IBrewEntityImpact).forEach(brewEffect ->
				((IBrewEntityImpact) brewEffect.getBrew()).impact(result, world, brewEffect.getAmplifier())
		);
	}

	private void doSplash() {
		playSound(SoundEvents.ENTITY_SPLASH_POTION_BREAK, 1F, 1F);
		AxisAlignedBB axisalignedbb = this.getEntityBoundingBox().expand(4.0D, 2.0D, 4.0D);
		List<EntityLivingBase> list = this.world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

		if (!list.isEmpty()) {
			Tuple<List<BrewEffect>, List<PotionEffect>> tuple = BrewUtils.deSerialize(NBTHelper.fixNBT(getBrew()));

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

	public ItemStack getBrew() {
		return getDataManager().get(ITEM);
	}

	public void setBrew(ItemStack stack) {
		getDataManager().set(ITEM, stack);
		getDataManager().setDirty(ITEM);
	}

	public enum BrewDispersion {
		SPLASH,
		LINGER,
		GAS
	}
}
