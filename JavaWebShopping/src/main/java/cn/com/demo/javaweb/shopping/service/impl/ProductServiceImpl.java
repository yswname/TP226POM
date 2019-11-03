package cn.com.demo.javaweb.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.shopping.dao.ISpProductDAO;
import cn.com.demo.javaweb.shopping.dao.impl.SpProductDAOImpl;
import cn.com.demo.javaweb.shopping.entity.SpProduct;
import cn.com.demo.javaweb.shopping.service.IProductService;

public class ProductServiceImpl implements IProductService {
    private ISpProductDAO proDao = new SpProductDAOImpl();
	@Override
	public List<SpProduct> searchProductListByCate(int cataId) {
		String where = " where pr_ct_id = ?";
		List params = new ArrayList();
		params.add(cataId);
		return this.proDao.findByCondition(where, params);
	}

}
