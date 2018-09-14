package com.demohot.subject.utils;

import com.alibaba.fastjson.JSON;

public class StringUtils {
	
	public static String toJsonString(Object obj) {
		return JSON.toJSONString(obj);
	}

}
