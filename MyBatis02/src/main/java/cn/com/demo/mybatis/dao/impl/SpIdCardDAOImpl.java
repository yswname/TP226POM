package cn.com.demo.mybatis.dao.impl;

import cn.com.demo.mybatis.dao.ISpIdCardDAO;
import cn.com.demo.mybatis.entity.SpIdCard;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class SpIdCardDAOImpl implements ISpIdCardDAO {
	private MyBatisUtil util = MyBatisUtil.getInstance();

	@Override
	public SpUser findUserByIcId(int icId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(SpIdCard card) {
		ISpIdCardDAO cardDAO = util.getSession().getMapper(ISpIdCardDAO.class);
		try {
			cardDAO.add(card);
			// SqlSession的线程安全性
			util.getSession().commit();
		} catch (Exception e) {
			util.getSession().rollback();
			throw new RuntimeException(e);
		} finally {
			util.close();
		}
	}

}
