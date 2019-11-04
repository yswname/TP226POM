package cn.com.demo.javaweb.shopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.demo.javaweb.shopping.entity.SpProduct;
import cn.com.demo.javaweb.shopping.service.IProductService;
import cn.com.demo.javaweb.shopping.service.IShopCarService;
import cn.com.demo.javaweb.shopping.service.impl.ProductServiceImpl;
import cn.com.demo.javaweb.shopping.service.impl.ShopCarServiceImpl;

@WebServlet("/addShopCarServlet")
public class AddShopCarServlet extends HttpServlet {
	private IProductService proService = new ProductServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取id
		String proIdStr = req.getParameter("prId");
		int proId = 0;
		try {
			proId = Integer.parseInt(proIdStr);
		} catch (Exception e) {
		}
		// 调用后面的service获取id对应的产品对象
		SpProduct product = this.proService.searchById(proId);
		String msg = "添加失败";
		try {
			// 添加到购物车
			// 0 session对象
			HttpSession session = req.getSession();
			// 1 获取购物车对象
			//  you: 添加
			//  wu:创建，再添加
			IShopCarService shopCar = (IShopCarService)session.getAttribute("SHOP_CAR");
			if(shopCar == null) {
				shopCar = new ShopCarServiceImpl();
				session.setAttribute("SHOP_CAR", shopCar);
			}
			shopCar.add(product);
			msg = "添加成功";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "添加失败:" + e.getMessage();
		}
		// 返回操作结果的提示信息
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print(msg);
		
	}

}
