package com.aml.core.util;

public class TrimUtil {
	/**
	 * 获得trim后的值
	 * @param params
	 * @return
	 */
	public static String trimValue(String params) {
		return params == null ? null : params.trim();
	}
}
