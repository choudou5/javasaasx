package cn.org.rapid_framework.generator.util;

public class ArrayHelper {

	public static String getValue(String[] array, int indexOf) {
		return getValue(array, indexOf,null);
	}
	
	public static String getValue(String[] array, int indexOf, String defaultValue) {
		if(array.length - 1 >= indexOf) {
			return array[indexOf];
		}
		return defaultValue;
	}

	public static boolean contains(String[] array, String str) {
		if(str == null) return false;
		if(array == null) throw new IllegalArgumentException("'array' must be not null");
		for(String text : array) {
			if(text.equals(str)) {
				return true;
			}
		}
		return false;
	}
	
}
