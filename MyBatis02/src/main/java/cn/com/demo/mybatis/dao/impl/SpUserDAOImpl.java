package cn.com.demo.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class SpUserDAOImpl implements ISpUserDAO {
	private MyBatisUtil mybatisUtil = MyBatisUtil.getInstance();
	@Override
	public void save(SpUser user) {
		SqlSession session = mybatisUtil.getSession();
		try {
			session.insert("cn.com.demo.mybatis.dao.ISpUserDAO.addUser", user);
			session.commit();
		}catch(Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			mybatisUtil.close();
		}
	}

	@Override
	public SpUser findByUserName(String userName) {
		SpUser user = null;
		SqlSession session = mybatisUtil.getSession();
		try {
			user = (SpUser)session.selectOne("cn.com.demo.mybatis.dao.ISpUserDAO.findByUserName", userName);
			//session.selectList(statement)
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			mybatisUtil.close();
		}
		return user;
	}

}
