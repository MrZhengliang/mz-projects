/*******************************************************************************
 * Copyright 2010 .com All Rights Reserved.
 * 
 * @(#)SQLPagingUtils.java CreateDate:
 ******************************************************************************/
package com.sh.manage.utils;

import org.apache.commons.lang.StringUtils;

/**
 * SQL分页工具类. <br>
 * SQL分页工具。
 * <p>
 * 创建类 <br>
 * <p>
 * Copyright: Copyright (c) 2011-06-23 下午06:16:09
 * <p>
 * <p>
 * 
 * @version 1.0
 */
public class SQLPagingUtils {

	/**
	 * 获取取总数的SQL语句
	 * 
	 * @param sql
	 *            语句
	 * @return
	 */
	public static String getCountSQL(String sql) {

		// 获取from位置
		int pos = StringUtils.indexOfIgnoreCase(sql, "from");

		if (pos != -1) {
			// 返回语句
			return "select count(1) count " + sql.substring(pos);
		} else {
			return sql;
		}
	}

	/**
	 * 获取取总数的SQL语句
	 * 
	 * @param sql
	 *            语句
	 * @return
	 */
	public static String getCountSQL(StringBuffer sql) {
		return getCountSQL(sql.toString());
	}

	/**
	 * 获取分页用的SQL语句
	 * 
	 * @param sql
	 *            语句
	 * @return
	 */
	public static String getPagingSQL(String sql) {
		return "select * from (select Z.*, rownum rn from (" + sql + ") Z where rownum <= ?) where rn >= ?";
	}

	/**
	 * 获取分页用的SQL语句
	 * 
	 * @param sql
	 *            语句
	 * @return
	 */
	public static String getPagingSQL(StringBuffer sql) {
		return getPagingSQL(sql.toString());
	}
	
}