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
	public SpProduct searchById(int prId) {
		SpProduct pro = this.proDao.findById(prId);
		// 获取列表图片
		List<SpImage> imageList = this.imgDAO.findImages(1, pro.getPrCtId());
		if(imageList != null && imageList.size()>0) {
			// 查询列表上显示的小图片对象
			pro.setListPic(imageList.get(0));
		}
		return pro;
	}


	@Override
	public List<SpProduct> searchProductListByCate(int cataId) {
		List<SpProduct> proList = this.proDao.findByCataId(cataId);//.findByCondition(where, params);
		
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
