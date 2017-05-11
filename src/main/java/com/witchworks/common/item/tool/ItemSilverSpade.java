package com.witchworks.common.item.tool;

import com.witchworks.api.item.IModelRegister;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
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
public class ItemSilverSpade extends ItemSpade implements IModelRegister {

	public ItemSilverSpade(ToolMaterial material) {
		super(material);
		setRegistryName(LibItemName.SILVER_SPADE);
		setUnlocalizedName(LibItemName.SILVER_SPADE);
		setCreativeTab(WitchWorksCreativeTabs.ITEMS_CREATIVE_TAB);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, @Nonnull EntityLivingBase attacker) {
		if (!target.world.isRemote
				&& target.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD
				&& attacker instanceof EntityPlayer) {
			target.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 12);
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
