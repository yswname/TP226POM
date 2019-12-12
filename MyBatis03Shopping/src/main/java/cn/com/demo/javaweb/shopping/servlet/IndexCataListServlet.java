package cn.com.demo.javaweb.shopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.demo.javaweb.shopping.entity.SpCatalogue;
import cn.com.demo.javaweb.shopping.service.ICatalogueService;
import cn.com.demo.javaweb.shopping.service.impl.CatalogueServiceImpl;
@WebServlet("/indexCataListServlet")
public class IndexCataListServlet extends HttpServlet {
    private ICatalogueService catalogueService = new CatalogueServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<SpCatalogue> cataList = this.catalogueService.searchAllCatalogues();
		req.setAttribute("cataList", cataList);
		req.getRequestDispatcher("/WEB-INF/jsp/indexCataList.jsp").forward(req, resp);
	}

}
