package cn.com.test;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.com.demo.mybatis.dao.ISpIdCardDAO;
import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class TestCacheMain {

	public static void main(String[] args) {
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSessionFactory factory = util.getSqlSessionFactory();

		SqlSession session1 = factory.openSession(true);
		SqlSession session3 = factory.openSession(true);
		
		SpUser u1 = session1.getMapper(ISpIdCardDAO.class).findUserByIcId(1);
		session1.close();
		
		SpUser u2 = session3.getMapper(ISpUserDAO.class).findById(1);
	}

}
