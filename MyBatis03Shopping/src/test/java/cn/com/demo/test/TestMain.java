package cn.com.demo.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.mybatis.util.MyBatisUtil;
import cn.com.demo.shopping.mybatis.dao.SpUserMapper;
import cn.com.demo.shopping.mybatis.entity.SpUser;

public class TestMain {

	public static void main(String[] args) {
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		SpUserMapper userMapper = session.getMapper(SpUserMapper.class);
//		SpUser user = new SpUser();
//		user.setUrPassword("666");
//		user.setUrUserName("u666");
//		
//		userMapper.insert(user);
//		session.commit();
		List<SpUser> userList = userMapper.findAllUsers();
		for(SpUser user:userList) {
			System.out.println(user);
		}
		util.close();
	}

}
