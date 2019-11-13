package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.SpCatalogue;

public interface ISpCatalogueDAO {
    public List<SpCatalogue> findAll();
}
