package cn.com.demo.javaweb.shopping.service;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.SpProduct;

public interface IShopCarService {
	// session中的购物车
    public void add(SpProduct pro);
    public void add(SpProduct pro, int number);
    public void edit(SpProduct pro, int number);
    public void remove(SpProduct pro);
    public void clear();
    public int sumCount();
    public List<ShopCarItem> getProList();
    public void setUserId(int urId);
}
