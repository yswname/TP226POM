package cn.com.demo.mybatis.dao.impl;

import cn.com.demo.mybatis.dao.ISpIdCardDAO;
import cn.com.demo.mybatis.entity.SpIdCard;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class SpIdCardDAOImpl implements ISpIdCardDAO {
	private MyBatisUtil util = MyBatisUtil.getInstance();

	@Override
	public void add(SpIdCard card) {
		ISpIdCardDAO cardDAO = util.getSession().getMapper(ISpIdCardDAO.class);
		try {
			cardDAO.add(card);
			util.getSession().commit();
		} catch (Exception e) {
			util.getSession().rollback();
			throw new RuntimeException(e);
		} finally {
			util.close();
		}
	}

}