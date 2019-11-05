package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.SpShopCarItem;

public interface IShopCarItemDAO {
    public void add(SpShopCarItem item);
    public void update(SpShopCarItem item);
    public void delete(SpShopCarItem item);
    public void deleteByUrId(int urId);
    public SpShopCarItem findById(int itId);
    public List<SpShopCarItem> findByUrId(int urId);
    public SpShopCarItem find(int urId, int prId);
}
