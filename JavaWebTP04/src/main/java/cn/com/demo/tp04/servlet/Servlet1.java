package cn.com.demo.tp04.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 获取上一次的次数
		ServletContext ctx = this.getServletContext();
		Object obj = ctx.getAttribute("Servlet1Count");
		int count = 0;
		if (obj != null) {
			count = (Integer) obj;
		}
		// 2 ++
		count++;
		// 3 保存
		ctx.setAttribute("Servlet1Count", count);
		
		// HttpSession
		HttpSession session = request.getSession();
		session = request.getSession(true);
		// true:有对象，返回；如果没有，创建一个对象返回
		// false:有，返回；没有，null
		int sessionCount = 0;
		Object sessionCountObj = session.getAttribute("sessionCount");
		if(sessionCountObj != null) {
			sessionCount = (Integer)sessionCountObj;
		}	
		sessionCount++;
		session.setAttribute("sessionCount", sessionCount);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("访问Servlet1的次数是:" + count + ",sessionCount:" + sessionCount);
	}

}
