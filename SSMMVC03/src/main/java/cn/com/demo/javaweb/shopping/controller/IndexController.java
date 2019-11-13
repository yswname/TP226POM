package cn.com.demo.javaweb.shopping.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.demo.javaweb.shopping.entity.SpProduct;
import cn.com.demo.javaweb.shopping.service.IIndexService;
import cn.com.demo.javaweb.shopping.service.impl.IndexServiceImpl;

@Controller
public class IndexController {
	private IIndexService indexService = new IndexServiceImpl();

	@RequestMapping("/indexListProductServlet")
	public String indexListProductServlet(Model model) {
		// 获取每类的第一个产品集合
		List<SpProduct> proList = this.indexService.searchCataFirst();
		// 设置到request中
		model.addAttribute("firstProList", proList);
		return "indexProList";
	}
}
