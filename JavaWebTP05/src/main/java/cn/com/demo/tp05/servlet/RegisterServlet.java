package cn.com.demo.tp05.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.tp05.entity.UserEntity;
import cn.com.demo.tp05.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 * 用户注册逻辑
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取数据
				request.setCharacterEncoding("UTF-8");// 对post请求得汉字进行转码
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				String ageStr = request.getParameter("age");
				String sex = request.getParameter("sex");
				String phone = request.getParameter("phone");
				int age = 0;
				try {
					age = Integer.parseInt(ageStr);
				} catch (Exception e) {
				}
				// 处理数据
				UserEntity user = new UserEntity();
				user.setUrAge(age);
				user.setUrPassword(password);
				user.setUrPhone(phone);
				user.setUrSex(sex);
				user.setUrUserName(userName);

				UserService userService = new UserService();
				String message = "注册成果";
				try {
					userService.registerUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					message = e.getMessage();
				}
				// 返回响应
				request.setAttribute("message", message);
				request.getRequestDispatcher("/registerPageServlet").forward(request, response);
	}

}
