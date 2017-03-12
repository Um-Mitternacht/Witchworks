package com.wiccanarts.common.block.tile;

import com.wiccanarts.common.net.PacketHandler;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * This class was created by Arekkuusu on 08/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class TileKettle extends TileMod implements ITickable {

	private static final String TAG_WATER = "waterLevel";
	private static final String TAG_HEAT = "heat";
	private float[] colors = new float[]{0.0f, 0.39215687f, 0.0f};
	private int waterLevel;
	private int heat;
	private int tickCount;
	private World worldObj;

	public TileKettle() {
		this.worldObj = worldObj;
	}

	public void collideItem(EntityItem entityItem) {
		if (!hasWater()) return;

		ItemStack stack = entityItem.getEntityItem();
		if (stack == null || entityItem.isDead)
			return;

		if (!worldObj.isRemote) {
			PacketHandler.sendTileUpdateNearbyPlayers(this);
			updateRecipe(stack.copy());
			fancySplash();

			stack.stackSize--;
			if (stack.stackSize == 0)
				entityItem.setDead();
		}

		worldObj.playSound(null, pos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 0.1F, 8F);
		float r = worldObj.rand.nextFloat();
		float g = worldObj.rand.nextFloat();
		float b = worldObj.rand.nextFloat();
		colors[0] = r;
		colors[1] = g;
		colors[2] = b;
	}

	private void fancySplash() {
		if (worldObj instanceof WorldServer) {
			for (int i = 0; i < 10; i++) {
				BlockPos pos = getPos();
				Random rand = new Random();
				float d3 = (pos.getX() + rand.nextFloat());
				float d4 = (float) (pos.getY() + 1);
				float d5 = (pos.getZ() + rand.nextFloat());
				((WorldServer) worldObj).spawnParticle(EnumParticleTypes.CRIT_MAGIC, d3, d4, d5, 1, 0, 0, 0, 0D);
			}
		}
	}

	private void updateRecipe(ItemStack stack) {
		//TODO: Check the recipe here, update the output each time a recipe matches
	}

	public boolean handleWater(@Nullable EntityPlayer player, EnumHand hand, ItemStack stack) {
		if (stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)) {
			IFluidHandler fluidHandler = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
			if (waterLevel < 6) {
				FluidStack drainWater = fluidHandler.drain(new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME), false);

				if (drainWater != null && drainWater.getFluid() == FluidRegistry.WATER
						&& drainWater.amount == Fluid.BUCKET_VOLUME) {
					if (player != null)
						worldObj.playSound(player, player.getPosition(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.PLAYERS, 1.0F, 5F);

					fluidHandler.drain(new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME), true);
					setWaterLevel(6);
					worldObj.updateComparatorOutputLevel(pos, worldObj.getBlockState(pos).getBlock());

					colors = new float[]{0.0f, 0.39215687f, 0.0f};
				}
			} else if (waterLevel == 6) {
				int fill = fluidHandler.fill(new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME), false);

				if (fill == Fluid.BUCKET_VOLUME) {
					if (player != null)
						worldObj.playSound(player, player.getPosition(), SoundEvents.ITEM_BUCKET_FILL, SoundCategory.PLAYERS, 1.0F, 5F);

					fluidHandler.fill(new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME), true);
					setWaterLevel(0);
					worldObj.updateComparatorOutputLevel(pos, worldObj.getBlockState(pos).getBlock());
				}
			}
		} else if (!worldObj.isRemote && stack.getItem() == Items.GLASS_BOTTLE && waterLevel > 0) {
			if (player != null && !player.capabilities.isCreativeMode) {
				ItemStack potion = getPotionFromRecipe();

				if (--stack.stackSize == 0) {
					player.setHeldItem(hand, potion);
				} else if (!player.inventory.addItemStackToInventory(potion)) {
					player.dropItem(potion, false);
				} else if (player instanceof EntityPlayerMP) {
					((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
				}
			}

			if (player != null)
				worldObj.playSound(player, player.getPosition(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.PLAYERS, 1.0F, 5F);
			setWaterLevel(waterLevel - 1);
		}
		return true;
	}

	private ItemStack getPotionFromRecipe() {
		//TODO: Return the correct potion from recipe when player uses a Bottle
		return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
	}

	@Override
	void writeDataNBT(NBTTagCompound cmp) {
		cmp.setInteger(TAG_WATER, waterLevel);
		cmp.setInteger(TAG_HEAT, heat);
	}

	@Override
	void readDataNBT(NBTTagCompound cmp) {
		waterLevel = cmp.getInteger(TAG_WATER);
		heat = cmp.getInteger(TAG_HEAT);
	}

	public int getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(int water) {
		waterLevel = water;
		PacketHandler.updateToNearbyPlayers(worldObj, pos);
	}

	public boolean hasWater() {
		return waterLevel > 0;
	}

	public boolean isHot() {
		return heat == 5;
	}

	public float[] getColor() {
		return colors;
	}

	@Override
	public void update() {
		List<EntityItem> entityItemList = worldObj.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(getPos()));
		entityItemList.forEach(this::collideItem);

		if (worldObj.rand.nextInt(10) == 0 && isHot() && hasWater() && worldObj.isRemote) {
			BlockPos pos = getPos();
			float d3 = ((float) pos.getX() + getWorld().rand.nextFloat());
			float d4 = ((float) pos.getY() + 0.65F);
			float d5 = ((float) pos.getZ() + getWorld().rand.nextFloat());
			worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, d3, d4, d5, 0.0D, 0.1D, 0.0D);
			worldObj.playSound(null, getPos(), SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 1.0F, 5F);
		}

		if (tickCount % 10 == 0) {
			handleRain();
		}

		if (tickCount % 20 == 0) {
			handleHeat();
		}
		++tickCount;
	}

	private void handleHeat() {
		if (isAboveFire() && heat < 5) {
			++heat;
		} else if (!isAboveFire() && heat > 0) {
			--heat;
		}
	}

	private boolean isAboveFire() {
		IBlockState state = worldObj.getBlockState(getPos().down());

		return state.getMaterial() == Material.FIRE;
	}

	private void handleRain() {
		if (waterLevel != 6 && worldObj.isRainingAt(getPos().up())) {
			Random rand = new Random();
			if (worldObj.isRemote) {
				for (int i = 0; i < 4; i++) {
					double d3 = pos.getX() + rand.nextFloat();
					double d4 = pos.getY() + 0.65F;
					double d5 = pos.getZ() + rand.nextFloat();
					worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, d3, d4, d5, 0.0D, 0.0D, 0.0D);
				}
			}
			worldObj.playSound(null, getPos(), SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 0.2F, 5F);
			setWaterLevel(waterLevel + 1);
		}
	}
}
