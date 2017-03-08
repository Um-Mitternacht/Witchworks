package com.wiccanarts.common.block.ore;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;


/**
 * Created by BerciTheBeast on 4.3.2017.
 */
public class BlockOre extends WorldGenMinable implements IWorldGenerator {

	private int minOreVeinSize;
	private int maxOreVeinSize;
	private int minHeight;
	private int maxHeight;
	private int genChance;
	private IBlockState oreToGen;
	private Predicate<IBlockState> predicate;

	public BlockOre(Block block, int minVeinSize, int maxVeinSize, int minHeight, int maxHeight, int generationChance, Block surrounding){
		super(block.getDefaultState(), minVeinSize);
		this.oreToGen = block.getDefaultState();
		this.minOreVeinSize = minVeinSize;
		this.maxOreVeinSize = maxVeinSize;
		this.maxHeight = maxHeight;
		this.minHeight = minHeight;
		this.genChance = generationChance;
		this.predicate = BlockMatcher.forBlock(surrounding);

	}

	public BlockOre(IBlockState blockState, int minVeinSize, int maxVeinSize, int minHeight, int maxHeight, int generationChance, Predicate<IBlockState> surround){
		super(blockState, minVeinSize);
		this.oreToGen = blockState;
		this.minOreVeinSize = minVeinSize;
		this.maxOreVeinSize = maxVeinSize;
		this.maxHeight = maxHeight;
		this.minHeight = minHeight;
		this.genChance = generationChance;
		this.predicate = surround;

	}

	public BlockOre(Block block, int min, int plusRand) {
		this(block, min, min+plusRand, 10, 30, 4, Blocks.STONE);
	}

	public BlockOre(Block block){
		this(block, 4, 3);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionType()){
			case OVERWORLD:
				generateOverworld(world, random, chunkX, chunkZ);
			break;
		}
	}

	public void generateOverworld(World world, Random random, int chunkX, int chunkZ){
		generateOre(oreToGen, world, random, chunkX, chunkZ, minOreVeinSize, maxOreVeinSize, genChance, minHeight, maxHeight, predicate);
	}

	public void generateOre(IBlockState blockToGen, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Predicate<IBlockState> generateInBlocks){
		int heightRange = maxY - minY;
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		WorldGenMinable generator = new WorldGenMinable(blockToGen, veinSize, generateInBlocks);

		for(int i = 0; i < chance; ++i) {
			int xRandom = chunkX * 16 + random.nextInt(16);
			int yRandom = random.nextInt(heightRange) + minY;
			int zRandom = chunkZ * 16 + random.nextInt(16);
			generator.generate(world, random, new BlockPos(xRandom, yRandom, zRandom));
		}
	}
}
