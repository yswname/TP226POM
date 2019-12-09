package cn.com.demo.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.com.demo.mybatis.entity.SpOrder;
import cn.com.demo.mybatis.entity.SpUser;
import cn.com.demo.mybatis.util.MyBatisUtil;

public class TestRelation {

	public static void main(String[] args) throws Exception{
		testOne2Many();
	}
	
	public static void testOne2Many()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		SpUser user = (SpUser)session.selectOne("test.rel.mapper.one2many.findById", 16);
		util.close();
		System.out.println(user);
		List<SpOrder> orderList = user.getOrders();
		if(orderList != null) {
			for(SpOrder order:orderList) {
				System.out.println("   " + order);
			}
		}
	}
	
	public static void testOne2One()throws Exception{
		MyBatisUtil util = MyBatisUtil.getInstance();
		SqlSession session = util.getSession();
		SpUser user = (SpUser)session.selectOne("test.rel.mapper.findById", 16);
		util.close();
		System.out.println(user);
		System.out.println(user.getIdCard());
	}

}
