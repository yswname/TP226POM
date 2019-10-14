package cn.com.demo.tp05.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterPageServlet
 * 用户得注册页面
 */
public class RegisterPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<title></title>\r\n" + 
				"		<script type=\"text/javascript\">\r\n" + 
				"			function toLogin(){\r\n" + 
				"				location.href=\"loginPageServlet?\"+Math.random();\r\n" + 
				"			}\r\n" + 
				"		</script>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<form action=\"registerServlet\" method=\"post\">\r\n" + 
				"			UserName:<input type=\"text\" name=\"userName\"/><br/>\r\n" + 
				"			Password:<input type=\"password\" name=\"password\" /><br/>\r\n" + 
				"			Age:<input type=\"text\" name=\"age\" /><br/>\r\n" + 
				"			Phone:<input type=\"text\" name=\"phone\"/><br/>\r\n" + 
				"			<input type=\"radio\" value=\"男\" name=\"sex\"/>男\r\n" + 
				"			<input type=\"radio\" value=\"女\" name=\"sex\" />女<br/>\r\n" + 
				"			<input type=\"submit\" value=\"注册\" />\r\n" + 
				"			<input type=\"button\" value=\"返回登录\" onclick=\"toLogin()\"/>\r\n" + 
				"		</form>");
		String message = (String)request.getAttribute("message");
		if(message != null) {
		out.println("		<script type=\"text/javascript\">\r\n" + 
				"			alert(\""+message+"\");\r\n" + 
				"		</script>");
		}
		out.println("	</body>\r\n" + 
				"</html>");
	}

}
