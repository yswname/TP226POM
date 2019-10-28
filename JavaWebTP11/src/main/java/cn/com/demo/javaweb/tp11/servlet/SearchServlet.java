package cn.com.demo.javaweb.tp11.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.javaweb.tp11.xml.Student;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		// 根据name查询数据库
		Student stu = new Student();
		stu.setAge(10);
		stu.setName(name);
		stu.setCode("0002");
		//
		response.setContentType("text/json;charset=utf-8");
		response.getWriter()
				.print("{\"name\":\"" + stu.getName() + "\",\"age\":" + stu.getAge() + ",\"code\":\"" + stu.getCode() + "\"}");
	}

}
