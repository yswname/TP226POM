package cn.com.demo.mybatis.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class TestGenerateKeyMain {

	public static void main(String[] args)throws Exception{
		testMyBatis();
	}
	
	public static void testMyBatis()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		ISpUserDAO dao = session.getMapper(ISpUserDAO.class);
		
		SpUser user = new SpUser();
		user.setUrPassword("123");
		user.setUrUserName("my06");
		
		dao.save(user);
		session.commit();
		
		System.out.println(user.getUrId());
	}
	
	public static void testJdbc()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/shop_db";
		String user = "root";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		String sql = "insert into sp_user(ur_user_name,ur_password) values(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, "my05");
		pstmt.setString(2, "123");
		
		int result = pstmt.executeUpdate();// 影响的记录数
		
		ResultSet keys = pstmt.getGeneratedKeys();
		if(keys != null && keys.next()) {
			System.out.println("id:" + keys.getInt(1));
		}
		
		System.out.println("result=" + result);
	}

}
