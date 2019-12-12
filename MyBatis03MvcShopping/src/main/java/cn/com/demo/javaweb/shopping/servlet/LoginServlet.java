package cn.com.demo.javaweb.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.demo.javaweb.shopping.entity.SpUser;
import cn.com.demo.javaweb.shopping.service.IShopCarService;
import cn.com.demo.javaweb.shopping.service.ISystemControlService;
import cn.com.demo.javaweb.shopping.service.ShopCarItem;
import cn.com.demo.javaweb.shopping.service.impl.ShopCarServiceImpl;
import cn.com.demo.javaweb.shopping.service.impl.ShopCarServiceImpl4DB;
import cn.com.demo.javaweb.shopping.service.impl.SystemControlServiceImpl;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private ISystemControlService sysService = new SystemControlServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		a）完成登录验证
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		String forwardJsp = "index.html";
		try {
			SpUser user = this.sysService.verify(userName, password);
//	    b）成功
			if (user != null) {
				// 添加登录标记
				HttpSession session = req.getSession();
				session.setAttribute("LOGIN_USER", user);
//	       i）购物车的同步
				IShopCarService shopCar = (IShopCarService) session.getAttribute("SHOP_CAR");
				if (shopCar != null && shopCar instanceof ShopCarServiceImpl) {
					// 1 获取以前购物车中的所有商品和数量
					List<ShopCarItem> sessionItemList = shopCar.getProList();
					// 2 创建DB购物车对象
					shopCar = new ShopCarServiceImpl4DB();
					shopCar.setUserId(user.getUrId());
					// 3 循环的将以前的商品和数量，添加到DB购物车
					for(ShopCarItem item:sessionItemList) {
						shopCar.add(item.getPro(), item.getCount());
					}
				} else {
					// 创建db购物车
					shopCar = new ShopCarServiceImpl4DB();
					shopCar.setUserId(user.getUrId());
				}
				// 4 用DB购物车对象，替换session中的老对象
				session.setAttribute("SHOP_CAR", shopCar);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "登录失败:" + e.getMessage());
			forwardJsp = "WEB-INF/jsp/login.jsp";
		}
		// ii）转向成功登录（index.html）
		req.getRequestDispatcher("/" + forwardJsp).forward(req, resp);
	}

}
