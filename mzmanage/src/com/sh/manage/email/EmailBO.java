package com.sh.manage.email;

/**
 * 
 * Title. 邮件业务处理接口<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 
 * <p>
 * Company: 
 * <p>
 * Author: 
 * <p>
 * Version: 1.0
 * <p>
 */
public interface EmailBO {
	/**
	 * 发送邮件
	 * 
	 * @param emailModel
	 *            email模型
	 * @throws Exception
	 *             抛出信息异常
	 */
	public void sendEmail(EmailModel emailModel) throws Exception;

	/**
	 * 发送邮件可以无附件
	 * 
	 * @param emailModel
	 *            email模型
	 * @throws Exception
	 *             抛出信息异常
	 */
	public void sendEmailNoAttachFile(EmailModel emailModel) throws Exception;
}
