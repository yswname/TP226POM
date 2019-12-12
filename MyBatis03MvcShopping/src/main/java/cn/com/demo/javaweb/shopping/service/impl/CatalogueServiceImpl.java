package cn.com.demo.javaweb.shopping.service.impl;

import java.util.List;

import cn.com.demo.javaweb.shopping.dao.ISpCatalogueDAO;
import cn.com.demo.javaweb.shopping.dao.impl.SpCatalogueDAOImpl;
import cn.com.demo.javaweb.shopping.entity.SpCatalogue;
import cn.com.demo.javaweb.shopping.service.ICatalogueService;

public class CatalogueServiceImpl implements ICatalogueService {
    private ISpCatalogueDAO catalogueDAO = new SpCatalogueDAOImpl();
	@Override
	public List<SpCatalogue> searchAllCatalogues() {
		return this.catalogueDAO.findAll();
	}

}
