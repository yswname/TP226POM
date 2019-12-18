package cn.com.ssm.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ssm.shopping.entity.SpCatalogue;
import cn.com.ssm.shopping.entity.SpProduct;
import cn.com.ssm.shopping.service.ICatalogueService;
import cn.com.ssm.shopping.service.IIndexService;
import cn.com.ssm.shopping.service.IShopCarService;
import cn.com.ssm.shopping.service.ShopCarItem;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private ICatalogueService catalogueService;
	@Autowired
	private IIndexService indexService;
	
	@RequestMapping("/shopCarItemList.mvc")
	public String shopCarItemList(HttpSession session, String type, Model model) {
		String result = "shopCarItemList";
		
		IShopCarService shopCar = (IShopCarService) session.getAttribute("SHOP_CAR");
		if (shopCar != null) {
			List<ShopCarItem> items = shopCar.getProList();
			model.addAttribute("itemList", items);
			if (items != null)
				model.addAttribute("itemSize", items.size());
		}

		if ("1".equals(type)) {
			result = "jsShopCarItemList";
		}
		
		return result;
	}
	
	
	@RequestMapping("/indexCataList.mvc")
	public String indexCataList(Model model) {
		List<SpCatalogue> cataList = this.catalogueService.searchAllCatalogues();
		model.addAttribute("cataList", cataList);
		return "indexCataList";
	}

	@RequestMapping("/indexProList.mvc")
	public String indexProList(Model model) {
		// 获取每类的第一个产品集合
		List<SpProduct> proList = this.indexService.searchCataFirst();
		// 设置到request中
		model.addAttribute("firstProList", proList);
		return "indexProList";
	}
}
