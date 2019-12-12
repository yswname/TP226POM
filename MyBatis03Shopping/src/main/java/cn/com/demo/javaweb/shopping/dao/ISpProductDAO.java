package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.SpProduct;

public interface ISpProductDAO {
    //public List<SpProduct> findByCondition(String whereSql,List params);
	public List<SpProduct> findByCataId(int cataId);
    public SpProduct findById(int prId);
}
