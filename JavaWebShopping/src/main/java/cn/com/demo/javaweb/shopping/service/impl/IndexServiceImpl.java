package cn.com.demo.javaweb.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.shopping.dao.ISpCatalogueDAO;
import cn.com.demo.javaweb.shopping.dao.impl.SpCatalogueDAOImpl;
import cn.com.demo.javaweb.shopping.entity.SpCatalogue;
import cn.com.demo.javaweb.shopping.entity.SpProduct;
import cn.com.demo.javaweb.shopping.service.IIndexService;
import cn.com.demo.javaweb.shopping.service.IProductService;

public class IndexServiceImpl implements IIndexService {
	private IProductService proService = new ProductServiceImpl();
	private ISpCatalogueDAO cataDAO = new SpCatalogueDAOImpl();

	@Override
	public List<SpProduct> searchCataFirst() {
		List<SpProduct> proList = null;
		// 查询所有的类别
		List<SpCatalogue> cataList = this.cataDAO.findAll();

		if (cataList != null && cataList.size() > 0) {
			proList = new ArrayList<SpProduct>();
			for (SpCatalogue cata : cataList) {
				// 根据每个类别查询产品
				List<SpProduct> cataProList = this.proService.searchProductListByCate(cata.getCtId());
				// 获取每个类别中的第一个产品
				if(cataProList != null && cataProList.size()>0) {
					proList.add(cataProList.get(0));
				}
			}
		}
		return proList;
	}

}
