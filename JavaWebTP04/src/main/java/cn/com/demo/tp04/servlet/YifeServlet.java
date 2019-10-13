package cn.com.demo.tp04.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LifeServlet
 */
public class YifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public YifeServlet() {
		System.out.println("create LifeServlet");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 操作conf
		String userName = config.getInitParameter("userName");
		String password = config.getInitParameter("password");

//		config.getInitParameterNames();
		System.out.println("init LifeServlet userName:" + userName +",password:" + password);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destory LifeServlet");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();
		String userName = config.getInitParameter("userName");
		String password = config.getInitParameter("password");
//		config.getInitParameterNames();
		System.out.println("service LifeServlet userName:" + userName +",password:" + password);
		
		ServletContext ctx = config.getServletContext();
		this.getServletContext();
		request.getServletContext();
		HttpSession session =  null;
//		session.getServletContext();
		
		String ctxName = ctx.getInitParameter("name");
		
		//ctx.addServlet(servletName, servletClass)
		
		ServletRegistration registration = ctx.addServlet("DemoServlet", DemoServlet.class);
		registration.addMapping("/demoServlet");
		
//		request.setAttribute("", new Object());
//		request.getAttribute(name)
//		request.removeAttribute(name);
//		
//		ctx.setAttribute(name, object);
//		ctx.getAttribute(name)
//		ctx.removeAttribute(name);
	}

}
