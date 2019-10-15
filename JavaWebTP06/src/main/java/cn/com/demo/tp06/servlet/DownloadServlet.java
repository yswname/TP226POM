package cn.com.demo.tp06.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 读取下载文件
		String fileName = "E:\\work\\中信\\农大\\TP226\\20191013_46Servlet之间的数据通信.mp4";
		FileInputStream fileIn = new FileInputStream(fileName);
		String defaultName = "20191013_46Servlet之间的数据通信.mp4";
		defaultName = URLEncoder.encode(defaultName, "utf-8");
		// 设置响应的类型和确实名称
		response.setHeader("Content-Disposition", "attachment; filename="+defaultName);
		// 输出下载文件的内容
		ServletOutputStream out = response.getOutputStream();
		byte[] bytes = new byte[1024];
		int count = -1;
		while((count = fileIn.read(bytes)) != -1) {
			out.write(bytes,0,count);
		}
		fileIn.close();
		out.flush();
		out.close();
	}

}
