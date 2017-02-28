package com.wiccanarts.api.enums;

import net.minecraft.util.IStringSerializable;

/**
 * Created by Joseph on 2/27/2017.
 */
public enum WAOres implements IStringSerializable {
    AMETHYST, NUUMMITE, MOLDAVITE, SERPENTINE, ALEXANDRITE, OVERQUARTZ, GARNET, JASPER, MALACHITE, TOURMALINE, TIGERSEYE, PETOSKEYSTONE, BLOODSTONE, SALT, SILVER, CHIMAERICMETAL;

    public String getName() {
        return this.name().toLowerCase();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
