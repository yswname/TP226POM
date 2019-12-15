package cn.com.demo.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.demo.spring.service.IUserService;
import cn.com.demo.spring.service.impl.UserServiceImpl;

public class TestAOPMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserService userService = (UserServiceImpl)ctx.getBean("userService");
		//UserServiceImpl userService = (UserServiceImpl)ctx.getBean("userService");
		System.out.println(userService);
		userService.service01();
		//userService.verify("zhangsan", "123");
	}

}
