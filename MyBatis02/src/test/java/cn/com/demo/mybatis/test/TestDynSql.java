package cn.com.demo.mybatis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class TestDynSql {

	public static void main(String[] args) throws Exception{
		testTrim();
	}
	public static void testTrim()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", "my12");
		//map.put("id", 1);
		List<SpUser> userList = session.selectList("test.dyn.sql.testTrim", map);
		for(SpUser u:userList) {
			System.out.println(u);
		}
	}
	public static void testForEach2()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		Object[] idArray = new Object[] {1,2,3,4,5};
		List<SpUser> userList = session.selectList("test.dyn.sql.testForeach2", idArray);
		for(SpUser u:userList) {
			System.out.println(u);
		}
	}
	
	public static void testForEach()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(1);
		idList.add(2);
		idList.add(3);
		idList.add(4);
		idList.add(5);
		List<SpUser> userList = session.selectList("test.dyn.sql.testForeach", idList);
		for(SpUser u:userList) {
			System.out.println(u);
		}
	}
	
	public static void testIf()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		Map<String,Object> map = new HashMap<String,Object>();
		//map.put("userName", "my12");
		List<SpUser> userList = session.selectList("test.dyn.sql.testIf", map);
		for(SpUser u:userList) {
			System.out.println(u);
		}
	}
	
	public static void testIf2()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", "my12");
		List<SpUser> userList = session.selectList("test.dyn.sql.testIf2", map);
		for(SpUser u:userList) {
			System.out.println(u);
		}
	}

	public static void testSet()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		SpUser user = new SpUser();
		user.setUrId(1);
		user.setUrPassword("abc1");
		user.setUrUserName("zhangsan01");
		
		session.update("test.dyn.sql.testSet", user);
		session.commit();
	}
	
	
}
