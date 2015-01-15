/**
 * 
 */
package com.sh.manage.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuzl
 *
 */
public class SessionConstants {
	
	public static final String LOGIN_USER="sh_web_loginUser";

	
	public static final List<String> SUPER_ADMIN_ID_LIST = new ArrayList<String>();
	/**
	 * 平台超级用户的ID定义
	 */
	public final static String SUPER_ADMIN_ID = "0";

	public static final Object SYS_TYPE_0 = null;
	
	static{
		SUPER_ADMIN_ID_LIST.add("2");
	}
}
