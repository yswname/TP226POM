package cn.com.demo.tp04.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoLoginPageServlet
 * 输出登录UI
 */
public class DemoLoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"   <form action=\"demoLoginServlet\" method=\"post\">\r\n" + 
				"      UserName:<input type='text' name='userName'/><br/>\r\n" + 
				"      Password:<input type='password' name='password'/><br/>\r\n" + 
				"      <input type=\"submit\" value='登录'/>\r\n" + 
				"   </form>\r\n");
		// 获取消息
		String msg = (String)request.getAttribute("message");
		if(msg != null) {
		out.println("<script type='text/javascript'>\r\n" + 
				"      alert(\""+msg+"\");\r\n" + 
				"   </script>");
		}
		
	out.println(			"</body>\r\n" + 
				"</html>");
	}

}
