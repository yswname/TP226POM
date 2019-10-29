package cn.com.demo.javaweb.tp11.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/xmlServlet")
public class XmlServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<?xml version='1.0' encoding='utf-8'?>");
		out.println("<classes>");
		out.println("   <stu code='001' aliaName='zhangsan1'>");
		out.println("      <name>张三</name>");
		out.println("      <age>11</age>");
		out.println("   </stu>");
		out.println("   <stu code='002' aliaName='zhangsan2'>");
		out.println("      <name>张三2</name>");
		out.println("      <age>12</age>");
		out.println("   </stu>");
		out.println("</classes>");
	}

}
