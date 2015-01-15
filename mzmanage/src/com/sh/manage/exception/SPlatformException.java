/*******************************************************************************
 * Copyright  All Rights Reserved.
 * 
 * @(#)SPlatformException.java CreateDate: 
 ******************************************************************************/
package com.sh.manage.exception;
import java.text.MessageFormat;

/**
 * 顶层Checked异常类. <br>
 * 定义顶层Checked异常。
 * <p>
 * 创建类 <br>
 * <p>
 * <p>
 * Company: 
 * <p>
 * 
 * @author fuzl
 * @version 1.0
 */
public class SPlatformException extends Exception {

	/**
	 * Version UID
	 */
	private static final long serialVersionUID = 3875929465986227858L;

	/**
	 * 消息参数。
	 */
	private final Object[] arguments;

	/**
	 * 消息格式。
	 */
	private final String pattern;

	/**
	 * 默认构造器。
	 */
	public SPlatformException() {
		this.pattern = "";
		this.arguments = new Object[0];
	}

	/**
	 * 带消息的构造器。
	 * 
	 * @param pattern
	 *            消息格式
	 * @param arguments
	 *            消息参数
	 */
	public SPlatformException(String pattern, Object... arguments) {
		this.pattern = pattern;
		this.arguments = (arguments == null) ? new Object[0] : arguments.clone();
	}

	/**
	 * 带异常的构造器。
	 */
	public SPlatformException(Throwable rootCause) {
		super(rootCause);
		this.pattern = "";
		this.arguments = new Object[0];
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
	public SPlatformException(Throwable rootCause, String pattern, Object... arguments) {
		super(rootCause);
		this.pattern = pattern;
		this.arguments = (arguments == null) ? new Object[0] : arguments.clone();
	}

	/**
	 * 获得消息参数。
	 * 
	 * @return 消息参数
	 */
	public Object[] getArguments() {
		return arguments.clone();
	}

	/**
	 * 格式化消息。
	 * 
	 * @return 返回消息
	 */
	@Override
	public String getMessage() {
		return (pattern == null) ? "" : new MessageFormat(pattern).format(arguments);
	}

	/**
	 * 获得消息格式。
	 * 
	 * @return 消息格式
	 */
	public String getPattern() {
		return pattern;
	}
}