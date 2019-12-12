package cn.com.demo.javaweb.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.demo.javaweb.shopping.service.IShopCarService;
@WebServlet("/showProductCountServlet")
public class ShowProductCountServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取session
		HttpSession session = req.getSession();
		// 获取购物
		IShopCarService shopCar = (IShopCarService)session.getAttribute("SHOP_CAR");
		// 获取数量
		int count = 0;
		if(shopCar != null) {
			count = shopCar.sumCount();
		}
		// 返回
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(count);
	}

}
