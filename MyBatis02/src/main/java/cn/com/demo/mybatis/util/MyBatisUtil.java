package cn.com.demo.mybatis.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static MyBatisUtil util = new MyBatisUtil();
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> tlSqlSession = new ThreadLocal<SqlSession>();
	static {
		init();
	}
	
	private MyBatisUtil() {}
	public static MyBatisUtil getInstance() {
		return util;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		if(factory == null) {
			init();
		}
		return factory;
	}

	public SqlSession getSession() {
		SqlSession sqlSession = null;
		// 从threadLocal中获取SqlSession
		sqlSession = tlSqlSession.get();
		// 如果有，并且有效，直接方法
		// 如果没有，或者无效
		if (sqlSession == null) {
			// 判断factory是否为null
			if (factory == null) {
				init();
			}
			// 不是null，openSession，set到threadLocal，再返回
			// 是null，init，open set
			sqlSession = factory.openSession();
			tlSqlSession.set(sqlSession);
		}

		return sqlSession;
	}

	public void close() {
		SqlSession session = tlSqlSession.get();
		if(session != null) {
			tlSqlSession.remove();
			session.close();
		}
	}

	private static void init() {
		try {
			// 读配置文件
			Reader reader = Resources.getResourceAsReader("MyMyBatis.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

			factory = builder.build(reader);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
