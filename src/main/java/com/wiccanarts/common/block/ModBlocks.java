package com.wiccanarts.common.block;

import com.wiccanarts.common.crafting.VanillaCrafting;
import com.wiccanarts.common.lib.LibMod;

import static net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@ObjectHolder(LibMod.MOD_ID)
public final class ModBlocks {

    public static void init() {
        VanillaCrafting.blocks();
    }

    public static void initOreDictionary() {
    }
}
