package com.witchworks.common.item.tool;

import com.witchworks.api.item.IModelRegister;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.item.ModMaterials;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 * Parts of the code were created by Vazkii, for Botania.
 */
public class ItemAthame extends ItemSword implements IModelRegister {

	public ItemAthame() {
		super(ModMaterials.TOOL_RITUAL);
		setRegistryName(LibItemName.ATHAME);
		setUnlocalizedName(LibItemName.ATHAME);
		setCreativeTab(WitchWorksCreativeTabs.ITEMS_CREATIVE_TAB);
	}

	//totally not using vazkii's code to insert a reference to redpower here
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, @Nonnull EntityLivingBase attacker) {
		if (!target.world.isRemote
				&& target instanceof EntityEnderman
				&& attacker instanceof EntityPlayer) {
			target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 20);
		}

		stack.damageItem(1, attacker);
		return true;
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void registerModels() {
		ModelHandler.registerItem(this);
	}
}
