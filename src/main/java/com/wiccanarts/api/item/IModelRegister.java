package com.wiccanarts.api.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public interface IModelRegister {
	@SideOnly (Side.CLIENT)
	void registerModels();
}
