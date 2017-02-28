package com.wiccanarts.common.core.handler;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ModSounds {

    public static void preInit() {
        //registerSound(ResourceLocationsAPI.TEST_SOUND);
    }

    private static void registerSound(ResourceLocation soundNameIn) {
        GameRegistry.register(new SoundEvent(soundNameIn), soundNameIn);
    }
}
