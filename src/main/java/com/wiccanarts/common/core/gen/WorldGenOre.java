package com.wiccanarts.common.core.gen;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by BerciTheBeast on 4.3.2017.
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class WorldGenOre extends WorldGenMinable implements IWorldGenerator {

	private final Set<DimensionType> dimensionList = new HashSet<>();

	private BlockMatcher predicate;
	private IBlockState oreToGen;
	private int minOreVeinSize;
	private int maxOreVeinSize;
	private int minHeight;
	private int maxHeight;
	private int genChance;

	public WorldGenOre(Block block, DimensionType... dimensionTypes) {
		this(block.getDefaultState(), 4, 3, 10, 30, 4, Blocks.STONE, dimensionTypes);
	}

	public WorldGenOre(Block block, int minVeinSize, int maxVeinSize, DimensionType... dimensionTypes) {
		this(block.getDefaultState(), minVeinSize, maxVeinSize, 10, 30, 4, Blocks.STONE, dimensionTypes);
	}

	public WorldGenOre(Block block, int minVeinSize, int maxVeinSize, int minHeight, int maxHeight, int generationChance, Block surrounding, DimensionType... dimensionTypes) {
		this(block.getDefaultState(), minVeinSize, maxVeinSize, minHeight, maxHeight, generationChance, surrounding, dimensionTypes);
	}

	public WorldGenOre(IBlockState blockState, int minVeinSize, int maxVeinSize, int minHeight, int maxHeight, int generationChance, Block surrounding, DimensionType... dimensionTypes) {
		super(blockState, minVeinSize);
		this.oreToGen = blockState;
		this.minOreVeinSize = minVeinSize;
		this.maxOreVeinSize = maxVeinSize;
		this.maxHeight = maxHeight;
		this.minHeight = minHeight;
		this.genChance = generationChance;
		this.predicate = BlockMatcher.forBlock(surrounding);
		if (dimensionTypes == null) {
			dimensionList.add(DimensionType.OVERWORLD);
		} else {
			Collections.addAll(dimensionList, dimensionTypes);
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (dimensionList.contains(world.provider.getDimensionType())) {
			generateOre(oreToGen, world, random, chunkX, chunkZ, minOreVeinSize, maxOreVeinSize, genChance, minHeight, maxHeight, predicate);
		}
	}

	private void generateOre(IBlockState blockToGen, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, BlockMatcher generateInBlocks) {
		int heightRange = maxY - minY;
		int randFactor = (maxVeinSize - minVeinSize) > 0 ? random.nextInt(maxVeinSize - minVeinSize) : 0;
		int veinSize = minVeinSize + randFactor;
		WorldGenMinable generator = new WorldGenMinable(blockToGen, veinSize, generateInBlocks);

		for (int i = 0; i < chance; ++i) {
			int xRandom = chunkX * 16 + random.nextInt(16);
			int yRandom = random.nextInt(heightRange) + minY;
			int zRandom = chunkZ * 16 + random.nextInt(16);
			generator.generate(world, random, new BlockPos(xRandom, yRandom, zRandom));
		}
	}
}
