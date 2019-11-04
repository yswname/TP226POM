package cn.com.demo.javaweb.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.shopping.dao.ISpImageDAO;
import cn.com.demo.javaweb.shopping.dao.ISpProductDAO;
import cn.com.demo.javaweb.shopping.dao.impl.SpImageDAOImpl;
import cn.com.demo.javaweb.shopping.dao.impl.SpProductDAOImpl;
import cn.com.demo.javaweb.shopping.entity.SpImage;
import cn.com.demo.javaweb.shopping.entity.SpProduct;
import cn.com.demo.javaweb.shopping.service.IProductService;

public class ProductServiceImpl implements IProductService {
    private ISpProductDAO proDao = new SpProductDAOImpl();
    private ISpImageDAO imgDAO = new SpImageDAOImpl();
	@Override
	public List<SpProduct> searchProductListByCate(int cataId) {
		String where = " where pr_ct_id = ?";
		List params = new ArrayList();
		params.add(cataId);
		List<SpProduct> proList = this.proDao.findByCondition(where, params);
		
		// 设置好查询列表的小图片
		if(proList != null) {
			for(SpProduct pro:proList) {
				List<SpImage> imageList = this.imgDAO.findImages(1, pro.getPrCtId());
				if(imageList != null && imageList.size()>0) {
					// 查询列表上显示的小图片对象
					pro.setListPic(imageList.get(0));
				}
			}
		}
		
		return proList;
	}

}
