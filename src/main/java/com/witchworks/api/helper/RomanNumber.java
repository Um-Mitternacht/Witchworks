package com.witchworks.api.helper;

import java.util.TreeMap;

/**
 * This class was created by Arekkuusu on 22/05/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class RomanNumber {

	private static final TreeMap<Integer, String> map = new TreeMap<>();

	static {
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
	}

	private RomanNumber() {
	}

	public static String getRoman(int number) {
		int l = map.floorKey(number);
		if (number == 1) {
			return map.get(number);
		}
		return map.get(l) + getRoman(number - 1);
	}
}
