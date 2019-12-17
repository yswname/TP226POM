package cn.com.ssm.shopping.service;

import java.util.List;

import cn.com.ssm.shopping.entity.SpProduct;

public interface IProductService {
    public List<SpProduct> searchProductListByCate(int cataId);
    public SpProduct searchById(int prId);
}
