package wiccanArts.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import wiccanArts.lib.Strings;

/**
 * Created by Joseph on 2/25/2017.
 */
public class BlockMoldaviteOre extends Block {

    public BlockMoldaviteOre(IBlockState state){
        super(Material.ROCK);
        setUnlocalizedName(Strings.MOLDAVITE_ORE);
        setRegistryName(Strings.MOLDAVITE_ORE);
        setHardness(1.0F);
        setHarvestLevel("pickaxe", 1, state);
        setSoundType(SoundType.STONE);
    }
}
