package cn.com.ssm.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ssm.shopping.entity.SpCatalogue;
import cn.com.ssm.shopping.entity.SpProduct;
import cn.com.ssm.shopping.service.ICatalogueService;
import cn.com.ssm.shopping.service.IIndexService;

@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	private ICatalogueService catalogueService;
	@Autowired
	private IIndexService indexService;
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
