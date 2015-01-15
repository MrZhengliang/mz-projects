/*******************************************************************************
 * Copyright 2014 All Rights Reserved.
 * 
 ******************************************************************************/
package com.sh.manage.exception;
/**
 * 业务异常类. <br>
 * 定义业务异常。
 * <p>
 * 创建类 <br>
 * <p>
 * Copyright: Copyright (c) 
 * <p>
 * <p>
 * 
 * @author fuzl
 * @version 1.0
 */
public class SPlatformServiceException extends SPlatformException {

	/**
	 * Version UID
	 */
	private static final long serialVersionUID = -783781055967730369L;

	/**
	 * 默认构造器。
	 */
	public SPlatformServiceException() {
		super("com.cplatform.zone12580.exception.SPlatformServiceException: Service Exception");
	}

	/**
	 * 带消息的构造器。
	 * 
	 * @param pattern
	 *            消息格式
	 * @param arguments
	 *            消息参数
	 */
	public SPlatformServiceException(String pattern, Object... arguments) {
		super(pattern, arguments);
	}

	/**
	 * 带异常的构造器。
	 */
	public SPlatformServiceException(Throwable rootCause) {
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
	public SPlatformServiceException(Throwable rootCause, String pattern, Object... arguments) {
		super(rootCause, pattern, arguments);
	}
}
