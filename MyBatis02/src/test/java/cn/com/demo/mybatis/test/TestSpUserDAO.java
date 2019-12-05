package cn.com.demo.mybatis.test;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class TestSpUserDAO {
    public static void main(String[] args) {
    	SpUser user = new SpUser();
    	user.setUrPassword("123");
    	user.setUrUserName("my02");
    	SqlSession session = MyBatisUtil.getInstance().getSession();
		try {
			// 动态绑定（dao的抽象方法-》sql id）
			// 注意事项：
			// 1 命名空间-》固定匹配
			// 2 sql的id-》固定匹配
			ISpUserDAO userDAO = session.getMapper(ISpUserDAO.class);
			//userDAO.save(user);
			user = userDAO.findByUserName("zhangsan");
			System.out.println(user);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		} finally {
			MyBatisUtil.getInstance().close();
		}
    }
}
