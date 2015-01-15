package com.sh.manage.utils;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sh.manage.constants.Constants;



/**
 * WEB实用工具类. <br>
 * 对上下文、URI等进行处理。
 * <p>
 * 创建类 <br>
 * <p>
 * Copyright: Copyright (c) 2011-06-30 下午05:13:28
 * <p>
 * Company: 
 * <p>
 * 
 * @author 
 * @version 1.0
 */
public class WebUtils {

	/** 日志记录者 */
	private static Log logger = LogFactory.getLog(WebUtils.class);

	/**
	 * 格式化URI。
	 * 
	 * @param request
	 * @param uri
	 * @return
	 */
	public static String formatURI(HttpServletRequest request, String uri) {

		// 上下文路径
		String contextPath = getContextPath(request);

		if (!uri.startsWith("/")) {
			uri = "/" + uri;
		}

		return contextPath + uri;
	}

	/**
	 * 返回上下文路径，末尾不带[/]
	 * 
	 * @param request
	 *            请求
	 * @return
	 */
	public static String getContextPath(HttpServletRequest request) {

		// 上下文路径
		String contextPath = request.getContextPath();

		if (contextPath.endsWith("/")) {
			contextPath = contextPath.substring(0, contextPath.length() - 1);
		}

		return contextPath;
	}

	/**
	 * 输出Excel文件流。
	 * 
	 * @param response
	 *            响应
	 * @param is
	 *            文件流
	 * @param fileName
	 *            输出文件名
	 */
	public static void outputExcelStream(HttpServletResponse response, InputStream is, String fileName) {
		outputStream(response, is, "application/vnd.ms-excel", fileName);
	}

	/**
	 * 输出TXT文件流。
	 * 
	 * @param response
	 *            响应
	 * @param is
	 *            文件流
	 * @param fileName
	 *            输出文件名
	 */
	public static void outputJpegStream(HttpServletResponse response, InputStream is) {
		outputStream(response, is, "image/jpeg");
	}

	/**
	 * 导出流。
	 * 
	 * @param response
	 *            响应
	 * @param is
	 *            文件流
	 * @param contentType
	 *            内容类型
	 */
	public static void outputStream(HttpServletResponse response, InputStream is, String contentType) {

		// 设置响应头信息
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType(contentType);

		// 导出流
		try {
			IOUtils.copy(is, response.getOutputStream());
		}
		catch (IOException e) {
			if (logger.isWarnEnabled()) {
				logger.warn("导出[" + contentType + "]到RESPONSE出现异常!", e);
			}
		}
	}

	/**
	 * 导出流。
	 * 
	 * @param response
	 *            响应
	 * @param is
	 *            文件流
	 * @param contentType
	 *            内容类型
	 * @param fileName
	 *            输出文件名
	 */
	public static void outputStream(HttpServletResponse response, InputStream is, String contentType, String fileName) {

		// 设置响应头信息
		response.setContentType(contentType);
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-cache");

		try {
			response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, Constants.CHARSET_UTF8) + "\"");
		}
		catch (UnsupportedEncodingException e) {
		}

		// 导出流
		try {
			IOUtils.copy(is, response.getOutputStream());
		}
		catch (IOException e) {
			if (logger.isWarnEnabled()) {
				logger.warn("导出[" + contentType + "]到[" + fileName + "]出现异常!", e);
			}
		}
	}

	/**
	 * 输出TXT文件流。
	 * 
	 * @param response
	 *            响应
	 * @param is
	 *            文件流
	 * @param fileName
	 *            输出文件名
	 */
	public static void outputTxtStream(HttpServletResponse response, InputStream is, String fileName) {
		outputStream(response, is, "text/plain", fileName);
	}
	
	
	
	/**
	 * 导出流。
	 * 
	 * @param request
	 * 
	 * @param response
	 *            响应
	 * @param is
	 *            文件流
	 * @param contentType
	 *            内容类型
	 * @param fileName
	 *            输出文件名
	 */
//	public static void downLodaFileOutputStream(HttpServletRequest request,HttpServletResponse response, InputStream is, String contentType, String fileName) {
//
//		// 设置响应头信息
//		response.setContentType(contentType);
//		response.addHeader("Pragma", "no-cache");
//		response.addHeader("Cache-Control", "no-cache");
//		
//		response.setDateHeader("Expires", 0);
//		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
//		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
//		//response.setHeader("Pragma", "no-cache");
//
//		try {
//			String agent = request.getHeader("USER-AGENT");
//	        if (null != agent &&-1 != agent.indexOf("Mozilla")&&-1!=agent.indexOf("Firefox")) { //针对Firefox
//				String codedFileName = "=?"+QjsConstants.CHARSET_UTF8+"?B?" + (new String(Base64.encodeBase64(fileName.getBytes(QjsConstants.CHARSET_UTF8)))) + "?=";
//				response.addHeader("Content-Disposition", "attachment; filename=\"" + codedFileName);
//			}else if (null != agent) { // IE,360,谷歌
//				response.addHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, QjsConstants.CHARSET_UTF8) + "\"");
//			}
//			//response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fileName, QjsConstants.CHARSET_UTF8) + "\"");
//		}
//		catch (UnsupportedEncodingException e) {
//		}
//
//		// 导出流
//		try {
//			IOUtils.copy(is, response.getOutputStream());
//		}
//		catch (IOException e) {
//			if (logger.isWarnEnabled()) {
//				logger.warn("导出[" + contentType + "]到[" + fileName + "]出现异常!", e);
//			}
//		}
//	}

}