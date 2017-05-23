package com.witchworks.common.item.baubles;

import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import com.witchworks.common.item.ItemMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

/**
 * This class was created by BerciTheBeast on 21.4.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 * Parts of the code may have been created by Vazkii for Botania.
 */
public abstract class ItemBauble extends ItemMod implements IBauble {

	public ItemBauble(String id) {
		super(id);
		setMaxStackSize(1);
	}

	@SuppressWarnings("deprecation")
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		ItemStack toEquip = stack.copy();
		toEquip.setCount(1);

		if (canEquip(toEquip, player)) {
			if (world.isRemote)
				return ActionResult.newResult(EnumActionResult.SUCCESS, stack);

			IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
			for (int i = 0; i < baubles.getSlots(); i++) {
				if (baubles.isItemValidForSlot(i, toEquip, player)) {
					ItemStack stackInSlot = baubles.getStackInSlot(i);
					if (stackInSlot.isEmpty() || ((IBauble) stackInSlot.getItem()).canUnequip(stackInSlot, player)) {
						baubles.setStackInSlot(i, toEquip);
						stack.shrink(1);

						if (!stackInSlot.isEmpty()) {
							((IBauble) stackInSlot.getItem()).onUnequipped(stackInSlot, player);

							if (stack.isEmpty()) {
								return ActionResult.newResult(EnumActionResult.SUCCESS, stackInSlot);
							} else {
								ItemHandlerHelper.giveItemToPlayer(player, stackInSlot);
							}
						}

						return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
					}
				}
			}
		}

		return ActionResult.newResult(EnumActionResult.PASS, stack);
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean willAutoSync(ItemStack itemstack, EntityLivingBase player) {
		return false;
	}
}
