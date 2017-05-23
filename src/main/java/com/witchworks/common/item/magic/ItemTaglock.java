package com.witchworks.common.item.magic;

import com.witchworks.api.helper.RayTraceHelper;
import com.witchworks.api.item.NBTHelper;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.block.BlockBed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.witchworks.api.WitchWorksAPI.TAGLOCK_ENTITY;
import static com.witchworks.api.WitchWorksAPI.TAGLOCK_ENTITY_NAME;
import static net.minecraft.util.math.RayTraceResult.Type.ENTITY;

/**
 * This class was created by Arekkuusu on 5/15/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemTaglock extends ItemMod {

	public ItemTaglock() {
		super(LibItemName.TAGLOCK);
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if (NBTHelper.hasTag(stack, TAGLOCK_ENTITY_NAME)) {
			tooltip.add(TextFormatting.DARK_GRAY + NBTHelper.getString(stack, TAGLOCK_ENTITY_NAME));
		} else {
			tooltip.add(TextFormatting.DARK_GRAY + I18n.format("item.tag_lock.empty"));
		}
	}

	@SuppressWarnings ("ConstantConditions")
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer entityPlayer, EnumHand hand) {
		if (!world.isRemote) {
			RayTraceResult result = RayTraceHelper.rayTraceResult(entityPlayer, RayTraceHelper.fromLookVec(entityPlayer, 2), true, true);
			if (result != null && result.typeOfHit == ENTITY && result.entityHit instanceof EntityLivingBase) {
				setVictim(stack, (EntityLivingBase) result.entityHit);
			}
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
	}

	@SuppressWarnings ("ConstantConditions")
	@Override
	public EnumActionResult onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
		IBlockState state = world.getBlockState(pos);
		if (state.getBlock().isBed(state, world, pos, player)) {
			Optional<EntityPlayer> victim = getPlayerFromBed(world, pos, state.getValue(BlockBed.OCCUPIED));
			if (victim.isPresent()) {
				setVictim(stack, victim.get());
			}
		}

		return super.onItemUseFirst(stack, player, world, pos, side, hitX, hitY, hitZ, hand);
	}

	public void removeVictim(ItemStack stack) {
		NBTHelper.removeTag(stack, TAGLOCK_ENTITY);
		NBTHelper.removeTag(stack, TAGLOCK_ENTITY_NAME);
	}

	public void setVictim(ItemStack stack, EntityLivingBase victim) {
		NBTHelper.setUniqueID(stack, TAGLOCK_ENTITY, victim.getUniqueID());
		NBTHelper.setString(stack, TAGLOCK_ENTITY_NAME, victim.getName());
	}

	public Optional<EntityLivingBase> getVictim(ItemStack stack, World world) {
		UUID uuid = NBTHelper.getUniqueID(stack, TAGLOCK_ENTITY);
		for (Entity entity : world.loadedEntityList) {
			if (entity instanceof EntityLivingBase && entity.getUniqueID().equals(uuid)) {
				return Optional.of((EntityLivingBase) entity);
			}
		}
		EntityPlayer victim = world.getPlayerEntityByUUID(uuid);
		return Optional.ofNullable(victim);
	}

	private Optional<EntityPlayer> getPlayerFromBed(World world, BlockPos bed, boolean inBed) {
		return world.playerEntities.stream().filter(
				player -> inBed ? (player.isPlayerSleeping() && player.bedLocation.equals(bed))
						: player.getBedLocation().equals(bed)
		).findAny();
	}
}
