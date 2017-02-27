/**
 * This class was created by <ArekkuusuJerii>. It's distributed as
 * part of the Grimoire Of Alice Mod. Get the Source Code in github:
 * https://github.com/ArekkuusuJerii/Grimore-Of-Alice
 *
 * Grimore Of Alice is Open Source and distributed under the
 * Grimore Of Alice license: https://github.com/ArekkuusuJerii/Grimore-Of-Alice/blob/master/LICENSE.md
 */
package com.wiccanarts.common.item;

import com.wiccanarts.common.WiccanArts;
import net.minecraft.item.Item;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class ItemMod extends Item {

	public ItemMod(String id) {
		super();
		setRegistryName(id);
		setUnlocalizedName(id);
		setCreativeTab(WiccanArts.CREATIVE_TAB);
	}
}
