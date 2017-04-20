package com.wiccanarts.common.block.tile;

import com.wiccanarts.api.KettleRegistry;
import com.wiccanarts.api.recipe.*;
import com.wiccanarts.api.recipe.PotionHolder.HolderType;
import com.wiccanarts.api.sound.WiccaSoundEvents;
import com.wiccanarts.client.fx.ParticleF;
import com.wiccanarts.common.WiccanArts;
import com.wiccanarts.common.item.ModItems;
import com.wiccanarts.common.net.PacketHandler;
import com.wiccanarts.common.potions.BrewUtils;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;
import java.util.*;

/**
 * This class was created by Arekkuusu on 08/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
public class TileKettle extends TileItemInventory implements ITickable {

	private final String TAG_WATER = "waterLevel";
	private final String TAG_HEAT = "heat";
	private final String TAG_MODE = "mode";
	private final String TAG_RECIPE = "recipe";
	private final int RECIPE_IDLE = -1;
	private float[] color = new float[] {0.0f, 0.39215687f, 0.0f};
	private KettleMode mode = KettleMode.POTION;
	private int waterLevel;
	private int heat;
	private int ticks;
	private int recipeBoilingTime = RECIPE_IDLE;
	private IKettleRecipe recipe;
	private int itemTimer;

	@SuppressWarnings ("ConstantConditions")
	public void collideItem(EntityItem entityItem) {
		if (!hasWater()) return;

		final ItemStack dropped = entityItem.getEntityItem();
		if (dropped == null || entityItem.isDead)
			return;

		if (!world.isRemote) {
			if (isHot() && isEmpty()) {
				if (KettleRegistry.getKettleExchanges().containsKey(dropped.getItem())) {
					final KettleExchange exchange = KettleRegistry.getKettleExchanges().get(dropped.getItem());
					final ItemStack out = exchange.getExchange(dropped);
					if (out != null) {
						PacketHandler.sendTileUpdateNearbyPlayers(this);
						setWaterLevel(0);
						fancySplash();

						dropped.stackSize--;
						if (dropped.stackSize == 0)
							entityItem.setDead();

						final double x = getPos().getX();
						final double y = getPos().getY() + 1D;
						final double z = getPos().getZ();
						final EntityItem item = new EntityItem(world, x + 0.5D, y, z + 0.5D, out);
						item.motionX = world.rand.nextDouble() * 2 - 1;
						item.motionZ = world.rand.nextDouble() * 2 - 1;
						item.motionY = 0.1D;
						item.setPickupDelay(0);
						world.spawnEntity(item);

						for (int i = 0; i < 4; i++) {
							PacketHandler.spawnParticle(ParticleF.STEAM, world, x + world.rand.nextFloat(), y, z + world.rand.nextFloat(), 5, 0, 0, 0);
						}

						return;
					}
				} else if (dropped.getItem() == ModItems.MANDRAKE_ROOT) {
					PacketHandler.sendTileUpdateNearbyPlayers(this);
					fancySplash();

					mode = KettleMode.CUSTOM;

					dropped.stackSize--;
					if (dropped.stackSize == 0)
						entityItem.setDead();

					return;
				}
			}

			for (int i = 0; i < getSizeInventory(); i++) {
				if (itemHandler.getItemSimulate(i) == null) {
					final ItemStack added = dropped.copy();
					added.stackSize = 1;
					itemHandler.insertItem(i, added, false);

					dropped.stackSize--;
					if (dropped.stackSize == 0)
						entityItem.setDead();

					PacketHandler.sendTileUpdateNearbyPlayers(this);
					fancySplash();
					if (loadRecipe() && !recipe.isLiquid()) {
						mode = KettleMode.ITEM;
						recipeBoilingTime = 10;
						itemTimer = 5;
					}
					break;
				}
			}
		}
	}

	private void fancySplash() {
		world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 0.1F, 1F);
		color[0] = world.rand.nextFloat();
		color[1] = world.rand.nextFloat();
		color[2] = world.rand.nextFloat();
	}

	public boolean useKettle(EntityPlayer player, EnumHand hand, ItemStack used) {
		if (!world.isRemote) {
			if (used.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)) {
				final IFluidHandler handler = used.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null);
				final FluidStack taken = new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME);
				if (waterLevel < 6) {
					final FluidStack drain = handler.drain(taken, false);

					if (drain != null && drain.getFluid() == FluidRegistry.WATER && drain.amount == Fluid.BUCKET_VOLUME) {
						world.updateComparatorOutputLevel(pos, world.getBlockState(pos).getBlock());
						handler.drain(taken, true);

						world.playSound(null, getPos(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1F, 8F);
						setWaterLevel(6);
						removeItems();
					}
				} else if (waterLevel == 6) {
					final int fill = handler.fill(taken, false);

					if (fill == Fluid.BUCKET_VOLUME) {
						world.updateComparatorOutputLevel(pos, world.getBlockState(pos).getBlock());
						handler.fill(taken, true);

						world.playSound(null, getPos(), SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1F, 8F);
						setWaterLevel(0);
						removeItems();
					}
				}
			} else if (waterLevel < 6 && used.getItem() == Items.POTIONITEM && PotionUtils.getEffectsFromStack(used).isEmpty()) {
				final ItemStack taken = new ItemStack(Items.GLASS_BOTTLE);

				giveItem(player, hand, used, taken);

				world.playSound(null, getPos(), SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1F, 8F);
				setWaterLevel(waterLevel + 1);
				removeItems();
			} else if (hasWater() && mode != KettleMode.ITEM) {
				ItemStack taken = null;
				int drain = 1;
				if (mode == KettleMode.POTION) {
					if (recipe != null && recipe.canTake(world, player, used)) {
						taken = recipe.getResult();
						drain = recipe.getDrain();
					}
				} else if (used.getItem() == Items.GLASS_BOTTLE) {
					taken = buildCustomPotion();
				}

				if (taken == null) {
					if (!isEmpty() && mode == KettleMode.CUSTOM) {
						fail();
						return false;
					} else if (used.getItem() == Items.GLASS_BOTTLE) {
						taken = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
					}
				}

				if (taken != null) {
					giveItem(player, hand, used, taken);

					world.playSound(null, getPos(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1F, 8F);
					setWaterLevel(waterLevel - drain);
				}
			}
		}
		return true;
	}

	private void giveItem(EntityPlayer player, EnumHand hand, ItemStack stack, ItemStack taken) {
		if (--stack.stackSize == 0) {
			player.setHeldItem(hand, taken);
		} else if (!player.inventory.addItemStackToInventory(taken)) {
			player.dropItem(taken, false);
		} else if (player instanceof EntityPlayerMP) {
			((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
		}
	}

	@Nullable
	public ItemStack buildCustomPotion() {
		HolderType holder = HolderType.BOTTLE;

		final List<IEffectListModifier> listMod = new ArrayList<>();
		final List<PotionEffect> tempPotions = new ArrayList<>();
		final List<IEffectModifier> tempModifiers = new ArrayList<>();
		for (int i = 0, slots = itemHandler.getSlots(); i < slots; i++) {
			final ItemStack out = itemHandler.getItemSimulate(i);

			if (out == null) break;
			if (!isModifier(out) && !isEffect(out)) {
				if (out.getItem() == Items.GUNPOWDER) {
					if (holder == HolderType.BOTTLE) {
						holder = HolderType.SPLASH;
						continue;
					}
				} else if (out.getItem() == Items.DRAGON_BREATH) {
					if (holder == HolderType.BOTTLE) {
						holder = HolderType.LINGERING;
						continue;
					}
				}
				return null;
			}

			if (isModifier(out)) {
				final PotionValidator<IEffectModifier> validator = KettleRegistry.getKettleModifiers().get(out.getItem());
				final Optional optional = validator.get(out);
				if (optional.isPresent()) {
					final IEffectModifier mod = (IEffectModifier) ((Tuple) optional.get()).getSecond();
					tempModifiers.add(mod);
					if (mod instanceof IEffectListModifier) {
						listMod.add((IEffectListModifier) mod);
					}
				}
			} else {
				final PotionValidator<PotionHolder> validator = KettleRegistry.getKettleEffects().get(out.getItem());
				final Optional optional = validator.get(out);
				if (optional.isPresent()) {
					final PotionHolder effect = ((PotionHolder) ((Tuple) optional.get()).getSecond()).copy();
					for (IEffectModifier mod : tempModifiers) {
						mod.apply(effect);
					}
					tempModifiers.clear();
					tempPotions.add(effect.getPotionEffect());
				}
			}
		}

		final Map<Potion, PotionEffect> potions = new LinkedHashMap<>();
		for (PotionEffect potion : tempPotions) {
			if (potions.containsKey(potion.getPotion())) continue;

			tempPotions.stream().filter(compared -> potion != compared && compared.getPotion() == potion.getPotion())
					.forEach(potion:: combine);

			potions.put(potion.getPotion(), potion);
		}

		Collection<PotionEffect> effects = potions.values();
		for (IEffectListModifier l : listMod) {
			effects = l.modify(effects);
		}

		return BrewUtils.createPotion(getItemHolderType(holder), effects);
	}

	private Item getItemHolderType(HolderType holder) {
		return holder == HolderType.BOTTLE ? Items.POTIONITEM : holder == HolderType.SPLASH
				? Items.SPLASH_POTION : Items.LINGERING_POTION;
	}

	private boolean isEffect(ItemStack stack) {
		return KettleRegistry.getKettleEffects().containsKey(stack.getItem());
	}

	private boolean isModifier(ItemStack stack) {
		return KettleRegistry.getKettleModifiers().containsKey(stack.getItem());
	}

	private void fail() {
		if (world instanceof WorldServer) {
			((WorldServer) world).spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, getPos().getX(), getPos().getY(), getPos().getZ(), 5
					, 0D, 0D, 0D, 0D);
		}
		world.playSound(null, getPos(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1F, 1F);

		world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(getPos()).expandXyz(2))
				.forEach(entity -> entity.attackEntityFrom(DamageSource.magic, 2));
		removeItems();
		setWaterLevel(0);
	}

	@Override
	public void update() {
		if (ticks % 2 == 0) {
			final List<EntityItem> entityItemList = world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(getPos()));
			entityItemList.forEach(this :: collideItem);
		}

		if (!world.isRemote && recipeBoilingTime == 0) {
			if (ticks % 2 == 0) {
				final float x = getPos().getX() + 0.2F + MathHelper.clamp(world.rand.nextFloat(), 0F, 0.5F);
				final float y = getPos().getY() + 0.155F + (waterLevel * 0.075F);
				final float z = getPos().getZ() + 0.2F + MathHelper.clamp(world.rand.nextFloat(), 0F, 0.5F);

				PacketHandler.spawnParticle(ParticleF.STEAM, world, x, y, z, 3, 0, 0, 0);
			}

			if (ticks % 20 == 0 && --itemTimer <= 0) {
				final float x = getPos().getX() + 0.5F;
				final float y = getPos().getY() + 0.65F;
				final float z = getPos().getZ() + 0.5F;

				if (recipe != null) {
					final EntityItem item = new EntityItem(world, x, y, z, recipe.getResult());
					world.spawnEntity(item);
					setWaterLevel(0);
				} else {
					fail();
				}
				recipeBoilingTime = RECIPE_IDLE;
			}
		}

		if (isHot() && hasWater()) {
			if (world.rand.nextInt(10) == 0) {
				final BlockPos pos = getPos();
				final float d3 = (float) pos.getX() + 0.2F + MathHelper.clamp(world.rand.nextFloat(), 0F, 0.5F);
				final float d4 = (float) pos.getY() + 0.155F + (waterLevel * 0.075F);
				final float d5 = (float) pos.getZ() + 0.2F + MathHelper.clamp(world.rand.nextFloat(), 0F, 0.5F);
				WiccanArts.proxy.spawnParticle(ParticleF.CAULDRON_BUBBLE, d3, d4, d5, 0.0D, 0.1D, 0.0D, color);
			}
			if (ticks % 60 == 0) {
				world.playSound(null, getPos(), WiccaSoundEvents.BOIL, SoundCategory.BLOCKS, 0.2F, 1F);
			}
		}

		if (!hasWater()) {
			setColor(new float[] {0.0f, 0.39215687f, 0.0f});
			if (!isEmpty()) {
				removeItems();
			}
		}

		if (ticks % 10 == 0) {
			handleRain();
			if (recipeBoilingTime > 0) {
				--recipeBoilingTime;
			}
		}

		if (!world.isRemote && ticks % 2 == 0 && !isEmpty()) {
			final float x = getPos().getX() + 0.2F + MathHelper.clamp(world.rand.nextFloat(), 0F, 0.5F);
			final float y = getPos().getY() + 0.155F + (waterLevel * 0.075F);
			final float z = getPos().getZ() + 0.2F + MathHelper.clamp(world.rand.nextFloat(), 0F, 0.5F);

			PacketHandler.spawnParticle(ParticleF.SPARK, world, x, y, z, 1, 0, 0, 0, color);
		}

		if (ticks % 20 == 0) {
			handleHeat();
		}
		++ticks;
	}

	private void removeItems() {
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			itemHandler.extractItem(i, 1, false);
		}
		mode = KettleMode.POTION;
		recipe = null;
	}

	private boolean isEmpty() {
		return itemHandler.getItemSimulate(0) == null;
	}

	private boolean loadRecipe() {
		recipe = KettleRegistry.getKettleRecipes().stream()
				.filter(kettleRecipe -> kettleRecipe.checkRecipe(itemHandler, world))
				.findFirst().orElse(null);

		return recipe != null;
	}

	private void handleHeat() {
		if (isAboveFire() && hasWater() && heat < 5) {
			++heat;
		} else if ((!isAboveFire() || !hasWater()) && heat > 0) {
			--heat;
		}
	}

	private boolean isAboveFire() {
		final IBlockState state = world.getBlockState(getPos().down());
		return state.getMaterial() == Material.FIRE;
	}

	private void handleRain() {
		if (waterLevel != 6 && world.isRainingAt(getPos().up())) {
			world.playSound(null, getPos(), SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 0.1F, 5F);
			setWaterLevel(waterLevel + 1);
			removeItems();
		}
	}

	@Override
	public int getSizeInventory() {
		return 32;
	}

	@Override
	public void writeDataNBT(NBTTagCompound cmp) {
		super.writeDataNBT(cmp);
		cmp.setInteger(TAG_WATER, waterLevel);
		cmp.setInteger(TAG_HEAT, heat);
		cmp.setString(TAG_MODE, mode.name());
		cmp.setInteger(TAG_RECIPE, KettleRegistry.getKettleRecipes().indexOf(recipe));
		cmp.setFloat("r", color[0]);
		cmp.setFloat("g", color[1]);
		cmp.setFloat("b", color[2]);
	}

	@Override
	public void readDataNBT(NBTTagCompound cmp) {
		super.readDataNBT(cmp);
		waterLevel = cmp.getInteger(TAG_WATER);
		heat = cmp.getInteger(TAG_HEAT);
		mode = KettleMode.valueOf(cmp.getString(TAG_MODE));
		color[0] = cmp.getFloat("r");
		color[1] = cmp.getFloat("g");
		color[2] = cmp.getFloat("b");

		final int index = cmp.getInteger(TAG_RECIPE);
		if (index >= 0) {
			recipe = KettleRegistry.getKettleRecipes().get(index);
		}
	}

	public int getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(int water) {
		waterLevel = water >= 6 ? 6 : water <= 0 ? 0 : water;
		PacketHandler.updateToNearbyPlayers(world, pos);
	}

	public boolean hasWater() {
		return waterLevel > 0;
	}

	public boolean isHot() {
		return heat == 5;
	}

	public KettleMode getMode() {
		return mode;
	}

	public float[] getColor() {
		return color;
	}

	public void setColor(float[] color) {
		this.color = color;
	}

	public enum KettleMode {
		ITEM,
		POTION,
		CUSTOM,
		RITUAL
	}
}
