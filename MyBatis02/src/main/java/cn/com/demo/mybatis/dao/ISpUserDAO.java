package cn.com.demo.mybatis.dao;

import java.util.List;

import cn.com.demo.mybatis.entity.SpUser;

public interface ISpUserDAO {
	public SpUser findById(int urId);
    public void save(SpUser user);
    //default void add(SpUser user) {}; rownum rowid
    public void add(SpUser user);
    public SpUser findByUserName(String userName);
    public List<SpUser> findByIdOrUserName(int id, String userName);
    public List<SpUser> findByPaging(int id, String urUserName, int start, int count);
    // mysql  limit begin,length
    public List<SpUser> findAllByPaging(int start, int count);
    public void update(SpUser user);
}
