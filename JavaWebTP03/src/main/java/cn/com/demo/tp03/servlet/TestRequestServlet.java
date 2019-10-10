package cn.com.demo.tp03.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestRequestServlet
 */
public class TestRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestRequestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 研究获取请求数据
		String methodName = request.getMethod();
		String uri = request.getRequestURI();
		StringBuffer urlBuff = request.getRequestURL();
		String proto = request.getProtocol();
		
		String hostValue = request.getHeader("Host");
		Enumeration<String> enum1 = request.getHeaders("Host");
		boolean bool = enum1.hasMoreElements();
		String s = enum1.nextElement();
		Enumeration<String> headerNames = request.getHeaderNames();
		
		String userName = request.getParameter("userName");
		String[] likes = request.getParameterValues("likes");
		Enumeration<String> paraNames = request.getParameterNames();
		Map<String,String[]> paramMap = request.getParameterMap();
		
		String queryString = request.getQueryString();
		
		ServletInputStream in = request.getInputStream();
		
		// 基本上是由服务器设置
		response.setContentType("text/html;charset=utf-8");
//		response.setHeader(name, value);
//		response.addHeader(name, value);
//		response.setStatus(sc, sm);
		
		PrintWriter out = response.getWriter();
		ServletOutputStream out2 = response.getOutputStream();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
