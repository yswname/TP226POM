package cn.com.demo.tp05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.tp05.entity.UserEntity;
import cn.com.demo.tp05.service.UserService;

/**
 * Servlet implementation class LoginServlet 登录逻辑
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取数据
		request.setCharacterEncoding("UTF-8");// 对post请求得汉字进行转码
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		UserService userService = new UserService();

		boolean bool = false;
		String message = null;
		try {
			bool = userService.verifyUser(userName, password);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		// 返回响应
		if(bool) {
			// ok
			request.getRequestDispatcher("/userListServlet").forward(request, response);
		}else {
			// fail
			if(message == null) {
				message = "登录失败，请重试!";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("/loginPageServlet").forward(request, response);
		}
	}

}
