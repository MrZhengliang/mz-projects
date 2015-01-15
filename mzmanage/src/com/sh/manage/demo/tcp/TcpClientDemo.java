package com.sh.manage.demo.tcp;


/**
 * Tcp客户端
 * @author fuzl
 *
 */

public class TcpClientDemo {
	public static void main(String[] args) throws Exception {
		new FileClient("c:\\login.conf"); // 启动客户端,准备发送指定文件
	}
}




