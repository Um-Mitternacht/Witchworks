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

	public ItemTaglock() {
		super(LibItemName.TAGLOCK);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer, EnumHand hand) {
		RayTraceResult result = ProjectileHelper.forwardsRaycast(entityPlayer, true, true, entityPlayer);
		ActionResult<ItemStack> actionResult = ActionResult.newResult(EnumActionResult.PASS, itemStack);
		if (result.typeOfHit == ENTITY) {
			NBTHelper.setUniqueID(itemStack, "name", result.entityHit.getUniqueID());
			actionResult = ActionResult.newResult(EnumActionResult.SUCCESS, itemStack);
		}
		return actionResult;
	}
}
