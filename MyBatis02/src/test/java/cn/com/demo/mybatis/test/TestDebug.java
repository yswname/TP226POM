package cn.com.demo.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.demo.mybatis.entity.SpUser;

public class TestDebug {

	public static void main(String[] args) throws Exception {
		// 读配置文件
		Reader reader = Resources.getResourceAsReader("MyMyBatis.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);
		SqlSession session = factory.openSession();
		SpUser user = (SpUser)session.selectOne("cn.com.demo.mybatis.dao.ISpUserDAO.findByUserName","my12");
		System.out.println(user);
	}

}
