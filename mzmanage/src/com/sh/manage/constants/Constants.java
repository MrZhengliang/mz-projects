package com.sh.manage.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Title. XX类<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2014年11月26日
 * <p>
 * Company: ff
 * <p>
 * Author: fuzl
 * <p>
 * Version: 1.0
 * <p>
 */
public class Constants {
	// Field descriptor #6 Ljava/lang/String;
	public static final String CHARSET_UTF8 = "UTF-8";

	// Field descriptor #6 Ljava/lang/String;
	public static final String CHARSET_GBK = "GBK";

	// 按钮声明
	public static final String ADD_BTN = "add_btn";
	public static final String EDIT_BTN = "edit_btn";
	public static final String DEL_BTN = "del_btn";
	public static final String QUERY_BTN = "query_btn";

	// 超级管理员
	public static final String USER_NAME = "admin";
	/**
	 * 平台超级用户的ID定义 多个
	 */
	public final static List<String> SUPER_ADMIN_ID_LIST = new ArrayList<String>();

	/**
	 * 帐号锁定状态：0,正常;1,锁定
	 */
	public final static Integer USER_LOCK_NO = 0;

	public final static Integer USER_LOCK_YES = 1;

	/**
	 * 帐户状态：1有效，9无效
	 */
	public final static Integer USER_STATUS_VALID = 1;
	
	public final static Integer USER_STATUS_INVALID = 9;
	
	
	static {
		SUPER_ADMIN_ID_LIST.add("0");
		SUPER_ADMIN_ID_LIST.add("41369");
		SUPER_ADMIN_ID_LIST.add("41370");
		SUPER_ADMIN_ID_LIST.add("68084");
	}
}
