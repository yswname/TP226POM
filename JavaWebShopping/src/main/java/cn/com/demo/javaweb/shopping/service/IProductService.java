package cn.com.demo.javaweb.shopping.service;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.SpProduct;

public interface IProductService {
    public List<SpProduct> searchProductListByCate(int cataId);
    public SpProduct searchById(int prId);
}
