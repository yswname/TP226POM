package cn.com.demo.tp05.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String noLogin = request.getParameter("ckbNoLogin");

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
		if (bool) {
			if ("1".equals(noLogin)) {
				// 添加免登录得cookie
				Cookie cookie = new Cookie("ckbNoLogin1", "true");
				cookie.setMaxAge(60);
				response.addCookie(cookie);
			}
			// 往session中存放一个登录标记
			HttpSession session = request.getSession();
			System.out.println(session.getId());
			session.setAttribute("LOGIN_FLAG", userName);
			// ok
			request.getRequestDispatcher("/userListServlet").forward(request, response);
		} else {
			// fail
			if (message == null) {
				message = "登录失败，请重试!";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("/loginPageServlet").forward(request, response);
		}
	}

}
