package cn.com.ssm.shopping.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import cn.com.ssm.shopping.entity.SpUser;
import cn.com.ssm.shopping.service.IShopCarService;
import cn.com.ssm.shopping.service.ISystemControlService;
import cn.com.ssm.shopping.service.ShopCarItem;
import cn.com.ssm.shopping.service.impl.ShopCarServiceImpl;
import cn.com.ssm.shopping.service.impl.ShopCarServiceImpl4DB;

@Controller
@RequestMapping("/system")
@SessionScope
public class SystemController {
	@Autowired
	@Qualifier("shopCarService4DB")
	private IShopCarService carService;
	@Autowired
	private ISystemControlService sysService;
	
	@RequestMapping(value="/login.mvc", method=RequestMethod.POST)
    public String login(String userName, String password, HttpSession session, ServletContext ctx, Model model) {
    	String forwardJsp = "index.html";
    	
//		a）完成登录验证

		try {
			SpUser user = this.sysService.verify(userName, password);
//	    b）成功
			if (user != null) {
				// 添加登录标记
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
					//shopCar = new ShopCarServiceImpl4DB();
					// 从容器中获取
					// 1 获取容器
//					WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
//					// 2 根据名称获取对象(没有用户一一对应，不能是单例模式)
//					shopCar = (IShopCarService)context.getBean("shopCarService4DB");
					
					shopCar = this.carService;
					shopCar.setUserId(user.getUrId());
				}
				// 4 用DB购物车对象，替换session中的老对象
				session.setAttribute("SHOP_CAR", shopCar);
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", "登录失败:" + e.getMessage());
			forwardJsp = "login";
		}
		// ii）转向成功登录（index.html）
    	forwardJsp = "redirect:../"+forwardJsp;
    	return forwardJsp;
    }
}
