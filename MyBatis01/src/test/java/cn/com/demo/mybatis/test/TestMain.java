package cn.com.demo.mybatis.test;

import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.demo.mybatis.entity.SpUser;

public class TestMain {

	public static void main(String[] args) throws Exception{
		SpUser user = new SpUser();
		user.setUrPassword("123456");
		user.setUrUserName("mybatis01");

        // 读配置文件
		Reader reader = Resources.getResourceAsReader("MyMyBatis.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory factory = builder.build(reader);
		SqlSession session = factory.openSession();
//		session.insert("cn.com.demo.mybatis.dao.ISpUserDAO.addUser", user);
//		session.commit();
		
		SpUser user1 = (SpUser)session.selectOne("cn.com.demo.mybatis.dao.ISpUserDAO.findByUserName", "zhangsan");
		System.out.println(user1);
	}

}
