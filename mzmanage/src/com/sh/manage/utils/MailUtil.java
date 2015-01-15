package com.sh.manage.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sh.manage.email.EmailBO;
import com.sh.manage.email.EmailModel;


/**
 * Title. 发送邮件帮助类<br>
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
public class MailUtil {

	/**
	 * EmailModel实体
	 */
	private static EmailModel emailModel = null;
	/**
	 * 读取加载system.properties
	 */
	private static Properties props = null;  
	
	/**
	 * 加载配置文件，设置邮件实体EmailModel
	 */
	static {
		/**
		 * 配置文件
		 */
		props = new Properties();
		/**
		 * 邮件实体
		 */
		emailModel=  new EmailModel();
	    
			//加载配置文件mail.properties
				try {
					InputStream ins = MailUtil.class.getClassLoader().getResourceAsStream("mail.properties");
					props.load(ins);//加载流
					emailModel.setFrom(props.getProperty("mailFrom"));   //设置发件人
					emailModel.setTitle(props.getProperty("mailTitle"));  //设置邮件标题
					emailModel.setContent(props.getProperty("mailContent"));//设置邮件正文
					emailModel.setTo(props.getProperty("mailToUsers"));     //设置收件人
					ins.close();	//关闭流
				} catch (IOException e) {
					throw new RuntimeException(e);
				} 
	}
	/**
	 * 获取邮件业务处理 bean  
	 * @return EmailBO
	 */
    public static EmailBO getEmailBO() {  
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mail.xml");  
        return (EmailBO) context.getBean("sendEmail");
    } 
    
	/**
	 * 发送邮件方法无附件
	 */
	public static void sendEmailNoAttachFile() throws Exception{
		try {
			/**
			 * 发送无附件的邮件
			 */
			getEmailBO().sendEmailNoAttachFile(emailModel);
		} catch (Exception e) {
			throw new Exception("发送无附件的邮件出错!"+e.getMessage());
		}
		
	};
	
	/**
	 * 发送邮件方法含附件
	 */
	public static void sendEmail() throws Exception{
		try {
			/**
			 * 发送含附件的邮件
			 */
			getEmailBO().sendEmail(emailModel);
		} catch (Exception e) {
			throw new Exception("发送含附件的邮件出错!");
		}
		
	};
	
	
	
	/**
	 * 发送邮件方法无附件带参数
	 */
	public static void sendEmailNoAttachFile(EmailModel emailModel) throws Exception{
		try {
			/**
			 * 发送无附件的邮件
			 */
			getEmailBO().sendEmailNoAttachFile(emailModel);
		} catch (Exception e) {
			throw new Exception("发送无附件的邮件出错!"+e.getMessage());
		}
		
	};
	
	/**
	 * 发送邮件方法含附件带参数
	 */
	public static void sendEmail(EmailModel emailModel) throws Exception{
		try {
			/**
			 * 发送含附件的邮件
			 */
			getEmailBO().sendEmail(emailModel);
		} catch (Exception e) {
			throw new Exception("发送含附件的邮件出错!");
		}
		
	};
}
