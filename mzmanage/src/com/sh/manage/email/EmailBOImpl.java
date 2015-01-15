package com.sh.manage.email;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.sh.manage.utils.StringUtil;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

/**
 * Title. 邮件业务处理类，实现EmailBO接口<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2014-1-16
 * <p>
 * Company: 
 * <p>
 * Author: 
 * <p>
 * Version: 1.0
 * <p>
 */
public class EmailBOImpl implements EmailBO {

	/**
	 * email发送类
	 */
	private JavaMailSenderImpl javaMail;
	/**
	 * 邮件信息设置类
	 */
	private MimeMessageHelper messageHelper;
	/**
	 * 日志信息类
	 */
	private static final Logger logger = Logger.getLogger(EmailBOImpl.class);

	/*
	 * 邮件发送方法实现,含附件 (non-Javadoc)
	 * 
	 * @see
	 * com.cplatform.lnsc.pay.email.EmailBO#sendEmail(com.cplatform.lnsc.pay
	 * .email.EmailModel)
	 */
	public void sendEmail(EmailModel emailModel) throws Exception {
		// 邮件附件是否为空
		if (null == emailModel.getAttachFileName()) {
			logger.info("emailModel的附件为空!");
			return;
		}
		/**
		 * 获得邮件发送人
		 */
		String tmpUserName = emailModel.getFrom();
		/**
		 * 判断邮件用户名是否为空，为空取spring配置文件中的默认用户名
		 */
		if (tmpUserName == null || "".equalsIgnoreCase(tmpUserName)) {
			emailModel.setFrom(javaMail.getUsername());
		}
		/**
		 * 创建一个MimeMessage对象
		 */
		MimeMessage mimeMessage = javaMail.createMimeMessage();
		/**
		 * 创建一个MimeMessageHelper对象,并设置编码类型GBK
		 * 
		 */
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
				mimeMessage, true, "GBK");

		/**
		 * 邮件群发人分析,格式xx@xx;yy@xx;
		 */
		String tmpToUser = emailModel.getTo();
		/**
		 * 分解群发人
		 */
		String[] arrToUsers = tmpToUser.split(";");
		/**
		 * 设置发送人
		 */
		mimeMessageHelper.setFrom(emailModel.getFrom());
		/**
		 * 设置邮件标题
		 */
		mimeMessageHelper.setSubject(emailModel.getTitle());
		/**
		 * 设置邮件正文内容
		 */
		mimeMessageHelper.setText(emailModel.getContent(), true);
		/**
		 * 附件名，类型为数组
		 */
		String[] attachFileNames = emailModel.getAttachFileName();
		/**
		 * 附件路径
		 */
		String attachFilePath = emailModel.getAttachPath();
		/**
		 * 操作系统分隔符
		 */
		String systemSeparator = StringUtil
				.getSystemParameter("file.separator");

		try {
			// 判断是否有附件，没有不进行发送附件
			if (null != attachFileNames
					&& !ArrayUtils.isEmpty(attachFileNames)) {
				for (int i = 0; i < attachFileNames.length; i++) {
					// 附件无法生成
					if (null == attachFileNames[i]) {
						throw new Exception("附件不能正常生成，邮件将不进行发送!");
					}
					mimeMessageHelper.addAttachment(MimeUtility
							.encodeText(attachFileNames[i]), new File(
							attachFilePath + systemSeparator
									+ attachFileNames[i]));
				}
			}
		} catch (Exception e) {
			throw e;
		}

		try {
			/**
			 * 设置邮件接收人
			 */
			mimeMessageHelper.setTo(arrToUsers);
			/**
			 * 发送邮件
			 */
			javaMail.send(mimeMessage);
			logger.info("邮件发送OK!");
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * 邮件发送方法实现，不带附件 (non-Javadoc)
	 * 
	 * @see
	 * com.cplatform.lnsc.pay.email.EmailBO#sendEmailNoAttachFile(com.cplatform
	 * .lnsc.pay.email.EmailModel)
	 */
	public void sendEmailNoAttachFile(EmailModel emailModel) throws Exception {
		/**
		 * 获得邮件发送人
		 */
		String tmpUserName = emailModel.getFrom();
		System.out.println("邮件发送人:"+tmpUserName);
		/**
		 * 判断邮件用户名是否为空，为空取spring配置文件中的默认用户名
		 */
		if (tmpUserName == null || "".equalsIgnoreCase(tmpUserName)) {
			// logger.info("配置的用户名:"+javaMail.getUsername());
			emailModel.setFrom(javaMail.getUsername());
		}
		/**
		 * 创建一个MimeMessage对象
		 */
		MimeMessage mimeMessage = javaMail.createMimeMessage();
		/**
		 * 创建一个MimeMessageHelper对象,并设置编码类型GBK
		 * 
		 */
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
				mimeMessage, true, "GBK");

		/**
		 * 邮件群发人分析,格式xx@xx;yy@xx;
		 */
		String tmpToUser = emailModel.getTo();
		System.out.println("邮件接收人:"+tmpToUser);
		/**
		 * 分解群发人
		 */
		String[] arrToUsers = tmpToUser.split(";");
		/**
		 * 设置发送人
		 */
		mimeMessageHelper.setFrom(emailModel.getFrom());
		/**
		 * 设置邮件标题
		 */
		mimeMessageHelper.setSubject(emailModel.getTitle());
		/**
		 * 设置邮件正文内容
		 */
		mimeMessageHelper.setText(emailModel.getContent(), true);

		try {
			/**
			 * 设置邮件接收人
			 */
			mimeMessageHelper.setTo(arrToUsers);
			/**
			 * 发送邮件
			 */
			javaMail.send(mimeMessage);
			logger.info("邮件发送OK!");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * @return the javaMail
	 */
	public JavaMailSenderImpl getJavaMail() {
		return javaMail;
	}

	/**
	 * @param javaMail
	 *            the javaMail to set
	 */
	public void setJavaMail(JavaMailSenderImpl javaMail) {
		this.javaMail = javaMail;
	}

	/**
	 * @return the messageHelper
	 */
	public MimeMessageHelper getMessageHelper() {
		return messageHelper;
	}

	/**
	 * @param messageHelper
	 *            the messageHelper to set
	 */
	public void setMessageHelper(MimeMessageHelper messageHelper) {
		this.messageHelper = messageHelper;
	}
}
