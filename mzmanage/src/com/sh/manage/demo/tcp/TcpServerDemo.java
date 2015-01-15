package com.sh.manage.demo.tcp;


/**
 * Tcp服务端，监听客户端的请求
 * @author fuzl
 *
 */
public class TcpServerDemo {
	public static void main(String[] args) throws Exception {
		new FileServer(); // 启动文件存储服务端
	}
}

