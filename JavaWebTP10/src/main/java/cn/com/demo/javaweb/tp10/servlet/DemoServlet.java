package cn.com.demo.javaweb.tp10.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.javaweb.tp10.bean.User;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 User u = new User();
	       u.setAge(10);
	       u.setUserName("zhangsan");
	       //pageContext.setAttribute("user", u);
	       
	       u = new User();
	       u.setUserName("lisi");
	       request.setAttribute("user", u);
	       // 就近原则
	       // EL表达式的隐式对象
	       u = new User();
	       u.setUserName("wangwu");
	       request.getSession().setAttribute("user", u);
	       
	       u = new User();
	       u.setUserName("zhaoliu");
	       request.getServletContext().setAttribute("user", u);
	       
	       request.getRequestDispatcher("/testEL01.jsp").forward(request, response);
	}

}
