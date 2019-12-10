package cn.com.demo.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class TestCache01 {

	public static void main(String[] args) throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSessionFactory factory = util.getSqlSessionFactory();
		SqlSession session1 = factory.openSession(true);
		SqlSession session2 = factory.openSession(true);
		
		SpUser user1 = session1.getMapper(ISpUserDAO.class).findByUserName("my12");
		SpUser user2 = session2.getMapper(ISpUserDAO.class).findByUserName("my12");
		
		System.out.println(user1);
		System.out.println(user2);
		System.out.println("************************");
		user1.setUrPassword("999");
		session1.getMapper(ISpUserDAO.class).update(user1);
		
		user1 = session1.getMapper(ISpUserDAO.class).findByUserName("my12");
		user2 = session2.getMapper(ISpUserDAO.class).findByUserName("my12");
		System.out.println(user1);
		System.out.println(user2);
	}

}
