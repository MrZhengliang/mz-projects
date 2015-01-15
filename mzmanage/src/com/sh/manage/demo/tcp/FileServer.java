package com.sh.manage.demo.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer // 服务端
{
	FileServer() throws Exception {
		s.op("服务端启动......");
		server();
	}

	@SuppressWarnings("resource")
	public void server() throws Exception {
		ServerSocket serversock = new ServerSocket(10007); // 监听端口
		while (true) {
			Socket sock = serversock.accept(); // 循环等待客户端连接
			new Thread(new FileServerThread(sock)).start(); // 当成功连接客户端后开启新线程接收文件
		}
	}
}

class FileServerThread implements Runnable // 服务端线程
{
	private Socket sock;

	FileServerThread(Socket sock) {
		this.sock = sock;
	}

	/**
	 * 主方法
	 */
	public void run() {
		String ip = sock.getInetAddress().getHostAddress(); // 获取客户端ip
		try {
			s.op("开启新线程接收来自客户端IP: " + ip + " 的文件");
			InputStream sockIn = sock.getInputStream();// 定义socket输入流,接收客户端的信息
			File file = getClientFileName(sockIn); // 创建同名文件
			if (file == null) {
				writeOutInfo(sock, "存在同名文件或获取文件失败,服务端断开连接!");
				sock.close();
				return;
			}

			FileOutputStream fos = new FileOutputStream(file); // 用来写入硬盘
			byte[] bufFile = new byte[1024 * 1024]; // 接收数据的缓存
			int len = 0;
			while (true) {
				len = sockIn.read(bufFile); // 接收数据
				if (len != -1) {
					fos.write(bufFile, 0, len); // 写入硬盘文件
				} else {
					break;
				}
			}
			writeOutInfo(sock, "上传成功!"); // 文件接收成功后给客户端反馈一个信息
			s.op("文件接收成功!" + System.getProperty("line.separator")); // 服务端打印一下
			fos.close(); //关闭文件流
			sock.close();// 关闭连接
		} catch (Exception ex) {
			throw new RuntimeException(ip + "异常!!!");
		}
	}

	/**
	 * 文件读出和写入
	 * @param sock
	 * @param infoStr
	 * @throws Exception
	 */
	public void writeOutInfo(Socket sock, String infoStr) throws Exception// 将信息反馈给服务端
	{
		OutputStream sockOut = sock.getOutputStream();
		sockOut.write(infoStr.getBytes());
	}

	/**
	 * 获取文件名，并转存文件
	 * @param sockIn
	 * @return
	 * @throws Exception
	 */
	public File getClientFileName(InputStream sockIn) throws Exception // 获取文件名并创建
	{
		// 获取客户端请求发送的文件名,并判断在D盘创建同名文件的情况
		byte[] bufName = new byte[1024];
		int lenInfo = 0;
		lenInfo = sockIn.read(bufName); // 获取文件名
		String fileName = new String(bufName, 0, lenInfo);

		File dir = new File("d:\\"); // 存到D盘根目录
		File[] files = dir.listFiles(); // 遍历d盘目录
		for (File f : files) {
			if (!f.isDirectory()) // 如果遍历到的该文件不是一个目录的话
			{
				if (f.getName().equals(fileName)) // 判断是否是同名文件
				{
					s.op(f.getName() + "文件已存在,断开该ip连接."
							+ System.getProperty("line.separator"));
					writeOutInfo(sock, "服务端已存在同名文件!"); // 反馈给客户端的信息
					return null;
				}
			}
		}
		s.op("将客户端发来的文件( " + fileName + " )存到" + dir.getAbsolutePath());
		File file = new File(dir + fileName);
		if (file.createNewFile()) {
			s.op("成功创建文件(" + fileName + " )准备写入数据");
			writeOutInfo(sock, "FileSendNow"); // 告诉客户端,开始传送数据吧
			return file;
		} else {
			return null; // 如果由于硬盘满了等原因创建文件失败的话
		}
	}
}

class ss {
	public static void op(Object obj) // 打印
	{
		System.out.println(obj);
	}
}
