package com.witchworks.common.item.tool;

import com.witchworks.api.helper.IModelRegister;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemBoline extends ItemShears implements IModelRegister {

	@Nonnull
	public ItemBoline() {
		super();
		setMaxDamage(400);
		setRegistryName(LibItemName.BOLINE);
		setUnlocalizedName(LibItemName.BOLINE);
		setCreativeTab(WitchWorksCreativeTabs.ITEMS_CREATIVE_TAB);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, @Nonnull EntityLivingBase attacker) {
		if (!target.world.isRemote) {
			if (attacker instanceof EntityPlayer)
				target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 5);
			stack.damageItem(1, attacker);
		}
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModel() {
		ModelHandler.registerModel(this, 0);
	}
}
