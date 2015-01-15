/**
 * ContextUtils.java
 * 
 * 2011-03-30 08:57:00
 */
package com.sh.manage.utils;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Spring上下文工具类
 * 
 * @author fuzl
 * 
 * @create 2011-03-30 08:57:00
 */
public class ContextUtils {

	/**
	 * 根据id找到相关的Bean
	 * 
	 * @param <T>
	 * @param id
	 * @param context
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String id, ServletContext context) {
		WebApplicationContext springContext = getContext(context);
		
		return (T)springContext.getBean(id);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String id) {
		WebApplicationContext springContext = ContextLoader.getCurrentWebApplicationContext();
		
		return (T)springContext.getBean(id);
	}
	
	/**
	 * 获取WEB运行环境的Spring上下文
	 * 
	 * @param context Servlet容器
	 * @return Spring上
	 */
	public static WebApplicationContext getContext(ServletContext context) {
		return WebApplicationContextUtils.getWebApplicationContext(context);
	}
}
