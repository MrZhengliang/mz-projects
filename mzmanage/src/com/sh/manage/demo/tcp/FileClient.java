package com.sh.manage.demo.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileClient // 客户端
{
	FileClient(String fileStr) throws Exception {
		s.op("客户端启动....");
		File file = new File(fileStr); // 关联一个文件c:\\FoxitReader_CHS.rar
		if (file.isFile()) // 是一个标准文件吗?
		{
			client(file); // 启动连接
		} else {
			s.op("要发送的文件 " + fileStr + " 不是一个标准文件,请正确指定");
		}
	}

	public void client(File file) throws Exception {
		Socket sock = new Socket("127.0.0.1", 10007); // 指定服务端地址和端口

		FileInputStream fis = new FileInputStream(file); // 读取本地文件
		OutputStream sockOut = sock.getOutputStream(); // 定义socket输出流

		// 先发送文件名.让服务端知道
		String fileName = file.getName();
		s.op("待发送文件:" + fileName);
		sockOut.write(fileName.getBytes());

		String serverInfo = servInfoBack(sock); // 反馈的信息:服务端是否获取文件名并创建文件成功
		if (serverInfo.equals("FileSendNow")) // 服务端说已经准备接收文件,发吧
		{
			byte[] bufFile = new byte[1024];
			int len = 0;
			while (true) {
				len = fis.read(bufFile);
				if (len != -1) {
					sockOut.write(bufFile, 0, len); // 将从硬盘上读取的字节数据写入socket输出流
				} else {
					break;
				}
			}
		} else {
			s.op("服务端返回信息:" + serverInfo);
		}
		sock.shutdownOutput(); // 必须的,要告诉服务端该文件的数据已写完
		s.op("服务端最后一个返回信息:" + servInfoBack(sock));// 显示服务端最后返回的信息

		fis.close();
		sock.close();
	}

	public String servInfoBack(Socket sock) throws Exception // 读取服务端的反馈信息
	{
		InputStream sockIn = sock.getInputStream(); // 定义socket输入流
		byte[] bufIn = new byte[1024];
		int lenIn = sockIn.read(bufIn); // 将服务端返回的信息写入bufIn字节缓冲区
		String info = new String(bufIn, 0, lenIn);
		return info;
	}
}

class s {
	public static void op(Object obj) // 打印
	{
		System.out.println(obj);
	}
}