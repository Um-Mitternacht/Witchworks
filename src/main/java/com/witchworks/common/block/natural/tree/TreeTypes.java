package com.witchworks.common.block.natural.tree;

import net.minecraft.util.IStringSerializable;

public class TreeTypes {

	public static enum SaplingTypes implements IStringSerializable {
		CYPRESS("cypress", 0),
		OLIVE("olive", 1),
		YEW("yew", 2),
		ALDER("alder", 3),
		ROWAN("rowan", 4),
		HAWTHORN("hawthorn", 5);

		private int ID;
		private String name;

		private SaplingTypes(String name, int ID) {
			this.ID = ID;
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public int getID() {
			return ID;
		}

		@Override
		public String toString() {
			return super.toString();
		}
	}
}