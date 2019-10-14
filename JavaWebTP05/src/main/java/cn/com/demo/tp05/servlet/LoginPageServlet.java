package cn.com.demo.tp05.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPageServlet 生成LoginPage页面
 */
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginPageServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "	<head>\r\n" + "		<meta charset=\"utf-8\">\r\n"
				+ "		<title></title>\r\n" + "		<script type=\"text/javascript\">\r\n"
				+ "			function toRegister(){\r\n"
				+ "				location.href=\"registerPageServlet?\"+Math.random();\r\n" + "			}\r\n"
				+ "		</script>\r\n" + "	</head>\r\n" + "	<body>\r\n"
				+ "		<form action=\"loginServlet\" method=\"post\">\r\n"
				+ "			UserName:<input type=\"text\" name=\"userName\"/><br/>\r\n"
				+ "			Password:<input type=\"password\" name=\"password\" /><br/>\r\n"
				+ "			<input type=\"submit\" value=\"登录\" />\r\n"
				+ "			<input type=\"button\" value=\"免费注册\" onclick=\"toRegister()\"/>\r\n"
				+ "		</form>\r\n");
		String msg = (String) request.getAttribute("message");
		if (msg != null) {
			out.print("		<script type=\"text/javascript\">\r\n" + "			alert(\""+msg+"\");\r\n"
					+ "		</script>");
		}
		out.println("	</body>\r\n" + "\r\n" + "</html>");
	}

}
