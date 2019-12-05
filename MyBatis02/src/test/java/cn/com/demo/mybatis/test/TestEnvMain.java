package cn.com.demo.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.entity.SpUser;

public class TestEnvMain {

	public static void main(String[] args) throws Exception{
		Reader reader =Resources.getResourceAsReader("MyMyBatis.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader,"runtime");
		SqlSession session = factory.openSession();
		ISpUserDAO userDAO = session.getMapper(ISpUserDAO.class);
		SpUser user = userDAO.findByUserName("zhansan");
		System.out.println(user);
		
		String test = "#{new cn.com.demo.mybatis.entity.SpUser()}";
		Object obj = Ognl.getValue(test, new Object());
		System.out.println(obj);
		user = new SpUser();
		user.setUrUserName("111111111");
		System.out.println(user.getUrUserName());
		test = "{#root.getUrUserName()}";
		obj = Ognl.getValue(test, user);
		System.out.println(obj);
	}

}
