package cn.com.demo.ms.shopping.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.demo.javaweb.shopping.entity.SpCatalogue;
import cn.com.demo.javaweb.shopping.service.ICatalogueService;
import cn.com.demo.javaweb.shopping.service.impl.CatalogueServiceImpl;

@Controller
@RequestMapping("/cata")
public class CatalogueController {
	private ICatalogueService catalogueService = new CatalogueServiceImpl();
	@RequestMapping("/viewCataList.mvc")
    public String viewCataList(Model model) {
    	String result = "indexCataList";
    	
    	List<SpCatalogue> cataList = this.catalogueService.searchAllCatalogues();
    	model.addAttribute("cataList", cataList);
    	
    	return result;
    }
}
