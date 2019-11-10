package cn.com.demo.javaweb.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchProductListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取当前页码
		//  如果没有获取页码参数值，默认页码值是1
		//  如果当前页码数，大于总页码数，页码数应该是总页码值
		// 获取查询条件
		// 调用产品Service，获取指定条件，指定页码的产品List
		// set request attribute
		// 转向searchProductList.jsp
	}

}
