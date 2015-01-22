/*******************************************************************************
 * Copyright 2010  All Rights Reserved.
 * 
 * @(#)SPlatformDaoException.java CreateDate: 
 ******************************************************************************/
package com.sh.manage.exception;

/**
 * 数据访问异常类. <br>
 * 定义数据访问异常。
 * <p>
 * 创建类 <br>
 * <p>
 * Copyright: 
 * <p>
 * Company: 
 * <p>
 * 
 * @author
 * @version 1.0
 */
public class SPlatformDaoException extends SPlatformRuntimeException {

	/**
	 * Version UID
	 */
	private static final long serialVersionUID = -4339593727972281146L;

	/**
	 * 默认构造器。
	 */
	public SPlatformDaoException() {
		super("com.splatform.manage.exception.SPlatformDaoEception: Data Access Exception");
	}

	/**
	 * 带消息的构造器。
	 * 
	 * @param pattern
	 *            消息格式
	 * @param arguments
	 *            消息参数
	 */
	public SPlatformDaoException(String pattern, Object... arguments) {
		super(pattern, arguments);
	}

	/**
	 * 带异常的构造器。
	 */
	public SPlatformDaoException(Throwable rootCause) {
		super(rootCause);
	}

	/**
	 * 带异常和消息的构造器。
	 * 
	 * @param rootCause
	 *            异常信息
	 * @param pattern
	 *            消息格式
	 * @param arguments
	 *            消息参数
	 */
	public SPlatformDaoException(Throwable rootCause, String pattern, Object... arguments) {
		super(rootCause, pattern, arguments);
	}
}
