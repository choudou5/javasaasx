package com.choudou5.javasaasx.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Json工具类（fastjson）
 * @author xuhaowen
 * @date 2017年3月13日
 */
public class JsonUtil {

	/**
	 * 将对象 转为 字符串
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj){
		return JSON.toJSONString(obj);
	}
	
	/**
	 * 转 Java对象
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static <T> T toJavaObject(String text, Class<T> clazz){
		return JSON.parseObject(text, clazz);
	}
	
	/**
	 * 转 Java对象
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T toJavaObject(JSONObject json, Class<T> clazz){
		return JSON.toJavaObject(json, clazz);
	}
	
	/**
	 * 转 Java对象集合
	 * @param text
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> toJavaObjectList(String text, Class<T> clazz){
		return JSON.parseArray(text, clazz);
	}
	
	/**
	 * 转 Json对象
	 * @param text
	 * @return
	 */
	public static <T> JSONObject toJsonObject(String text){
		return JSON.parseObject(text);
	}
	
	/**
	 * 转 Json数组
	 * @param text
	 * @return
	 */
	public static <T> JSONArray toJsonArray(String text){
		return JSON.parseArray(text);
	}
	
}
