package cn.com.demo.javaweb.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.demo.javaweb.shopping.service.IShopCarService;
import cn.com.demo.javaweb.shopping.service.ShopCarItem;

@WebServlet("/shopCarItemListServlet")
public class ShopCarItemListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// i)从购物车中获取items，转向shopCarItemList.jsp
		// 1 获取Session
		// 2 获取购物车
		// 3 获取shopCarItemList
		// 4 设置到request
		// 5 转向shopCarItemList.jsp

		HttpSession session = req.getSession();
		IShopCarService shopCar = (IShopCarService) session.getAttribute("SHOP_CAR");
		if (shopCar != null) {
			List<ShopCarItem> items = shopCar.getProList();
			req.setAttribute("itemList", items);
			if (items != null)
				req.setAttribute("itemSize", items.size());
		}
		req.getRequestDispatcher("/WEB-INF/jsp/shopCarItemList.jsp").forward(req, resp);

	}

}
