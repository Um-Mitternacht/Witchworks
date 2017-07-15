package com.witchworks.common.item.tool;

import com.witchworks.api.helper.IModelRegister;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.item.ModMaterials;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
// Uses code from Botania

public class ItemAthame extends ItemSword implements IModelRegister {

	public ItemAthame() {
		super(ModMaterials.TOOL_RITUAL);
		setRegistryName(LibItemName.ATHAME);
		setUnlocalizedName(LibItemName.ATHAME);
		setCreativeTab(WitchWorksCreativeTabs.ITEMS_CREATIVE_TAB);
		MinecraftForge.EVENT_BUS.register(this);
	}


	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (!target.world.isRemote)
			if (target instanceof EntityEnderman && attacker instanceof EntityPlayer) {
				target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 20);
				stack.damageItem(50, attacker);
			} else {
				stack.damageItem(1, attacker);
			}
		return true;
	}

	private void addDrop(LivingDropsEvent event, ItemStack drop) {
		EntityItem entityitem = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, drop);
		entityitem.setPickupDelay(10);
		event.getDrops().add(entityitem);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModel() {
		ModelHandler.registerModel(this, 0);
	}
}
