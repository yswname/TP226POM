package cn.com.demo.tp04.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.tp04.service.LoginService;

/**
 * Servlet implementation class DemoLoginServlet
 * 处理登录
 */
public class DemoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// super.service(request, response);
				// 获取数据
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				// 处理
				LoginService service = new LoginService();
				boolean bool = service.verifyPassword(userName, password);

                // 调用WelcomeServlet或者PageServlet
				if(bool) {
					// 转向WelcomeServlet
//					RequestDispatcher dispatcher = request.getRequestDispatcher("/demoWelcomeServlet");
//					// 转向
//					dispatcher.forward(request, response);
					
					// 重定向
					response.sendRedirect("demoWelcomeServlet");
					//response.sendRedirect("http://www.taobao.com");
				}else {
					// 使用request实现servlet之间的数据传递
					request.setAttribute("message", "登录失败，请重试");
					// 转向WelcomeServlet
					RequestDispatcher dispatcher = request.getRequestDispatcher("/demoLoginPageServlet");
					// 转向
					dispatcher.forward(request, response);
				}
	}

}
