/*******************************************************************************
 * Copyright 2010 .com All Rights Reserved.
 * 
 * @(#)ResponseUtils.java CreateDate: 2011-06-23 下午05:26:09
 ******************************************************************************/
package com.sh.manage.utils;


/**
 * 响应工具类. <br>
 * 定义简单json和xml响应结果。
 * <p>
 * 创建类 <br>
 * <p>
 * Copyright: 
 * <p>
 * <p>
 * 
 * @author fuzl
 * @version 1.0
 */
public class ResponseUtils {

	/**
	 * JSON形式的BAD响应值。
	 * 
	 * @param msg
	 *            消息
	 * @return
	 */
	public static String newJsonBADResp(String msg) {
		return newJsonResp(-1, msg, null);
	}

	/**
	 * JSON形式的BAD响应值。
	 * 
	 * @param msg
	 *            消息
	 * @param obj
	 *            要转化成成JSON的对象。
	 * @return
	 */
	public static String newJsonBADResp(String msg, Object obj) {
		String objJson = JsonUtils.toJson(obj);
		return newJsonResp(-1, msg, objJson);
	}

	/**
	 * JSON形式的OK响应值。
	 * 
	 * @param msg
	 *            消息
	 * @return
	 */
	public static String newJsonOKResp(String msg) {
		return newJsonResp(0, msg, null);
	}

	/**
	 * JSON形式的OK响应值。
	 * 
	 * @param msg
	 *            消息
	 * @param obj
	 *            要转化成成JSON的对象。
	 * @return
	 */
	public static String newJsonOKResp(String msg, Object obj) {
		String objJson = JsonUtils.toJson(obj);
		return newJsonResp(0, msg, objJson);
	}

	/**
	 * JSON形式的响应值。
	 * 
	 * @param result
	 * @param msg
	 * @param data
	 *            数据
	 * @return
	 */
	public static String newJsonResp(int result, String msg, String data) {
		StringBuffer buffer = new StringBuffer();

		buffer.append("{\"code\":");
		buffer.append(result);

		if (msg != null) {
			buffer.append(", \"msg\":\"");
			buffer.append(msg);
			buffer.append("\"");
		}

		if (data != null) {
			buffer.append(", \"data\":");
			buffer.append(data);
		}

		buffer.append("}");

		return buffer.toString();
	}
}
