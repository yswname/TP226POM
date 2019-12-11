package cn.com.demo.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.demo.mybatis.dao.ISpIdCardDAO;
import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class TestCache02 {

	public static void main(String[] args) throws Exception {
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSessionFactory factory = util.getSqlSessionFactory();

		SqlSession session1 = factory.openSession(true);
		SqlSession session2 = factory.openSession(true);
		SqlSession session3 = factory.openSession(true);
		
		SpUser u1 = session1.getMapper(ISpIdCardDAO.class).findUserByIcId(1);
		session1.close();
		
		SpUser u2 = session3.getMapper(ISpUserDAO.class).findById(1);
		
		

	}

	public static void test2() throws Exception {
		SqlSessionFactory f1 = getFactory();
		SqlSessionFactory f2 = getFactory();

		SqlSession s1 = f1.openSession(true);
		SqlSession s2 = f2.openSession(true);

		SpUser u1 = s1.getMapper(ISpUserDAO.class).findById(1);
		s1.close();
		SpUser u2 = s2.getMapper(ISpUserDAO.class).findById(1);
		s2.close();
		System.out.println("--------------------------");
		s1 = f1.openSession(true);
		s2 = f2.openSession(true);

		u1 = s1.getMapper(ISpUserDAO.class).findById(1);
		u2 = s2.getMapper(ISpUserDAO.class).findById(1);
		System.out.println(u1);
		u1.setUrPassword("bbbbb");
		s1.getMapper(ISpUserDAO.class).update(u1);
		s1.commit();
		System.out.println("---------------------------");
		u2 = s2.getMapper(ISpUserDAO.class).findById(1);
		System.out.println(u2);
	}

	public static SqlSessionFactory getFactory() throws Exception {
		Reader reader = Resources.getResourceAsReader("MyMyBatis.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		return builder.build(reader);
	}

	public static void test1() throws Exception {
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSessionFactory factory = util.getSqlSessionFactory();

		SqlSession session1 = factory.openSession(true);
		SqlSession session2 = factory.openSession(true);

		SpUser user1 = session1.getMapper(ISpUserDAO.class).findById(1);
		// close当前的session后，才将当前session中的一级缓存的数据，移到到二级缓存中
		session1.close();
		SpUser user2 = session2.getMapper(ISpUserDAO.class).findById(1);

		System.out.println(user1);
		System.out.println(user2);

		System.out.println("-----------------------");
		SqlSession session3 = factory.openSession(true);
		SpUser user3 = session3.getMapper(ISpUserDAO.class).findById(1);
		user3.setUrPassword("aaaaa");
		session3.getMapper(ISpUserDAO.class).update(user3);
		session3.commit();
		// session3.close();

		user2 = session2.getMapper(ISpUserDAO.class).findById(1);
		System.out.println(user2);
	}

}
