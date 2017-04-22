package com.wiccanarts.common.block.tile;

import com.wiccanarts.client.gui.container.ContainerApiary;
import com.wiccanarts.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 16/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class TileApiary extends TileEntityLockable implements ITickable, ISidedInventory {

	private static final int[] SLOT_TOP = new int[] {0};
	private static final int[] SLOT_BOTTOM = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
	private static final int GEN = 1000;
	private ItemStack[] itemStacks = new ItemStack[19];
	private String customName;
	private int flowerCount;
	private int tick;

	public static void registerFixesFurnace(DataFixer fixer) {
		fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists("Apiary", "Items"));
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.UP ? SLOT_TOP : SLOT_BOTTOM;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return direction == EnumFacing.UP && isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return direction == EnumFacing.DOWN && index > 0;
	}

	@Override
	public int getSizeInventory() {
		return itemStacks.length;
	}

	@Nullable
	@Override
	public ItemStack getStackInSlot(int index) {
		return itemStacks[index];
	}

	@Nullable
	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(itemStacks, index, count);
	}

	@Nullable
	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(itemStacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
		final boolean flag = stack != null && stack.isItemEqual(this.itemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.itemStacks[index]);
		this.itemStacks[index] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}

		if (index == 0 && !flag) {
			this.markDirty();
		}
	}

	public void dropItems() {
		for (int i = 0; i < this.itemStacks.length; ++i) {
			final ItemStack stack = itemStacks[i];
			if (!world.isRemote && stack != null) {
				final EntityItem item = new EntityItem(world, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, stack);
				world.spawnEntity(item);
			}
			itemStacks[i] = null;
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {

	}

	@Override
	public void closeInventory(EntityPlayer player) {

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return index == 0 ? stack.getItem() == ModItems.BEE
				: stack.getItem() == ModItems.HONEYCOMB
				|| stack.getItem() == ModItems.EMPTY_HONEYCOMB
				|| stack.getItem() == ModItems.BEE;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.itemStacks.length; ++i) {
			this.itemStacks[i] = null;
		}
	}

	@Override
	public void update() {
		if (!world.isRemote) {
			++tick;
			final ItemStack bee = getStackInSlot(0);
			if (bee != null && bee.getItemDamage() < 35) {
				lookForFlowers();
				if (flowerCount > 0) {
					if (world.rand.nextInt(3) == 0 && tick % (GEN - flowerCount * 3) == 0) {
						for (int i = 1; i < itemStacks.length; i++) {
							if (getStackInSlot(i) == null) {
								bee.attemptDamageItem(1, world.rand);
								bonemealArea();

								itemStacks[i] = randomItem();
								break;
							}
						}
					}
					flowerCount = 0;
				}
			}
		}
	}

	private void lookForFlowers() {
		getArea().forEach(
				pos -> {
					final Block block = world.getBlockState(pos).getBlock();
					if ((block instanceof BlockCrops) || block == Blocks.RED_FLOWER || block == Blocks.YELLOW_FLOWER) {
						if (++flowerCount > 200) flowerCount = 200;
					}
				}
		);
	}

	private void bonemealArea() {
		getArea().forEach(
				pos -> {
					final IBlockState state = world.getBlockState(pos);
					if (state.getBlock() instanceof BlockCrops && world.rand.nextInt(400 - flowerCount) == 0) {
						if (((BlockCrops) state.getBlock()).canGrow(world, pos, state, false)) {
							((BlockCrops) state.getBlock()).grow(world, world.rand, pos, state);
						}
					}
				}
		);
	}

	private Iterable<BlockPos> getArea() {
		final BlockPos posI = getPos().add(-5, -5, -5);
		final BlockPos posF = getPos().add(5, 5, 5);
		return BlockPos.getAllInBox(posI, posF);
	}

	private ItemStack randomItem() {
		final Item item = world.rand.nextBoolean()
				? (world.rand.nextInt(8) == 0 ? ModItems.BEE : ModItems.HONEYCOMB)
				: ModItems.EMPTY_HONEYCOMB;
		return new ItemStack(item);
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerApiary(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return "wiccanarts:apiary";
	}

	public String getName() {
		return this.hasCustomName() ? this.customName : new TextComponentTranslation("container.apiary").getFormattedText();
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.isEmpty();
	}

	public void setCustomInventoryName(String name) {
		this.customName = name;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		final NBTTagList nbttaglist = compound.getTagList("Items", 10);
		this.itemStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			final NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
			final int j = nbttagcompound.getByte("Slot");

			if (j >= 0 && j < this.itemStacks.length) {
				this.itemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		final NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.itemStacks.length; ++i) {
			if (this.itemStacks[i] != null) {
				final NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}

		compound.setTag("Items", nbttaglist);

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}

		return compound;
	}
}
