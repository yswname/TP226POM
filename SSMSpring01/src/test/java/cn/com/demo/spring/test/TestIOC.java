package cn.com.demo.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.demo.spring.dao.UserDAO;
import cn.com.demo.spring.service.ServiceFactory;
import cn.com.demo.spring.service.UserService;

public class TestIOC {

	public static void main(String[] args) {
		// 创建IOC容器，根据指定的xml进行初始化
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userSerivce = (UserService)ctx.getBean("userService");
        userSerivce.verify(null, null);
	}

	public static void test1() {
		// 创建IOC容器，根据指定的xml进行初始化
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//				// 获取对象
		UserDAO userDAO = (UserDAO) ctx.getBean("userDAO");
		// UserDAO userDAO1 = ctx.getBean(UserDAO.class);
		UserDAO userDAO2 = (UserDAO) ctx.getBean("UserDAO");
//				
//				System.out.println(userDAO+"," + userDAO1);
//				System.out.println(userDAO2 == userDAO1);
//				
		UserDAO userDAOxx = (UserDAO) ctx.getBean("userDAO2");
		System.out.println(userDAOxx.getTest());
		System.out.println(userDAO == userDAOxx);

		ServiceFactory factory = (ServiceFactory) ctx.getBean("serviceFactory");
		System.out.println(factory);
		System.out.println(ctx.getBean("userService"));

		System.out.println(ctx.getBean("testConfigData"));
		UserService userService = (UserService) ctx.getBean("userService2");
		userService.verify("x", "x");
	}

}
