package cn.com.demo.javaweb.shopping.dao;

import java.util.List;

import cn.com.demo.javaweb.shopping.entity.SpImage;

public interface ISpImageDAO {
    public List<SpImage> findImages(int type, int prId);
}
