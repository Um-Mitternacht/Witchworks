package wiccanArts.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import wiccanArts.lib.Strings;

/**
 * Created by Joseph on 2/25/2017.
 */
public class BlockMoldaviteOre extends Block {

    public BlockMoldaviteOre(){
        super(Material.ROCK);
        setUnlocalizedName(Strings.MOLDAVITE_ORE);
        setRegistryName(Strings.MOLDAVITE_ORE);
        setHardness(1.0F);
        setSoundType(SoundType.STONE);
    }
}
