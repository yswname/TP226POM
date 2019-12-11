package cn.com.demo.mybatis.dao;

import cn.com.demo.mybatis.entity.SpUser;

public interface ISpIdCardDAO {
    public SpUser findUserByIcId(int icId);
}
