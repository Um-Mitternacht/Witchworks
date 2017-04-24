package com.witchworks.common.item.food;

import com.witchworks.api.item.IModelRegister;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by Joseph on 3/4/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemHoney extends ItemModFood implements IModelRegister {

	public ItemHoney() {
		super(LibItemName.HONEY, 2, 4F, false);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 450, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 450, 0));
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void registerModels() {
		ModelHandler.registerItem(this);
	}
}
