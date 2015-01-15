package com.sh.manage.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * 
 * Title. <br>
 * Description.获取用户IP地址
 * <p>
 * Copyright: Copyright (c) 2014-4-7 下午02:52:49
 * <p>
 * Company:
 * <p>
 * Author: 
 * <p>
 * 修改人：
 * <p>
 * 修改时间:
 * <p>
 * 修改内容：
 * <p>
 * Version: 1.0
 * <p>
 */

public class IPUtil{
	
	/**
	 * 
	 */
	Logger logger=Logger.getLogger(IPUtil.class);
	/**
	 * 获取IP地址
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) { 
		request.getRemoteAddr(); 
	    if (request.getHeader("x-forwarded-for") == null) {
	    	return request.getRemoteAddr();
	    	}
	   return request.getHeader("x-forwarded-for"); 
	}
	
}
