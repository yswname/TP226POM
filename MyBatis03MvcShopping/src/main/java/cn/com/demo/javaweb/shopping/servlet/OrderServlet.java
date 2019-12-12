package cn.com.demo.javaweb.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取收货人相关的信息
		// 获取被选中的商品的id
		String[] proIds = req.getParameterValues("proIds");
		// 调用订单Service的下单方法
		// 转向当前页面
	}

}
