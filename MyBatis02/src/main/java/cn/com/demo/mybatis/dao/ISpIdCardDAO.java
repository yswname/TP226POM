package cn.com.demo.mybatis.dao;

import cn.com.demo.mybatis.entity.SpIdCard;
import cn.com.demo.mybatis.entity.SpUser;

public interface ISpIdCardDAO {
    public void add(SpIdCard card);
    public SpUser findUserByIcId(int icId);
}
