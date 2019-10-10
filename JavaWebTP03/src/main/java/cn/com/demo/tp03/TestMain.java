package cn.com.demo.tp03;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestMain {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9000);
		System.out.println("启动了服务器：9000");
		while (true) {
			Socket socket = server.accept();

			new Thread() {
				public void run() {
					try {
						InputStream in = socket.getInputStream();
						Reader reader = new InputStreamReader(in);
						char[] chars = new char[1024];
						int count = -1;
						while((count = reader.read(chars)) != -1) {
							System.out.print(new String(chars,0,count));
						}
					} catch (Exception e) {

					}
				}
			}.start();
		}
	}

}
