package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.SpShopCarItem;

public interface IShopCarItemDAO {
	/**
	 *  添加新的对象
	 * @param item
	 */
    public void add(SpShopCarItem item);
    /**
     *  根据prId和urId，更新数量
     * @param item
     */
    public void update(SpShopCarItem item);
    /**
     *  根据prId和urId删除
     * @param item
     */
    public void delete(SpShopCarItem item);
    /**
     *  根据urId删除
     * @param urId
     */
    public void deleteByUrId(int urId);
    /**
     *  根据itId查询
     * @param itId
     * @return
     */
    public SpShopCarItem findById(int itId);
    /**
     *  根据urId查询
     * @param urId
     * @return
     */
    public List<SpShopCarItem> findByUrId(int urId);
    /**
     *  根据urId和prId查询
     * @param urId
     * @param prId
     * @return
     */
    public SpShopCarItem find(int urId, int prId);
}
