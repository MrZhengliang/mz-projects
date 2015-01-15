package com.sh.manage.demo.ftp;

/**
 * Title. XX类<br>
 * Description.
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

@Deprecated
public class FtpTool {
	@SuppressWarnings("unused")
	private static final int TIMEOUT = 10000;
	private FTPClient ftpClient;
	private String localDir;

	public FtpTool() {
		this.ftpClient = new FTPClient();
		this.ftpClient.setConnectTimeout(10000);
		this.ftpClient.setDefaultTimeout(10000);
	}

	public boolean cd(String remotePath) throws Exception {
		return this.ftpClient.changeWorkingDirectory(remotePath);
	}

	public boolean cdUp() throws Exception {
		return this.ftpClient.changeToParentDirectory();
	}

	public boolean deleteFile(String pathname) throws Exception {
		if (!this.ftpClient.deleteFile(pathname)) {
			return this.ftpClient.removeDirectory(pathname);
		}
		return true;
	}

	public void enterActiveMode() {
		this.ftpClient.enterLocalActiveMode();
	}

	public void enterPassiveMode() {
		this.ftpClient.enterLocalPassiveMode();
	}

	public void exit() throws Exception {
		if (this.ftpClient.isConnected())
			try {
				this.ftpClient.logout();
			} catch (Exception e) {
				throw e;
			} finally {
				this.ftpClient.disconnect();
			}
	}

	public boolean get(String localDir, String remoteFileName) throws Exception {
		if ((localDir == null) || (localDir.trim().length() == 0)) {
			localDir = this.localDir;
		}
		if ((localDir == null) || (localDir.trim().length() == 0)) {
			localDir = ".";
		}
		if (!localDir.equals(".")) {
			File temp = new File(localDir);
			if (!temp.isDirectory()) {
				temp.mkdirs();
			}
		}
		if (!localDir.endsWith("/")) {
			localDir = localDir + "/";
		}

		FileOutputStream fos = new FileOutputStream(localDir + remoteFileName);
		try {
			boolean bool = this.ftpClient.retrieveFile(remoteFileName, fos);
			return bool;
		} catch (Exception e) {
			throw e;
		} finally {
			if (fos != null)
				fos.close();
		}
	}

	public boolean getAbsoluteFile(String localFilePath, String remoteFilePath)
			throws Exception {
		File localFile = new File(localFilePath).getParentFile();
		if ((localFile != null) && (!localFile.exists())) {
			localFile.mkdirs();
		}

		FileOutputStream fos = new FileOutputStream(localFilePath);
		try {
			boolean bool = this.ftpClient.retrieveFile(remoteFilePath, fos);
			return bool;
		} catch (Exception e) {
			throw e;
		} finally {
			if (fos != null)
				fos.close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] getDirList(String remoteDir, String dirNameRegex)
			throws Exception {
		if ((remoteDir != null) && (remoteDir.length() > 0)) {
			cd(remoteDir);
		}
		FTPFile[] fileList = this.ftpClient.listFiles();
		ArrayList al = new ArrayList();

		if ((dirNameRegex != null) && (dirNameRegex.trim().length() != 0)) {
			for (int i = 0; i < fileList.length; i++) {
				if ((fileList[i].getName().equals("."))
						|| (fileList[i].getName().endsWith(".."))) {
					continue;
				}
				if ((fileList[i].isDirectory())
						&& (fileList[i].getName().matches(dirNameRegex)))
					al.add(fileList[i].getName());
			}
		} else {
			for (int i = 0; i < fileList.length; i++) {
				if ((!fileList[i].isDirectory())
						|| (fileList[i].getName().equals("."))
						|| (fileList[i].getName().endsWith(".."))) {
					continue;
				}
				al.add(fileList[i].getName());
			}
		}

		String[] nameList = new String[al.size()];
		for (int i = 0; i < al.size(); i++) {
			nameList[i] = ((String) al.get(i));
		}
		return nameList;
	}

	public String getEncoding() {
		return this.ftpClient.getControlEncoding();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String[] getFileList(String remoteDir, String fileNameRegex)
			throws Exception {
		if ((remoteDir != null) && (remoteDir.length() > 0)) {
			cd(remoteDir);
		}
		FTPFile[] fileList = this.ftpClient.listFiles();

		ArrayList al = new ArrayList();
		if ((fileNameRegex != null) && (fileNameRegex.trim().length() != 0)) {
			for (int i = 0; i < fileList.length; i++) {
				if ((fileList[i].isFile())
						&& (fileList[i].getName().matches(fileNameRegex)))
					al.add(fileList[i].getName());
			}
		} else {
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isFile()) {
					al.add(fileList[i].getName());
				}
			}
		}

		String[] nameList = new String[al.size()];
		for (int i = 0; i < al.size(); i++) {
			nameList[i] = ((String) al.get(i));
		}
		return nameList;
	}

	public String getLocalDir() {
		return this.localDir;
	}

	public boolean login(String url, int port, String userName, String password)
			throws Exception {
		try {
			if (this.ftpClient.isConnected())
				exit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.ftpClient.connect(url, port);
		int code = this.ftpClient.getReplyCode();
		String reply = this.ftpClient.getReplyString();

		if (!FTPReply.isPositiveCompletion(code)) {
			this.ftpClient.disconnect();
			throw new Exception(reply);
		}

		this.ftpClient.setSoTimeout(10000);
		this.ftpClient.setDataTimeout(10000);
		setBinary();
		return this.ftpClient.login(userName, password);
	}

	public boolean login(String url, String userName, String password)
			throws Exception {
		return login(url, 21, userName, password);
	}

	public boolean mkdir(String name) throws Exception {
		return this.ftpClient.makeDirectory(name);
	}

	public boolean multiGet(String localDir, String remoteFileNames)
			throws Exception {
		String[] files = getFileList(null, remoteFileNames);
		if (files == null) {
			return false;
		}
		for (int i = 0; i < files.length; i++) {
			get(localDir, files[i]);
		}
		return true;
	}

	public boolean multiPut(String localDir, String[] localFileNames)
			throws Exception {
		for (int i = 0; i < localFileNames.length; i++) {
			put(localDir, localFileNames[i]);
		}
		return true;
	}

	public boolean put(String localDir, String localFileName) throws Exception {
		if ((localDir == null) || (localDir.trim().length() == 0)) {
			localDir = this.localDir;
		}
		if ((localDir == null) || (localDir.trim().length() == 0))
			localDir = ".";
		File file;
		if (localFileName.startsWith("/"))
			file = new File(localDir + localFileName);
		else {
			file = new File(localDir + "/" + localFileName);
		}
		FileInputStream fis = new FileInputStream(file);
		try {
			boolean bool = this.ftpClient.storeFile(file.getName(), fis);
			return bool;
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null)
				fis.close();
		}
	}

	public boolean putToFile(File localFile, String remoteFilePath)
			throws Exception {
		if (!localFile.isFile()) {
			throw new FileNotFoundException("文件" + localFile.getAbsolutePath()
					+ "不存在或者没有读取权限");
		}
		String[] temp = remoteFilePath.split("/");
		String currentDir = this.ftpClient.printWorkingDirectory();
		int length = temp.length;
		String fileName = temp[(length - 1)];
		if (fileName.indexOf(".") == -1) {
			throw new Exception("文件路径不合法");
		}
		if (remoteFilePath.startsWith("/")) {
			cd("/");
		}
		for (String dir : temp) {
			if ((dir.trim().length() <= 0) || (dir.indexOf(".") != -1)
					|| (cd(dir)))
				continue;
			mkdir(dir);
			cd(dir);
		}

		FileInputStream fis = new FileInputStream(localFile);
		try {
			boolean b = this.ftpClient.storeFile(fileName, fis);
			cd(currentDir);
			boolean bool1 = b;
			return bool1;
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null)
				fis.close();
		}
	}

	public boolean putToFile(String localFilePath, String remoteFilePath)
			throws Exception {
		File file = new File(localFilePath);
		return putToFile(file, remoteFilePath);
	}

	public boolean putToPath(File localFile, String remoteDirPath)
			throws Exception {
		if (!localFile.isFile()) {
			throw new FileNotFoundException("文件" + localFile.getAbsolutePath()
					+ "不存在或者没有读取权限");
		}
		String[] temp = remoteDirPath.split("/");
		String currentDir = this.ftpClient.printWorkingDirectory();
		if (remoteDirPath.startsWith("/")) {
			cd("/");
		}
		for (String dir : temp) {
			if ((dir.trim().length() <= 0) || (cd(dir)))
				continue;
			mkdir(dir);
			cd(dir);
		}

		FileInputStream fis = new FileInputStream(localFile);
		try {
			boolean b = this.ftpClient.storeFile(localFile.getName(), fis);
			cd(currentDir);
			boolean bool1 = b;
			return bool1;
		} catch (Exception e) {
			throw e;
		} finally {
			if (fis != null)
				fis.close();
		}
	}

	public boolean putToPath(String localFilePath, String remoteDirPath)
			throws Exception {
		File file = new File(localFilePath);
		return putToPath(file, remoteDirPath);
	}

	public boolean rename(String srcFileName, String destFileName)
			throws Exception {
		return this.ftpClient.rename(srcFileName, destFileName);
	}

	public boolean setAscii() throws Exception {
		return this.ftpClient.setFileType(0);
	}

	public boolean setBinary() throws Exception {
		return this.ftpClient.setFileType(2);
	}

	public void setEncoding(String encoding) {
		this.ftpClient.setControlEncoding(encoding);
	}

	public void setLocalDir(String path) {
		this.localDir = path;
	}
}