package cn.com.demo.mybatis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.mybatis.dao.ISpUserDAO;
import cn.com.demo.mybatis.dao.ISpUserDAO2;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class TestMutilParamMain {

	public static void main(String[] args)throws Exception{
		test5();
	}
	
	public static void test5()throws Exception{
		List<Object> list = new ArrayList<Object>();
		list.add("my02");
		list.add(1);
		
		Object[] arrays = new Object[] {"my02", 1};
		
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		ISpUserDAO2 dao = session.getMapper(ISpUserDAO2.class);
		
		List<SpUser> userList = dao.find5(arrays);
		
		for(SpUser user:userList) {
			System.out.println(user);
		}
		session.close();
	}
	
	public static void test4()throws Exception{
		List<Object> list = new ArrayList<Object>();
		list.add("my02");
		list.add(1);
		
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		ISpUserDAO2 dao = session.getMapper(ISpUserDAO2.class);
		
		List<SpUser> userList = dao.find4(list);
		
		for(SpUser user:userList) {
			System.out.println(user);
		}
		session.close();
	}
	
	public static void test3()throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mapUserName", "my02");
		map.put("mapId", 1);
		
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		ISpUserDAO2 dao = session.getMapper(ISpUserDAO2.class);
		
		List<SpUser> userList = dao.find3(map);
		
		for(SpUser user:userList) {
			System.out.println(user);
		}
		session.close();
	}
	
	public static void test2()throws Exception{
		SpUser u = new SpUser();
		u.setUrId(1);
		u.setUrUserName("my02");
		
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		ISpUserDAO2 dao = session.getMapper(ISpUserDAO2.class);
		List<SpUser> userList = dao.find2(u);
		for(SpUser user:userList) {
			System.out.println(user);
		}
		session.close();
	}
	
	public static void test1()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		ISpUserDAO dao = session.getMapper(ISpUserDAO.class);
		List<SpUser> userList = dao.findByIdOrUserName(1, "my02");
		for(SpUser user:userList) {
			System.out.println(user);
		}
		session.close();
	}

}
