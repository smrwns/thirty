package com.smrwns.thirty.common.util;

import java.util.List;
import java.util.Set;

public class ValidationUtils {
	
	private ValidationUtils() {}

	public static boolean isNull(Object obj) {
		if (obj == null)
			return true;
		else
			return false;
	}

	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	public static boolean isNull(List<?> list) {
		if (list.isEmpty() || list == null)
			return true;
		return false;
	}

	public static boolean isNull(Set<?> set) {
		if (set.isEmpty() || set == null)
			return true;
		return false;
	}

	public static boolean isNull(Object... objs) {
		for (Object obj : objs) {
			if (isNull(obj))
				return true;
		}
		return false;
	}

	public static boolean isNotNull(Object... objs) {
		return !isNull(objs);
	}

	public static boolean isEmpty(Object obj) {
		return isNull(obj) || "".equals(obj.toString().trim());
	}

	public static boolean isEmpty(Object... objs) {
		for (Object obj : objs) {
			if (isEmpty(obj))
				return true;
		}
		return false;
	}

	public static boolean containsNull(Object[] objects) {
		for (Object object : objects) {
			if (isNull(object)) {
				return true;
			}
		}

		return false;
	}

	public static boolean containsEmpty(Object[] objects) {
		for (Object object : objects) {
			if (isEmpty(object)) {
				return true;
			}
		}

		return false;
	}

	public static boolean contains(Object[] objects, Object obj) {
		if (obj == null)
			return false;

		for (Object object : objects) {
			if (obj.equals(object)) {
				return true;
			}
		}

		return false;
	}
}