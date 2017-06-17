package com.witchworks.common.item.magic.brew;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.brew.BrewUtils;
import com.witchworks.common.entity.EntityBrew;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.witchworks.api.BrewRegistry.Brew.LINGER;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemBrewLinger extends ItemBrew {

	public ItemBrewLinger() {
		super(LibItemName.BREW_PHIAL_LINGER);
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		ItemStack copy = playerIn.capabilities.isCreativeMode ? itemstack.copy() : itemstack.splitStack(1);
		playerIn.playSound(SoundEvents.ENTITY_LINGERINGPOTION_THROW, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote) {
			EntityBrew brew = new EntityBrew(worldIn, playerIn, copy, EntityBrew.BrewDispersion.LINGER);

			brew.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.5F, 1.0F);
			worldIn.spawnEntity(brew);
		}

		return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		BrewRegistry.getDefaults().get(LINGER).forEach((brew, brewEffect) ->
				subItems.add(BrewUtils.createBrew(LINGER, brew))
		);
	}
}
