package com.liuyong666.tcp.simple;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
需求：
	定义端点接收数据并打印在控制台上。
服务端:
	1，建立服务端的socket服务。ServerSocket();
		并监听一个端口。
	2，获取连接过来的客户端对象。
		通过ServerSokcet的 accept方法。没有连接就会等，所以这个方法阻塞式的。
	3，客户端如果发过来数据，那么服务端要使用对应的客户端对象，并获取到该客户端对象的读取流来读取发过来的数据。
		并打印在控制台。
	
	4，关闭服务端。（可选）
*/

public class Server {
	
	public static void main(String[] args) throws Exception {
		//建立服务端socket服务。并监听一个端口
		ServerSocket serverSocket = new ServerSocket(10005);
		
		//通过accept方法获取连接过来的客户端对象
		while(true){
			Socket socket = serverSocket.accept();
			
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println(ip + " is connected!");
			
			//获取客户端发送过来的数据，那么要使用客户端对象的读取流来读取数据
			InputStream is = socket.getInputStream();
			
			byte[] buf = new byte[1024];
			int len = is.read(buf);
			
			System.out.println(new String(buf, 0, len));
			
			//关闭客户端
			socket.close();
			
		}
		
	}
	
}
