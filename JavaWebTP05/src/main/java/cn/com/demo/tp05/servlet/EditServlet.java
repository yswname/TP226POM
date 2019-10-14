package cn.com.demo.tp05.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.tp05.entity.UserEntity;
import cn.com.demo.tp05.service.UserService;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends ControllerServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
		request.setCharacterEncoding("UTF-8");// 对post请求得汉字进行转码
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String ageStr = request.getParameter("age");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String idStr = request.getParameter("id");
		int age = 0, id = 0;
		try {
			age = Integer.parseInt(ageStr);
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
		}
		// 处理数据
		UserEntity user = new UserEntity();
		user.setUrAge(age);
		user.setUrPassword(password);
		user.setUrPhone(phone);
		user.setUrSex(sex);
		user.setUrUserName(userName);
		user.setUrId(id);

		UserService userService = new UserService();
		String message = "更新成功！";
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("/editPageServlet").forward(request, response);
	}

}
