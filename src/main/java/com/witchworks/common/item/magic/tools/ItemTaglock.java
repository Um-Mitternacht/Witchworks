package com.witchworks.common.item.magic.tools;

import com.witchworks.api.item.NBTHelper;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import static net.minecraft.util.math.RayTraceResult.Type.ENTITY;

/**
 * Created by Joseph on 5/15/2017.
 */
public class ItemTaglock extends ItemMod {

	//Todo: Change text to indicate the mob or player that has been tagged, as well as change texture upon getting a taglock.

	public ItemTaglock() {
		super(LibItemName.TAGLOCK);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer entityPlayer, EnumHand hand) {
		RayTraceResult result = ProjectileHelper.forwardsRaycast(entityPlayer, true, true, entityPlayer);
		ActionResult<ItemStack> actionResult = ActionResult.newResult(EnumActionResult.PASS, stack);
		if (result != null && result.typeOfHit == ENTITY) {
			NBTHelper.setUniqueID(stack, "name", result.entityHit.getUniqueID());
			actionResult = ActionResult.newResult(EnumActionResult.SUCCESS, stack);
			System.out.print("Success, entity has been tagged");
		}
		return actionResult;
	}
}
