package cn.com.demo.javaweb.shopping.service.impl;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.SpProduct;
import cn.com.demo.javaweb.shopping.service.IIndexService;
import cn.com.demo.javaweb.shopping.service.IProductService;

public class IndexServiceImpl implements IIndexService {
    private IProductService proService = new ProductServiceImpl();
	@Override
	public List<SpProduct> searchCataFirst() {
		
		return null;
	}

}
