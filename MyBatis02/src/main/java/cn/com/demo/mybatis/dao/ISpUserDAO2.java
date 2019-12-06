package cn.com.demo.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.com.demo.mybatis.entity.SpUser;

public interface ISpUserDAO2 {
     public List<SpUser> find2(SpUser user);
     public List<SpUser> find3(Map<String,Object> values);
     public List<SpUser> find4(List<Object> values);
     public List<SpUser> find5(Object[] values);
}
