package com.sh.manage.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.sun.istack.internal.logging.Logger;

/**
 * Title. 导出用工具类<br>
 * Description.导出Excel、CSV、TXT工具类。
 * <p>
 * Copyright: Copyright (c) 2014年11月30日
 * <p>
 * Company: ff
 * <p>
 * Author: fuzl
 * <p>
 * Version: 1.0
 * <p>
 */
public class ExportUtils {

	/** 日志记录者 */
	private static Logger logger = Logger.getLogger(ExportUtils.class);

	/**
	 * 导出CSV文件流。
	 * 
	 * @param headers
	 *            标题数组
	 * @param fields
	 *            字段名数组
	 * @param data
	 *            数据
	 * @return 文件流
	 * @throws IOException
	 */
	public static InputStream exportCsvIS(String[] headers, String[] fields,
			List<Map<String, Object>> data) throws IOException {

		// 检查参数
		if (headers.length != fields.length) {
			throw new IllegalArgumentException("参数有误!");
		}

		// 创建临时文件
		File xlfFile = new File(System.getProperty("java.io.tmpdir"),
				RandomStringUtils.randomAlphabetic(32));
		PrintWriter printw = new PrintWriter(xlfFile);

		StringBuilder sBuilder = new StringBuilder();

		for (int i = 0; i < headers.length; i++) {

			sBuilder.append(headers[i]);
			if (i != headers.length - 1) {
				sBuilder.append(",\t");
			}
		}
		sBuilder.append("\r\n");
		@SuppressWarnings("unused")
		int count = 0;
		if (data != null && data.size() > 0) {
			for (Map<String, Object> rowMap : data) {
				for (int m = 0; m < fields.length; m++) {
					count++;
					sBuilder.append(StringUtil.getString(rowMap.get(fields[m])));

					if (m != fields.length - 1) {
						sBuilder.append(",\t");
					}
				}
				sBuilder.append("\r\n");
			}

		}

		// 将内容写入文本中
		printw.write(sBuilder.toString());

		printw.flush();
		printw.close();

		// 输出流
		try {
			return FileUtils.openInputStream(xlfFile);
		} catch (IOException e) {

			logger.warning("导出CSV文件流出现异常!", e);

			throw e;
		}
	}

	/**
	 * 导出EXCEL文件流。
	 * 
	 * @param headers
	 *            标题数组
	 * @param fields
	 *            字段名数组
	 * @param data
	 *            数据
	 * @return 文件流
	 * @throws IOException
	 */
	public static InputStream exportExcelIS(String[] headers, String[] fields,
			List<Map<String, Object>> data) throws IOException {

		// 检查参数
		if (headers.length != fields.length) {
			throw new IllegalArgumentException("参数有误!");
		}

		// 创建临时文件
		File xlfFile = new File(System.getProperty("java.io.tmpdir"),
				RandomStringUtils.randomAlphabetic(32));

		FileOutputStream os = new FileOutputStream(xlfFile);

		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet("Sheet1");

		// 头列表
		HSSFRow row1 = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row1.createCell(i);
			cell.setCellValue(headers[i]);
		}

		int j = 1;
		int k = 1;
		int count = 2;
		HSSFRow row = null;
		HSSFCell cell = null;

		if (data != null && data.size() > 0) {
			for (Map<String, Object> rowMap : data) {

				row = sheet.createRow(j);

				for (int m = 0; m < fields.length; m++) {
					cell = row.createCell(m);
					cell.setCellValue(StringUtil.getString(rowMap
							.get(fields[m])));
				}

				j = j + 1;
				k++;
				// 如果数据量大于5000,则分多个sheet导出
				if (k > 5000) {
					sheet = workbook.createSheet("Sheet" + count);
					HSSFRow row2 = sheet.createRow(0);
					for (int i = 0; i < headers.length; i++) {
						HSSFCell cell1 = row2.createCell(i);
						cell1.setCellValue(headers[i]);
					}
					count++;
					k = 1;
					j = 1;
				}
			}
		}

		workbook.write(os);

		os.flush();
		os.close();

		// 输出流
		try {
			return FileUtils.openInputStream(xlfFile);
		} catch (IOException e) {

			logger.warning("导出EXCEL文件流出现异常!", e);

			throw e;
		}
	}

	/**
	 * 导出TXT文件流。
	 * 
	 * @param headers
	 *            标题数组
	 * @param fields
	 *            字段名数组
	 * @param data
	 *            数据
	 * @return 文件流
	 * @throws IOException
	 */
	public static InputStream exportTxtIS(String[] headers, String[] fields,
			List<Map<String, Object>> data) throws IOException {

		// 检查参数
		if (headers.length != fields.length) {
			throw new IllegalArgumentException("参数有误!");
		}

		// 创建临时文件
		File xlfFile = new File(System.getProperty("java.io.tmpdir"),
				RandomStringUtils.randomAlphabetic(32));
		System.out.println(xlfFile);
		FileWriter fw = new FileWriter(xlfFile);

		StringBuilder sBuilder = new StringBuilder();

		for (int i = 0; i < headers.length; i++) {
			sBuilder.append(headers[i]);
			if (i != headers.length - 1) {
				sBuilder.append(",\t");
			}

		}
		sBuilder.append("\r\n");

		if (data != null && data.size() > 0) {

			for (Map<String, Object> rowMap : data) {
				for (int m = 0; m < fields.length; m++) {
					sBuilder.append(StringUtil.getString(rowMap.get(fields[m])));

					if (m != fields.length - 1) {
						sBuilder.append(",\t");
					}
				}
				sBuilder.append("\r\n");
			}
		}

		// 将内容写入文本中
		fw.write(sBuilder.toString());
		fw.flush();
		fw.close();

		// 输出流
		try {
			return FileUtils.openInputStream(xlfFile);
		} catch (IOException e) {
			logger.warning("导出TXT文件流出现异常!", e);
			throw e;
		}
	}

	/*
	 * public static void main(String[] args) { String[] headers = { "123",
	 * "item" }; String[] fields = { "123", "item" }; Map<String, Object> item =
	 * new HashMap<String, Object>(); List<Map<String, Object>> data = new
	 * ArrayList<Map<String, Object>>(); item = new HashMap<String, Object>();
	 * item.put("123", "item1"); item.put("item", "100"); data.add(item); item =
	 * new HashMap<String, Object>(); item.put("123", "item2"); item.put("item",
	 * "200"); data.add(item); item = new HashMap<String, Object>();
	 * item.put("123", "item3"); item.put("item", "300"); data.add(item); try {
	 * exportExcelIS(headers, fields, data); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */

}
