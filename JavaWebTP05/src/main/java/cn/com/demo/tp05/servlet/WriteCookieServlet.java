package cn.com.demo.tp05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteCookieServlet
 */
public class WriteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = "zhangsan";
		Cookie cookie = new Cookie("userName",userName);
		
		Cookie cookie2 = new Cookie("age","18");
		Cookie cookie3 = new Cookie("age","20");
		cookie3.setMaxAge(30);
		//Cookie cookie4 = new Cookie("name","张三");
		response.addCookie(cookie);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		//response.addCookie(cookie4);
	}

}
