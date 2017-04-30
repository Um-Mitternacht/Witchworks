package com.witchworks.common.item.magic.brew;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.item.BrewEffect;
import com.witchworks.common.core.capability.potion.BrewStorageHandler;
import com.witchworks.common.lib.LibItemName;
import com.witchworks.common.potions.BrewUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Optional;

/**
 * This class was created by BerciTheBeast on 27.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemBrewDrink extends ItemBrew {

	public ItemBrewDrink() {
		super(LibItemName.BREW_PHIAL_DRINK);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity) {
		EntityPlayer entityplayer = entity instanceof EntityPlayer ? (EntityPlayer) entity : null;
		if (!world.isRemote) {
			Optional<BrewEffect> optional = BrewUtils.getBrewFromStack(stack);
			if (optional.isPresent()) {
				BrewStorageHandler.addEntityBrewEffect(entity, optional.get());
			} else {
				for (PotionEffect potioneffect : PotionUtils.getEffectsFromStack(stack)) {
					entity.addPotionEffect(new PotionEffect(potioneffect));
				}
			}
		}

		if (entityplayer == null || !entityplayer.capabilities.isCreativeMode) {
			--stack.stackSize;
			if (stack.stackSize <= 0) {
				return new ItemStack(Items.GLASS_BOTTLE);
			}

			if (entityplayer != null) {
				entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
			}
		}
		return stack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.setActiveHand(hand);
		return new ActionResult<>(EnumActionResult.SUCCESS, itemStackIn);
	}

	@SideOnly (Side.CLIENT)
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
		BrewRegistry.getBrews().stream().filter(brew -> brew.getType() == BrewRegistry.Brew.DRINK).forEach(brew -> {
			BrewEffect effect = BrewRegistry.getDefaults().get(brew);
			subItems.add(BrewUtils.createBrew(itemIn, effect.getBrew(), effect.getDuration(), effect.isInstant()));
		});
	}
}
