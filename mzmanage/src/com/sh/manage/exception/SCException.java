/**
 * 
 */
package com.sh.manage.exception;



/**
 * 
 * 平台异常抽象基类
 * @author fuzl
 *
 */
public abstract class SCException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1123136997944842530L;
	@SuppressWarnings("unused")
	private String message = null;
	//private ErrorMessage i18nErrorMessage;
	
	public SCException(Throwable cause) {
		//super(SCException.unwrap(cause));
		if(cause != null) {
			//setErrorMessage(AbstractErrorMessageFactory.createStaticErrorMessage(cause.getMessage() + " (" + cause.getClass().getName() + ")", -1));
		}
	}
}
