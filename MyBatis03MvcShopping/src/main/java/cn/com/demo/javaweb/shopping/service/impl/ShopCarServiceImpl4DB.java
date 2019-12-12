package cn.com.demo.javaweb.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.demo.javaweb.shopping.dao.IShopCarItemDAO;
import cn.com.demo.javaweb.shopping.dao.ISpProductDAO;
import cn.com.demo.javaweb.shopping.dao.impl.ShopCarItemDAOImpl;
import cn.com.demo.javaweb.shopping.dao.impl.SpProductDAOImpl;
import cn.com.demo.javaweb.shopping.entity.SpProduct;
import cn.com.demo.javaweb.shopping.entity.SpShopCarItem;
import cn.com.demo.javaweb.shopping.service.IProductService;
import cn.com.demo.javaweb.shopping.service.IShopCarService;
import cn.com.demo.javaweb.shopping.service.ShopCarItem;

public class ShopCarServiceImpl4DB implements IShopCarService {
	private IShopCarItemDAO carDAO = new ShopCarItemDAOImpl();
	private ISpProductDAO productDAO = new SpProductDAOImpl();
	IProductService productService = new ProductServiceImpl();

	private int urId;

	@Override
	public void setUserId(int urId) {
		this.urId = urId;
	}

	@Override
	public void add(SpProduct pro) {
		this.add(pro, 1);
	}

	@Override
	public void add(SpProduct pro, int number) {
		if (pro != null) {
			SpShopCarItem item = this.carDAO.find(urId, pro.getPrId());
			if(item == null) {
				// 没有
				item = new SpShopCarItem();
				item.setCarItNumber(number);
				item.setCarItPrId(pro.getPrId());
				item.setCarItUrId(urId);
				// 插入
				this.carDAO.add(item);
			}else {
				item.setCarItNumber(item.getCarItNumber()+number);
				// 更新(urId+prId)
				this.carDAO.update(item);
			}
		}
	}

	@Override
	public void edit(SpProduct pro, int number) {
		if(pro != null) {
			SpShopCarItem item = this.carDAO.find(urId, pro.getPrId());
			if(item == null) {
				// 没有
				item = new SpShopCarItem();
				item.setCarItNumber(number);
				item.setCarItPrId(pro.getPrId());
				item.setCarItUrId(urId);
				// 插入
				this.carDAO.add(item);
			}else {
				item.setCarItNumber(number);
				// 更新(urId+prId)
				this.carDAO.update(item);
			}
		}
	}

	@Override
	public void remove(SpProduct pro) {
		if(pro != null) {
			SpShopCarItem item =new SpShopCarItem();
			item.setCarItPrId(pro.getPrId());
			item.setCarItUrId(urId);
			this.carDAO.delete(item);
		}
	}

	@Override
	public void clear() {
		this.carDAO.deleteByUrId(urId);
	}

	@Override
	public int sumCount() {
		int count = 0;
		List<SpShopCarItem> dbItems = this.carDAO.findByUrId(urId);
		if(dbItems != null) {
			for(SpShopCarItem item:dbItems) {
				count += item.getCarItNumber();
			}
		}
		return count;
	}

	@Override// 数据库中的item查询出来，封装成代码中的item
	public List<ShopCarItem> getProList() {
		List<ShopCarItem> items = null;
		
		// 查询数据库对象
		List<SpShopCarItem> dbItems = this.carDAO.findByUrId(urId);
		// 封装成ShopCarItem
		if(dbItems != null) {
			items = new ArrayList<ShopCarItem>();
			ShopCarItem item = null;
			for(SpShopCarItem dbItem:dbItems) {
				item = new ShopCarItem();
				item.setCount(dbItem.getCarItNumber());
				//item.setPro(this.productDAO.findById(dbItem.getCarItPrId()));
				SpProduct product = this.productService.searchById(dbItem.getCarItPrId());
				item.setPro(product);
				
				items.add(item);
			}
		}
		
		return items;
	}

}
