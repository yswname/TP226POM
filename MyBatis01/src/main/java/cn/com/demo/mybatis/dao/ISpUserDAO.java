package cn.com.demo.mybatis.dao;

import cn.com.demo.mybatis.entity.SpUser;

public interface ISpUserDAO {
    public void save(SpUser user);
    public SpUser findByUserName(String userName);
}
