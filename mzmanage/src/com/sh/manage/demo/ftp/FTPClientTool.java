package com.sh.manage.demo.ftp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTPClientTool {
	@SuppressWarnings("unused")
	private static final int FTP_ERROR_CODE = 550;
	@SuppressWarnings("unused")
	private final int BUFFER_SIZE = 24576;
	private FTPClient ftpClient;
	private int timeOut = 10000;

	public FTPClientTool() {
		this.ftpClient = new FTPClient();
		this.ftpClient.setConnectTimeout(this.timeOut);
		this.ftpClient.setDefaultTimeout(this.timeOut);
	}

	private boolean cd(String remotePath) throws Exception {
		remotePath = remotePath.replaceAll("\\\\", "/");

		return this.ftpClient.changeWorkingDirectory(remotePath);
	}

	public void close() throws Exception {
		if (this.ftpClient.isConnected())
			try {
				this.ftpClient.logout();
			} catch (Exception e) {
				throw e;
			} finally {
				this.ftpClient.disconnect();
			}
	}

	public void connect(String hostName, int port, String userName,
			String passWord) throws Exception {
		try {
			if (this.ftpClient.isConnected())
				close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.ftpClient.connect(hostName, port);
		int code = this.ftpClient.getReplyCode();
		String reply = this.ftpClient.getReplyString();
		if (!FTPReply.isPositiveCompletion(code)) {
			this.ftpClient.disconnect();
			throw new Exception(reply);
		}
		this.ftpClient.setSoTimeout(this.timeOut);
		this.ftpClient.setDataTimeout(this.timeOut);
		this.ftpClient.setFileType(2);
		this.ftpClient.setBufferSize(24576);
		if (this.ftpClient.login(userName, passWord)) {
			this.ftpClient.enterLocalPassiveMode();
			try {
				this.ftpClient.listFiles();
			} catch (Exception e) {
				connectActiveMode(hostName, port, userName, passWord);
			}
			if (this.ftpClient.getReplyCode() == 550) {
				connectActiveMode(hostName, port, userName, passWord);
			}
			this.ftpClient.setFileType(2);
		} else {
			throw new Exception("login fail:" + this.ftpClient.getReplyString());
		}
	}

	private void connectActiveMode(String hostname, int port, String userName,
			String passWord) throws Exception {
		try {
			this.ftpClient.logout();
		} catch (Exception localException1) {
			try {
				this.ftpClient.disconnect();
			} catch (IOException localIOException) {
			}
		} finally {
			try {
				this.ftpClient.disconnect();
			} catch (IOException localIOException1) {
			}
		}
		try {
			this.ftpClient.connect(hostname, port);
			int code = this.ftpClient.getReplyCode();
			String reply = this.ftpClient.getReplyString();
			if (!FTPReply.isPositiveCompletion(code)) {
				this.ftpClient.disconnect();
				throw new Exception(reply);
			}
			this.ftpClient.setSoTimeout(this.timeOut);
			this.ftpClient.setDataTimeout(this.timeOut);
			this.ftpClient.setBufferSize(24576);
			this.ftpClient.setFileType(2);
			if (this.ftpClient.login(userName, passWord)) {
				this.ftpClient.enterLocalActiveMode();
			}
			this.ftpClient.setFileType(2);
		} catch (Exception e) {
			throw e;
		}
	}

	public void delDirFiles(String dir) throws Exception {
		dir = dir.replaceAll("\\\\", "/");
		if (cd(dir)) {
			FTPFile[] ftpfiles = this.ftpClient.listFiles(dir);
			for (FTPFile file : ftpfiles) {
				if ((file.getName().startsWith(".")) || (!file.isFile()))
					continue;
				if (!this.ftpClient.deleteFile(file.getName())) {
					throw new Exception("delete file fail :" + file.getName()
							+ " info:" + this.ftpClient.getReplyString());
				}

			}

			this.ftpClient.removeDirectory(dir);
		} else {
			throw new Exception("entry into path fail :" + dir + " info:"
					+ this.ftpClient.getReplyString());
		}
	}

	public boolean deleteFile(String pathname) throws Exception {
		pathname = pathname.replaceAll("\\\\", "/");
		boolean succFlag = this.ftpClient.deleteFile(pathname);
		if (!succFlag) {
			succFlag = this.ftpClient.removeDirectory(pathname);
		}
		return succFlag;
	}

	// ERROR //
	public byte[] get(String remoteFilePath) throws Exception {
		return null;
	}

	public void get(String remoteFilePath, String localDir) throws Exception {
		get(remoteFilePath, localDir, null);
	}

	// ERROR //
	public void get(String remoteFilePath, String localDir, String localName)
			throws Exception {
	}

	public List<String> getDirList(String remoteDir) throws Exception {
		return getDirList(remoteDir, null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> getDirList(String remoteDir, String dirNameRegex)
			throws Exception {
		List nameList = new ArrayList();
		List dirList = getFTPDirList(remoteDir, dirNameRegex);
		for (int i = 0; i < dirList.size(); i++) {
			nameList.add(((FTPFile) dirList.get(i)).getName());
		}
		return nameList;
	}

	public String getEncoding() {
		return this.ftpClient.getControlEncoding();
	}

	public List<String> getFileList(String remoteDir) throws Exception {
		return getFileList(remoteDir, null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> getFileList(String remoteDir, String fileNameRegex)
			throws Exception {
		List al = new ArrayList();
		List fileList = getFTPFileList(remoteDir, fileNameRegex);
		for (int i = 0; i < fileList.size(); i++) {
			al.add(((FTPFile) fileList.get(i)).getName());
		}
		return al;
	}

	public FTPClient getFtpClient() {
		return this.ftpClient;
	}

	public List<FTPFile> getFTPDirList(String remoteDir) throws Exception {
		return getFTPDirList(remoteDir, null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FTPFile> getFTPDirList(String remoteDir, String dirNameRegex)
			throws Exception {
		List nameList = new ArrayList();
		remoteDir = remoteDir.replaceAll("\\\\", "/");
		remoteDir = remoteDir.replaceAll("//", "/");
		if (!remoteDir.startsWith("/")) {
			remoteDir = "/" + remoteDir;
		}

		if ((remoteDir != null) && (remoteDir.length() > 0) && (cd(remoteDir))) {
			FTPFile[] fileList = this.ftpClient.listFiles();
			if ((dirNameRegex != null) && (dirNameRegex.trim().length() != 0)) {
				for (int i = 0; i < fileList.length; i++) {
					if ((fileList[i].getName().equals("."))
							|| (fileList[i].getName().endsWith(".."))) {
						continue;
					}
					if ((fileList[i].isDirectory())
							&& (fileList[i].getName().matches(dirNameRegex)))
						nameList.add(fileList[i]);
				}
			} else {
				for (int i = 0; i < fileList.length; i++) {
					if ((!fileList[i].isDirectory())
							|| (fileList[i].getName().equals("."))
							|| (fileList[i].getName().endsWith(".."))) {
						continue;
					}
					nameList.add(fileList[i]);
				}
			}

		}

		return nameList;
	}

	public List<FTPFile> getFTPFileList(String remoteDir) throws Exception {
		return getFTPFileList(remoteDir, null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FTPFile> getFTPFileList(String remoteDir, String fileNameRegex)
			throws Exception {
		remoteDir = remoteDir.replaceAll("\\\\", "/");
		List al = new ArrayList();
		if ((remoteDir != null) && (remoteDir.length() > 0) && (cd(remoteDir))) {
			FTPFile[] fileList = this.ftpClient.listFiles();
			if ((fileNameRegex != null) && (fileNameRegex.trim().length() != 0)) {
				for (int i = 0; i < fileList.length; i++) {
					if ((fileList[i].isFile())
							&& (fileList[i].getName().matches(fileNameRegex)))
						al.add(fileList[i]);
				}
			} else {
				for (int i = 0; i < fileList.length; i++) {
					if (fileList[i].isFile()) {
						al.add(fileList[i]);
					}
				}
			}

		}

		return al;
	}

	public final int getTimeOut() {
		return this.timeOut;
	}

	public void mkdir(String name) throws Exception {
		if ((name == null) || (name.trim().length() == 0)) {
			throw new Exception("the param name can not be null or empty.");
		}
		name = name.replaceAll("\\\\", "/");
		name = name.replaceAll("//", "/");
		if (!name.startsWith("/")) {
			name = "/" + name;
		}
		if (!cd(name)) {
			String upDir = new File(name).getParent();
			if ((upDir == null) || (upDir.equals(""))) {
				return;
			}
			mkdir(upDir);
			this.ftpClient.makeDirectory(name);
		}
	}

	// ERROR //
	public void put(byte[] inputDate, String remoteDirPath,
			String remoteFileName) throws Exception { // Byte code:
	}

	public void put(String localPathFile, String remoteDirPath)
			throws Exception {
		put(localPathFile, remoteDirPath, null);
	}

	// ERROR //
	public void put(String localPathFile, String remoteDirPath,
			String remoteFileName) throws Exception { // Byte code:
	}

	public boolean rename(String srcPathFile, String destPathFile)
			throws Exception {
		srcPathFile = srcPathFile.replaceAll("\\\\", "/");
		destPathFile = destPathFile.replaceAll("\\\\", "/");
		return this.ftpClient.rename(srcPathFile, destPathFile);
	}

	public void setEncoding(String encoding) {
		this.ftpClient.setControlEncoding(encoding);
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
		this.ftpClient.setConnectTimeout(timeOut);
		this.ftpClient.setDefaultTimeout(timeOut);
	}
}