package cn.com.demo.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class SpUserDAOImpl implements ISpUserDAO {
	private MyBatisUtil mybatisUtil = MyBatisUtil.getInstance();
	
	
	@Override
	public void add(SpUser user) {
		SqlSession session = mybatisUtil.getSession();
		try {
			ISpUserDAO userDAO = session.getMapper(ISpUserDAO.class);
			userDAO.add(user);
			session.commit();
		}catch(Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			mybatisUtil.close();
		}
		System.out.println(user);
	}

	@Override
	public List<SpUser> findAllByPaging(int start, int count) {
		List<SpUser> userList = null;
		SqlSession session = mybatisUtil.getSession();
		try {
			ISpUserDAO userDAO = session.getMapper(ISpUserDAO.class);
			userList = userDAO.findAllByPaging(start, count);
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			mybatisUtil.close();
		}
		return userList;
	}

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

	@Override
	public List<SpUser> findByIdOrUserName(int id, String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpUser> findByPaging(int id, String urUserName, int start, int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
