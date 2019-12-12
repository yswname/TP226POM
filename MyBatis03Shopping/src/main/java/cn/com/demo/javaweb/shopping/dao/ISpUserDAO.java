package cn.com.demo.javaweb.shopping.dao;

import cn.com.demo.javaweb.shopping.entity.SpUser;

public interface ISpUserDAO {
    public SpUser findByUserName(String userName);
}
