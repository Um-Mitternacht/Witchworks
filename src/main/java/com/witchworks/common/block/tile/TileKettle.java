package com.witchworks.common.block.tile;

import com.witchworks.api.KettleRegistry;
import com.witchworks.api.recipe.ItemValidator;
import com.witchworks.api.sound.WitchSoundEvents;
import com.witchworks.client.fx.ParticleF;
import com.witchworks.common.WitchWorks;
import com.witchworks.common.core.net.PacketHandler;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static net.minecraftforge.fluids.Fluid.BUCKET_VOLUME;

/**
 * This class was created by Arekkuusu on 08/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings ("WeakerAccess")
public class TileKettle extends TileFluidInventory implements ITickable {

	private final String TAG_HEAT = "heat";
	private final KettleFluid inv = tank();

	private Color rgb = new Color(0x194919);
	private Mode mode = Mode.NORMAL;
	private ItemStack[] ingredients = new ItemStack[64];
	private ItemStack container;
	private int heat;
	private int ticks;

	@SuppressWarnings ("ConstantConditions")
	public void collideItem(EntityItem entityItem) {
		final ItemStack dropped = entityItem.getEntityItem();
		if (dropped == null || entityItem.isDead)
			return;

		if (inv.hasFluid()) {
			if (!inv.hasFluid(FluidRegistry.LAVA)) {
				boolean splash = false;
				if (isHeat()) {
					splash = recipeDropLogic(dropped);
				}
				if (splash)
					play(SoundEvents.ENTITY_GENERIC_SPLASH, 0.5F, 0.5F);
			} else {
				play(SoundEvents.BLOCK_LAVA_EXTINGUISH, 1F, 1F);
				entityItem.setDead();
				return;
			}
			if (dropped.stackSize == 0)
				entityItem.setDead();
		}
	}

	public boolean recipeDropLogic(ItemStack dropped) {
		switch (mode) {
			case NORMAL:
				return processingLogic(dropped) || acceptIngredient(dropped);
			case POTION:
				return false;
			case CUSTOM:
				return false;
			default:
		}
		return false;
	}

	public boolean useKettle(EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem) {
		if (!world.isRemote) {
			if (heldItem == null) {
				if (getContainer() != null) {
					giveItem(player, hand, null, getContainer());
					setContainer(null);
				}
				return true;
			}
			//Held Item is not null
			if (heldItem.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null)) {
				handleLiquid(heldItem.getCapability(CapabilityFluidHandler.FLUID_HANDLER_CAPABILITY, null));
			} else if (heldItem.getItem() == Items.POTIONITEM && PotionUtils.getEffectsFromStack(heldItem).isEmpty()) {
				int level = inv.getFluidAmount();
				if (level < BUCKET_VOLUME && (inv.getFluid() == null || inv.hasFluid(FluidRegistry.WATER))) {
					play(SoundEvents.ITEM_BUCKET_FILL, 1F, 1F);
					giveItem(player, hand, heldItem, new ItemStack(Items.GLASS_BOTTLE));
					FluidStack fluidStack = new FluidStack(FluidRegistry.WATER, 250);
					inv.fill(fluidStack, true);
				}
			} else if (heldItem.getItem() == Items.GLASS_BOTTLE) {
				//TODO: Add Potion Logic here
			} else if (getContainer() == null) {
				setContainer(heldItem.copy());
				giveItem(player, hand, heldItem, null);
			}
		}
		return true;
	}

	private void handleLiquid(IFluidHandler handler) {
		if (inv.isEmpty()) {
			FluidStack drain = handler.drain(BUCKET_VOLUME, false);

			if (drain != null && drain.amount <= BUCKET_VOLUME) {
				handler.drain(drain.amount, true);
				inv.setFluid(drain);
				onLiquidChange();

				play(drain.getFluid().getEmptySound(), 1F, 1F);
			}
		} else {
			if (inv.isFull()) {
				FluidStack fill = inv.drain(BUCKET_VOLUME, false);
				FluidStack compare = handler.drain(BUCKET_VOLUME, false);
				int filled = handler.fill(fill, false);

				if (fill != null && (compare == null || fill.isFluidEqual(compare)) && filled <= BUCKET_VOLUME) {
					handler.fill(fill, true);
					inv.drain(filled, true);

					play(fill.getFluid().getEmptySound(), 1F, 1F);
				}
			} else {
				FluidStack drain = handler.drain(BUCKET_VOLUME, false);

				if (drain != null && drain.isFluidEqual(inv.getFluid()) && drain.amount <= BUCKET_VOLUME) {
					handler.drain(drain.amount, true);
					inv.fill(drain, true);

					play(drain.getFluid().getFillSound(), 1F, 1F);
				}
			}
		}
	}

	private void giveItem(EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, @Nullable ItemStack toGive) {
		if (heldItem == null || --heldItem.stackSize == 0) {
			player.setHeldItem(hand, toGive);
		} else if (!player.inventory.addItemStackToInventory(toGive)) {
			player.dropItem(toGive, false);
		} else if (player instanceof EntityPlayerMP) {
			((EntityPlayerMP) player).sendContainerToPlayer(player.inventoryContainer);
		}
	}

	@Override
	public void update() {
		if (!world.isRemote && ticks % 2 == 0) {
			final List<EntityItem> entityItemList = world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(getPos()));
			entityItemList.forEach(this :: collideItem);
		}

		if (inv.hasFluid()) {
			if (!inv.hasFluid(FluidRegistry.LAVA) && isHeat()) {
				handleParticles();
				if (ticks % 60 == 0) {
					play(WitchSoundEvents.BOIL, 0.1F, 1F);
				}
			} else if (ticks % 5 == 0 && world.rand.nextInt(20) == 0) {
				play(SoundEvents.BLOCK_LAVA_AMBIENT, 1F, 1F);
			}
		}

		if (ticks % 20 == 0) {
			handleHeat();
		}

		++ticks;
	}

	private void handleParticles() {
		if (world.rand.nextInt(10) == 0) {
			float x = getPos().getX();

			float z = getPos().getZ();
			for (int i = 0; i < 4; i++) {
				final float posX = x + MathHelper.clamp(world.rand.nextFloat(), 0.2F, 0.9F);
				final float posY = getParticleLevel();
				final float posZ = z + MathHelper.clamp(world.rand.nextFloat(), 0.2F, 0.9F);
				WitchWorks.proxy.spawnParticle(ParticleF.CAULDRON_BUBBLE, posX, posY, posZ, 0.0D, 0.01D, 0.0D, getColorRGB().getRGB());
			}
		}
		if (hasIngredients() && ticks % 2 == 0) {
			final float x = getPos().getX() + MathHelper.clamp(world.rand.nextFloat(), 0.2F, 0.9F);
			float y = getParticleLevel();
			final float z = getPos().getZ() + MathHelper.clamp(world.rand.nextFloat(), 0.2F, 0.9F);
			WitchWorks.proxy.spawnParticle(ParticleF.SPARK, x, y, z, 0.0D, 0.1D, 0.0D);
		}
	}

	private void handleHeat() {
		boolean aboveFire = world.getBlockState(getPos().down()).getMaterial() == Material.FIRE;
		if (aboveFire && inv.getFluidAmount() > 0 && heat < 10) {
			++heat;
		} else if ((!aboveFire || !(inv.getFluidAmount() > 0)) && heat > 0) {
			--heat;
		}
	}

	@Override
	void writeDataNBT(NBTTagCompound cmp) {
		saveItems(cmp);
		cmp.setInteger(TAG_HEAT, heat);
		cmp.setInteger("rgb", getColorRGB().getRGB());
	}

	private void saveItems(NBTTagCompound cmp) {
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < ingredients.length; ++i) {
			if (ingredients[i] != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("slot", (byte) i);

				ingredients[i].writeToNBT(tag);
				nbttaglist.appendTag(tag);
			}
		}

		if (container != null) {
			container.writeToNBT(cmp);
		}
		cmp.setTag("ingredients", nbttaglist);
	}

	@Override
	void readDataNBT(NBTTagCompound cmp) {
		loadItems(cmp);
		heat = cmp.getInteger(TAG_HEAT);
		if (cmp.hasKey("rgb"))
			setColorRGB(new Color(cmp.getInteger("rgb")));
	}

	private void loadItems(NBTTagCompound cmp) {
		NBTTagList nbttaglist = cmp.getTagList("ingredients", 10);
		ingredients = new ItemStack[64];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("slot");

			if (j >= 0 && j < ingredients.length) {
				this.ingredients[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}

		container = ItemStack.loadItemStackFromNBT(cmp);
	}

	@SuppressWarnings ("ConstantConditions")
	@Override
	void onLiquidChange() {
		ingredients = new ItemStack[64];
		mode = Mode.NORMAL;
		if (inv.getInnerFluid() == FluidRegistry.WATER) {
			setColorRGB(new Color(0x194919));
		}
		PacketHandler.updateToNearbyPlayers(world, pos);
	}

	public boolean acceptIngredient(ItemStack stack) {
		if (ingredients[ingredients.length - 1] == null) {
			addIngredient(stack);
			final float hue = world.rand.nextFloat();
			final float saturation = (world.rand.nextInt(2000) + 1000) / 10000f;
			final float luminance = 0.5f;
			setColorRGB(Color.getHSBColor(hue, saturation, luminance));
			PacketHandler.updateToNearbyPlayers(world, pos);
			return true;
		}
		return false;
	}

	public void addIngredient(ItemStack stack) {
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] == null) {
				ingredients[i] = stack.copy();
				stack.stackSize = 0;
				break;
			}
		}
	}

	public boolean isHeat() {
		return heat == 10;
	}

	public Optional<FluidStack> getFluid() {
		FluidStack stack = inv.getFluid();
		return stack != null ? Optional.of(stack) : Optional.empty();
	}

	public boolean hasIngredients() {
		return ingredients[0] != null;
	}

	public Color getColorRGB() {
		return rgb;
	}

	public void setColorRGB(Color rgb) {
		this.rgb = rgb;
	}

	public float getParticleLevel() {
		float level = (float) inv.getFluidAmount() / (Fluid.BUCKET_VOLUME * 2F);
		return getPos().getY() + 0.1F + level;
	}

	@Nullable
	public ItemStack getContainer() {
		return container;
	}

	public void setContainer(@Nullable ItemStack container) {
		this.container = container;
		world.updateComparatorOutputLevel(pos, world.getBlockState(pos).getBlock());
		PacketHandler.updateToNearbyPlayers(world, pos);
	}

	//------------------------------------Crafting Logic------------------------------------//

	@SuppressWarnings ("ConstantConditions")
	public boolean processingLogic(ItemStack stack) {
		if (!isHeat() || hasIngredients()) return false;
		Map<Item, ItemValidator<ItemStack>> processing = KettleRegistry.getKettleProcessing(inv.getInnerFluid());
		if (processing != null && processing.containsKey(stack.getItem())) {
			ItemValidator<ItemStack> validator = processing.get(stack.getItem());
			Optional<ItemStack> optional = validator.getMatchFor(stack);
			if (optional.isPresent()) {
				ItemStack out = optional.get().copy();
				if (stack.isItemDamaged() && out.isItemStackDamageable())
					out.setItemDamage(stack.getItemDamage());
				out.stackSize = 0;
				int fluid = inv.getFluidAmount();
				int taken = 0;

				if (stack.stackSize <= 16) {
					taken = 250;
					out.stackSize = stack.stackSize;
					stack.stackSize = 0;
				} else {
					while (stack.stackSize > 0 && taken <= fluid) {
						--stack.stackSize;
						++out.stackSize;
						if (out.stackSize % 16 == 0)
							taken += 250;
					}
				}

				if (out.stackSize > 0) {
					final double x = getPos().getX();
					final double y = getPos().getY() + 1D;
					final double z = getPos().getZ();
					final EntityItem item = new EntityItem(world, x + 0.5D, y, z + 0.5D, out);
					item.motionX = world.rand.nextDouble() * 2 - 1;
					item.motionZ = world.rand.nextDouble() * 2 - 1;
					item.motionY = 0.1D;
					item.setPickupDelay(0);
					world.spawnEntity(item);

					play(SoundEvents.BLOCK_FIRE_EXTINGUISH, 1F, 1F);
					for (int i = 0; i < 4; i++) {
						PacketHandler.spawnParticle(ParticleF.STEAM, world, x + world.rand.nextFloat(), y, z + world.rand.nextFloat(), 5, 0, 0, 0);
					}

					inv.drain(taken, true);
					return true;
				}
			}
		}
		return false;
	}

	public enum Mode {
		NORMAL,
		RITUAL,
		POTION,
		CUSTOM
	}
}
