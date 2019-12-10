package cn.com.demo.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class SpUserDAOImpl2 implements ISpUserDAO {
	private MyBatisUtil mybatisUtil = MyBatisUtil.getInstance();

	@Override
	public SpUser findById(int urId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SpUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(SpUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(SpUser user) {
		SqlSession session = this.mybatisUtil.getSession();
		try {
			// 动态绑定
			ISpUserDAO userDAO = session.getMapper(ISpUserDAO.class);
			userDAO.save(user);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			this.mybatisUtil.close();
		}
	}

	@Override
	public SpUser findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public List<SpUser> findAllByPaging(int start, int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
