package com.witchworks.common.core.gen;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * This class was created by BerciTheBeast on 4.3.2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
public class WorldGenOre extends WorldGenMinable implements IWorldGenerator {

	private final int[] dim;
	private final BlockMatcher predicate;
	private final IBlockState oreToGen;
	private final int minOreVeinSize;
	private final int maxOreVeinSize;
	private final int minHeight;
	private final int maxHeight;
	private final int genChance;

	WorldGenOre(Block block, int minVeinSize, int maxVeinSize, int minHeight, int maxHeight, int generationChance, Block surrounding, int[] dim) {
		super(block.getDefaultState(), minVeinSize);
		this.oreToGen = block.getDefaultState();
		this.minOreVeinSize = minVeinSize;
		this.maxOreVeinSize = maxVeinSize;
		this.maxHeight = maxHeight;
		this.minHeight = minHeight;
		this.genChance = generationChance;
		this.predicate = BlockMatcher.forBlock(surrounding);
		this.dim = dim;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		for (int i : dim) {
			if (i == world.provider.getDimensionType().getId()) {
				generateOre(world, random, chunkX, chunkZ);
			}
		}
	}

	private void generateOre(World world, Random random, int chunkX, int chunkZ) {
		final int heightRange = maxHeight - minHeight;
		final int randFactor = (maxOreVeinSize - minOreVeinSize) > 0 ? random.nextInt(maxOreVeinSize - minOreVeinSize) : 0;
		final int veinSize = minOreVeinSize + randFactor;
		final WorldGenMinable generator = new WorldGenMinable(oreToGen, veinSize, predicate);

		for (int i = 0; i < genChance; ++i) {
			final int xRandom = chunkX * 16 + random.nextInt(16);
			final int yRandom = random.nextInt(heightRange) + minHeight;
			final int zRandom = chunkZ * 16 + random.nextInt(16);
			generator.generate(world, random, new BlockPos(xRandom, yRandom, zRandom));
		}
	}

	public static class OreGenBuilder {

		private Block ore;
		private Block container;
		private int minOreVeinSize;
		private int maxOreVeinSize;
		private int minHeight;
		private int maxHeight;
		private int genChance;
		private int[] dimensions;

		private OreGenBuilder(Block block, int genChance) {
			this.ore = block;
			this.genChance = genChance;
		}

		public static OreGenBuilder forOre(Block block, int genChance) {
			return new OreGenBuilder(block, genChance);
		}

		public OreGenBuilder generateOn(Block block) {
			this.container = block;
			return this;
		}

		public OreGenBuilder setVeinSize(int min, int max) {
			this.minOreVeinSize = min;
			this.maxOreVeinSize = max;
			return this;
		}

		public OreGenBuilder setHeightRange(int min, int max) {
			this.minHeight = min;
			this.maxHeight = max;
			return this;
		}

		public OreGenBuilder setDimension(int... dims) {
			this.dimensions = dims;
			return this;
		}

		public WorldGenOre build() {
			return new WorldGenOre(ore, minOreVeinSize, maxOreVeinSize, minHeight, maxHeight, genChance, container, dimensions);
		}
	}
}
