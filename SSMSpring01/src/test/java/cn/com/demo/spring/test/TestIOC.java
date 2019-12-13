package cn.com.demo.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.demo.spring.dao.UserDAO;

public class TestIOC {

	public static void main(String[] args) {
		// 创建IOC容器，根据指定的xml进行初始化
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取对象
		UserDAO userDAO = (UserDAO)ctx.getBean("userDAO");
		UserDAO userDAO1 = ctx.getBean(UserDAO.class);
		
		System.out.println(userDAO+"," + userDAO1);
		
	}

}
