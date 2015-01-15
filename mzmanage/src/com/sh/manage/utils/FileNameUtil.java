package com.sh.manage.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

/**
 * Title. 文件名处理类<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2014-3-20
 * <p>
 * Company: 
 * <p>
 * Author: 
 * <p>
 * Version: 1.0
 * <p>
 */
public class FileNameUtil {
	public static String getNameExt(String filePathName) {
		return FilenameUtils.getExtension(filePathName);
	}

	public static String getNamePre(String filePathName) {
		return FilenameUtils.getBaseName(filePathName);
	}

	public static String getName(String filePathName) {
		return FilenameUtils.getName(filePathName);
	}

	public static String getPath(String filePathName) {
		return FilenameUtils.getFullPath(filePathName);
	}

	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>();

		String filePathName = "/data/mms/1.gif";
		strs.add(getName(filePathName));//文件名
		strs.add(getNameExt(filePathName));//后缀名
		strs.add(getNamePre(filePathName));//文件名前缀
		strs.add(getPath(filePathName));//文件路径

		for (String str : strs)
			System.out.println(str);
	}
}
